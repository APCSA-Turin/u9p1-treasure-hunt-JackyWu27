package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite{
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        if (direction.equals("w")) { //checks direction and moves if possible
            setY(getY() + 1);
        }
        if (direction.equals("s")) { //checks direction and moves if possible
            setY(getY() - 1);
        }
        if (direction.equals("a")) { //checks direction and moves if possible
            setX(getX() - 1);
        }
        if (direction.equals("d")) { //checks direction and moves if possible
            setX(getX() + 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (obj instanceof Treasure) {
            if (obj instanceof Trophy) {
                if (numTreasures - treasureCount == 0) {
                    win = true;
                }
            } else {
                treasureCount ++;
            }
        } else if (obj instanceof Enemy) {
            numLives --;
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equals("w") && getY() == size - 1) { //checks direction and moves if possible
            return false;
        }
        if (direction.equals("s") && getY() == 0) { //checks direction and moves if possible
            return false;
        }
        if (direction.equals("a") && getX() == 0) { //checks direction and moves if possible
            return false;
        }
        if (direction.equals("d") && getX() == size - 1) { //checks direction and moves if possible
            return false;
        }
        return true;
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return ("Player:" + super.getRowCol(size));
    }

    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Player:" + super.getCoords();
    }
   
}



