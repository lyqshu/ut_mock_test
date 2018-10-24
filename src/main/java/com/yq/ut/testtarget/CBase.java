package com.yq.ut.testtarget;

public class CBase {
    protected String getStatus() {
        return status + " " +  calcString();
    }

    private String status = "original";

    private String calcString(){
        return " original calculate";
    }

    protected static final String psf = "This is original static final string";
}
