package softgpt.enums;

import lombok.Getter;

@Getter
public enum CallbackData {

    ULTRA_BUT("ultra_but"),
    STANDARD_BUT("standard_but"),
    ECONOMY_BUT("economy_but"),
    REF_PRO_BUT("referral_program");

   private final String text;

    CallbackData(String text) {
        this.text = text;
    }
}
