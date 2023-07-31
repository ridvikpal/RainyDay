package org.rainyday;

import java.util.ArrayList;

public class Alert {
    private ArrayList<AlertSubClass> alert;

    public ArrayList<AlertSubClass> getAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alert=" + alert +
                '}';
    }
}
