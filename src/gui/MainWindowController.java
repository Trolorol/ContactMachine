package gui;

import java.util.LinkedHashSet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController {
	
	@FXML
	private Button management;
	private Button send;
	private ListView<String> contactList;
	private ListView<String> groupList;
	private ListView<String> templateList;
	private TextField message;
	
	
	
	
	@FXML
	public void btManagementAction() {
		System.out.println("Click");
	}
	
	@FXML
	public void btSendAction() {
		
	}
	
	@FXML
	
	public void showContactList() {
		
	}
	
	@FXML
	public void showGroupList() {
		
	}
	
	@FXML
	public void showTemplateList() {
		
	}
	
	
	
}
