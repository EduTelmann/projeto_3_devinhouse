package player;

import enums.*;
import utils.Utils;

public class Monster extends Player{
    public Monster(String name, Gender gender, Type type, Weapon weapon, Motivation motivation, GameDifficulty gameDifficulty, int life, int armor) {
        super(name,gender,type,weapon,motivation,gameDifficulty,life,armor);
    }

    public int getFinalPower(){
        int power = this.getType().getPower() * this.getGameDifficulty().getMonsterPower()/100;
        return power;
    }

    public void atack(Hero hero){
        int dice = Utils.rollthedice(20);
        int totaldamage;
        switch (dice){
            case 1:
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") tirou 1 e errou o ataque!");
                Utils.printText("("+hero.getType().getName()+" - "+hero.getName()+") não sofreu nenhum dano");
                break;
            case 20:
                totaldamage = getFinalPower() + getWeapon().getPower() + dice;
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") acertou um ataque CRÍTICO com seu/sua "+this.getWeapon().getName()+" e causou "+totaldamage+" de dano a você!");
                hero.damage(totaldamage,true,true);
                break;
            default:
                totaldamage = getFinalPower() + getWeapon().getPower() + dice;
                Utils.printText("("+this.getType().getName()+" - "+this.getName()+") atacou com seu/sua "+this.getWeapon().getName()+" e causou "+totaldamage+" de dano a você!");
                hero.damage(totaldamage,true,false);
                break;
        }
        if(hero.getLife() <= 0){
            Utils.line();
            Utils.printText("++++++++++++++++++++++++++++++++++++++++++++++++++");
            Utils.printText("Você não estava preparado para a força do inimigo.");
            Utils.printText("++++++++++++++++++++++++++++++++++++++++++++++++++");
            if(hero.getMotivation().equals(Motivation.GLORY)){
                Utils.printText("A glória que buscavas não será sua, e a cidade aguarda \n" +
                        "por seu próximo herói.");
            }
            if(hero.getMotivation().equals(Motivation.REVENGE)){
                Utils.printText("Não foi possível concluir sua vingança, e agora resta \n" +
                        "saber se alguém se vingará por você.");
            }
            Utils.printText("=======");
            Utils.printText("= FIM =");
            Utils.printText("=======");
            System.exit(0);
        }
    }
}
