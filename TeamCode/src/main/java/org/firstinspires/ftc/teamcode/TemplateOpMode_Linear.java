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

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */


@TeleOp(name="Template: Linear OpMode", group="Linear Opmode")  // @Autonomous(...) is the other common choice

public class TemplateOpMode_Linear extends LinearOpMode {
    public  DcMotor MotorLeft;
    public DcMotor MotorRight;
    public DcMotor Motorpushsuck;

    private void move(double powerRight,double powerLeft)
    {
        MotorRight.setPower(powerRight);
        MotorLeft.setPower(powerLeft);
    }
    public void  suck(double powersuck)
    {
        Motorpushsuck.setPower(powersuck);
    }
    private void turnLeft(double power)
    {
        MotorRight.setPower(power);
        MotorLeft.setPower(power/3);
    }
    public void turnarpund(double powerright,double powerleft)
    {
        MotorLeft.setPower(-powerleft);
        MotorRight.setPower(powerright);
    }
    private void turnRight(double power)
    {
        MotorRight.setPower(power/3);
        MotorLeft.setPower(power);
    }
    /* Declare OpMode members. */



    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight = hardwareMap.dcMotor.get("MotorRight");
        Motorpushsuck = hardwareMap.dcMotor.get("Motorpushsuck");

        waitForStart();

        while (opModeIsActive())
        {
            telemetry.update();
            move(-gamepad1.right_stick_y,-gamepad1.left_stick_y);
           if (gamepad1.a)
            {
                suck(1);
            }
           else
            {
               suck(0);
           }
           if (gamepad1.b)
            {
               suck(1);
          }
            else
            {
                suck(0);
            }
            // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)
           MotorRight.setPower(-gamepad1.right_stick_y);
            MotorLeft.setPower(-gamepad1.left_stick_y);
        }
    }

}
