package player;

import enums.*;
import utils.Utils;

public abstract class Player {
    protected String name;
    protected Gender gender;
    protected Type type;
    protected Weapon weapon;
    protected Motivation motivation;
    protected GameDifficulty gameDifficulty;
    protected int life;
    protected int armor;

    public Player(String name, Gender gender, Type type, Weapon weapon, Motivation motivation, GameDifficulty gameDifficulty, int life, int armor) {
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.weapon = weapon;
        this.motivation = motivation;
        this.gameDifficulty = gameDifficulty;
        this.life = life;
        this.armor = armor;
    }

    public void damage(int damage, boolean printmessage, boolean ignorearmor){
        if(this.armor > 0 && !ignorearmor) {
            int totalarmor = this.armor - damage;
            if (totalarmor < 0) {
                this.setArmor(0);
                int totallife = this.life - Math.abs(totalarmor);
                if(totallife < 0){
                    this.setLife(0);
                }else{
                    this.setLife(totallife);
                }
            }else{
                this.setArmor(totalarmor);
            }
        }else{
            int totallife = this.life - damage;
            if(totallife < 0){
                this.setLife(0);
            }else{
                this.setLife(totallife);
            }
        }
        if(printmessage) {
            Utils.printText("(" + this.type.getName() + " - " + this.getName() + ") sofreu " + damage + " de dano | VIDA: " + this.getLife() + " | ARMADURA: " + this.getArmor());
        }
    }

    public void restore(int life, int armor){
        if(life > 0) {
            if ((this.life + life) > 100) {
                this.setLife(100);
                Utils.printText("(" + this.type.getName() + " - " + this.getName() + ") teve a vida restaurada em 100%!");
            } else {
                this.setLife(this.life + life);
                Utils.printText("(" + this.type.getName() + " - " + this.getName() + ") teve a vida restaurada para "+this.getLife()+"%!");
            }
        }
        if(armor > 0){
            this.setArmor(this.armor + armor);
            Utils.printText("(" + this.type.getName() + " - " + this.getName() + ") teve a armadura restaurada para "+this.getArmor()+"%!");
        }
    }

    public void battle(Hero hero, Monster monster){
        Utils.printText("## INICIANDO BATALHA ##");
        Utils.pause(1000);
        Utils.printText("("+hero.type.getName()+" - "+hero.getName()+") VIDA: "+hero.getLife()+ " | ARMADURA: "+hero.getArmor());
        Utils.pause(1000);
        Utils.printText("vs");
        Utils.pause(1000);
        Utils.printText("("+monster.type.getName()+" - "+monster.getName()+") VIDA: "+monster.getLife()+ " | ARMADURA: "+monster.getArmor());
        Utils.line();
        boolean gaming = true;
        while(gaming){
            Utils.line();
            int response = Utils.readInt("1 - Atacar\n2 - Fugir");
            switch (response) {
                case 1:
                    if(monster.getLife() > 0){
                        hero.atack(monster);
                        if(monster.getLife() > 0) {
                            Utils.pause(4000);
                            Utils.line();
                            monster.atack(hero);
                        }else{
                            gaming = false;
                            Utils.printText("++ O inimigo não é páreo para o seu heroísmo e jaz imóvel aos seus pés! ++");
                        }
                    }else{
                        gaming = false;
                        Utils.printText("++ O inimigo não é páreo para o seu heroísmo e jaz imóvel aos seus pés! ++");
                    }
                    break;
                case 2:
                    Utils.printText("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
                    System.exit(0);
                    break;
                default:
                    Utils.printText("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gender=" + gender.getName() +
                ", type=" + type.getName() +
                ", weapon=" + weapon.getName() +
                ", motivation=" + motivation.getName() +
                ", gameDifficulty=" + gameDifficulty.getName() +
                ", life=" + life +
                ", armor=" + armor +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Motivation getMotivation() {
        return motivation;
    }

    public void setMotivation(Motivation motivation) {
        this.motivation = motivation;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
