import java.io.Console;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by bxtr on 24.05.2017.
 */
public class ConsoleView implements View {

    @Override
    public void showQuestedWord(WordCard wordCard) {
        System.out.println(String.format("\n%s\n", wordCard.getOriginalWord()));
    }

    @Override
    public void showPossibleAnswers(List<WordCard> wordCards) {
        int count = 1;
        System.out.println();
        for(WordCard wordCard : wordCards) {
            System.out.println(String.format("%d. %s", count, wordCard.getTranslation()));
            count++;
        }
        System.out.println();
    }

    @Override
    public int getUserAnswer() {
        int answer = 0;
        Scanner reader = new Scanner(System.in);
        if(reader.hasNextInt()) {
            try {
                answer = reader.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Please, write a number.");
            }
        }
        return answer-1;
    }

    @Override
    public void showSuccess() {
        System.out.println("Right!");
    }

    @Override
    public void showWrong(WordCard wordCard) {
        System.out.println(String.format(
                "Wrong..\n%s is right answer.", wordCard.getTranslation()
        ));
    }
}
