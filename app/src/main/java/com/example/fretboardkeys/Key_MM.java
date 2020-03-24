package com.example.fretboardkeys;

import java.io.Serializable;

public class Key_MM implements Serializable {

    String accNum;
    String accType;
    String majorKey;
    String minorKey;

    public Key_MM(String accNum, String accType, String major, String minor){
        this.accNum = accNum;
        this.accType = accType;
        this.majorKey = major;
        this.minorKey = minor;
    }
}
