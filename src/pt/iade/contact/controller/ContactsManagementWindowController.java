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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import pt.iade.contact.Main;
import pt.iade.contact.model.Contact;

public class ContactsManagementWindowController implements Initializable {

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

	/*
	 * initialize method was overridden in order to transform Sets in ArraysLists
	 * This method will create an ArrayList Contact type, then it will call the method .showAllContacts from Main.facade
	 * in order to create a similar ArrayList from the set List located in Main.facade.
	 * The ArrayList will then be showed by FXCollections.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ArrayList<Contact> contactListAux = new ArrayList<Contact>(Main.facade.showAllContacts());

		this.contactListProperty = new SimpleListProperty<Contact>();
		this.contactList.itemsProperty().bind(this.contactListProperty);
		this.contactListProperty.set(FXCollections.observableArrayList(contactListAux));

	}

	/*
	 * addContactBt will show a addContactWindow 
	 * TODO: after adding a contact the addContactWindow has to close.
	 * 
	 */
	public void addContactBt() throws IOException
	{
		pt.iade.contact.Main.openAddContactWindow();
		/*
		Parent part = FXMLLoader.load(getClass().getResource("../view/AddContactWindow.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(part);
		stage.setScene(scene);
		stage.show();
		*/
	}

	public void editContactBt() {
		pt.iade.contact.Main.openAddContactWindow();
		
	}
	/*Delete Contact Button
	 * Receives a number of type String and fetches the number from contactList 
	 * and using the .removeContact from the facade removes it from the rest of the program.
	 * 
	 */
	public void deleteContactBt() {
		String number = contactList.getSelectionModel().getSelectedItem().getNumber();
		Main.facade.removeContact(number);

	}
	
	/*
	 * saveBt method will trigger a Serializable action, storing a facade Object in a file located in /data/state.dat
	 * This ensures all data created from the facade is stored in state.dat file
	 */
	public void saveBt() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/state.dat"));
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
