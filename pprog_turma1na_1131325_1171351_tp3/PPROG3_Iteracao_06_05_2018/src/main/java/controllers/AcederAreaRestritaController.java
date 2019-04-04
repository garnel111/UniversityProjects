package controllers;

import Interfaces.Cartao;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Calendar;
import models.AreaRestrita;

import models.Colaborador;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.RegistoDeAcessos;
import models.RegistoDeCartoes;
import models.RegistoDeEquipamentos;

public class AcederAreaRestritaController {
    
    private final Empresa empresa;
    private RegistoDeEquipamentos registoDeEquipamentos;
    private Equipamento equipamento;
    private RegistoDeCartoes registoDeCartoes;
    private Colaborador colaboradorAtribuido;
    private Cartao cartao;
    private PerfilDeAutorizacao perfilDeAutorizacao;
    private RegistoDeAcessos registoDeAcessos;
    
    public AcederAreaRestritaController(Empresa m_empresa) {
        this.empresa = m_empresa;
    }
    
    public boolean solicitaAcesso(String idEquipamento, int idCartaoInt, LocalDate date, String hourString) {
        registoDeEquipamentos = empresa.getRegistoDeEquipamentos();
        equipamento = registoDeEquipamentos.getEquipamentoById(idEquipamento);
        
        if (equipamento != null) {
            registoDeCartoes = empresa.getRegistodeCartoes();
            cartao = registoDeCartoes.getCartaoById(idCartaoInt);
            if (cartao != null) {
                colaboradorAtribuido = cartao.getColaboradorAtribuido(date);
                if (colaboradorAtribuido != null) {
                    
                    perfilDeAutorizacao = colaboradorAtribuido.getPerfilDeAutorizacao();
                    boolean sucesso = perfilDeAutorizacao.isEquipamentoAutorizado(idEquipamento, date, hourString);
                    
                    AreaRestrita areaRestrita = equipamento.getAreaRestrita();
                    String movimento = equipamento.getMovimento();
                    boolean permiteAcesso = areaRestrita.lotacaoPermiteAcesso(movimento);
                    if (permiteAcesso) {
                        registoDeAcessos = empresa.getRegistoAcessos();
                        Calendar cal = Calendar.getInstance();
                        cal.add(Calendar.HOUR, -2);
                        SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
                        String hora = sdfHour.format(cal.getTime());
                        registoDeAcessos.novoAcesso(equipamento, cartao, colaboradorAtribuido, LocalDate.now(), hora, sucesso, movimento);
                        return true;
                    }
                    
                }
                
            }
        }
        return false;
    }
    
}
