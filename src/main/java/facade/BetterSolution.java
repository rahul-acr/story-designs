package facade;

public class BetterSolution {
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

    static class RepairShop{
        
        CarInspector carInspector = new CarInspector();
        OilChanger oilChanger = new OilChanger();
        BrakeChanger brakeChanger = new BrakeChanger();
        EngineServicer engineServicer = new EngineServicer();

        
        void repair(Car car){
            CarInspectionResult inspectionResult = carInspector.inspect(car);
            if(inspectionResult.isOilChangeRequired){
                oilChanger.changeOil(car);
            }
            if(inspectionResult.isBrakeChangeRequired){
                brakeChanger.changeBrakes(car);
            }
            if(inspectionResult.isEngineServicingRequired){
                engineServicer.serviceEngine(car);
            }
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        RepairShop repairShop = new RepairShop();
        repairShop.repair(car);
    }
}
