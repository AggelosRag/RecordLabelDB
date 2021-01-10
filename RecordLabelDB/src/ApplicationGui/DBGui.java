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

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClientsGui.ClientsTable;
import DeleteDataGui.DeleteGui;
import InsertDataGui.InsertGui;




public class DBGui extends JFrame{
	
	private TextArea queryta,queryprint;
	private JTable ta;
	private DatabaseConnect db;
	private DBGui2 gui2;
	private DeleteGui deletegui;
	private InsertGui insertgui;
	private ComponentItemListener listener;
	private DBGuiCheckBox artist,singer,musician,writer,composer,album,contract,song,group;
	private DBGuiCheckBox activecontract,notactivecontract,albumsongs,albumtitle,albumstyle;
	private DBGuiCheckBox songtitle,songduration,songstyle,songalbum,songsingle,songfeats;
	private DBGuiCheckBox studio,studioname,studiocity,studiocost;
	private DBGuiLabel artistname; 
	private DBGuiTextField artistnametf,albumtitletf,albumstyletf,songtitletf,songstyletf,studionametf,studiocitytf;
	private ClientsTable clientstable;
	
	public DBGui(DatabaseConnect db) {
		super("RecordsLabelApp");
		this.db=db;
		this.setLayout(null);
	    this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	    this.getContentPane().setBackground(Color.YELLOW);;
	    this.setSize(1450,750);
	    this.setLocation(100,30);
	    this.setVisible(true);
	    this.setResizable(false);
	    this.addWindowListener(new CloseWindowAndExit());
	    
	    
	    clientstable = new ClientsTable(db);
	    gui2 = new DBGui2(db);
	    deletegui = new DeleteGui(db);
	    insertgui =  new InsertGui(db);
	    
	    // TextArea 
	    
	    ta = new JTable();
	    JScrollPane sp1 = new JScrollPane(ta); 
	    sp1.setBounds(0,370,1000,325);
	    this.add(sp1);
	    
	    queryta = new TextArea("Insert Query", 10,1,TextArea.SCROLLBARS_BOTH );
	    queryta.setBounds(0, 2, 440, 375);
	    this.add(queryta);
	    
	    queryprint = new TextArea("", 10,1,TextArea.SCROLLBARS_BOTH );
	    queryprint.setBounds(1020,370, 405, 325);
	    this.add(queryprint);
	    
	    
	    listener = new ComponentItemListener(this);
	    
	    //MENU 
	    
		MenuBar mb = new MenuBar();
		this.setMenuBar(mb);
		Menu DBMS_Menu = new Menu("DBMS Menu");
		mb.add(DBMS_Menu);
		
		MenuItem ClientsTable = new MenuItem("Clients Table");
		DBMS_Menu.add(ClientsTable);
		ClientsTable.setActionCommand("ClientsTable");
		ClientsTable.addActionListener(listener);
		
		MenuItem InsertTable = new MenuItem("InsertData Table");
		DBMS_Menu.add(InsertTable);
		InsertTable.setActionCommand("InsertDataTable");
		InsertTable.addActionListener(listener);
		
		MenuItem DeleteTable = new MenuItem("DeleteData Table");
		DBMS_Menu.add(DeleteTable);
		DeleteTable.setActionCommand("DeleteDataTable");
		DeleteTable.addActionListener(listener);
		
		MenuItem ClearDisplay = new MenuItem("Clear Display");
		DBMS_Menu.add(ClearDisplay);
		ClearDisplay.setActionCommand("ClearDisplay");
		ClearDisplay.addActionListener(listener);
	    
	    
	    //CheckBoxes
	     
	    artist = new DBGuiCheckBox(this,"Artist",450, 20, 80, 30,true);
	    artist.addItemListener(listener);
	    
	    singer= new DBGuiCheckBox(this,"Singer",700, 20, 80, 30,false);
	    singer.addItemListener(listener);
	    
	    musician = new DBGuiCheckBox(this,"Musician",790, 20, 80, 30,false);
	    musician.addItemListener(listener);
	   
	    writer = new DBGuiCheckBox(this,"Lyricist",880, 20, 80, 30,false);
	    writer.addItemListener(listener);
	
	    composer = new DBGuiCheckBox(this,"Composer",971, 20, 95, 30,false);
	    composer.addItemListener(listener);
	    
	    group = new DBGuiCheckBox(this,"Band",1076, 20, 95, 30,false);
	    group.addItemListener(listener);
	    
	    album = new DBGuiCheckBox(this,"Album",450, 90, 80, 30,true);
	    album.addItemListener(listener);
	    
	    albumsongs = new DBGuiCheckBox(this,"Album Songs",950, 90, 110, 30,false);
	    albumsongs.addItemListener(listener);
	    
	    contract = new DBGuiCheckBox(this,"Contract",450, 160, 80, 30,true);
	    contract.addItemListener(listener);
	    
	    activecontract = new DBGuiCheckBox(this,"Active",550, 160, 100, 30,false);
	    activecontract.addItemListener(listener);
	    
	    notactivecontract = new DBGuiCheckBox(this,"Not Active",660, 160, 100, 30,false);
	    notactivecontract.addItemListener(listener);
	    
	    
	    song = new DBGuiCheckBox(this,"Song",450, 230, 80, 30,true);
	    song.addItemListener(listener);
	    
	    songtitle = new DBGuiCheckBox(this,"Title",540, 230, 60, 30,false);
	    songtitle.addItemListener(listener);
	    
	    songstyle = new DBGuiCheckBox(this,"Genre",700, 230, 100, 30,false);
	    songstyle.addItemListener(listener);
	    
	    songduration = new DBGuiCheckBox(this,"Duration",900, 230, 90, 30,false);
	    songduration.addItemListener(listener);
	    
	    songalbum = new DBGuiCheckBox(this,"Album",1000, 230, 80, 30,false);
	    songalbum.addItemListener(listener);
	    
	    songsingle = new DBGuiCheckBox(this,"Single",1089, 230, 80, 30,false);
	    songsingle.addItemListener(listener);
	    
	    songfeats = new DBGuiCheckBox(this,"Feats",1178, 230, 80, 30,false);
	    songfeats.addItemListener(listener);
	    
	    studio = new DBGuiCheckBox(this,"Studio",450, 300, 80, 30,true);
	    studio.addItemListener(listener);
	    
	    studioname = new DBGuiCheckBox(this,"Name",540, 300, 80, 30,false);
	    studioname.addItemListener(listener);
	    
	    studiocity = new DBGuiCheckBox(this,"City",735, 300, 70, 30,false);
	    studiocity.addItemListener(listener);
	    
	    studiocost = new DBGuiCheckBox(this,"Cost/hour",930, 300, 100, 30,false);
	    studiocost.addItemListener(listener);
	    
	   
	    //Labels , TextFields
	    
	    artistname=  new DBGuiLabel(this,"Name",550,20,50,30);
	    artistnametf = new DBGuiTextField(this,600,20,90,30,null);
	
	    albumtitle= new DBGuiCheckBox(this,"Title",550, 90, 80, 30,false);
	    albumtitletf = new DBGuiTextField(this,635,90,90,30,null);
	    
	    albumstyle = new DBGuiCheckBox(this,"Genre",750, 90, 95, 30,false);
	    albumstyletf = new DBGuiTextField(this,850,90,90,30,null);
	    
	    songtitletf= new DBGuiTextField(this,605, 230, 80, 30,null);
	    songstyletf = new DBGuiTextField(this,805, 230, 80, 30,null);
	    
	    studionametf= new DBGuiTextField(this,621, 300, 78, 30,null);
	    studiocitytf=new DBGuiTextField(this,806, 300, 78, 30,null);
	    
	    
	    
	    //BUTTON START
	    
	    Button start = new Button("START");
	    start.setFont(new Font("Arial Black", Font.PLAIN, 16));
	    start.setForeground(Color.BLACK);
	    start.setBackground(Color.WHITE);
	    start.setVisible(true);
	    start.setBounds(1230, 300, 70, 60);
	    start.setActionCommand("START");
	    start.addActionListener(listener);
	    this.add(start);
	    
	    //BUTTON SHOWTABLES
	    
	    Button showtables = new Button("SHOW TABLES");
	    showtables.setFont(new Font("Arial Black", Font.PLAIN, 16));
	    showtables.setForeground(Color.BLACK);
	    showtables.setBackground(Color.orange);
	    showtables.setVisible(true);
	    showtables.setBounds(1100, 300, 120, 60);
	    showtables.setActionCommand("SHOW TABLES");
	    showtables.addActionListener(listener);
	    this.add(showtables);
	    
	    
	    
	    
		
	}
	
	
	
	
	public DeleteGui getDeletegui() {
		return deletegui;
	}

