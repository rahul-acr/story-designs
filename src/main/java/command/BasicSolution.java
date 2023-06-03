package command;

public class BasicSolution {

    static class Rover {
        void moveForward(int distanceInMeters ) {
        }

        void moveBackward(int distanceInMeters) {
        }

        void rotate(double angleInDegrees) {
        }

        void scan() {
        }

        void collectSample() {
        }
    }

    static class RoverService{
        void scanAndCollectSample(Rover rover){
            rover.scan();
            rover.collectSample();
        }

        void rotateAndMove(Rover rover, double angle, int distance){
            rover.rotate(angle);
            rover.moveForward(distance);
        }
    }


    public static void main(String[] args) {
        Rover rover = new Rover();
        RoverService roverService = new RoverService();
        roverService.rotateAndMove(rover, 45, 10);
        roverService.rotateAndMove(rover, 180, 50);
        roverService.scanAndCollectSample(rover);
    }
}
