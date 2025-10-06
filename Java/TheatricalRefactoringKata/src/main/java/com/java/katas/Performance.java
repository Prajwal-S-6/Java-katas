package com.java.katas;

public class Performance {

    public String playID;
    public int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }

    public int getVolumeCredits(PlayTypeEnum type) {
        return type.getVolumeCredits(audience);
    }


    public int getAmount(PlayTypeEnum type) {
        return type.getAmount(audience);
    }

}