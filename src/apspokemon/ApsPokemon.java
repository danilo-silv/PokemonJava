package apspokemon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Danilo| RA: 21055361| Curso: Sistemas de informações| Materia: POO
 *APS PROGRAMAÇÃO ORIENTTADA A OBJETOS
 *vantagem (Elétrico  Voador  Grama  Água  Fogo) 
 *desvantagem (Fogo  Água  Grama  Voador  Elétrico)
 */
public class ApsPokemon {

    //------------leituraDeString---------------------
    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    //------------random---------------------
    public static int generateRandomNumber() {
        return (int) (Math.random() * 7);//SORTEIA NUMEROS DE 0 A 7
    }

    //------------random---------------------
    public static void getError() {
        System.err.println("Servidor fora do AR");
        System.err.println("Tente novamente em alguns instantes");
    }

    //------------clearOutput---------------------
    public static void clearOutput(int sleep) {
        try {
            sleepThread(sleep);
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException error) {
            getError();
        }
    }

    //------------pausaThread--------------------- 
    public static void sleepThread(int sllep) {
        try {
            if (sllep > 8000) {
                System.out.println("Aguardando a verificação dos pokemons!!!");
            }
            Thread.sleep(sllep);
        } catch (InterruptedException err) {
            getError();
        }
    }

    //-----------miniMenu---------------------------
    public static void miniMenu() {
        System.out.println("----------------------------------");
        System.out.println("Novo opnente, oque deseja fazer?  |");
        System.out.println("1- Batalhar                       |");
        System.out.println("2- Ver meus Pokémons              |");
        System.out.println("3- Alterar ordens dos pokemons    |");
        System.out.println("----------------------------------");
        String optionUser = inputString();
        clearOutput(500);
        do {
            if (!((optionUser.equals("1")) || (optionUser.equals("2")) || (optionUser.equals("3")))) {
                clearOutput(1000);
                System.err.println("Informe os valores corretos!!");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("|1-Jogar |    |2- Ver meus Pokémons |    |3- Alterar as ordens dos pokemons|\nDigite novamente:");
                optionUser = inputString();
            }
            switch (optionUser) {
                case "1":
                    clearOutput(100);
                    break;
                case "2":
                    showPokemon();
                    miniMenu();
                    break;
                case "3":
                    exchangePokemon(listTreinador.get(0).getPokemons());
                    miniMenu();
                    break;
            }

        } while (!((optionUser.equals("1")) || (optionUser.equals("2")) || (optionUser.equals("3"))));
    }

    //------------mensagemInicio---------------------
    public static void messageStart() {
        System.out.println("---------------------------------------");
        System.out.println("|            JOGO POKÉMON             |");
        System.out.println("|           SEJA BEM VINDO            |");
        System.out.println("---------------------------------------");
    }

    //------------status---------------------
    public static void messageStatus() {
        System.out.println("---------------------------------------------------");
        System.out.println("|     STATUS DO TREINADOR E SEUS POKéMONS         |");
        System.out.println("---------------------------------------------------");
    }

    //------------menu---------------------
    public static void messageGameMenu() {
        System.out.println("-----------------------------------");
        System.out.println("Ok, Vamos lá.. O que deseja fazer |");
        System.out.println("1- Batalhar                       |");
        System.out.println("2- Ver meus Pokémons              |");
        System.out.println("3- Alterar ordens dos Pokémons    |");
        System.out.println("4- Sair                           |");
        System.out.println("----------------------------------");
        Treinador userTrainer = listTreinador.get(0);
        validationOptionMenu(userTrainer);
    }

