package utils;

import Interfaces.AtribuicaoDeCartao;
import Interfaces.Cartao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import models.AreaRestrita;
import models.AtribuicaoCartaoDefinitivo;
import models.CartaoIdentificacaoDefinitivo;
import models.Colaborador;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.PeriodoDeAutorizacao;

/**
 *
 * @author
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mjdg1
 */
public class Leitura implements Serializable {

    public static void leituraCartaotxt(String nomeFicheiroCartoes, Empresa m_Empresa) throws FileNotFoundException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList<Cartao> listaCartoes = new ArrayList<>();
        ArrayList<Colaborador> listaColaboradores = new ArrayList<>();
        ArrayList<Equipamento> listaEquipamentos = new ArrayList<>();
        
        Cartao cartao = null;

        AtribuicaoDeCartao atr = null;
        Colaborador colaborador = null;
        PerfilDeAutorizacao perfilDeAutorizacao = null;
        Equipamento equipamento = null;
        AreaRestrita areaRestrita = null;

        Scanner leitura = new Scanner(new File(nomeFicheiroCartoes));
        while (leitura.hasNext()) {
            String[] aux = leitura.nextLine().split(";");
            cartao = new CartaoIdentificacaoDefinitivo(Integer.parseInt(aux[0]), LocalDate.parse(aux[1], dateTimeFormatter), Integer.parseInt(aux[2]));
            areaRestrita = new AreaRestrita(Integer.parseInt(aux[18]), Integer.parseInt(aux[19]), Integer.parseInt(aux[20]), Integer.parseInt(aux[21]), Integer.parseInt(aux[22]), Integer.parseInt(aux[23]));
            equipamento = new Equipamento(aux[11], aux[12], aux[13], aux[14], aux[15], aux[16], aux[17], areaRestrita);
            perfilDeAutorizacao = new PerfilDeAutorizacao(aux[9], aux[10]);
            perfilDeAutorizacao.adicionaPeriodo(equipamento, Integer.parseInt(aux[24]), aux[25], aux[26]);
            colaborador = new Colaborador(Integer.parseInt(aux[6]), aux[7], aux[8], perfilDeAutorizacao);
            atr = new AtribuicaoCartaoDefinitivo(LocalDate.parse(aux[3]), LocalDate.parse(aux[4]), LocalDate.parse(aux[5]), colaborador);
            cartao.registaAtribuicao(atr);
            
            listaCartoes.add(cartao);
            listaEquipamentos.add(equipamento);
            listaColaboradores.add(colaborador);
        }

        leitura.close();
        m_Empresa.getRegistodeCartoes().setCartoes(listaCartoes);
        m_Empresa.getRegistoColaboradores().setColaboradores(listaColaboradores);
        m_Empresa.getRegistoDeEquipamentos().setEquipamentos(listaEquipamentos);
    }

    
    public static void lerFicheiroBin(String nomeFicheiro, Empresa m_Empresa) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFicheiro));      
        
        m_Empresa.getRegistodeCartoes().getCartoes().addAll(((ArrayList<Cartao>) in.readObject()));
        m_Empresa.getRegistoColaboradores().getColaboradores().addAll(((ArrayList<Colaborador>) in.readObject()));
        m_Empresa.getRegistoDeEquipamentos().getEquipamentos().addAll(((ArrayList<Equipamento>) in.readObject()));
        in.close();
    }
    
    
}
