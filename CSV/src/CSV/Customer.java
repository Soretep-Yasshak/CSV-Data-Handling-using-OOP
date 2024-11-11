package CSV;

import java.util.Objects;

public class Customer implements Comparable<Customer> {

    private final String name;
    private final String country;
    private final String type;


    public Customer() {

        this(" ", " ", " ");

    }


    public Customer(String name, String country, String type) {

        this.name          = name;
        this.country       = country;
        this.type          = type;

    }


    public String getCountry() {

        return country;

    }


    @Override
    public int compareTo(Customer other) {

        if (!name.equals(other.name)) {

            return name.compareTo(other.name);

        }

        else if (!type.equals(other.type)) {

            return type.compareTo(other.type);

        }

        else {

            return this.getCountry().compareTo(other.getCountry());

        }

    }


    @Override
    public boolean equals(Object o) {

        if (o == this) {

            return true;

        }

        if (!(o instanceof Customer other)) {

            return false;

        }

        return Objects.equals(name, other.name) &&
                Objects.equals(country, other.country) &&
                Objects.equals(type, other.type);

    }


    public String toFile() {

        return String.format("%s,%s,%s", name, type, country);

    }


    public String getName() {

        return name;

    }


    @Override
    public String toString() {

        int items            = 3;
        DataMap[] map        = new DataMap[items];

        map[0]               = new DataMap("\n \tName:          \t", name);
        map[1]               = new DataMap("\n \tType:          \t", type);
        map[2]               = new DataMap("\n \tCountry:       \t", country);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items; i++) {

            result.append(String.format("%s %s", map[i].name, map[i].value));

        }

        return result.toString();

    }


    public String getType() {

        return type;

    }

}