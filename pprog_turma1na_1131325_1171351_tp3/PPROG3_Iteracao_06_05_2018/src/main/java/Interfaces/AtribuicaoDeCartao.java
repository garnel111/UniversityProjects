package Interfaces;

import java.time.LocalDate;
import models.Colaborador;

public interface AtribuicaoDeCartao {
    
    public Colaborador getColaborador();
    
    public boolean pertencePeriodo(LocalDate date);
    
    public boolean valida();
    
}
