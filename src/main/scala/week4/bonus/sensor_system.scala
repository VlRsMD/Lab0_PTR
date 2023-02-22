package week4.bonus

import akka.actor._

class wheel_sensor extends Actor {
  def receive = {
    case m: String => println("Message received.")
  }
}

class wheel_sensor_supervisor extends Actor {
  val wheel_sensor_actor = context.actorOf(Props[wheel_sensor], name = "wheel_sensor")
  context.watch(wheel_sensor_actor)
  def receive = {
    case m: String => println("Message received.")
    case Terminated(wheel_sensor_actor) => {
      val new_wheel_sensor = ActorSystem().actorOf(Props(new wheel_sensor))
      println("Wheel sensor restarted")
      new_wheel_sensor ! "Message"
    }
  }
}

class cabin_sensor extends Actor {
  def receive = {
    case m: String => println("Message received.")
  }
}

class motor_sensor extends Actor {
  def receive = {
    case m: String => println("Message received.")
  }
}

class chassis_sensor extends Actor {
  def receive = {
    case m: String => println("Message received.")
  }
}

class airbags extends Actor {
  def receive = {
    case m: String => println("Message received.")
  }
}

class sensor_system extends Actor {
  val wheel_sensor_supervisor_actor = context.actorOf(Props[wheel_sensor_supervisor], name = "wheel_sensor_supervisor")
  val cabin_actor = context.actorOf(Props[cabin_sensor], name = "cabin_sensor")
  val motor_actor = context.actorOf(Props[motor_sensor], name = "motor_sensor")
  val chassis_actor = context.actorOf(Props[chassis_sensor], name = "chassis_sensor")
  context.watch(wheel_sensor_supervisor_actor)
  context.watch(cabin_actor)
  context.watch(motor_actor)
  context.watch(chassis_actor)

  def receive = {
    case Terminated(wheel_sensor_supervisor_actor) => {
      supervise.i += 1
      val new_wheel_sensor_supervisor = ActorSystem().actorOf(Props(new wheel_sensor_supervisor))
      println("Wheel sensor supervisor restarted")
      new_wheel_sensor_supervisor ! "Message"
      val cabin_sensor = ActorSystem().actorOf(Props(new cabin_sensor))
      println("Cabin sensor restarted")
      cabin_sensor ! "Message"
      val motor_sensor = ActorSystem().actorOf(Props(new motor_sensor))
      println("Motor sensor restarted")
      motor_sensor ! "Message"
      val chassis_sensor = ActorSystem().actorOf(Props(new chassis_sensor))
      println("Chassis sensor restarted")
      chassis_sensor ! "Message"
    }
  }
  if (supervise.i==3) {
    val airbags_actor = ActorSystem().actorOf(Props(new airbags))
    println("Deploy airbags")
    airbags_actor ! "Deploy"
  }
}

object supervise extends App {
  var i: Int = 0
  val system = ActorSystem("Sensor_System")
  val sensorSupervisorA = system.actorOf(Props[sensor_system], name = "supervisor")
  val wheelSensorSupervisorA = system.actorSelection("user/supervisor/wheel_sensor_supervisor")
  val wheelSensorA1 = system.actorSelection("user/supervisor/wheel_sensor_supervisor/wheel_sensor")
  val wheelSensorA2 = system.actorSelection("user/supervisor/wheel_sensor_supervisor/wheel_sensor")
  val wheelSensorA3 = system.actorSelection("user/supervisor/wheel_sensor_supervisor/wheel_sensor")
  val wheelSensorA4 = system.actorSelection("user/supervisor/wheel_sensor_supervisor/wheel_sensor")
  val cabinSensorA = system.actorSelection("user/supervisor/cabin_sensor")
  val motorSensorA = system.actorSelection("user/supervisor/motor_sensor")
  val chassisSensorA = system.actorSelection("user/supervisor/chassis_sensor")
  wheelSensorA2 ! PoisonPill
  Thread.sleep(1000)
  cabinSensorA ! PoisonPill
}
