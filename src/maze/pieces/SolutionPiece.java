package maze.pieces;

import maze.Direction;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class SolutionPiece extends EmptySpace{
    
    Direction direction;
    
    public SolutionPiece() {
        super();
    }
    
    public SolutionPiece(Direction direction) {
        this.direction = direction;
    }
    
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
}
