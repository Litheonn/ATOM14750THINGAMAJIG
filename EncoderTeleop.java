package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class EncoderTeleop extends LinearOpMode {
    // @Override
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    public void runOpMode() throws InterruptedException {
        // Position of the arm when it's lifted
        int ForwardPosition = 537;
        int Position2 = 1074;
        int Position3 = 2148;
        // Position of the arm when it's down
        int StopPosition = 0;

        // Find a motor in the hardware map named "Arm Motor"
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);

        // Reset the motor encoder so that it reads zero ticks
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Sets the starting position of the arm to the down position
        FrontLeft.setTargetPosition(StopPosition);
        FrontRight.setTargetPosition(StopPosition);
        BackLeft.setTargetPosition(StopPosition);
        BackRight.setTargetPosition(StopPosition);
        //Break
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        while (opModeIsActive()) {
            // If the A button is pressed, raise the arm
            if (gamepad1.a)  {
                FrontLeft.setTargetPosition(ForwardPosition);
                FrontRight.setTargetPosition(ForwardPosition);
                BackLeft.setTargetPosition(ForwardPosition);

                BackRight.setTargetPosition(ForwardPosition);
                //break
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.5);
                FrontRight.setPower(0.5);
                BackLeft.setPower(0.5);
                BackRight.setPower(0.5);
            }

            // If the B button is pressed, lower the arm
            if (gamepad1.b) {
                FrontLeft.setTargetPosition(StopPosition);
                FrontRight.setTargetPosition(StopPosition);
                BackLeft.setTargetPosition(StopPosition);
                BackRight.setTargetPosition(StopPosition);
                FrontLeft.setTargetPosition(StopPosition);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.5);
                FrontRight.setPower(0.5);
                BackLeft.setPower(0.5);
                BackRight.setPower(0.5);
            }
            if (gamepad1.y) {
                FrontRight.setTargetPosition(Position2);
                BackLeft.setTargetPosition(Position2);
                BackRight.setTargetPosition(Position2);
                FrontLeft.setTargetPosition(Position2);
                //break
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.5);
                FrontRight.setPower(0.5);
                BackLeft.setPower(0.5);
                BackRight.setPower(0.5);
            }
            if (gamepad1.x) {
                FrontRight.setTargetPosition(Position3);
                BackLeft.setTargetPosition(Position3);
                BackRight.setTargetPosition(Position3);
                FrontLeft.setTargetPosition(Position3);
                //break
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.5);
                FrontRight.setPower(0.5);
                BackLeft.setPower(0.5);
                BackRight.setPower(0.5);
            }
            // Get the current position of the armMotor
            double position = FrontLeft.getCurrentPosition();

            // Get the target position of the armMotor
            double desiredPosition = FrontLeft.getTargetPosition();

            // Show the position of the armMotor on telemetry
            telemetry.addData("Encoder Position", position);

            // Show the target position of the armMotor on telemetry
            telemetry.addData("Desired Position", desiredPosition);

            telemetry.update();
        }
    }
}