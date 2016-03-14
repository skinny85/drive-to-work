package org.skinny.drive_to_work;

public class Episode {
    private int number;
    private String title;
    private String description;
    private String url;

    private Episode() {

    }

    public Episode(int number, String title, String description, String url) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
