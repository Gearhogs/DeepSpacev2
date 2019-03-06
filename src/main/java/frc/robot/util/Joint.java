package frc.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class Joint {
    private Vector vector;
    private Double length, currentAngle, targetAngle, gearRatio;
    private int tick, adc;
    private WPI_TalonSRX jointMotor;
    private Boolean isSoftLimitEnabled = false;

    public Joint(int motor, Double gearRatio) {
        jointMotor = new WPI_TalonSRX(motor);
        // jointMotor.setSafetyEnabled(true);
        jointMotor.configFactoryDefault();
        jointMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
        jointMotor.configOpenloopRamp(RobotMap.defaultRampRate);
        jointMotor.configClosedloopRamp(RobotMap.defaultRampRate);

        jointMotor.configNominalOutputForward(0);
        jointMotor.configNominalOutputReverse(0);
        jointMotor.configPeakOutputForward(RobotMap.peakOutput);
        jointMotor.configPeakOutputReverse(-RobotMap.peakOutput);
       
        this.setVector(new Vector(0.0, 0.0));
        setLength(0.0);
        setCurrentAngle(0.0);
        setTargetPos(0);
        this.gearRatio = gearRatio;

        jointMotor.set(ControlMode.PercentOutput, 0.0);        
    }
    
    /**
     * @return the currentAngle
     */
    public Double getCurrentAngle() {
        int ticks = jointMotor.getSensorCollection().getQuadraturePosition();
        currentAngle = MathUtil.TicksToDegrees(ticks, gearRatio);
        return currentAngle;
    }

    /**
     * @param currentAngle the currentAngle to set
     */
    public void setCurrentAngle(Double currentAngle) {
        this.currentAngle = currentAngle;
        //jointMotor.getSensorCollection().setQuadraturePosition(MathUtil.DegreesToTicks(currentAngle, gearRatio), 50);
        
    }

    /**
     * @return the vector
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * @param vector the vector to set
     */
    public void setVector(Vector vector) {
        this.vector = vector;
    }

    /**
     * @return the targetAngle
     */
    public Double getTargetAngle() {
        return targetAngle;
    }
    public void setTargetPos(int tick) {
        this.tick = tick;
        jointMotor.set(ControlMode.MotionMagic, tick);
    }
    public void setTargetAdc(int adc) {
        this.adc = adc;
        jointMotor.set(ControlMode.MotionMagic, adc);
    }
    public int getTargetPos() {
        return tick;
    }

    /**
     * @return the length
     */
    public Double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Double length) {
        this.length = length;
    }
    public void runMotor(Double power){
        jointMotor.set(ControlMode.PercentOutput, power);

    }
    public void stopMotor(){
        jointMotor.set(ControlMode.PercentOutput, 0);
    }
    public TalonSRX getMotor() {
        return jointMotor;
    }
    public Joint(Vector vector) {
        this.setVector(vector);
        setLength(vector.getLength());
    }
    public void configSoftLimits(int lowLimit, int highLimit){
        jointMotor.configForwardSoftLimitThreshold(highLimit);
        jointMotor.configReverseSoftLimitThreshold(lowLimit);
        jointMotor.configForwardSoftLimitEnable(true);
        jointMotor.configReverseSoftLimitEnable(true);
    }
    public void configLimitSwitchForward(){
        jointMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    }
    public void configLimitSwitchReverse(){
        jointMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    }
    public void toggleSoftLimit(){
        jointMotor.configForwardSoftLimitEnable(!isSoftLimitEnabled);
        jointMotor.configReverseSoftLimitEnable(!isSoftLimitEnabled);
        isSoftLimitEnabled = !isSoftLimitEnabled;
    }
    public void setSoftLimit(boolean isEnabled) {
        jointMotor.configForwardSoftLimitEnable(isEnabled);
        jointMotor.configReverseSoftLimitEnable(isEnabled);
    }
    public void setRelativePosition(int position){
        jointMotor.getSensorCollection().setQuadraturePosition(position, 0);
    }
    public void setSensorPhase(boolean isTrue) {
        jointMotor.setSensorPhase(isTrue);
    }
    public void setAnalogPosition(int position){
            jointMotor.getSensorCollection().setAnalogPosition(position, 0);
    }
    public int getAnalogPosition(){
        return jointMotor.getSensorCollection().getAnalogIn();
    }
    public void setk(Double kF){
        jointMotor.config_kF(0, kF);
    }
    public void setkP(Double kP){
        jointMotor.config_kP(0, kP);
    }
    public void setkI(Double kI){
        jointMotor.config_kI(0, kI);
    }
    public void setkD(Double kD){
        jointMotor.config_kD(0, kD);
    }
    public void setPID(Double kF, Double kP, Double kI, Double kD){
        jointMotor.config_kF(0, kF);
        jointMotor.config_kP(0, kP);
        jointMotor.config_kI(0, kI);
        jointMotor.config_kD(0, kD);
    }
    public void setMotionMagic(int unitsV, int unitsA) {
        jointMotor.configMotionCruiseVelocity(unitsV);
        jointMotor.configMotionAcceleration(unitsA);
    }
    public void Debug(String name) {
        SmartDashboard.putNumber(name + " Position", jointMotor.getSelectedSensorPosition());
        SmartDashboard.putNumber(name + " Angle", MathUtil.TicksToDegrees(jointMotor.getSelectedSensorPosition(), gearRatio));
        SmartDashboard.putNumber(name + " Velocity" , jointMotor.getSelectedSensorVelocity(0));
        SmartDashboard.putNumber(name + " Error: ", jointMotor.getClosedLoopError(0));
        SmartDashboard.putNumber(name + " Absolute Position", MathUtil.AdcToDegrees(jointMotor.getSensorCollection().getAnalogIn()));
        if(name.equals("Arm1")) {
            SmartDashboard.putBoolean(name + " FwdSwitchPressed", jointMotor.getSensorCollection().isRevLimitSwitchClosed());
        } 
        else {
            SmartDashboard.putBoolean(name + " RevSwitchPressed", jointMotor.getSensorCollection().isFwdLimitSwitchClosed());
        }
    }
}