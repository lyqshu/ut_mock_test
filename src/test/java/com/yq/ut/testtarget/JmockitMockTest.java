package com.yq.ut.testtarget;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.annotations.Test;


public class JmockitMockTest {
    @Test
    public void originalTest(){
        CDerived cDerived = new CDerived();
        cDerived.expressStatus();
    }

    @Test
    public void withMockedTest(){

        CDerived cDerived = new CDerived();
        Deencapsulation.setField(cDerived, "status", "Base_MOCKED");
        Deencapsulation.setField(Deencapsulation.getField(cDerived,"fieddBase"), "Filed_MOCKED");
        cDerived.expressStatus();
    }

    @Test
    public void withMocked2Test(@Mocked final CBase base){

        new Expectations(){{
            base.getStatus(); result = "MOCKED";
        }};

        CDerived cDerived = new CDerived();
        cDerived.expressStatus();
    }
}
