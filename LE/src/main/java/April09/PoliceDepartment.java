package April09;

/**
 * Class PoliceDepartment here.
 *
 * @author (Cherry Cui)
 * @version (2020-03-19)
 */
import java.util.ArrayList;

public class PoliceDepartment {
    // instance variables
    private String address;
    private ArrayList<PoliceOfficer> officersList;
    private ParkingTicket parkingTicket;

    /**
     * Constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment(String inputAddress) {
        setAddress(inputAddress);
        officersList = new ArrayList<PoliceOfficer>();
    }

    /**
     * Accessor getAddress
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Accessor getOfficerList return officersList
     */
    public ArrayList<PoliceOfficer> getOfficerList() {
        return officersList;
    }

    /**
     * Mutator setAddress
     * 
     * @param inputAddress
     */
    public void setAddress(String inputAddress) {
        if (inputAddress == null) {
            throw new IllegalArgumentException("address cannot be null");
        } else {
            if (inputAddress.isEmpty()) {
                throw new IllegalArgumentException("address cannot be an empty String");
            }
        }
    }

    /**
     * A method to add PoliceOfficer object to the officersList
     * 
     * @param PoliceOfficer objects
     */
    public void addPoliceOfficer(PoliceOfficer officer) {
        if (officer != null) {
            officersList.add(officer);
        }
    }

    /**
     * A method to search the collection and display a list of the parking tickets
     * issued by the specific officer
     * 
     * @param officerName
     */
    public void displayTicketsByOfficer(String officerName) {
        if (officerName != null) {
            for (PoliceOfficer officer : officersList) {
                if (officerName == officer.getOfficerName()) {
                    officer.displayticketsDetails();
                }
            }
        }
    }

    /**
     * A method to calculate the total amount of fines issued by all the officers in
     * the collection
     * 
     * @return sum
     */
    public double calculateSumOfAllTicketsOfAllOfficers() {
        double sum = 0;
        for (PoliceOfficer officer : officersList) {
            sum = sum + officer.sumAllfines();
        }
        return sum;
    }

    /**
     * A method to search in the collection for total count of tickets issued to the
     * plate number
     * 
     * @param carLicensePlateNumber
     * @return totalTicketCount
     */
    public int totalParkingTicketCountOfACar(String carLicensePlateNumber) {

        int totalTicketCount = 0;
        for (PoliceOfficer officer : officersList) {
            String license = parkingTicket.getCarLicensePlateNumber();
            if (carLicensePlateNumber.equalsIgnoreCase(license)) {

                totalTicketCount = totalTicketCount + officer.getParkingTicketsCountForACar(carLicensePlateNumber);

            }

        }

        return totalTicketCount;

    }

}
