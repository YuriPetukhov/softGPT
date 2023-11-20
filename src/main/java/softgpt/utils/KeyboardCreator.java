package softgpt.utils;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.configuration.SoftGPTConfiguration;
import softgpt.entity.Buttons;

import java.util.ArrayList;
import java.util.List;

import static softgpt.enums.CallbackData.*;

@Service
@RequiredArgsConstructor
@Slf4j  // SLF4J logging
public class KeyboardCreator {

    private final ButtonsCreator buttonsCreator;
    private final SoftGPTConfiguration config;

    public InlineKeyboardMarkup tariffsMessageKeyboard() {
        log.info("Creating keyboard markup for tariffs");

        List<Buttons> buttons = new ArrayList<>();
        buttons.add(new Buttons(config.getULTRA_BUT(), ULTRA_BUT.getText()));
        buttons.add(new Buttons(config.getSTANDARD_BUT(), STANDARD_BUT.getText()));
        buttons.add(new Buttons(config.getECONOMY_BUT(), ECONOMY_BUT.getText()));
        buttons.add(new Buttons(config.getREF_PRO_BUT(), REF_PRO_BUT.getText()));
        return buttonsCreator.sendWithInlineKeyboard(buttons);
    }
}
