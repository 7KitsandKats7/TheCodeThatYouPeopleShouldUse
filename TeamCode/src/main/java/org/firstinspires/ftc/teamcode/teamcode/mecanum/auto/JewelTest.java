package org.firstinspires.ftc.teamcode.teamcode.mecanum.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

/**
 * Created by USER on 2/8/2018.
 */

@Disabled
@Autonomous(name="Jewel Test", group="Test")
public class JewelTest extends BaseAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        initGyro();

        telemetry.log().add("ready to start");

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("pos", gamepad1.left_stick_y);
            telemetry.update();
        }

        autoTurn(10, 0.4, 3, true);

        autoTurn(0, 0.4, 3, true);
    }

}
