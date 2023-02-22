
package apuestas;

/**
 * Tenemos la clase apuesta
 * @author BORREGO
 */
public class Apuesta {

    /**
     * devuelve los goles del local
     * @return the goles_local
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * recibe los goles del local
     * @param goles_local the goles_local to set
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * devuelve los goles del visitantes
     * @return the goles_visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * recibe los goles del local
     * @param goles_visitante the goles_visitante to set
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * devuelve las apuestas
     * @return the apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * recibe las apuestas
     * @param apostado the apostado to set
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante; 
    private int apostado;

    /**
     * Constructor de la clase Apuesta
     */
    public Apuesta() {
    } 

    /**
     * Constructor con todos los parametros de la calse Apuesta
     * @param dinero_disp es el dinero que se dispensa
     * @param goles_local son los goles que mete el equipo local
     * @param goles_visitante son los goles que mete el equipo visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }

    /**
     * devuelve el dinero dispensado
     * @return dinero_disp
     */
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * recibe el dinero dispensado
     * @param dinero_disp 
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    
    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * @param dinero es el dinero que tenemos
     * @throws Exception 
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
   
    /**
     * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * @param local es el equipo local
     * @param visitante el equipo visitantes
     * @return devuelve si se ha acertado o no
     * @throws Exception 
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
   
    
    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * @param cantidad_goles_local es la cantidad de goles que ha metido los locales
     * @param cantidad_goles_visit es la cantidad de goles que ha metido los visitantes
     * @throws Exception 
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}