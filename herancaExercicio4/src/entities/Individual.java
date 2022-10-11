package entities;

public class Individual extends TaxPlayer {

	private double gastosSaude;

	public Individual() {
		super();
	}

	public Individual(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double taxa() {
		
		// Operador condicional ternário
		// double impostoBasico = (getRendaAnual() < 20000.0) ? getRendaAnual() * 0.15 :
		// getRendaAnual() * 0.25;

		double impostoBasico;
		if (getRendaAnual() < 20000.0) {
			impostoBasico = getRendaAnual() * 0.15;
		} else {
			impostoBasico = getRendaAnual() * 0.25;
		}
		impostoBasico -= getGastosSaude() * 0.5;
		if (impostoBasico < 0.0) {
			impostoBasico = 0.0; // Não há imposto negativo
		}
		return impostoBasico;

	}

}
