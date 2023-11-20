package softgpt.handler.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.handler.Handler;
import softgpt.handler.MessageHandler;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static softgpt.enums.Commands.*;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j  // SLF4J logging
public class CommandHandler implements Handler {
    private final MessageHandler messageHandler;
    @FunctionalInterface
    interface Command {
        void run(String firstName, String lastName, Long chatId);
    }

    Map<String, Command> commandMap = new HashMap<>();

    @PostConstruct
    public void init() {
        commandMap.put(START.getName(), (firstName, lastName, chatId) -> {
            log.info("Received START command");
            messageHandler.sendWelcomeMessage(firstName, chatId);
        });
        commandMap.put(ABOUT.getName(), (firstName, lastName, chatId) -> {
            log.info("Received ABOUT command");
            messageHandler.sendAboutMessage(firstName, chatId);
        });
        commandMap.put(INFO.getName(), (firstName, lastName, chatId) -> {
            log.info("Received INFO command");
            messageHandler.sendInfoMessage(firstName, lastName, chatId);
        });
        commandMap.put(TARIFFS.getName(), (firstName, lastName, chatId) -> {
            log.info("Received TARIFFS command");
            messageHandler.sendTariffsMessage(chatId);
        });
        commandMap.put(BENEFITS.getName(), (firstName, lastName, chatId) -> {
            log.info("Received BENEFITS command");
            messageHandler.sendBenefitsMessage(chatId);
        });
        commandMap.put(SAFETY.getName(), (firstName, lastName, chatId) -> {
            log.info("Received SAFETY command");
            messageHandler.sendSafetyMessage(chatId);
        });
        commandMap.put(CONSULT.getName(), (firstName, lastName, chatId) -> {
            log.info("Received CONSULT command");
            messageHandler.sendConsultMessage(chatId);
        });
        commandMap.put(BACK.getName(), (firstName, lastName, chatId) -> {
            log.info("Received BACK command");
            messageHandler.sendCommandList(chatId);
        });

    }
    @Override
    public void handle(String command, String firstName, String lastName, Long chatId) {
        Command commandToRun = commandMap.get(command.toLowerCase());
        if (commandToRun != null) {
            commandToRun.run(firstName, lastName, chatId);
        } else {
            log.warn("No handler found for command: {}", command);
            messageHandler.sendDefaultMessage(chatId);
        }
    }
}
