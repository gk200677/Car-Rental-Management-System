public class Car {
    private int carId;
    private String model;
    private double pricePerDay;
    private boolean isRented;

    public Car(int carId, String model, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isRented = false;
    }

    public int getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        this.isRented = true;
    }

    public void returnCar() {
        this.isRented = false;
    }

    @Override
    public String toString() {
        return "Car ID: " + carId +
               ", Model: " + model +
               ", Price/Day: ₹" + pricePerDay +
               ", Status: " + (isRented ? "Rented" : "Available");
    }
}
