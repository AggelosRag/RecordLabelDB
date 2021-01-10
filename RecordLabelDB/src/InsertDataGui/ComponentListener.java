package InsertDataGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import ApplicationGui.DBGui;

public class ComponentListener implements ItemListener ,ActionListener{
	
	private InsertGui dbGui;
	private static String query="";
	private static int flagband=0;
	
	public ComponentListener(InsertGui dbGui) {
		this.dbGui=dbGui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("INSERT")) {
			try {
				this.createQuery();
				query="";
				flagband=0;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		dbGui.getSinger().setVisible(visible);
		dbGui.getWriter().setVisible(visible);
		dbGui.getComposer().setVisible(visible);
		dbGui.getMusician().setVisible(visible);
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
		dbGui.getGroupartist().setVisible(visible);
		dbGui.getGroupartisttf().setVisible(visible);
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
		dbGui.getSongalbum().setVisible(visible);
		dbGui.getSongalbumtf().setVisible(visible);
		dbGui.getSongduration().setVisible(visible);
		dbGui.getSongdurationtf().setVisible(visible);
		dbGui.getSongsingle().setVisible(visible);
		dbGui.getSongsingletf().setVisible(visible);
		dbGui.getSongstyle().setVisible(visible);
		dbGui.getSongstyletf().setVisible(visible);
		dbGui.getSongtitle().setVisible(visible);
		dbGui.getSongtitletf().setVisible(visible);
		dbGui.getSongoriginal().setVisible(visible);
		dbGui.getSongremix().setVisible(visible);
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
		query +="INSERT INTO ";
		
		
		////////////////// INSERT ARTIST ///////////////////////////////
		
		if(dbGui.getArtist().isSelected()) {
			int pk =this.getPk("Artist");
			//System.out.println(pk);
			query += " Artist (ArtistID,Firstname,Lastname,ArtisticName,Gender,Genre";
			if(dbGui.getGroupartist().isSelected()) {query += ",BandID)";}
			else {query += ")";}
			
			query += " VALUES (?,?,?,?,?,?";
			if(dbGui.getGroupartist().isSelected()) {query +=",?);";}
			else {query +=");";}
			
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, pk+1);
			statement.setString(2,dbGui.getFirstnametf().getText() );
			statement.setString(3,dbGui.getLastnametf().getText());
			statement.setString(4,dbGui.getArtisticnametf().getText());
			statement.setString(5, dbGui.getArtistgendertf().getText());
			statement.setString(6,dbGui.getArtistgenretf().getText());
			if(dbGui.getGroupartist().isSelected()) {statement.setInt(7,this.getArtistBandID(dbGui.getGroupartisttf().getText()));}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Saved");}
			
			String sql2 = null;
			if(dbGui.getSinger().isSelected()) {sql2="Singer";}
			else if(dbGui.getMusician().isSelected()) {sql2="Musician";}
			else if(dbGui.getComposer().isSelected()) {sql2="Composer";}
			else if(dbGui.getWriter().isSelected()) {sql2="Lyricist";}
			
			if(sql2 != null) {
			query ="INSERT INTO " + sql2 + " (" + sql2+"ID) VALUES (?);";
			statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, pk+1);
			dbGui.getTa().append("\n" +statement.toString());
			rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Artist Saved");}
			}
		}
		
		////////////////////////// INSERT ALBUM /////////////////////////
		
		else if(dbGui.getAlbum().isSelected()) {
			int pk = this.getPk("Collections");
			query +=" Collections (CollectionsID) VALUES (?)";
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, pk+1);
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Collections Saved");}
			
			query= "INSERT INTO Album (AlbumID,Name,Genre) VALUES (?,?,?);";
			
			statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, pk+1);
			statement.setString(2,dbGui.getAlbumtitletf().getText());
			statement.setString(3, dbGui.getAlbumstyletf().getText());
			dbGui.getTa().append("\n" +statement.toString());
			rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Album Saved");}
			
			if(!dbGui.getArtistalbumtf().getText().equals("Insert Artist/Band")) {
				int artistpk=this.getArtistBandID(dbGui.getArtistalbumtf().getText());
				if(flagband==0) {query ="INSERT INTO Creates(ArtistID,CollectionID)  VALUES (?,?)";}
				else if(flagband==1) {query ="INSERT INTO Creates2(BandID,CollectionID)  VALUES (?,?)";}
				statement= dbGui.getDb().getCon().prepareStatement(query);
				statement.setInt(1, artistpk);
				statement.setInt(2, pk+1);
				dbGui.getTa().append("\n" +statement.toString());
				rows= statement.executeUpdate();
				if(rows>0) {System.out.println("Creates Saved");}
			}
		}
		
		/////////////////////////  INSERT SONG ///////////////////////////////
		
		else if (dbGui.getSong().isSelected()) {
			int pk = this.getPk("Song");
			query += "Song (SongID,Name,Duration,Genre,Type)  VALUES (?,?,?,?,?)";
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, pk+1);
			statement.setString(2, dbGui.getSongtitletf().getText());
			statement.setBigDecimal(3, new BigDecimal(dbGui.getSongdurationtf().getText()));
			statement.setString(4, dbGui.getSongstyletf().getText());
			if(dbGui.getSongoriginal().isSelected()) {statement.setString(5, "Original");}
			else if(dbGui.getSongremix().isSelected()) {statement.setString(5, "Remix");}
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Song Saved");}
			
			
			
			if(dbGui.getSongsingle().isSelected()) {
				
				int collectionpk = this.getPk("Collections");
				query = "INSERT INTO Collections (CollectionsID) VALUES (?)";
				statement = dbGui.getDb().getCon().prepareStatement(query);
				statement.setInt(1, collectionpk+1);
				dbGui.getTa().append("\n" +statement.toString());
				rows= statement.executeUpdate();
				if(rows>0) {System.out.println("Collections Saved");}
				
				
				query ="INSERT INTO Single (SingleID,SongID) VALUES (?,?)";
				statement = dbGui.getDb().getCon().prepareStatement(query);
				statement.setInt(1, collectionpk+1);
				statement.setInt(2, pk+1);
				dbGui.getTa().append("\n" +statement.toString());
				rows= statement.executeUpdate();
				if(rows>0) {System.out.println("Single Saved");}
				
				int artistpk= this.getArtistBandID(dbGui.getSongsingletf().getText());
				if(flagband==0) {query ="INSERT INTO Creates(ArtistID,CollectionID)  VALUES (?,?)";}
				else if(flagband==1) {query ="INSERT INTO Creates2(BandID,CollectionID)  VALUES (?,?)";}
				statement = dbGui.getDb().getCon().prepareStatement(query);
				statement.setInt(1, artistpk);
				statement.setInt(2,collectionpk+1);
				dbGui.getTa().append("\n" +statement.toString());
				rows= statement.executeUpdate();
				if(rows>0) {System.out.println("Creates Saved");}
			}
			
			if(dbGui.getSongalbum().isSelected()) {
				int albumpk = this.getAlbumID(dbGui.getSongalbumtf().getText());
				int trackno = this.getTrackNumberInAlbum(albumpk);
				// EDW THA MPEI TRACK NO
				System.out.println(albumpk);
				query ="INSERT INTO Has (AlbumID,SongID,TrackNo) VALUES (?,?,?) ";
				PreparedStatement statement1 = dbGui.getDb().getCon().prepareStatement(query);
				statement1.setInt(1, albumpk);
				statement1.setInt(2,pk+1);
				statement1.setInt(3,trackno +1 );
				dbGui.getTa().append("\n" +statement1.toString());
				rows= statement1.executeUpdate();
				if(rows>0) {System.out.println("Album Saved");}
			}
		}
		
		///////////////////////////////// INSERT STUDIO ///////////////////////////////////
		
		else if(dbGui.getStudio().isSelected()) {
			int studiopk = this.getPk("Studio");
			query += "Studio (StudioID,Name,Address,City,Cost) VALUES (?,?,?,?,?);";
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, studiopk+1);
			statement.setString(2, dbGui.getStudionametf().getText());
			statement.setString(3,dbGui.getStudioaddresstf().getText());
			statement.setString(4, dbGui.getStudiocitytf().getText());
			statement.setBigDecimal(5, new BigDecimal(dbGui.getStudiocosttf().getText()));
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Studio Saved");}
		}
		
		//////////////////////// INSERT BAND //////////////////////////////
		
		else if(dbGui.getGroup().isSelected()) {
			int bandpk = this.getPk("Band");
			query += " Band (BandID ,Name ,Genre) VALUES (?,?,?);";
			PreparedStatement statement = dbGui.getDb().getCon().prepareStatement(query);
			statement.setInt(1, bandpk+1);
			statement.setString(2, dbGui.getGroupnametf().getText());
			statement.setString(3,dbGui.getGroupgenretf().getText());
			dbGui.getTa().setText(statement.toString());
			int rows= statement.executeUpdate();
			if(rows>0) {System.out.println("Band Saved");}
			
		}
	}
	
	
	public int getPk(String table) {
		String sql = "SELECT " + table+"."+table+"ID \n"
				+ "FROM "+table+"\n"
				+ "ORDER BY "+table+"."+table+"ID DESC\n"
				+ "LIMIT 1";
		System.out.println(sql);
		try {
			int pk=0;
			Statement statement = dbGui.getDb().getCon().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
			pk = result.getInt(1);
			System.out.println(pk);
			}
			
			
			return pk;
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
		return 0;
}
	
	public int getArtistBandID(String artist) throws SQLException {
		String sql ="SELECT Artist.ArtistID  FROM Artist WHERE ArtisticName = '"+artist+"'";
		Statement statement = dbGui.getDb().getCon().createStatement();
		ResultSet result = statement.executeQuery(sql);
		int pk=0;
		while(result.next()) {
			pk =result.getInt(1);
		}
		
		if(pk==0) {
			sql ="SELECT Band.BandID  FROM Band WHERE Name = '"+artist+"'";
			statement = dbGui.getDb().getCon().createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				pk =result.getInt(1);
			}
			if(pk!=0) {flagband=1;}
		}
		return pk;
	}
	
	public int getAlbumID(String album) throws SQLException {
		String sql ="SELECT Album.AlbumID FROM Album WHERE Name= '"+album +"'";
		Statement statement = dbGui.getDb().getCon().createStatement();
		ResultSet result = statement.executeQuery(sql);
		int pk=0;
		while(result.next()) {
			pk =result.getInt(1);
		}
		return pk;
	}
	
	public int getTrackNumberInAlbum(int albumkey) throws SQLException {
		String sql = "SELECT TrackNo FROM Album JOIN Has ON Album.AlbumID=Has.AlbumID WHERE Album.AlbumID = '" + albumkey + "'";
		sql += "\nORDER BY TrackNo DESC\nLIMIT 1;";
		System.out.println(sql);
		Statement statement = dbGui.getDb().getCon().createStatement();
		ResultSet result = statement.executeQuery(sql);
		int pk =0;
		while(result.next()) {
			pk= result.getInt(1);		
	}
		return pk;
}
}
