package models;

import Interfaces.Cartao;
import java.time.LocalDate;

/**
 * Representa um Acesso à Área Restrita
 *
 * @author mjdg1
 */
public class AcessoAreaRestrita {
    
    /**
     * data de acesso
     */
    private LocalDate data;
    /**
     * hora de acesso
     */
    private String hora;
    /**
     * movimento - entrada ou saída
     */
    private String movimento;
    /**
     * sucesso relativo ao acesso
     */
    private boolean sucesso;
    /**
     * motivo do acesso
     */
    private String motivo;
    /**
     * equipamento a aceder
     */
    private Equipamento equipamento;
    /**
     * cartão de acesso
     */
    private Cartao cartao;
    /**
     * colaborador que está a aceder à área restrira
     */
    private Colaborador colaborador;
    
    /**
     * Constrói uma instância de AcessoAreaRestrita recebendo como parâmetros:
     *
     * @param data
     * @param hora
     * @param movimento
     * @param sucesso
     * @param motivo
     * @param equipamento
     * @param cartao
     * @param colaborador
     */
    public AcessoAreaRestrita(LocalDate data, String hora, String movimento, boolean sucesso, String motivo, Equipamento equipamento, Cartao cartao, Colaborador colaborador) {
        this.data = data;
        this.hora = hora;
        this.movimento = movimento;
        this.sucesso = sucesso;
        this.motivo = motivo;
        this.equipamento = equipamento;
        this.cartao = cartao;
        this.colaborador = colaborador;
    }
    
    /**
     * Constrói uma instância de AcessoAreaRestrita recebendo como parâmetros:
     *
     * @param equipamento
     * @param cartao
     * @param colaborador
     * @param date
     * @param hora
     * @param sucesso
     * @param movimento
     */
    public AcessoAreaRestrita(Equipamento equipamento, Cartao cartao, Colaborador colaborador, LocalDate date, String hora, boolean sucesso, String movimento) {
        this.equipamento = equipamento;
        this.cartao = cartao;
        this.colaborador = colaborador;
        this.data = date;
        this.hora = hora;
        this.sucesso = sucesso;
        this.movimento = movimento;
    }
    
    /**
     * Devolve a data de acesso à área restrita
     *
     * @return data
     */
    public LocalDate getData() {
        return this.data;
    }
    
    /**
     * Modifica a data de acesso à área restrita
     *
     * @param data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    /**
     * Devolve a hora de acesso à área restrita
     *
     * @return hora
     */
    public String getHora() {
        return this.hora;
    }
    
    /**
     * Modifica a hora de acesso à área restrira
     *
     * @param horava hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    /**
     * Devolve o movimento referente à área restrita (entrada ou saída)
     *
     * @return movimento o movimento
     */
    public String getMovimento() {
        return this.movimento;
    }
    
    /**
     * Modifica o movimento referente à área restrita (entrada ou saída)
     *
     * @param o moviemento
     */
    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }
    
    /**
     * Devolve se o acesso à área restrira foi ou não realizado com sucesso
     *
     * @return sucesso o sucesso
     */
    public boolean getSucesso() {
        return this.sucesso;
    }
    
    /**
     * Modifica o resultado do acesso da área restrita
     *
     * @param sucesso o sucesso
     */
    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
    
    /**
     * Devolve o motivo de acesso à área restrita
     *
     * @return motivo o motivo de acesso
     */
    public String getMotivo() {
        return this.motivo;
    }
    
    /**
     * Modifica o motivo de acesso à área restrita
     *
     * @param motivo o motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
