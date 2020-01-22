package pt.iade.contact.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pt.iade.contact.Main;
import pt.iade.contact.model.Contact;

public class ContactsManagementWindowController implements Initializable{

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
	private ListProperty<Contact> contactListProperty;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) { 
		ArrayList<Contact> contactListAux = new ArrayList<Contact> (Main.facade.showAllContacts());
		
		this.contactListProperty = new SimpleListProperty<Contact>();
		this.contactList.itemsProperty().bind(this.contactListProperty);
		this.contactListProperty.set(FXCollections.observableArrayList(contactListAux));
		
	}
	
	
	public void addContactBt() throws IOException // TODO after adding contact window has to close
	{
	        Parent part = FXMLLoader.load(getClass().getResource("../view/AddContactWindow.fxml"));
	        Stage stage = new Stage();
	        Scene scene = new Scene(part);
	        stage.setScene(scene);
	        stage.show();
	}
	

	
	
	public void editContactBt() {
		System.out.println("Click");
		pt.iade.contact.Main.openAddContactWindow();
		System.out.println("Click");
	
		
	}
	public void deleteContactBt() {
		System.out.println("Click");
		
	}
	public void saveBt() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"/data/state.dat"));
			oos.writeObject(Main.facade);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		pt.iade.contact.Main.openMainWindow();
		System.out.println("Contacts Saved");
		
		
	}
	
	public void listViewTable() {
		System.out.println("Click");
		
	}
	
	
}
