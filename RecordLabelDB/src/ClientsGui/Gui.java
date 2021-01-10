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

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ApplicationGui.DatabaseConnect;


public class Gui extends JFrame {

	private TextArea ta,queryta,queryprint;
	private DatabaseConnect db;
	private  JTable jtable;
	private DBGui2 tablesgui;
	private ComponentItemListener listener;
	private DBGuiCheckBox collections,collectionsname,collectionstype,releasedate,versions, versionsid, productioncost,type,clients, companyname, firstname, lastname, address, purchases, purchasesdate, terms;
	private DBGuiLabel collectionsinputname, versionsinputid, clientsinputcompany, purchasesinputdate; 
	private DBGuiTextField collectionsinputnametf,versionsidtf,clientscompanytf,purchasesdatetf;
	
	
	public Gui(DatabaseConnect db) {
		super("Clients App");
		this.db=db;
		tablesgui = new DBGui2(db);
		this.setLayout(null);
	    this.setFont(new Font("monospace", Font.PLAIN, 14));
	    this.getContentPane().setBackground(Color.YELLOW);;
	    this.setSize(1450,750);
	    this.setLocation(100,30);
	    this.setVisible(false);
	    this.setResizable(false);
	   // this.addWindowListener(new CloseWindowAndExit());
	    
	    // TextArea 
	    
	    jtable = new JTable(); 
	    JScrollPane sp1 = new JScrollPane(jtable); 
	    sp1.setBounds(10,370,1000,325); 
	    this.add(sp1);
	    
	    ta = new TextArea("", 10,1,TextArea.SCROLLBARS_BOTH );
	    ta.setBounds(10,370,1000,325);
	    ta.setFont( new Font("consolas", Font.BOLD, 12) );
	    this.add(ta);
	    
	    queryta = new TextArea("Insert Query", 10,1,TextArea.SCROLLBARS_BOTH );
	    queryta.setBounds(10, 10, 420, 350);
	    this.add(queryta);
	    
	    queryprint = new TextArea("", 10,1,TextArea.SCROLLBARS_BOTH );
	    queryprint.setBounds(1020,370, 405, 325);
	    this.add(queryprint);
	    
	    listener = new ComponentItemListener(this);
	    
	    
	    //CheckBoxes, Labels and Textfields
	    
	    collections = new DBGuiCheckBox(this,"Collections",450, 20, 100, 30,true);
	    collections.addItemListener(listener);
	    
	    collectionsname = new DBGuiCheckBox(this,"Name",971, 20, 95, 30,false,Color.CYAN);
	    
	    collectionstype = new DBGuiCheckBox(this,"Type",1076, 20, 95, 30,false,Color.CYAN);
	    
	    releasedate = new DBGuiCheckBox(this,"Release Date",1181, 20, 115, 30,false,Color.CYAN);
	    
	    versions = new DBGuiCheckBox(this,"Versions",450, 90, 100, 30,true);
	    versions.addItemListener(listener);
	
	    clients = new DBGuiCheckBox(this,"Clients",450, 160, 100, 30,true);
	    clients.addItemListener(listener);
	    
	    purchases = new DBGuiCheckBox(this,"Purchases",450, 230, 100, 30,true);
	    purchases.addItemListener(listener);
	    	    
	    collectionsinputname=  new DBGuiLabel(this,"Name",590,20,100,30,Color.ORANGE);
	    collectionsinputnametf = new DBGuiTextField(this,690,20,130,30);
	    
	    versionsinputid=  new DBGuiLabel(this,"Version ID",590,90,100,30,Color.ORANGE);
		// versionsid= new DBGuiCheckBox(this,"Title",550, 90, 80, 30,false);
	    versionsid= new DBGuiCheckBox(this,"Version ID",971, 90, 100, 30,false,Color.CYAN);
	    versionsidtf = new DBGuiTextField(this,690,90,130,30);
	    productioncost= new DBGuiCheckBox(this,"Production Cost",1081, 90, 120, 30,false,Color.CYAN);
	    type= new DBGuiCheckBox(this,"Type",1211, 90, 80, 30,false,Color.CYAN);
	    
	    clientsinputcompany=  new DBGuiLabel(this,"Company Name",590,160,100,30,Color.ORANGE);
	    clientscompanytf = new DBGuiTextField(this,690,160,130,30);
	    companyname= new DBGuiCheckBox(this,"Company",971, 160, 100, 30,false,Color.CYAN);
	    firstname= new DBGuiCheckBox(this,"First Name",1081, 160, 100, 30,false,Color.CYAN);
	    lastname= new DBGuiCheckBox(this,"Last Name",1191, 160, 100, 30,false,Color.CYAN);
	    address= new DBGuiCheckBox(this,"Address",1301, 160, 80, 30,false,Color.CYAN);
	    
	    purchasesinputdate=  new DBGuiLabel(this,"Purchase Date",590,230,100,30,Color.ORANGE);
	    purchasesdatetf = new DBGuiTextField(this,690,230,130,30);
	    purchasesdate= new DBGuiCheckBox(this,"Purchase Date",971, 230, 120, 30,false,Color.CYAN);
	    terms= new DBGuiCheckBox(this,"Terms",1101, 230, 80, 30,false,Color.CYAN);
	 
	    
	    //BUTTON START
	    
	    Button start = new Button("START");
	    start.setFont(new Font("Arial Black", Font.BOLD, 16));
	    start.setForeground(Color.BLACK);
	    start.setBackground(Color.WHITE);
	    start.setVisible(true);
	    start.setBounds(1260, 300, 70, 60);
	    start.setActionCommand("START");
	    start.addActionListener(listener);
	    this.add(start);
	    
	    // BUTTON SHOW TABLES
	    
	    Button showTables = new Button("SHOW TABLES");
	    showTables.setFont(new Font("Arial Black", Font.BOLD, 16));
	    showTables.setForeground(Color.BLACK);
	    showTables.setBackground(Color.ORANGE);
	    showTables.setVisible(true);
	    showTables.setBounds(1100, 300, 140, 60);
	    showTables.setActionCommand("SHOW TABLES");
	    showTables.addActionListener(listener);
	    this.add(showTables);
	    
	}
	
