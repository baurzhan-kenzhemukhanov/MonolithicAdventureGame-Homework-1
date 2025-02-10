import player.Player;
import managers.*;
import interfaces.*;
import enemies.Enemy;

public class Game {
    private Player player;
    private LevelManager levelManager;
    private CombatManager combatManager;

    public Game() {
        this.player = new Player("Adventurer");
        this.levelManager = new LevelManager();
        this.combatManager = new CombatManager();
    }

    public void playGame() {
        System.out.println("=== Adventure Game Begins ===");
        
        while (levelManager.getCurrentLevel() <= 3 && player.isAlive()) {
            System.out.println("\n=== Level " + levelManager.getCurrentLevel() + " ===");
            playLevel();
            
            if (player.isAlive() && levelManager.getCurrentLevel() < 3) {
                levelManager.advanceLevel();
                player.setHealth(100); // Restore health between levels
            }
        }

        // Game over
        if (!player.isAlive()) {
            System.out.println("\nGame Over! " + player.getName() + " has fallen!");
        } else {
            System.out.println("\nCongratulations! " + player.getName() + " has completed the adventure!");
            System.out.println("Final Experience: " + player.getExperience());
        }
    }

    private void playLevel() {
        // Process all enemies and items in the level
        while (!levelManager.isLevelComplete() && player.isAlive()) {
            // Handle enemies
            for (Enemy enemy : levelManager.getEnemies()) {
                if (enemy.isAlive()) {
                    combatManager.processCombat(player, enemy);
                    if (!player.isAlive()) {
                        return;
                    }
                    if (!enemy.isAlive()) {
                        levelManager.removeEnemy(enemy);
                        player.setExperience(player.getExperience() + enemy.getExperience());
                        System.out.println(player.getName() + " gained " + enemy.getExperience() + " experience!");
                        break;
                    }
                }
            }

            // Handle items
            if (!levelManager.getItems().isEmpty()) {
                IItem item = levelManager.getItems().get(0);
                System.out.println(player.getName() + " found " + item.getName() + "!");
                item.use(player);
                player.addItem(item);
                levelManager.removeItem(item);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
} 
