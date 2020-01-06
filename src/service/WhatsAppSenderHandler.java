package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppSenderHandler {

	// Find your Account Sid and Token at twilio.com/user/account
	private static String ACCOUNT_SID = "";
	private static String AUTH_TOKEN = "";

	public static void init() {

		
		String filePath = "C:\\Users\\coelh\\Documents\\twilioAPI.txt";

		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));

			String APIstr = contentBuilder.toString();

			String[] tempString;
			String delimiter = " ";

			tempString = APIstr.split(delimiter);
			ACCOUNT_SID = tempString[0].substring(0,34);
			AUTH_TOKEN = tempString[1].substring(0,32);
			
			System.out.println("Using: \n SID: " + "|" + ACCOUNT_SID + "|" + "\n" + "AUTH: " + "|" + AUTH_TOKEN.substring(0,32) + "|");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// service.serviceFacade.sendMessage("+1 415 523 8886", "+351915311412");

	static void sendText(String fromNumber, String toNumber, String finalMessage) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		System.out.println(ACCOUNT_SID);
		System.out.println(AUTH_TOKEN);

		fromNumber = "whatsapp:+14155238886";
		toNumber = "whatsapp:" + toNumber;

		System.out.println("To: " + toNumber + "\nFrom: " + fromNumber);

		Message message = Message.creator(new com.twilio.type.PhoneNumber(toNumber),
				new com.twilio.type.PhoneNumber(fromNumber), finalMessage).create();

		System.out.println(message.getSid());
	}
}

/*
 * new com.twilio.type.PhoneNumber("whatsapp:+15005550006"), new
 * com.twilio.type.PhoneNumber("whatsapp:+14155238886")
 */
