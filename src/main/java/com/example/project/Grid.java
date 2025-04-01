package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        grid = new Sprite [size][size];
        for (int c = 0; c < size; c ++) {
            for (int d = 0; d < size; d ++) {
                grid[c][d] = new Dot (c, d);
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[s.getY()][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        if (direction.equals("w") && s.getY() != 0) { //checks direction and moves if possible
            s.setY(s.getY() + 1);
        }
        if (direction.equals("s") && s.getY() != size - 1) { //checks direction and moves if possible
            s.setY(s.getY() - 1);
        }
        if (direction.equals("a") && s.getX() != 0) { //checks direction and moves if possible
            s.setX(s.getX() + 1);
        }
        if (direction.equals("d") && s.getX() != size - 1) { //checks direction and moves if possible
            s.setX(s.getX() - 1);
        }
    }


    public void display() { //print out the current grid to the screen 
        for (Sprite [] c : grid) {
            for (Sprite d : c) {
                if (d instanceof Dot) {
                    System.out.print("⬜");
                } else if (d instanceof Player) {
                    System.out.print("🤖");
                } else if (d instanceof Enemy) {
                    System.out.print("💀");
                } else if (d instanceof Treasure) {
                    System.out.print("💰");
                } else if (d instanceof Trophy) {
                    System.out.print("🏆");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss   
        for (Sprite [] c : grid) {
            for (Sprite d : c) {
                System.out.print("🟥");
            }
            System.out.println();
        }
    }

    public void win(){ //use this method to display a win 
        for (Sprite [] c : grid) {
            for (Sprite d : c) {
                System.out.print("⭐");
            }
            System.out.println();
        }
    }


}