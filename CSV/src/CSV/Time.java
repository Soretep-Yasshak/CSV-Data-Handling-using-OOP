package CSV;

public class Time implements Comparable<Time> {

    private final int hour;
    private final int minutes;


    public Time() {

        this(0, 0);

    }


    public Time(String time) {

        if (time == null || time.isEmpty()) {

            throw new IllegalArgumentException("Time string must not be empty");

        }

        String[] parts     = time.split(":");

        if (parts.length != 2) {

            throw new IllegalArgumentException("Time string must contain exactly one ':' character");

        }

        hour               = Integer.parseInt(parts[0]);
        minutes            = Integer.parseInt(parts[1]);

        if (hour < 0 || hour > 23) {

            throw new IllegalArgumentException("Hour value must be between 0 and 23");

        }

        if (minutes < 0 || minutes > 59) {

            throw new IllegalArgumentException("Minute value must be between 0 and 59");

        }

    }


    public Time(int hour, int minutes) {

        this.hour         = hour;
        this.minutes      = minutes;

    }


    public int getHour() {

        return hour;

    }


    public int getMinutes() {

        return minutes;

    }


    @Override
    public int compareTo(Time other) {

        if (this.getHour() != other.getHour()) {

            return Integer.compare(this.getHour(), other.getHour());

        }

        else {

            return Integer.compare(this.getMinutes(), other.getMinutes());

        }

    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (!(o instanceof Time time)) {

            return false;

        }

        return hour == time.hour && minutes == time.minutes;

    }


    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minutes);

    }

}
