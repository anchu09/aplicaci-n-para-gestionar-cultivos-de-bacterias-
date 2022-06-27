package ordenacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;
import model.Poblacion;

/**
 *
 * @author Dani
 */
public class Ordenarporfecha implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        Poblacion pob1 = (Poblacion) t;
        Poblacion pob2 = (Poblacion) t1;
        return pob1.getFechaComienzo().compareTo(pob2.getFechaComienzo());
    }

}
