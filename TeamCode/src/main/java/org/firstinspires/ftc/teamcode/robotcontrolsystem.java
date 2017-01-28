package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by User on 15/01/2017.
 */

@Autonomous(name = "contro.sytem")
public class robotcontrolsystem extends LinearOpMode {
    public  DcMotor MotorLeft;
   public   DcMotor MotorRight;



public void moveforward(double powerright, double powerleft)
    {
        MotorRight.setPower(powerright);
        MotorLeft.setPower(powerleft);

    }

    @Override
    public void runOpMode() throws InterruptedException {




     MotorRight = hardwareMap.dcMotor.get("MotorRight");
        MotorLeft=hardwareMap.dcMotor.get("MotorLeft");
        MotorLeft.setDirection(DcMotor.Direction.REVERSE);
     waitForStart();
        moveforward(1,1);
        Thread.sleep(4500);
 }
}
