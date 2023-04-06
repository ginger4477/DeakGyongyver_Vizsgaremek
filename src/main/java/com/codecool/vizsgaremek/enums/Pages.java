package com.codecool.vizsgaremek.enums;

public enum Pages {

    REGISTRATION_AND_LOGIN_PAGE("https://lennertamas.github.io/roxo/index.html"),
    LANDING_PAGE("https://lennertamas.github.io/roxo/landing.html");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
