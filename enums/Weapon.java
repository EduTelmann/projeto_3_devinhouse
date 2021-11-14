package enums;

import java.util.stream.Stream;

public enum Weapon {
    BOW_ARROW(1,"ARCO E FLECHA",10),
    SPEAR(2,"LANÇA",10),
    STAFF(3,"CAJADO",10),
    SWORD(4,"ESPADA",10),
    WAND(5,"VARINHA",10),
    AXE(6,"MACHADO DE  GUERRA DE LÂMINA DUPLA", 10);

    private int id;
    private String name;
    private int power;

    Weapon(int id, String name, int power) {
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

    public static Weapon getById(Integer id) {
        return Stream.of(Weapon.values()).filter(weapon -> id.equals(weapon.getId())).findFirst().orElseThrow();
    }
}
