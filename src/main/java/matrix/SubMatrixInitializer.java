package matrix;

/**
 * A {@link MatrixInitializer} that takes its values from a part of another {@link Matrix}.
 * The cell (x, y) of the sub-matrix gets the value of the cell (x + x0, y + y0) of the
 * original matrix, where (x0, y0) is the corner of the sub-matrix.
 *
 * @param <T> The type of values stored in the matrix cells.
 */
public class SubMatrixInitializer<T> implements MatrixInitializer<T> {

  private final Matrix<T> matrix;
  private final Coordinate corner;

  public SubMatrixInitializer(Matrix<T> matrix, Coordinate corner) {
    this.matrix = matrix;
    this.corner = corner;
  }

  @Override
  public T get(Coordinate coordinate) {
    return matrix.get(coordinate.plus(corner));
  }
}
