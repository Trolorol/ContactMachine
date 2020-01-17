package application;

import java.net.URL;

import entities.Contact;
import entities.EntitiesFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage mainStage;

	@Override
	public void start(Stage stage) {

		mainStage = stage;
		Scene scene = new Scene(new Pane());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		openMainWindow();
		//openAddContactWindow();
		mainStage.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

	public static void openMainWindow() {
		String urlStr = "../views/MainWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openforkWindow() {
		String urlStr = "../views/ForkMenagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openContactManagementWindow() {
		String urlStr = "../views/ContactsManagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openAddContactWindow() {
		String urlStr = "/views/AddContactWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openGroupManagementWindow() {
		String urlStr = "../views/GroupsManagementWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openAddGroupWindow() {
		String urlStr = "../views/AddGroupWindow.fxml";
		windowChanger(urlStr);
	}

	public static void openconfirmWindow() {
		String urlStr = "../views/ConfirmWindow.fxml"; 
		windowChanger(urlStr);
	}

	private static void windowChanger(String urlStr) {
		try {
			URL path = Main.class.getResource(urlStr);
			System.out.println(path);
			System.out.println(urlStr);
			FXMLLoader loader = new FXMLLoader(path);
			Parent root = loader.load();
			mainStage.getScene().setRoot(root);
			mainStage.sizeToScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * 
 * System.out.println("**************** Contacts ****************");
 * 
 * entities.EntitiesFacade.addContact("Jo�o Calapez", "915311412");
 * entities.EntitiesFacade.addContact("Joana Silva", "910000002");
 * entities.EntitiesFacade.addContact("Jos� Silva", "910000003");
 * 
 * 
 * Contact find = entities.EntitiesFacade.findContact("915311413");
 * System.out.println(find);
 * System.out.println("-----------------Contact-----------------");
 * 
 * 
 * System.out.println(entities.EntitiesFacade.showAllContacts());
 * 
 * 
 * System.out.println("-----------------Remove-----------------");
 * entities.EntitiesFacade.removeContact("910000003");
 * System.out.println(entities.EntitiesFacade.showAllContacts());
 * 
 * 
 * System.out.println("***************** Groups *****************");
 * entities.EntitiesFacade.addGroup("Homens");
 * entities.EntitiesFacade.addGroup("Mulheres");
 * entities.EntitiesFacade.addContactToGroup("915311412", "Homens");
 * entities.EntitiesFacade.addContactToGroup("910000003", "Homens");
 * entities.EntitiesFacade.addContactToGroup("910000002", "Mulheres");
 * System.out.println(entities.EntitiesFacade.showAllGroups());
 * 
 * 
 * 
 * System.out.println("*************** Templates ****************");
 * 
 * entities.EntitiesFacade.addTemplate("teste", "Isto � assim porque �");
 * entities.EntitiesFacade.addTemplateToGroup("teste", "Homens");
 * 
 * 
 * System.out.println("###########################");
 * System.out.println(EntitiesFacade.showAllGroups());
 * System.out.println(EntitiesFacade.showAllContacts());
 * System.out.println("###########################");
 * 
 * 
 * WhatsAppSenderHandler.init();
 * System.out.println("***************************************");
 * System.out.println("**************** Envio ****************");
 * //service.ServiceFacade.sendMessage("000", "+351915311412", "O andre � gay");
 * 
 * 
 * }
 * 
 * }
 * 
 */

/*
 * Contact c1 = new Contact("Jo�o Calapez", 91531142); Contact c2 = new
 * Contact("Jo�o Calapez", 91531142); Contact c3 = new Contact("Rita Serra",
 * 916487855); Contact c4 = new Contact("Rita Sera", 916487855); // menos 1 r
 * Contact c5 = new Contact("Rita Serra", 916487885); // nome igual numero
 * diferente
 * 
 * Group g1 = new Group("Raparigas"); Group g2 = new Group("Rapazes");
 * 
 * Group g3 = new Group("Tudo");
 * 
 * GroupMessageTemplate t1 = new GroupMessageTemplate("Geral para Rapazes",
 * "Ol� somos rapazes", g2); GroupMessageTemplate t2 = new
 * GroupMessageTemplate("Geral para Raparigas", "Ol� somos raparigas", g1);
 * GroupMessageTemplate t3 = new GroupMessageTemplate("Geral para Rapazes",
 * "Ol� somos rapazes", g2); //repetido em novo objeto GroupMessageTemplate t4 =
 * new GroupMessageTemplate("Geral para Raparigas", "Ol� somos raparigas", g1);
 * //repetido em novo objeto GroupMessageTemplate t5 = new
 * GroupMessageTemplate("Geral para Rapaz", "Ol� somos rapaz", g2); //conteudo
 * diferente a t1
 * 
 * g1.addContact(c3); g1.addContact(c4); g1.addContact(c5); g2.addContact(c1);
 * 
 * c3.addToGroup(g1); c4.addToGroup(g1); c5.addToGroup(g1); c1.addToGroup(g2);
 * c1.addToGroup(g1); c2.addToGroup(g2);
 * 
 * g1.addTemplate(t1); g1.addTemplate(t2);
 * 
 * 
 * 
 * System.out.println("-----------------Contact-----------------");
 * System.out.println(c1);
 * System.out.println("------------------Group------------------");
 * System.out.println(g1);
 * System.out.println("----------------Template-----------------");
 * System.out.println(t1); System.out.println(t2);
 */
