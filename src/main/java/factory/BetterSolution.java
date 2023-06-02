package factory;

public class BetterSolution {
    interface Product {
        default void ship(){};
    }

    class Chair implements Product {
    }

    class Bench implements Product {
    }

    class Store {

        final ProductFactory productFactory;

        Store(ProductFactory productFactory) {
            this.productFactory = productFactory;
        }

        void order(String productType){
            Product product = productFactory.createProduct(productType);
            product.ship();
        }


    }

    class ProductFactory{
         Product createProduct(String productType) {
             return switch (productType){
                 case "chair"-> new Chair();
                 case "bench"->new Bench();
                 default -> throw new RuntimeException("furniture is not manufactured");
             };
        }
    }
}
