package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        while(!player.getWin() && player.getLives() != 0){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Treasure collected: " + player.getTreasureCount());
            System.out.println("Lives left: " + player.getLives());
            
            String answer = scanner.nextLine();
            if (player.isValid(size, answer)) {
                player.move(answer);
                grid.placeSprite(player, answer);
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            grid.display();
            }
            clearScreen();
            if (player.getLives() == 0) {
                grid.gameover();
                System.out.println("You Lose");
            } else {
                grid.win();
                System.out.println("You Win");
            }
     
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        grid = new Grid(size);
        player = new Player(0, 0);
        Enemy enemy = new Enemy(5, 5);
        Enemy enemy2 = new Enemy(7,8);
        Treasure treasure = new Treasure(2, 2);
        Treasure treasure2 = new Treasure(1,7);
        trophy = new Trophy(9, 9);
        enemies = new Enemy[] {enemy, enemy2};
        treasures = new Treasure[] {treasure, treasure2};

        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
        grid.display();
    }

    public static void main(String[] args) {
        Game g = new Game(10);
    }

}