package ApplicationGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import InsertDataGui.InsertGui;

public class ComponentItemListener implements ItemListener ,ActionListener{
	
	private DBGui dbGui;
	private static String query="";
	private static int flagartist=0,flagroup=0;
	private static int flagsong=0;
	private static int flagalbum=0;
	private int flag1=0,flagunion=0;
	private int flagcontract=0;


	public ComponentItemListener(DBGui dbGui) {
		// TODO Auto-generated constructor stub
		this.dbGui=dbGui;
		
	}


	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		String action = e1.getActionCommand();
		if(action.equals("START")) {
			
			
			if(!dbGui.getQueryta().getText().equals("Insert Query")) {
				//System.out.println(dbGui.getQueryta().getText());
				this.readDatabase(dbGui.getQueryta().getText());
				dbGui.getQueryta().setText("Insert Query");
			}
			else {
			this.buildQuerySelectArtist();
			this.buildQuerySelectContract();
			this.buildQuerySelectAlbum();
			this.buildQuerySelectStudio();
			this.buildQuerySelectSong();
			
			this.buildQueryJoin();
			this.buildQueryConditions();
			dbGui.getQueryprint().setText(query);

			
			this.readDatabase(query);
			
		
			query="";
			flagartist=0;
			flagsong=0;
			flagalbum=0;
			flag1=0;
			flagunion=0;
			flagcontract=0;
			flagroup=0;
		//	attributeslist=0;
		//	selectslist.clear();
			}
		}
		
		else if(action.equals("ClientsTable")) {
			dbGui.getClientstable().getGui2().setVisible(true);
		}
		
		else if (action.equals("SHOW TABLES")) {dbGui.getGui2().setVisible(true);}
		
		else if(action.equals("ClearDisplay")) {dbGui.getQueryprint().setText("");}
		
		else if(action.equals("InsertDataTable")) {dbGui.getInsertgui().setVisible(true);}
		
