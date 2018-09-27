import java.util.LinkedList;

public class EstanqueAbstracta {

	private int superficie;
	private int profundidadEstanque;
	private float alturaAgua;

	

	public float getAlturaAgua() {
		return Math.round(alturaAgua);
	}

	public void setAlturaAgua(float alturaAgua) {
		this.alturaAgua = alturaAgua;
	}

	public EstanqueAbstracta(int superficie, int profundidadEstanque) {
		this.superficie = superficie;
		this.profundidadEstanque = profundidadEstanque;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getProfundidadEstanque() {
		return profundidadEstanque;
	}
}
