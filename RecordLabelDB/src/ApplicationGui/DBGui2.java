package ApplicationGui;

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


public class DBGui2 extends JFrame{
	
	private TextArea ta;
	private DBGuiLabel artistname; 
	private DBGuiTextField artistnametf,albumtitletf,albumstyletf,songtitletf,songstyletf;
	private JTable singers, lyricists, composers, musicians, songs, albums, singles, contracts, studios, bands;
	private Connection con;
	
	public DBGui2(DatabaseConnect db) {
		super("Records Label Tables");
		this.con=db.getCon();
		this.setLayout(null);
	    this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	    this.getContentPane().setBackground(Color.ORANGE);;
	    this.setSize(1210,760);
	    this.setLocation(50,80);
	    this.setVisible(false);
	    this.setResizable(false);
	   // this.addWindowListener(new CloseWindowAndExit());
	    

	    
	    // JTables
 
		String[] singerColumns = {"First name", "Last name", "Artistic name", "Genre"};
		String query = "SELECT Firstname, Lastname, ArtisticName, Genre FROM (Singer JOIN Artist ON Singer.SingerID = Artist.ArtistID)";
		DefaultTableModel model = setQuery(con, singerColumns, query);
	    singers = new JTable(model); 
	    JScrollPane sp1 = new JScrollPane(singers); 
	    sp1.setBounds(20, 50, 550, 100); 
	    this.add(sp1);
	    
	    String[] lyrisictColumns = {"First name", "Last name", "Artistic name", "Genre"};
		String query2 = "SELECT Firstname, Lastname, ArtisticName, Genre FROM (Lyricist JOIN Artist ON Lyricist.LyricistID = Artist.ArtistID)";
		DefaultTableModel model2 = setQuery(con, lyrisictColumns, query2);
		lyricists = new JTable(model2); 
	    JScrollPane sp2 = new JScrollPane(lyricists); 
	    sp2.setBounds(20, 190, 550, 100); 
	    this.add(sp2);
	    
	    String[] composerColumns = {"First name", "Last name", "Artistic name", "Genre"};
	    String query3 = "SELECT Firstname, Lastname, ArtisticName, Genre FROM (Composer JOIN Artist ON Composer.ComposerID = Artist.ArtistID)";
		DefaultTableModel model3 = setQuery(con, composerColumns, query3);
		composers = new JTable(model3); 
	    JScrollPane sp3 = new JScrollPane(composers); 
	    sp3.setBounds(20, 330, 550, 100); 
	    this.add(sp3);
	    
	    String[] musicianColumns = {"First name", "Last name", "Artistic name", "Genre", "Instrument"};
	    String query4 = "SELECT Firstname, Lastname, ArtisticName, Genre, Instrument FROM (Musician JOIN Artist ON Musician.MusicianID = Artist.ArtistID)";
		DefaultTableModel model4 = setQuery(con, musicianColumns, query4);
		musicians = new JTable(model4); 
	    JScrollPane sp4 = new JScrollPane(musicians); 
	    sp4.setBounds(20, 470, 550, 100); 
	    this.add(sp4);
	        
	    String[] songColumns = {"Name", "Artists", "Duration", "Genre"};
	    String query5 = "SELECT * FROM (SELECT Song.Name, Artist.ArtisticName as ArtistName, Duration, Song.Genre FROM (Artist JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Album ON Creates.CollectionID = Album.AlbumID JOIN Has ON Has.AlbumID = Album.AlbumID JOIN Song ON Song.SongID = Has.SongID) UNION SELECT Song.Name, Artist.ArtisticName as ArtistName, Duration, Song.Genre FROM (Artist JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Single ON Creates.CollectionID = Single.SingleID JOIN Song ON Song.SongID = Single.SongID) UNION SELECT Song.Name, Band.Name as ArtistName, Duration, Song.Genre FROM (Band JOIN Creates2 ON Band.BandID = Creates2.BandID JOIN Album ON Creates2.CollectionID = Album.AlbumID JOIN Has ON Has.AlbumID = Album.AlbumID JOIN Song ON Song.SongID = Has.SongID) UNION SELECT Song.Name, Band.Name as ArtistName, Duration, Song.Genre FROM (Band JOIN Creates2 ON Band.BandID = Creates2.bandID JOIN Single ON Creates2.CollectionID = Single.SingleID JOIN Song ON Song.SongID = Single.SongID) UNION SELECT Song.Name, Artist.ArtisticName as ArtistName, Duration, Song.Genre FROM (Artist JOIN Participates ON Artist.ArtistID = Participates.ArtistID JOIN Song ON Song.SongID = Participates.SongID)) as totals ORDER BY totals.Name";
		DefaultTableModel model5 = setQueryForSongs(con, songColumns, query5);
		//DefaultTableModel model5 = setQuery(con, songColumns, query5);
		songs = new JTable(model5);
	    JScrollPane sp5 = new JScrollPane(songs); 
	    sp5.setBounds(640, 50, 550, 100); 
	    this.add(sp5);
	    
	    String[] albumColumns = {"Name", "Artist", "Genre", "Release Date"};
	    String query6 = "SELECT * FROM (SELECT Album.Name, Artist.ArtisticName as ArtistName, Album.Genre, ReleaseDate FROM (Artist JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Collections ON Creates.CollectionID = Collections.CollectionsID JOIN Album ON Collections.CollectionsID = Album.AlbumID) UNION SELECT Album.Name, Band.Name as ArtistName, Album.Genre, ReleaseDate FROM (Band JOIN Creates2 ON Band.BandID = Creates2.BandID JOIN Collections ON Creates2.CollectionID = Collections.CollectionsID JOIN Album ON Collections.CollectionsID = Album.AlbumID)) as totals";
		DefaultTableModel model6 = setQuery(con, albumColumns, query6);
		albums = new JTable(model6); 
	    JScrollPane sp6 = new JScrollPane(albums); 
	    sp6.setBounds(640, 190, 550, 100); 
	    this.add(sp6);
	      
	    String[] contractColumns = {"Contract ID", "Artist", "Start Date", "End Date"};
	    String query7 = "SELECT ContractID, ArtisticName, StartDate, ExpDate FROM (Contracts JOIN Artist ON Contracts.ArtistID = Artist.ArtistID)";
		DefaultTableModel model7 = setQuery(con, contractColumns, query7);
		contracts = new JTable(model7); 
	    JScrollPane sp7 = new JScrollPane(contracts); 
	    sp7.setBounds(640, 470, 550, 100); 
	    this.add(sp7);
	    
	    String[] singleColumns = {"Name", "Artist", "Genre", "Duration", "Release Date"};
	    String query8 = "SELECT Name, ArtisticName, Song.Genre, Duration, ReleaseDate FROM (Artist JOIN Creates ON Artist.ArtistID = Creates.ArtistID JOIN Collections ON Creates.CollectionID = Collections.CollectionsID JOIN Single ON Collections.CollectionsID = Single.SingleID JOIN Song ON Song.SongID = Single.SongID)";
		DefaultTableModel model8 = setQuery(con, singleColumns, query8);
		singles = new JTable(model8); 
	    JScrollPane sp8 = new JScrollPane(singles); 
	    sp8.setBounds(640, 330, 550, 100); 
	    this.add(sp8);
	    
	    String[] studioColumns = {"Name", "City", "Address", "Cost per Hour"};
	    String query9 = "SELECT Name, City, Address, Cost FROM Studio";
		DefaultTableModel model9 = setQuery(con, studioColumns, query9);
		studios = new JTable(model9); 
	    JScrollPane sp9 = new JScrollPane(studios); 
	    sp9.setBounds(640, 610, 550, 100); 
	    this.add(sp9);
	    
	    String[] bandColumns = {"Name", "Genre"};
	    String query10 = "SELECT Name, Genre FROM Band";
		DefaultTableModel model10 = setQuery(con, bandColumns, query10);
		bands = new JTable(model10); 
	    JScrollPane sp10 = new JScrollPane(bands); 
	    sp10.setBounds(20, 610, 550, 100); 
	    this.add(sp10);
	            	   
	    // Labels 
	    
	    DBGuiLabel singers_label =  new DBGuiLabel(this,"Singers",260,10,100,50, Color.orange);
	    DBGuiLabel lyricists_label = new DBGuiLabel(this,"Lyricists",255, 150,100,50, Color.orange);	    
	    DBGuiLabel composers_label = new DBGuiLabel(this,"Composers",245, 290, 100,50, Color.orange);	    
	    DBGuiLabel musicians_label = new DBGuiLabel(this,"Musicians",250, 430, 100,50, Color.orange);
	    DBGuiLabel bands_label =  new DBGuiLabel(this,"Bands",260,570,100,50, Color.orange);
	    DBGuiLabel songs_label = new DBGuiLabel(this,"Songs",890, 10, 100,50, Color.orange);	    
	    DBGuiLabel albums_label = new DBGuiLabel(this,"Albums",885, 150, 100,50, Color.orange);	    
	    DBGuiLabel singles_label = new DBGuiLabel(this,"Singles",885, 290, 100,50, Color.orange);
	    DBGuiLabel contracts_label =  new DBGuiLabel(this,"Contracts",880,430,100,50, Color.orange);
	    DBGuiLabel studios_label = new DBGuiLabel(this,"Studios",890, 570, 100,50, Color.orange);	    
	    	    
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
    
    public DefaultTableModel setQueryForSongs (Connection con, String[] columns, String query) {
    	
    	DefaultTableModel model = new DefaultTableModel(columns, 0);
	    try {
	    	PreparedStatement pstm = con.prepareStatement(query);
	    	ResultSet Rs = pstm.executeQuery();
	    	List<String> arrlist = new ArrayList<String>();
	    	String names = "";
	    	String prevsong = "";
	    	while(Rs.next()){
	    		String song = Rs.getString(1);
	    		for (int i = 1; i <= columns.length; i++) {
	    			String str = Rs.getString(i);
		    		if (i == 2) {
		    			if (prevsong.equals(song) == true && model.getRowCount()>0) {
		    				System.out.println(song);
		    				System.out.println(prevsong);
		    				model.removeRow(model.getRowCount()-1);
		    				names = names + ", " + str;
		    				System.out.println(names);
		    				str = names;
		    			} else {
		    				names = Rs.getString(2);
		    			}
		    		}
	    			arrlist.add(str);
	    		}
    			System.out.println(names);
		    	prevsong = song;
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
