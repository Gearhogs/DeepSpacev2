package frc.robot.util;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Joint {
    private Vector vector;
    private Double length, currentAngle, targetAngle, gearRatio;
    private TalonSRX jointMotor;

    public Joint(int motor) {
        jointMotor = new TalonSRX(motor);
        jointMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);	
        this.setVector(new Vector(0.0, 0.0));
        setLength(0.0);
        setCurrentAngle(0.0);
        setTargetAngle(0.0);
        gearRatio = 0.0;
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
    public ErrorCode setCurrentAngle(Double currentAngle) {
        this.currentAngle = currentAngle;
        ErrorCode myError = jointMotor.getSensorCollection().setQuadraturePosition(MathUtil.DegreesToTicks(currentAngle, gearRatio), 50);
        return myError;
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

    /**
     * @param targetAngle the targetAngle to set
     */
    public void setTargetAngle(Double targetAngle) {
        this.targetAngle = targetAngle;
        jointMotor.set(ControlMode.Position, MathUtil.DegreesToTicks(targetAngle, gearRatio));
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

    public Joint(Vector vector) {
        this.setVector(vector);
        setLength(vector.getLength());
    }
}