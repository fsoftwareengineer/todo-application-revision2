package algorithms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberOfUniqueInts {

  public int findLeastNumOfUniqueInts(int[] arr, int k) {

    Map<Integer, Frequency> m = new LinkedHashMap<>();

    for (int i = 0; i < arr.length; i++) {
      m.putIfAbsent(arr[i], new Frequency(arr[i]));
      Frequency f = m.get(arr[i]);
      f.increaseFrequency();
    }
    List<Frequency> list = new ArrayList<>();;
    m.entrySet().stream().forEach((integerFrequencyEntry -> {
      Frequency f = integerFrequencyEntry.getValue();
      list.add(f);
    }));

    list.sort((f1, f2) -> f1.frequency - f2.frequency);

    for (int i = 0; i < k; i++) {
      Frequency f = list.get(0);
      if(f.frequency == 1) {
        list.remove(0);
      } else {
        f.decreaseFrequency();
      }
    }
    return list.size();
  }

  static class Frequency {
    int value;
    int frequency;

    public Frequency(int value) {
      this.value = value;
      this.frequency = 0;
    }

    public void increaseFrequency() {
      this.frequency++;
    }

    public void decreaseFrequency() {
      this.frequency--;
    }
  }

}
