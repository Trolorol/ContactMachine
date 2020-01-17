package guiController;

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
		application.Main.openGroupManagementWindow();
	}

	public void openContactsBt() {
		application.Main.openContactManagementWindow();

	}

	public void cancel() {
		application.Main.openMainWindow();

	}

}
