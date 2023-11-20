package softgpt.enums;

import lombok.Getter;

@Getter
public enum ImageNames {

    WELCOME_IMG("/photos/start/start.jpg"),
    ABOUT_IMG("/photos/about/about.jpg"),
    BENEFITS_IMG("/photos/benefits/benefits.jpg"),
    CONTACT_IMG("/photos/contacts/consult.jpg"),
    START_IMG("/photos/start/menu.jpg"),
    ULTRA_IMG("/photos/tariffs/ultra.jpg"),
    STANDARD_IMG("/photos/tariffs/standard.jpg"),
    ECONOMY_IMG("/photos/tariffs/economy.jpg"),
    SAFETY_IMG("/photos/safety/safety.jpg"),
    REF_PRO_IMG("/photos/tariffs/refprog.jpg");

    private final String path;

    ImageNames(String path) {
        this.path = path;
    }
}
