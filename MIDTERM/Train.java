public class Train {
    private StackInterface<Passenger> onTrain;
    private int numPassengersOnTrain;
    private int capacity;
    private int nextStation;
    private int timeToNextStation;
    private int trainNum;
    private static int trainsCreated = 0;

    public Train(int cap) {
        onTrain = new ArrayStack<>();
        numPassengersOnTrain = 0;
        capacity = cap;
        nextStation = 0;
        timeToNextStation = 1;
        trainsCreated++;
        trainNum = trainsCreated;
        System.out.println("Train created, capacity: " + capacity + " Train number: " + trainNum);
    }

    public int nextStation() {
        return nextStation;
    }

    public int timeToNext() {
        return timeToNextStation;
    }

    public void move() {
        timeToNextStation--;
    }

    public void changeStation(int timeToNext) {
        nextStation++;
        timeToNextStation = timeToNext;
    }

    public int unloadPassengers(int station) {
        StackInterface<Passenger> temp = new ArrayStack<>();
        int count = numPassengersOnTrain;
        for (int i = 0; i < count; i++) {
            Passenger passenger = onTrain.pop();
            if (passenger.getDestination() == station) {
                numPassengersOnTrain--;
            } else {
                temp.push(passenger);
            }
        }
        onTrain = temp;
        int passengersUnloaded = count - numPassengersOnTrain;
        System.out
                .println("Train " + trainNum + " unloaded " + passengersUnloaded + " passengers at station " + station);
        return passengersUnloaded;
    }

    public int loadPassengers(Station station, int clock) {
        int count = numPassengersOnTrain;
        boolean passengerWaiting = station.isWaiting();
        while (passengerWaiting && (numPassengersOnTrain < capacity)) {
            Passenger passenger = station.getPassenger();
            onTrain.push(passenger);
            passenger.boardTrain(clock);
            passengerWaiting = station.isWaiting();
            numPassengersOnTrain++;
        }
        int passengersBoarding = numPassengersOnTrain - count;
        System.out.println("Loaded" + passengersBoarding + " passengers on train " + trainNum);
        System.out.println("Space left on train: " + (capacity - numPassengersOnTrain));
        return passengersBoarding;
    }

    public int getPassengersOnTrain() {
        return numPassengersOnTrain;
    }

    public int getPassengersDelivered() {
        return numPassengersOnTrain;
    }

    public int getTrainToNextStation() {
        return nextStation;
    }

    public void updateTrainToNextStation() {
        nextStation++;
    }
}