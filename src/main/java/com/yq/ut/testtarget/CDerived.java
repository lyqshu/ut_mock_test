package com.yq.ut.testtarget;

public class CDerived extends CBase {
    private CBase fieddBase = new CBase();
    public void expressStatus(){
        CBase stockBase = new CBase();
        System.out.println("Super status is : " + super.getStatus());
        System.out.println("field status is : " + fieddBase.getStatus());
        System.out.println("stockfield status is : " + stockBase.getStatus());
    }
}
