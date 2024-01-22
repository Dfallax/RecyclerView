package com.example.divisasrecycler;

import android.graphics.drawable.Drawable;

public class DivisaModel {

    public String eventName;
    public String eventValor;
    public Drawable eventIcon;

    public DivisaModel(String eventName, String eventValor, Drawable eventIcon) {
        this.eventName = eventName;
        this.eventValor = eventValor;
        this.eventIcon = eventIcon;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventValor() {
        return eventValor;
    }

    public Drawable getEventIcon() {
        return eventIcon;
    }
}
