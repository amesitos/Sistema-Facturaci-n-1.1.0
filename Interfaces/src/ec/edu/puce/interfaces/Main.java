package ec.edu.puce.interfaces;

public class Main {

	public static void main(String[] args) {
		
		// Rectángulos
		System.out.println("|| RECTÁNGULOS ||");
		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo();
		r1.setBase(7);
		r1.setAltura(15);
		r2.setBase(10);
		r2.setAltura(12);
		System.out.println("Área del rectángulo 1: " + r1.calcularArea());
		System.out.println("Área del rectángulo 2: " + r2.calcularArea());
		System.out.println("");
		
		// Triángulo 
		System.out.println("|| TRIÁNGULO ||");
		Triangulo t1 = new Triangulo();
		Triangulo t2 = new Triangulo();
		t1.setBase(8);
		t1.setAltura(14);
		t2.setBase(20);
		t2.setAltura(15);
		System.out.println("Área del triángulo 1: " + t1.calcularArea());
		System.out.println("Área del triángulo 2: " + t2.calcularArea());
		System.out.println("");
		
		// Círculos
		System.out.println("|| CÍRCULO ||");
		Circulo c1 = new Circulo();
		Circulo c2 = new Circulo();
		c1.setRadio(8);
		c2.setRadio(14);
		System.out.println("Área del círculo 1: " + c1.calcularArea());
		System.out.println("Área del círculo 2: " + c2.calcularArea());
	}

}
