package se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.POS.integration.ItemDescriptionDTO;

/**
 *
 * @author Martin Nylund
 */
public class ControllerTest {
    private Controller controller;
    
    public ControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }
    
    @AfterEach
    public void tearDown() {
        controller = null;
    }

    /**
     * Test of searchItem method, when an invalid identifier is being used.
     */
    @Test
    public void testSearchItemInvalidIdentifier() throws Exception {
        String identifier = "juice";
        ItemDescriptionDTO expResult = null;
        ItemDescriptionDTO result = controller.searchItem(identifier);
        assertEquals(expResult, result);
    }
}
