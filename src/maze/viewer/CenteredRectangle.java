/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.viewer;

import java.awt.Rectangle;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class CenteredRectangle extends Rectangle {
    
    public CenteredRectangle(int x, int y, int width, int height){
        
        super( x - width / 2, y - height / 2, width, height );
    
    }
}
