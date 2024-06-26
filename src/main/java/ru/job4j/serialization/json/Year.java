package ru.job4j.serialization.json;

public class Year {
    private final String releaseYear;

    public Year(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Year{"
                + "releaseYear='" + releaseYear + '\''
                + '}';
    }
}
