package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name="EncoderAutonomous")
public class EncoderAutonomous extends LinearOpMode {
    // @Override
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;


        // Position of the arm when it's lifted
        int ForwardPosition = 537;
       int Position2 = 1074;
        int Position3 = 2148;
        int PositionTurnLeft = 537;
        int PositionTurnRight = 537;
        int ForwardPosition2 = 540;
        // Position of the arm when it's down
        int StopPosition = 0;
        public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);

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


        if (opModeIsActive()) {
            // If the A button is pressed, raise the arm
            sleep(1000);
            GoStopPosition();
            sleep(2000);
            GoForwardPosition();
            sleep(2000);
            GoPosition2();
           sleep(2000);
           GoPosition3();
           sleep(2000);
           GoTurnPositionLeft();
           sleep(2000);

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

    private void GoPosition2() {

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
    private void GoPosition3() {
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
    private void GoForwardPosition() {
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
    public void GoStopPosition() {
        FrontLeft.setTargetPosition(StopPosition);
        FrontRight.setTargetPosition(StopPosition);
        BackLeft.setTargetPosition(StopPosition);
        BackRight.setTargetPosition(StopPosition);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setPower(0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(0.5);
        BackRight.setPower(0.5);
    }
    public void GoTurnPositionLeft() {
        FrontLeft.setTargetPosition(PositionTurnLeft);
        BackLeft.setTargetPosition(PositionTurnLeft);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeft.setPower(0.5);
        BackLeft.setPower(0.5);
    }
    public void GoTurnPositionRight() {
        FrontRight.setTargetPosition(PositionTurnRight);
        BackRight.setTargetPosition(PositionTurnRight);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setPower(0.5);
        BackRight.setPower(0.5);
    }
    private void GoForwardPosition2() {
        FrontLeft.setTargetPosition(ForwardPosition2);
        FrontRight.setTargetPosition(ForwardPosition2);
        BackLeft.setTargetPosition(ForwardPosition2);

        BackRight.setTargetPosition(ForwardPosition2);
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
}
