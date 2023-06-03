package command;

public class BetterSolution {

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

    interface RoverCommand {
        void execute(Rover rover);
    }

    static class RotateAndMoveCommand implements RoverCommand{

        final double angle;
        final int distance;

        public RotateAndMoveCommand(double angle, int distance) {
            this.angle = angle;
            this.distance = distance;
        }

        @Override
        public void execute(Rover rover) {
            rover.rotate(angle);
            rover.moveForward(distance);
        }
    }

    static class ScanAndCollectSampleCommand implements RoverCommand{
        @Override
        public void execute(Rover rover) {
            rover.scan();
            rover.collectSample();
        }
    }

    static class CommandExecutor{

        final Rover rover;

        CommandExecutor(Rover rover) {
            this.rover = rover;
        }

        void command(RoverCommand command){
            command.execute(rover);
        }
    }

    public static void main(String[] args) {
        Rover rover = new Rover();
        CommandExecutor executor = new CommandExecutor(rover);
        executor.command(new RotateAndMoveCommand(45.0, 10));
        executor.command(new ScanAndCollectSampleCommand());
    }
}
