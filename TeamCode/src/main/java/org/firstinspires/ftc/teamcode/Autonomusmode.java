package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by User on 02/02/2017.
 */

public class Autonomusmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotClass robot=new RobotClass(hardwareMap);
      robot.MotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.MotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        robot.moveForward_encoders(100,0.2,telemetry);
        Thread.sleep(2000);




    }
}
