import enums.Type;
import history.History;
import player.Hero;
import player.Monster;
import player.Player;
import utils.Utils;

public class Main {
    public static void main(String[] args){
        String continuar;
        Hero hero = History.stage1();
        continuar = Utils.readString("Pressione ENTER para continuar.");
        History.stage2(hero.getMotivation());
        if(Utils.continueGame()){
            continuar = Utils.readString("Pressione ENTER para continuar.");
            History.stage3(hero);
        }
        continuar = Utils.readString("Pressione ENTER para continuar.");
        History.stage4(hero);
        continuar = Utils.readString("Pressione ENTER para continuar.");
        History.stage5(hero);
        continuar = Utils.readString("Pressione ENTER para continuar.");
        History.stage6(hero);
        //Hero hero = new Hero( "Eduardo", Gender.MALE, Type.WIZARD, Weapon.STAFF, Motivation.GLORY, GameDifficulty.HARD, 100, 100);
        //Monster monster = new Monster( "Armeiro", Gender.MALE, Type.ORCH, Weapon.SWORD, Motivation.GLORY, hero.getGameDifficulty(), 100, 100);
        //System.out.println(hero.toString());
        //System.out.println(monster.toString());
    }
}
