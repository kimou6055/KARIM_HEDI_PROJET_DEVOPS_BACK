package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveProduct() {
        // Arrange
        Long productId = 1L;
        String productName = "Sample Product";
        float price = 100.0f;
        int quantity = 10;
        ProductCategory category = ProductCategory.ELECTRONICS; // Adjust category if needed
        Stock stock = new Stock(); // Initialize Stock appropriately if needed

        // Using the complete constructor as per the error message
        Product mockProduct = new Product(productId, productName, price, quantity, category, stock);

        when(productService.retrieveProduct(productId)).thenReturn(mockProduct);

        // Act
        Product retrievedProduct = productController.retrieveProduct(productId);

        // Assert
        assertNotNull(retrievedProduct, "The retrieved product should not be null");
        assertEquals(productId, retrievedProduct.getProductId(), "The product ID should match the expected value"); // Adjust getter if needed
        assertEquals(productName, retrievedProduct.getProductName(), "The product name should match the expected value"); // Adjust getter if needed
    }
}
