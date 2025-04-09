package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;
    private int numTreasures;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite [size][size];
        for (int c = 0; c < size; c ++) {
            for (int d = 0; d < size; d ++) {
                grid[c][d] = new Dot (c, d);
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}

    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size - (s.getY() + 1)][s.getX()] = s;
        int num = 0;
        for (Sprite [] c : grid) {
            for (Sprite d : c) {
                if (d instanceof Treasure && !(d instanceof Trophy)) {
                    num ++;
                }
            }
        } 
        numTreasures = num;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        
        if (direction.equals("d")) {
            placeSprite(new Dot(s.getX() - 1, s.getY()));
        }
        if (direction.equals("a")) {
            placeSprite(new Dot(s.getX() + 1, s.getY()));        
        }
        if (direction.equals("w")) {
            placeSprite(new Dot(s.getX(), s.getY() - 1));
        }
        if (direction.equals("s")) {
            placeSprite(new Dot(s.getX(), s.getY() + 1));
        }
        if(s instanceof Player){
            ((Player)s).interact(size, direction, numTreasures, grid[s.getY()][s.getX()]);
        }
        
        placeSprite(s);
    }


    public void display() { //print out the current grid to the screen 
        for (Sprite [] c : grid) {
            for (Sprite d : c) {
                if (d instanceof Trophy) {
                    System.out.print("🏆 ");
                } else if (d instanceof Treasure) {
                    System.out.print("💰 ");
                }
                if (d instanceof Player) {
                    System.out.print("🤖 ");
                }
                if (d instanceof Enemy) {
                    System.out.print("💀 ");
                }
                if (d instanceof Dot) {
                    System.out.print("⬜ ");
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