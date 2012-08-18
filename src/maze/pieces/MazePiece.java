/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.pieces;

import java.awt.Color;
import maze.Direction;

/**
 *
 * @author Rob
 */
public interface MazePiece {
    public MazePiece getNorth();
    public void setNorth( MazePiece piece);
    
    public MazePiece getSouth();
    public void setSouth( MazePiece piece);
    
    public MazePiece getEast();
    public void setEast( MazePiece piece);
    
    public MazePiece getWest();
    public void setWest( MazePiece piece);
    
    public MazePiece getDirection( Direction direction);
    public void setDirection( MazePiece piece, Direction direction);
    
    public double getWidth();
    public double getHeight();
    public Color  getColor();
}
