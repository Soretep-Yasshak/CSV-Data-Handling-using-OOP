package CSV;

public class Mission implements Comparable<Mission> {

    private final String flightNumber;
    private final Date launchDate;
    private final Time launchTime;
    private final String launchSite;
    private final String vehicleType;
    private final Payload payload;
    private final Customer customer;
    private final String missionOutcome;
    private final String failureReason;
    private final String landingType;
    private final String landingOutcome;


    public Mission(Builder builder) {

        this.flightNumber    = builder.flightNumber;
        this.launchDate      = builder.launchDate;
        this.launchTime      = builder.launchTime;
        this.launchSite      = builder.launchSite;
        this.vehicleType     = builder.vehicleType;
        this.payload         = builder.payload;
        this.customer        = builder.customer;
        this.missionOutcome  = builder.missionOutcome;
        this.failureReason   = builder.failureReason;
        this.landingType     = builder.landingType;
        this.landingOutcome  = builder.landingOutcome;

    }


    @Override
    public int compareTo(Mission other) {

        if (this.launchDate.compareTo(other.launchDate) != 0) {

            return this.launchDate.compareTo(other.launchDate);

        }

        if (this.launchTime.compareTo(other.launchTime) != 0) {

            return this.launchTime.compareTo(other.launchTime);

        }

        return this.flightNumber.compareTo(other.flightNumber);

    }


    public Customer getCustomer() {

        return this.customer;

    }


    public Date getDate() {

        return this.launchDate;

    }


    public Payload getPayload() {

        return this.payload;

    }


    public String toFile() {

        StringBuilder result = new StringBuilder();
        result.append(String.format("%s, ", flightNumber));
        result.append(String.format("%s, ", launchDate));
        result.append(String.format("%s, ", launchTime));
        result.append(String.format("%s, ", launchSite));
        result.append(String.format("%s, ", vehicleType));
        result.append(String.format("%s, ", payload.toFile()));
        result.append(String.format("%s, ", customer.toFile()));
        result.append(String.format("%s, ", missionOutcome));
        result.append(String.format("%s, ", failureReason));
        result.append(String.format("%s, ", landingType));
        result.append(String.format("%s, ", landingOutcome));

        return result.toString();

    }


    @Override
    public String toString() {

        int items            = 11;
        DataMap[] map        = new DataMap[items];

        map[0]               = new DataMap("\nFlight Number:    \t", flightNumber);
        map[1]               = new DataMap("\nLaunch Date:      \t", launchDate.toString());
        map[2]               = new DataMap("\nLaunch Time:      \t", launchTime.toString());
        map[3]               = new DataMap("\nLaunch Site:      \t", launchSite);
        map[4]               = new DataMap("\nVehicle Type:     \t", vehicleType);
        map[5]               = new DataMap("\n---Payload---     \t", payload.toString());
        map[6]               = new DataMap("\n---Customer---    \t", customer.toString());
        map[7]               = new DataMap("\nMission Outcome:  \t", missionOutcome);
        map[8]               = new DataMap("\nFailure Reason:   \t", failureReason);
        map[9]               = new DataMap("\nLanding Type:     \t", landingType);
        map[10]              = new DataMap("\nLanding Outcome:  \t", landingOutcome);

        StringBuilder result = new StringBuilder("----------------------------------------------");

        for (int i = 0; i < items; i++) {

            result.append(String.format("%s %s", map[i].name, map[i].value));

        }

        return result.toString();

    }


}