	public InsertGui getInsertgui() {
		return insertgui;
	}

	public DBGui2 getGui2() {
		return gui2;
	}

	public ClientsTable getClientstable() {
		return clientstable;
	}


	public DatabaseConnect getDb() {
		return db;
	}


	public JTable getTa() {
		return ta;
	}
	
	
	public TextArea getQueryta() {
		return queryta;
	}
	
	
	public TextArea getQueryprint() {
		return queryprint;
	}


	//////////////CHECK BOXES //////////////////
	


	public DBGuiCheckBox getArtist() {
		return artist;
	}
	
	public DBGuiCheckBox getSinger() {
		return singer;
	}


	public DBGuiCheckBox getMusician() {
		return musician;
	}


	public DBGuiCheckBox getWriter() {
		return writer;
	}


	public DBGuiCheckBox getComposer() {
		return composer;
	}


	public DBGuiCheckBox getGroup() {
		return group;
	}


	public DBGuiCheckBox getAlbum() {
		return album;
	}


	public DBGuiCheckBox getContract() {
		return contract;
	}


	public DBGuiCheckBox getSong() {
		return song;
	}
	
	public DBGuiCheckBox getActivecontract() {
		return activecontract;
	}


	public DBGuiCheckBox getNotactivecontract() {
		return notactivecontract;
	}
	
	
	public DBGuiCheckBox getAlbumsongs() {
		return albumsongs;
	}
	
