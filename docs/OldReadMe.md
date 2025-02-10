# **Homework Assignment: Refactoring MonolithicAdventureGame Using SOLID Principles**

## **Objective**
The goal of this assignment is to refactor a **monolithic game simulation** into a well-structured, **SOLID-compliant** design by separating concerns, introducing abstractions, and ensuring maintainability.

---

## **Monolithic Code Base**
You have been provided with a **monolithic** implementation of an adventure game where:
- **Player Management**: Health, experience, and inventory are handled within the same class.
- **Combat System**: Enemy encounters and damage calculations are tightly coupled.
- **Item Management**: Items are picked up and stored in the same monolithic class.
- **Level Progression**: Game levels, enemy spawns, and resets are handled within a single method.

---

## **How to Approach the Refactoring**

### **1. Identify Responsibilities**
Break the existing **MonolithicAdventureGame** class into distinct components:

| Responsibility           | Suggested Class |
|-------------------------|----------------|
| **Player Management**  | `Player` |
| **Combat System**       | `CombatManager` |
| **Enemy Handling**      | `EnemyManager` |
| **Item Handling**       | `ItemManager` |
| **Level Progression**   | `LevelManager` |
| **Score Management**    | `ScoreManager` |

---

### **2. Apply SOLID Principles**

#### **✅ Single Responsibility Principle (SRP)**
- Each class should focus on **only one** responsibility.
- **Example:** The `Player` class should not handle scoring or enemy interactions.

#### **✅ Open/Closed Principle (OCP)**
- The system should be **open for extension** but **closed for modification**.
- **Example:** New enemy types should be **added** without modifying the existing logic.

#### **✅ Dependency Inversion Principle (DIP)**
- High-level modules should not depend on **low-level modules**.
- Use **interfaces** where applicable to **decouple dependencies**.
- **Example:** The `CombatManager` should rely on an `IEnemy` interface rather than concrete `Enemy` classes.

#### **✅ Liskov Substitution Principle (LSP)**
- Any subclass should **replace** its superclass **without breaking functionality**.
- **Example:** A `Zombie` or `Vampire` class should be interchangeable without modifying the combat system.

#### **✅ Interface Segregation Principle (ISP)**
- Avoid **large, bloated interfaces**—split them into **focused**, smaller interfaces.
- **Example:** Instead of a **single** `GameEntity` interface, create `IAttackable`, `IDamageable`, and `IItemInteractable`.

---

## **3. Documentation and UML Diagrams**
### **Write-Up**
- Explain **how your refactoring applies SOLID principles**.
- Justify **why** you structured the new classes as you did.

### **UML Diagrams (Optional, but Recommended)**
- **After Refactoring** → Show the **new modular structure** with dependencies.

---

## **Submission Guidelines**
- **Submit:**
  1. **Refactored Java Code** (`.java` files)
  2. **Documentation** (`README.md` or `.pdf`)
  3. **UML Diagrams** (`.png`, `.jpg`, or `.pdf`)
- **Submission Method:** GitHub Repository

---

## **Example Folder Structure (After Refactoring)**
```
📂 SOLID-Refactored-AdventureGame
│── 📂 src
│   ├── 📂 player
│   │   ├── Player.java
│   ├── 📂 combat
│   │   ├── CombatManager.java
│   ├── 📂 enemies
│   │   ├── Enemy.java
│   │   ├── Skeleton.java
│   │   ├── Zombie.java
│   │   ├── Vampire.java
│   ├── 📂 items
│   │   ├── ItemManager.java
│   │   ├── GoldCoin.java
│   │   ├── HealthElixir.java
│   │   ├── MagicScroll.java
│   ├── 📂 level
│   │   ├── LevelManager.java
│   ├── 📂 score
│   │   ├── ScoreManager.java
│   ├── MainGame.java
│
│── 📂 docs
│   ├── UML-Before-Refactor.png
│   ├── UML-After-Refactor.png
│   ├── SOLID-Refactoring-Report.pdf
│
│── README.md
```
