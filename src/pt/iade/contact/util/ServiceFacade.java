package pt.iade.contact.util;

public class ServiceFacade {

	public static void sendMessage(String FromNumber, String toNumber, String finalMessage) {
		WhatsAppSenderHandler.sendText(FromNumber, toNumber, finalMessage);
	}
}
