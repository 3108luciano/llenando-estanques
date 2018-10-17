import java.util.LinkedList;

public class EstanqueAbstracta {

	private float superficie;
	private float profundidadEstanque;
	private float alturaAgua;

	public EstanqueAbstracta(float superficie, float profundidadEstanque) {
		this.superficie = superficie;
		this.profundidadEstanque = profundidadEstanque;
	}

	public float getAlturaAgua() {
		return Math.round(alturaAgua);
	}

	public void setAlturaAgua(float alturaAgua) {
		this.alturaAgua = alturaAgua;
	}

	public float getSuperficie() {
		return superficie;
	}

	public float getProfundidadEstanque() {
		return profundidadEstanque;
	}
}
