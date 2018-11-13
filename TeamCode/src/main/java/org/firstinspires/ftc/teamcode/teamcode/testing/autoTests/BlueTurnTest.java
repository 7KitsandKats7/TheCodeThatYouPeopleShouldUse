package org.firstinspires.ftc.teamcode.teamcode.testing.autoTests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.teamcode.mecanum.auto.BaseAuto;

/**
 * Created by USER on 2/24/2018.
 */

@Autonomous(name = "test mark find (blueTurn)", group = "test")
public class BlueTurnTest extends BaseAuto {

    @Override
    public void runOpMode() throws InterruptedException {
        setTeamColor(BLUE);

        super.runOpMode();
    }

    protected void alignToCryptobox() {
        autoDrive(26.5, 0.3, 8); // drive forward until robot is off of the platform.

        autoTurn(90, 0.3, 8, true);
        sleep(100);
        autoTurn(90, 0.4, 1, true);

        sleep(100);
        telemetry.log().add("%.2f", angles.firstAngle);
    }

}
