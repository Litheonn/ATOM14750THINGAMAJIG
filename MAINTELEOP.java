package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// The file is currently called mainthingy.java on the robot's storage...?
@TeleOp(name = "MAINTELEOP")
public class MAINTELEOP extends LinearOpMode {


    private DcMotor FrontRight;
    private DcMotor BackRight;
    private DcMotor FrontLeft;
    private DcMotor BackLeft;
    private DcMotor ArmMotor;
    private DcMotor LiftMotor;

    private Servo Intake;


    private void IntakeIn() {
        if (gamepad2.a){
            Intake.setPosition(1);
        }
    }

    private void IntakeOut(){
        if (gamepad2.y){
            Intake.setPosition(0);
        }
    }


    private void DPadUp() {
        while (gamepad1.dpad_up) {
            FrontLeft.setPower(1);
            FrontRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(1);
        }
    }

    private void DPadBackwards() {
        while (gamepad1.dpad_down) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(-1);
        }
    }

    private void DPadRight() {
        if (gamepad1.dpad_right) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void DPadLeft() {
        if (gamepad1.dpad_left) {
            FrontLeft.setPower(1);
            FrontRight.setPower(-1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeLeft() {
        if (gamepad1.x) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeRight() {
        if (gamepad1.b) {
            FrontLeft.setPower(1);
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void Diag1() {
        if (gamepad1.left_bumper) {
            FrontRight.setPower(1);
            BackLeft.setPower(1);
        }
    }

    private void Diag2() {
        if (gamepad1.right_bumper) {
            FrontLeft.setPower(1);
            BackRight.setPower(1);
        }
    }

    private void Diag3() {
        if (gamepad1.y) {
            FrontLeft.setPower(-1);
            BackRight.setPower(-1);
        }
    }

    private void Diag4() {
        if (gamepad1.a) {
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
        }
    }
private void LiftUp () {
        while (gamepad2.dpad_up) {
            LiftMotor.setPower(0.5);
        }
}
    private void LiftDown () {
        while (gamepad2.dpad_up) {
            LiftMotor.setPower(-0.5);
        }
    }
    private void ArmUp () {
        while (gamepad2.dpad_right) {
            ArmMotor.setPower(0.5);
        }
    }
    private void ArmDown () {
        while (gamepad2.dpad_left) {
            ArmMotor.setPower(-0.5);
        }
    }

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {

        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        ArmMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        LiftMotor = hardwareMap.get(DcMotor.class, "LiftMotor");
        Intake = hardwareMap.get(Servo.class, "Intake");

        // Put initialization blocks here.
        waitForStart();
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here
                IntakeIn();
                IntakeOut();
                DPadLeft();
                DPadRight();
                DPadUp();
                DPadBackwards();
                StrafeLeft();
                StrafeRight();
                Diag1();
                Diag2();
                Diag3();
                Diag4();
                LiftUp();
                LiftDown();
                ArmUp();
                ArmDown();
                FrontRight.setPower(-gamepad1.right_stick_y);
                BackRight.setPower(-gamepad1.right_stick_y);
                FrontLeft.setPower(-gamepad1.left_stick_y);
                BackLeft.setPower(-gamepad1.left_stick_y);
                LiftMotor.setPower(gamepad2.right_stick_y);
                telemetry.update();
                // Put loop blocks here.
                telemetry.update();
            }
        }
    }
}
