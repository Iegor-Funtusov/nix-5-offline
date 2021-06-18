package ua.com.alevel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    public void oneObject() {
        User user = new User();
        user.setFirstName("qq");
        user.setLastName("ww");
        user.setFullName("qq ww");

        System.out.println("user = " + user);

        Gson gson = new Gson();
        String u = gson.toJson(user);
        System.out.println("u = " + u);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"));
            BufferedReader reader = new BufferedReader(new FileReader("user.json"));
            writer.append(u);
            writer.flush();
            u = reader.readLine();
            System.out.println("u = " + u);
            user = gson.fromJson(u, User.class);
            System.out.println("user = " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void arrayObjects() {
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

        Gson gson = new Gson();
        String u = gson.toJson(users);

        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("users.json"));
            BufferedReader reader = new BufferedReader(new FileReader("users.json"));
//            writer.append(u);
//            writer.flush();
            u = reader.readLine();
            System.out.println("u = " + u);

            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(u, new TypeReference<List<User>>() { });
            System.out.println("users = " + users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void someJson() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("some.json"));
            String position;
            StringBuilder stringBuilder = new StringBuilder();
            while ((position = reader.readLine()) != null) {
                System.out.println("position = " + position);
                stringBuilder.append(position);
            }
            System.out.println("stringBuilder = " + stringBuilder);

            JsonElement jsonElement = new Gson().fromJson(stringBuilder.toString(), JsonObject.class);
            if (jsonElement.isJsonObject()) {
                System.out.println("jsonElement = " + jsonElement);
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                System.out.println("asJsonObject = " + asJsonObject);
                JsonObject data = asJsonObject.get("data").getAsJsonObject();
                System.out.println("data = " + data);
                int id = data.get("id").getAsInt();
                System.out.println("id = " + id);
                JsonArray items = data.get("items").getAsJsonArray();
                System.out.println("items = " + items);
                for (JsonElement item : items) {
                    JsonObject i = item.getAsJsonObject();
                    String test = i.get("test").getAsString();
                    System.out.println("test = " + test);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
