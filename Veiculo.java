package crud_veiculo_carapicuiba_poo_manha;

public class Veiculo {
	
	private String placa, renavam, modelo, marca, cor;
	private int anoFabricacao;
	public Veiculo(String placa, String renavam, String modelo, String marca, String cor, int anoFabricacao) {
		setPlaca(placa);
		setRenavam(renavam);
		setModelo(modelo);
		setMarca(marca);
		setCor(cor);
		setAnoFabricacao(anoFabricacao);
	}
	public Veiculo() {
	}
	public Veiculo(String placa) {
		setPlaca(placa);
	}
	public Veiculo(String renavam, String a) {
		setRenavam(renavam);
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Veiculo [placa=");
		builder.append(placa);
		builder.append(", renavam=");
		builder.append(renavam);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", cor=");
		builder.append(cor);
		builder.append(", anoFabricacao=");
		builder.append(anoFabricacao);
		builder.append("]");
		return builder.toString();
	}
}	