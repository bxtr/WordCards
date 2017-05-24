import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by bxtr on 22.05.2017.
 */
public class NoisePickerTest {

    @Test
    public void RandomNoisePickerGetWords() {
        NoisePicker noisePicker = new RandomNoisePicker();
        WordCard wordCard = new WordCard();
        wordCard.setOriginalWord("esti");
        wordCard.setTranslation("быть");
        List<WordCard> wordCardList = noisePicker.getNoise(wordCard, Main.getAllWordCards(), 3);
        wordCardList.add(wordCard);
        Collections.shuffle(wordCardList);
        System.out.println("start:RandomNoisePickerGetWords");
        for(WordCard temp : wordCardList) {
            System.out.println(String.format("%s - %s", temp.getOriginalWord(), temp.getTranslation()));
        }
        System.out.println("end:RandomNoisePickerGetWords");
    }
}
