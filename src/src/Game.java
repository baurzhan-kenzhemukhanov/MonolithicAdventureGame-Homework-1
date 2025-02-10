import player.Player;
import managers.*;
import interfaces.*;
import rivals.Rival;

public class Game {
    private Player player;
    private LevelManager levelHandler;
    private CombatManager battleHandler;

    public Game() {
        this.player = new Player("Adventurer");
        this.levelHandler = new LevelManager();
        this.battleHandler = new CombatManager();
    }

    public void startGame() {
        System.out.println("=== The Adventure Begins ===");

        while (levelHandler.getCurrentLevel() <= 3 && player.isAlive()) {
            System.out.println("\n=== Entering Level " + levelHandler.getCurrentLevel() + " ===");
            processLevel();

            if (player.isAlive() && levelHandler.getCurrentLevel() < 3) {
                levelHandler.advanceLevel();
                player.setHealth(100); 
            }
        }

        displayGameResult();
    }

    private void processLevel() {
        while (!levelHandler.isLevelComplete() && player.isAlive()) {
            for (Rival rival : levelHandler.getRivals()) {
                if (rival.isAlive()) {
                    battleHandler.processCombat(player, rival);

                    if (!player.isAlive()) {
                        return;
                    }
                    if (!rival.isAlive()) {
                        levelHandler.removeRival(rival);
                        player.setExperience(player.getExperience() + rival.getExperience());
                        System.out.println(player.getName() + " earned " + rival.getExperience() + " XP!");
                        break;
                    }
                }
            }
            
            if (!levelHandler.getItems().isEmpty()) {
                IItem foundItem = levelHandler.getItems().get(0);
                System.out.println(player.getName() + " discovered " + foundItem.getName() + "!");
                foundItem.use(player);
                player.addItem(foundItem);
                levelHandler.removeItem(foundItem);
            }
        }
    }

    private void displayGameResult() {
        if (!player.isAlive()) {
            System.out.println("\nGame Over! " + player.getName() + " has perished.");
        } else {
            System.out.println("\nVictory! " + player.getName() + " has triumphed over the adventure!");
            System.out.println("Total Experience Gained: " + player.getExperience());
        }
    }

    public static void main(String[] args) {
        Game adventure = new Game();
        adventure.startGame();
    }
}
