package CSV;

public enum Month {

    JAN("Jan"),
    FEB("Feb"),
    MAR("Mar"),
    APR("Apr"),
    MAY("May"),
    JUN("Jun"),
    JUL("Jul"),
    AUG("Aug"),
    SEP("Sep"),
    OCT("Oct"),
    NOV("Nov"),
    DEC("Dec");

    private final String value;


    Month(String value) {

        this.value        = value;

    }


    @Override
    public String toString() {

        return value;

    }

}
