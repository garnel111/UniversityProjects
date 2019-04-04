package models;

import java.io.Serializable;

/**
 *
 * Representa uma Área Restrita
 */
public class AreaRestrita implements Serializable {
    
    /**
     * endereço lógico da área restrita
     */
    private int endeLogico;
    /**
     * endereço físico da área restrita
     */
    private int endeFisico;
    /**
     * código da área restrita
     */
    private int codigo;
    /**
     * lotação máxima da área restrita
     */
    private int lotMax;
    /**
     * localização da área restrita
     */
    private int localizacao;
    /**
     * lotação atual da área restrita
     */
    private int lotacao;
    
    /**
     * Constrói uma instância de AreaRestrita
     */
    public AreaRestrita() {
        
    }
    
    /**
     * Constrói uma instância de AreaRestrita com os seguintes parâmtros
     *
     * @param endeLogico
     * @param endeFisico
     * @param codigo
     * @param lotMax
     * @param localizacao
     * @param lotacao
     */
    public AreaRestrita(int endeLogico, int endeFisico, int codigo, int lotMax, int localizacao, int lotacao) {
        this.endeLogico = endeLogico;
        this.endeFisico = endeFisico;
        this.codigo = codigo;
        this.lotMax = lotMax;
        this.localizacao = localizacao;
        this.lotacao = lotacao;
    }
    
    /**
     * Devolve o endereço lógico da área restrita
     *
     * @return
     */
    public int getEndeLogico() {
        return endeLogico;
    }
    
    /**
     * Modifica o endereço lógico da área restrita
     *
     * @param endeLogico
     */
    public void setEndeLogico(int endeLogico) {
        this.endeLogico = endeLogico;
    }
    
    /**
     * Devolve o endereço físico da área restrita
     *
     * @return
     */
    public int getEndeFisico() {
        return endeFisico;
    }
    
    /**
     * Modifica o endereço físico da área restrita
     *
     * @param endeFisico
     */
    public void setEndeFisico(int endeFisico) {
        this.endeFisico = endeFisico;
    }
    
    /**
     * Devolce o código da área restrita
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Modifica o códido da área restrita
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Devolve a lotação máxima da área restrita
     *
     * @return
     */
    public int getLotMax() {
        return lotMax;
    }
    
    /**
     * Modifica a lotação máxima da área restrita
     *
     * @param lotMax
     */
    public void setLotMax(int lotMax) {
        this.lotMax = lotMax;
    }
    
    /**
     * Devolve a localização da área restrita
     *
     * @return
     */
    public int getLocalizacao() {
        return localizacao;
    }
    
    /**
     * Modifica a localização da área restrita
     *
     * @param localizacao
     */
    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }
    
    /**
     * Devolve a lotação da área restrita
     *
     * @param lotacao
     */
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    
    /**
     * Verifica se o movimento é válido
     *
     * @param movimento
     * @return true se o movimento for permitido
     */
    public boolean lotacaoPermiteAcesso(String movimento) {
        String entrada = movimento;
        if (entrada.equalsIgnoreCase("entrada")) {
            return true;
        }
        return false;
        
    }
    
    /**
     * Devolve a descrição textual da área restrita
     *
     * @return descrição textual da área restrita
     */
    @Override
    public String toString() {
        return "AreaRestrita{" + "endeLogico=" + endeLogico + ", endeFisico=" + endeFisico + ", codigo=" + codigo + ", lotMax=" + lotMax + ", localizacao=" + localizacao + ", lotacao=" + lotacao + '}';
    }
    
}
