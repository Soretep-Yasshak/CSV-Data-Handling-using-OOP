package CSV;

import java.util.List;

public class SortUtil {


    public static void sortByCustomer(List<Mission> list) {

        Customer first;
        Customer second;
        Mission temp;

        for (int i = 0; i < list.size(); i++) {

            for (int j = 1; j < list.size() - i; j++) {

                first         = list.get(j - 1).getCustomer();
                second        = list.get(j).getCustomer();

                if (second.compareTo(first) < 0) {

                    temp      = list.get(j);

                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);

                }

            }

        }

    }


    public static void sortByPayload(List<Mission> list) {

        Payload first;
        Payload second;
        Mission temp;

        for (int i = 0; i < list.size(); i++) {

            for (int j = 1; j < list.size() - i; j++) {

                first         = list.get(j - 1).getPayload();
                second        = list.get(j).getPayload();

                if (second.compareTo(first) < 0) {

                    temp     = list.get(j);

                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);

                }

            }

        }

    }

}