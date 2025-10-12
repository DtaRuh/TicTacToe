# OOP Implementation

Object-oriented refactor demonstrating proper class design and separation of concerns.

## Class Structure

- **Main.java** - Entry point with replay functionality
- **Game.java** - Game flow, turn management, and win/tie detection
- **Board.java** - Board state management and move validation
- **Player.java** - Player representation with symbol tracking

## How to Run

```bash
javac *.java && java Main
```

## Features

- Multi-class architecture
- Encapsulation of game logic
- Input validation with error handling
- Play-again functionality
- Clean separation between game logic and board management

## Key OOP Concepts Demonstrated

- **Encapsulation** - Each class manages its own data
- **Single Responsibility** - Each class has one clear purpose
- **Object Composition** - Game uses Board and Player objects
- **Data Hiding** - Private fields with public methods

---

See [parent directory](../) for full project documentation and comparison with procedural version.