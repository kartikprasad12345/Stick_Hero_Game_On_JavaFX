
<img width="731" height="727" alt="image" src="https://github.com/user-attachments/assets/eee4d9aa-7688-4095-8ff1-855aa657cbe0" />
<img width="423" height="531" alt="image" src="https://github.com/user-attachments/assets/f9c2a13c-6414-426c-9fbc-6a4599ec0f34" />
<img width="731" height="745" alt="image" src="https://github.com/user-attachments/assets/4393094f-c824-44d5-a909-5f5846d984e1" />


# JavaFX Bridge Game

## Description
This is a JavaFX-based game where players build bridges to cross between randomly generated pillars. Players start by running the `Homepage` class and can play or quit from there. The game involves creating bridges of the correct length to progress, collecting cherries for revival, and features pausing, saving, and loading game states, enhanced with animations for an exciting experience.

## Features
- Start the game from the `Homepage` class with **Play** and **Quit** options.
- Build bridges by clicking and holding the screen; release to let the bridge fall.
- Cross to the next pillar if the bridge is the perfect length; otherwise, the player falls.
- Collect cherries while moving; if the cherry count is 2 or more, the player revives upon falling.
- Pause the game with a **Pause** button, redirecting to a pause page with **Resume**, **Save**, and **Exit** options.
- Save the game state via the **Save** button and load it from the homepage using the **Load** button.
- Randomly generated pillars using `random_gen` for varied gameplay.
- Multi-threading to track player and cherry positions continuously.
- JUnit test files to test classes with different inputs.
- Animations for an enhanced gaming experience.

## How to Play
1. Run the `Homepage` class to start the game.
2. Click **Play** to begin or **Quit** to exit.
3. On the game page:
   - Click and hold the screen to make a bridge appear and grow longer.
   - Release the screen to let the bridge fall.
   - If the bridge is the perfect length, the player crosses to the next pillar.
   - If not, the player falls; with 2 or more cherries, the player revives and continues.
4. Collect cherries while moving to increase the cherry count for revival.
5. Click the **Pause** button to access the pause page:
   - **Resume**: Continue the game.
   - **Save**: Save the current game state.
   - **Exit**: Return to the homepage.
6. From the homepage, use the **Load** button to resume a saved game.

## Usage
Ensure JavaFX is installed and configured in your development environment. Compile and run the `Homepage` class to start the game.

## Testing
The project includes JUnit test files to verify the functionality of classes with various inputs.
