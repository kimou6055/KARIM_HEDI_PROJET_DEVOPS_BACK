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
        String productTitle = "Sample Product";
        float price = 100.0f;
        int quantity = 10;
        ProductCategory category = ProductCategory.ELECTRONICS; // Adjust category if needed
        Stock stock = new Stock(); // Initialize Stock appropriately if needed

        // Create Product using constructor with all arguments
        Product mockProduct = new Product(productId, productTitle, price, quantity, category, stock);

        when(productService.retrieveProduct(productId)).thenReturn(mockProduct);

        // Act
        Product retrievedProduct = productController.retrieveProduct(productId);

        // Assert
        assertNotNull(retrievedProduct, "The retrieved product should not be null");
        assertEquals(productId, retrievedProduct.getIdProduct(), "The product ID should match the expected value");
        assertEquals(productTitle, retrievedProduct.getTitle(), "The product title should match the expected value");
    }
}
