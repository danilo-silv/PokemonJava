package apspokemon;

/*
 *@author Danilo| RA: 21055361| Curso: Sistemas de informações| Materia: POO
 *APS PROGRAMAÇÃO ORIENTTADA A OBJETOS
 */
public class Pokemon {

    private final String nomePokemon;
    private final Tipos tipoPokemon;
    private final Tipos tipoVantagem;
    private final Tipos tipoDesvantagem;
    private int nivel;
    private float vidaAtual;
    private final int ataque;
    private final int defesa;
    private final int velocidade;
    private final Golpe[] golpes;

    public Pokemon(String nomePokemon, Tipos tipoPokemon, Tipos tipoVantagem, Tipos tipoDesvantagem, int vidalAtual, int ataque, int defesa, int velocidade, Golpe golpe1, Golpe golpe2, Golpe golpe3, Golpe golpe4) {
        this.nomePokemon = nomePokemon;
        this.tipoPokemon = tipoPokemon;
        this.tipoVantagem = tipoVantagem;
        this.tipoDesvantagem = tipoDesvantagem;
        this.vidaAtual = vidalAtual;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.golpes = new Golpe[]{golpe1, golpe2, golpe3, golpe4};
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVidaAtual(float vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public float getVidaAtual() {
        return vidaAtual;
    }

    public Tipos getTipoVantagem() {
        return tipoVantagem;
    }

    public Tipos getTipoDesvantagem() {
        return tipoDesvantagem;
    }

    public Golpe[] getGolpes() {
        return golpes;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public static Pokemon atacar(int ataquePokemon, Golpe golpeAtaque, Pokemon pokemonAtacado) {
        float modificador;
        if (golpeAtaque.getTipoGolpe() == pokemonAtacado.tipoVantagem) {
            modificador = 0.5f;
        } else if (golpeAtaque.getTipoGolpe() == pokemonAtacado.tipoDesvantagem) {
            modificador = 1.5f;
        } else {
            modificador = 0.5f;
        }
        float vidaAtualPokemon = pokemonAtacado.getVidaAtual() - ((ataquePokemon + golpeAtaque.getPoderGolpe()) - pokemonAtacado.getDefesa()) * modificador;
        if (vidaAtualPokemon < 0) {
            vidaAtualPokemon = 0f;
        }
        pokemonAtacado.setVidaAtual(vidaAtualPokemon);
        return pokemonAtacado;
    }

    public String stringNameGolpe() {
        return "(1) - " + golpes[0].getNomeGolpe() + "      (2) - " + golpes[1].getNomeGolpe() + "\n"
                + "(3) - " + golpes[2].getNomeGolpe() + "      (4) - " + golpes[3].getNomeGolpe();
    }

    public String stringVidaPokemon() {
        return "\nNome do Pokemon: " + nomePokemon
                + "\nNumero de Vida: " + vidaAtual;
    }

    @Override
    public String toString() {
        return "\nNome do Pokemon: " + nomePokemon
                + "\nTipo do Pokemon: " + tipoPokemon
                + "\nVantagem: " + tipoVantagem
                + "\nDesvantagem:" + tipoDesvantagem
                + "\nNivel Pokemom: " + nivel
                + "\nNumero de Vida: " + vidaAtual
                + "\nAtaque: " + ataque
                + "\nDefesa: " + defesa
                + "\nVelocidade: " + velocidade
                + "\nGolpes: \n" + golpes[0] + "\n" + golpes[1] + "\n" + golpes[2] + "\n" + golpes[3] + "\n";
    }
}
