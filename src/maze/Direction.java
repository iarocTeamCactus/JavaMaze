package maze;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public interface Direction {

    //
    // Direction is an interface that is intended to map the cardinal
    // directions, NORTH, SOUTH, EAST, and WEST.
    //
    // set the Xdiff and Ydiff for the four cardinal directions as such:
    //        xdiff | ydiff
    // NORTH:   0       1
    // SOUTH:   0      -1
    // EAST:    1       0
    // WEST:   -1       0
    //
    
    public int getXdiff();

    public int getYdiff();
    
    public Direction oppositeDirection();
}