    //------------validaOpçãoUsuario---------------------
    public static void validationOptionMenu(Treinador userTrainer) {
        String optionUser = inputString();
        try {
            clearOutput(500);
            do {
                if (!((optionUser.equals("1")) || (optionUser.equals("2")) || (optionUser.equals("3")) || (optionUser.equals("4")))) {
                    clearOutput(1000);
                    System.err.println("Informe os valores corretos!!");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("|1-Jogar |    |2- Ver meus Pokémons |    |3- Alterar as ordens dos pokemons|   |4- Sair |\nDigite novamente:");
                    optionUser = inputString();
                }
                switch (optionUser) {
                    case "1":
                        startGame(userTrainer);
                        break;
                    case "2":
                        showPokemon();
                        messageGameMenu();
                        break;
                    case "3":
                        exchangePokemon(listTreinador.get(0).getPokemons());
                        messageGameMenu();
                        break;
                    case "4":
                        System.out.println("Sair");
                        System.exit(0);
                }

            } while (!((optionUser.equals("1")) || (optionUser.equals("2")) || (optionUser.equals("3")) || (optionUser.equals("4"))));
        } catch (Exception error) {
            getError();
        }

    }

    //------------trocaOrdemPokemon---------------------
    public static void exchangePokemon(Pokemon[] pokemon) {
        clearOutput(1000);
        Pokemon aux = pokemon[0];
        pokemon[0] = pokemon[1];
        pokemon[1] = aux;
        System.out.println("Ordem alterada !!");
        clearOutput(1000);
    }

    //------------mostraPokemonUsuario---------------------
    public static void showPokemon() {
        System.out.println("Pokémons: ");
        for (Pokemon pokemon : listTreinador.get(0).getPokemons()) {
            System.out.println(pokemon);
        }
        clearOutput(10000);
    }

    //------------statusPartida---------------------
    public static void showPokemonsDefeated(Pokemon pokemonUser, Treinador userTrainer, Pokemon pokemonOponente, Treinador treinadorOponente) {
        if (pokemonUser.getVidaAtual() <= 0) {
            System.out.println("Seu pokémon Foi derrotado");
            String optionUser;
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("Deseja ver o pokémon derrotado?[sim/nao]");
                optionUser = input.nextLine();
                if (optionUser.equalsIgnoreCase("sim")) {
                    System.out.println(pokemonUser);
                    clearOutput(2000);
                } else if (optionUser.equalsIgnoreCase("nao") || optionUser.equalsIgnoreCase("não")) {
                    clearOutput(500);
                    break;
                } else {
                    mensagemErr();
                }
            } while (!optionUser.equalsIgnoreCase("sim"));
        }

