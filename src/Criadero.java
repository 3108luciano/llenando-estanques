import java.util.LinkedList;

public class Criadero {

	private LinkedList<EstanqueAbstracta> estanques;
	private int volumen;
	private String desborde;
	private int estanquesLlenos;
	

	public Criadero(LinkedList<EstanqueAbstracta> estanques, int volumen) {
		this.volumen = volumen;
		this.estanques = estanques;
	}

	public Criadero resolver() {

		
		int capacidad = 0;
		float alturaCaño = 0;

		for (EstanqueAbstracta est : estanques) {
			capacidad += est.getSuperficie() * est.getProfundidadEstanque();
		}

		if (capacidad < volumen) {

			this.setDesborde("hay desborde: " + Integer.toString((volumen - capacidad)));
			return this;

		}

		int i = 0;
		int volumenCaño = 0;
		int cantTanques = 0;
		int alturaUltimoEst = 0;

		while (i < estanques.size() - 1 && volumen >= volumenCaño) {

			Estanque est = (Estanque) estanques.get(i);
			volumenCaño = (est.getProfundidadEstanque() - est.getProfundidadCaño()) * est.getSuperficie();
			alturaCaño = est.getProfundidadEstanque() - est.getProfundidadCaño();

			if (volumen >= volumenCaño) {
				cantTanques++;
				volumen -= volumenCaño;
				estanques.get(i).setAlturaAgua(alturaCaño);

			} else {
				int auxvol = 0;
				auxvol = volumenCaño;
				cantTanques++;
				volumen -= volumenCaño;
				alturaCaño = ((-volumen) * alturaCaño) / volumenCaño;
				estanques.get(i).setAlturaAgua(alturaCaño);

			}

			i++;
		}

		Estanque est = (Estanque) estanques.get(i);
		volumenCaño = (est.getProfundidadEstanque() - est.getProfundidadCaño()) * est.getSuperficie();

		if (volumen >= volumenCaño) {

			cantTanques++;
			volumen -= volumenCaño;
			estanques.get(i).setAlturaAgua(alturaCaño);
		}

			if (volumen > 0) {

				cantTanques++;
				alturaUltimoEst = est.getProfundidadCaño();
				i++;
				alturaCaño = ((-volumen) * alturaCaño) / volumenCaño;
				estanques.get(i).setAlturaAgua(alturaCaño);
				
			}
			
			for(i=estanques.size()-1;i>=cantTanques;i--) {
				estanques.remove(i);
			}
		
		this.setEstanquesLlenos(cantTanques);
		
		return this;

	}

	public LinkedList<EstanqueAbstracta> getEstanques() {
		return estanques;
	}

	public void setEstanques(LinkedList<EstanqueAbstracta> estanques) {
		this.estanques = estanques;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getDesborde() {
		return desborde;
	}

	public void setDesborde(String desborde) {
		this.desborde = desborde;
	}

	public int getEstanquesLlenos() {
		return estanquesLlenos;
	}

	public void setEstanquesLlenos(int estanquesLlenos) {
		this.estanquesLlenos = estanquesLlenos;
	}
}
