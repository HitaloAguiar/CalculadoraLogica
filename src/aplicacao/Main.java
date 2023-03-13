package aplicacao;

import java.util.Scanner;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	
	Equacao equacao = new Equacao();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		boolean retorno = false;
		
		do {
			
			main.equacao.setCodigoIdentificador(25);
			main.equacao.setBackupCodigoIdentificador(25);
		
			main.insercaoDaEquacao();
			
			main.resolucaoValoracaoOuTabela();			
			
			retorno = main.novaEquacao();
		}
		while(retorno == true);
		
		System.out.println("\n\nPROGRAMA DO HÍTALO AGUIAR E DO LUIS FELIPE");
	}
	
	public void insercaoDaEquacao () {
		
		boolean flag;
		
		int indice = 0, retorno;
		
		equacao.quantVariavel();
		
		do {
			
			flag = equacao.montagemEquacao(indice);
			
			do {
			
				System.out.println("\n Deseja finalizar a equação?");
				System.out.println("\n 1 - Sim\t\t 2 - Não");
				retorno = Main.scan.nextInt();
			}
			while(retorno != 1 && retorno != 2);
			
			if (retorno == 1 && equacao.getFlagParentese() != equacao.getFlagParenteseFechado()) {
				
				System.out.println("Você não pode finalizar a equação com um parêntese aberto");
				retorno = 2;
			}
			
			if (!flag)
				indice++;
		}
		while(retorno == 2);
	}
	
	public void resolucaoDaEquacao () {
		
		boolean flagResolucao;
		
		do {
								
			equacao.agrupandoOperacoes();
			
			equacao.resolvendoOperacao();
			
			equacao.gerandoCodigoSaida();
			
			flagResolucao = equacao.verificaResolucao();
		}
		while(flagResolucao == false);
	}
	
	public void resolucaoValoracaoOuTabela () {
		
		if (valoracaoOuTabela() == 1) {
		
			equacao.valoracaoVariaveis();
			
			resolucaoDaEquacao();
			
			imprimirResultadoValoracao();
		}
		
		else {
			
			equacao.setTabelaVerdade();
			
			for (int i = 0; i < equacao.getTabelaVerdade(); i++) {
				
				equacao.valoracaoTabelaVerdade(i);
				
				resolucaoDaEquacao();
				
				equacao.insercaoLinhaTabela(i);
				
				equacao.getBackup();
			}
			
			imprimirTabelaVerdade();
			
			//(p + q -> ~r) -> s
		}
	}
	
	public boolean novaEquacao () {
		
		int escolha;
		
		do {
			
			System.out.println("\n Deseja resolver outra equação?");
			System.out.println("\n 1 - Sim\t\t 2 - Não");
			escolha = Main.scan.nextInt();
		}
		while(escolha != 1 && escolha != 2);
		
		if (escolha == 1) {
			
			equacao.setCodigoIdentificador(null);
			equacao.setBackupCodigoIdentificador(null);
			equacao.setTabelaVerdade(null);
			equacao.setCodigoDeOperacao(null);
			equacao.setEquacaoTranscrita(null);
			equacao.setFlagParentese(0);
			equacao.setFlagParenteseFechado(0);
			equacao.setQuantVariaveis(0);
			equacao.setVariaveis(null);
			equacao.setFlagSaidaParentese(0);
			
			return true;
		}
		
		else
			return false;
	}
	
	public int valoracaoOuTabela () {
		
		int resposta;
		
		do {
		
			System.out.println("\n O que deseja fazer com esta equação?");
			System.out.println("\n 1 - Atribuir uma valoração às variáveis\t\t 2 - Gerar tabela verdade");
			resposta = Main.scan.nextInt();
		}
		while (resposta != 1 && resposta != 2);
		
		return resposta;
	}
	
	public void imprimirResultadoValoracao () {
		
		switch (equacao.getVariaveis().length) {
		
			case 2:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | S |");
				System.out.println("-------------");
				
				equacao.imprimirValoracao();
			break;
			
			case 3:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | r | S |");
				System.out.println("-----------------");
				
				equacao.imprimirValoracao();
			break;
			
			case 4:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | r | s | S |");
				System.out.println("---------------------");
				
				equacao.imprimirValoracao();
			break;
		}
	}
	
	public void imprimirTabelaVerdade () {
		
		switch (equacao.getTabelaVerdade()) {
		
			case 4:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | S |");
				System.out.println("-------------");
			break;
			
			case 8:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | r | S |");
				System.out.println("-----------------");
				
				equacao.imprimirValoracao();
			break;
			
			case 16:
				
				System.out.printf("\n %s\n\n", equacao.getEquacaoTranscrita());
				
				System.out.println("| p | q | r | s | S |");
				System.out.println("---------------------");
			break;
		}
		
		for (int i = 0; i < equacao.getTabelaVerdade(); i++) {
			
			equacao.imprimirTabelaVerdade(i);
		}
	}
}