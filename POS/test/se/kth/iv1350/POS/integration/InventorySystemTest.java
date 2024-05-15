package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Martin Nylund
 */
public class InventorySystemTest {

    private InventorySystem inventorySystem;

    public InventorySystemTest() {
    }

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
    }

    /**
     * Test of checkIfItemExists method, of an item which should exist in the inventory.
     */
    @Test
    public void testCheckIfItemExists() throws Exception {
        String identifier = "Banana";
        ItemDescriptionDTO expResult = new ItemDescriptionDTO(12.5, 9, "Banana");
        ItemDescriptionDTO result = InventorySystem.checkIfItemExists(identifier);
        assertEquals(expResult, result, "The itemDescriptionDTO returned is not correct. ");
    }

    /**
     * Test of checkIfItemExists method, when the database connection is not online.
     */
    @Test
    public void testCheckIfItemExistsNoConnection() throws Exception {
        inventorySystem.setDatabaseConnected(false);
        String identifier = "Banana";
        ItemDescriptionDTO expResult = new ItemDescriptionDTO(12.5, 9, "Banana");
        ItemDescriptionDTO result = InventorySystem.checkIfItemExists(identifier);
        assertEquals(expResult, result, "The itemDescriptionDTO returned is not correct. ");
    }

}
