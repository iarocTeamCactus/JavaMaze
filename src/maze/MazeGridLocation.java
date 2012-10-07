/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class MazeGridLocation {
    int x, y;
    
    public void setLocation( int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getXLocation() { return x; }
    public int getYLocation() { return y; }
    
    public int additiveDistanceFrom00() { 
        return Math.abs(x) + Math.abs(y);
    }
    
    public int additiveNorthWestDistance(){
        return -x + -y;
    }
    
    public int additiveNorthEastDistance(){
        return  x + -y;
    }
    
    public int additiveSouthWestDistance(){
        return -x +  y;
    }
    
    public int additiveSouthEastDistance(){
        return  x +  y;
    }
    
    public int southDistance() {
        return y;
    }
    
    public int northDistance() {
        return -y;
    }
}
