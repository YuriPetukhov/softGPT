package softgpt.enums;

import lombok.Getter;

@Getter
public enum VideoNames {

    WELCOME_VIDEO("/photos/about/9757.mp4", "9757.mp4");

    private final String path;
    private final String name;

    VideoNames(String path, String name) {
        this.path = path;
        this.name = name;
    }
}
