package application.exec;

import entities.Contact;
import service.WhatsAppSenderHandler;

public class Main {

	public static void main(String[] args) {
		
		/******************************************************************/
		/*************************    Contacts    *************************/
		/******************************************************************/
		System.out.println("**************** Contacts ****************");
		/************************* Contact Creation *************************/
		entities.EntitiesFacade.addContact("Jo�o Calapez", "910000001");
		entities.EntitiesFacade.addContact("Ricardo Costa", "910000002");
		entities.EntitiesFacade.addContact("Jos� Silva", "910000003");
		
		/************************* Find contact *************************/
		Contact find = entities.EntitiesFacade.findContact("915311413");
		System.out.println(find);
		System.out.println("-----------------Contact-----------------");
		
		/************************* Show All Contacts *************************/
		System.out.println(entities.EntitiesFacade.showAllContacts());
		
		
		/************************* Remove Contact *************************/
		/*
		System.out.println("-----------------Remove-----------------");
		entities.EntitiesFacade.removeContact("910000003");
		System.out.println(entities.EntitiesFacade.showAllContacts());
		*/
		
		
		/******************************************************************/
		/*************************     Groups     *************************/
		/******************************************************************/
		System.out.println("***************** Groups *****************");
		/************************* Group Creation *************************/
		entities.EntitiesFacade.addGroup("Homens");
		entities.EntitiesFacade.addGroup("Mulheres");
		
		/************************* Group ShowAll *************************/
		System.out.println(entities.EntitiesFacade.showAllGroups());
		
		//!!!!!!!!!****FALTA O RESTANTE******!!!!!!!!!
	
		
		/************************* WhatsApp Sender Testes *************************/
		WhatsAppSenderHandler.init();
		System.out.println("***************************************");
		System.out.println("**************** Envio ****************");
		service.serviceFacade.sendMessage("000", "+351915311412", "Teste");
	
	}

}

/*
Contact c1 = new Contact("Jo�o Calapez", 91531142);
Contact c2 = new Contact("Jo�o Calapez", 91531142);
Contact c3 = new Contact("Rita Serra", 916487855);
Contact c4 = new Contact("Rita Sera", 916487855); // menos 1 r
Contact c5 = new Contact("Rita Serra", 916487885); // nome igual numero diferente 

Group g1 = new Group("Raparigas");
Group g2 = new Group("Rapazes");

Group g3 = new Group("Tudo");

GroupMessageTemplate t1 = new GroupMessageTemplate("Geral para Rapazes", "Ol� somos rapazes", g2);
GroupMessageTemplate t2 = new GroupMessageTemplate("Geral para Raparigas", "Ol� somos raparigas", g1);
GroupMessageTemplate t3 = new GroupMessageTemplate("Geral para Rapazes", "Ol� somos rapazes", g2); //repetido em novo objeto
GroupMessageTemplate t4 = new GroupMessageTemplate("Geral para Raparigas", "Ol� somos raparigas", g1); //repetido em novo objeto
GroupMessageTemplate t5 = new GroupMessageTemplate("Geral para Rapaz", "Ol� somos rapaz", g2); //conteudo diferente a t1

g1.addContact(c3);
g1.addContact(c4);
g1.addContact(c5);
g2.addContact(c1);

c3.addToGroup(g1);
c4.addToGroup(g1);
c5.addToGroup(g1);
c1.addToGroup(g2);
c1.addToGroup(g1);
c2.addToGroup(g2);

g1.addTemplate(t1);
g1.addTemplate(t2);



System.out.println("-----------------Contact-----------------");
System.out.println(c1);
System.out.println("------------------Group------------------");
System.out.println(g1);
System.out.println("----------------Template-----------------");
System.out.println(t1);
System.out.println(t2);
*/
