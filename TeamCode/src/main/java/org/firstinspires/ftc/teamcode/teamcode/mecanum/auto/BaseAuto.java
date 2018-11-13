package org.firstinspires.ftc.teamcode.teamcode.mecanum.auto;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaRoverRuckus;
import org.firstinspires.ftc.teamcode.teamcode.RunUntil;
import org.firstinspires.ftc.teamcode.teamcode.mecanum.MecanumOpMode;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.disnodeteam.dogecv.detectors.roverrukus.SamplingOrderDetector;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Base autonomous class that removes the correct jewel, places a glyph, and parks in the safe zone.
 * The {@link com.qualcomm.robotcore.eventloop.opmode.Autonomous} opModes all extend this class.
 * They declare their color and each autonomous has a different method to align to the cryptobox.
 */

public abstract class BaseAuto extends MecanumOpMode {
    private GoldAlignDetector detector;

    private boolean teamColor;

    /**
     * Main autonomous code. <br/>
     *      1. initialize robot, gyro, jewel detector <br/>
     *      2. read jewel order after waiting 1 second <br/>
     *      3. wait for start <br/>
     *      4. initialize Vuforia <br/>
     *      5. remove the correct jewel <br/>
     *      6. turn and scan pictograph <br/>
     *      7. align to starting rotation <br/>
     *      8. drive/align to cryptobox <br/>
     *      9. move to correct column <br/>
     *      10.place the glyph
     * @throws InterruptedException When the program is stopped.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        initGyro();

//        leftColor = hardwareMap.get(ColorSensor.class, "leftColor"); // TODO: add sensors and program them
//        rightColor = hardwareMap.get(ColorSensor.class, "rightColor");

        sleep(1000);

        telemetry.log().add("ready to start");

        waitForStart();

        autoTurn(5, 0.25, 3, true);

        autoTurn(0, 0.2, 3, true);

        autoTurn( 0, 0.2, 5, true);
        sleep(100);
        autoTurn( 0, 0.25, 1, true);


        sleep(1000);
    }

    /**
     * Tells the program which color jewel to go for and adjusts a few other parts of it.
     * @param teamColor the color of the autonomous
     */
    protected void setTeamColor(boolean teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * Uses the collector motors to eject the glyph into a cryptobox column.
     * This method can place the glyphs into the cryptobox even if it isn't
     * aligned properly. Whenever it is misaligned, whichever side of the
     * cryptobox divider has more distance has more torque, so the glyph is
     * pushed even farther in that direction, magnifying the effect.
     */

    @Override
    public void stop() {
        super.stop();
    }
}
