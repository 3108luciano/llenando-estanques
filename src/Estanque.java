
public class Estanque  extends EstanqueAbstracta{

	
	private int profundidadCa�o;
	
	public Estanque(int superficie, int profundidadTanque, int profundidadCa�o) {
		super(superficie,profundidadTanque);
		this.profundidadCa�o = profundidadCa�o;
	}

	public int getProfundidadCa�o() {
		return profundidadCa�o;
	}
}
