package enums;

import java.util.stream.Stream;

public enum GameDifficulty {
    EASY(1,"FÁCIL",100,80),
    NORMAL(2,"NORMAL",100,100),
    HARD(3,"DIFÍCIL",90,100);

    private int id;
    private String name;
    private int HeroPower;
    private int MonsterPower;

    GameDifficulty(int id, String name, int heroPower, int monsterPower) {
        this.id = id;
        this.name = name;
        HeroPower = heroPower;
        MonsterPower = monsterPower;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeroPower() {
        return HeroPower;
    }

    public int getMonsterPower() {
        return MonsterPower;
    }

    public static GameDifficulty getById(Integer id) {
        return Stream.of(GameDifficulty.values()).filter(gameDifficulty -> id.equals(gameDifficulty.getId())).findFirst().orElseThrow();
    }
}
