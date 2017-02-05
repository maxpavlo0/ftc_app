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
        


        robot.moveForwardEncoders(4260,0.7,telemetry);
        robot.turnLeft(300,0.4);
        robot.moveForwardEncoders(400,0.6,telemetry);
        robot.moveBackwardsEncoders(500,0.6);
        robot.turnLeft(200,0.4);
        robot.moveForwardEncoders(300,0.8,telemetry);
        robot.turnLeft(300,0.5);
        robot.moveForwardEncoders(400,0.5,telemetry);
        robot.suck(1);


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
