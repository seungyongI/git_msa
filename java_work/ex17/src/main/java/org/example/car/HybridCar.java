package org.example.car;

class HybridCar extends Car {
    int electricGauge;

    public HybridCar(int gasolineGauge, int electricGauge){
        super(gasolineGauge);
        this.electricGauge = electricGauge;
    }


}
