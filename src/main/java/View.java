import java.util.List;

/**
 * Created by bxtr on 24.05.2017.
 */
public interface View {

    void showQuestedWord(WordCard wordCard);

    void showPossibleAnswers(List<WordCard> wordCards);

    int getUserAnswer();

    void showSuccess();

    void showWrong(WordCard wordCard);
}
