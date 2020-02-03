/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author MohamedGaber
 */
public class BoardPostion
{
   int x,y;
   char value;

    public BoardPostion() {
        x=y=0;
        value='-';
    }
    
    public BoardPostion(int x, int y,char value)
    {
        this.x = x;
        this.y = y;
        this.value=value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
    
    
    
    
   
}
