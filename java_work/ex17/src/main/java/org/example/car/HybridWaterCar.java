package org.example.car;


class HybridWaterCar extends HybridCar{
    int waterGauge;

    public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge){
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
    }

    public void showCurrentGauge(){
        System.out.println("잔여 가솔린 "+gasolineGauge);
        System.out.println("잔여 전기량 "+electricGauge);
        System.out.println("잔여 워터량 "+waterGauge);
    }
}
