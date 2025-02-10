# Adventure Game Refactoring Implementation
Made by Baurzhan Kenzhemukhanov / ShP 2223


## Review
This project showcases the transformation of a monolithic adventure game into a well-structured design that adheres to SOLID principles. Initially, all game logic was confined to a single class, leading to multiple SOLID violations. The refactored version organizes functionalities into separate components, enhancing maintainability, scalability, and testability.

## Project Structure
```
src/
├── 📂 interfaces/
│   ├── IEntity.java        # Base interface for all game entities
│   ├── IEntityType.java    # Entity type definitions
│   ├── ICombatant.java     # Interface for combat-capable entities
│   ├── IItem.java          # Interface for collectible items
│   └── IItemType.java      # Item type definitions
├── 📂 player/
│   └── Player.java         # Player implementation
├── 📂 enemies/
│   ├── Enemy.java          # Base abstract class for enemies
│   ├── Skeleton.java       # Skeleton enemy implementation
│   ├── Zombie.java         # Zombie enemy implementation
│   └── Vampire.java        # Vampire enemy implementation
├── 📂 items/
│   ├── HealthElixir.java   # Health restoration item
│   ├── GoldCoin.java       # Experience-giving item
│   └── MagicScroll.java    # Experience-boosting item
├── 📂 managers/
│   ├── CombatManager.java  # Handles combat interactions
│   └── LevelManager.java   # Manages level progression and spawning
└── Game.java               # Main game orchestration
```

## SOLID Principles Implementation

### 1️⃣ Single Responsibility Principle (SRP)
Each class has been designed with a single, well-defined responsibility:
- `Player`: Manages player state and attributes
- `Enemy`: Defines base enemy behavior
- `CombatManager`: Handles combat logic exclusively
- `LevelManager`: Manages level progression and entity spawning
- `Item` classes: Each handles its specific item behavior
- Type interfaces: Separate enums into dedicated interfaces (`IEntityType`, `IItemType`)

### 2️⃣ Open/Closed Principle (OCP)
The design is open for extension but closed for modification:
- New enemy types can be added by extending `Enemy` without modifying existing code
- New items can be implemented through the `IItem` interface
- New combat mechanics can be added by extending `CombatManager`
- New level types can be added in `LevelManager` without changing other components
- New entity or item types can be added to their respective type interfaces

### 3️⃣ Liskov Substitution Principle (LSP)
All derived classes can be used in place of their base classes:
- All enemies (Skeleton, Zombie, Vampire) are interchangeable through the `Enemy` base class
- All items are usable through the `IItem` interface
- All combat participants implement `ICombatant` consistently

### 4️⃣ Interface Segregation Principle (ISP)
Interfaces are focused and minimal:
- `IEntity`: Basic entity properties (name, type)
- `IEntityType`: Entity type enumeration
- `ICombatant`: Combat-specific behaviors (health, damage, experience)
- `IItem`: Item-specific behaviors (use effect)
- `IItemType`: Item type enumeration

### 5️⃣ Dependency Inversion Principle (DIP)
High-level modules depend on abstractions:
- Game class depends on interfaces rather than concrete implementations
- Managers work with interfaces (`ICombatant`, `IItem`) rather than specific classes
- Combat system is decoupled from specific entity implementations
- Type systems use interface-based enums for better encapsulation

## Key Components

### Player System
- Player class implements `ICombatant`
- Manages health, experience, and inventory
- Damage calculation based on experience level

### Enemy System
- Base `Enemy` class with common functionality
- Specific enemy types with unique attributes:
  - Skeleton: Low health, low damage
  - Zombie: Medium health, medium damage
  - Vampire: High health, high damage

### Item System
- Items implement `IItem` interface
- Three types of items:
  - Health Elixir: Restores player health
  - Gold Coin: Grants small experience boost
  - Magic Scroll: Grants larger experience boost

### Combat System
- Handles attack and counter-attack mechanics
- Manages damage calculation and health updates
- Provides combat feedback through console output

### Level Management
- Controls level progression
- Manages enemy and item spawning
- Tracks level completion conditions

## Extensibility
The refactored design allows for easy additions:
1. New Enemy Types: Create new class extending `Enemy`
2. New Items: Implement `IItem` interface
3. New Combat Mechanics: Extend `CombatManager`
4. New Level Types: Add to `LevelManager`

## Benefits of Refactoring
1. Improved maintainability through separated concerns
2. Enhanced testability with clear component boundaries
3. Easier addition of new features
4. Better code organization and readability
5. Reduced coupling between components
6. Clear separation of game mechanics

## Justification for Class Structure
The new classes were structured to adhere to the SOLID principles, which enhance maintainability, testability, and extensibility. By separating concerns, each class focuses on a single responsibility, reducing complexity and improving readability. Interfaces decouple dependencies, allowing high-level modules to depend on abstractions, which facilitates easier addition of new features and reduces coupling. This clear separation of game mechanics ensures that changes in one part of the system do not affect others, promoting a modular and organized codebase. The refactored design allows for easy additions, such as new enemy types, items, combat mechanics, and level types, by extending existing classes or implementing new interfaces. This approach not only simplifies the integration of new features but also maintains the integrity of the existing system, ensuring that enhancements do not disrupt the current functionality.

## Running the Game
```java
public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
```

The game provides a console-based interface showing:
- Combat encounters
- Item pickups
- Level progression
- Player status updates
- Final game outcome 
