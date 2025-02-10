import player.Player;
import managers.*;
import interfaces.*;
import rivals.Rival;

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
        // Process all rivals and items in the level
        while (!levelManager.isLevelComplete() && player.isAlive()) {
            // Handle rivals
            for (Rival rival : levelManager.getRivals()) {
                if (rival.isAlive()) {
                    combatManager.processCombat(player, rival);
                    if (!player.isAlive()) {
                        return;
                    }
                    if (!rival.isAlive()) {
                        levelManager.removeRival(rival);
                        player.setExperience(player.getExperience() + rival.getExperience());
                        System.out.println(player.getName() + " gained " + rival.getExperience() + " experience!");
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
