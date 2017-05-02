package herencia.Ejemplo1;

public class Main {

	public static void main(String[] args) {
		Empleado[] empleados = new Empleado[4];
		empleados[0] = new Empleado("José", 1500);
		empleados[1] = new Empleado("Maria",23000);
		empleados[2] = new Empleado("Pablo",8500);
		empleados[3] = new Jefatura("Pedro",35000);

		for (Empleado empleado : empleados) {
			System.out.println(empleado.getNombre());
			System.out.println(empleado.getSueldo());
			System.out.println(empleado.getIdentificador());
		}
		
		Jefatura jefe = new Jefatura("Pedro",35000);
		System.out.println(jefe.getNombre());
		System.out.println(jefe.getSueldo());
	}

}
