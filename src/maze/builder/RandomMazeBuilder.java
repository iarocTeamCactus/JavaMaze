/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.builder;

import java.awt.Color;
import maze.pieces.EmptySpace;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import maze.Direction;
import maze.MazeConstants;
import maze.MazeGridLocation;
import maze.pieces.*;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class RandomMazeBuilder extends Observable {

    private final static int LENGTH = 10;
    private final static int WIDTH = 10;
    private final static int OPENSPACES = 1000;
    HashMap<String, MazePiece> usedMazePositions = new HashMap<>(OPENSPACES);
    private int emptySpaceCount = OPENSPACES;
    private boolean moreOpenSpaces = true;
    Random randomDirectionGenerator = new Random();
    Random randomPieceGenerator = new Random();
    EmptySpace northWestPiece, northEastPiece, southWestPiece, southEastPiece;

    private String keyFromXY(int x, int y) {
        return x + " " + y;
    }

    public MazePiece buildRandomMaze() {

        // Builds a Random Maze using a HashMap to ensure no duplicate pieces
        MazePiece startingPiece = new EmptySpace() {

            @Override
            public Color getColor() {
                return Color.ORANGE;
            }
        };
        MazeGridLocation loc = new MazeGridLocation();
        loc.setLocation(0, 0);
        ((EmptySpace) startingPiece).setGridLocation(loc);

        // Start beginning and end piece to startingPiece
        northWestPiece = (EmptySpace) startingPiece;
        northEastPiece = (EmptySpace) startingPiece;
        southWestPiece = (EmptySpace) startingPiece;
        southEastPiece = (EmptySpace) startingPiece;
        System.out.println(OPENSPACES - emptySpaceCount + " spaces used.");

        // Build the maze
        startingPiece = buildRandomMaze(startingPiece, 0, 0);

        // Denote the South starting point and the North beacon wall
        System.out.println("Southmost: " + getSouthMostPiece().getGridLocation().getXLocation() + " " + getSouthMostPiece().getGridLocation().getYLocation());
        System.out.println("Northmost: " + getNorthMostPiece().getGridLocation().getXLocation() + " " + getNorthMostPiece().getGridLocation().getYLocation());
        getNorthMostPiece().setNorth(new BeaconWall());
        getSouthMostPiece().setColor(Color.DARK_GRAY);

        return startingPiece;
    }

    MazePiece buildRandomMaze(MazePiece currentPiece, int x, int y) {

        if (usedMazePositions.containsKey(keyFromXY(x, y)) && currentPiece instanceof EmptySpace) {
            System.out.println("Already put down piece" + x + " " + y);
        } else {
            if (currentPiece instanceof EmptySpace) {
                //add the current EmptySpace to the list of usedMazePositions
                usedMazePositions.put(keyFromXY(x, y), currentPiece);
                MazeGridLocation loc = new MazeGridLocation();
                loc.setLocation(x, y);
                ((EmptySpace) currentPiece).setGridLocation(loc);
                markBeginEnd((EmptySpace) currentPiece);
            }

            // apply something to all four sides of the currentPiece
            // TODO: Sometimes beginning piece gets overwritten
            // TODO: Sometimes (perhaps) laid down empty spaces don't connect walls
            // TODO: Sometimes there are spaces without any entry point
            // TODO: Sometimes there are empty walls
            MazePiece nextPiece;
            for (Direction direction : MazeConstants.DIRECTIONS) {
                System.out.println(x + " " + y + " " + direction);
                if (currentPiece.getDirection(direction) == UndefinedMazePiece.getInstance()) {
                    nextPiece = getRandomMazePiece(direction);
                    currentPiece.setDirection(nextPiece, direction);
                    nextPiece.setDirection(currentPiece, direction.oppositeDirection());  //set next piece to point back to current piece as well
                    connectSurroundingEmptySpaces(currentPiece, x, y);
                    // Inform Observers
                    setChanged();
                    notifyObservers();
                    if (nextPiece instanceof EmptySpace) {
                        nextPiece = buildRandomMaze(nextPiece, x + direction.getXdiff(), y + direction.getYdiff());
                    }
                }
            }
        }
        return currentPiece;
    }

    MazePiece getAppropriateWall(Direction direction) {
        MazePiece wall;

        if (direction == MazeConstants.NORTH || direction == MazeConstants.SOUTH) {
            wall = new RunsEastWestWall();
        } else {
            wall = new RunsNorthSouthWall();
        }

        return wall;
    }

    MazePiece getRandomMazePiece(Direction direction) {
        MazePiece returnPiece;

        if (emptySpaceCount > 0) {
            if (randomPieceGenerator.nextDouble() < .58 /*
                     * 1.0 / MazeConstants.GOLDENRATIO
                     */) {  //61.8%
                //build a wall
                returnPiece = getAppropriateWall(direction);
            } else {
                //build an empty space
                emptySpaceCount--;
                System.out.println("emptySpaceCount " + emptySpaceCount);
                returnPiece = new EmptySpace();
            }
        } else {
            //ran out of empty space, so build a wall
            returnPiece = getAppropriateWall(direction);
        }

        return returnPiece;
    }

    private void connectSurroundingEmptySpaces(MazePiece currentPiece, int x, int y) {
        MazePiece surroundingMazePiece;
        MazePiece possibleWall;
        for (Direction direction : MazeConstants.DIRECTIONS) {
            if (usedMazePositions.containsKey(keyFromXY(x + direction.getXdiff(), y + direction.getYdiff()))) {
                surroundingMazePiece = usedMazePositions.get(keyFromXY(x + direction.getXdiff(), y + direction.getYdiff()));
                possibleWall = surroundingMazePiece.getDirection(direction.oppositeDirection());
                if (possibleWall instanceof RunsEastWestWall || possibleWall instanceof RunsNorthSouthWall) {
                    // set neighboring wall
                    currentPiece.setDirection(possibleWall, direction);
                } else {
                    currentPiece.setDirection(surroundingMazePiece, direction);
                    surroundingMazePiece.setDirection(currentPiece, direction.oppositeDirection());
                }
            }
        }

    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        System.out.println("Added Observer" + o);
    }

    private void markBeginEnd(EmptySpace currentPiece) {
        setNorthWestPiece(currentPiece);
        setNorthEastPiece(currentPiece);
        setSouthWestPiece(currentPiece);
        setSouthEastPiece(currentPiece);
    }

    private void setNorthWestPiece(EmptySpace currentPiece) {
        if (currentPiece.getGridLocation().additiveNorthWestDistance() >= northWestPiece.getGridLocation().additiveNorthWestDistance()) {
            northWestPiece = currentPiece;
        }
    }

    private void setNorthEastPiece(EmptySpace currentPiece) {
        if (currentPiece.getGridLocation().additiveNorthEastDistance() >= northEastPiece.getGridLocation().additiveNorthEastDistance()) {
            northEastPiece = currentPiece;
        }
    }

    private void setSouthWestPiece(EmptySpace currentPiece) {
        if (currentPiece.getGridLocation().additiveSouthWestDistance() >= southWestPiece.getGridLocation().additiveSouthWestDistance()) {
            southWestPiece = currentPiece;
        }
    }

    private void setSouthEastPiece(EmptySpace currentPiece) {
        if (currentPiece.getGridLocation().additiveSouthEastDistance() >= southEastPiece.getGridLocation().additiveSouthEastDistance()) {
            southEastPiece = currentPiece;
        }
    }

    public EmptySpace getNorthWestPiece() {
        return northWestPiece;
    }

    public EmptySpace getNorthEastPiece() {
        return northEastPiece;
    }

    public EmptySpace getSouthWestPiece() {
        return southWestPiece;
    }

    public EmptySpace getSouthEastPiece() {
        return southEastPiece;
    }

    public EmptySpace getSouthMostPiece() {
        if (southWestPiece.getGridLocation().additiveSouthWestDistance() >= southEastPiece.getGridLocation().additiveSouthEastDistance()) {
            return southWestPiece;
        } else {
            return southEastPiece;
        }
    }

    public EmptySpace getNorthMostPiece() {
        if (northWestPiece.getGridLocation().additiveNorthWestDistance() >= northEastPiece.getGridLocation().additiveNorthEastDistance()) {
            return northWestPiece;
        } else {
            return northEastPiece;
        }
    }
}
