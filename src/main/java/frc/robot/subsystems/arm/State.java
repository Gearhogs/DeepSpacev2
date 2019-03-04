package frc.robot.subsystems.arm;

import frc.robot.util.MathUtil;

public class State {
    private Double angle;
    private int ticks;
    private int adc;

    public State(Double angle, Double ratio) {
        this.angle = angle;
        this.ticks = MathUtil.DegreesToTicks(angle, ratio);
    }
    public State(Double angle){
        this.angle = angle;
        this.adc = MathUtil.DegreesToAdc(angle);
    }
    public State(int ticks,  Double ratio) {
        this.ticks = ticks;
        this.angle = MathUtil.TicksToDegrees(ticks, ratio);
    }
    public State(int adc) {
        this.adc = adc;
        this.angle = MathUtil.AdcToDegrees(adc);
    }
    public int getTicks() {
        return ticks;
    }
    public Double getAngle() {
        return angle;
    }
    public int getAdc(){
        return adc;
    }
}