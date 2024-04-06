package gerenciamento.backEnd;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome; 
	private String endereco; 
	private float creditoDisponivel; 
	private float divida; 
	List <Venda> compras = new ArrayList<>();
}
