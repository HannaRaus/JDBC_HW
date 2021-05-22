package ua.goit.jdbc.dao.model.en;

import java.util.Arrays;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Gender findByName(String name) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Gender with name " + name + " doesn't exists"));
    }
}
