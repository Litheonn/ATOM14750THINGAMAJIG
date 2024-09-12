package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;

@Autonomous(name="BackDropSideBlue")
public class BackDropSideBlue extends LinearOpMode {

    private DcMotor BackLeft;
    private DcMotor BackRight;
    private Blinker control_Hub;
    private Blinker expansion_Hub_6;
    private DcMotor intake;
    private DcMotor lift;
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
        FrontLeft.setPower(1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(1);

        sleep(time);
        end();
    }

    private void moveBackwards(int time) {
        FrontLeft.setPower(-1);
        FrontRight.setPower(-1);
        BackLeft.setPower(-1);
        BackRight.setPower(-1);

        sleep(time);
        end();
    }

    // Turning (Complete)
    private void turnRight(int time) {
        FrontLeft.setPower(1);
        FrontRight.setPower(-1);
        BackLeft.setPower(1);
        BackRight.setPower(-1);

        sleep(time);
        end();
    }

    private void turnLeft(int time) {
        FrontLeft.setPower(-1);
        FrontRight.setPower(1);
        BackLeft.setPower(-1);
        BackRight.setPower(1);

        sleep(time);
        end();
    }

    // Strafing (needs work)
    private void strafeLeft(int time) {
        FrontLeft.setPower(-1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(-1);

        sleep(time);
        end();
    }

    private void strafeRight(int time){
        FrontLeft.setPower(1);
        FrontRight.setPower(-1);
        BackLeft.setPower(-1);
        BackRight.setPower(1);

        sleep(time);
        end();
    }

    // Lift & servos (not used on robot currently)
    private void liftUp(int time){
        lift.setPower(0.5);
        sleep(time);

    }
    private void intakeIn(int time){
        intake.setPower(0.5);
        sleep(time);
    }
    private void intakeOut(int time){
        intake.setPower(-0.5);
        sleep(time);
    }
    // Servo code not implemented yet.


    @Override
    // Run method
    public void runOpMode() {
        lift = hardwareMap.get(DcMotor.class, "Lift");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        intake = hardwareMap.get(DcMotor.class, "Intake");

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
            strafeLeft(500);
          /*  sleep(2000);
          intakeOut(1000);
          sleep(2000);
          moveBackwards(600);
          sleep(2000);
          strafeLeft(700);
          sleep(2000);
          moveForward(300);
          sleep(2000);*/
        }
    }
}



