package pt.iade.contact.util;

public class ServiceFacade {

	public static void sendMessage(String toNumber, String finalMessage) {
		WhatsAppSenderHandler.sendText(toNumber, finalMessage);
	}
}
