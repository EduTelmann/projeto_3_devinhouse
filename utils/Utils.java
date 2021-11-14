package utils;

import enums.*;

import java.util.*;
import java.util.stream.Stream;

public class Utils {

    private Utils(){}

    public static int rollthedice(int limit){
        Random random = new Random();
        int result = 1 + random.nextInt(limit);
        printText("- - - ");
        printText("| "+result+" | ");
        printText("- - - ");
        return result;
    }

    private static Scanner getScanner(){
        return new Scanner(System.in);
    }

    public static void printText(String text){
        System.out.println(text);
    }

    public static String readString(String message){
        Scanner intext = getScanner();
        printText(message);
        return intext.nextLine();
    }

    public static int readInt(String message) {
        Scanner intext = getScanner();
        printText(message);
        return intext.nextInt();
    }

    public static GameDifficulty chooseGameDifficulty(String message){
        Scanner intext = getScanner();
        printText(message);
        Stream.of(GameDifficulty.values()).forEach(gameDifficulty -> printText(gameDifficulty.getId()+" - "+gameDifficulty.getName()));
        int gameDifficulty = intext.nextInt();
        try {
            return GameDifficulty.getById(gameDifficulty);
        } catch(Exception e) {
            printText("Opção inválida");
            return chooseGameDifficulty("Tente escolher o nível de dificuldade novamente: ");
        }
    }
    public static Gender chooseGender(String message){
        Scanner intext = getScanner();
        printText(message);
        Stream.of(Gender.values()).forEach(gender -> printText(gender.getId()+" - "+gender.getName()));
        int gender = intext.nextInt();
        try {
            return Gender.getById(gender);
        } catch(Exception e) {
            printText("Opção inválida");
            return chooseGender("Tente escolher o Gênero do seu personagem novamente: ");
        }
    }
    public static Type chooseType(String message){
        Scanner intext = getScanner();
        printText(message);
        Stream.of(Type.values()).forEach(type -> printText(type.getId()+" - "+type.getName()));
        int type = intext.nextInt();
        try {
            return Type.getById(type);
        } catch(Exception e) {
            printText("Opção inválida");
            return chooseType("Tente escolher o tipo do seu personagem novamente: ");
        }
    }
    public static Weapon chooseWeapon(String message, Type classtype){
        Scanner intext = getScanner();
        printText(message);
        List<Weapon> availableWeapons = getAvailableWeapons(classtype);
        int length = availableWeapons.size();
        HashMap<Integer, Weapon> collect = availableWeapons
                .stream()
                .collect(HashMap<Integer, Weapon>::new,
                        (map, streamValue) -> map.put(map.size(), streamValue),
                        (map, map2) -> {});
        collect.forEach((index, weapon) -> printText(index+1 + " - " + weapon.getName()));
        int weapon = intext.nextInt();
        if(weapon <= length && weapon > 0){
            return collect.get(weapon-1);
        }else{
            printText("Opção inválida");
            return chooseWeapon("Tente escolher a sua arma novamente novamente: ", classtype);
        }
    }
    public static Motivation chooseMotivation(String message){
        Scanner intext = getScanner();
        printText(message);
        Stream.of(Motivation.values()).forEach(motivation -> printText(motivation.getId()+" - "+motivation.getName()));
        int motivation = intext.nextInt();
        try {
            return Motivation.getById(motivation);
        } catch(Exception e) {
            printText("Opção inválida");
            return chooseMotivation("Tente escolher a sua motivação novamente: ");
        }
    }

    public static List<Weapon> getAvailableWeapons(Type classtype){
        return switch (classtype){
            case ELF -> Arrays.asList(Weapon.BOW_ARROW, Weapon.SPEAR);
            case WIZARD -> Arrays.asList(Weapon.STAFF, Weapon.WAND);
            case WARRIOR -> Arrays.asList(Weapon.SWORD, Weapon.SPEAR);
            case ORCH -> Arrays.asList(Weapon.SWORD);
        };
    }

    public static Boolean continueGame(){
        int response = readInt("1 - Seguir\n2 - Desistir");
        switch (response) {
            case 1:
                printText("" +
                        "Você caminha, atento a todos os seus sentidos, por vários metros, \n" +
                        "até visualizar a frente uma fonte de luz, que você imagina ser a \n" +
                        "chama de uma tocha, vindo de dentro de uma porta aberta.");
                break;
            case 2:
                printText("" +
                        "O medo invade o seu coração e você sente que ainda não está à \n" +
                        "altura do desafio. Você se volta para a noite lá fora e corre \n" +
                        "em direção à segurança.");
                System.exit(0);
                break;
            default:
                printText("Opção inválida! Tente novamente.");
                line();
                continueGame();
                break;
        }
        return true;
    }

    public static void pause(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void line() {
        for (int i = 0; i < 40; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
