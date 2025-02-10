# **Homework-1 Assignment: Refactoring MonolithicAdventureGame Using SOLID Principles**

## **Purpose**
This assignment aims to transform a monolithic game simulation into a well-structured, SOLID-compliant design by dividing responsibilities, incorporating abstractions, and enhancing maintainability.

---

## **Monolithic Code Base**
You have received a monolithic adventure game implementation where:

1. Player Management: Health, experience, and inventory are all managed within a single class.
2. Combat System: Rival encounters and damage calculations are tightly integrated.
3. Item Management: Item pickup and storage occur within the same monolithic structure.
4. Level Progression: Game levels, rival spawns, and resets are controlled by a single method.

---

## **How to Access the Refactoring**

### **1. Identify Responsibilities**
Break the existing **MonolithicAdventureGame** class into distinct components:

| Responsibility           | Suggested Class |
|-------------------------|----------------|
| **Player Management**  | `Player` |
| **Combat System**       | `CombatManager` |
| **Rival Handling**      | `RivalManager` |
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
- **Example:** New rival types should be **added** without modifying the existing logic.

#### **✅ Dependency Inversion Principle (DIP)**
- High-level modules should not depend on **low-level modules**.
- Use **interfaces** where applicable to **decouple dependencies**.
- **Example:** The `CombatManager` should rely on an `IRival` interface rather than concrete `Rival` classes.

#### **✅ Liskov Substitution Principle (LSP)**
- Any subclass should **replace** its superclass **without breaking functionality**.
- **Example:** A `Dwarfs` or `Elves` class should be interchangeable without modifying the combat system.

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
│   ├── 📂 rivals
│   │   ├── Rival.java
│   │   ├── Orcs.java
│   │   ├── Dwarfs.java
│   │   ├── Elves.java
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
