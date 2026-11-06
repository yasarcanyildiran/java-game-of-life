package matrix;

public class ConstantMatrixInitializer<T> implements MatrixInitializer<T> {

   private final T constant;

  public ConstantMatrixInitializer(T constant) {
    this.constant = constant;
  }

    @Override
    public T get(Coordinate coordinate) {
      return constant;
    }
}
