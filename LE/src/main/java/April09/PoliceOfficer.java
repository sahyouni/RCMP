package April09;

/**
 * Class PoliceOfficer info.
 *
 * @author (Cherry Cui)
 * @version (a version number or a date2020-03-02)
 */
public class PoliceOfficer {
    // Symbolic constants
    public static final double ONE_HOUR_FINE_AMOUNT = 20;
    public static final int MINUTES_IN_HOUR = 60;

    // instance variables
    private String officerName;
    private String officerBadgeNumber;

    /**
     * Parameterized Constructor for objects of class PoliceOfficer
     * 
     * @param name        A parameter to set officer name value
     * @param badgeNumber A parameter to set officer badge number
     */
    public PoliceOfficer(String name, String badgeNumber) {
        setOfficerName(name);
        setOfficerBadgeNumber(badgeNumber);
    }

    /**
     * Accessor getOfficerName
     * 
     * @return officerName
     */
    public String getOfficerName() {
        return officerName;
    }

    /**
     * Accessor getOfficerBadgeNumber
     * 
     * @return officerBadgeNumber
     */
    public String getOfficerBadgeNumber() {
        return officerBadgeNumber;
    }

    /**
     * Mutator setOfficerName
     * 
     * @param name A parameter to set officer name
     */
    public void setOfficerName(String name) {
        if (name == null)
            throw new IllegalArgumentException("officer name must not be null");

        if (name == "")
            throw new IllegalArgumentException("officer name must not be an empty String");

        officerName = name;
    }

    /**
     * Mutator setOfficerBadgeNumber
     * 
     * @param badgeNumber A parameter to set officer badge number
     */
    public void setOfficerBadgeNumber(String badgeNumber) {
        if (badgeNumber == null)
            throw new IllegalArgumentException("badge number must not be null");

        if (badgeNumber == "")
            throw new IllegalArgumentException("badge number must not be empty String");

        officerBadgeNumber = badgeNumber;
    }

    /**
     * A private method to check if the parkedCar time has expired
     * 
     * @return if it's expired
     */

    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter) {

        if (car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * A private method to calculate the fine
     * 
     * @return calculateFine
     */
    private double calculateFine(ParkedCar car, ParkingMeter meter) {
        int notPaidMinutes = car.getNumberOfMinutesParked() - meter.getNumberOfPurchasedMinutes();
        int k = notPaidMinutes % MINUTES_IN_HOUR;
        double fine = 0;
        int count = 0;
        if (isParkingTimeExpired(car, meter) == true) {
            if (notPaidMinutes % MINUTES_IN_HOUR == 0) {
                fine = ONE_HOUR_FINE_AMOUNT * notPaidMinutes / MINUTES_IN_HOUR;
            }
            if (notPaidMinutes < 60) {
                fine = ONE_HOUR_FINE_AMOUNT;
            }
            if (notPaidMinutes % MINUTES_IN_HOUR != 0) {
                while (notPaidMinutes > MINUTES_IN_HOUR) {
                    notPaidMinutes = notPaidMinutes - MINUTES_IN_HOUR;
                    count++;
                }

                fine = ONE_HOUR_FINE_AMOUNT * (count + 1);
            }

        }
        return fine;
    }

    /**
     * A method to issue parking ticket
     * 
     * @return ParkingTicket object
     */
    public ParkingTicket issueParkingTicket(ParkedCar car, ParkingMeter meter) {

        if (isParkingTimeExpired(car, meter) == true) {

            ParkingTicket parkingTicket = new ParkingTicket(officerName, officerBadgeNumber,
                    car.getLicensePlateNumber(), calculateFine(car, meter));

            System.out.println("Ticket Number: " + parkingTicket.getTicketNumber());

            System.out.println("Officer Name: " + getOfficerName());
            System.out.println("Officer Badge number: " + getOfficerBadgeNumber());
            System.out.println("Car License Plate Number: " + parkingTicket.getCarLicensePlateNumber());
            System.out.println("Fine amount: " + calculateFine(car, meter));
            return parkingTicket;
        } else {
            return null;
        }

    }
}
