package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

public class X {
    private Y y;

    @JSONPropertyIgnore
    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public String getGoodMorning() {
        return "Good morning";
    }

}
