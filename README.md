# Zoo-Management-System-

This project is a **Java-based Zoo Management System** developed using **Object-Oriented Programming (OOP)** principles. It simulates the daily operations of a zoo, including animal care, feeding processes, and the management of zoo staff and visitors. The system heavily utilizes **inheritance and polymorphism** to model real-world zoo dynamics.

---

## Features

### Advanced Class Hierarchy
- **Animal (Abstract Class):**  
  Defines the core attributes shared by all animals, such as `ID`, `age`, and `weight`.
- **Species-Specific Classes:**  
  `Lion`, `Elephant`, `Penguin`, and `Chimpanzee` extend the `Animal` class and implement species-specific care and behavior rules.

### Operational Management
- **Feeding System:**  
  The `Foods` class manages food types and stock levels, ensuring animals are fed according to their caloric requirements.
- **People Management:**  
  The `People` class represents zoo staff and visitors within the system.

### Command-Based Simulation
- The system processes commands from text files (`commands.txt`) to simulate daily zoo operations dynamically.
- File parsing and data loading are modularized using the `fileReader` utility class.

---

## Project Structure
src/
├── Main.java
├── Animal.java
├── Lion.java
├── Elephant.java
├── Penguin.java
├── Chimpanzee.java
├── People.java
├── Foods.java
├── fileReader.java

### File Descriptions
- **Main.java**  
  Application entry point; initializes file reading and executes the command-processing loop.
- **Animal.java**  
  Abstract base class for all animal entities.
- **Species Classes (Lion, Elephant, etc.)**  
  Implement species-specific logic and care rules.
- **People.java**  
  Stores and manages zoo personnel and visitor information.
- **Foods.java**  
  Manages food types and available stock.
- **fileReader.java**  
  Handles file parsing and input processing.

---

## Input File Formats

The system works with the following input files:

- **animals.txt**  
  Animal species, ID, age, weight, and other relevant attributes.
- **foods.txt**  
  Food types and available stock quantities.
- **persons.txt**  
  Zoo staff and visitor records.
- **commands.txt**  
  Operational commands executed during the simulation.

---

## Compilation & Execution

To compile and run the project:

```bash
javac src/*.java
java src.Main
