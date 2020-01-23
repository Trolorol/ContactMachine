package pt.iade.contact;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import pt.iade.contact.model.EntitiesFacade;
import pt.iade.contact.util.WhatsAppSenderHandler;

public class TestMain {

	public static void main(String[] args) {
		
		WhatsAppSenderHandler.init();
		EntitiesFacade ef = new EntitiesFacade();
		pt.iade.contact.util.ServiceFacade.sendMessage("915311412", "Ola");
		//Esta merda funcionava.......
		// KEKSIMUS MAXIMUS
		// Ideias?
		
		System.out.println(ef.showAllTemplates());
		System.out.println(ef.showAllContacts());
		System.out.println(ef.showAllGroups());
		/*
		ef.addContact("João Calapez", "910000001");
		ef.addContact("Joana Silva", "910000002");
		ef.addContact("José Silva", "910000003");
		ef.addGroup("Homens");
		ef.addGroup("Mulheres");
		ef.addContactToGroup("910000001", "Homens");
		ef.addContactToGroup("910000002", "Mulheres");
		ef.addContactToGroup("910000003", "Homens");
		ef.addTemplate("teste", "Isto é assim porque é");
		ef.addTemplate("teste2", "Isto é assim porque é2");
		ef.addTemplate("teste3", "Isto é assim porque é3");
		ef.addTemplateToGroup("teste", "Homens");
		ef.addTemplateToGroup("teste2", "Mulheres");
		//System.out.println(ef.showAllTemplates());
		ef.editTemplate("teste", "NewTitle", "LOLE");
		System.out.println(ef.showAllGroups());
		System.out.println(ef.showAllContacts());
		ef.removeContact("910000003");
		System.out.println("#######");
		System.out.println(ef.showAllGroups());
		System.out.println(ef.showAllContacts());
		*/
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
