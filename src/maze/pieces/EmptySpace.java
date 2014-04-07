/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.pieces;

import maze.MazeGridLocation;
import java.awt.Color;
import maze.Direction;
import maze.MazeConstants;

/**
 *
 * @author Rob
 */
public class EmptySpace implements MazePiece {

    MazePiece north = UndefinedMazePiece.getInstance(),
            south = UndefinedMazePiece.getInstance(),
            east = UndefinedMazePiece.getInstance(),
            west = UndefinedMazePiece.getInstance();
    MazeGridLocation location;
    Color color = Color.LIGHT_GRAY;

    public EmptySpace() {
        System.out.println("creating EmptySpace");
    }

    @Override
    public MazePiece getNorth() {
        return north;
    }

    @Override
    public void setNorth(MazePiece piece) {
        north = piece;
    }

    @Override
    public MazePiece getSouth() {
        return south;
    }

    @Override
    public void setSouth(MazePiece piece) {
        south = piece;
    }

    @Override
    public MazePiece getEast() {
        return east;
    }

    @Override
    public void setEast(MazePiece piece) {
        east = piece;
    }

    @Override
    public MazePiece getWest() {
        return west;
    }

    @Override
    public void setWest(MazePiece piece) {
        west = piece;
    }

    @Override
    public MazePiece getDirection(Direction direction) {
        MazePiece piece = null;

        if (direction == MazeConstants.NORTH) {
            piece = getNorth();
        } else if (direction == MazeConstants.EAST) {
            piece = getEast();
        } else if (direction == MazeConstants.SOUTH) {
            piece = getSouth();
        } else if (direction == MazeConstants.WEST) {
            piece = getWest();
        } else {
            throw new IndexOutOfBoundsException("a direction " + direction + " does not map to NORTH SOUTH EAST WEST");
        }
        return piece;
    }

    @Override
    public void setDirection(MazePiece piece, Direction direction) {
        if (direction == MazeConstants.NORTH) {
            setNorth(piece);
        } else if (direction == MazeConstants.EAST) {
            setEast(piece);
        } else if (direction == MazeConstants.SOUTH) {
            setSouth(piece);
        } else if (direction == MazeConstants.WEST) {
            setWest(piece);
        } else {
            throw new IndexOutOfBoundsException("a direction " + direction + " does not map to NORTH SOUTH EAST WEST");
        }
    }

    @Override
    public double getWidth() {
        return 36.0;
    }

    @Override
    public double getHeight() {
        return 36.0;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void setGridLocation(MazeGridLocation loc) {
        location = loc;
    }

    public MazeGridLocation getGridLocation() {
        return location;
    }
}
