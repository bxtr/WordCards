import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bxtr on 22.05.2017.
 */
public class RandomNoisePicker implements NoisePicker {

    @Override
    public List<WordCard> getNoise(WordCard wordCard, List<WordCard> from, int size) {
        Random random = new Random();
        List<Integer> indexList = new ArrayList<>();
        int count = 0;
        while (true) {
            int newIndex = random.nextInt(from.size());

            if (!indexList.contains(newIndex)) {
                indexList.add(newIndex);
            }

            if(indexList.size() == size || count > 100) {
                break;
            }

            count++;
        }

        List<WordCard> resultList = new ArrayList<>();
        for(Integer index : indexList) {
            resultList.add(from.get(index));
        }

        return resultList;
    }
}