	public DBGuiCheckBox getAlbumstyle() {
		return albumstyle;
	}

	public DBGuiCheckBox getAlbumtitle() {
		return albumtitle;
	}
	
	public DBGuiCheckBox getSongtitle() {
		return songtitle;
	}

	public DBGuiCheckBox getSongstyle() {
		return songstyle;
	}
	
	public DBGuiCheckBox getSongduration() {
		return songduration;
	}


	public DBGuiCheckBox getSongalbum() {
		return songalbum;
	}
	

	public DBGuiCheckBox getSongsingle() {
		return songsingle;
	}
	
	public DBGuiCheckBox getSongfeats() {
		return songfeats;
	}
	
	
	public DBGuiCheckBox getStudio() {
		return studio;
	}

	public DBGuiCheckBox getStudioname() {
		return studioname;
	}


	public DBGuiCheckBox getStudiocity() {
		return studiocity;
	}


	public DBGuiCheckBox getStudiocost() {
		return studiocost;
	}


	//////////LABELS/////////////////
	public DBGuiLabel getArtistname() {
		return artistname;
	}
	



	////////////////TEXT FIELDS /////////////
	public DBGuiTextField getArtistnametf() {
		return artistnametf;
	}

	public DBGuiTextField getAlbumtitletf() {
		return albumtitletf;
	}

	public DBGuiTextField getAlbumstyletf() {
		return albumstyletf;
	}

	public DBGuiTextField getSongtitletf() {
		return songtitletf;
	}

	public DBGuiTextField getSongstyletf() {
		return songstyletf;
	}

	public DBGuiTextField getStudionametf() {
		return studionametf;
	}


	public DBGuiTextField getStudiocitytf() {
		return studiocitytf;
	}






	class CloseWindowAndExit extends WindowAdapter
	{
		public void windowClosing(WindowEvent closeWindowAndExit)
		  {
		   System.exit(0);
		  }
	}

}
