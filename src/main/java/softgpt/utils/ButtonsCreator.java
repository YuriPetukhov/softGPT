package softgpt.utils;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.entity.Buttons;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j  // SLF4J logging
public class ButtonsCreator {

    public InlineKeyboardMarkup sendWithInlineKeyboard(List<Buttons> buttonsNames) {

        List<InlineKeyboardButton> firstRowButtons = new ArrayList<>();
        List<InlineKeyboardButton> secondRowButtons = new ArrayList<>();
        int count = 0;
        for (Buttons buttonsName : buttonsNames) {
            if (count < 3) {
                String callbackData = buttonsName.getCallbackData();
                String buttonName = buttonsName.getName();
                InlineKeyboardButton button = new InlineKeyboardButton(buttonName).callbackData(callbackData);
                firstRowButtons.add(button);
            } else {
                String callbackData = buttonsName.getCallbackData();
                String buttonName = buttonsName.getName();
                InlineKeyboardButton button = new InlineKeyboardButton(buttonName).callbackData(callbackData);
                secondRowButtons.add(button);
            }
            count++;
        }

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstRowButtons.toArray(new InlineKeyboardButton[0]));
        inlineKeyboardMarkup.addRow(secondRowButtons.toArray(new InlineKeyboardButton[0]));
        log.info("Keyboard was set for four buttons");
        return inlineKeyboardMarkup;

    }
}