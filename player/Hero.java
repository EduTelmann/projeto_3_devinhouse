package player;

import enums.*;
import utils.Utils;

public class Hero extends Player{
    public Hero(String name, Gender gender, Type type, Weapon weapon, Motivation motivation, GameDifficulty gameDifficulty, int life, int armor) {
        super(name,gender,type,weapon,motivation,gameDifficulty,life,armor);
    }

    public int getFinalPower(){
        int power = this.getType().getPower() * this.getGameDifficulty().getHeroPower()/100;
        return power;
    }

    public void atack(Monster monster){
        int dice = Utils.rollthedice(20);
        int totaldamage;
        switch (dice){
            case 1:
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") tirou 1 e errou o ataque!");
                Utils.printText("("+monster.getType().getName()+" - "+monster.getName()+") não sofreu nenhum dano");
                break;
            case 20:
                totaldamage = getFinalPower() + getWeapon().getPower() + dice;
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") acertou um ataque CRÍTICO com seu/sua "+this.getWeapon().getName()+" e causou "+totaldamage+" de dano ao inimigo!");
                monster.damage(totaldamage,true,true);
                break;
            default:
                totaldamage = getFinalPower() + getWeapon().getPower() + dice;
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") atacou com seu/sua "+this.getWeapon().getName()+" e causou "+totaldamage+" de dano ao inimigo!");
                monster.damage(totaldamage,true,false);
                break;
        }
    }

}
