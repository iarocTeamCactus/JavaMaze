/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.solver;

import java.util.HashSet;
import java.util.Queue;
import maze.pieces.EmptySpace;
import maze.pieces.SolutionPiece;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class MazeSolver {
    HashSet<SolutionPiece> solution;
    public void solveMaze( EmptySpace currentMazePiece, HashSet<SolutionPiece> traversedLocations){
        //Starting at starting space, recursively traverse maze
        //if this is the BeaconWall then mark the maze as done and return the traversedLocations
        //if this piece has already been traversed then exit
        //if this is an EmptySpace then
        //  add current EmptySpace to the traversedLocations
        //  traverse the four directions recursively
        //
    }
    
    public HashSet<SolutionPiece> getSolution(){
        return solution;
    }
    
}
