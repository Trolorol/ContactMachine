package guiController;

import entities.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ContactsManagementWindowController {

	@FXML
	private Button addContactBt;

	@FXML
	private Button editContactBt;

	@FXML
	private Button deleteContactBt;

	@FXML
	private Button saveBt;

	@FXML
	private ListView<Contact> contactList;
	
	public void addContactBt(ActionEvent event) throws Exception { 
		               
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/AddContactWindow.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.show();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		
	
	// implentar metodo de abrir addContact numa nova janela.
	public void editContactBt() {
		System.out.println("Click");
		application.Main.openAddContactWindow();
		System.out.println("Click");
		
	}
	public void deleteContactBt() {
		System.out.println("Click");
		
	}
	public void saveBt() {
		System.out.println("Click");
		application.Main.openMainWindow();
		System.out.println("Click");
		
	}
	
	public void listViewTable() {
		System.out.println("Click");
		
	}
	
	
}
