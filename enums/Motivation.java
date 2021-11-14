package enums;

import java.util.stream.Stream;

public enum Motivation {
    GLORY(1,"GLÓRIA"),
    REVENGE(2,"VINGANÇA");

    private int id;
    private String name;

    Motivation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Motivation getById(Integer id) {
        return Stream.of(Motivation.values()).filter(motivation -> id.equals(motivation.getId())).findFirst().orElseThrow();
    }
}
