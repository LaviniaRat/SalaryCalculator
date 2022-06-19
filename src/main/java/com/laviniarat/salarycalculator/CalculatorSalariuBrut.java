package com.laviniarat.salarycalculator;

public class CalculatorSalariuBrut {
    private final double salariuNet;
    private final double valoareTichet;
    private final double numarTichete;
    private final boolean scutireImpozit;

    private double salariuBrut;
    private double cass;
    private double cas;
    private double iv;
    private double tichetMasa;


    public CalculatorSalariuBrut(int salariuNet, int valoareTichet, int numarTichete, boolean scutireImpozit) {
        this.salariuNet = salariuNet;
        this.valoareTichet = valoareTichet;
        this.numarTichete = numarTichete;
        this.scutireImpozit = scutireImpozit;
        this.tichetMasa = this.valoareTichet * this.numarTichete;
    }

    public void compute() {
        double salariuBrutTemp;
        if (!scutireImpozit) {
            salariuBrutTemp = (this.salariuNet + this.tichetMasa * 0.1) / 0.585;
        } else {
            salariuBrutTemp = this.salariuNet / 0.65;
        }
        this.cass = Math.round(salariuBrutTemp * 0.1);
        this.cas = Math.round(salariuBrutTemp * 0.25);
        if (!scutireImpozit) {
            this.iv = Math.round((salariuBrutTemp + this.tichetMasa - this.cas - this.cass) * 0.1);
        } else {
            this.iv = 0;
        }
        this.salariuBrut = this.salariuNet + this.cas + this.cass + this.iv;
    }


    public double getSalariuBrut() {
        return salariuBrut;
    }

    public double getCASS() {
        return cass;
    }

    public double getCAS() {
        return cas;
    }

    public double getIV() {
        return iv;
    }
}
