package service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppSenderHandler {

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "";
	public static final String AUTH_TOKEN = "";

	//service.serviceFacade.sendMessage("+1 415 523 8886", "+351915311412");
	
	
	static void sendText(String fromNumber, String toNumber, String finalMessage) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		fromNumber = "whatsapp:+14155238886";
		toNumber = "whatsapp:"+toNumber;
		
		System.out.println("To: " + toNumber + "\nFrom: " + fromNumber);
		
		
		Message message = Message.creator(
                new com.twilio.type.PhoneNumber(toNumber),
                new com.twilio.type.PhoneNumber(fromNumber),
                finalMessage)
            .create();

        System.out.println(message.getSid());
	}
}


/*
new com.twilio.type.PhoneNumber("whatsapp:+15005550006"),
new com.twilio.type.PhoneNumber("whatsapp:+14155238886")
*/

