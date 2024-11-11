package CSV;

public class Date implements Comparable<Date> {

    private final Month month;
    private final int day;
    private final int year;


    public Date() {

        this(Month.JAN, 0, 0);

    }


    public Date(String date) {

        String[] array     = date.split("-");
        this.day           = Integer.parseInt(array[0]);
        this.month         = Month.valueOf(array[1].toUpperCase());
        this.year          = Integer.parseInt(array[2]);

    }


    public Date(Month month, int day, int year) {

        this.month        = month;
        this.day          = day;
        this.year         = year;

    }


    public int getDay() {

        return day;

    }


    public Month getMonth() {

        return month;

    }


    public int getYear() {

        return year;

    }


    @Override
    public int compareTo(Date other) {

        if (this.getYear() != other.getYear()) {

            return Integer.compare(this.getYear(), other.getYear());

        }

        if (this.getMonth() != other.getMonth()) {

            return this.getMonth().compareTo(other.getMonth());

        }

        return Integer.compare(this.getDay(), other.getDay());

    }


    @Override
    public boolean equals(Object o) {

        if (o == this) {

            return true;

        }

        if (!(o instanceof Date other)) {

            return false;

        }

        return month == other.month && day == other.day && year == other.year;

    }


    @Override
    public String toString() {

        String value      = String.format("%d-%s-%02d", day, month, year);
        return value.equals("0-Jan-0") ? "" : value;

    }

}
