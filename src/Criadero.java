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
		float alturaCa�o = 0;

		for (EstanqueAbstracta est : estanques) {
			capacidad += est.getSuperficie() * est.getProfundidadEstanque();
		}

		if (capacidad < volumen) {

			this.setDesborde("hay desborde: " + Integer.toString((volumen - capacidad)));
			return this;

		}

		int i = 0;
		int volumenCa�o = 0;
		int cantTanques = 0;
		int alturaUltimoEst = 0;

		while (i < estanques.size() - 1 && volumen >= volumenCa�o) {

			Estanque est = (Estanque) estanques.get(i);
			volumenCa�o = (est.getProfundidadEstanque() - est.getProfundidadCa�o()) * est.getSuperficie();
			alturaCa�o = est.getProfundidadEstanque() - est.getProfundidadCa�o();

			if (volumen >= volumenCa�o) {
				cantTanques++;
				volumen -= volumenCa�o;
				estanques.get(i).setAlturaAgua(alturaCa�o);

			} else {
				int auxvol = 0;
				auxvol = volumenCa�o;
				cantTanques++;
				volumen -= volumenCa�o;
				alturaCa�o = ((-volumen) * alturaCa�o) / volumenCa�o;
				estanques.get(i).setAlturaAgua(alturaCa�o);

			}

			i++;
		}

		Estanque est = (Estanque) estanques.get(i);
		volumenCa�o = (est.getProfundidadEstanque() - est.getProfundidadCa�o()) * est.getSuperficie();

		if (volumen >= volumenCa�o) {

			cantTanques++;
			volumen -= volumenCa�o;
			estanques.get(i).setAlturaAgua(alturaCa�o);
		}

			if (volumen > 0) {

				cantTanques++;
				alturaUltimoEst = est.getProfundidadCa�o();
				i++;
				alturaCa�o = ((-volumen) * alturaCa�o) / volumenCa�o;
				estanques.get(i).setAlturaAgua(alturaCa�o);
				
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
