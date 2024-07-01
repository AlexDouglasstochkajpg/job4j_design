package ru.job4j.serialization.json;

import org.json.JSONObject;

public class Y {
    private X x;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        x.setY(y);
        y.setX(x);

        System.out.println(new JSONObject(y));
    }
}
