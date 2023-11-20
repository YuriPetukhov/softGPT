package softgpt.handler.impl;

import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.request.SendVideo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.configuration.SoftGPTConfiguration;
import softgpt.handler.MessageHandler;
import softgpt.sender.MessageSender;
import softgpt.utils.KeyboardCreator;
import softgpt.utils.MediaMessageGenerator;

import static com.pengrad.telegrambot.model.request.ParseMode.HTML;

@RequiredArgsConstructor
@Service
@Slf4j  // SLF4J logging
public class MessageHandlerImpl implements MessageHandler {

    private final MessageSender messageSender;
    private final KeyboardCreator keyboardCreator;
    private final MediaMessageGenerator mediaMessageGenerator;
    private final SoftGPTConfiguration config;

    @Override
    public void sendWelcomeMessage(String firstName, Long chatId) {
        log.info("Sending welcome message to {}: {}", firstName, chatId);
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.welcomeMessagePhotoCreate(chatId, firstName);
            messageSender.sendImageMessage(sendPhoto);
            SendVideo sendVideo = mediaMessageGenerator.welcomeMessageVideoCreate(chatId);
            messageSender.sendVideo(sendVideo);
        } catch (Exception e) {
            log.error("Failed to send welcome message to {}: {}", firstName, chatId, e);
        }
    }

    @Override
    public void sendAboutMessage(String firstName, Long chatId) {
        log.info("Sending about message to {}: {}", firstName, chatId);
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.aboutMessagePhotoCreate(chatId);
            messageSender.sendImageMessage(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send about message to {}: {}", firstName, chatId, e);
        }
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }

    public void sendInfoMessage(String firstName, String lastName, Long chatId) {
        log.info("Sending info message to {}: {}", firstName, chatId);
        try {
            SendDocument sendDocument = mediaMessageGenerator.infoMessageDocumentCreate(chatId);
            messageSender.sendDocument(chatId, sendDocument);
        } catch (Exception e) {
            log.error("Failed to send info message to {}: {}", firstName, chatId, e);
        }
    }

    @Override
    public void sendTariffsMessage(Long chatId) {
        log.info("Sending tariffs message to {}", chatId);
        SendMessage message = new SendMessage(
                chatId,
                config.getTARIFF_MES()).parseMode(HTML);
        message.replyMarkup(keyboardCreator.tariffsMessageKeyboard());
        messageSender.executeMessage(message);
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }

    @Override
    public void sendBenefitsMessage(Long chatId) {
        log.info("Sending about benefits  to {}", chatId);
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.benefitsMessagePhotoCreate(chatId);
            messageSender.sendImageMessage(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send benefits message to {}", chatId, e);
        }
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }

    public void sendConsultMessage(Long chatId) {
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.consultMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send consult message to {}", chatId, e);
        }
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }

    @Override
    public void sendDefaultMessage(Long chatId) {
        log.info("Sending about message to {}", chatId);
        messageSender.sendHTMLMessage(chatId, String.format(config.getDEFAULT_MES(), chatId));
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());

    }

    @Override
    public void sendCommandList(Long chatId) {
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.commandListMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send command list message to {}", chatId, e);;;
        }
    }
    @Override
    public void sendUltraImageMessage(Long chatId) {
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.ultraMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
            messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
        } catch (Exception e) {
            log.error("Failed to send ultra image message to {}", chatId, e);;;
        }
    }
    @Override
    public void sendStandardImageMessage(Long chatId) {
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.standardMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
            messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
        } catch (Exception e) {
            log.error("Failed to send standard image message to {}", chatId, e);;;
        }
    }
    @Override
    public void sendEconomyImageMessage(Long chatId) {
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.economyMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
            messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
        } catch (Exception e) {
            log.error("Failed to send economy image message to {}", chatId, e);;;
        }
    }
    @Override
    public void sendSafetyMessage(Long chatId) {
        log.info("Sending safety message  to {}", chatId);
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.safetyMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send safety message to {}", chatId, e);;;
        }
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }

    @Override
    public void sendReferralProgramImageMessage(Long chatId) {
        log.info("Sending referral program message to {}", chatId);
        try {
            SendPhoto sendPhoto = mediaMessageGenerator.refProMessagePhotoCreate(chatId);
            messageSender.sendImageMessageStart(sendPhoto);
        } catch (Exception e) {
            log.error("Failed to send referral program message to {}", chatId, e);;;
        }
        messageSender.sendHTMLMessage(chatId, config.getBACK_MES());
    }
}