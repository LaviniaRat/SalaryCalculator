package com.laviniarat.salarycalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorSalariuBrutTest {

    @Test
    void happyFlowTestCuTicheteFaraScutireImpozit() {
        CalculatorSalariuBrut test1 = new CalculatorSalariuBrut(5500, 20, 20, false);
        test1.compute();
        Assertions.assertEquals(9471, test1.getSalariuBrut());
        Assertions.assertEquals(2368, test1.getCAS());
        Assertions.assertEquals(947, test1.getCASS());
        Assertions.assertEquals(656, test1.getIV());

    }


    @Test
    void happyFlowTestCuTicheteCuScutireImpozit() {
        CalculatorSalariuBrut test1 = new CalculatorSalariuBrut(5500, 20, 20, true);
        test1.compute();
        Assertions.assertEquals(8461, test1.getSalariuBrut());
        Assertions.assertEquals(2115, test1.getCAS());
        Assertions.assertEquals(846, test1.getCASS());
        Assertions.assertEquals(0, test1.getIV());
    }

    @Test
    void testFaraTicheteFaraImpozit() {
        CalculatorSalariuBrut test1 = new CalculatorSalariuBrut(6500, 0, 0, true);
        test1.compute();
        Assertions.assertEquals(10000, test1.getSalariuBrut());
        Assertions.assertEquals(2500, test1.getCAS());
        Assertions.assertEquals(1000, test1.getCASS());
        Assertions.assertEquals(0, test1.getIV());
    }

    @Test
    void testFaraTicheteCuImpozit() {
        CalculatorSalariuBrut test1 = new CalculatorSalariuBrut(5500, 0, 0, false);
        test1.compute();
        Assertions.assertEquals(9401, test1.getSalariuBrut());
        Assertions.assertEquals(2350, test1.getCAS());
        Assertions.assertEquals(940, test1.getCASS());
        Assertions.assertEquals(611, test1.getIV());
    }


}