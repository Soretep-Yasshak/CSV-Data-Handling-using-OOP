package CSV;

public class Builder {

    String flightNumber;
    Date launchDate;
    Time launchTime;
    String launchSite;
    String vehicleType;
    Payload payload;
    Customer customer;
    String missionOutcome;
    String failureReason;
    String landingType;
    String landingOutcome;


    public Builder() {

        flightNumber       = "";
        launchDate         = new Date();
        launchTime         = new Time();
        launchSite         = "";
        vehicleType        = "";
        payload            = new Payload();
        customer           = new Customer();
        missionOutcome     = "";
        failureReason      = "";
        landingType        = "";
        landingOutcome     = "";

    }


    public Builder setCustomer(Customer customer) {

        this.customer      = customer;
        return this;

    }


    public Builder setFailureReason(String failureReason) {

        this.failureReason = failureReason;
        return this;

    }


    public Builder setFlightNumber(String flightNumber) {

        this.flightNumber  = flightNumber;
        return this;

    }


    public Builder setLaunchDate(Date launchDate) {

        this.launchDate    = launchDate;
        return this;

    }


    public Builder setLaunchSite(String launchSite) {

        this.launchSite    = launchSite;
        return this;

    }


    public Builder setLaunchTime(Time launchTime) {

        this.launchTime    = launchTime;
        return this;

    }


    public Builder setLandingType(String landingType) {

        this.landingType   = landingType;
        return this;

    }


    public Builder setLandingOutcome(String landingOutcome) {

        this.landingOutcome = landingOutcome;
        return this;

    }


    public Builder setMissionOutcome(String missionOutcome) {

        this.missionOutcome = missionOutcome;
        return this;

    }


    public Builder setPayload(Payload payload) {

        this.payload       = payload;
        return this;

    }


    public Builder setVehicleType(String vehicleType) {

        this.vehicleType   = vehicleType;
        return this;

    }


    public Mission build() {

        return new Mission(this);

    }

}