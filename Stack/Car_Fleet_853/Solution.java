import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int numberOfCars = position.length;
        double[][] carPositionAndTime = new double[numberOfCars][2];

        // Each row stores [starting position, arrival time].
        for (int i = 0; i < numberOfCars; i++) {
            carPositionAndTime[i][0] = position[i];
            carPositionAndTime[i][1] =
                    (double) (target - position[i]) / speed[i];
        }

        // Closest to the destination first.
        Arrays.sort(carPositionAndTime,
                (carA, carB) -> Double.compare(carB[0], carA[0]));

        int fleetCount = 0;
        double fleetAheadArrivalTime = 0;

        for (double[] currentCar : carPositionAndTime) {
            double currentCarArrivalTime = currentCar[1];

            // A slower arrival means this car cannot catch the fleet ahead.
            if (currentCarArrivalTime > fleetAheadArrivalTime) {
                fleetCount++;
                fleetAheadArrivalTime = currentCarArrivalTime;
            }
        }

        return fleetCount;
    }
}
