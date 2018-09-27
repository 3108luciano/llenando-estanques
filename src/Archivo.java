import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Archivo {

	public static Criadero leer(String path) throws FileNotFoundException {

		int profundidadCaño = 0;

		Scanner sc = new Scanner(new File(path));

		LinkedList<EstanqueAbstracta> estanques = new LinkedList<EstanqueAbstracta>();
		int cantEstanques = sc.nextInt();

		int i = 0;
		while (i < (cantEstanques - 1)) {
			estanques.add(new Estanque(sc.nextInt(), sc.nextInt(), profundidadCaño = sc.nextInt()));
			System.out.println(estanques.get(i).getSuperficie() + " " + estanques.get(i).getProfundidadEstanque() + " "
					+ ((Estanque) (estanques.get(i))).getProfundidadCaño());

			i++;
		}

		estanques.add(new EstanqueBase(sc.nextInt(), sc.nextInt()));
		int volumenEstanque = sc.nextInt();

		System.out.println(estanques.get(i).getSuperficie() + " " + estanques.get(i).getProfundidadEstanque());
		System.out.println(volumenEstanque);

		return new Criadero(estanques, volumenEstanque);
	}

	public static void escribir(String path, Criadero criadero) throws FileNotFoundException {

		PrintWriter salida = new PrintWriter(new File(path));
		
		if (criadero.getDesborde() != null) {
			
			salida.println(criadero.getDesborde());
			
		} else {
			
			salida.println(criadero.getEstanquesLlenos());
	
			for (int i = 0; i < criadero.getEstanques().size(); i++) {

				salida.println((i + 1) + " " + (int) (criadero.getEstanques().get(i).getAlturaAgua()));
			}
		}

		salida.close();
	}
}
