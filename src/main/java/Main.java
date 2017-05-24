import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bxtr on 22.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<WordCard> allWordCards = getAllWordCards();
        Collections.shuffle(allWordCards);
        List<WordCard> wordCardsForOneRound = allWordCards.subList(0, 5);
        NoisePicker noisePicker = new RandomNoisePicker();
        View view = new ConsoleView();
        for(WordCard wordCard : wordCardsForOneRound) {
            List<WordCard> noiseWordCards = noisePicker.getNoise(wordCard, allWordCards, 3);
            noiseWordCards.add(wordCard);
            Collections.shuffle(noiseWordCards);
            view.showQuestedWord(wordCard);
            view.showPossibleAnswers(noiseWordCards);
            int answerIndex = view.getUserAnswer();
            if(answerIndex < 0 || answerIndex >= noiseWordCards.size()) {
                continue;
            }
            WordCard userAnswer = noiseWordCards.get(answerIndex);
            if(wordCard.getOriginalWord().equals(userAnswer.getOriginalWord())) {
                view.showSuccess();
            } else {
                view.showWrong(wordCard);
            }
        }
    }


    public static List<WordCard> getAllWordCards() {
        List<WordCard> list = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:wordcardsDB.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select original, translation from wordcards");
            while(resultSet.next()) {
                WordCard wordCard = new WordCard();
                wordCard.setOriginalWord(resultSet.getString("original"));
                wordCard.setTranslation(resultSet.getString("translation"));
                list.add(wordCard);
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return list;
    }
}
