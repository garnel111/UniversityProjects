/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ui;

import controllers.AcederAreaRestritaController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.ParseConversionEvent;
import models.Colaborador;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.RegistoDeCartoes;
import models.RegistoDeEquipamentos;
import utils.Utils;

/**
 *
 * @author mjdg1
 */
public class AcederAreaRestritaUI {

    private Empresa m_oEmpresa;
    private AcederAreaRestritaController acederAreaRestritaController;

    public AcederAreaRestritaUI(Empresa m_oEmpresa) {
        this.m_oEmpresa = m_oEmpresa;
        acederAreaRestritaController = new AcederAreaRestritaController(m_oEmpresa);

    }

    public void run() {
        System.out.println("\nIntroduza os dados de acesso à área restrita:");
        verificaAutorizacao();

    }

    public void verificaAutorizacao() {
        try {
            String idEquipamento = Utils.readLineFromConsole("Introduza o Id do Equipamento: ");
            String idCartao = Utils.readLineFromConsole("Introduza o ID do Cartão: ");
            int idCartaoInt = Integer.parseInt(idCartao);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.now();
            String date = dateTimeFormatter.format(localDate);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm aa");
            String hourString = dateFormat.format(new Date());

            boolean acesso = acederAreaRestritaController.solicitaAcesso(idEquipamento, idCartaoInt, localDate, hourString);
            if (acesso) {
                System.out.println("Acesso autorizado");
            } else {
                System.out.println("Acesso não autorizado");
            }
        } catch (Exception e) {
            System.err.println("Exceçao" + e.getMessage());
        }

    }

}
