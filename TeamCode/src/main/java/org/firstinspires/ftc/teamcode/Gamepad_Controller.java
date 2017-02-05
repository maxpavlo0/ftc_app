/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */


@TeleOp(name="Gamepad_Controller", group="Linear Opmode")  // @Autonomous(...) is the other common choice

public class Gamepad_Controller extends LinearOpMode {



    /* Declare OpMode members. */


    @Override

    public void runOpMode()  {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        RobotClass robot = new RobotClass(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("left motor: ",robot.motorLeft.getCurrentPosition());

            telemetry.addData("right motor: ",robot.motorRight.getCurrentPosition());
            telemetry.update();

            robot.move(-gamepad1.right_stick_y, -gamepad1.left_stick_y);


            if (gamepad2.a || gamepad1.a ) {
                robot.suck(-1);

            }
            if (gamepad1.x || gamepad2.x )
            {
                robot.suck(0);
            }


            if (gamepad2.b || gamepad1.b) {
                robot.suck(1);
            }
            if (gamepad1.right_bumper) {
                robot.turnRight(0.2, 1);
            }
            if (gamepad1.left_bumper) {
                robot.turnLeft(1, 0.2);
            }

            if(gamepad1.dpad_down || gamepad2.dpad_down)
            {
                robot.moveForwardEncoders(1000,0.2,telemetry);
            }
            if (gamepad1.dpad_up || gamepad2.dpad_up)
            {
              robot.moveBackwardsEncoders(1000,0.2);
            }
            if (gamepad2.right_bumper)
            {
                robot.servoControlOpen();
            }
            if (gamepad2.left_bumper)
            {
                robot.servoControlClose();
            }
           // if(gamepad2.x)
           // {
             //   robot.shoot(1);
            //}

        }
    }
}





