package by.resliv.cityexplorerbot.bot;

import by.resliv.cityexplorercore.bean.City;
import by.resliv.cityexplorercore.exception.CityNotFoundException;
import by.resliv.cityexplorercore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@PropertySource("classpath:bot.properties")
public class CityExplorerBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    private CityService cityService;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            sendCityDescription(update);
        }
    }

    private void sendCityDescription(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(getCityDescription(update.getMessage().getText()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String getCityDescription(String cityName){
        try {
            City city = cityService.findByName(cityName);
            return city.getDescription();
        } catch (CityNotFoundException exception){
            return "К сожалению, такой город не найден.";
        }
    }

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }
}
