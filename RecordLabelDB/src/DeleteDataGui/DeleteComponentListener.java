package DeleteDataGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteComponentListener implements ItemListener ,ActionListener{
	
	private DeleteGui dbGui;
	private static String query="";
	private List<Integer> pk = new ArrayList<Integer>();

	
	public DeleteComponentListener(DeleteGui dbGui) {
		this.dbGui=dbGui;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("DELETE")) {
			try {
				this.createQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			query = "";
			pk.clear();
		}
	
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(dbGui.getArtist().isSelected()) {this.setArtistVisibility(true);}
		else {this.setArtistVisibility(false);}
		
		if(dbGui.getAlbum().isSelected()) {this.setAlbumVisibility(true);}
		else {this.setAlbumVisibility(false);}
		
		if(dbGui.getSong().isSelected()) {this.setSongVisibility(true);}
		else {this.setSongVisibility(false);}
		
		if(dbGui.getStudio().isSelected()){this.setStudioVisibility(true);}
		else {this.setStudioVisibility(false);}
		
		if(dbGui.getGroup().isSelected()) {this.setGroupVisibility(true);}
		else {this.setGroupVisibility(false);}
		
	}
	
	public void setArtistVisibility(boolean visible) {

		dbGui.getFirstname().setVisible(visible);
		dbGui.getFirstnametf().setVisible(visible);
		dbGui.getLastname().setVisible(visible);
		dbGui.getLastnametf().setVisible(visible);
		dbGui.getArtisticname().setVisible(visible);
		dbGui.getArtisticnametf().setVisible(visible);
		dbGui.getGender().setVisible(visible);
		dbGui.getArtistgendertf().setVisible(visible);
		dbGui.getGenre().setVisible(visible);
		dbGui.getArtistgenretf().setVisible(visible);

	}
	
	public void setAlbumVisibility(boolean visible) {
		dbGui.getAlbumtitle().setVisible(visible);
		dbGui.getAlbumtitletf().setVisible(visible);
		dbGui.getAlbumstyle().setVisible(visible);
		dbGui.getAlbumstyletf().setVisible(visible);
		dbGui.getArtistalbum().setVisible(visible);
		dbGui.getArtistalbumtf().setVisible(visible);
	}
	
	public void setSongVisibility(boolean visible) {
		dbGui.getSongduration().setVisible(visible);
		dbGui.getSongdurationtf().setVisible(visible);
		dbGui.getSongstyle().setVisible(visible);
		dbGui.getSongstyletf().setVisible(visible);
		dbGui.getSongtitle().setVisible(visible);
		dbGui.getSongtitletf().setVisible(visible);
	}
	
	public void setStudioVisibility(boolean visible) {
		dbGui.getStudioaddress().setVisible(visible);
		dbGui.getStudioaddresstf().setVisible(visible);
		dbGui.getStudiocity().setVisible(visible);
		dbGui.getStudiocitytf().setVisible(visible);
		dbGui.getStudiocost().setVisible(visible);
		dbGui.getStudiocosttf().setVisible(visible);
		dbGui.getStudioname().setVisible(visible);
		dbGui.getStudionametf().setVisible(visible);
	}
	
	public void setGroupVisibility(boolean visible) {
		dbGui.getGroupgenre().setVisible(visible);
		dbGui.getGroupgenretf().setVisible(visible);
		dbGui.getGroupname().setVisible(visible);
		dbGui.getGroupnametf().setVisible(visible);
	}
	
	
	public void createQuery() throws SQLException {
		if(dbGui.getArtist().isSelected()) {
			query += "DELETE FROM Artist WHERE";
			int flagcondition=0;
			int i=1;
			if(!dbGui.getFirstnametf().getText().equals("")) {flagcondition=1;query += " Firstname = ? AND";}                                    
			if(!dbGui.getLastnametf().getText().equals("")) {flagcondition=1;query += " Lastname = ? AND";}
			if(!dbGui.getArtisticnametf().getText().equals("")) {flagcondition=1;query += " ArtisticName = ? AND";}
			if(!dbGui.getArtistgendertf().getText().equals("")) {flagcondition=1;query += " Gender = ? AND";}
			if(!dbGui.getArtistgenretf().getText().equals("")) {flagcondition=1;query += " Genre = ? AND";}
			if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
			if(flagcondition==0) {query += "1";}
			
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			if(!dbGui.getFirstnametf().getText().equals("")) {statement.setString(i, dbGui.getFirstnametf().getText());i++;}
			if(!dbGui.getLastnametf().getText().equals("")) {statement.setString(i, dbGui.getLastnametf().getText());i++;}
			if(!dbGui.getArtisticnametf().getText().equals("")) {statement.setString(i, dbGui.getArtisticnametf().getText());i++;}
			if(!dbGui.getArtistgendertf().getText().equals("")) {statement.setString(i, dbGui.getArtistgendertf().getText());i++;}
			if(!dbGui.getArtistgenretf().getText().equals("")) {statement.setString(i, dbGui.getArtistgenretf().getText());i++;}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Deleted");}
		}
		
		else if(dbGui.getAlbum().isSelected()) {
			try {
				this.getAlbumID();
				query="";
				String list="";
				for(int s : pk) {
					list+= "CollectionsID =" +s +" OR ";
				}
				if(list.length()==0) {dbGui.getTa().setText("Album doesnt exist");}
				else {
				list= list.substring(0, list.length() - 3);
				list = list.replace("[", "").replace("]", "");
				query = "DELETE FROM Collections WHERE "+ list;
				PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
				dbGui.getTa().setText(statement.toString());
				int rows= statement.executeUpdate();
				if(rows>0) {System.out.println("Deleted");}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(dbGui.getSong().isSelected()) {
			query += "DELETE FROM Song WHERE";
			int flagcondition=0;
			int i=1;
			if(!dbGui.getSongtitletf().getText().equals("")) {flagcondition=1; query += " Name = ? AND"; }
			if(!dbGui.getSongstyletf().getText().equals("")) {flagcondition=1; query += " Genre = ? AND";}
			if(!dbGui.getSongdurationtf().getText().equals("")) {flagcondition=1; query += " Duration = ? AND";}
			if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
			if(flagcondition==0) {query += "1";}
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			if(!dbGui.getSongtitletf().getText().equals("")) {statement.setString(i, dbGui.getSongtitletf().getText());i++;}
			if(!dbGui.getSongstyletf().getText().equals("")) {statement.setString(i, dbGui.getSongstyletf().getText());i++;}
			if(!dbGui.getSongdurationtf().getText().equals("")) {statement.setString(i, dbGui.getSongdurationtf().getText());i++;}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Deleted");}
		}
		
		else if (dbGui.getStudio().isSelected()) {
			query += "DELETE FROM Studio WHERE";
			int flagcondition=0;
			int i=1;
			if(!dbGui.getStudioaddresstf().getText().equals("")) {flagcondition=1; query += " Address = ? AND"; }
			if(!dbGui.getStudiocitytf().getText().equals("")) {flagcondition=1; query += " City = ? AND";}
			if(!dbGui.getStudionametf().getText().equals("")) {flagcondition=1; query += " Name = ? AND";}
			if(!dbGui.getStudiocosttf().getText().equals("")) {flagcondition=1; query += " Cost = ? AND"; }
			if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
			if(flagcondition==0) {query += "1";}
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			if(!dbGui.getStudioaddresstf().getText().equals("")) {statement.setString(i, dbGui.getStudioaddresstf().getText());i++;}
			if(!dbGui.getStudiocitytf().getText().equals("")) {statement.setString(i, dbGui.getStudiocitytf().getText());i++;}
			if(!dbGui.getStudionametf().getText().equals("")) {statement.setString(i, dbGui.getStudionametf().getText());i++;}
			if(!dbGui.getStudiocosttf().getText().equals("")) {statement.setString(i, dbGui.getStudiocosttf().getText());i++;}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Deleted");}
		}
		
		else if (dbGui.getGroup().isSelected()) {
			query += "DELETE FROM Band WHERE";
			int flagcondition=0;
			int i=1;
			if(!dbGui.getGroupnametf().getText().equals("")) {flagcondition=1; query += " Name = ? AND"; }
			if(!dbGui.getGroupgenretf().getText().equals("")) {flagcondition=1; query += " Genre = ? AND";}
		
			if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
			if(flagcondition==0) {query += "1";}
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			if(!dbGui.getGroupnametf().getText().equals("")) {statement.setString(i, dbGui.getGroupnametf().getText());i++;}
			if(!dbGui.getGroupgenretf().getText().equals("")) {statement.setString(i, dbGui.getGroupgenretf().getText());i++;}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Deleted");}
		}
		
	}
	
	
	public void getAlbumID() throws SQLException {
		// Single Artist
		query += "SELECT Album.AlbumID FROM Album WHERE";
		int flagcondition=0;
		if(!dbGui.getAlbumtitletf().getText().equals("")) {flagcondition=1;query += " Name = '"+ dbGui.getAlbumtitletf().getText()+ "' AND";}
		if(!dbGui.getAlbumstyletf().getText().equals("")) {flagcondition=1;query += " Genre = '"+ dbGui.getAlbumstyletf().getText()+ "' AND";}
		if(!dbGui.getArtistalbumtf().getText().equals("Insert Artist/Band")) {flagcondition=1;query += " Album.AlbumID IN (SELECT Album.AlbumID FROM Album JOIN Collections ON Album.AlbumID=Collections.CollectionsID";
		query += " JOIN Creates ON Collections.CollectionsID = Creates.CollectionID JOIN Artist ON Creates.ArtistID = Artist.ArtistID WHERE Artist.ArtisticName = '"+dbGui.getArtistalbumtf().getText()+"') AND";}                    
		if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
		if(flagcondition==0) {query += "1";}
		// Band
		query += "\nUNION\n";
		query += "SELECT Album.AlbumID FROM Album WHERE";
		flagcondition=0;
		if(!dbGui.getAlbumtitletf().getText().equals("")) {flagcondition=1;query += " Name = '"+ dbGui.getAlbumtitletf().getText()+ "' AND";}
		if(!dbGui.getAlbumstyletf().getText().equals("")) {flagcondition=1;query += " Genre = '"+ dbGui.getAlbumstyletf().getText()+ "' AND";}
		if(!dbGui.getArtistalbumtf().getText().equals("Insert Artist/Band")) {flagcondition=1;query += " Album.AlbumID IN (SELECT Album.AlbumID FROM Album JOIN Collections ON Album.AlbumID=Collections.CollectionsID";
		query += " JOIN Creates2 ON Collections.CollectionsID = Creates2.CollectionID JOIN Band ON Creates2.BandID = Band.BandID WHERE Band.Name = '"+dbGui.getArtistalbumtf().getText()+"') AND";}                    
		if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
		if(flagcondition==0) {query += "1";}
		
		System.out.println(query);
		Statement statement = dbGui.getDb().getCon().createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			int col=1;
			pk.add(result.getInt(col));
		}
		for(int s : pk) {
			System.out.println(s);
		}
	
	}
}