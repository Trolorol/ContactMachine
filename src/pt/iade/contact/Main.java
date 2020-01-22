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

/*
 * pt.iade.contact.model.EntitiesFacade.addContact("João Calapez", "910000001");
 * pt.iade.contact.model.EntitiesFacade.addContact("Joana Silva", "910000002");
 * pt.iade.contact.model.EntitiesFacade.addContact("José Silva", "910000003");
 * pt.iade.contact.model.EntitiesFacade.addGroup("Homens");
 * pt.iade.contact.model.EntitiesFacade.addGroup("Mulheres");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("910000001",
 * "Homens");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("910000002",
 * "Mulheres");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("910000003",
 * "Homens"); pt.iade.contact.model.EntitiesFacade.addTemplate("teste",
 * "Isto é assim porque é");
 * pt.iade.contact.model.EntitiesFacade.addTemplate("teste2",
 * "Isto é assim porque é2");
 * pt.iade.contact.model.EntitiesFacade.addTemplate("teste3",
 * "Isto é assim porque é3");
 * pt.iade.contact.model.EntitiesFacade.addTemplateToGroup("teste", "Homens");
 * pt.iade.contact.model.EntitiesFacade.addTemplateToGroup("teste2",
 * "Mulheres");
 * pt.iade.contact.model.EntitiesFacade.addTemplateToGroup("teste3", "Homens");
 * 
 * System.out.println(pt.iade.contact.model.EntitiesFacade.findGroup("Homens"));
 * 
 * 
 * 
 * 
 * System.out.println("**************** Contacts ****************");
 * 
 * pt.iade.contact.model.EntitiesFacade.addContact("João Calapez", "915311412");
 * pt.iade.contact.model.EntitiesFacade.addContact("Joana Silva", "910000002");
 * pt.iade.contact.model.EntitiesFacade.addContact("José Silva", "910000003");
 * 
 * 
 * Contact find = pt.iade.contact.model.EntitiesFacade.findContact("915311413");
 * System.out.println(find);
 * System.out.println("-----------------Contact-----------------");
 * 
 * 
 * System.out.println(pt.iade.contact.model.EntitiesFacade.showAllContacts());
 * 
 * 
 * System.out.println("-----------------Remove-----------------");
 * pt.iade.contact.model.EntitiesFacade.removeContact("910000003");
 * System.out.println(pt.iade.contact.model.EntitiesFacade.showAllContacts());
 * 
 * 
 * System.out.println("***************** Groups *****************");
 * pt.iade.contact.model.EntitiesFacade.addGroup("Homens");
 * pt.iade.contact.model.EntitiesFacade.addGroup("Mulheres");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("915311412",
 * "Homens");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("910000003",
 * "Homens");
 * pt.iade.contact.model.EntitiesFacade.addContactToGroup("910000002",
 * "Mulheres");
 * System.out.println(pt.iade.contact.model.EntitiesFacade.showAllGroups());
 * 
 * 
 * 
 * System.out.println("*************** Templates ****************");
 * 
 * pt.iade.contact.model.EntitiesFacade.addTemplate("teste",
 * "Isto é assim porque é");
 * pt.iade.contact.model.EntitiesFacade.addTemplateToGroup("teste", "Homens");
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
 * //pt.iade.contact.util.ServiceFacade.sendMessage("000", "+351915311412",
 * "O andre é gay");
 * 
 * 
 * }
 * 
 * }
 * 
 */

/*
 * Contact c1 = new Contact("João Calapez", 91531142); Contact c2 = new
 * Contact("João Calapez", 91531142); Contact c3 = new Contact("Rita Serra",
 * 916487855); Contact c4 = new Contact("Rita Sera", 916487855); // menos 1 r
 * Contact c5 = new Contact("Rita Serra", 916487885); // nome igual numero
 * diferente
 * 
 * Group g1 = new Group("Raparigas"); Group g2 = new Group("Rapazes");
 * 
 * Group g3 = new Group("Tudo");
 * 
 * GroupMessageTemplate t1 = new GroupMessageTemplate("Geral para Rapazes",
 * "Olá somos rapazes", g2); GroupMessageTemplate t2 = new
 * GroupMessageTemplate("Geral para Raparigas", "Olá somos raparigas", g1);
 * GroupMessageTemplate t3 = new GroupMessageTemplate("Geral para Rapazes",
 * "Olá somos rapazes", g2); //repetido em novo objeto GroupMessageTemplate t4 =
 * new GroupMessageTemplate("Geral para Raparigas", "Olá somos raparigas", g1);
 * //repetido em novo objeto GroupMessageTemplate t5 = new
 * GroupMessageTemplate("Geral para Rapaz", "Olá somos rapaz", g2); //conteudo
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
