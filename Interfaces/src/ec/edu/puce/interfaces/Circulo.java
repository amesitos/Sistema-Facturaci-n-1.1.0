package ec.edu.puce.interfaces;

public class Circulo implements FiguraGeometrica {
	private double radio;
	private static final double PI = 3.1416;

	@Override
	public double calcularArea() {
		return this.PI * (this.radio * this.radio);
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
