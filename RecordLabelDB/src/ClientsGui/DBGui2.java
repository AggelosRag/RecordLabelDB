package ClientsGui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ApplicationGui.DatabaseConnect;


public class DBGui2 extends JFrame{
	
	private TextArea ta;
	private DatabaseConnect db;
	private DBGuiLabel artistname; 
	private DBGuiTextField artistnametf,albumtitletf,albumstyletf,songtitletf,songstyletf;
	private JTable collections, versions, clients, purchases;
	
	public DBGui2(DatabaseConnect db) {
		super("Records Label Tables");
		this.db = db;
		this.setLayout(null);
	    this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	    this.getContentPane().setBackground(Color.CYAN);;
	    this.setSize(615,640);
	    this.setLocation(50,80);
	    this.setVisible(false);
	    this.setResizable(false);
	    
	    // JTables
 
		String[] collectionColumns = {"Collection ID", "Name", "Type", "Release Date"};
		String query = "SELECT * FROM (SELECT CollectionsID, Name, 'Single' as Type, ReleaseDate FROM (Collections JOIN Single ON Collections.CollectionsID = Single.SingleID JOIN  Song ON Single.SongID = Song.SongID) UNION SELECT CollectionsID, Name,  'Album' as Type, ReleaseDate FROM (Collections JOIN Album ON Collections.CollectionsID = Album.AlbumID) ) AS totals ORDER BY CollectionsID";
		DefaultTableModel model = setQuery(db.getCon(), collectionColumns, query);
		collections = new JTable(model); 
	    JScrollPane sp1 = new JScrollPane(collections); 
	    sp1.setBounds(20, 50, 550, 100); 
	    this.add(sp1);
	    
	    String[] versionColumns = {"Collection ID", "Version ID", "Production Cost", "Type"};
		String query2 = "SELECT Versions.CollectionID, VersionID, ProductionCost, Type FROM Versions JOIN Collections ON Collections.CollectionsID = Versions.CollectionID";
		DefaultTableModel model2 = setQuery(db.getCon(), versionColumns, query2);
		versions = new JTable(model2); 
	    JScrollPane sp2 = new JScrollPane(versions); 
	    sp2.setBounds(20, 190, 550, 100); 
	    this.add(sp2);
	    
	    String[] clientColumns = {"First name", "Last name", "Company", "City", "Address"};
	    String query3 = "SELECT Firstname, Lastname, Company, City, Address FROM Client ";
		DefaultTableModel model3 = setQuery(db.getCon(), clientColumns, query3);
		clients = new JTable(model3); 
	    JScrollPane sp3 = new JScrollPane(clients); 
	    sp3.setBounds(20, 330, 550, 100); 
	    this.add(sp3);
	    
	    String[] purchasesColumns = {"Company", "Collection ID", "Version ID", "Purchase Date", "Terms"};
	    String query4 = "SELECT Company, Purchases.CollectionID, Purchases.VersionID, PurchaseDate, Terms FROM Purchases JOIN Client ON Client.ClientID = Purchases.ClientID";
		DefaultTableModel model4 = setQuery(db.getCon(), purchasesColumns, query4);
		purchases = new JTable(model4); 
	    JScrollPane sp4 = new JScrollPane(purchases); 
	    sp4.setBounds(20, 470, 550, 100); 
	    this.add(sp4);  

	    // Labels 
	    DBGuiLabel collections_label =  new DBGuiLabel(this,"Collections",250,10,100,50);
	    DBGuiLabel versions_label = new DBGuiLabel(this,"Versions",250, 150,100,50);	    
	    DBGuiLabel clients_label = new DBGuiLabel(this,"Clients",255, 290, 100,50);	
	    DBGuiLabel purchases_label = new DBGuiLabel(this,"Purchases",250, 430, 100,50);	    	    	    
	}
	 
    public DefaultTableModel setQuery (Connection con, String[] columns, String query) {
    	
    	DefaultTableModel model = new DefaultTableModel(columns, 0);
	    try {
	    	PreparedStatement pstm = con.prepareStatement(query);
	    	ResultSet Rs = pstm.executeQuery();
	    	List<String> arrlist = new ArrayList<String>();
	    	while(Rs.next()){
	    		for (int i = 1; i <= columns.length; i++) {
	    			arrlist.add(Rs.getString(i));
	    		}
		    	model.addRow(arrlist.toArray());
		    	arrlist.removeAll(arrlist);
	    	}
	    	return model;
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	return null;
	    }
    }
}
