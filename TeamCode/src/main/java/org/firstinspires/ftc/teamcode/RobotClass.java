package org.firstinspires.ftc.teamcode;

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
        motorShoot = hardwareMap.dcMotor.get("motorshoot1");
        servoLoad = hardwareMap.servo.get("servoLoad");
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

        //RESET
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // run to distance
        motorRight.setTargetPosition(distance);
        motorLeft.setTargetPosition(-distance);


        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        turnLeft(1, 0);
        while (motorLeft.isBusy() && motorRight.isBusy()) {
            //waiting for getting to the given directon
        }
        stopDriving();
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void turnRightEncoders(int distance, double power) {
        // RESET
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

// distance
        motorRight.setTargetPosition(-distance);
        motorLeft.setTargetPosition(distance);

        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        turnRight(0, 1);
        while (motorLeft.isBusy() && motorRight.isBusy()) {
            //waiting for getting to the given direction
        }
        stopDriving();
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void moveForwardEncoders(int distance, double power, Telemetry telemetry) {
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // RESET

        motorRight.setTargetPosition(distance);
        motorLeft.setTargetPosition(distance);
        // distance
        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("the current position is", motorLeft.getCurrentPosition());
        telemetry.addData("the current position is", motorRight.getCurrentPosition());
        motorRight.getCurrentPosition();
        move(power, power);

        while (motorLeft.isBusy() && motorRight.isBusy()) {
            telemetry.addData("the loop is still working the motor left is ", motorLeft);
            telemetry.addData("the loop is still working the motorright is", motorRight);

        }
        stopDriving();
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("the current new position is", motorLeft.getCurrentPosition());
        telemetry.addData("the current new position is", motorRight.getCurrentPosition());


    }

    public void moveBackwardsEncoders(int distance, double power) {
        // RESET
        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // distance
        motorRight.setTargetPosition(-distance);
        motorLeft.setTargetPosition(-distance);

        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        move(power, power);
        while (motorLeft.isBusy() && motorRight.isBusy()) {
            //waiting for getting to the given directon
        }
        stopDriving();
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

//endregion
}
