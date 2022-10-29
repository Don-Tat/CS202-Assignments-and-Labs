public class Station {
    private QueueInterface<Passenger> waitingPassengers;
    private int timeToNextStation;

    public Station(int timeToNext) {
        waitingPassengers = new LinkedQueue<>();
        timeToNextStation = timeToNext;
    }

    public void addPassenger(Passenger passenger) {
        waitingPassengers.enqueue(passenger);
    }

    public boolean isWaiting() {
        return !waitingPassengers.isEmpty();
    }

    public Passenger getPassenger() {
        return waitingPassengers.dequeue();
    }

    public int timeToNext() {
        return timeToNextStation;
    }
}
