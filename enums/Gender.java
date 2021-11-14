package enums;

import java.util.stream.Stream;

public enum Gender {
    MALE(1, "MASCULINO"),
    FEMALE(2, "FEMININO");

    private Integer id;
    private String name;

    Gender(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Gender getById(Integer id) {
        return Stream.of(Gender.values()).filter(gender -> id.equals(gender.getId())).findFirst().orElseThrow();
    }
}
