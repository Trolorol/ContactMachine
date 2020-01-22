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
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) { //TODO clear selection button
		ArrayList<Contact> contactListAux = new ArrayList<Contact> (Main.facade.showAllContacts());
		ArrayList<Group> groupListAux = new ArrayList<Group> (Main.facade.showAllGroups());
		
		
		this.contactListProperty = new SimpleListProperty<Contact>();
		this.contactList.itemsProperty().bind(this.contactListProperty);
		this.contactListProperty.set(FXCollections.observableArrayList(contactListAux));
		
		this.groupListProperty = new SimpleListProperty<Group>();
		this.groupList.itemsProperty().bind(this.groupListProperty);
		this.groupListProperty.set(FXCollections.observableArrayList(groupListAux));
		 
		this.templateListProperty = new SimpleListProperty<GroupMessageTemplate>();
		this.templateList.itemsProperty().bind(this.templateListProperty);
		
		
		
		
		this.groupList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group>() {
			@Override
			public void changed(ObservableValue<? extends Group> observable, Group oldValue, Group newValue) {
				ArrayList<GroupMessageTemplate> templateListAux = new ArrayList<GroupMessageTemplate> (newValue.getTemplateList());
				ArrayList<Contact> contactListAux = new ArrayList<Contact> (newValue.getContactList());
				
				templateListProperty.set(FXCollections.observableArrayList(templateListAux));
				
				contactListProperty.set(FXCollections.observableArrayList(contactListAux));
			}
		});
		
		
		this.templateList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GroupMessageTemplate>() {
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
	@FXML
	public void btManagementAction() {
		pt.iade.contact.Main.openforkWindow();
	}
	*/
	@FXML
	public void btManagementAction() throws IOException //TODO Fork window has to close after selection.
	{
	        Parent part = FXMLLoader.load(getClass().getResource("../view/ForkMenagementWindow.fxml"));
	        Stage stage = new Stage();
	        Scene scene = new Scene(part);
	        stage.setScene(scene);
	        stage.show();
	}
	
	
	@FXML
	public void btSendAction() {
		
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
