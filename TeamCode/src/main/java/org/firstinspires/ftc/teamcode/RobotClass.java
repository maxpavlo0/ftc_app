package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by User on 29/01/2017.
 */

public class RobotClass {
    public DcMotor motorShoot;
    public DcMotor motorLeft;
    public DcMotor motorRight;
    public DcMotor motorPushSuck;
    public Servo servoLoad;

    RobotClass(HardwareMap hardwareMap) {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorPushSuck = hardwareMap.dcMotor.get("motorPushSuck");
       // motorShoot = hardwareMap.dcMotor.get("motorshoot1");
     //   servoLoad = hardwareMap.servo.get("servoLoad");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

    }
    //region drive
    public void shoot(int power) {
        motorShoot.setPower(1);
    }

    public void stopDriving() {
        move(0, 0);
    }

    public void suck(double powerSuck) {
        motorPushSuck.setPower(powerSuck);
    }

    public void turnLeft(double powerRight, double powerLeft) {
        motorRight.setPower(powerRight);
        motorLeft.setPower(powerLeft);
    }

    public void turnRight(double powerRight, double powerLeft) {
        motorLeft.setPower(powerLeft);
        motorRight.setPower(powerRight);
    }


    public void move(double powerRight, double powerLeft) {
        motorRight.setPower(-powerRight);
        motorLeft.setPower(-powerLeft);
    }

    public void servoControlOpen() {

        servoLoad.setPosition(0.8);

    }

    public void servoControlClose() {
        servoLoad.setPosition(0.002);
    }
    // endregion


//region autonomous
    public void turnLeftEncoders(int distance, double power) {


        int ds = motorLeft.getCurrentPosition();
        int ds2 = motorRight.getCurrentPosition();

        move(power, -power/2);
        while(motorLeft.isBusy() && motorRight.isBusy()){

            if(motorLeft.getCurrentPosition() >= distance - ds &&motorRight.getCurrentPosition() <= distance + ds2 ){
                break;
            }
        }
        stopDriving();

    }

    public void turnRightEncoders(int distance, double power) {
        // RESET

         int ds =motorLeft.getCurrentPosition();
        int ds2 =motorRight.getCurrentPosition();

        move(-power/2,power);
        while(motorLeft.isBusy() && motorRight.isBusy()){

            if(motorLeft.getCurrentPosition() <= distance + ds &&motorRight.getCurrentPosition() >= distance - ds2 ){
                break;
            }
        }
        stopDriving();
    }

    public void timerun(long seconds)
    {
        long starttime=System.currentTimeMillis();

        while(System.currentTimeMillis() <= starttime+ seconds *1000)
        {
            move(-0.3,-0.3);
        }

    }

    public void moveForwardEncoders(int distance, double power , Telemetry telemetry) throws InterruptedException {

        // RESET

        int ds = motorLeft.getCurrentPosition();
        int ds2 = motorRight.getCurrentPosition();
        telemetry.addData("ds",ds);
        telemetry.update();
        move(power, power);
        Thread.sleep(100);
        if (ds < 0 ){
            ds = ds *-1;

        }
        if(ds2 <0){
            ds2 = ds2 *-1;
        }
        while(motorLeft.isBusy() && motorRight.isBusy()){
            int a = motorLeft.getCurrentPosition();
            int b = motorRight.getCurrentPosition();
            telemetry.addData("motorLeft.getCurrentPosition()",motorLeft.getCurrentPosition());
            telemetry.update();
            if( a >= (distance + ds) &&b >= (distance + ds2) ){
                break;
            }
        }        stopDriving();
        // distance

//        telemetry.addData("the current position is", motorLeft.getCurrentPosition());
//        telemetry.addData("the current position is", motorRight.getCurrentPosition());
//        motorRight.getCurrentPosition();
//        stopDriving();
        telemetry.addData("the current new position is", motorLeft.getCurrentPosition());
        telemetry.addData("the current new position is", motorRight.getCurrentPosition());


    }

    public void moveBackwardsEncoders(int distance, double power) {
        // RESET
        int ds = motorLeft.getCurrentPosition();
        int ds2 =motorRight.getCurrentPosition();

        move(-power, -power);
        while(motorLeft.isBusy() && motorRight.isBusy()){

            if(motorLeft.getCurrentPosition() <= distance - ds &&motorRight.getCurrentPosition() <= distance - ds2 ){
                break;
            }
        }
        stopDriving();
        // distance

//        telemetry.addData("the current position is", motorLeft.getCurrentPosition());
//        telemetry.addData("the current position is", motorRight.getCurrentPosition());
//        motorRight.getCurrentPosition();
//        stopDriving();


    }

//endregion
}
