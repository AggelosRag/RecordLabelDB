package ClientsGui;

import ApplicationGui.DatabaseConnect;

public class ClientsTable {
	
	private Gui gui2;

	public ClientsTable (DatabaseConnect db) {
		// TODO Auto-generated method stub
		//new DBGui(db);
		gui2=new Gui(db);
	}

	public Gui getGui2() {
		return gui2;
	}
	
	

}
