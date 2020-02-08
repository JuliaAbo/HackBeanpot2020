import java.io.IOException;

public interface IHangmanView {
  void render() throws IOException;

  void addFeatures(Features f);
}
