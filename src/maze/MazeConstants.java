/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public interface MazeConstants {

    final static double GOLDENRATIO = (1 + Math.sqrt(5.0)) / 2; 
    // see http://en.wikipedia.org/wiki/Golden_ratio
    final static Direction NORTH = new Direction() {

        @Override
        public int getXdiff() {
            return 0;
        }

        @Override
        public int getYdiff() {
            return -1;
        }

        @Override
        public String toString() {
            return "North";
        }

        @Override
        public Direction oppositeDirection() {
            return SOUTH;
        }
    };
    
    final static Direction SOUTH = new Direction() {

        @Override
        public int getXdiff() {
            return 0;
        }

        @Override
        public int getYdiff() {
            return 1;
        }

        @Override
        public String toString() {
            return "South";
        }

        @Override
        public Direction oppositeDirection() {
            return NORTH;
        }
    };
    final static Direction EAST = new Direction() {

        @Override
        public int getXdiff() {
            return 1;
        }

        @Override
        public int getYdiff() {
            return 0;
        }

        @Override
        public String toString() {
            return "East";
        }

        @Override
        public Direction oppositeDirection() {
            return WEST;
        }
    };
    final static Direction WEST = new Direction() {

        @Override
        public int getXdiff() {
            return -1;
        }

        @Override
        public int getYdiff() {
            return 0;
        }

        @Override
        public String toString() {
            return "West";
        }

        @Override
        public Direction oppositeDirection() {
            return EAST;
        }
    };
    final static List<Direction> DIRECTIONS = 
            new ArrayList<>(Arrays.asList(NORTH, SOUTH, EAST, WEST));
}
