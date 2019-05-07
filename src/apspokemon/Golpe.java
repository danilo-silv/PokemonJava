package apspokemon;
/*
 * @author Danilo| RA: 21055361| Curso: Sistemas de informações| Materia: POO
 *APS PROGRAMAÇÃO ORIENTTADA A OBJETOS
 */
public class Golpe {
    private final String nomeGolpe;
    private Tipos tipoGolpe;
    private int poderGolpe;
    private int qtdUtizada;

    public Golpe(String nomeGolpe, Tipos tipoGolpe, int poderGolpe, int qtdUtizada) {
        this.nomeGolpe = nomeGolpe;
        this.tipoGolpe = tipoGolpe;
        this.poderGolpe = poderGolpe;
        this.qtdUtizada = qtdUtizada;
    } 

    public String getNomeGolpe() {
        return nomeGolpe;
    }

    public void setQtdUtizada(int qtdUtizada) {
        this.qtdUtizada = qtdUtizada;
    }

    public int getQtdUtizada() {
        return qtdUtizada;
    }

    public Tipos getTipoGolpe() {
        return tipoGolpe;
    }

    public int getPoderGolpe() {
        return poderGolpe;
    }

    public void setTipoGolpe(Tipos tipoGolpe) {
        this.tipoGolpe = tipoGolpe;
    }

    public void setPoderGolpe(int poderGolpe) {
        this.poderGolpe = poderGolpe;
    }
    
    
    @Override
    public String toString() {
        return nomeGolpe +
               ", Tipo: " + tipoGolpe + 
               ", Poder:" + poderGolpe + 
               ", Quantidade: " + qtdUtizada;
    }
    
    
}
