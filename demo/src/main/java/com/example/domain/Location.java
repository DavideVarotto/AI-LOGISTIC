//Pnalling entity

package com.example.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.io.Serializable;

@PlanningEntity
public class Location implements Serializable {
    @PlanningVariable( valueRangeProviderRefs = "posRange")
    private Position pos;

    @PlanningVariable(valueRangeProviderRefs = "prodRange")
    private Product prod;

    private int idLocation;

    private Location() {
    }

    public Location(int _idLocation) {
        this.idLocation = _idLocation;
    }

    @Override
    public String toString() {
        return prod + " : " + pos.toString();
    }

    // ********************************
    // Getters and setters
    // ********************************
    public void setPos(Position _pos) {
        this.pos = _pos;
    }

    public void setProd(Product _prod) {
        this.prod = _prod;
    }

    public void setIdLocation(int _idLocation) {
        this.idLocation = _idLocation;
    }

    public Product getProd() {
        return this.prod;
    }

    public Position getPos() {
        return this.pos;
    }

    public int getIdLocation() {
        return this.idLocation;
    }
}
