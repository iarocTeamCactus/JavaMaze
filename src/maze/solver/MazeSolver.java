/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.solver;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import maze.Direction;
import maze.MazeConstants;
import maze.pieces.BeaconWall;
import maze.pieces.EmptySpace;
import maze.pieces.MazePiece;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class MazeSolver extends Observable {

    HashSet<MazePiece> solution;
    private boolean solved = false;

    public void solveMaze(MazePiece currentMazePiece, HashSet<MazePiece> traversedLocations) {
        //Starting at starting space, recursively traverse maze
        //if the maze has been solved then exit (and thus backtrack through recursion)
        //if this piece has already been traversed then exit (and thus backtrack through recursion)
        //clone the traversedLocations for recursion
        //if this is the BeaconWall then mark the maze as done and return the traversedLocations
        //if this piece has already been traversed then exit (and thus backtrack through recursion)
        //if this is an EmptySpace then
        //  add current EmptySpace to the traversedLocations
        //  traverse the four directions recursively passing a clone of the traversed pieces
        //
        //if the maze has been solved then exit (and thus backtrack through recursion)
        //if this piece has already been traversed then exit (and thus backtrack through recursion)
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (!solved && !traversedLocations.contains(currentMazePiece)) {
            //clone the traversedLocations for recursion
            HashSet<MazePiece> localLocations = (HashSet<MazePiece>) traversedLocations.clone();
            //if this is the BeaconWall then mark the maze as done and return the traversedLocations
            if (currentMazePiece instanceof BeaconWall) {
                solution = localLocations;
                solved = true;
            } //if this is an EmptySpace then
            else if (currentMazePiece instanceof EmptySpace) {
                //color traversed pieces
                currentMazePiece.setColor(Color.YELLOW);
                //add current EmptySpace to the traversedLocations
                localLocations.add(currentMazePiece);
                highlightSolution(localLocations);
                this.setChanged();
                this.notifyObservers();
                for (Iterator<Direction> it = MazeConstants.DIRECTIONS.iterator(); it.hasNext();) {
                    Direction d = it.next();
                    solveMaze(currentMazePiece.getDirection(d), localLocations);
                    highlightSolution(localLocations);
                    currentMazePiece.setColor(Color.CYAN);
                    this.setChanged();
                    this.notifyObservers();
                }
            }
            // else currentMazePiece is a Wall or Undefined, so exit
        }
    }

    public void highlightSolution() {
        for (MazePiece aPiece:solution ) {
            aPiece.setColor(Color.GREEN);
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void highlightSolution(HashSet<MazePiece> traversedLocations) {
        for (MazePiece aPiece:traversedLocations ) {
            aPiece.setColor(Color.PINK);
            this.setChanged();
            this.notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        System.out.println("Added Observer" + o);
    }


    public HashSet<MazePiece> getSolution() {
        return solution;
    }
}
