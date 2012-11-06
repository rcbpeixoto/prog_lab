package br.fbv.exe1;


public class VendedorCarreira extends Empregado {
	
	private double vendasMes;
	private double comissao;
	private double gratTempoServico;
	
	public VendedorCarreira() {
		this.gratTempoServico = 0;
	}
	
	public double getSalario(int tempoServicoAnos){
		return getSalarioFixo() + (vendasMes * comissao) + calcularGratTempoServico(tempoServicoAnos);
	}
	
	private double calcularGratTempoServico(int tempoServicoAnos) {
		int fator = (int) tempoServicoAnos / 3 ;
		return this.gratTempoServico * fator; 
	}

	public double getVendasMes() {
		return vendasMes;
	}

	public void setVendasMes(double vendasMes) {
		this.vendasMes = vendasMes;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	public double getGratTempoServico() {
		return gratTempoServico;
	}

	public void setGratTempoServico(double gratTempoServico) {
		this.gratTempoServico = gratTempoServico;
	}
	
	public static void main(String[] args) {
		VendedorCarreira vendedor1 = new VendedorCarreira();
		
		vendedor1.setMatricula("12345");
		vendedor1.setSalarioFixo(2000);
		vendedor1.setComissao(.10);
		vendedor1.setGratTempoServico(500);
		vendedor1.setVendasMes(30000);
		
		System.out.println("SALÁRIO DE VENDEDOR EM 3 ANOS DE SERVIÇO: " + vendedor1.getSalario(6));
	}
}
