public class Passenger {
    private int waitingTime;
    private int boardingPoint;
    private boolean onTrain;
    private int destinationPoint;

    public Passenger(int start, int destination) {
        waitingTime = start;
        destinationPoint = destination;
        onTrain = false;
        System.out.println("Passenger created. Created at: " + start + " Destination: " + destinationPoint);
    }

    public int getDestination() {
        return destinationPoint;
    }

    public void boardTrain(int clock) {
        onTrain = true;
        waitingTime = clock;
        System.out.println("Passenger boarded train. Waiting time: " + waitingTime);
    }

    public int waitTime(int clock) {
        int result = clock - waitingTime;
        if (onTrain) {
            result = boardingPoint - waitingTime;
            return result;
        } else {
            return 0;
        }
    }

    public boolean isOnTrain() {
        return onTrain;
    }
}