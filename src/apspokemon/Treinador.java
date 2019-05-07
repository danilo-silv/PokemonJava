package apspokemon;
/*
 * @author Danilo| RA: 21055361| Curso: Sistemas de informações| Materia: POO
 * APS PROGRAMAÇÃO ORIENTTADA A OBJETOS
 */
public class Treinador {
    private final String nomeJogador;
    private final Pokemon[] pokemons;
    private final StatusTreinador status;
    private boolean isDerrotado;

    public Treinador(String nomeJogador, Pokemon pokemon01, Pokemon pokemon02, StatusTreinador status, boolean isDerrotado) {
        this.nomeJogador = nomeJogador;
        this.pokemons = new Pokemon[]{pokemon01, pokemon02};
        this.status = status;
        this.isDerrotado = isDerrotado;
        if(status == StatusTreinador.TREINADOR_LIDER){
            for (Pokemon pokemon : pokemons) {
                    pokemon.setNivel(75);
            }
        }
        else {
            for (Pokemon pokemon : pokemons) {
                pokemon.setNivel(50);   
            }
        }
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public boolean isIsDerrotado() {
        return isDerrotado;
    }

    public StatusTreinador getStatus() {
        return status;
    }

    public void setIsDerrotado(boolean isDerrotado) {
        this.isDerrotado = isDerrotado;
    }
    
    
    public Treinador statusTreiandor(Treinador treinador) {
          if(treinador.getPokemons()[0].getVidaAtual() <=0 && treinador.getPokemons()[1].getVidaAtual() <=0){
              treinador.setIsDerrotado(true);
          }    
       return treinador;
    }
    

    @Override
    public String toString() {
        return "Treinador: " + nomeJogador + 
                "\npokemon01:" + pokemons[0] + "\npokemon02: " + pokemons[1];
                
//                "status: " + status;
    }

}