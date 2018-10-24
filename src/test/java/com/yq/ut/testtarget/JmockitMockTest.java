package com.yq.ut.testtarget;

import mockit.*;
import org.testng.annotations.Test;


public class JmockitMockTest {
    @Test
    public void originalTest(){
        System.out.println("\noriginal test");
        CDerived cDerived = new CDerived();
        cDerived.expressStatus();
    }

    @Test
    public void withMockedTest(){

        System.out.println("\nusing Deencapsulation.setField");
        CDerived cDerived = new CDerived();
        Deencapsulation.setField(cDerived, "status", "Base_MOCKED");
        Deencapsulation.setField(Deencapsulation.getField(cDerived,"fieddBase"), "Filed_MOCKED");
//        Deencapsulation.setField(Deencapsulation.getField(cDerived,"psf"), "MOCKED psf");
        cDerived.expressStatus();
    }

    @Test
    public void withMocked2Test(@Mocked final CBase base){

        System.out.println("\nusing @Mocked");
        new Expectations(){{
            base.getStatus(); result = "MOCKED " + "MOCKED calculate";
        }};

        CDerived cDerived = new CDerived();
        cDerived.expressStatus();
    }

    @Test
    public void withMockupTest(){
        new MockUp<CBase>(){

            @Mock
            String  calcString(){
                return "Calc Mocked";
            }


            String psf = "Mocked";
        };

        CBase base = new CBase();
        CDerived cDerived = new CDerived();
        Deencapsulation.setField(cDerived, "status", "MockedStatus");
        cDerived.expressStatus();
    }
}
