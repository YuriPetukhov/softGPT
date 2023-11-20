package softgpt.utils;

import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.request.SendVideo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softgpt.configuration.SoftGPTConfiguration;
import softgpt.entity.MediaMessageParams;

import java.io.IOException;

import static softgpt.enums.DocumentNames.ABOUT_DOC;
import static softgpt.enums.ImageNames.*;
import static softgpt.enums.VideoNames.WELCOME_VIDEO;

@Service
@RequiredArgsConstructor
@Slf4j  // SLF4J logging
public class MediaMessageGenerator {

    private final MediaLoader mediaLoader;
    private final SoftGPTConfiguration config;

    public SendPhoto createPhotoMessage(MediaMessageParams params) throws IOException {
        return mediaLoader.imageCreator(params.getChatId(), params.getFilePath(), params.getCaption());
    }

    public SendVideo createVideoMessage(MediaMessageParams params) throws IOException {
        return mediaLoader.videoCreator(params.getChatId(), params.getFilePath(), params.getFileName());
    }

    public SendDocument createDocumentMessage(MediaMessageParams params) throws IOException {
        return mediaLoader.documentCreator(params.getChatId(), params.getFilePath(), params.getFileName());
    }

    public SendPhoto welcomeMessagePhotoCreate(long chatId, String firstName) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(WELCOME_IMG.getPath());
        params.setCaption(String.format(config.getWELCOME_MES(), firstName));
        return createPhotoMessage(params);
    }

    public SendPhoto aboutMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(ABOUT_IMG.getPath());
        params.setCaption(config.getABOUT_MES());
        return createPhotoMessage(params);
    }

    public SendPhoto benefitsMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(BENEFITS_IMG.getPath());
        params.setCaption(config.getBENEFITS_MES());
        return createPhotoMessage(params);
    }

    public SendPhoto consultMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(CONTACT_IMG.getPath());
        params.setCaption(String.format(config.getCONTACT_MES(), config.getCONSULT_LINK_IMG()));
        return createPhotoMessage(params);
    }

    public SendPhoto commandListMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(START_IMG.getPath());
        params.setCaption(config.getSTART_MES());
        return createPhotoMessage(params);
    }

    public SendPhoto ultraMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(ULTRA_IMG.getPath());
        params.setCaption(config.getULTRA_TAR_IMG());
        return createPhotoMessage(params);
    }

    public SendPhoto standardMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(STANDARD_IMG.getPath());
        params.setCaption(config.getSTANDARD_TAR_IMG());
        return createPhotoMessage(params);
    }

    public SendPhoto economyMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(ECONOMY_IMG.getPath());
        params.setCaption(config.getECONOMY_TAR_IMG());
        return createPhotoMessage(params);
    }

    public SendPhoto safetyMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(SAFETY_IMG.getPath());
        params.setCaption(config.getSAFETY_MES());
        return createPhotoMessage(params);
    }

    public SendVideo welcomeMessageVideoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(WELCOME_VIDEO.getPath());
        params.setFileName(WELCOME_VIDEO.getName());
        return createVideoMessage(params);
    }

    public SendDocument infoMessageDocumentCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(ABOUT_DOC.getPath());
        params.setFileName(ABOUT_DOC.getName());
        return createDocumentMessage(params);
    }

    public SendPhoto refProMessagePhotoCreate(Long chatId) throws IOException {
        MediaMessageParams params = new MediaMessageParams();
        params.setChatId(chatId);
        params.setFilePath(REF_PRO_IMG.getPath());
        params.setCaption(config.getREF_PRO_MES());
        return createPhotoMessage(params);
    }
}
