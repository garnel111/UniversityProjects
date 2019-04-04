/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ui;

import controllers.RegistarPerfilDeAutorizacaoController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import models.Empresa;
import utils.Utils;

/**
 *
 * @author mjdg1
 */
public class RegistarPerfilDeAutorizacaoUI {

    private Empresa mEmpresa;
    private RegistarPerfilDeAutorizacaoController registarPerfilDeAutorizacaoController;
    private String diaDaSemana;

    public RegistarPerfilDeAutorizacaoUI(Empresa mEmpresa) {
        this.mEmpresa = mEmpresa;
        registarPerfilDeAutorizacaoController = new RegistarPerfilDeAutorizacaoController(mEmpresa);
    }

    public void run() throws ParseException {
        System.out.println("\nNovo Perfil de Autorização:");

        registarPerfilDeAutorizacaoController.novoPerfilDeAutorizacao();

        introduzDados();
    }

    private void introduzDados() throws ParseException {

        String idPerfilDeAutorizacao = Utils.readLineFromConsole("Introduza o id do Perfil");
        String descricao = Utils.readLineFromConsole("Introduza a descricao do perfil");

        registarPerfilDeAutorizacaoController.setDados(idPerfilDeAutorizacao, descricao);
        ArrayList<String> m_EquipamentosList = procuraEquipamentos();

        apresentarEquipamentos(m_EquipamentosList);

        if (registarPerfilDeAutorizacaoController.valida()) {
            String confirma = Utils.readLineFromConsole("Deseja Guardar este perfil?\nPerfil de autorização: " + registarPerfilDeAutorizacaoController.getPerfilDeAutorizacao() + "\n s-sim \n n-Não");
            if ("S".equalsIgnoreCase(confirma)) {
                if (registarPerfilDeAutorizacaoController.registaPerfildeAutorizacao()) {
                    System.out.println("Perfil de autorização registado com sucesso");
                };
            }

        } else {
            System.out.println("Dados de perfil inválidos");
        }

    }

    private void apresentaDados() {

        System.out.print(registarPerfilDeAutorizacaoController.getPerfilDeAutorizacao());

    }

    private ArrayList<String> procuraEquipamentos() {

        return registarPerfilDeAutorizacaoController.getListaDeEquipamentos();

    }

    private void apresentarEquipamentos(ArrayList<String> registoDeEquipamentos) throws ParseException {
        boolean flag = false;
        boolean flag2 = false;
        String opcao_eq;
        String maisPeriodos;

        do {
            System.out.println("\n##### Equipamentos #####");

            for (String item : registoDeEquipamentos) {
                System.out.println(item);
            }
            opcao_eq = Utils.readLineFromConsole("\nEscolha o equipamento a associar (O para sair)");
            if (!opcao_eq.equalsIgnoreCase("0")) {

                registarPerfilDeAutorizacaoController.addEquipamentoById(opcao_eq);
                if (!opcao_eq.equalsIgnoreCase("0")) {

                    System.out.println("\nIntroduza o periodo de autorizacao (O para sair)");
                    flag = introduzPeriodo();

                    do {
                        maisPeriodos = Utils.readLineFromConsole("Deseja associar mais períodos a este equipamento?\n s-sim \n n-não");
                        if (maisPeriodos.equalsIgnoreCase("s")) {
                            while (flag2 == false) {
                                flag2 = introduzPeriodo();
                                maisPeriodos = Utils.readLineFromConsole("Deseja associar mais períodos a este equipamento?\n s-sim \n n-não");
                            }
                        }

                    } while (maisPeriodos.equalsIgnoreCase("s"));
                }
            }

        } while (!opcao_eq.equals("0"));

    }

    private boolean introduzPeriodo() throws ParseException {

        try {

            String diaDaSemana = Utils.readLineFromConsole("Introduza o dia da semana: \n 1-Domingo\n 2-Segunda-feira\n 3-Terça-feira\n 4-Quarta-feira\n 5-Quinta-feira\n 6-Sexta-feira\n 7-Domingo");

            int dia = Integer.parseInt(diaDaSemana.trim());

            validaDia(dia);
            
            DateFormat inicialHour = new SimpleDateFormat("HH:mm");
            String horaInicial = Utils.readLineFromConsole("Introduza a hora de inicio(formato: HH:mm) ");
            inicialHour.setLenient(false);
            Date dateInicial = inicialHour.parse(horaInicial);

            DateFormat finalHour = new SimpleDateFormat("HH:mm");
            String horaFinal = Utils.readLineFromConsole("Introduza a hora de fim(formato: HH:mm) ");
            finalHour.setLenient(false);
            Date dateFinal = finalHour.parse(horaFinal);

            while (!dateFinal.after(dateInicial)) {

                System.out.println("Deve introduzir uma hora final superior à inicial");
                horaFinal = Utils.readLineFromConsole("Introduza a hora de fim(formato: HH:mm) ");

                dateFinal = finalHour.parse(horaFinal);

            }

            registarPerfilDeAutorizacaoController.addPeriodo(dia, horaInicial, horaFinal);
            return true;

        } catch (ParseException pe) {
            System.out.println("Período Inválido\n Introduza novamente o  período");

        }
        return false;
    }

    private int validaDia(int dia) {

        if ((dia <= 0 || dia > 7)) {
            diaDaSemana = Utils.readLineFromConsole("Dia da semana inválido\n Introduza novamente o dia da semana: ");

            dia = Integer.parseInt(diaDaSemana.trim());
        }
        return dia;
    }
}
