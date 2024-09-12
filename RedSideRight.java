package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;

@Autonomous(name="RedSideRight")
public class RedSideRight extends LinearOpMode {

    private DcMotor BackLeft;
    private DcMotor BackRight;
    private Blinker control_Hub;
    private Blinker expansion_Hub_6;
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private Gyroscope imu;

    // Stops all movement for movement methods that are below it.
    private void end() {
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }


    // Note: The time parameter defines how long the method will run.

    // Intake methods (complete)


    // Straight line movement (Complete)
    private void moveForward(int time) {
        FrontLeft.setPower(0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(0.5);
        BackRight.setPower(0.5);

        sleep(time);
        end();
    }

    private void moveBackwards(int time) {
        FrontLeft.setPower(-0.5);
        FrontRight.setPower(-0.5);
        BackLeft.setPower(-0.5);
        BackRight.setPower(-0.5);

        sleep(time);
        end();
    }

    // Turning (Complete)
    private void turnRight(int time) {
        FrontLeft.setPower(0.5);
        FrontRight.setPower(-0.5);
        BackLeft.setPower(0.5);
        BackRight.setPower(-0.5);

        sleep(time);
        end();
    }

    private void turnLeft(int time) {
        FrontLeft.setPower(-0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(-0.5);
        BackRight.setPower(0.5);

        sleep(time);
        end();
    }

    // Strafing (needs work)
    private void strafeLeft(int time) {
        FrontLeft.setPower(-0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(0.5);
        BackRight.setPower(-0.5);

        sleep(time);
        end();
    }

    private void strafeRight(int time){
        FrontLeft.setPower(0.5);
        FrontRight.setPower(-0.5);
        BackLeft.setPower(-0.5);
        BackRight.setPower(0.5);

        sleep(time);
        end();
    }


    // Servo code not implemented yet.


    @Override
    // Run method
    public void runOpMode() {
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");

        // Put initialization blocks here.
        waitForStart();
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        // BackLeft.setDirection(DcMotor.Direction.REVERSE);


        if (opModeIsActive()); {
            // Put run blocks here.
            /* Below code is just testing. 4 second starting delay,
             * 2 second delay between movements. */
            sleep(1000);
            moveForward(1000);
            turnRight(700);
            moveBackwards(2000);
            strafeLeft(1000);

        }
    }
}