package service;

public class serviceFacade {
	
	public static void sendMessage(String FromNumber, String toNumber, String finalMessage) {
		WhatsAppSenderHandler.sendText(FromNumber, toNumber, finalMessage);
	}

}
