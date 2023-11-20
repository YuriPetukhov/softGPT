package softgpt.handler;

public interface Handler {
    void handle(String callbackData, String firstName, String lastName, Long chatId);
}
