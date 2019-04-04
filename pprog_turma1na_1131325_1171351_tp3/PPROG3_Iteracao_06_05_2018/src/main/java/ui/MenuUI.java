/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ui;

import Interfaces.Cartao;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import models.Colaborador;
import models.Empresa;
import models.Equipamento;
import utils.EscritaFicheiroBin;
import utils.InstanciacaoClasses;
import utils.Leitura;
import utils.Utils;

/**
 * 
 * Representa oMenu UI
 */
public class MenuUI {

    private final Empresa m_empresa;
    private String opcao;

    public MenuUI(Empresa empresa) {
        m_empresa = empresa;
    }

    public void run() throws IOException, ParseException, ClassNotFoundException {

        try {
            Leitura.lerFicheiroBin("PersistenciaDeDados.bin", m_empresa);
            System.out.println("\n##### Cartões #####");
            System.out.println(m_empresa.getRegistodeCartoes().getCartoes());
            System.out.println("\n##### Colaboradores #####");
            System.out.println(m_empresa.getRegistoColaboradores().getColaboradores());
            System.out.println("\n##### Equipamentos #####");
            System.out.println(m_empresa.getRegistoDeEquipamentos().getEquipamentos());
        } catch (IOException e) {
            System.err.println("Ficheiro PersistenciaDeDados.bin não encontrado");
        }

        do {

            System.out.println("\n\nIntroduza opção do menu seguinte");
            System.out.println("1. Registar Perfil de Autorizacao");
            System.out.println("2. Aceder Área Restrita");
            System.out.println("3. Instanciar Cartão/Colaborador/Equipamento a partir de ficheiro de texto");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Introduza opção\n");

            if (opcao.equals("1")) {
                InstanciacaoClasses.instanciarClassesUC3(m_empresa);
                RegistarPerfilDeAutorizacaoUI ui = new RegistarPerfilDeAutorizacaoUI(m_empresa);
                ui.run();
            }
            if (opcao.equals("2")) {
                InstanciacaoClasses.instanciarClassesUC6(m_empresa);
                AcederAreaRestritaUI acederAreaRestritaUI = new AcederAreaRestritaUI(m_empresa);
                acederAreaRestritaUI.run();
            }
            if (opcao.equals("3")) {
                Leitura.leituraCartaotxt("Dados.txt", m_empresa);
                System.out.println("\n##### Cartões #####\n");
                for (Cartao c : m_empresa.getRegistodeCartoes().getCartoes()) {
                    System.out.println("Cartão gravado: " + c.toString());
                }
                System.out.println("\n##### Colaboradores #####\n");
                for (Colaborador col : m_empresa.getRegistoColaboradores().getColaboradores()) {
                    System.out.println("Colaborador gravado: " + col.toString());
                }
                System.out.println("\n##### Equipamentos #####\n");
                for (Equipamento eq : m_empresa.getRegistoDeEquipamentos().getEquipamentos()) {
                    System.out.println("Equipamento gravado: " + eq.toString());
                }
            }
        } while (!opcao.equals("0"));
        if (opcao.equalsIgnoreCase("0")) {
            fechar();
        }
    }

    private void fechar() throws IOException {
        opcao = Utils.readLineFromConsole("Deseja Salvar os Dados? S-Sim \t N-Não\n");

        if (opcao.equalsIgnoreCase("S")) {
            try {
                System.out.println(m_empresa.getRegistodeCartoes().getCartoes());
                System.out.println(m_empresa.getRegistoColaboradores().getColaboradores());
                System.out.println(m_empresa.getRegistoDeEquipamentos().getEquipamentos());
                EscritaFicheiroBin.gravarNoFicheiroEventoBin("PersistenciaDeDados.bin", m_empresa.getRegistodeCartoes().getCartoes(), m_empresa.getRegistoColaboradores().getColaboradores(), m_empresa.getRegistoDeEquipamentos().getEquipamentos());
            } catch (IOException excecao) {
                System.err.println(excecao);
            }

        }
    }
}
