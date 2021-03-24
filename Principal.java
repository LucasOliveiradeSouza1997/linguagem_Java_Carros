package crud_veiculo_carapicuiba_poo_manha;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws SQLException {
		int op;
		String menu = "0-Sair\n1-Cadastrar\n2-Consultar pela Placa\n3-Remover pela Placa\n4-Remover pelo RENAVAM\n5-Listar\n6-Atualizar pela Placa";
		VeiculoDAO dao = new VeiculoDAO();
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
				case 0:
					JOptionPane.showMessageDialog(null, "Tchau");
					break;
				case 1:{
					String placa = JOptionPane.showInputDialog("Digite a placa");
					String renavam = JOptionPane.showInputDialog("Digite o renavam");
					String modelo = JOptionPane.showInputDialog("Digite o modelo");
					String marca = JOptionPane.showInputDialog("Digite a marca");
					String cor = JOptionPane.showInputDialog("Digite a cor");
					int anoFabricacao = Integer.parseInt (JOptionPane.
							showInputDialog("Digite o ano de Fabricação"));
					Veiculo veiculo = new Veiculo(placa,renavam,modelo,marca,cor,anoFabricacao);
					dao.cadastrar(veiculo);
					JOptionPane.showMessageDialog(null, "Ok, inseriu");
					break;
				}	
				case 2:{
					String placa = JOptionPane.showInputDialog("Digite a placa");
					Veiculo veiculo = new Veiculo(placa);
					Veiculo veiculo2 = dao.consultar(veiculo);
					JOptionPane.showMessageDialog(null, veiculo2);
					break;
				}
				case 3:{
					String placa = JOptionPane.showInputDialog("Digite a placa do veiculo");
					Veiculo veiculo = new Veiculo (placa);
					dao.removerPelaPlaca(veiculo);
					JOptionPane.showMessageDialog(null, "Veiculo apagado com sucesso");
					break;
				}
				case 4:{
					String renavam = JOptionPane.showInputDialog("Digite o RENAVAM do veiculo");
					Veiculo veiculo = new Veiculo (renavam,"");
					dao.removerPeloRenavam(veiculo);
					JOptionPane.showMessageDialog(null, "Veiculo apagado com sucesso");
					break;
				}
				case 5:{
					List <Veiculo> veiculos = dao.listar();
					JOptionPane.showMessageDialog(null, veiculos);
					break;
				}
				case 6:{
					String renavam = JOptionPane.showInputDialog("Digite o renavam");
					String modelo = JOptionPane.showInputDialog("Digite o modelo");
					String marca = JOptionPane.showInputDialog("Digite a marca");
					String cor = JOptionPane.showInputDialog("Digite a cor");
					int anoFabricacao = Integer.parseInt (JOptionPane.
							showInputDialog("Digite o ano de Fabricação"));
					String placa = JOptionPane.showInputDialog("Qual a placa do veiculo?");
					Veiculo veiculo = new Veiculo(placa,renavam,modelo,marca,cor,anoFabricacao);
					dao.atualizar(veiculo);
					JOptionPane.showMessageDialog (null, "Atualizou");
					break;
				}
				
			}
		}while (op != 0);
	}

}
