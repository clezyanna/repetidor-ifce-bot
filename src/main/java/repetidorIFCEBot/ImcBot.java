

import java.text.NumberFormat;
import java.util.Locale;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ImcBot extends TelegramLongPollingBot {
	 
	public void onUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()) {
			Message msg = update.getMessage();
			
			SendMessage sm1 = new SendMessage();
			sm1.setChatId(update.getMessage().getChatId());
			
			
			String dado = msg.getText();
			String[] result = dado.split(" ");
			
			int altura = Integer.parseInt(result[0]);
			Double peso = Double.parseDouble(result[1]);
			
			Locale local= new Locale("pt","br");
			NumberFormat format = NumberFormat.getCurrencyInstance(local);
			
			
			
			double imc =(peso / (altura * altura));
			
			imc*=10000;
		
			
			if(imc < 18.5) {
				sm1.setText("Abaixo do Peso se cuide! \nSeu IMC: " + format.format(imc));
			} else if(imc >= 18.5 && imc <= 24.9) {
				sm1.setText("Parabéns você esta com o Peso Normal! \nSeu IMC: " +format.format(imc));
			} else if(imc >= 25 && imc <= 29.9) {
				sm1.setText(" Sobrepeso se cuida! \nSeu IMC: " + format.format(imc));
			} else {
				sm1.setText("Obeso! \nSeu IMC: " + format.format(imc));
			}
			
			try {
				execute(sm1);
			} catch (TelegramApiException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	public String getBotUsername() {
		
		return "imc_pessoa_bot";
	}

	public String getBotToken() {
		
		return "735490422:AAG17QcGGsk2FZbUT8UolKOOcbHpCqBk5HE";
	}

	
}
	


