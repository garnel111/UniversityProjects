/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package utils;

import Interfaces.AtribuicaoDeCartao;
import Interfaces.Cartao;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import models.AreaRestrita;
import models.AtribuicaoCartaoDefinitivo;
import models.CartaoIdentificacaoDefinitivo;
import models.Colaborador;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;

/**
 *
 * @author mjdg1
 */
public class InstanciacaoClasses {

    public static void instanciarClassesUC3(Empresa m_empresa) {
        for (int i = 0; i < 5; i++) {
            int id = i + 1;
            Equipamento equipamento = new Equipamento(Integer.toString(id), "teste" + id, "teste" + id, "sFicheiroConfiguracao" + id, " novasc" + id, "Fabricante" + id, "entrada", new AreaRestrita(id, id, id, id, id, id));
            m_empresa.getRegistoDeEquipamentos().registaEquipamento(equipamento);
        }
    }

    public static void instanciarClassesUC6(Empresa m_empresa) {
        ArrayList<Cartao> cartoes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int id = i + 1;
            Cartao c = new CartaoIdentificacaoDefinitivo(id, LocalDate.now(), id);
            AreaRestrita area = new AreaRestrita(id, id, id, id, id, id);
            Equipamento equi = new Equipamento(Integer.toString(id), "teste" + id, "teste" + id, "sFicheiroConfiguracao" + id, " novasc" + id, "Fabricante" + id, "entrada", area);
            m_empresa.getRegistoDeEquipamentos().registaEquipamento(equi);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR, -2);
            SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
            String horaInicial = sdfHour.format(cal.getTime());
            cal.add(Calendar.HOUR, 3);
            String horaFinal = sdfHour.format(cal.getTime());

            PerfilDeAutorizacao perfilDeAutorizacao = new PerfilDeAutorizacao(Integer.toString(id), "perfil de autorização " + id);
            perfilDeAutorizacao.adicionaPeriodo(equi, 6, horaInicial, horaFinal);
            Colaborador col = new Colaborador(i + 1, "Sofia Bastos Pereira", "Sofia Pereira", perfilDeAutorizacao);
            m_empresa.getRegistoColaboradores().registaColaborador(col);

            AtribuicaoDeCartao a = new AtribuicaoCartaoDefinitivo(LocalDate.now().minusDays(1), LocalDate.now(), LocalDate.now().plusYears(2), col);
            c.registaAtribuicao(a);
            cartoes.add(c);
        }
        m_empresa.getRegistodeCartoes().setCartoes(cartoes);
    }

}
