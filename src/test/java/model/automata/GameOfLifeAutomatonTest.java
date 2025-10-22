package model.automata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeAutomatonTest {

  private final GameOfLifeAutomaton auto = new GameOfLifeAutomaton(10,8);
  private final Random gen = new Random(2874);
  @Test
  void numberOfColumns() {
    assertEquals(10, auto.numberOfColumns());
  }

  @Test
  void numberOfRows() {
    assertEquals(8, auto.numberOfRows());
  }

  @Test
  void defaultState() {
    assertEquals(GameOfLifeState.DEAD, auto.defaultState());
  }

  @Test
  void randomState() {
    List<GameOfLifeState> states = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      states.add(auto.randomState(gen));
    }
    assertTrue(states.contains(GameOfLifeState.ALIVE), "randomState should sometimes returns ALIVE");
    assertTrue(states.contains(GameOfLifeState.DEAD), "randomState should sometimes returun DEAD");
  }
}