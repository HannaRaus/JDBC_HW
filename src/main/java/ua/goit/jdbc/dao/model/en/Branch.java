package ua.goit.jdbc.dao.model.en;

import java.util.Arrays;

public enum Branch {
    JAVA("Java"),
    CPLUS("C++"),
    CSHARP("C#");

    private final String name;

    Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Branch findByName(String name) {
        return Arrays.stream(Branch.values())
                .filter(branch -> branch.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Branch with name " + name + " doesn't exists"));
    }
}
