package pt.iade.contact.controller;

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
import javafx.scene.control.TextField;
import pt.iade.contact.Main;
import pt.iade.contact.model.Group;

public class AddContactWindowController implements Initializable {

	@FXML
	private Button confirm;
	@FXML
	private ListView<Group> groupList;
	@FXML
	private ListProperty<Group> groupListProperty;
	@FXML
	private TextField name = new TextField();
	@FXML
	private TextField number = new TextField();

	
	
	/*
	 * initialize method was overridden in order to transform Sets in ArraysLists
	 * This method will create an ArrayList Group type, then it will call the method .showAllGroups from Main.facade
	 * in order to create a similar ArrayList from the set List located in Main.facade.
	 * The ArrayList will then be showed by FXCollections.
	 * This happens in order to select a group for the contact in the contact creation moment. 
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) { // TODO clear selection button;

		ArrayList<Group> groupListAux = new ArrayList<Group>(Main.facade.showAllGroups());

		this.groupListProperty = new SimpleListProperty<Group>();
		this.groupList.itemsProperty().bind(this.groupListProperty);
		this.groupListProperty.set(FXCollections.observableArrayList(groupListAux));

	}

	
	/*
	 * btConfirm method will grab the Contact name, number, and selected group and it will update the respective set Lists in Main.facade via .addContact
	 * and .addContactToGroup by using this two methods presented in Main.facade the number will get added to the Set with a Group.
	 * TODO: NULL check 
	 */
	@FXML
	public void btConfirm() {
		String name = this.name.getText();
		String number = this.number.getText();
		String group = this.groupList.getSelectionModel().getSelectedItem().getName();

		Main.facade.addContact(name, number);
		Main.facade.addContactToGroup(number, group);
		System.out.println(Main.facade.showAllContacts());
	}

	@FXML
	public void groupTable() {

	}

	@FXML
	public void nameInput() {

	}

	@FXML
	public void numberInput() {

	}
}
