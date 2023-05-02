package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"USD","MacBook","$602.00"},
                {"GBP","iPhone","£75.46"},
                {"EUR","Canon EOS 5D","76.89€"}
        };
    }
}