	public DatabaseConnect getDb() {
		return db;
	}
	
	public DBGui2 getTablesGui() {
		return tablesgui;
	}
	
	public JTable getTable() {
		return jtable;
	}
	
	public TextArea getTaPrint() {
		return queryprint;
	}
	
	public TextArea getQueryta() {
		return queryta;
	}
	
	//////////////CHECK BOXES, TEXTFIELDS, LABELS //////////////////
	
	public DBGuiCheckBox getCollections() {
		return collections;
	}
	
	public DBGuiCheckBox getCollectionsName() {
		return collectionsname;
	}
	
	public DBGuiCheckBox getCollectionsType() {
		return collectionstype;
	}
	
	public DBGuiCheckBox getReleaseDate() {
		return releasedate;
	}
	
	public DBGuiCheckBox getVersions() {
		return versions;
	}
	
	public DBGuiCheckBox getClients() {
		return clients;
	}
	
	public DBGuiCheckBox getPurchases() {
		return purchases;
	}
	
	public DBGuiCheckBox getVersionsID() {
		return versionsid;
	}
	
	public DBGuiCheckBox getProductionCost() {
		return productioncost;
	}
	
	public DBGuiCheckBox gettype() {
		return type;
	}
	
	public DBGuiCheckBox getCompanyName() {
		return companyname;
	}
	
	public DBGuiCheckBox getFirstName() {
		return firstname;
	}
	
	public DBGuiCheckBox getLastName() {
		return lastname;
	}
	
	public DBGuiCheckBox getAddress() {
		return address;
	}
	
	public DBGuiCheckBox getPurchasesDate() {
		return purchasesdate;
	}
	
	public DBGuiCheckBox getTerms() {
		return terms;
	}
	
	public DBGuiLabel getCollectionsInputName() {
		return collectionsinputname;
	}
	
	public DBGuiLabel getVersionsInputID() {
		return versionsinputid;
	}
	
	public DBGuiLabel getClientsInputCompany() {
		return clientsinputcompany;
	}
	
	public DBGuiLabel getPurchasesInputDate() {
		return purchasesinputdate;
	}
	
	public DBGuiTextField getCollectionsInputNameTf() {
		return collectionsinputnametf;
	}

	public DBGuiTextField getVersionsIdTf() {
		return versionsidtf;
	}

	public DBGuiTextField getClientsCompanyTf() {
		return clientscompanytf;
	}

	public DBGuiTextField getPurchasesDateTf() {
		return purchasesdatetf;
	}
	
}

class CloseWindowAndExit extends WindowAdapter
{
	public void windowClosing(WindowEvent closeWindowAndExit)
	  {
	   System.exit(0);
	  }
}
