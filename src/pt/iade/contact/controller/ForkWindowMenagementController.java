package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ForkWindowMenagementController {

	@FXML
	private Button groups;

	@FXML
	private Button contacts;

	@FXML
	private Button cancel;

	public void openGroupsBt() {
		pt.iade.contact.Main.openGroupManagementWindow();
	}

	public void openContactsBt() {
		pt.iade.contact.Main.openContactManagementWindow();

	}

	public void cancel() {
		pt.iade.contact.Main.openMainWindow();

	}

}
