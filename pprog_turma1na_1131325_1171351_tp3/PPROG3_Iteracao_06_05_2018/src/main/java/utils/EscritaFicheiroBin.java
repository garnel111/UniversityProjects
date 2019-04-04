/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Interfaces.Cartao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import models.Colaborador;
import models.Equipamento;

/**
 *
 * @author Manuel
 */
public class EscritaFicheiroBin implements Serializable{
    
     /**
     * Guarda num ficheiro do tipo binário toda a informação relativa aos cartões
     *
     * @param nomeFicheiro nome do ficheiro onde será gravada a informação@throws java.io.IOException
     * @param cartoes
     * @throws java.io.IOException
     */
    public static void gravarNoFicheiroEventoBin(String nomeFicheiro, ArrayList<Cartao> cartoes, ArrayList<Colaborador> colaboradores, ArrayList<Equipamento> equipamentos  ) throws FileNotFoundException, IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
        try{
                   out.writeObject(cartoes);

        out.writeObject(colaboradores);

        out.writeObject(equipamentos); 
        } catch(Exception e){
            out.close();
        }
           

        out.close();
    }
    
    
}
