package lapr.project.model;

import javafx.util.Pair;
import lapr.project.controller.TripController;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Organization {

    private TripController trpController;

    public Organization() {
        trpController = new TripController();
    }

    public Pair<Long, Long> getAmountOfEnergyConsumed(Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> poiWithValuesListFromDataBase) throws IOException {
        long energiaTotal = 0;
        long potencia = 0;
        Set<Map.Entry<Pair<String, String>, Pair<Pair<Long, Long>, Long>>> conjuntodeParesDoMapa = poiWithValuesListFromDataBase.entrySet();
        for (Map.Entry<Pair<String, String>, Pair<Pair<Long, Long>, Long>> paresEValores : conjuntodeParesDoMapa
        ) {
            Pair<String, String> pardeParques = paresEValores.getKey();

            Pair<Pair<Long, Long>, Long> pardeValores = paresEValores.getValue();
            Pair<Long, Long> pardeVelocidades = pardeValores.getKey();
            String poiOrigin = pardeParques.getKey();

            String poiDestiny = pardeParques.getValue();
            long vrk = pardeVelocidades.getKey();
            long vak = pardeVelocidades.getValue();
            long angulo = pardeValores.getValue();

            /*
             * Calcular a energia com o vento entre dois pois
             */
            TripController trp = new TripController();
            Pair<Long, Long> energyAndPower = trp.getEnergyBurnedBetweenTwoPOI(vrk, vak, angulo, poiOrigin, poiDestiny);
            potencia = potencia + energyAndPower.getKey();
            energiaTotal = energiaTotal + energyAndPower.getValue();
        }
        Pair<Long, Long> powerAndEndEnergy = new Pair<>(potencia, energiaTotal);

        return powerAndEndEnergy;
    }

    public void setTrpController(TripController trpController) {
        this.trpController = trpController;
    }
}
