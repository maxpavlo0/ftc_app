package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by User on 02/02/2017.
 */

public class Autonomusmode1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotClass robot = new RobotClass(hardwareMap);

        waitForStart();
        robot.moveForwardEncoders(100, 0.2, telemetry);
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
