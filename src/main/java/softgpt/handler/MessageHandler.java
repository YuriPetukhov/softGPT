package softgpt.handler;

import java.io.IOException;

public interface MessageHandler {

    void sendWelcomeMessage(String firstName, Long chatId);

    void sendAboutMessage(String firstName, Long chatId);

    void sendInfoMessage(String firstName, String lastName, Long chatId);

    void sendTariffsMessage(Long chatId);

    void sendBenefitsMessage(Long chatId);

    void sendConsultMessage(Long chatId);

    void sendDefaultMessage(Long chatId);

    void sendCommandList(Long chatId);

    void sendUltraImageMessage(Long chatId);

    void sendStandardImageMessage(Long chatId);

    void sendEconomyImageMessage(Long chatId);

    void sendSafetyMessage(Long chatId);

    void sendReferralProgramImageMessage(Long chatId);
}
