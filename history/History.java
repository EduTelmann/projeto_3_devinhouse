package history;

import enums.*;
import player.Hero;
import player.Monster;
import utils.Utils;

public class History {
    static Hero hero;

    public static Hero stage1(){
        Utils.printText("Seja bem vindo(a) à BATALHA FINAL!");
        Utils.pause(1000);
        GameDifficulty gameDifficulty = Utils.chooseGameDifficulty("Qual o nível de dificuldade?");
        String heroName = Utils.readString("Qual o seu nome?");
        Gender heroGender = Utils.chooseGender("Escolha o Gênero do seu personagem: ");
        Type heroType = Utils.chooseType("Escolha o Tipo do seu personagem");
        Weapon heroWeapon = Utils.chooseWeapon("Escolha a arma do seu personagem:", heroType);
        Utils.clear();
        Utils.pause(1000);
        Utils.printText("" +
                "A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n" +
                "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n" +
                "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");
        Utils.line();
        Utils.pause(5000);
        Utils.printText("" +
                "Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n" +
                "Você se lembra de todos os inimigos já derrotados para alcançar o covil\n" +
                "do líder maligno. Olha para seu equipamento de combate, já danificado e\n" +
                "desgastado depois de tantas lutas. Você está a um passo de encerrar para\n" +
                "sempre esse mal.");
        Utils.line();
        Utils.pause(5000);
        Utils.printText("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
        Utils.pause(100);
        Motivation heroMotivation = Utils.chooseMotivation("Muito bem caro "+heroType.getName()+"! Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:");
        return new Hero( heroName, heroGender, heroType, heroWeapon, heroMotivation, gameDifficulty, 100, 100);
    }

    public static void stage2(Motivation motivation){
        Utils.clear();
        if(Motivation.GLORY.equals(motivation)){
            Utils.printText("" +
                    "Você já consegue visualizar na sua mente o povo da cidade te recebendo\n" +
                    "de braços abertos, bardos criando canções sobre seus feitos heróicos, \n" +
                    "nobres te presenteando com jóias e diversas riquezas, taberneiros se \n" +
                    "recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente \n" +
                    "o amor do público, te louvando a cada passo que dá pelas ruas, depois de \n" +
                    "destruir o vilão que tanto assombrou a paz de todos. Porém, você sabe que \n" +
                    "ainda falta o último ato dessa história. Você se concentra na missão. \n" +
                    "A glória o aguarda, mas não antes da última batalha.");
        }
        if(Motivation.REVENGE.equals(motivation)){
            Utils.printText("" +
                    "Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar \n" +
                    "para lembrar, pois essas memórias estão sempre presentes, mesmo que de pano \n" +
                    "de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram. \n" +
                    "Elas são o combustível que te fizeram chegar até aqui. E você sabe que não \n" +
                    "irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua \n" +
                    "fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará \n" +
                    "por tanto mal causado na vida de tantos (e principalmente na sua).");
        }
        Utils.pause(5000);
        Utils.line();
        Utils.printText("" +
                "Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em \n" +
                "chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. \n" +
                "Seu foco está renovado. Você avança pelo portal.");
        Utils.pause(5000);
        Utils.line();
        Utils.printText("" +
                "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. \n" +
                "À sua frente, só é possível perceber que você se encontra em um corredor extenso. \n" +
                "Você só pode ir à frente, ou desistir.");
        Utils.pause(5000);
        Utils.line();
    }

    public static void stage3(Hero hero){
        Utils.clear();
        Utils.printText("" +
                "Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, \n" +
                "e pondera sobre como passar pela porta.");
        boolean continueoption = true;
        while(continueoption) {
            int response = Utils.readInt("1 - Andando cuidadosamente\n2 - Correndo\n3 - Saltando");
            switch (response) {
                case 1:
                    Utils.line();
                    Utils.printText("" +
                            "Você toma cuidado e vai caminhando vagarosamente em direção à luz. \n" +
                            "Quando você pisa exatamente embaixo da porta, você sente o chão ceder \n" +
                            "levemente, como se tivesse pisado em uma pedra solta. Você ouve um \n" +
                            "ruído de mecanismos se movimentando, e uma escotilha se abre no teto \n" +
                            "atrás de você, no corredor. Flechas voam da escotilha em sua direção, \n" +
                            "e você salta para dentro da sala, porém uma delas te acerta na perna.");
                    hero.damage(Utils.rollthedice(10), true, false);
                    continueoption = false;
                    break;
                case 2:
                    Utils.line();
                    Utils.printText("" +
                            "Você respira fundo e desata a correr em direção à sala. Quando passa \n" +
                            "pela porta, sente que pisou em uma pedra solta, mas não dá muita \n" +
                            "importância e segue para dentro da sala, olhando ao redor à procura \n" +
                            "de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo \n" +
                            "na pedra atrás de você, e quando se vira, vê várias flechas no chão. \n" +
                            "Espiando pela porta, você entende que pisou em uma armadilha que soltou \n" +
                            "flechas de uma escotilha aberta no teto, mas por sorte você entrou \n" +
                            "correndo e conseguiu escapar desse ataque surpresa.");
                    continueoption = false;
                    break;
                case 3:
                    Utils.line();
                    Utils.printText("" +
                            "Você se concentra e pula em direção à luz, saltando de antes \n" +
                            "da porta até o interior da sala.");
                    continueoption = false;
                    break;
                default:
                    Utils.printText("Opção inválida! Tente novamente.");
                    continueoption = true;
                    break;
            }
        }
    }

    public static void stage4(Hero hero){
        Utils.clear();
        Utils.printText("" +
                "Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. \n" +
                "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três \n" +
                "estão fechadas. A porta à sua frente é a maior das quatro, com inscrições em seu \n" +
                "entorno em uma língua que você não sabe ler, mas reconhece como sendo a língua \n" +
                "antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que ela está \n" +
                "trancada por duas fechaduras douradas, e você entende que precisará primeiro \n" +
                "derrotar o que estiver nas outras duas portas laterais, antes de conseguir \n" +
                "enfrentar o líder.");
        Utils.pause(5000);
        Utils.printText("Você se dirige para a porta à direita.");
        Utils.pause(5000);
        Utils.printText("" +
                "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. \n" +
                "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. \n" +
                "Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha \n" +
                "pendurados nas paredes e dispostos em armários e mesas. Você imagina que este seja \n" +
                "o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados \n" +
                "utilizam quando saem para espalhar o terror nas cidades e vilas da região.");
        Utils.pause(5000);
        Utils.printText("" +
                "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente \n" +
                "para olhar para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho \n" +
                "do seu destino, está um dos capitães do inimigo. Um orque horrendo, de armadura, \n" +
                "capacete e espada em punho, em posição de combate. Ele avança em sua direção.");
        String continuar = Utils.readString("Pressione ENTER para continuar.");
        Monster monster = new Monster( "Armeiro", Gender.MALE, Type.ORCH, Weapon.SWORD, Motivation.GLORY, hero.getGameDifficulty(), 100, 100);
        hero.battle(hero,monster);
        Utils.pause(2000);
        Utils.line();
        Utils.pause(2000);
        Utils.printText("" +
                "Após derrotar o "+monster.getName()+", você percebe que seus equipamentos estão \n" +
                "muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes \n" +
                "e em ótimo estado.");
        boolean continueoption = true;
        while(continueoption) {
            int response = Utils.readInt("1 - Pegar e equipar a nova armadura encotrada\n2 - Não pegar a nova armadura\n");
            switch (response) {
                case 1:
                    Utils.line();
                    Utils.printText("" +
                            "Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, \n" +
                            "que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, \n" +
                            "você se sente mais protegido para os desafios à sua frente.");
                    hero.restore(0,90);
                    continueoption = false;
                    break;
                case 2:
                    Utils.line();
                    Utils.printText("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
                    continueoption = false;
                    break;
                default:
                    Utils.printText("Opção inválida! Tente novamente.");
                    continueoption = true;
                    break;
            }
        }
        Utils.pause(3000);
        Utils.printText("" +
                "Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das \n" +
                "fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa \n" +
                "que leva presa ao cinto.\n");
    }

    public static void stage5(Hero hero) {
        Utils.clear();
        Utils.printText("" +
                "Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, \n" +
                "tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais \n" +
                "força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você \n" +
                "se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem \n" +
                "vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e \n" +
                "você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, \n" +
                "criando poções utilizadas pelos soldados para aterrorizar a região.");
        Utils.pause(5000);
        Utils.printText("" +
                "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. \n" +
                "Um orque horrendo, de armadura, cajado em punho, em posição de combate. \n" +
                "Ele avança em sua direção.");
        String continuar = Utils.readString("Pressione ENTER para continuar.");
        Monster monster = new Monster( "Alquimista", Gender.MALE, Type.ORCH, Weapon.STAFF, Motivation.GLORY, hero.getGameDifficulty(), 100, 100);
        hero.battle(hero,monster);
        Utils.pause(2000);
        Utils.line();
        Utils.pause(2000);
        Utils.printText("" +
                "Após derrotar o "+monster.getName()+", você olha em volta, tentando reconhecer alguma \n" +
                "poção do estoque do inimigo. Em uma mesa, você reconhece uma pequena garrafa \n" +
                "de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se \n" +
                "deve beber um gole.");
        boolean continueoption = true;
        while(continueoption) {
            int response = Utils.readInt("1 - BEBER a poção\n2 - NÃO BEBER a poção\n");
            switch (response) {
                case 1:
                    Utils.line();
                    Utils.printText("" +
                            "Você se sente revigorado para seguir adiante!");
                    hero.restore(100,0);
                    continueoption = false;
                    break;
                case 2:
                    Utils.line();
                    Utils.printText("Você fica receoso de beber algo produzido pelo inimigo");
                    continueoption = false;
                    break;
                default:
                    Utils.printText("Opção inválida! Tente novamente.");
                    continueoption = true;
                    break;
            }
        }
        Utils.pause(3000);

        Utils.printText("" +
                "Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que \n" +
                "aquela chave abre a outra fechadura da porta do líder inimigo. Você pega a \n" +
                "chave e guarda na pequena bolsa que leva presa ao cinto.");
    }

    public static void stage6(Hero hero) {
        Utils.clear();
        Utils.printText("" +
                "De volta à sala das portas, você se dirige à porta final. Coloca as chaves \n" +
                "nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a \n" +
                "sua vida passam pela sua mente, e você percebe que está muito próximo do \n" +
                "seu objetivo final. Segura sua arma com mais firmeza, foca no combate que \n" +
                "você sabe que irá se seguir, e adentra a porta.");
        Utils.pause(3000);
        Utils.printText("" +
                "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas \n" +
                "fogueiras de cada lado, e prisioneiros acorrentados às paredes.");
        Utils.pause(3000);
        Utils.printText("Ele percebe sua chegada e se levanta com um salto, apanhando \n" +
                "seu machado de guerra de lâmina dupla.");
        boolean waiting = true;
        while(waiting){
            int response = Utils.readInt("1 - INICIAR BATALHA!\n2 - ESPERAR UM POUCO\n");
            switch (response) {
                case 1:
                    Utils.line();
                    Monster monster = new Monster( "O LÍDER", Gender.MALE, Type.ORCH, Weapon.AXE, Motivation.GLORY, hero.getGameDifficulty(), 100, 100);
                    hero.battle(hero,monster);
                    waiting = false;
                    break;
                case 2:
                    Utils.printText("Esperando por 5 segundos...");
                    Utils.pause(5000);
                    waiting = true;
                    break;
                default:
                    Utils.printText("Opção inválida! Tente novamente.");
                    waiting = true;
                    break;
            }
        }
        Utils.printText("*******************************");
        Utils.printText("******* VOCÊ CONSEGUIU! *******");
        Utils.printText("*******************************");
        Utils.pause(5000);
        if(hero.getMotivation().equals(Motivation.GLORY)){
            Utils.printText("" +
                    "O êxtase em que você se encontra não cabe dentro de si. \n" +
                    "Você se ajoelha e grita de alegria. A glória o aguarda, \n" +
                    "você a conquistou.");
        }
        if(hero.getMotivation().equals(Motivation.REVENGE)){
            Utils.printText("" +
                    "Você obteve sua vingança. Você se ajoelha e cai no choro, \n" +
                    "invadido por uma sensação de alívio e felicidade. Você se vingou, \n" +
                    "tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
        }
        Utils.pause(5000);
        Utils.printText("" +
                "Você se levanta, olha para os prisioneiros, vai de um em um e os \n" +
                "liberta, e todos vocês saem em direção à noite, retornando à cidade. \n" +
                "Seu dever está cumprido.");
        Utils.pause(5000);
        Utils.printText("=======");
        Utils.printText("= FIM =");
        Utils.printText("=======");
    }


}
