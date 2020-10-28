package model.entities;

public enum MediaType {
    BOOK("Book"),
    MOOVE("Moove");

    private final String description;

    MediaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
