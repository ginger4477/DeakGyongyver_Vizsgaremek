package com.codecool.vizsgaremek.enums;

public enum Pages {

    REGISTRATION_AND_LOGIN_PAGE("https://lennertamas.github.io/roxo/index.html"),
    LANDING_PAGE("https://lennertamas.github.io/roxo/landing.html"),
    ABOUT_PAGE("https://lennertamas.github.io/roxo/about/"),
    CONTACT_PAGE("https://lennertamas.github.io/roxo/contact/"),
    PORTFOLIO_PAGE("https://lennertamas.github.io/roxo/portfolio/"),
    BLOG_PAGE("https://lennertamas.github.io/roxo/blog/"),
    PROFILE_PAGE("https://lennertamas.github.io/roxo/profile");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
