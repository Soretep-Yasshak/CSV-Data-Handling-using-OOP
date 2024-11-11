package CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private static String csvFileHeader;


    public static void read(List<Mission> list, String inputLocation) throws FileNotFoundException {

        File file           = new File(inputLocation);
        Scanner scanner     = new Scanner(file);

        csvFileHeader       = scanner.nextLine();

        String line;
        Mission mission;

        while (scanner.hasNextLine()) {

            line            = scanner.nextLine();
            mission         = parseMission(line);

            list.add(mission);

        }

        scanner.close();

    }


    public static Mission parseMission(String line) throws IllegalArgumentException {

        String[] str         = line.split(",");
        String[] column      = new String[16];

        System.arraycopy(str, 0, column, 0, str.length);

        if (str.length < column.length) {

            for (int i = str.length; i < column.length; i++) {

                column[i]  = "";

            }

        }

        String flightNumber   = column[0];
        Date launchDate       = new Date(column[1]);
        Time launchTime       = new Time(column[2]);
        String launchSite     = column[3];
        String vehicleType    = column[4];
        double mass           = column[7].isEmpty() ? 0.0 : Double.parseDouble(column[7]);
        Payload payload       = new Payload(column[5], column[6], mass, column[8]);
        Customer customer     = new Customer(column[9], column[10], column[11]);
        String missionOutcome = column[12];
        String failureReason  = column[13];
        String landingType    = column[14];
        String landingOutcome = column[15];

        return new Builder()
                .setFlightNumber(flightNumber)
                .setLaunchTime(launchTime)
                .setLaunchDate(launchDate)
                .setLaunchSite(launchSite)
                .setVehicleType(vehicleType)
                .setPayload(payload)
                .setCustomer(customer)
                .setMissionOutcome(missionOutcome)
                .setFailureReason(failureReason)
                .setLandingType(landingType)
                .setLandingOutcome(landingOutcome)
                .build();

    }

    public static void writeCustomerData(List<Mission> list, String customer, String outputLocation)
            throws FileNotFoundException {

        String csvLocation                    = outputLocation + File.separator + customer + ".csv";
        String txtLocation                    = outputLocation + File.separator + customer + ".txt";
        File csvFile                          = new File(csvLocation);
        File txtFile                          = new File(txtLocation);

        try (PrintStream csvStream = new PrintStream(csvFile);
             PrintStream txtStream = new PrintStream(txtFile)) {

            if (csvFile.exists() && txtFile.exists()) {

                List<Mission> customerMissions = new ArrayList<>();
                SortUtil.sortByCustomer(list);

                for (int i = 0; i < list.size(); i++) {

                    Customer missionCustomer   = list.get(i).getCustomer();

                    if (missionCustomer != null && missionCustomer.getName().equals(customer)) {

                        customerMissions.add(list.get(i));

                    }

                }

                for (int i = 0; i < customerMissions.size(); i++) {

                    csvStream.println(customerMissions.get(i).toFile());
                    txtStream.println(customerMissions.get(i));

                }

            }

        }

    }


    public static void writePayloadData(List<Mission> list, String outputLocation) throws FileNotFoundException {

        String csvLocation         = outputLocation + File.separator + "ordered_payload.csv";
        String txtLocation         = outputLocation + File.separator + "ordered_payload.txt";
        File csvFile               = new File(csvLocation);
        File txtFile               = new File(txtLocation);

        try (PrintStream csvStream = new PrintStream(csvFile);
             PrintStream txtStream = new PrintStream(txtFile)) {

            if (csvFile.exists() && txtFile.exists()) {

                SortUtil.sortByPayload(list);
                csvStream.println(csvFileHeader);

                for (int i = 0; i < list.size(); i++) {

                    csvStream.println(list.get(i).toFile());
                    txtStream.println(list.get(i));

                }

            }

        }

    }

}