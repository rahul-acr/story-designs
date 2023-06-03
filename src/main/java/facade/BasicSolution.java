package facade;

public class BasicSolution {

    static class Car {

    }

    static class CarInspector{
        CarInspectionResult inspect(Car car){
            return new CarInspectionResult(true, false, true);
        }

    }

    private static class CarInspectionResult {
        boolean isOilChangeRequired;
        boolean isEngineServicingRequired;
        boolean isBrakeChangeRequired;

        public CarInspectionResult(boolean isOilChangeRequired,
                                   boolean isEngineServicingRequired,
                                   boolean isBrakeChangeRequired) {
            this.isOilChangeRequired = isOilChangeRequired;
            this.isEngineServicingRequired = isEngineServicingRequired;
            this.isBrakeChangeRequired = isBrakeChangeRequired;
        }
    }

    static class OilChanger{
        void changeOil(Car car){
            System.out.println("Changing oil of "+car);
        }
    }


    static class EngineServicer {
        void serviceEngine(Car car){
            System.out.println("Servicing engine of "+car);
        }
    }


    static class BrakeChanger{
        void changeBrakes(Car car){
            System.out.println("Changing brakes of "+car);
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        CarInspectionResult inspectionResult = new CarInspector().inspect(car);
        if(inspectionResult.isOilChangeRequired){
            new OilChanger().changeOil(car);
        }
        if(inspectionResult.isBrakeChangeRequired){
            new BrakeChanger().changeBrakes(car);
        }
        if(inspectionResult.isEngineServicingRequired){
            new EngineServicer().serviceEngine(car);
        }
    }

}
