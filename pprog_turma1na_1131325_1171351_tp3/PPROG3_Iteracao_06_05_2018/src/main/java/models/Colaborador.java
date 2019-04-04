package models;

import java.io.Serializable;

/**
 *
 * Representa um colaborador
 */
public final class Colaborador implements Serializable {
    
    /**
     * número mecanográfico do colaborador
     */
    private int numeroMecanografico;
    /**
     * nome completo do colaborador
     */
    private String nomeCompleto;
    /**
     * nome abreviado do colaborador
     */
    private String nomeAbrev;
    /**
     * perfil de autorização associado ao colaborador
     */
    private PerfilDeAutorizacao perfilDeAutorizacao;
    
    /**
     * Constrói uma instância de colaborador recebendo os seguintes parâmetros
     *
     * @param numeroMecanografico
     * @param nomeCompleto
     * @param nomeAbrev
     * @param perfilDeAutorizacao
     */
    public Colaborador(int numeroMecanografico, String nomeCompleto, String nomeAbrev, PerfilDeAutorizacao perfilDeAutorizacao) {
        this.setNumeroMecanografico(numeroMecanografico);
        this.setNomeCompleto(nomeCompleto);
        this.setNomeAbreviado(nomeAbrev);
        this.perfilDeAutorizacao = new PerfilDeAutorizacao();
        this.setPerfilDeAutorizacao(perfilDeAutorizacao);
    }
    
    /**
     * Constrói uma instância de colaborador
     */
    public Colaborador() {
        perfilDeAutorizacao = new PerfilDeAutorizacao();
    }
    
    /**
     * Devolve o nome abreviado do colaborador
     *
     * @return
     */
    public String getNomeAbrev() {
        return nomeAbrev;
    }
    
    /**
     * Modifica o nome abreviado do colaborador
     *
     * @param nomeAbrev
     */
    public void setNomeAbrev(String nomeAbrev) {
        this.nomeAbrev = nomeAbrev;
    }
    
    /**
     * Devolve o número mecanográfico do colaborador
     *
     * @return
     */
    public int getNumeroMecanografico() {
        return this.numeroMecanografico;
    }
    
    /**
     * Modifica o número mecanográfico do colaborador
     *
     * @param numMecanog
     */
    public void setNumeroMecanografico(int numMecanog) {
        this.numeroMecanografico = numMecanog;
    }
    
    /**
     * Modifica o nome completo do colaborador
     *
     * @param nomeCompleto
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    /**
     * Modifica o nome avreviado do colaborador
     *
     * @param nomeAbreviado
     */
    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbrev = nomeAbreviado;
    }
    
    /**
     * Valida o colaborador
     *
     * @return true se o colaborador for válido
     */
    public boolean valida() {
        return this.nomeCompleto != null && this.nomeAbrev != null && this.perfilDeAutorizacao.valida();
    }
    
    /**
     * Valida o colaborador recebido por parâmetro
     *
     * @param m_colaborador
     * @return true se o colaborador for válido
     */
    public boolean validaColaborador(Colaborador m_colaborador) {
        boolean bRet = false;
        if (m_colaborador.valida()) {
            bRet = true;
        }
        return bRet;
    }
    
    /**
     * Devolve o perfil de autorização do colaborador
     *
     * @return
     */
    public PerfilDeAutorizacao getPerfilDeAutorizacao() {
        return perfilDeAutorizacao;
    }
    
    /**
     * Modifica o perfil de autorização do colaborador
     *
     * @param perfilDeAutorizacao
     */
    public void setPerfilDeAutorizacao(PerfilDeAutorizacao perfilDeAutorizacao) {
        this.perfilDeAutorizacao = perfilDeAutorizacao;
    }
    
    /**
     * Devolve a descrição textual do colaborador
     *
     * @return
     */
    @Override
    public String toString() {
        return "Colaborador{" + "numeroMecanografico=" + numeroMecanografico + ", nomeCompleto=" + nomeCompleto + ", nomeAbrev=" + nomeAbrev + '}';
    }
    
}
