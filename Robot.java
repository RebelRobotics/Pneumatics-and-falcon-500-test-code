// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Robot extends TimedRobot {
  private final Joystick m_stick = new Joystick(0);

  // DoubleSolenoid corresponds to a double solenoid.
  private final DoubleSolenoid m_doubleSolenoid =
    new DoubleSolenoid(2, PneumaticsModuleType.CTREPCM, 0, 1);

  TalonFX falcon = new TalonFX(1);
  
  double X = m_stick.getX();
  double Y = m_stick.getY();
  double MotorSpeed = 0.2;
  double falVelcotiy = falcon.getSelectedSensorVelocity();
  double falPos = falcon.getSelectedSensorPosition();
  double RPM = falVelcotiy*10*60/2048;
  double Pos = 0;
  

  // private static final int kSolenoidButton = 1;
  private static final int kDoubleSolenoidForward = 1;
  private static final int kDoubleSolenoidReverse = 2;
  @Override
  public void teleopInit() {
    falcon.configFactoryDefault();
    // falcon.configClearPositionOnQuadIdx(true, 1);
    /*
    falcon.configClearPositionOnLimitR(true, 0);
    falcon.configClearPositionOnLimitF(true, 0);
    */
    // falcon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
  }
  @Override
  public void teleopPeriodic() {
    /*
     * The output of GetRawButton is true/false depending on whether
     * the button is pressed; Set takes a boolean for whether
     * to use the default (false) channel or the other (true).
     */
    // m_solenoid.set(m_stick.getRawButton(kSolenoidButton));


    /*
     * In order to set the double solenoid, if just one button
     * is pressed, set the solenoid to correspond to that button.
     * If both are pressed, set the solenoid will be set to Forwards.
     */
    /*
    if (m_stick.getRawButton(kDoubleSolenoidForward)) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kDoubleSolenoidReverse)) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    */

    X = m_stick.getX();
    Y = m_stick.getY();
    falVelcotiy = falcon.getSelectedSensorVelocity();
    falPos = falcon.getSelectedSensorPosition();
    Pos = falPos;
    RPM = falVelcotiy*10*60/2048;
    falcon.set(ControlMode.PercentOutput, X*MotorSpeed);
    
    //System.out.println(RPM);
    System.out.println(Pos);

  }
}
