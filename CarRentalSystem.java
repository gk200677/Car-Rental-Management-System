import java.util.*;

public class CarRentalSystem {
    private static List<Car> cars = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Preloaded cars
        cars.add(new Car(1, "Swift", 1200));
        cars.add(new Car(2, "Baleno", 1500));
        cars.add(new Car(3, "Creta", 2500));

        while (true) {
            try {
                System.out.println("\n===== CAR RENTAL SYSTEM =====");
                System.out.println("1. View Cars");
                System.out.println("2. Rent Car");
                System.out.println("3. Return Car");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        viewCars();
                        break;
                    case 2:
                        rentCar();
                        break;
                    case 3:
                        returnCar();
                        break;
                    case 4:
                        System.out.println("Thank you for using Car Rental System!");
                        System.exit(0);
                    default:
                        System.out.println("❌ Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter valid numeric input.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    private static void viewCars() {
        System.out.println("\n--- Available Cars ---");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void rentCar() throws Exception {
        System.out.print("Enter Car ID to rent: ");
        int carId = sc.nextInt();

        Car car = findCar(carId);

        if (car.isRented()) {
            throw new CarAlreadyRentedException("Car is already rented.");
        }

        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        if (days <= 0) {
            throw new InvalidRentalDaysException("Rental days must be greater than zero.");
        }

        double cost = days * car.getPricePerDay();
        car.rentCar();

        System.out.println("✅ Car rented successfully!");
        System.out.println("Total cost: ₹" + cost);
    }

    private static void returnCar() throws Exception {
        System.out.print("Enter Car ID to return: ");
        int carId = sc.nextInt();

        Car car = findCar(carId);

        if (!car.isRented()) {
            throw new Exception("Car is not rented.");
        }

        car.returnCar();
        System.out.println("✅ Car returned successfully!");
    }

    private static Car findCar(int carId) throws CarNotFoundException {
        for (Car car : cars) {
            if (car.getCarId() == carId) {
                return car;
            }
        }
        throw new CarNotFoundException("Car with ID " + carId + " not found.");
    }
}
