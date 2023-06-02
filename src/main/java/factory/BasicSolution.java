package factory;

public class BasicSolution {


    interface Product {
        default void ship() {
        }
    }

    class Chair implements Product {
    }

    class Bench implements Product {
    }

    class Store {
        void order(String productType) {
            Product product = switch (productType) {
                case "chair" -> new Chair();
                case "bench" -> new Bench();
                default -> throw new RuntimeException("furniture is not manufactured");
            };
            product.ship();
        }
    }

}
