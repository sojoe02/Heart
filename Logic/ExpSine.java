/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Soren V. Jorgensen
 */
public class ExpSine {

    public double pulseFunction(double amp, double alpha, double DC, double x, double a) {
	return (Math.exp(alpha * x) * (amp * (Math.sin(x * a)))) + DC;
    }
}
