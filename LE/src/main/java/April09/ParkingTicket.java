package April09;

/**
 * Class ParkingTicket information.
 *
 * @author (Cherry Cui)
 * @version (2020-03-02)
 */
public class ParkingTicket {
    // Symbolic Constants
    public static final String TICKET_PREFIX = "VAN";

    // instance variables

    private String ticketNumber;
    private String officerName;
    private String officerBadgeNumber;
    private String carLicensePlateNumber;
    private double fineAmountInCAD;
    public static int counter = 1000;
    private static int resetCounter = counter;

    /**
     * Parameterized Constructor for objects of class ParkingTicket
     * 
     * @param inputOfficerName        A parameter to set police office's name
     * @param inputOfficerBadgeNumber A parameter to set officre's badge number
     * @param carLicenseNumber        A parameter to set car license number
     * @param fine                    A parameter to set fine amount value
     */
    public ParkingTicket(String inputOfficerName, String inputOfficerBadgeNumber, String carLicenseNumber,
            double fine) {
        setOfficerName(inputOfficerName);
        setOfficerBadgeNumber(inputOfficerBadgeNumber);
        setCarLicensePlateNumber(carLicenseNumber);
        setFineAmountInCAD(fine);
        generateTicketNumber();
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
     * Accessor getCarLicensePlateNumber
     * 
     * @return carLicensePlateNumber
     */
    public String getCarLicensePlateNumber() {
        return carLicensePlateNumber;
    }

    /**
     * Accessor getTicketNumber
     * 
     * @return ticketNumber
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Accessor getFineAmountInCAD
     * 
     * @return fineAmountInCAD
     */
    public double getFineAmountInCAD() {
        return fineAmountInCAD;
    }

    /**
     * Mutator setOfficerName
     * 
     * @param inputOfficerName A parameter to set police office's name
     * 
     */
    public void setOfficerName(String inputOfficerName) {
        if (inputOfficerName == null) {
            throw new IllegalArgumentException("officer name must not be null");
        }
        if (inputOfficerName == "") {
            throw new IllegalArgumentException("officer name must not be an empty String");
        }

        officerName = inputOfficerName;
    }

    /**
     * Mutator setOfficerBadgeNumber
     * 
     * @param inputOfficerBadgeNumber A parameter to set police office's badge
     *                                number
     * 
     */
    public void setOfficerBadgeNumber(String inputOfficerBadgeNumber) {
        if (inputOfficerBadgeNumber == null)
            throw new IllegalArgumentException("badge number must not be null");

        if (inputOfficerBadgeNumber == "")
            throw new IllegalArgumentException("badge number must not be empty String");

        officerBadgeNumber = inputOfficerBadgeNumber;

    }

    /**
     * Mutator setCarLicenseNumber
     * 
     * @param carLicenseNumber A parameter to set car license number
     * 
     */
    public void setCarLicensePlateNumber(String carLicenseNumber) {
        if (carLicenseNumber == null) {
            throw new IllegalArgumentException("car license plate number must not be null");

        }
        if (carLicenseNumber == "") {
            throw new IllegalArgumentException("car license plate number must not be empty String");

        }
        carLicensePlateNumber = carLicenseNumber;
    }

    /**
     * Mutator setFineAmountInCAD
     * 
     * @param fine A parameter to set fine amount
     */
    public void setFineAmountInCAD(double fine) {
        if (fine == 0) {
            throw new IllegalArgumentException("fine amount must not be 0");
        } 
        
        if (fine < 0) {
            throw new IllegalArgumentException("fine amount must not be negative");
        } 
        
        fineAmountInCAD = fine;
        
    }

    /**
     * private method - to create unique sequential ticket numbers
     * 
     * @return ticketNumber
     */

    private String generateTicketNumber() {
        counter = counter + 1;
        ticketNumber = TICKET_PREFIX + counter;
        return ticketNumber;
    }

    /**
     * Method - displayDetails to display the details of the ParkedCar object
     */
    public void displayDetails() {
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Officer Name: " + getOfficerName());
        System.out.println("Officer Badge number: " + getOfficerBadgeNumber());
        System.out.println("Car License Plate Number: " + getCarLicensePlateNumber());
        System.out.println("Fine amount: " + getFineAmountInCAD());
    }

    /**
     * Static method to set the counter to the value 1000
     */
    public static void resetCounter() {
        counter = resetCounter;

    }
}
