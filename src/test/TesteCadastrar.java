package test;

import java.util.Date;

import control.Atleta;
import model.MAtleta;

public class TesteCadastrar {

	public static void main(String[] args) {
		
		Atleta a = new Atleta("gabriel", "60000000000", 29, new Date("10/06/1990"), "masculino", "Rua Desenhista Luís Guimarães", "Rio de Janeiro", "Rio de Janeiro", "33255499", "gflamen@gmail.com", "gflamen", "132313", "RX", true);
		
		MAtleta ma = new MAtleta();
		if(ma.cadastrar(a)) {
			System.out.print("cadastrado com sucesso");
		}else {
			System.out.print("erroooooo");
		}
	}

}
