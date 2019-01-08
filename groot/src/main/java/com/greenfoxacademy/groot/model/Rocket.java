package com.greenfoxacademy.groot.model;


public class Rocket {

    public Integer caliber25;
    public Integer caliber30;
    public Integer caliber50;
    public String shipStatus;
    public boolean ready;

    public Rocket() {
        caliber50=0;
        caliber30=0;
        caliber25=0;
        shipStatus="empty";
        ready=false;
    }

    public String fill(RocketCargoFill fill) {
        if (!shipStatus.equals("full")) {
            switch (fill.received) {
                case ".25":
                    caliber25 += fill.amount;
                    break;
                case ".30":
                    caliber30 += fill.amount;
                    break;
                case ".50":
                    caliber50 += fill.amount;
                    break;
                default:
                    break;
            }
        }

        float sumCargo = caliber25+caliber30+caliber50;

        if (sumCargo==0){
            shipStatus="empty";
        }
        else if(sumCargo<12500){
            shipStatus = String.format("%.0f%%", sumCargo/12500 * 100);
        }
        else if(sumCargo>=12500) {
            shipStatus = "full";
            ready=true;
        }

        return shipStatus;
    }
}
