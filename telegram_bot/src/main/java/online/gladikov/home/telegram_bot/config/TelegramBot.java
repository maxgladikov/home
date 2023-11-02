//package online.gladikov.home.telegram_bot.config;
//
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@Component
////@RequiredArgsConstructor
//@AllArgsConstructor
//public class TelegramBot extends TelegramLongPollingBot {
//	private final BotConfig botConfig;
//
//	@Override
//	public String getBotUsername() {
//		return botConfig.getBotName();
//	}
//
//	@Override
//	public String getBotToken() {
//		return botConfig.getToken();
//	}
//
//	@Override
//	public void onUpdateReceived(Update update) {
//		try {
//			if (update.hasMessage() && update.getMessage().hasText()) {
//				String messageText = update.getMessage().getText();
//				long chatId = update.getMessage().getChatId();
//				SendMessage outMess = new SendMessage();
//
//                //Добавляем в наше сообщение id чата а также наш ответ
//                outMess.setChatId(chatId);
//                outMess.setText("Petux");
//                
//                //Отправка в чат
//                execute(outMess);
//			}
//		} catch (TelegramApiException e) {
//			e.printStackTrace();
//		}
//	}
//}