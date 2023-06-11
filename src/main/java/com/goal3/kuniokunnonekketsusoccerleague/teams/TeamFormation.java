package com.goal3.kuniokunnonekketsusoccerleague.teams;

public enum TeamFormation {

    _2_1_2("2-1-2", (byte) 2, (byte) 1, (byte) 2),
    _1_2_2("1-2-2", (byte) 1, (byte) 2, (byte) 2),
    _2_2_1("2-2-1", (byte) 2, (byte) 2, (byte) 1);

    final String name;
    final byte quantityDF;
    final byte quantityMF;
    final byte quantityFW;

    TeamFormation(String name, byte quantityDF, byte quantityMF, byte quantityFW) {
        this.name = name;
        this.quantityDF = quantityDF;
        this.quantityMF = quantityMF;
        this.quantityFW = quantityFW;
    }

    public String getName() {
        return name;
    }

    public byte getQuantityDF() {
        return quantityDF;
    }

    public byte getQuantityMF() {
        return quantityMF;
    }

    public byte getQuantityFW() {
        return quantityFW;
    }
}