/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.builder;

import maze.pieces.MazePiece;
import maze.pieces.RunsEastWestWall;
import maze.pieces.RunsNorthSouthWall;
import maze.pieces.EmptySpace;
import maze.pieces.BeaconWall;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class SimpleMazeBuilder {
    
    MazePiece buildMaze(){
        // Building this maze:
        // ╔─╗
        // ╟─╢
        // ╚═╝
        // starting at bottom empty space
        
        // Build starting block
        MazePiece startingPiece = new EmptySpace();
        startingPiece.setSouth(new RunsEastWestWall());
        startingPiece.setEast (new RunsNorthSouthWall());
        startingPiece.setWest (new RunsNorthSouthWall());
        
        // Build North block
        MazePiece northBlock = new EmptySpace();
        northBlock.setNorth(new BeaconWall());
        northBlock.setEast (new RunsNorthSouthWall());
        northBlock.setWest (new RunsNorthSouthWall());
        
        // Connect starting block and North block
        startingPiece.setNorth(northBlock);
        northBlock.setSouth(startingPiece);
        
        return startingPiece;
    }
    
}
