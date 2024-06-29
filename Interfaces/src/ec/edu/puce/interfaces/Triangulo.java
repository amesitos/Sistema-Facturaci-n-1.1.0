package ec.edu.puce.interfaces;

public class Triangulo implements FiguraGeometrica{
	private double base;
	private double altura;

	@Override
	public double calcularArea() {
		return (this.base * this.altura)/2;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}


