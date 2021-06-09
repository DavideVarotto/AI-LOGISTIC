//Problem fact

package com.example.domain;

import java.io.Serializable;

enum Level {
    HIGH, MEDIUM, LOW
}

public class Position implements Serializable {
    private String idPosition;
    private int lev;

    private Position() {
    }
    
    public Position(String string, int i) {
        this.idPosition = string;
        this.lev = i;
    }

    @Override
    public String toString() {
        return "Position: " + idPosition + "Level: " + lev;
    }

    // ********************************
    // Getters and setters
    // ********************************

    public void setIdPosition(String _idPosition) {
        this.idPosition = _idPosition;
    }

    public void setLevel(int _lev) {
        this.lev = _lev;
    }

    public String getIdPosition() {
        return this.idPosition;
    }

    public int getLevel() {
        return this.lev;
    }
}
