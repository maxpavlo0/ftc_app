package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by User on 29/01/2017.
 */

public class RobotClass {
    public  DcMotor motorShootl;
    public DcMotor MotorLeft;
   public   DcMotor MotorRight;
    public  DcMotor Motorpushsuck;
    public Servo servoLoad;
    RobotClass(HardwareMap hardwareMap)
    {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight=hardwareMap.dcMotor.get("MotorRight");
        Motorpushsuck=hardwareMap.dcMotor.get("Motorpushsuck");
        motorShootl=hardwareMap.dcMotor.get("motorshoot1");
        servoLoad=hardwareMap.servo.get("servoLoad");
        MotorLeft.setDirection(DcMotor.Direction.REVERSE);

    }
    public void  shoot(int power)
    {
        motorShootl.setPower(1);
    }
    public void servcontrolopen()
    {

        servoLoad.setPosition(0.8);

    }
    public void servocontrolclose()
    {
        servoLoad.setPosition(0.002);
    }
    public void turnLeft_encoders(int distance,double power)
    {
        MotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // RESET

        MotorRight.setTargetPosition(distance);
        MotorLeft.setTargetPosition(-distance);
        // distence
        MotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        MotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //
       TurnLeft(1,0);
        while (MotorLeft.isBusy() && MotorRight.isBusy())
        {
            //waiting for getting to the given directon
        }
        stopddriving();
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void turnRight_encoders(int distance,double power)
    {
        MotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // RESET

        MotorRight.setTargetPosition(-distance);
        MotorLeft.setTargetPosition(distance);
        // distence
        MotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        MotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //
        TurnRight(0,1);
        while (MotorLeft.isBusy() && MotorRight.isBusy())
        {
            //waiting for getting to the given directon
        }
        stopddriving();
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void stopddriving()
    {
        move(0,0);
    }
    public void move(double powerRight,double powerLeft)
    {
        MotorRight.setPower(-powerRight);
        MotorLeft.setPower(-powerLeft);
    }
    public void movewithoutencoders(double power)
    {
        MotorRight.setPower(power);
        MotorLeft.setPower(power);
    }
    public void moveForward_encoders(int distance,double power,Telemetry telemetry)
    {
        MotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // RESET

        MotorRight.setTargetPosition(distance);
         MotorLeft.setTargetPosition(distance);
        // distance
        MotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        MotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("the current position is", MotorLeft.getCurrentPosition());
        telemetry.addData("the current position is",MotorRight.getCurrentPosition());
        MotorRight.getCurrentPosition();
     move(power,power);

        while (MotorLeft.isBusy() && MotorRight.isBusy())
        {
            telemetry.addData("the loop is still working the motor left is ",MotorLeft);
            telemetry.addData("the loop is still working the motorright is", MotorRight);

        }
        stopddriving();
        telemetry.addData("the current new position is", MotorLeft.getCurrentPosition());
        telemetry.addData("the current new position is",MotorRight.getCurrentPosition());


    }
    public void movebackwards_encoders(int distance,double power)
    {
        MotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // RESET

        MotorRight.setTargetPosition(-distance);
        MotorLeft.setTargetPosition(-distance);
        // distence
        MotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        MotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //
        move(power,power);
        while (MotorLeft.isBusy() && MotorRight.isBusy())
        {
            //waiting for getting to the given directon
        }
        stopddriving();
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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
