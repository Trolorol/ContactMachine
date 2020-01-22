package pt.iade.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pt.iade.contact.model.EntitiesFacade;

public class Main extends Application {

	private static Stage mainStage;
	public static EntitiesFacade facade;

	@Override
	public void start(Stage stage) {

		mainStage = stage;
		Scene scene = new Scene(new Pane());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		openMainWindow();
		// openAddContactWindow();
		mainStage.show();
	}

	public static void main(String[] args) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("./data/state.dat"));
			facade = (EntitiesFacade) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		launch(args);
	}

// TODO: Set base path as constant in class
	public static void openMainWindow() {
		String urlStr = "view/MainWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openforkWindow() {
		String urlStr = "view/ForkMenagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openContactManagementWindow() {
		String urlStr = "view/ContactsManagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openAddContactWindow() {
		String urlStr = "view/AddContactWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openGroupManagementWindow() {
		String urlStr = "view/GroupsManagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openAddGroupWindow() {
		String urlStr = "view/AddGroupWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openconfirmWindow() {
		String urlStr = "view/ConfirmWindow.fxml";
		windowChanger(urlStr);
	}
	
	public static void openAddTemplateWindow() {
		String urlStr = "view/AddTemplateWindow.fxml";
		windowChanger(urlStr);
	}

	private static void windowChanger(String urlStr) {
		try {
			URL path = Main.class.getResource(urlStr);
			FXMLLoader loader = new FXMLLoader(path);
			Parent root = loader.load();
			mainStage.getScene().setRoot(root);
			mainStage.sizeToScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


