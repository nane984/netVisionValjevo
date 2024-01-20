/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author branko.scekic
 */
public class MousePoint {
    
    public static Point getMousePoint() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        if (p.y > 712) {
            p.y = 712;
        } 
        
        return p;
    }
}