        if (pokemonOponente.getVidaAtual() <= 0) {
            System.out.println("- -  - -   - -   - -  - -  - -  - -  - -  - -  - - - - ");
            System.out.println("    Parabéns você derrotou o pokemon :   " + pokemonOponente.getNomePokemon());
            System.out.println("- -  - -   - -   - -  - -  - -  - -  - -  - -  - - - - ");
            clearOutput(4000);
        }
        if (treinadorOponente.isIsDerrotado() == false) {
            if (pokemonUser.getVidaAtual() > 0) {
                System.out.println(userTrainer.getNomeJogador() + " Analise seu pokémon:");
                System.out.println(pokemonUser);
                clearOutput(5000);
            }
        }
    }

    //------------mensagemErro---------------------
    public static void mensagemErr() {
        System.err.println("Informe os valores corretos!!");
        System.out.println("-----------------------------");
        System.out.println("informe sim ou não");
    }

    //------------checaStatusOponente---------------------
    public static boolean coachStatusCheck(Treinador treinadorOponente) {
        boolean status = false;
        System.out.println("Checando Status !!");
        clearOutput(100);
        if (treinadorOponente.getPokemons()[0].getVidaAtual() <= 0 && treinadorOponente.getPokemons()[1].getVidaAtual() <= 0) {
            Treinador treiandorDerrotado = treinadorOponente.statusTreiandor(treinadorOponente);

            if (treiandorDerrotado.isIsDerrotado() != false) {
                status = true;
                for (Pokemon pokemonsUser : listTreinador.get(0).getPokemons()) {
                    pokemonsUser.setVidaAtual(0f);
                }

                System.out.println("- -  - -   - -   - -  - -  - -  - -  - -  - -  - - - - ");
                System.out.println("  Parabéns você derrotou o Treinador : " + treinadorOponente.getNomeJogador());
                System.out.println("- -  - -   - -   - -  - -  - -  - -  - -  - -  - - - - ");
                if (treinadorOponente.getStatus() == StatusTreinador.TREINADOR_COMUM) {
                    String optionUser;
                    do {
                        Scanner input = new Scanner(System.in);
                        System.out.println("Deseja ir para a proxima batalha?[sim/nao]");
                        optionUser = input.nextLine();
                        if (optionUser.equalsIgnoreCase("sim")) {
                            System.out.println("Boa sorte!!");
                            clearOutput(800);
                        } else if (optionUser.equalsIgnoreCase("nao") || optionUser.equalsIgnoreCase("não")) {
                            messageGameMenu();
                        } else {
                            mensagemErr();
                        }
                    } while (!optionUser.equalsIgnoreCase("sim"));
                }
            }
        }
        return status;
    }

    //------------ataqueGolpes---------------------
    public static Pokemon batalha(Treinador treinador, Pokemon pokemonAtacante, Golpe golpeAtaque, Pokemon pokemonAtacado) {
        System.out.println("Treinador Atacante: " + treinador.getNomeJogador());
        System.out.println("Nome Pokémon atacante: " + pokemonAtacante.getNomePokemon());
        System.out.println("Nome do Golpe: " + golpeAtaque.getNomeGolpe());
        System.out.println("- -  - -   - -   - -  - -  - -  - -  - -  - -  - - - - \n");
        Pokemon pokemonAttacked = Pokemon.atacar(pokemonAtacante.getAtaque(), golpeAtaque, pokemonAtacado);
        System.out.println("---------------------------------------");
        System.out.println("          POKéMON ATACADO          ");
        System.out.println(pokemonAtacado.stringVidaPokemon());
        System.out.println("---------------------------------------");
        return pokemonAttacked;
    }

    //------------confrontoPokemon---------------------
    public static void startGame(Treinador treinadorUser) {
        int verificador = 0;
        boolean status = false;
        Treinador treinadorOponente;
        Treinador userTrainer = treinadorUser;
        do {
            if (userTrainer.isIsDerrotado() != true) {
                int interador = 0;
                treinadorOponente = getTreinadorOponente(treinadorUser);

                if (treinadorOponente == null) {
                    System.out.println("Parabéns, você é o novo LIDER!");
                    System.exit(0);
                }
                if (treinadorOponente.getStatus() == StatusTreinador.TREINADOR_LIDER) {
                    System.out.println("Você está enfrantando o LIDER DO GINÁSIO : " + treinadorOponente.getNomeJogador());
                    System.out.println("Utilize com sabedoria os golpes");
                    clearOutput(3000);
                }
                if (verificador == 1) {
                    miniMenu();
                }
                verificador = 1;
                System.out.println("TREIANDOR OPONENTE :\n" + treinadorOponente);
                clearOutput(9000);
                for (Pokemon pokemonUser : userTrainer.getPokemons()) {
                    do {
                        for (int i = 0; i < treinadorOponente.getPokemons().length; i++) {
                            System.out.println("--------------BATALHA ENTRE POKEMONS------------------------");
                            System.out.println("Treinador " + userTrainer.getNomeJogador() + " Pokémon: " + pokemonUser.getNomePokemon());
                            System.out.println("                          X                                  ");
                            System.out.println("Treinador " + treinadorOponente.getNomeJogador() + " Pokémon: " + treinadorOponente.getPokemons()[interador].getNomePokemon());
                            System.out.println("------------------------------------------------------------");
                            clearOutput(8000);

                            if (pokemonUser.getVelocidade() >= treinadorOponente.getPokemons()[interador].getVelocidade()) {
                                System.out.println("Treinador: " + userTrainer.getNomeJogador() + " você vai atacar!!!");
                                clearOutput(2500);
                                Golpe golpeUserAtacante = choiceGolpe(pokemonUser);
                                Pokemon pokemonOponente = batalha(userTrainer, pokemonUser, golpeUserAtacante, treinadorOponente.getPokemons()[interador]);
                                clearOutput(8000);
                                if (pokemonOponente.getVidaAtual() > 0) {
                                    System.out.println("Treinador: " + treinadorOponente.getNomeJogador() + " vai atacar!!!");
                                    clearOutput(2500);
                                    Golpe golpeOponenteAtacante = choiceGolpeOponente(pokemonOponente);
                                    batalha(treinadorOponente, pokemonOponente, golpeOponenteAtacante, pokemonUser);
                                    clearOutput(8000);
                                }
                                showPokemonsDefeated(pokemonUser, userTrainer, treinadorOponente.getPokemons()[interador], treinadorOponente);
                            } else {
                                System.out.println("Treinador: " + treinadorOponente.getNomeJogador() + " vai atacar!!!");
                                clearOutput(2500);
                                Golpe golpeOponenteAtacante = choiceGolpeOponente(treinadorOponente.getPokemons()[interador]);
                                Pokemon pokemonUserAtacado = batalha(treinadorOponente, treinadorOponente.getPokemons()[interador], golpeOponenteAtacante, pokemonUser);
                                clearOutput(8000);
                                if (pokemonUserAtacado.getVidaAtual() > 0) {
                                    System.out.println("Treinador: " + userTrainer.getNomeJogador() + " você vai atacar!!!");
                                    clearOutput(4000);
                                    Golpe golpeUserAtacante = choiceGolpe(pokemonUserAtacado);
                                    batalha(userTrainer, pokemonUser, golpeUserAtacante, treinadorOponente.getPokemons()[interador]);
                                    clearOutput(8000);
                                }
                                showPokemonsDefeated(pokemonUser, userTrainer, treinadorOponente.getPokemons()[interador], treinadorOponente);
                            }

                            if (treinadorOponente.getPokemons()[interador].getVidaAtual() <= 0) {
                                interador = interador + 1;
                                status = coachStatusCheck(treinadorOponente);
                            }
                            if (pokemonUser.getVidaAtual() <= 0) {
                                break;
                            }
                        }

                        if (status == true) {
                            break;
                        }

                        if (pokemonUser.getVidaAtual() <= 0) {
                            userTrainer.statusTreiandor(userTrainer);
                            break;
                        }

                    } while (pokemonUser.getVidaAtual() > 0);
                    if (status == true) {
                        for (Pokemon pokemonsUser : listTreinador.get(0).getPokemons()) {
                            pokemonsUser.setVidaAtual(100f);
                            for (Golpe golpeUser : pokemonsUser.getGolpes()) {
                                golpeUser.setQtdUtizada(10);
                            }
                        }
                        status = false;
                        break;
                    }
                }
            } else {
                System.out.println("Seus Pokémons foram derrotados!!!!");
                System.out.println(userTrainer.getPokemons()[0].stringVidaPokemon());
                System.out.println(userTrainer.getPokemons()[1].stringVidaPokemon());
                break;
            }
        } while (treinadorOponente != null);
    }

    //------------usuarioGolpe---------------------
    public static Golpe choiceGolpe(Pokemon pokemonAtualizado) {
        String golpeUser;
        clearOutput(100);
        System.out.println("-------------");
        System.out.println("| Seu ataque |");
        System.out.println("-------------");
        System.out.println(listTreinador.get(0).getNomeJogador() + " Escolha o golpe para ataque do pokémon : " + pokemonAtualizado.getNomePokemon());
        System.out.println(pokemonAtualizado.stringNameGolpe());
        golpeUser = inputString();
        do {
            if (!((golpeUser.equals("1")) || (golpeUser.equals("2")) || (golpeUser.equals("3")) || (golpeUser.equals("4")))) {
                clearOutput(1000);
                System.err.println("Informe os valores corretos!!");
                System.out.println("--------------------------------------------------");
                System.out.println(pokemonAtualizado.stringNameGolpe());
                golpeUser = inputString();
            }
        } while (!((golpeUser.equals("1")) || (golpeUser.equals("2")) || (golpeUser.equals("3")) || (golpeUser.equals("4"))));
        int golpe = Integer.parseInt(golpeUser);
        golpe = golpe - 1;
        pokemonAtualizado.getGolpes()[golpe].setQtdUtizada(pokemonAtualizado.getGolpes()[golpe].getQtdUtizada() - 1);
        clearOutput(100);
        return pokemonAtualizado.getGolpes()[golpe];
    }

    //------------oponenteGolpe---------------------
    public static Golpe choiceGolpeOponente(Pokemon pokemonOponete) {
        Golpe golpeOponente = null;
        int lottery;
        do {
            lottery = (int) (Math.random() * 3);
            if (pokemonOponete.getGolpes()[lottery].getQtdUtizada() > 0) {
                golpeOponente = pokemonOponete.getGolpes()[lottery];
            }
        } while (pokemonOponete.getGolpes()[lottery].getQtdUtizada() <= 0);
        pokemonOponete.getGolpes()[lottery].setQtdUtizada(pokemonOponete.getGolpes()[lottery].getQtdUtizada() - 1);
        return golpeOponente;
    }

    //------------trinadorOponente---------------------
    public static Treinador getTreinadorOponente(Treinador treinadorUser) {
        Treinador oponenteAtual = null;
        for (Treinador oponente : listTreinador) {
            if (oponente.isIsDerrotado() != true && !(oponente.equals(listTreinador.get(0)))) {
                oponenteAtual = oponente;
                //alterando o tipo do golpe do lider para o tipo de desvantagem do treiandor do usuario
                if (oponenteAtual.getStatus() == StatusTreinador.TREINADOR_LIDER) {
                    for (Pokemon pokemonLider : oponente.getPokemons()) {
                        for (Golpe golpePokemonLider : pokemonLider.getGolpes()) {
                            for (Pokemon pokemonUser : treinadorUser.getPokemons()) {
                                if (golpePokemonLider.getTipoGolpe() == pokemonUser.getTipoVantagem()) {
                                    golpePokemonLider.setTipoGolpe(pokemonUser.getTipoDesvantagem());
                                }
                                golpePokemonLider.setPoderGolpe((int) 62.5);
                            }
                        }
                    }
                }
                break;
            }
        }
        return oponenteAtual;
    }

    public static Golpe getGolpe(int numberGolpe) {

        switch (numberGolpe) {
            case 0:
                return new Golpe("CHUVA DE PRATA", Tipos.VOADOR, 50, 10);
            case 1:
                return new Golpe("ATAQUE DE ASAS", Tipos.VOADOR, 50, 10);
            case 2:
                return new Golpe("LÂMINA DO AR", Tipos.VOADOR, 50, 10);
            case 3:
                return new Golpe("QUEDA DOS CÉUS", Tipos.VOADOR, 50, 10);
            case 4:
                return new Golpe("RAIO SOLAR", Tipos.GRAMA, 50, 10);
            case 5:
                return new Golpe("RAJADA DE SEMENTES", Tipos.GRAMA, 50, 10);
            case 6:
                return new Golpe("LÂMINA DE FOLHA", Tipos.GRAMA, 50, 10);
            case 7:
                return new Golpe("TEMPESTADE DE FOLHAS", Tipos.GRAMA, 50, 10);
            case 8:
                return new Golpe("CANHÃO DE AGUA", Tipos.AGUA, 50, 10);
            case 9:
                return new Golpe("CALDA DE AGUA", Tipos.AGUA, 50, 10);
            case 10:
                return new Golpe("DANÇA DA CHUVA", Tipos.AGUA, 50, 10);
            case 11:
                return new Golpe("FURACÃO", Tipos.AGUA, 50, 10);
            case 12:
                return new Golpe("LANÇA CHAMAS", Tipos.FOGO, 50, 10);
            case 13:
                return new Golpe("PRESA DE FOFO", Tipos.FOGO, 50, 10);
            case 14:
                return new Golpe("BOLA DE FOGO", Tipos.FOGO, 50, 10);
            case 15:
                return new Golpe("METEORO", Tipos.PEDRA, 50, 10);
            case 16:
                return new Golpe("ONDA DE CALOR", Tipos.FOGO, 50, 10);
            case 17:
                return new Golpe("INVESTIDA TROVÃO", Tipos.ELETRICO, 50, 10);
            case 18:
                return new Golpe("CHOQUE DO TROVÃO", Tipos.ELETRICO, 50, 10);
            case 19:
                return new Golpe("PANCADA DE RAIO", Tipos.ELETRICO, 50, 10);
            case 20:
                return new Golpe("TEIA ELÉTRICA", Tipos.ELETRICO, 50, 10);
            case 21:
                return new Golpe("PEDRA OCULTA", Tipos.PEDRA, 50, 10);
            case 22:
                return new Golpe("DEVASTAÇÃO DE ROCHA", Tipos.PEDRA, 50, 10);
            case 23:
                return new Golpe("EXPLOSÃO DE ROCHA", Tipos.PEDRA, 50, 10);
        }

        return null;
    }

    public static Pokemon createPokemons(int numberPokemon) {
        switch (numberPokemon) {
            case 0:
                return new Pokemon("Charizard", Tipos.FOGO, Tipos.ELETRICO, Tipos.AGUA, 100, 100, 100, 99, getGolpe(12), getGolpe(13), getGolpe(1), getGolpe(2));
            case 1:
                return new Pokemon("Pikachu ", Tipos.ELETRICO, Tipos.VOADOR, Tipos.FOGO, 100, 100, 100, 99, getGolpe(17), getGolpe(18), getGolpe(19), getGolpe(20));
            case 2:
                return new Pokemon("Vaporeon", Tipos.AGUA, Tipos.FOGO, Tipos.PEDRA, 100, 100, 100, 98, getGolpe(8), getGolpe(9), getGolpe(20), getGolpe(19));
            case 3:
                return new Pokemon("Pidgeot", Tipos.VOADOR, Tipos.GRAMA, Tipos.ELETRICO, 100, 100, 100, 97, getGolpe(0), getGolpe(3), getGolpe(22), getGolpe(23));
            case 4:
                return new Pokemon("Lugia", Tipos.AGUA, Tipos.FOGO, Tipos.PEDRA, 100, 100, 100, 100, getGolpe(10), getGolpe(11), getGolpe(0), getGolpe(1));
            case 5:
                return new Pokemon("Onix", Tipos.PEDRA, Tipos.AGUA, Tipos.GRAMA, 100, 100, 100, 95, getGolpe(23), getGolpe(21), getGolpe(22), getGolpe(15));
            case 6:
                return new Pokemon("Venusaur", Tipos.GRAMA, Tipos.PEDRA, Tipos.VOADOR, 100, 100, 100, 94, getGolpe(4), getGolpe(5), getGolpe(6), getGolpe(7));
            case 7:
                return new Pokemon("Moltres", Tipos.FOGO, Tipos.ELETRICO, Tipos.AGUA, 100, 100, 100, 93, getGolpe(16), getGolpe(14), getGolpe(3), getGolpe(4));
        }
        return null;
    }

    static ArrayList<Treinador> listTreinador = new ArrayList<>();//CRIA UM ARRAY DE TREINADOR

    public static void main(String[] args) {
        messageStart();
        System.out.print("Para registar um novo Treinador \nInforme o Nome:");
        String nameUser = inputString();
        listTreinador.add(new Treinador(nameUser, createPokemons(generateRandomNumber()), createPokemons(generateRandomNumber()), StatusTreinador.TREINADOR_COMUM, false));
        listTreinador.add(new Treinador("ASHE", createPokemons(1), createPokemons(3), StatusTreinador.TREINADOR_COMUM, false));
        listTreinador.add(new Treinador("HOPPA", createPokemons(6), createPokemons(7), StatusTreinador.TREINADOR_COMUM, false));
        listTreinador.add(new Treinador("CINTHIA", createPokemons(4), createPokemons(5), StatusTreinador.TREINADOR_LIDER, false));
        clearOutput(1000);
        //------------------------------------------------------------
        System.out.println("Cadastro Realizado!!!!!");
        clearOutput(1500);
        messageStatus();
        System.out.println("Treinador: " + listTreinador.get(0).getNomeJogador());
        String optionUser;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Deseja ver seus pokemons?[sim/nao]");
            optionUser = input.nextLine();
            if (optionUser.equalsIgnoreCase("sim")) {
                showPokemon();
                messageGameMenu();
            } else if (optionUser.equalsIgnoreCase("nao") || optionUser.equalsIgnoreCase("não")) {
                clearOutput(500);
                messageGameMenu();
                break;
            } else {
                mensagemErr();
            }
        } while (!optionUser.equalsIgnoreCase("sim"));
    }
}
