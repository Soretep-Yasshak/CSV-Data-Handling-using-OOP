package CSV;

public class Payload implements Comparable<Payload> {

    private final String name;
    private final String type;
    private final double mass;
    private final String orbit;


    public Payload() {

        this("", " ", 0.0, "");

    }


    public Payload(String name, String type, double mass, String orbit) {

        this.name         = name;
        this.type         = type;
        this.mass         = mass;
        this.orbit        = orbit;

    }


    @Override
    public int compareTo(Payload other) {

        if (this.getMass() != other.getMass()) {

            return Double.compare(this.getMass(), other.getMass());

        }

        if (!this.getName().equals(other.getName())) {

            return this.getName().compareTo(other.getName());

        }

        if (!this.getType().equals(other.getType())) {

            return this.getType().compareTo(other.getType());

        }

        return this.getOrbit().compareTo(other.getOrbit());

    }


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Payload other) {

            return name.equals(other.name) &&
                    type.equals(other.type) &&
                    mass == other.mass &&
                    orbit.equals(other.orbit);

        }

        return false;

    }


    public String getName() {

        return name;

    }


    public double getMass() {

        return mass;

    }


    public String getOrbit() {

        return orbit;

    }


    public String getType() {

        return type;

    }


    public String toFile() {

        return String.format("%s,%s,%.1f,%s", name, type, mass, orbit);

    }


    @Override
    public String toString() {

        int items            = 4;
        DataMap[] map        = new DataMap[items];

        map[0]               = new DataMap("\n \tName:    \t", name);
        map[1]               = new DataMap("\n \tType:    \t", type);
        map[2]               = new DataMap("\n \tMass(kg):\t", Double.toString(mass));
        map[3]               = new DataMap("\n \tOrbit:   \t", orbit);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items; i++) {

            result.append(String.format("%s %s", map[i].name, map[i].value));

        }

        return result.toString();

    }

}