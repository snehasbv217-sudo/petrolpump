import java.util.Scanner;

public class CircularPetrolPump {

    public static int findStartingPoint(int[] petrol, int[] distance) {

        int start = 0;
        int currentPetrol = 0;
        int totalPetrol = 0;

        for (int i = 0; i < petrol.length; i++) {

            currentPetrol += petrol[i] - distance[i];
            totalPetrol += petrol[i] - distance[i];

            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        if (totalPetrol >= 0) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of petrol pumps must be greater than 0.");
            scanner.close();
            return;
        }

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("\nEnter petrol available at each pump:");

        for (int i = 0; i < n; i++) {
            System.out.print("Petrol at pump " + i + ": ");
            petrol[i] = scanner.nextInt();
        }

        System.out.println("\nEnter distance to the next pump:");

        for (int i = 0; i < n; i++) {
            System.out.print("Distance from pump " + i + ": ");
            distance[i] = scanner.nextInt();
        }

        int result = findStartingPoint(petrol, distance);

        System.out.println();

        if (result == -1) {
            System.out.println("It is not possible to complete the circular journey.");
        } else {
            System.out.println("Starting petrol pump: " + result);
        }

        scanner.close();
    }
}