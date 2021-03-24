package crud_veiculo_carapicuiba_poo_manha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

	public void cadastrar (Veiculo veiculo) {
		//1. Especificar o comando sql
		String sql = "INSERT INTO veiculo (placa,renavam,modelo,marca,cor,ano_fabricacao) VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		try{
			//2. Abrir o canal de comunicação, ou seja, fabricar uma conexão
			conn = ConnectionFactory.getConnection();
			//3. pré compilar o comando sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//4 Preencher os place holders
			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getRenavam());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getMarca());
			ps.setString(5, veiculo.getCor());
			ps.setInt(6, veiculo.getAnoFabricacao());
			//5 Executar o comando
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
	public void atualizar (Veiculo veiculo) {
		//1. Especificar o comando sql
		String sql = "UPDATE veiculo SET renavam = ?, modelo = ? , marca = ?, cor = ?, ano_fabricacao = ? WHERE placa = ?";
		//2 Abrir a conexao
		//3 Pre compilar o comando sql
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			//4 Preencher os place holders
			ps.setString(1, veiculo.getRenavam());
			ps.setString(2, veiculo.getModelo());
			ps.setString(3, veiculo.getMarca());
			ps.setString(4, veiculo.getCor());
			ps.setInt(5, veiculo.getAnoFabricacao());
			ps.setString(6, veiculo.getPlaca());
			//5 executar
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void removerPelaPlaca (Veiculo veiculo) {
		//1 Especificar o comando sql
		String sql = "DELETE FROM veiculo WHERE placa = ?";
		//2 Abrir a conexão com o banco
		//3 Pré compilar o comando sql
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			//4 Preencher os place holders
			ps.setString(1, veiculo.getPlaca());
			//5 executar
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerPeloRenavam (Veiculo veiculo) {
		//1 Especificar o comando sql
		String sql = "DELETE FROM veiculo WHERE renavam = ?";
		//2 Abrir a conexão com o banco
		//3 Pré compilar o comando sql
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			//4 Preencher os place holders
			ps.setString(1, veiculo.getRenavam());
			//5 executar
			ps.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Veiculo consultar (Veiculo veiculo){

		String sql = "SELECT * FROM veiculo WHERE placa = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				){
				ps.setString(1, veiculo.getPlaca());
				ResultSet rs = ps.executeQuery();
				rs.next();
				String placa = rs.getString("placa");
				String renavam = rs.getString ("renavam");
				String modelo = rs.getString("modelo");
				String marca = rs.getString ("marca");
				String cor = rs.getString ("cor");
				int anoFabricacao = rs.getInt("ano_fabricacao");
				Veiculo veiculo2 = new Veiculo(placa,renavam,modelo,marca,cor,anoFabricacao);
				return veiculo2;
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculo;	
	}
	

	public List <Veiculo> listar (){
		List <Veiculo> veiculos = new ArrayList <> ();
		
		String sql = "SELECT * FROM veiculo";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					String placa = rs.getString("placa");
					String renavam = rs.getString ("renavam");
					String modelo = rs.getString("modelo");
					String marca = rs.getString ("marca");
					String cor = rs.getString ("cor");
					int anoFabricacao = rs.getInt("ano_fabricacao");
					Veiculo veiculo = new Veiculo (placa,renavam,modelo,marca,cor,anoFabricacao);
					veiculos.add(veiculo);
				}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculos;	
	}
	
	
	
	
	
	
	
	
	
}
