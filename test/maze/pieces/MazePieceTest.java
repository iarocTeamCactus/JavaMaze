package maze.pieces;

import java.awt.Color;
import maze.Direction;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class MazePieceTest {
    
    public MazePieceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNorth method, of class MazePiece.
     */
    @Test
    public void testGetNorth() {
        System.out.println("getNorth");
        MazePiece instance = new MazePieceImpl();
        MazePiece expResult = null;
        MazePiece result = instance.getNorth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNorth method, of class MazePiece.
     */
    @Test
    public void testSetNorth() {
        System.out.println("setNorth");
        MazePiece piece = null;
        MazePiece instance = new MazePieceImpl();
        instance.setNorth(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSouth method, of class MazePiece.
     */
    @Test
    public void testGetSouth() {
        System.out.println("getSouth");
        MazePiece instance = new MazePieceImpl();
        MazePiece expResult = null;
        MazePiece result = instance.getSouth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSouth method, of class MazePiece.
     */
    @Test
    public void testSetSouth() {
        System.out.println("setSouth");
        MazePiece piece = null;
        MazePiece instance = new MazePieceImpl();
        instance.setSouth(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEast method, of class MazePiece.
     */
    @Test
    public void testGetEast() {
        System.out.println("getEast");
        MazePiece instance = new MazePieceImpl();
        MazePiece expResult = null;
        MazePiece result = instance.getEast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEast method, of class MazePiece.
     */
    @Test
    public void testSetEast() {
        System.out.println("setEast");
        MazePiece piece = null;
        MazePiece instance = new MazePieceImpl();
        instance.setEast(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWest method, of class MazePiece.
     */
    @Test
    public void testGetWest() {
        System.out.println("getWest");
        MazePiece instance = new MazePieceImpl();
        MazePiece expResult = null;
        MazePiece result = instance.getWest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWest method, of class MazePiece.
     */
    @Test
    public void testSetWest() {
        System.out.println("setWest");
        MazePiece piece = null;
        MazePiece instance = new MazePieceImpl();
        instance.setWest(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirection method, of class MazePiece.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Direction direction = null;
        MazePiece instance = new MazePieceImpl();
        MazePiece expResult = null;
        MazePiece result = instance.getDirection(direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirection method, of class MazePiece.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        MazePiece piece = null;
        Direction direction = null;
        MazePiece instance = new MazePieceImpl();
        instance.setDirection(piece, direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class MazePiece.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        MazePiece instance = new MazePieceImpl();
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class MazePiece.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        MazePiece instance = new MazePieceImpl();
        double expResult = 0.0;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class MazePiece.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        MazePiece instance = new MazePieceImpl();
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MazePieceImpl implements MazePiece {

        @Override
        public MazePiece getNorth() {
            return null;
        }

        @Override
        public void setNorth(MazePiece piece) {
        }

        @Override
        public MazePiece getSouth() {
            return null;
        }

        @Override
        public void setSouth(MazePiece piece) {
        }

        @Override
        public MazePiece getEast() {
            return null;
        }

        @Override
        public void setEast(MazePiece piece) {
        }

        @Override
        public MazePiece getWest() {
            return null;
        }

        @Override
        public void setWest(MazePiece piece) {
        }

        @Override
        public MazePiece getDirection(Direction direction) {
            return null;
        }

        @Override
        public void setDirection(MazePiece piece, Direction direction) {
        }

        @Override
        public double getWidth() {
            return 0.0;
        }

        @Override
        public double getHeight() {
            return 0.0;
        }

        @Override
        public Color getColor() {
            return null;
        }
    }
}
