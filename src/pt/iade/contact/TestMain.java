package pt.iade.contact;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import pt.iade.contact.model.EntitiesFacade;

public class TestMain {

	public static void main(String[] args) {
		
		EntitiesFacade ef = new EntitiesFacade();

		ef.addContact("Jo�o Calapez", "910000001");
		ef.addContact("Joana Silva", "910000002");
		ef.addContact("Jos� Silva", "910000003");
		ef.addGroup("Homens");
		ef.addGroup("Mulheres");
		ef.addContactToGroup("910000001", "Homens");
		ef.addContactToGroup("910000002", "Mulheres");
		ef.addContactToGroup("910000003", "Homens");
		ef.addTemplate("teste", "Isto � assim porque �");
		ef.addTemplate("teste2", "Isto � assim porque �2");
		ef.addTemplate("teste3", "Isto � assim porque �3");
		ef.addTemplateToGroup("teste", "Homens");
		ef.addTemplateToGroup("teste2", "Mulheres");
		System.out.println(ef.showAllTemplates());
		ef.editTemplate("teste", "NewTitle", "LOLE");
		System.out.println(ef.showAllTemplates());

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"/data/state.dat"));
			oos.writeObject(ef);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
