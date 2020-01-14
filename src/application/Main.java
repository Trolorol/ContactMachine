package application;

import java.io.IOException;

import entities.Contact;
import entities.EntitiesFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.WhatsAppSenderHandler;

public class Main extends Application {

	
	private static Stage mainStage;

	
	
	@Override
	public void start(Stage stage) {
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/MainWindow.fxml")); // class Parent é uma
																								// superClass da class
																								// AnchorPane
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}

	public static void openforkWindow() {

	}

	public static void openContactManagementWindow() {

	}

	public static void openAddContactWindow() {

	}

	public static void openGroupManagementWindow() {

	}

	public static void openAddGroupWindow() {

	}

	public static void openconfirmWindow() {

	}

}

/*
 * 
 * System.out.println("**************** Contacts ****************");
 * 
 * entities.EntitiesFacade.addContact("João Calapez", "915311412");
 * entities.EntitiesFacade.addContact("Joana Silva", "910000002");
 * entities.EntitiesFacade.addContact("José Silva", "910000003");
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
 * entities.EntitiesFacade.addTemplate("teste", "Isto é assim porque é");
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
 * //service.ServiceFacade.sendMessage("000", "+351915311412", "O andre é gay");
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
