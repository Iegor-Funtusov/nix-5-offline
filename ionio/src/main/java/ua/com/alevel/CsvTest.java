package ua.com.alevel;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTest {

    public void test() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setFirstName("qq");
        user.setLastName("ww");
        user.setFullName("qq ww");
        users.add(user);
        user = new User();
        user.setFirstName("ee");
        user.setLastName("rr");
        user.setFullName("ee rr");
        users.add(user);
        user = new User();
        user.setFirstName("tt");
        user.setLastName("yy");
        user.setFullName("tt yy");
        users.add(user);

        List<String[]> csvData = new ArrayList<>();
        String[] header = new String[3];
        header[0] = "firstName";
        header[1] = "lastName";
        header[2] = "fullName";
        csvData.add(header);

        for (User user1 : users) {
            String[] u = new String[3];
            u[0] = user1.getFirstName();
            u[1] = user1.getLastName();
            u[2] = user1.getFullName();
            csvData.add(u);
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter("users.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(CSVReader reader = new CSVReader(new FileReader("users.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                for (String[] string : strings) {
                    for (String s : string) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                }

                users = strings
                        .stream()
                        .skip(1)
                        .map(s -> {
                            User u = new User();
                            u.setFirstName(s[0]);
                            u.setLastName(s[1]);
                            u.setFullName(s[2]);
                            return u;
                        })
                        .collect(Collectors.toList());

                System.out.println("users = " + users);

            } catch (CsvException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