		else if (action.equals("DeleteDataTable")) {dbGui.getDeletegui().setVisible(true);}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e2) {
		// TODO Auto-generated method stub
		
		
		if(dbGui.getArtist().isSelected()) { this.setArtistVisibility(true);}
		else {this.setArtistVisibility(false);}

		
		 if(dbGui.getAlbum().isSelected()) {
		//	System.out.println("Album selected");
		this.setAlbumVisibility(true);}
		 else {this.setAlbumVisibility(false);}


		 if(dbGui.getContract().isSelected()) {this.setContractVisibility(true);}
		 else {this.setContractVisibility(false);}
	

		if(dbGui.getSong().isSelected()) {this.setSongsVisibility(true);}
		else {this.setSongsVisibility(false);}		
		
		if(dbGui.getStudio().isSelected()) {this.setStudioVisibility(true);}
		else {this.setStudioVisibility(false);}
}	
		

	
	
	public void setArtistVisibility(boolean visible) {
		dbGui.getArtistname().setVisible(visible);
		dbGui.getArtistnametf().setVisible(visible);
		dbGui.getSinger().setVisible(visible);
		dbGui.getMusician().setVisible(visible);
		dbGui.getComposer().setVisible(visible);
		dbGui.getWriter().setVisible(visible);
		dbGui.getGroup().setVisible(visible);
	}
	
	public void setContractVisibility(boolean visible) {
		dbGui.getActivecontract().setVisible(visible);
		dbGui.getNotactivecontract().setVisible(visible);
	}
	
	public void setAlbumVisibility(boolean visible) {
		dbGui.getAlbumtitle().setVisible(visible);
		dbGui.getAlbumtitletf().setVisible(visible);
		dbGui.getAlbumstyle().setVisible(visible);
		dbGui.getAlbumstyletf().setVisible(visible);
		dbGui.getAlbumsongs().setVisible(visible);
	}
	
	public void setSongsVisibility(boolean visible) {
		dbGui.getSongtitle().setVisible(visible);
		dbGui.getSongtitletf().setVisible(visible);
		dbGui.getSongstyle().setVisible(visible);
		dbGui.getSongstyletf().setVisible(visible);
		dbGui.getSongduration().setVisible(visible);
		dbGui.getSongalbum().setVisible(visible);
		dbGui.getSongsingle().setVisible(visible);
		dbGui.getSongfeats().setVisible(visible);
	}
	
	public void setStudioVisibility(boolean visible) {
		dbGui.getStudioname().setVisible(visible);
		dbGui.getStudiocity().setVisible(visible);
		dbGui.getStudiocost().setVisible(visible);
		dbGui.getStudionametf().setVisible(visible);
		dbGui.getStudiocitytf().setVisible(visible);
	}
	
	
	public void buildQuerySelectArtist() {
		query += "SELECT ";
		if(dbGui.getSinger().isSelected() ||dbGui.getWriter().isSelected() || dbGui.getComposer().isSelected() ) {query+="Artist.ArtisticName,Artist.Firstname,Artist.Lastname,";}
		if(dbGui.getMusician().isSelected()) {query+="Artist.ArtisticName, Musician.Instrument,";}
		if(dbGui.getGroup().isSelected()) {query += "Band.Name,";}
		//	if(dbGui.getWriter().isSelected()) {query+="Artist.ArtisticName,";selectslist.add("Artist.ArtisticName");}
	//	if(dbGui.getComposer().isSelected()) {query+="Artist.ArtisticName,";selectslist.add("Artist.ArtisticName");}
	}
	
	public void buildQuerySelectContract() {
		if(dbGui.getContract().isSelected()) {query += "Contracts.StartDate ,Contracts.ExpDate,";}
	}
	
	public void buildQuerySelectAlbum() {
		if(dbGui.getAlbumtitle().isSelected()) {query+="Album.Name,";}
		if(dbGui.getAlbumstyle().isSelected()) {query+="Album.Genre,";}
		if(dbGui.getAlbumsongs().isSelected()) {query+="Song.Name,";}
	}
	//	if(dbGui.getActivecontract().isSelected()) {query+="Contract.";} //einai where
	public void buildQuerySelectSong() {
		if(dbGui.getSongtitle().isSelected()) {query+="Song.Name,";}
		if(dbGui.getSongstyle().isSelected()) {query+="Song.Genre,";}
		if(dbGui.getSongduration().isSelected()) {query+="Song.Duration,";}
		

		query= query.substring(0, query.length() - 1);
	
		query += "\nFROM  ";	
	}
	
	public void buildQuerySelectStudio() {
		if(dbGui.getStudioname().isSelected()) {query += "Studio.Name,";}
		if(dbGui.getStudiocity().isSelected()) {query += "Studio.City,";}
	}
	
	public void buildQueryJoin() {
		
		///////////////////// ARTIST //////////////////////
		
		if(dbGui.getGroup().isSelected()) {flagartist=1;flagroup=1; query += "Band ";}
		else {
		
		if (dbGui.getArtist().isSelected() ) {
			query += "Artist ";
			flagartist=1;
		}
		
		if(dbGui.getSinger().isSelected()) {query += " JOIN Singer ON Artist.ArtistID = Singer.SingerID  ";}
		
		if(dbGui.getMusician().isSelected()) {
			query += " JOIN Musician ON Artist.ArtistID = Musician.MusicianID  ";
		}
		
		if(dbGui.getComposer().isSelected()) {query += " JOIN Composer ON Artist.ArtistID = Composer.ComposerID  ";}
		
		if(dbGui.getWriter().isSelected()) {query += " JOIN Writer ON Artist.ArtistID = Writer.WriterID  ";}
		
		}
		//////////////// CONTRACT //////////////////////////
		
		if(dbGui.getActivecontract().isSelected() || dbGui.getNotactivecontract().isSelected()) {
			flagcontract=1;
			if(flagartist==0) {query += "Contracts";}
			else {query += "JOIN Contracts ON Artist.ArtistID = Contracts.ArtistID";}
		}
		
		
		
		
		//////////////////////  ALBUM ////////////////////////////
		
		if(dbGui.getAlbum().isSelected()) {
			
			flagalbum=1;
			if(flagartist==0 && flagroup==0) {
				query += "Album ";
				if(dbGui.getAlbumsongs().isSelected()) {query += "JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";}
			
			}
			else {
				if(dbGui.getSinger().isSelected()) {
				query += " JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Album ON Creates.CollectionID=Album.AlbumID  ";
				flag1=1;
				}
				else if (flagroup==1) {query += "JOIN Creates2 ON Band.BandID = Creates2.BandID JOIN Album ON Creates2.CollectionID=Album.AlbumID ";flag1=1;} 
				else {
					query += " JOIN Participates ON Artist.ArtistID= Participates.ArtistID JOIN Song ON Participates.SongID = Song.SongID JOIN Has ON Song.SongID = Has.SongID JOIN Album ON Has.AlbumID = Album.AlbumID  ";
					
				}
				
				if(dbGui.getAlbumsongs().isSelected()) {query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";}
			}

		}
		
		/////////////////////// SONG /////////////////////////
		
		if(dbGui.getSong().isSelected()) {
			flagsong=1;
			if(flagartist==0 && flagalbum==0) {
				query+= "Song ";
				if(dbGui.getSongsingle().isSelected()) {query += "JOIN Single ON  Song.SongID =Single.SongID ";}
				if(dbGui.getSongalbum().isSelected()) {query += "JOIN Has ON Song.SongID = Has.SongID JOIN Album ON Has.AlbumID = Album.AlbumID ";}
				if(dbGui.getSongfeats().isSelected()) {query += "JOIN Participates ON Song.SongID = Participates.SongID";}
			}
			else {
				if(flagartist==1) {
					
					
				if(dbGui.getSinger().isSelected()) {                           /*////////////// SINGER //////////// */	
						if(dbGui.getSongsingle().isSelected() && flagalbum==0) {
							query += "  JOIN Creates ON Artist.ArtistID = Creates.ArtistID";
							query += "  JOIN Single ON Creates.CollectionID=Single.SingleID JOIN Song ON Single.SongID = Song.SongID";
							
							if(dbGui.getSongalbum().isSelected() || dbGui.getSongfeats().isSelected() ) {           /// UNION !!!!!!!!!
							if (dbGui.getStudio().isSelected()) {   query += " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID"; }
							this.buildQueryConditions();
							query += "\nUNION\n";
							this.buildQuerySelectArtist();
							this.buildQuerySelectContract();
							this.buildQuerySelectStudio();
							this.buildQuerySelectSong();
							query += " Artist JOIN Singer ON Artist.ArtistID = Singer.SingerID  ";
							if(flagcontract ==1 ) {query += "JOIN Contracts ON Artist.ArtistID = Contracts.ArtistID";}
							flagunion=1;
							}
						}
						
						if(dbGui.getSongalbum().isSelected()) {
							if(flagunion==1) {
								query += " JOIN Creates ON Artist.ArtistID = Creates.ArtistID";
								query += "  JOIN Album ON Creates.CollectionID=Album.AlbumID";
								query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";
							}
							else {
									if(flag1==0) {query += " JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Album ON Creates.CollectionID=Album.AlbumID  ";}
									query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";	
							}
							if(dbGui.getSongfeats().isSelected()) {           /// UNION !!!!!!!!!!
								
								if (dbGui.getStudio().isSelected()) {   query += " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID"; }
								this.buildQueryConditions();
								query += "\nUNION\n";
								this.buildQuerySelectArtist();
								this.buildQuerySelectContract();
								this.buildQuerySelectStudio();
								this.buildQuerySelectSong();
								query += " Artist JOIN Singer ON Artist.ArtistID = Singer.SingerID  ";
								if(flagcontract ==1 ) {query += "JOIN Contracts ON Artist.ArtistID = Contracts.ArtistID";}
								flagunion=1;
								}
							}
						
						
						if(dbGui.getSongfeats().isSelected()) {
							query += " JOIN Participates ON Artist.ArtistID= Participates.ArtistID JOIN Song ON Participates.SongID = Song.SongID";
							}
						}
					
					else if(dbGui.getGroup().isSelected()) {             /*////////////// GROUP //////////// */	
						
						if(dbGui.getSongsingle().isSelected() && flagalbum==0) {
							query += "  JOIN Creates2 ON Band.BandID = Creates2.BandID";
							query += "  JOIN Single ON Creates2.CollectionID=Single.SingleID JOIN Song ON Single.SongID = Song.SongID";
							
							if(dbGui.getSongalbum().isSelected()  ) {           /// UNION !!!!!!!!!
							if (dbGui.getStudio().isSelected()) {   query += " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID"; }
							this.buildQueryConditions();
							query += "\nUNION\n";
							this.buildQuerySelectArtist();
							this.buildQuerySelectContract();
							this.buildQuerySelectStudio();
							this.buildQuerySelectSong();
							query += " Band ";
					
							flagunion=1;
							}
						}
						
						if(dbGui.getSongalbum().isSelected()) {
							if(flagunion==1) {
								query += " JOIN Creates2 ON Band.BandID = Creates2.BandID";
								query += "  JOIN Album ON Creates2.CollectionID=Album.AlbumID";
								query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";
							}
							else {
									if(flag1==0) {query += " JOIN Creates2 ON Band.BandID = Creates2.BandID JOIN Album ON Creates2.CollectionID=Album.AlbumID  ";}
									query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";	
							}	
					}
						
					}
					
					else {                                       /*////////////// MUSICIAN,LYRISIST,COMPOSER //////////// */	
						
			
							query += "  JOIN Participates ON Artist.ArtistID= Participates.ArtistID JOIN Song ON Participates.SongID = Song.SongID";
							if(dbGui.getSongalbum().isSelected()) {
								query += "  JOIN Has ON Song.SongID = Has.SongID JOIN Album ON Has.AlbumID = Album.AlbumID ";
								if(dbGui.getSongsingle().isSelected()) {
									if (dbGui.getStudio().isSelected()) {   query += " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID"; }
									this.buildQueryConditions();
									query += "\nUNION\n";
									this.buildQuerySelectArtist();
									this.buildQuerySelectContract();
									this.buildQuerySelectStudio();
									this.buildQuerySelectSong();
									query += " Artist  ";
									if(flagcontract ==1 ) {query += "JOIN Contracts ON Artist.ArtistID = Contracts.ArtistID";}
									flagunion=1;}
						      }
							if(dbGui.getSongsingle().isSelected()) {
								if(flagunion==1) {
									if(dbGui.getMusician().isSelected()) {query += " JOIN Musician ON Artist.ArtistID = Musician.MusicianID  ";}
									if(dbGui.getComposer().isSelected()) {query += " JOIN Composer ON Artist.ArtistID = Composer.ComposerID  ";}
									if(dbGui.getWriter().isSelected()) {query += " JOIN Writer ON Artist.ArtistID = Writer.WriterID  ";}
									
									query += " JOIN Participates ON Artist.ArtistID= Participates.ArtistID JOIN Song ON Participates.SongID = Song.SongID";}
									query += "  JOIN Single ON Song.SongID = Single.SongID";
							}
			
						
					}
				}
				}
		}
		
		
		///////////////////////// STUDIO  ///////////////////////////
		
		if(dbGui.getStudio().isSelected()) {
		if(flagartist==0&&flagalbum==0&&flagsong==0) {query += "Studio";}
		else {
			if (flagsong==1 || (flagalbum==1 && dbGui.getAlbumsongs().isSelected())) {query += " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID";}
			else if(flagalbum==1 && !dbGui.getAlbumsongs().isSelected()) {query += " JOIN Has ON Album.AlbumID = Has.AlbumID  JOIN Song ON Has.SongID = Song.SongID";
			query+= " JOIN Recorded ON Song.SongID= Recorded.SongID  JOIN Studio ON Recorded.StudioID = Studio.StudioID";
			}
		
	}
	}
	}
	
	public void buildQueryConditions() {
		query += "\nWHERE ";
		int flagcondition=0;
		if(!dbGui.getArtistnametf().getText().equals("")&& flagroup==0) {flagcondition=1;query +="Artist.ArtisticName LIKE '"+ dbGui.getArtistnametf().getText() + "%'  AND";}
		if(!dbGui.getArtistnametf().getText().equals("")&& flagroup==1) {flagcondition=1;query +="Band.Name LIKE '"+ dbGui.getArtistnametf().getText() + "%'  AND";}
		if(!dbGui.getAlbumtitletf().getText().equals("")) {flagcondition=1; query += " Album.Name LIKE '"+ dbGui.getAlbumtitletf().getText() + "%'  AND";}
		if(!dbGui.getAlbumstyletf().getText().equals("")) {flagcondition=1;query += " Album.Genre LIKE '"+ dbGui.getAlbumstyletf().getText() + "%'  AND";}
		if(!dbGui.getSongtitletf().getText().equals("")) {flagcondition=1;query += " Song.Name LIKE '"+ dbGui.getSongtitletf().getText() + "%'  AND";}
		if(!dbGui.getSongstyletf().getText().equals("")) {flagcondition=1;query += " Song.Genre LIKE '"+ dbGui.getSongstyletf().getText() + "%'  AND";}
		if(!dbGui.getStudionametf().getText().equals("")) {flagcondition=1;query += " Studio.Name LIKE '"+dbGui.getStudionametf().getText() + "%'  AND";}
		if(!dbGui.getStudiocitytf().getText().equals("")) {flagcondition=1;query += " Studio.City LIKE '"+dbGui.getStudiocitytf().getText() + "%'  AND";}
		if(!(dbGui.getActivecontract().isSelected() && dbGui.getNotactivecontract().isSelected())){
		if(dbGui.getActivecontract().isSelected()) {flagcondition=1;query += " DATEDIFF(CURDATE(),ExpDate)<=0 AND";}
		if(dbGui.getNotactivecontract().isSelected()) {flagcondition=1;query += " DATEDIFF(CURDATE(),ExpDate)>=0 AND";}
		}
		if(flagcondition==1) {query= query.substring(0, query.length() - 3);}
		if(flagcondition==0) {query += "1";}
	}
	
	
	
	
	public void readDatabase(String str) {
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

		String[] list=selectquery.split("[ ,]+");


		try {
		Statement statement = dbGui.getDb().getCon().createStatement();
		ResultSet result = statement.executeQuery(str);
		DefaultTableModel model = new DefaultTableModel(list, 0);
		List<String> arrlist = new ArrayList<String>();
		
		while(result.next()) {
			int col=1;
		
			for (String s : list) {
				arrlist.add(result.getString(col));
				col++;
			}
			model.addRow(arrlist.toArray());
	    	arrlist.removeAll(arrlist);
		}
		dbGui.getTa().setModel(model);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
	


}
