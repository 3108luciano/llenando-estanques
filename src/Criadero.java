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
		float volumenCa�o = 0;
		int cantTanques = 0;
		float alturaultimo = 0;

		while (i < estanques.size() && volumen > 0) {

			if (i == estanques.size() - 1) {
				EstanqueBase est2 = (EstanqueBase) estanques.get(i);
				volumenCa�o = (est2.getProfundidadEstanque() - alturaultimo) * est2.getSuperficie();
				cantTanques++;
				alturaCa�o = ((volumen) * (est2.getProfundidadEstanque() - alturaultimo)) / volumenCa�o;

				if (volumen > (est2.getProfundidadEstanque() * est2.getSuperficie())) {
					alturaultimo = est2.getProfundidadEstanque() - alturaultimo;
					estanques.get(i).setAlturaAgua(alturaultimo);
				} else {
					estanques.get(i).setAlturaAgua(alturaCa�o);
				}

				break;
			}

			Estanque est = (Estanque) estanques.get(i);
			volumenCa�o = (est.getProfundidadEstanque() - est.getProfundidadCa�o()) * est.getSuperficie();
			alturaCa�o = est.getProfundidadEstanque() - est.getProfundidadCa�o();

			if (volumen > 0) {
				cantTanques++;
				volumen -= volumenCa�o;
				alturaCa�o = Math.abs(volumen) / est.getSuperficie();
				estanques.get(i).setAlturaAgua(alturaCa�o);
				alturaultimo = est.getProfundidadCa�o();
			}

			i++;

		}

		for (i = estanques.size() - 1; i >= cantTanques; i--) {
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
