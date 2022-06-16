package com.laviniarat.salarycalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorSalariuNetTest {

    @Test
    void happyFlowTestScutireImpozit() {
        CalculatorSalariuNet test1 = new CalculatorSalariuNet(10000, 20,20,true);
        test1.compute();
        Assertions.assertEquals(6500, test1.getSalariuNet());
        Assertions.assertEquals(2500, test1.getCAS());
        Assertions.assertEquals(1000, test1.getCASS());
        Assertions.assertEquals(0, test1.getIV());
    }


    @Test
    void happyFlowTestFaraScutireImpozit() {
        CalculatorSalariuNet test1 = new CalculatorSalariuNet(10000, 20,20,false);
        test1.compute();
        Assertions.assertEquals(5810, test1.getSalariuNet());
        Assertions.assertEquals(2500, test1.getCAS());
        Assertions.assertEquals(1000, test1.getCASS());
        Assertions.assertEquals(690, test1.getIV());
    }

    @Test
    void testFaraTicheteFaraImpozit() {
        CalculatorSalariuNet test1 = new CalculatorSalariuNet(10000, 0,0,true);
        test1.compute();
        Assertions.assertEquals(6500, test1.getSalariuNet());
        Assertions.assertEquals(2500, test1.getCAS());
        Assertions.assertEquals(1000, test1.getCASS());
        Assertions.assertEquals(0, test1.getIV());
    }
    @Test
    void testFaraTicheteCuImpozit() {
        CalculatorSalariuNet test1 = new CalculatorSalariuNet(10000, 0,0,false);
        test1.compute();
        Assertions.assertEquals(5850, test1.getSalariuNet());
        Assertions.assertEquals(2500, test1.getCAS());
        Assertions.assertEquals(1000, test1.getCASS());
        Assertions.assertEquals(650, test1.getIV());
    }


    @Test
    void testSalariumazim() {
        CalculatorSalariuNet test1 = new CalculatorSalariuNet(Integer.MAX_VALUE, 0,0,true);
        test1.compute();
        Assertions.assertEquals(6500, test1.getSalariuNet());
        Assertions.assertEquals(2, test1.getCAS());
        Assertions.assertEquals(2, test1.getCASS());
        Assertions.assertEquals(2, test1.getIV());
    }
}