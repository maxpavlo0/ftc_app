package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by User on 29/01/2017.
 */

public class RobotClass {

    public DcMotor MotorLeft = null;
   public   DcMotor MotorRight=null;
    public  DcMotor Motorpushsuck=null;
    public void RobotClass(HardwareMap hardwareMap)
    {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight=hardwareMap.dcMotor.get("MotorRight");
        Motorpushsuck=hardwareMap.dcMotor.get("Motorpushsuck");


    }


}
