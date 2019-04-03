
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AplicativoBot {
	public static void main(String[] args) {
		

		ApiContextInitializer.init();
		
		TelegramBotsApi imc_pessoa_bot = new TelegramBotsApi();
		
		try {
			imc_pessoa_bot.registerBot(new ImcBot());
		} catch ( TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
	


