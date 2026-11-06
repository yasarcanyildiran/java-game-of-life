package matrix;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a matrix, a rectangular array, with generic values in each cell.
 *
 * @param <T> The type of values stored in the matrix cells.
 */
public class ListMatrix<T> implements Matrix<T> {

  private final List<List<T>> matrix;
  private final int width;
  private final int height;

  /**
   * Creates a new {@link ListMatrix} with the specified width, height, and an initializer to set
   * values.
   *
   * @param width       The width of the {@link ListMatrix}.
   * @param height      The height of the {@link ListMatrix}.
   * @param initializer A matrix initializer to set values in the {@link ListMatrix}.
   */
  public ListMatrix(int width, int height, MatrixInitializer<T> initializer) {
    this.width = width;
    this.height = height;
    this.matrix = new ArrayList<>();
    this.initializeWith(initializer); // fills the matrix using initializer
  }

  public ListMatrix(int width, int height, T constant) {
    this(width, height, new ConstantMatrixInitializer<>(constant));
  }

  private void initializeWith(MatrixInitializer<T> initializer) {
    for (int y = 0; y < height; y++) {
      List<T> row = new ArrayList<>();
      for (int x = 0; x < width; x++) {
        row.add(initializer.get(Coordinate.of(x, y)));
      }
      matrix.add(row);
    }
  }

  public enum Color { WHITE, BLACK; }

  static ListMatrix<Color> checkerboard(int width, int height) {
    return new ListMatrix<>(
      width,
      height,
      coord -> (coord.x() + coord.y()) % 2 == 0 ? Color.WHITE : Color.BLACK
      );
  }

  static ListMatrix<Integer> add(Matrix<Integer> m1, Matrix<Integer> m2) {
    return new ListMatrix<>(
      m1.width(),
      m1.height(),
      coord -> m1.get(coord) + m2.get(coord)
    );
  }


  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  @Override
  public T get(int x, int y) {
    return matrix.get(y).get(x);
  }


  @Override
  public void set(int x, int y, T newValue) {
    matrix.get(y).set(x, newValue);
  }

  public Matrix<T> subMatrix(Coordinate corner, int width, int height) {
    return new ListMatrix<>(width, height, new SubMatrixInitializer<>(this, corner));
  }

}
