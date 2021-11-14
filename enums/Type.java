package enums;

import java.util.stream.Stream;

public enum Type {
    ELF(1, "ELFO", 30),
    WIZARD(2,"BRUXO",30),
    WARRIOR(3,"GUERREIRO",30),
    ORCH(4,"ORQUE",10);

    private int id;
    private String name;
    private int power;

    Type(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public static Type getById(Integer id) {
        return Stream.of(Type.values()).filter(type -> id.equals(type.getId())).findFirst().orElseThrow();
    }
}
