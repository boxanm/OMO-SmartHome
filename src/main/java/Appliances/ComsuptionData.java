package Appliances;

public class ComsuptionData {

    private double fridgeComsuption[] = new double[] {0.8, 0.01, 0.0002};
    private double hifiComsuption[] = new double[] {0.6, 0.07, 0.00009};
    private double pcComsuption[] = new double[] {0.9, 0.03, 0.0001};
    private double playstationComsuption[] = new double[] {0.7, 0.04, 0.0006};
    private double tvComsuption[] = new double[] {0.8, 0.02, 0.0005};
    private double xboxComsuption[] = new double[] {0.7, 0.04, 0.0004};
    private double washingMachineComsuption[] = new double[] {1.3, 0.01, 0.0002};
    private double freezerComsuption[] = new double[] {1, 0.02, 0.0005};

    public double[] getFreezerComsuption() {
        return freezerComsuption;
    }

    public void setFreezerComsuption(double[] freezerComsuption) {
        this.freezerComsuption = freezerComsuption;
    }

    public double[] getFridgeComsuption() {
        return fridgeComsuption;
    }

    public void setFridgeComsuption(double[] fridgeComsuption) {
        this.fridgeComsuption = fridgeComsuption;
    }

    public double[] getHifiComsuption() {
        return hifiComsuption;
    }

    public void setHifiComsuption(double[] hifiComsuption) {
        this.hifiComsuption = hifiComsuption;
    }

    public double[] getPcComsuption() {
        return pcComsuption;
    }

    public void setPcComsuption(double[] pcComsuption) {
        this.pcComsuption = pcComsuption;
    }

    public double[] getPlaystationComsuption() {
        return playstationComsuption;
    }

    public void setPlaystationComsuption(double[] playstationComsuption) {
        this.playstationComsuption = playstationComsuption;
    }

    public double[] getTvComsuption() {
        return tvComsuption;
    }

    public void setTvComsuption(double[] tvComsuption) {
        this.tvComsuption = tvComsuption;
    }

    public double[] getXboxComsuption() {
        return xboxComsuption;
    }

    public void setXboxComsuption(double[] xboxComsuption) {
        this.xboxComsuption = xboxComsuption;
    }

    public double[] getWashingMachineComsuption() {
        return washingMachineComsuption;
    }

    public void setWashingMachineComsuption(double[] washingMachineComsuption) {
        this.washingMachineComsuption = washingMachineComsuption;
    }
}
