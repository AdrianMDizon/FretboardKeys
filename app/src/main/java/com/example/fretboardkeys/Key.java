package com.example.fretboardkeys;

public class Key {
    int accNum;
    String accType;
    String majorOrMinor;
    String keyName;

    public Key(int accNum, String accType, String majorOrMinor, String keyName){
        this.accNum = accNum;
        this.accType = accType;
        this.majorOrMinor = majorOrMinor;
        this.keyName = keyName;
    }

}
