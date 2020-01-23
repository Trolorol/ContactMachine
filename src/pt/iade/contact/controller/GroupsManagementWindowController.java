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
import pt.iade.contact.model.Group;

public class GroupsManagementWindowController implements Initializable {

	@FXML
	private Button addGroupBt;
	@FXML
	private Button editGroupBt;
	@FXML
	private Button deleteGroupBt;
	@FXML
	private Button saveBt;
	@FXML
	private ListView<Group> groupList;
	private ListProperty<Group> groupListProperty;

	/*
	 * initialize method was overridden in order to transform Sets in ArraysLists
	 * This method will create an ArrayList Group type, then it will call the method .showAllGroups from Main.facade
	 * in order to create a similar ArrayList from the set List located in Main.facade.
	 * The ArrayList will then be showed by FXCollections.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ArrayList<Group> groupListAux = new ArrayList<Group>(Main.facade.showAllGroups());
		this.groupListProperty = new SimpleListProperty<Group>();
		this.groupList.itemsProperty().bind(this.groupListProperty);
		this.groupListProperty.set(FXCollections.observableArrayList(groupListAux));
	}

	public void addGroup() {
		pt.iade.contact.Main.openAddGroupWindow();
	}

	/*
	 * TODO: editGroup method will open a new window and has to pass the selected data in current window:
	 * @param groupName -> String name = groupList.getSelectionModel().getSelectedItem().getName();
	 * The EditGroupWindow will then grab the passed name and will display possible editable info.
	 */
	public void editGroup() { // How to pass dat , segunda solução é fazer segunda janela e segundo
								// controlador
		pt.iade.contact.Main.openAddGroupWindow();
	}

	public void deleteGroup() {
		String name = groupList.getSelectionModel().getSelectedItem().getName();
		Main.facade.removeGroup(name);
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
		System.out.println("Groups Saved");
	}
}
