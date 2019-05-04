package j2c.controllers;

import org.springframework.stereotype.Component;

@Component
public class Preferences {
    private String lang;

    public Preferences() {

    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
