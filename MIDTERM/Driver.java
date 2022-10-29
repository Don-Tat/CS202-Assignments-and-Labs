import java.util.Random;
//template for algorithm found online images attached.
public class Driver {

    public static Random generator = new Random();
    public static final int NUM_STATIONS = 5;
    public static final int TRAIN_CAPACITY = 50;
    public static final int TRAIN_INTERVAL = 10;
    public static final int TIME_INTERVAL = 200;
    public static int trainCount = 0;
    public static int passengersOnTrain = 0;
    public static int passengersDelivered = 0;

    // Create List for train Stations
    public static Station[] stations = new Station[NUM_STATIONS];
    // Create Queue for Trains
    public static LinkedQueue<Train> trains = new LinkedQueue<>();
    // Create Queue for passengers
    public static LinkedQueue<Passenger> passengers = new LinkedQueue<>();
    // Declare variable to keep track of number of passengers created
    public static int passengerCount = 0;
    // Declare variable to keep track of number of passengers waiting
    public static int passengersWaiting = 0;

    /*
     * Call method to create stations
     * Loop for time interval. Report time. Report how many passengers waiting.
     * Report how many passengers on train. Call method to start new train. Call
     * method to create new passengers at this interval. Update number of passengers
     * created. Call method to move trians in queue.
     */
    public static void main(String[] args) {
        createStations();
        for (int clock = 0; clock < TIME_INTERVAL; clock++) {
            System.out.println("Time: " + clock);
            System.out.println("Passengers waiting: " + passengersWaiting);
            System.out.println("Passengers on train: " + passengersOnTrain);
            System.out.println("Passengers delivered: " + passengersDelivered);
            startNewTrain(clock);
            createNewPassengers(clock);
            moveTrains(clock);
        }

        // Call final report method

        finalReport();

    }

    // Create stations method
    /*
     * Loop for number of stations created, generate random number from 5 to 10 for
     * time to next station. Add new station to queue. Output statement to confirm
     * station has been created with time to next station
     */

    public static void createStations() {
        for (int i = 0; i < NUM_STATIONS; i++) {
            int timeToNext = generator.nextInt(6) + 5;
            stations[i] = new Station(timeToNext);
            System.out.println("Station created, time to next station: " + timeToNext);
        }
    }

    // start new train method
    /*
     * Start new train method. Check to see if train is divisible by TRAIN_INTERVAL.
     * If true add train to queue. Increase train count.
     */

    public static void startNewTrain(int clock) {
        if (clock % TRAIN_INTERVAL == 0) {
            trains.enqueue(new Train(TRAIN_CAPACITY));
            trainCount++;
        }
    }

    // Create new passenger method
    /*
     * Generate random number from 0 to 5 for number of passengers to create. Loop
     * for the number of passengers to create, initialize start station and stop
     * station, loop until the start station < stop station (pick random number for
     * start station and stop station), create new pasenger with start staion and
     * stop station, add passenger to appropriate start staion, add passenger to
     * passenger queue.
     */

    public static void createNewPassengers(int clock) {
        int numPassengers = generator.nextInt(6);
        for (int i = 0; i < numPassengers; i++) {
            int startStation = generator.nextInt(NUM_STATIONS);
            int stopStation = generator.nextInt(NUM_STATIONS);
            while (startStation >= stopStation) {
                startStation = generator.nextInt(NUM_STATIONS);
                stopStation = generator.nextInt(NUM_STATIONS);
            }
            Passenger passenger = new Passenger(startStation, stopStation);
            stations[startStation].addPassenger(passenger);
            passengers.enqueue(passenger);
            passengerCount++;
            passengersWaiting++;
        }
    }

    // move trains method
    /*
     * Store trainCount variable in local variable for numTrains. Loop to process
     * all the trains (use local variable for condition) in the queue, get a train
     * from queue, move train, get the time to next station, check to see if the
     * current time is equal to 0 at the station, get the station, uload passengers
     * at the station, load passengers from the station, update passengers on
     * trains, update passengers delivered to station, update train to next station
     * to move to, check to make sure the next station is valid put the train back
     * in queue if still more stations else doent put back in queue and update train
     * count.
     */
    public static void moveTrains(int clock) {
        int numTrains = trainCount;
        for (int i = 0; i < numTrains; i++) {
            Train train = trains.dequeue();
            train.move();
            int timeToNext = train.timeToNext();
            if (timeToNext == 0) {
                int station = train.nextStation();
                passengersOnTrain -= train.unloadPassengers(station);
                train.loadPassengers(stations[station], timeToNext);
                passengersOnTrain += train.getPassengersOnTrain();
                passengersDelivered += train.getPassengersDelivered();
                train.updateTrainToNextStation();
                if (train.getTrainToNextStation() < NUM_STATIONS) {
                    trains.enqueue(train);
                } else {
                    trainCount--;
                }
            } else {
                trains.enqueue(train);
            }
        }
    }
    // final report method
    /*
     * Output final report with number of trains created, number of passengers
     * created, number of passengers delivered, average wait time for passengers
     */

    public static void finalReport() {
        System.out.println("Final Report");
        System.out.println("Number of trains created: " + trainCount);
        System.out.println("Number of passengers created: " + passengerCount);
        System.out.println("Number of passengers delivered: " + passengersDelivered);

    }
}