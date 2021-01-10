package DeleteDataGui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JFrame;

import ApplicationGui.DBGuiCheckBox;
import ApplicationGui.DBGuiLabel;
import ApplicationGui.DBGuiTextField;
import ApplicationGui.DatabaseConnect;
import InsertDataGui.ComponentListener;

public class DeleteGui extends JFrame{
	private DatabaseConnect db;
	private TextArea ta;
	private DeleteComponentListener listener;
	private DBGuiCheckBox artist,album,contract,song;
	private DBGuiCheckBox group,studio;
	private DBGuiLabel firstname,lastname,artisticname,gender,genre;
	private DBGuiLabel albumtitle,albumstyle,artistalbum;
	private DBGuiLabel songtitle,songduration,songstyle;
	private DBGuiLabel studioname,studiocity,studioaddress,studiocost;
	private DBGuiLabel groupname,groupgenre;
	private DBGuiTextField firstnametf,lastnametf,artisticnametf,artistgendertf,artistgenretf,albumtitletf,albumstyletf,artistalbumtf;
	private DBGuiTextField songtitletf,songstyletf,songdurationtf,studionametf,studiocitytf,studioaddresstf,studiocosttf;
	private DBGuiTextField groupnametf,groupgenretf;

	public DeleteGui(DatabaseConnect db) {
		super("RecordsLabelAppDeleteData");
		this.db=db;
		this.setLayout(null);
	    this.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	    this.getContentPane().setBackground(Color.CYAN);;
	    this.setSize(1200,800);
	    this.setLocation(100,30);
	    this.setVisible(false);
	    this.setResizable(false);
	    
	    
	    listener = new DeleteComponentListener(this);
	    
	    ta =  new TextArea("", 10,1,TextArea.SCROLLBARS_BOTH );
	    ta.setBounds(10, 400, 1160, 370);
	    this.add(ta);
	    
	    //CheckBoxes
	     
	    artist = new DBGuiCheckBox(this,"Artist",10, 20, 80, 30,true);
	    artist.addItemListener(listener);

	    firstname = new DBGuiLabel(this,"Firstname",10,60,80,30);
	    firstnametf= new DBGuiTextField(this,100,60,100,30,null);
	    lastname= new DBGuiLabel(this,"Lastname",210,60,80,30);
	    lastnametf = new DBGuiTextField(this,300,60,100,30,null);
	    artisticname = new DBGuiLabel(this,"Artistic Name",410,60,80,30);
	    artisticnametf=new DBGuiTextField(this,500,60,100,30,null);
	    gender= new DBGuiLabel(this,"Gender",610,60,80,30);
	    artistgendertf = new DBGuiTextField(this,700,60,100,30,null);
	    genre =new DBGuiLabel(this,"Genre",810,60,80,30);
	    artistgenretf = new DBGuiTextField(this,900,60,100,30,null);
	    
	    
	    album = new DBGuiCheckBox(this,"Album",10, 100, 80, 30,true);
	    album.addItemListener(listener);
	    albumtitle= new DBGuiLabel(this,"Title",100, 100, 80, 30);
	    albumtitletf = new DBGuiTextField(this,190,100,100,30,null);
	    albumstyle = new DBGuiLabel(this,"Genre",300, 100, 80, 30);
	    albumstyletf = new DBGuiTextField(this,390,100,100,30,null);
	    artistalbum = new DBGuiLabel(this,"Artist",500, 100, 80, 30);
	    artistalbumtf = new DBGuiTextField(this,590,100,100,30,"Insert Artist/Band");
	    
	    song = new DBGuiCheckBox(this,"Song",10, 180, 80, 30,true);
	    song.addItemListener(listener);
	    songtitle = new DBGuiLabel(this,"Title",100, 180, 80, 30);
	    songtitletf = new DBGuiTextField(this,190,180,100,30,null);
	    songstyle =  new DBGuiLabel(this,"Genre",300, 180, 80, 30);
	    songstyletf = new DBGuiTextField(this,390,180,100,30,null);
	    songduration =  new DBGuiLabel(this,"Duration",500, 180, 80, 30);
	    songdurationtf= new DBGuiTextField(this,590,180,100,30,null);
	    
	    studio = new DBGuiCheckBox(this,"Studio",10, 260, 80, 30,true);
	    studio.addItemListener(listener);
	    studioname = new DBGuiLabel(this,"Name",100, 260, 80, 30);
	    studionametf = new DBGuiTextField(this,190,260,100,30,null);
	    studiocity =  new DBGuiLabel(this,"City",300, 260, 80, 30);
	    studiocitytf = new DBGuiTextField(this,390,260,100,30,null);
	    studioaddress =  new DBGuiLabel(this,"Address",500, 260, 80, 30);
	    studioaddresstf= new DBGuiTextField(this,590,260,100,30,null);
	    studiocost =new DBGuiLabel(this,"Cost/hour",700, 260, 80, 30);
	    studiocosttf = new DBGuiTextField(this,790,260,100,30,null);
	    
	    group = new DBGuiCheckBox(this,"Band",10, 340, 80, 30,true);
	    group.addItemListener(listener);
	    groupname = new DBGuiLabel(this,"Name",100, 340, 80, 30);
	    groupnametf = new DBGuiTextField(this,190,340,100,30,null);
	    groupgenre =  new DBGuiLabel(this,"Genre",300, 340, 80, 30);
	    groupgenretf = new DBGuiTextField(this,390,340,100,30,null);
	    
	    
	    Button start = new Button("DELETE");
	    start.setFont(new Font("Arial Black", Font.PLAIN, 16));
	    start.setForeground(Color.BLACK);
	    start.setBackground(Color.WHITE);
	    start.setVisible(true);
	    start.setBounds(1000, 300, 70, 60);
	    start.setActionCommand("DELETE");
	    start.addActionListener(listener);
	    this.add(start);
	    
	}


public DatabaseConnect getDb() {
	return db;
}

public TextArea getTa() {
	return ta;
}

/////////// ARTIST CHECK BOX /////////////////////


public DBGuiCheckBox getArtist() {
	return artist;
}

public DBGuiLabel getFirstname() {
	return firstname;
}

public DBGuiLabel getLastname() {
	return lastname;
}

public DBGuiLabel getArtisticname() {
	return artisticname;
}

public DBGuiLabel getGender() {
	return gender;
}

public DBGuiLabel getGenre() {
	return genre;
}

public DBGuiTextField getFirstnametf() {
	return firstnametf;
}

public DBGuiTextField getLastnametf() {
	return lastnametf;
}

public DBGuiTextField getArtisticnametf() {
	return artisticnametf;
}

public DBGuiTextField getArtistgendertf() {
	return artistgendertf;
}

public DBGuiTextField getArtistgenretf() {
	return artistgenretf;
}



//////////////////////////////////////////////////

////////////////// ALBUM CHECK BOX ////////////////////
	


public DBGuiLabel getAlbumtitle() {
	return albumtitle;
}


public DBGuiCheckBox getAlbum() {
	return album;
}


public DBGuiLabel getAlbumstyle() {
	return albumstyle;
}


public DBGuiLabel getArtistalbum() {
	return artistalbum;
}


public DBGuiTextField getAlbumtitletf() {
	return albumtitletf;
}


public DBGuiTextField getAlbumstyletf() {
	return albumstyletf;
}


public DBGuiTextField getArtistalbumtf() {
	return artistalbumtf;
}




//////////////////////////////////////////////////

///////////////////// SONG CHECK BOX /////////////////////



public DBGuiCheckBox getSong() {
	return song;
}


public DBGuiLabel getSongtitle() {
	return songtitle;
}


public DBGuiLabel getSongduration() {
	return songduration;
}


public DBGuiLabel getSongstyle() {
	return songstyle;
}


public DBGuiTextField getSongtitletf() {
	return songtitletf;
}


public DBGuiTextField getSongstyletf() {
	return songstyletf;
}


public DBGuiTextField getSongdurationtf() {
	return songdurationtf;
}


/////////////////////////////////////////////////////////


//////////////////// STUDIO CHECK BOX //////////////////


public DBGuiCheckBox getStudio() {
	return studio;
}

public DBGuiLabel getStudioname() {
	return studioname;
}

public DBGuiLabel getStudiocity() {
	return studiocity;
}

public DBGuiLabel getStudioaddress() {
	return studioaddress;
}

public DBGuiLabel getStudiocost() {
	return studiocost;
}

public DBGuiTextField getStudionametf() {
	return studionametf;
}

public DBGuiTextField getStudiocitytf() {
	return studiocitytf;
}

public DBGuiTextField getStudioaddresstf() {
	return studioaddresstf;
}

public DBGuiTextField getStudiocosttf() {
	return studiocosttf;
}





////////////////////////////////////////////////////////

/////////////////// GROUP CHECK BOX ////////////////////////


public DBGuiCheckBox getGroup() {
	return group;
}

public DBGuiLabel getGroupname() {
	return groupname;
}

public DBGuiLabel getGroupgenre() {
	return groupgenre;
}

public DBGuiTextField getGroupnametf() {
	return groupnametf;
}

public DBGuiTextField getGroupgenretf() {
	return groupgenretf;
}

}



