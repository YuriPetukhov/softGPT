package softgpt.handler.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.handler.Handler;
import softgpt.handler.MessageHandler;
import softgpt.utils.KeyboardCreator;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static softgpt.enums.CallbackData.*;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j  // SLF4J logging
public class ButtonHandler implements Handler {
    private final MessageHandler messageHandler;
    private final KeyboardCreator keyboardCreator;

    @FunctionalInterface
    interface Button {
        void run(String firstName, String lastName, Long chatId);
    }

    Map<String, Button> battonMap = new HashMap<>();
    Map<String, Button> adminBattonMap = new HashMap<>();

    @PostConstruct
    public void init() {

        battonMap.put(ULTRA_BUT.getText(), (firstName, lastName, chatId) -> {
            log.info("Pressed ULTRA button");
            messageHandler.sendUltraImageMessage(chatId);
        });
        battonMap.put(STANDARD_BUT.getText(), (firstName, lastName, chatId) -> {
            log.info("Pressed STANDARD button");
            messageHandler.sendStandardImageMessage(chatId);
        });
        battonMap.put(ECONOMY_BUT.getText(), (firstName, lastName, chatId) -> {
            log.info("Pressed ECONOMY button");
            messageHandler.sendEconomyImageMessage(chatId);
        });
        battonMap.put(REF_PRO_BUT.getText(), (firstName, lastName, chatId) -> {
            log.info("Pressed REF_PRO button");
            messageHandler.sendReferralProgramImageMessage(chatId);
        });
    }
    @Override
    public void handle(String callbackData, String firstName, String lastName, Long chatId) {
        Button commandToRun = adminBattonMap.get(callbackData.toLowerCase());
        if (commandToRun == null) {
            commandToRun = battonMap.get(callbackData.toLowerCase());
        }
        if (commandToRun != null) {
            commandToRun.run(firstName, lastName, chatId);
        } else {
            log.warn("No handler found for button: {}", callbackData);
            messageHandler.sendDefaultMessage(chatId);
        }
    }

}
