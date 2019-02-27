package Podsumowanie.Wzorce.Fabryka;

/*


public interface Robot {
    public void work();
}

 */

class LazyRobot implements Robot {
    @Override
    public void work() {
        System.out.println("Im sleeping");
    }
}

class FunnyRobot implements Robot{
    @Override
    public void work() {
        System.out.println("Telling a joke");
    }
}

public class RobotFactory {
    public Robot makeRobot(String robotType){
        if(robotType == "lazy robot"){
            return new LazyRobot();
        }
        if(robotType == "funny robot"){
            return new FunnyRobot();
        }
        return null;
    }
}

class Fabryka {

    public static void main(String[] args) {
        RobotFactory robotFactory = new RobotFactory();

        Robot funny = robotFactory.makeRobot("funny robot");
        Robot lazy = robotFactory.makeRobot("lazy robot");

        lazy.work();
        funny.work();
    }
}
