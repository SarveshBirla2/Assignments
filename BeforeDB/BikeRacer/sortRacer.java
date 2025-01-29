package BikeRacer;

public class sortRacer {
    public static void sortRacersByTime(Racer[] racers) {
        // Sorting the racers array using simple Bubble Sort
        for (int i = 0; i < racers.length - 1; i++) {
            for (int j = 0; j < racers.length - i - 1; j++) {
                long time1 = racers[j].getEndTime() - racers[j].getStartTime();
                long time2 = racers[j + 1].getEndTime() - racers[j + 1].getStartTime();
                if (time1 > time2) {
                    // Swap if the first racer took more time
                    Racer temp = racers[j];
                    racers[j] = racers[j + 1];
                    racers[j + 1] = temp;
                }
            }
        }
    }
}
