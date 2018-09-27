import java.io.FileNotFoundException;

public class App {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		Criadero criadero = Archivo.leer("src/estanques.in");
		criadero = criadero.resolver();
		Archivo.escribir("src/estanques.out",criadero);
	}
}
