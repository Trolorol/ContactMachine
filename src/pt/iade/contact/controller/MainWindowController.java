package pt.iade.contact.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.iade.contact.Main;
import pt.iade.contact.model.Contact;
import pt.iade.contact.model.Group;
import pt.iade.contact.model.GroupMessageTemplate;

public class MainWindowController implements Initializable{
	
	
	@FXML
	private Button management;
	@FXML
	private Button send;
	@FXML
	private ListView<Group> groupList;
	private ListProperty<Group> groupListProperty;
	@FXML
	private ListView<Contact> contactList;
	private ListProperty<Contact> contactListProperty;
	@FXML
	private ListView<GroupMessageTemplate> templateList;
	private ListProperty<GroupMessageTemplate> templateListProperty;
	@FXML
	private TextField message;
	
	/*
	 * initialize method was overridden in order to transform Sets in ArraysLists
	 * This method will create ArraysLists from Contact and Group types, then it will call the method .showAllContacts and .showAllGroups from Main.facade
	 * in order to create a similar ArrayList from the set List located in Main.facade.
	 * The ArraysLists will then be showed by FXCollections.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) { //TODO clear selection button
		ArrayList<Contact> contactListAux = new ArrayList<Contact> (Main.facade.showAllContacts());
		ArrayList<Group> groupListAux = new ArrayList<Group> (Main.facade.showAllGroups());
		
		//Contact Set conversion to ArrayList for JavaFx display.
		this.contactListProperty = new SimpleListProperty<Contact>();
		this.contactList.itemsProperty().bind(this.contactListProperty);
		this.contactListProperty.set(FXCollections.observableArrayList(contactListAux));
		
		//Group Set conversion to ArrayList for JavaFx display.
		this.groupListProperty = new SimpleListProperty<Group>();
		this.groupList.itemsProperty().bind(this.groupListProperty);
		this.groupListProperty.set(FXCollections.observableArrayList(groupListAux));
		 
		//GroupMessageTemplate Set conversion to ArrayList for JavaFx display.
		this.templateListProperty = new SimpleListProperty<GroupMessageTemplate>();
		this.templateList.itemsProperty().bind(this.templateListProperty);
		
		
		
		/*
		 * Implemented method to display Contacts and templates aggregated to the selected Group in MainWindow.
		 * changed method was overridden in order to establish a new listener.
		 */
		this.groupList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group>() { //O que faz quando se seleciona um grupo na main window
			@Override
			public void changed(ObservableValue<? extends Group> observable, Group oldValue, Group newValue) {
				ArrayList<GroupMessageTemplate> templateListAux = new ArrayList<GroupMessageTemplate> (newValue.getTemplateList());
				ArrayList<Contact> contactListAux = new ArrayList<Contact> (newValue.getContactList());
				
				templateListProperty.set(FXCollections.observableArrayList(templateListAux));
				
				contactListProperty.set(FXCollections.observableArrayList(contactListAux));
			}
		});
		
		/*
		 * Implemented method to display selected template in TextField in MainWindow
		 * changed method was overridden in order to establish a new listner.
		 */
		this.templateList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GroupMessageTemplate>() { // O que faz quando se seleciona um template 
			@Override
			public void changed(ObservableValue<? extends GroupMessageTemplate> observable, GroupMessageTemplate oldValue, GroupMessageTemplate newValue) {
				String messageText = "";
				if(newValue != null) {
					messageText = newValue.getBody();
				}
				message.setText(messageText);
			}
		});
	}
	

	/*
	 * method to control the Management Button shown in Main widow, this opens a fork window to select Group or Contacts Management.
	 * TODO: Fork Window has open on top of main window.
	 */
	@FXML
	public void btManagementAction() throws IOException{
	       
		pt.iade.contact.Main.openforkWindow();
		/*Parent part = FXMLLoader.load(getClass().getResource("../view/ForkMenagementWindow.fxml"));
	        Stage stage = new Stage();
	        Scene scene = new Scene(part);
	        stage.setScene(scene);
	        stage.show();*/
	}
	
	/*
	 * Send Button, this will pass data to service Facade.
	 * TODO: this action will receive a Set of contacts, is missing a iterator to send one message to all contacts in set.
	 */
	@FXML
	public void btSendAction() {
		// vou buscar o grupo selecion
		// vou a text box buscar a mensagem 
		// for loop para enviar mensagem 
		
		
	}
	
	
	@FXML
	public void showContactList() {
		
	}
	
	@FXML
	public Collection<Group> showGroupList() {
		return Main.facade.showAllGroups();
		
	}
	
	@FXML
	public void showTemplateList() {
		
	}
	
	
	
}
