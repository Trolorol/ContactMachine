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
import pt.iade.contact.model.GroupMessageTemplate;

public class AddGroupWindowController implements Initializable {

	@FXML
	private Button btConfirm;
	@FXML
	private Button addTemplateBt;
	@FXML
	private TextField groupName;
	@FXML
	private ListView<GroupMessageTemplate> templateList;
	private ListProperty<GroupMessageTemplate> templateListProperty;

	/*
	 * initialize method was overridden in order to transform Sets in ArraysLists
	 * This method will create an ArrayList GroupMessageTemplate type, then it will call the method .showAllTemplates from Main.facade
	 * in order to create a similar ArrayList from the set List located in Main.facade.
	 * The ArrayList will then be showed by FXCollections.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ArrayList<GroupMessageTemplate> groupListAux = new ArrayList<GroupMessageTemplate>(
				Main.facade.showAllTemplates());

		this.templateListProperty = new SimpleListProperty<GroupMessageTemplate>();
		this.templateList.itemsProperty().bind(this.templateListProperty);
		this.templateListProperty.set(FXCollections.observableArrayList(groupListAux));

	}

	/*
	 * confirmBt method will grab the Group name and selected template and will update the respective set Lists in Main.facade via .addGroup
	 * and .addTemplateToGroup
	 */
	@FXML
	public void confirmBt() {
		String name = this.groupName.getText();
		String templateTitle = templateList.getSelectionModel().getSelectedItem().getTitle();
		Main.facade.addGroup(name);
		Main.facade.addTemplateToGroup(templateTitle, name);
		pt.iade.contact.Main.openGroupManagementWindow();
	}

	@FXML
	public void nameInput() {

	}

	@FXML
	public void templateInput() {

	}

	@FXML
	public void btAddTemplate() {
		System.out.println("click Add Template");
		pt.iade.contact.Main.openAddTemplateWindow();
	}
}
