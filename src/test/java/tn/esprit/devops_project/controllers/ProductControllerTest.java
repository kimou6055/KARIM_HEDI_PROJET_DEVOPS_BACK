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
        Product mockProduct = new Product();
        mockProduct.setId(productId);
        mockProduct.setName("Sample Product");

        when(productService.retrieveProduct(productId)).thenReturn(mockProduct);

        // Act
        Product retrievedProduct = productController.retrieveProduct(productId);

        // Assert
        assertNotNull(retrievedProduct, "The retrieved product should not be null");
        assertEquals(productId, retrievedProduct.getId(), "The product ID should match the expected value");
        assertEquals("Sample Product", retrievedProduct.getName(), "The product name should match the expected value");
    }
}
