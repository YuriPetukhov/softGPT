package softgpt.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import com.pengrad.telegrambot.request.SetMyCommands;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static softgpt.enums.Commands.*;

@Configuration
@Getter
public class SoftGPTConfiguration {
    @Value("${softgpt.bot.token}")
    private String token;
    @Value("${START-MES}")
    private String START_MES;
    @Value("${BACK_MES}")
    private String BACK_MES;
    @Value("${ABOUT_MES}")
    private String ABOUT_MES;
    @Value("${TARIFF_MES}")
    private String TARIFF_MES;
    @Value("${WELCOME_MES}")
    private String WELCOME_MES;
    @Value("${TARIFF_EXTENT_MES}")
    private String TARIFF_EXTENT_MES;
    @Value("${BENEFITS_MES}")
    private String BENEFITS_MES;
    @Value("${SAFETY_MES}")
    private String SAFETY_MES;
    @Value("${CONSULT_MES}")
    private String CONSULT_MES;
    @Value("${CONTACT_MES}")
    private String CONTACT_MES;
    @Value("${DEFAULT_MES}")
    private String DEFAULT_MES;
    @Value("${REF_PRO_MES}")
    private String REF_PRO_MES;

    @Value("${CONSULT_LINK_IMG}")
    private String CONSULT_LINK_IMG;
    @Value("${ULTRA_TAR_IMG}")
    private String ULTRA_TAR_IMG;
    @Value("${STANDARD_TAR_IMG}")
    private String STANDARD_TAR_IMG;
    @Value("${ECONOMY_TAR_IMG}")
    private String ECONOMY_TAR_IMG;

    @Value("${ULTRA_BUT}")
    private String ULTRA_BUT;
    @Value("${STANDARD_BUT}")
    private String STANDARD_BUT;
    @Value("${ECONOMY_BUT}")
    private String ECONOMY_BUT;
    @Value("${REF_PRO_BUT}")
    private String REF_PRO_BUT;

    @Value("${START_DESC}")
    private String START_DESC;
    @Value("${ABOUT_DESC}")
    private String ABOUT_DESC;
    @Value("${INFO_DESC}")
    private String INFO_DESC;
    @Value("${TARIFFS_DESC}")
    private String TARIFFS_DESC;
    @Value("${BENEFITS_DESC}")
    private String BENEFITS_DESC;
    @Value("${SAFETY_DESC}")
    private String SAFETY_DESC;
    @Value("${CONSULT_DESC}")
    private String CONSULT_DESC;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        bot.execute(new SetMyCommands(
                new BotCommand(START.getName(), START_DESC),
                new BotCommand(ABOUT.getName(), ABOUT_DESC),
                new BotCommand(INFO.getName(), INFO_DESC),
                new BotCommand(TARIFFS.getName(), TARIFFS_DESC),
                new BotCommand(BENEFITS.getName(), BENEFITS_DESC),
                new BotCommand(SAFETY.getName(), SAFETY_DESC),
                new BotCommand(CONSULT.getName(), CONSULT_DESC)
        ));
        return bot;
    }
}