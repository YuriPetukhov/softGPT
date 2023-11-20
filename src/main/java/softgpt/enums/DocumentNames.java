package softgpt.enums;

import lombok.Getter;

@Getter
public enum DocumentNames {
    ABOUT_DOC("/photos/info/SoftGPT.pdf", "SoftGPT.pdf");

    private final String path;
    private final String name;

    DocumentNames(String path, String name) {
        this.path = path;
        this.name = name;
    }
}
