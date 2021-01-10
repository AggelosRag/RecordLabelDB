package ClientsGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ComponentItemListener implements ItemListener ,ActionListener{
	
	private Gui dbGui;
	private static String query="";
	private static List<String> columnslist = new ArrayList<String>();

	public ComponentItemListener(Gui dbGui) {
		
		this.dbGui=dbGui;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {

		String action = e1.getActionCommand();
		if(action.equals("START")) {
			
			if(!dbGui.getQueryta().getText().equals("Insert Query")) {
				//System.out.println(dbGui.getQueryta().getText());
				this.readDatabase2(dbGui.getQueryta().getText());
				dbGui.getQueryta().setText("Insert Query");
			}
			else {
				this.chooseQuery();
				this.chooseSelect();
				this.chooseWhere();
				
				dbGui.getTaPrint().append("\n"+query+"\n\n");
				executeQuery();
				query="";
			}
		}
		
		else if(action.equals("SHOW TABLES")) {
			dbGui.getTablesGui().setVisible(true);		
		}
	}

	

	@Override
	public void itemStateChanged(ItemEvent e2) {
		// TODO Auto-generated method stub
		
		
		if(dbGui.getCollections().isSelected()) { this.setCollectionsVisibility(true);}
		else {this.setCollectionsVisibility(false);}

		
		 if(dbGui.getVersions().isSelected()) {
		this.setVersionsVisibility(true);}
		 else {this.setVersionsVisibility(false);}


		 if(dbGui.getClients().isSelected()) {this.setClientsVisibility(true);}
		 else {this.setClientsVisibility(false);}
		 
		
		if(dbGui.getPurchases().isSelected()) {this.setPurchasesVisibility(true);}
		else {this.setPurchasesVisibility(false);}

	}
	
	public void setCollectionsVisibility(boolean visible) {
		dbGui.getCollectionsInputNameTf().setVisible(visible);
		dbGui.getCollectionsInputName().setVisible(visible);
		dbGui.getCollectionsType().setVisible(visible);
		dbGui.getReleaseDate().setVisible(visible);
		dbGui.getCollectionsName().setVisible(visible);
	}
	
	public void setVersionsVisibility(boolean visible) {
		dbGui.getVersionsInputID().setVisible(visible);
		dbGui.getVersionsIdTf().setVisible(visible);
		dbGui.getVersionsID().setVisible(visible);
		dbGui.getProductionCost().setVisible(visible);
		dbGui.gettype().setVisible(visible);
	}
	
	public void setClientsVisibility(boolean visible) {
		dbGui.getClientsInputCompany().setVisible(visible);
		dbGui.getClientsCompanyTf().setVisible(visible);
		dbGui.getCompanyName().setVisible(visible);
		dbGui.getFirstName().setVisible(visible);
		dbGui.getLastName().setVisible(visible);
		dbGui.getAddress().setVisible(visible);
	}
	
	public void setPurchasesVisibility(boolean visible) {
		dbGui.getPurchasesDateTf().setVisible(visible);
		dbGui.getPurchasesInputDate().setVisible(visible);
		dbGui.getPurchasesDate().setVisible(visible);
		dbGui.getTerms().setVisible(visible);
	}
	
	
	public void chooseQuery() {
		
		boolean collectionsselected = dbGui.getCollections().isSelected();
		boolean versionssselected = dbGui.getVersions().isSelected();
		boolean purchasesselected = dbGui.getPurchases().isSelected();
		boolean clientsselected = dbGui.getClients().isSelected();

		if (collectionsselected == true && versionssselected == false && purchasesselected == false && clientsselected == false) { 
			query += " FROM (SELECT CollectionsID, Name, 'Single' as Type, ReleaseDate FROM (Collections JOIN Single ON Collections.CollectionsID = Single.SingleID JOIN  Song ON Single.SongID = Song.SongID) UNION SELECT CollectionsID, Name,  'Album' as Type, ReleaseDate FROM (Collections JOIN Album ON Collections.CollectionsID = Album.AlbumID) ) AS totals";
		}
		else if (collectionsselected == true && versionssselected == true && purchasesselected == false && clientsselected == false) {
			query += " FROM (SELECT CollectionsID, Name, 'Single' as Type, ReleaseDate FROM (Collections JOIN Single ON Collections.CollectionsID = Single.SingleID JOIN  Song ON Single.SongID = Song.SongID) UNION SELECT CollectionsID, Name,  'Album' as Type, ReleaseDate FROM (Collections JOIN Album ON Collections.CollectionsID = Album.AlbumID) ) AS totals JOIN Versions ON totals.CollectionsID = Versions.CollectionID";
		}
		else if (collectionsselected == false && versionssselected == false && purchasesselected == false && clientsselected == true) {
			query += " FROM Client";
		}
		else {
			query += " FROM (SELECT CollectionsID, Name, 'Single' as Type, ReleaseDate FROM (Collections JOIN Single ON Collections.CollectionsID = Single.SingleID JOIN  Song ON Single.SongID = Song.SongID) UNION SELECT CollectionsID, Name,  'Album' as Type, ReleaseDate FROM (Collections JOIN Album ON Collections.CollectionsID = Album.AlbumID) ) AS totals JOIN Versions ON totals.CollectionsID = Versions.CollectionID JOIN Purchases ON totals.CollectionsID = Purchases.CollectionID AND Versions.VersionID = Purchases.VersionID JOIN Client ON Purchases.ClientID = Client.ClientID";
		}	
	}
		
	public void chooseSelect() {
		
		String selectquery = "SELECT ";
		columnslist.removeAll(columnslist);
		
		// collections
		if(dbGui.getCollectionsName().isSelected()) {selectquery+="totals.Name,";columnslist.add("Name");}
		if(dbGui.getCollectionsType().isSelected()) {selectquery+="totals.Type,";columnslist.add("Type");}
		if(dbGui.getReleaseDate().isSelected()) {selectquery+="totals.ReleaseDate,";columnslist.add("Release Date");}
		
		// versions
		if(dbGui.getVersionsID().isSelected()) {selectquery+="Versions.VersionID,";columnslist.add("Version ID");}
		if(dbGui.getProductionCost().isSelected()) {selectquery+="Versions.ProductionCost,";columnslist.add("Production Cost");}
		if(dbGui.gettype().isSelected()) {selectquery+="Versions.Type,";columnslist.add("Type");}
		
		// clients
		if(dbGui.getCompanyName().isSelected()) {selectquery+="Client.Company,";columnslist.add("Company");}
		if(dbGui.getFirstName().isSelected()) {selectquery+="Client.FirstName,";columnslist.add("First Name");}
		if(dbGui.getLastName().isSelected()) {selectquery+="Client.LastName,";columnslist.add("Last Name");}
		if(dbGui.getAddress().isSelected()) {selectquery+="Client.Address,";columnslist.add("Address");}
		
		// purchases
		if(dbGui.getPurchasesDate().isSelected()) {selectquery+="Purchases.PurchaseDate,";columnslist.add("Purchase Date");}
		if(dbGui.getTerms().isSelected()) {selectquery+="Purchases.Terms,";columnslist.add("Terms");}
		
		selectquery= selectquery.substring(0, selectquery.length() - 1);
		query = selectquery + query;
	}
	
	public void chooseWhere() {
		
		query += "\nWHERE ";
		int flagcondition=0;
		if(!dbGui.getCollectionsInputNameTf().getText().equals("")) {flagcondition=1; query +=" totals.Name LIKE '"+ dbGui.getCollectionsInputNameTf().getText() + "%'  AND";}
		if(!dbGui.getVersionsIdTf().getText().equals("")) {flagcondition=1; query += " Versions.VersionID = "+ dbGui.getVersionsIdTf().getText() + " AND";}
		if(!dbGui.getClientsCompanyTf().getText().equals("")) {flagcondition=1;query += " Client.Company LIKE '"+ dbGui.getClientsCompanyTf().getText() + "%'  AND";}
		if(!dbGui.getPurchasesDateTf().getText().equals("")) {flagcondition=1;query += " Purchases.PurchaseDate = '"+ dbGui.getPurchasesDateTf().getText() + "'  AND";}
		if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
		if(flagcondition==0) {query += "1";}
	}
	
	public void executeQuery() {
		
	    try {
	    	PreparedStatement pstm = dbGui.getDb().getCon().prepareStatement(query);
	    	ResultSet Rs = pstm.executeQuery();
	    	List<String> arrlist = new ArrayList<String>();
	    	DefaultTableModel model = new DefaultTableModel(columnslist.toArray(), 0);
	    	while(Rs.next()){
	    		for (int i = 1; i <= columnslist.toArray().length; i++) {
	    			arrlist.add(Rs.getString(i));
	    		}
		    	model.addRow(arrlist.toArray());
		    	arrlist.removeAll(arrlist);
	    	}
	    	dbGui.getTable().setModel(model);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
	private void readDatabase2(String str) {
		// TODO Auto-generated method stub
		int i=0;
		String selectquery;
		while(true) {
		int iend = str.indexOf("F",i);
		System.out.println(iend);
		if(str.charAt(iend+1)=='R'&&str.charAt(iend+2)=='O' && str.charAt(iend+3)=='M') {
			selectquery=str.substring(7, iend);
			break;
		}
		else {
			i=iend+1;
		}
	}
		System.out.println("Ok");
		String[] list=selectquery.split("[ ,]+");


		try {
		Statement statement = dbGui.getDb().getCon().createStatement();
		System.out.println("Ok");
		System.out.println(str);
		ResultSet result = statement.executeQuery(str);
		DefaultTableModel model = new DefaultTableModel(list, 0);
		List<String> arrlist = new ArrayList<String>();
		
		while(result.next()) {
			int col=1;
			for (String s : list) {
				System.out.println(s);
				arrlist.add(result.getString(col));
			col++;
			}
			model.addRow(arrlist.toArray());
	    	arrlist.removeAll(arrlist);
		}
		dbGui.getTable().setModel(model);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}		
	}
	
	
} 

