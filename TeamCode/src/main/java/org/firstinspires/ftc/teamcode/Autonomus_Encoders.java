package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by User on 17/01/2017.
 */
@Autonomous(name="encoders")
public class Autonomus_Encoders extends LinearOpMode {
   public DcMotor MotorRight;
   public DcMotor MotorLeft;
    public  void turnLeft_NoEncoders(double power)
    {
        MotorLeft.setPower(-power);
        MotorRight.setPower(power);
    }
    public  void turnRight_NoEncoders(double power)
    {
        MotorLeft.setPower(power);
        MotorRight.setPower(-power);
    }

        public  void MoveForward_NoENcoders( double power)
        {
            MotorRight.setPower(power);
            MotorLeft.setPower(power);
        }
        public void moveForward_encoders(int distance,double power)
        {
        MotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            MotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            // RESET

            MotorRight.setTargetPosition(distance);
            MotorLeft.setTargetPosition(distance);
            // distence
            MotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            MotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //
            MoveForward_NoENcoders(power);
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
       turnRight_NoEncoders(power);
        while (MotorLeft.isBusy() && MotorRight.isBusy())
        {
            //waiting for getting to the given directon
        }
        stopddriving();
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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
        turnLeft_NoEncoders(power);
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
            MoveForward_NoENcoders(0);
        }

    @Override
    public void runOpMode() throws InterruptedException {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight=hardwareMap.dcMotor.get("MotorRight");
        MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        moveForward_encoders(3000,0.3); // Experiment
        turnRight_encoders(2699,0.1); // Experiment
        turnLeft_encoders(2323, 0.1); //Experiment

    }
}
