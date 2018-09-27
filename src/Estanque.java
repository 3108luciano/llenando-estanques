
public class Estanque  extends EstanqueAbstracta{

	
	private int profundidadCaño;
	
	public Estanque(int superficie, int profundidadTanque, int profundidadCaño) {
		super(superficie,profundidadTanque);
		this.profundidadCaño = profundidadCaño;
	}

	public int getProfundidadCaño() {
		return profundidadCaño;
	}
}
