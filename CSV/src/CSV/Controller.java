package CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    public static void intro() {

        System.out.println();
        System.out.println();
        System.out.println("================================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t   C L A S S I F I E D   A C C E S S ");
        System.out.println();
        System.out.println(" \t   M I S S I O N   D A T A   T E S T   P R O G R A M ");
        System.out.println();
        System.out.println(" \t    S E C U R E    S Y S T E M    I N I T I A T E D ");
        System.out.println();
        System.out.println("================================================================");
        System.out.println();
        System.out.println();


    }


    public static void main(String[] args) throws FileNotFoundException {

        String outputLocation  = "." + File.separator + "results";
        String inputLocation   = "." + File.separator + "data" + File.separator + "Misson_data.csv";

        intro();

        List<Mission> list    = new ArrayList<>();

        FileHandler.read(list, inputLocation);
        FileHandler.writePayloadData(list, outputLocation);
        FileHandler.writeCustomerData(list, "Peteros", outputLocation);

    }

}