package softgpt.enums;

import lombok.Getter;

@Getter
public enum Commands {
    START("/start"),
    ABOUT("/about"),
    INFO("/info"),
    TARIFFS("/tariffs"),
    BENEFITS("/benefits"),
    SAFETY("/safety"),
    CONSULT("/consult"),
    BACK("/back"),
    SHOW_MORE("/show_more");

    private final String name;

    Commands(String name) {
        this.name = name;
    }

    public static Commands fromString(String name) {
        for (Commands b : Commands.values()) {
            if (b.name.equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

}
