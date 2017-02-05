package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by User on 02/02/2017.
 */
    @Autonomous(name = "autonomusencoders")
public class Autonomusmode1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotClass robot = new RobotClass(hardwareMap);

        waitForStart();
        robot.moveForwardEncoders(4320, 0.7, telemetry);
        robot.turnLeftEncoders(1000,0.5);
        robot.moveForwardEncoders(300,0.8,telemetry);
        robot.moveBackwardsEncoders(300,0.8);
        robot.turnLeftEncoders(1000,0.8);
        robot.moveBackwardsEncoders(3000,0.7);
        robot.turnLeftEncoders(1000,0.4);
        robot.moveForwardEncoders(1000,0.4,telemetry);
        robot.turnLeftEncoders(1000,0.2);
        robot.moveBackwardsEncoders(500,1);
        robot.suck(-1);
        /** Robot Start Position
             //.     .
         //(.)
          //.
         */
        //drive to shooting position
        //shoot 2 balls
        //move & bump into big ball
        //Go to beacon
        //Find our button by color
        // go to other close beacon
        //Find our button by color
    }
}
