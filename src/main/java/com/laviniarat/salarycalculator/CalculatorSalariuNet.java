package com.laviniarat.salarycalculator;

public class CalculatorSalariuNet {
    private final double salariuBrut;
    private final double valoareTichet;
    private final double numarTichete;
    private final boolean scutireImpozit;

    private double salariuNet;
    private double cass;
    private double cas;
    private double iv;


    public CalculatorSalariuNet(int salariuBrut, int valoareTichet, int numarTichete, boolean scutireImpozit) {
        this.salariuBrut = salariuBrut;
        this.valoareTichet = valoareTichet;
        this.numarTichete = numarTichete;
        this.scutireImpozit = scutireImpozit;
    }

        public void compute(){
            this.cass = this.salariuBrut * 0.1;
            this.cas = this.salariuBrut * 0.25;
            if (!scutireImpozit) {
                this.iv = (this.salariuBrut+(this.numarTichete*this.valoareTichet)-this.cas-this.cass) * 0.1;
            } else {
               this.iv = 0;
            }
            this.salariuNet = this.salariuBrut - this.cass - this.cas - this.iv;
        }


    public double getSalariuNet () {
        return salariuNet;
    }
    public double getCASS () {
        return cass;
    }
    public double getCAS () {
        return cas;
    }
    public double getIV () {
        return iv;
    }
}
