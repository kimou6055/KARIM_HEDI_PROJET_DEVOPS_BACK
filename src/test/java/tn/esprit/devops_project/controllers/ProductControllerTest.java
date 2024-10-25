package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Product;
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
        // Assuming Product has a constructor Product(Long id, String name) or adjust accordingly
        Product mockProduct = new Product(productId, "Sample Product"); // Adjust constructor parameters if different

        when(productService.retrieveProduct(productId)).thenReturn(mockProduct);

        // Act
        Product retrievedProduct = productController.retrieveProduct(productId);

        // Assert
        assertNotNull(retrievedProduct, "The retrieved product should not be null");
        assertEquals(productId, retrievedProduct.getId(), "The product ID should match the expected value"); // Adjust getter if needed
        assertEquals("Sample Product", retrievedProduct.getName(), "The product name should match the expected value"); // Adjust getter if needed
    }
}
