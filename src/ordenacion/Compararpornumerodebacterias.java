package ordenacion;

import java.util.Comparator;
import model.Poblacion;

/**
 *
 * @author Dani
 */
public class Compararpornumerodebacterias implements Comparator {

    /**
     *
     * @param t
     * @param t1
     * @return
     */
    @Override
    public int compare(Object t, Object t1) {
        Poblacion pob1 = (Poblacion) t;
        int respuesta = 0;

        Poblacion pob2 = (Poblacion) t1;
        if (pob1.getNumeroInicialBacterias() > pob2.getNumeroInicialBacterias()) {
            respuesta = 1;
        } else if (pob1.getNumeroInicialBacterias() > pob2.getNumeroInicialBacterias()) {
            respuesta = -1;
        } else {
            respuesta = 0;
        }
        return respuesta;
    }
}
