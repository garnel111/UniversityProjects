
import controllers.RegistarPerfilDeAutorizacaoController;
import java.time.LocalDate;
import models.AreaRestrita;
import models.Empresa;
import models.Equipamento;
import models.PerfilDeAutorizacao;
import models.PeriodoDeAutorizacao;
import models.RegistoDeEquipamentos;
import models.RegistoPerfisDeAutorizacao;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author mjdg1
 */
public class RegistarPerfilDeAutorizacaoTest {
    
    private RegistoDeEquipamentos registoDeEquipamentos;
    private Empresa m_Empresa;
    private RegistoPerfisDeAutorizacao registoPerfisDeAutorizacao;
    private PerfilDeAutorizacao perfilDeAutorizacao;
    private Equipamento equipamento;
    
    Equipamento equi1 = new Equipamento("1", "teste1", "tete1", "sFicheiroConfiguracao1", " novasc", "fabricante ", "entrada", new AreaRestrita());
    
    Equipamento equi3 = new Equipamento("3", "equi23a", "re232ws", "da232sdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
    
    PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi1);
    
    @Test
    public void addPerfilDeAutorizacaoTest() {
        
        //Arrange
        PerfilDeAutorizacao perfilDeAutorizacao1 = new PerfilDeAutorizacao("1", "descricao1");
        
        PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi1);
        
        Equipamento equi2 = new Equipamento("2", "equi2a", "rews", "dasdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
        
        //Act
        perfilDeAutorizacao1.adicionaPeriodo(equi2, 2, "11:30", "11:59");
        
        System.out.println(perfilDeAutorizacao1.getListaPeriodosDeAutorizacao().toString());
        //Assert
        System.out.println("Id PerfilDe Autoriza" + perfilDeAutorizacao1.getIdPerfilDeAutorizacao());
        Assert.assertTrue(perfilDeAutorizacao1.getIdPerfilDeAutorizacao().equalsIgnoreCase("1"));
    }
    
    @Test
    public void getListaDeEquipamentosTeste() {
        PerfilDeAutorizacao perfilDeAutorizacao = new PerfilDeAutorizacao();
        RegistarPerfilDeAutorizacaoController registarPerfilDeAutorizacaoController = new RegistarPerfilDeAutorizacaoController(m_Empresa);
        //Arrange
        // Equipamento equi3 = new Equipamento("3", "equi23a", "re232ws", "da232sdsa", "novasc", "fabricante", "entrada", new AreaRestrita());
        
        Equipamento equi1 = new Equipamento("1", "teste1", "tete1", "sFicheiroConfiguracao1", " novasc", "fabricante ", "entrada", new AreaRestrita());
        
        //Act
        perfilDeAutorizacao = new PerfilDeAutorizacao("1", "descricao1");
        int diaDaSemana = 2;
        PeriodoDeAutorizacao periododeAutorizacao1 = new PeriodoDeAutorizacao(2, "14:24", "14:33", equi1);
        perfilDeAutorizacao.adicionaPeriodo(equi3, 2, "11:30", "11:59");
        //Assert
        Assert.assertFalse(perfilDeAutorizacao.isEquipamentoAutorizado("3", LocalDate.MAX, "13:22"));
        Assert.assertTrue(perfilDeAutorizacao.valida());
        
       // System.out.println(registarPerfilDeAutorizacaoController.);
    }
    
}
