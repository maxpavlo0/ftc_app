package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by User on 29/01/2017.
 */

public class RobotClass {

    public DcMotor MotorLeft;
   public   DcMotor MotorRight;
    public  DcMotor Motorpushsuck;
    RobotClass(HardwareMap hardwareMap)
    {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight=hardwareMap.dcMotor.get("MotorRight");
        Motorpushsuck=hardwareMap.dcMotor.get("Motorpushsuck");
        MotorLeft.setDirection(DcMotor.Direction.REVERSE);

    }
    public void move(double powerRight,double powerLeft)
    {
        MotorRight.setPower(-powerRight);
        MotorLeft.setPower(-powerLeft);
    }
    public void  suck(double powersuck)
    {
        Motorpushsuck.setPower(powersuck);
    }
        public void TurnLeft(double powerright,double powerleft)
    {
        MotorRight.setPower(powerright);
        MotorLeft.setPower(powerleft);
    }
    public void TurnRight(double powerright,double powerleft)
    {
        MotorLeft.setPower(powerleft);
        MotorRight.setPower(powerright);
    }

}
