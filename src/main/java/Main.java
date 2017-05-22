import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bxtr on 22.05.2017.
 */
public class Main {
    public static void main(String[] args) {



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
