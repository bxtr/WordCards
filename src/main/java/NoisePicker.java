import java.util.List;

/**
 * Created by bxtr on 22.05.2017.
 */
public interface NoisePicker {
    List<WordCard> getNoise(WordCard wordCard, List<WordCard> from, int size);
}
