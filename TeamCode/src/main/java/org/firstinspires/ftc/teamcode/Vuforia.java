package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Vuforia")
public class Vuforia extends LinearOpMode {
    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters pereameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastknownLocation;
    OpenGLMatrix phoneLocation;

    public void runOpMode() throws  InterruptedException
    {
        waitForStart();
        while (opModeIsActive())
        {
            telemetry.update();
            idle();
        }

    }


}
