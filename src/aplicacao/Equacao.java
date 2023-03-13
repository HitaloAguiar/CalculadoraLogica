package aplicacao;

public class Equacao {
	
	private String equacaoTranscrita;
	
	private String[] codigoIdentificador;
	
	private String[] backupCodigoIdentificador;
	
	// 	00-00-0
	
	/*
	 vetorEquacao[0] recebe a operação lógica a ser realizada
	 vetorEquacao[1] indica se a operação tem prioridade (se está entre parênteses), e em qual parêntese está
	 
	 vetorEquacao[2] recebe a variável
	 vetorEquacao[3] indica se a variável está negada ou não		 
	*/
	
	private String codigoDeOperacao;
	
	//	0-00-0-00
	
	private boolean saida;
	
	private int flagParentese = 0, flagParenteseFechado = 0, quantVariaveis;
	
	private boolean[] variaveis;
	
	private boolean[][] tabelaVerdade;
	
	private int flagSaidaParentese = 0;
	
	// 2 variaveis
	
	// [] [] [saida]
	
	
	
	public int getTabelaVerdade() {
		return tabelaVerdade.length;
	}

	public int getFlagSaidaParentese() {
		return flagSaidaParentese;
	}

	public void setFlagSaidaParentese(int flagSaidaParentese) {
		this.flagSaidaParentese = flagSaidaParentese;
	}

	public String getEquacaoTranscrita() {
		return equacaoTranscrita;
	}

	public void setEquacaoTranscrita(String equacaoTranscrita) {
		this.equacaoTranscrita = equacaoTranscrita;
	}

	public int getFlagParentese() {
		return flagParentese;
	}

	public void setFlagParentese(int flagParentese) {
		this.flagParentese = flagParentese;
	}

	public int getFlagParenteseFechado() {
		return flagParenteseFechado;
	}

	public void setFlagParenteseFechado(int flagParenteseFechado) {
		this.flagParenteseFechado = flagParenteseFechado;
	}

	public String[] getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public String[] getBackupCodigoIdentificador() {
		return backupCodigoIdentificador;
	}

	public void setBackupCodigoIdentificador(String[] backupCodigoIdentificador) {
		this.backupCodigoIdentificador = backupCodigoIdentificador;
	}

	public void setCodigoIdentificador(String[] codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}

	public void setCodigoIdentificador(int i) {
		this.codigoIdentificador = new String[i];
	}
	
	public void setBackupCodigoIdentificador(int i) {
		this.backupCodigoIdentificador = new String[i];
	}
	
	public boolean[] getVariaveis() {
		return variaveis;
	}

	public void setVariaveis(boolean[] variaveis) {
		this.variaveis = variaveis;
	}
	
	public String getCodigoDeOperacao() {
		return codigoDeOperacao;
	}

	public void setCodigoDeOperacao(String codigoDeOperacao) {
		this.codigoDeOperacao = codigoDeOperacao;
	}

	public int getQuantVariaveis() {
		return quantVariaveis;
	}

	public void setQuantVariaveis(int quantVariaveis) {
		this.quantVariaveis = quantVariaveis;
	}

	public void quantVariavel () {
		
		do {
			
			System.out.println("Quantas variáveis a equação terá?(Máximo de 4 variáveis e mínimo de 2)");
			quantVariaveis = Main.scan.nextInt();
		}
		while(quantVariaveis < 2 || quantVariaveis > 4);
		
		variaveis = new boolean[quantVariaveis];		
	}
	
	public void setTabelaVerdade () {
		
		int indice = 2;
		
		for (int i = 1; i < quantVariaveis; i++) {
			
			indice *= 2;
		}
		
		tabelaVerdade = new boolean[indice][quantVariaveis+1];
	}

	public void setTabelaVerdade (boolean[][] tabelaVerdade) {
		
		this.tabelaVerdade = tabelaVerdade;
	}
	
	public void valoracaoVariaveis () {
		
		int flag = 0, escolha;
		
		for (int i = 0; i < quantVariaveis; i++) {
			
			do {
				
				if (flag > 0)
					System.out.println("Número digitado é inválido");
				
				switch (i) {
				
					case 0:
						
						System.out.print("\n Escolha a valoração que a variável [p] irá receber (V ou F):");
					break;
					
					case 1:
						
						System.out.print("\n Escolha a valoração que a variável [q] irá receber (V ou F):");
					break;
					
					case 2:
						
						System.out.print("\n Escolha a valoração que a variável [r] irá receber (V ou F):");
					break;
					
					case 3:
						
						System.out.print("\n Escolha a valoração que a variável [s] irá receber (V ou F):");
					break;
				}				
					
				System.out.print("\n  1 - Verdadeiro\t\t\t 2 - Falso\n");
				escolha = Main.scan.nextInt();
				
				flag++;
			}
			while(escolha < 1 || escolha > 2);
			
			flag = 0;
			
			if (escolha == 1)
				variaveis[i] = true;
			
			else
				variaveis[i] = false;
			
		}
	}
	
	public void valoracaoTabelaVerdade (int indice) {
		
		switch (tabelaVerdade.length) {
		
			case 4:
			
				switch (indice) {
				
					case 0:
						
						variaveis[0] = true;
						variaveis[1] = true;
					break;
					
					case 1:
						
						variaveis[0] = true;
						variaveis[1] = false;
					break;
						
					case 2:
						
						variaveis[0] = false;
						variaveis[1] = true;
					break;
						
					case 3:
						
						variaveis[0] = false;
						variaveis[1] = false;
					break;						
				}
			break;
			
			case 8:
				
				switch (indice) {
				
					case 0:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = true;
					break;
					
					case 1:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = false;
					break;
						
					case 2:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = true;
					break;
						
					case 3:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = false;
					break;
					
					case 4:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = true;
					break;
						
					case 5:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = false;
					break;
						
					case 6:
						
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = true;
					break;
						
					case 7:
						
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = false;
					break;
						
				}
			break;
			
			case 16:
				
				switch (indice) {
				
					case 0:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = true;
						variaveis[3] = true;
					break;
					
					case 1:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = true;
						variaveis[3] = false;
					break;
						
					case 2:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = false;
						variaveis[3] = true;
					break;
						
					case 3:
						
						variaveis[0] = true;
						variaveis[1] = true;
						variaveis[2] = false;
						variaveis[3] = false;
					break;
					
					case 4:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = true;
						variaveis[3] = true;
					break;
						
					case 5:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = true;
						variaveis[3] = false;
					break;
						
					case 6:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = false;
						variaveis[3] = true;
					break;
						
					case 7:
						
						variaveis[0] = true;
						variaveis[1] = false;
						variaveis[2] = false;
						variaveis[3] = false;
					break;
					
					case 8:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = true;
						variaveis[3] = true;
					break;
						
					case 9:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = true;
						variaveis[3] = false;
					break;
						
					case 10:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = false;
						variaveis[3] = true;
					break;
						
					case 11:
						
						variaveis[0] = false;
						variaveis[1] = true;
						variaveis[2] = false;
						variaveis[3] = false;
					break;
						
					case 12:
						
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = true;
						variaveis[3] = true;
					break;
						
					case 13:
						
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = true;
						variaveis[3] = false;
					break;
						
					case 14:
					
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = false;
						variaveis[3] = true;
					break;
						
					case 15:
						
						variaveis[0] = false;
						variaveis[1] = false;
						variaveis[2] = false;
						variaveis[3] = false;
					break;
						
				}
			break;
		}
	}
	
	public boolean montagemEquacao (int indice) {
		
		int flag = 0;
		
		boolean fine = false, flagOpen = false;
		
		int[] vetorEquacao = new int[4];
		
		if (flagParentese != flagParenteseFechado)
			vetorEquacao[1] = flagParentese;
		
		if (indice != 0) {
		
			do {
				
				if (flag > 0)
					System.out.println("Número digitado é inválido");
				
				System.out.print("\n  --------------------- Montagem da equação lógica ----------------------\n");
				System.out.print("\n  Escolha a operação que será realizada:\n");
				
				if (flagParenteseFechado != flagParentese)
					System.out.print("\n  1 - OU\t\t 2 - E\t\t3 - SE ENTÃO\n\n  4 - SE SOMENTE SE\t\t 5 - Fechar Parêntese\n");
				
				else
					System.out.print("\n  1 - OU\t\t 2 - E\t\t3 - SE ENTÃO\n\n  4 - SE SOMENTE SE\n");
				
				vetorEquacao[0] = Main.scan.nextInt();
				
				if (vetorEquacao[0] == 5 && flagParenteseFechado != flagParentese) {
					flagParenteseFechado++;
					fine = true;
					break;
				}
				
				else
					flag++;
			}
			while(vetorEquacao[0] < 1 || vetorEquacao[0] > 4);
			
			flag = 0;
		}
		
		do {
			
			if (fine == true)
				break;
			
			if (flag > 0)
				System.out.println("Número digitado é inválido");
			
			System.out.print("\n  --------------------- Montagem da equação lógica ----------------------\n");
			if (indice != 0)
				System.out.print("\n  Escolha a variável:\n");
			
			else
				System.out.print("\n  Escolha a variável inicial:\n");
			
			switch (quantVariaveis) {
			
				case 2:
					
					if (flagParenteseFechado == flagParentese)				
						System.out.print("\n  1 - p\t\t 2 - q\t\t  3 - Abrir Parêntese\n");
					
					else
						System.out.print("\n  1 - p\t\t 2 - q\n");
				break;
				
				case 3:
					
					if (flagParenteseFechado == flagParentese)				
						System.out.print("\n  1 - p\t\t 2 - q\t\t 3 - r\n\n  4 - Abrir Parêntese\n");
					
					else
						System.out.print("\n  1 - p\t\t 2 - q\t\t3 - r\n");
				break;
				
				case 4:
					
					if (flagParenteseFechado == flagParentese)				
						System.out.print("\n  1 - p\t\t 2 - q\t\t 3 - r\n\n  4 - s\t\t 5 - Abrir Parêntese\n");
					
					else
						System.out.print("\n  1 - p\t\t 2 - q\t\t3 - r\n\n  4 - s\n");
				break;
			}
			
			vetorEquacao[2] = Main.scan.nextInt();
			
			switch (quantVariaveis) {
			
				case 2:
					
					if (vetorEquacao[2] == 3 && flagParenteseFechado == flagParentese) {
						
						flagParentese++;
						vetorEquacao[1] = flagParentese;
						flagOpen = true;
					}
						
					else
						flag++;
				break;
				
				case 3:
					
					if (vetorEquacao[2] == 4 && flagParenteseFechado == flagParentese) {
						
						flagParentese++;
						vetorEquacao[1] = flagParentese;
						flagOpen = true;
					}
						
					else
						flag++;
				break;
				
				case 4:
					
					if (vetorEquacao[2] == 5 && flagParenteseFechado == flagParentese) {
						
						flagParentese++;
						vetorEquacao[1] = flagParentese;
						flagOpen = true;
					}
						
					else
						flag++;
				break;
			}
		}
		while(vetorEquacao[2] < 1 || vetorEquacao[2] > quantVariaveis);
		
		flag = 0;
		
		do {
			
			if (fine == true)
				break;
			
			if (flag > 0)
				System.out.println("Número digitado é inválido");
			
			System.out.print("\n Escolha se a variável será negada ou não:");
			
			if (vetorEquacao[2] == 1)
				System.out.print("\n  1 - p\t\t\t 2 - ~p\n");
			
			else if (vetorEquacao[2] == 2)
				System.out.print("\n  1 - q\t\t\t 2 - ~q\n");
			
			else if (vetorEquacao[2] == 3)
				System.out.print("\n  1 - r\t\t\t 2 - ~r\n");
			
			else if (vetorEquacao[2] == 4)
				System.out.print("\n  1 - s\t\t\t 2 - ~s\n");
			
			vetorEquacao[3] = Main.scan.nextInt();
			
			flag++;
		}
		while(vetorEquacao[3] < 1 || vetorEquacao[3] > 2);
		
		flag = 0;
		
		if (flagParentese != flagParenteseFechado) {
			
			codigoIdentificador[indice] = Integer.toString(vetorEquacao[0]) + Integer.toString(vetorEquacao[1]) + "-" + Integer.toString(vetorEquacao[2]) + Integer.toString(vetorEquacao[3]) + "-0";
			backupCodigoIdentificador[indice] = Integer.toString(vetorEquacao[0]) + Integer.toString(vetorEquacao[1]) + "-" + Integer.toString(vetorEquacao[2]) + Integer.toString(vetorEquacao[3]) + "-0";
		}
			
		else if (fine == false) {
			
			codigoIdentificador[indice] = Integer.toString(vetorEquacao[0]) + "0-" + Integer.toString(vetorEquacao[2]) + Integer.toString(vetorEquacao[3])  + "-0";
			backupCodigoIdentificador[indice] = Integer.toString(vetorEquacao[0]) + "0-" + Integer.toString(vetorEquacao[2]) + Integer.toString(vetorEquacao[3])  + "-0";
		}
		
		anotarEquacao(indice, fine, flagOpen);
			
		return fine;
	}
	
	public void anotarEquacao (int indice, boolean fine, boolean flagOpen) {
		
		if (fine) {
			
			equacaoTranscrita += ")";
		}
		
		else {
		
			switch (codigoIdentificador[indice].charAt(0)) {
			
				case '0':
					
					switch (codigoIdentificador[indice].charAt(1)) {
					
						case '0':
							
							switch (codigoIdentificador[indice].charAt(3)) {
							
								case '1':
									
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita = "p";
										break;
										
										case '2':
											
											equacaoTranscrita = "~p";
										break;
									}
								break;
							
								case '2':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita = "q";
										break;
										
										case '2':
											
											equacaoTranscrita = "~q";
										break;
									}
								break;
								
								case '3':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita = "r";
										break;
										
										case '2':
											
											equacaoTranscrita = "~r";
										break;
									}
								break;
								
								case '4':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita = "s";
										break;
										
										case '2':
											
											equacaoTranscrita = "~s";
										break;
									}
								break;							
							}
						break;
						
						default:
							
							if (flagOpen == true) {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita = "(p";
											break;
											
											case '2':
												
												equacaoTranscrita = "(~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita = "(q";
											break;
											
											case '2':
												
												equacaoTranscrita = "(~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita = "(r";
											break;
											
											case '2':
												
												equacaoTranscrita = "(~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita = "(s";
											break;
											
											case '2':
												
												equacaoTranscrita = "(~s";
											break;
										}
									break;							
								}					
							}						
						break;
					}
				break;
				
				case '1':
					
					switch (codigoIdentificador[indice].charAt(1)) {
					
						case '0':
							
							switch (codigoIdentificador[indice].charAt(3)) {
							
								case '1':
									
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " + p";
										break;
										
										case '2':
											
											equacaoTranscrita += " + ~p";
										break;
									}
								break;
							
								case '2':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " + q";
										break;
										
										case '2':
											
											equacaoTranscrita += " + ~q";
										break;
									}
								break;
								
								case '3':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " + r";
										break;
										
										case '2':
											
											equacaoTranscrita += " + ~r";
										break;
									}
								break;
								
								case '4':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " + s";
										break;
										
										case '2':
											
											equacaoTranscrita += " + ~s";
										break;
									}
								break;							
							}
						break;
						
						default:
							
							if (flagOpen == true) {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + (p";
											break;
											
											case '2':
												
												equacaoTranscrita += " + (~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + (q";
											break;
											
											case '2':
												
												equacaoTranscrita += " + (~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + (r";
											break;
											
											case '2':
												
												equacaoTranscrita += " + (~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + (s";
											break;
											
											case '2':
												
												equacaoTranscrita += " + (~s";
											break;
										}
									break;							
								}					
							}
							
							else {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + p";
											break;
											
											case '2':
												
												equacaoTranscrita += " + ~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + q";
											break;
											
											case '2':
												
												equacaoTranscrita += " + ~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + r";
											break;
											
											case '2':
												
												equacaoTranscrita += " + ~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " + s";
											break;
											
											case '2':
												
												equacaoTranscrita += " + ~s";
											break;
										}
									break;							
								}
							}
						break;
					}
				break;
				
				case '2':
					
					switch (codigoIdentificador[indice].charAt(1)) {
					
						case '0':
							
							switch (codigoIdentificador[indice].charAt(3)) {
							
								case '1':
									
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " . p";
										break;
										
										case '2':
											
											equacaoTranscrita += " . ~p";
										break;
									}
								break;
							
								case '2':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " . q";
										break;
										
										case '2':
											
											equacaoTranscrita += " . ~q";
										break;
									}
								break;
								
								case '3':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " . r";
										break;
										
										case '2':
											
											equacaoTranscrita += " . ~r";
										break;
									}
								break;
								
								case '4':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " . s";
										break;
										
										case '2':
											
											equacaoTranscrita += " . ~s";
										break;
									}
								break;							
							}
						break;
						
						default:
							
							if (flagOpen == true) {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . (p";
											break;
											
											case '2':
												
												equacaoTranscrita += " . (~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . (q";
											break;
											
											case '2':
												
												equacaoTranscrita += " . (~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . (r";
											break;
											
											case '2':
												
												equacaoTranscrita += " . (~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . (s";
											break;
											
											case '2':
												
												equacaoTranscrita += " . (~s";
											break;
										}
									break;							
								}					
							}
							
							else {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . p";
											break;
											
											case '2':
												
												equacaoTranscrita += " . ~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . q";
											break;
											
											case '2':
												
												equacaoTranscrita += " . ~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . r";
											break;
											
											case '2':
												
												equacaoTranscrita += " . ~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " . s";
											break;
											
											case '2':
												
												equacaoTranscrita += " . ~s";
											break;
										}
									break;							
								}
							}
						break;
					}
				break;
				
				case '3':
					
					switch (codigoIdentificador[indice].charAt(1)) {
						
						case '0':
							
							switch (codigoIdentificador[indice].charAt(3)) {
							
								case '1':
									
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " -> p";
										break;
										
										case '2':
											
											equacaoTranscrita += " -> ~p";
										break;
									}
								break;
							
								case '2':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " -> q";
										break;
										
										case '2':
											
											equacaoTranscrita += " -> ~q";
										break;
									}
								break;
								
								case '3':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " -> r";
										break;
										
										case '2':
											
											equacaoTranscrita += " -> ~r";
										break;
									}
								break;
								
								case '4':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " -> s";
										break;
										
										case '2':
											
											equacaoTranscrita += " -> ~s";
										break;
									}
								break;							
							}
						break;
						
						default:
							
							if (flagOpen == true) {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> (p";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> (~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> (q";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> (~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> (r";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> (~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> (s";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> (~s";
											break;
										}
									break;							
								}					
							}
							
							else {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> p";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> ~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> q";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> ~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> r";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> ~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " -> s";
											break;
											
											case '2':
												
												equacaoTranscrita += " -> ~s";
											break;
										}
									break;							
								}
							}
						break;
					}
				break;
				
				case '4':
					
					switch (codigoIdentificador[indice].charAt(1)) {
					
						case '0':
							
							switch (codigoIdentificador[indice].charAt(3)) {
							
								case '1':
									
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " <-> p";
										break;
										
										case '2':
											
											equacaoTranscrita += " <-> ~p";
										break;
									}
								break;
							
								case '2':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " <-> q";
										break;
										
										case '2':
											
											equacaoTranscrita += " <-> ~q";
										break;
									}
								break;
								
								case '3':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " <-> r";
										break;
										
										case '2':
											
											equacaoTranscrita += " <-> ~r";
										break;
									}
								break;
								
								case '4':
								
									switch (codigoIdentificador[indice].charAt(4)) {
									
										case '1':
											
											equacaoTranscrita += " <-> s";
										break;
										
										case '2':
											
											equacaoTranscrita += " <-> ~s";
										break;
									}
								break;							
							}
						break;
						
						default:
							
							if (flagOpen == true) {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> (p";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> (~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> (q";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> (~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> (r";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> (~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> (s";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> (~s";
											break;
										}
									break;							
								}					
							}
							
							else {
								
								switch (codigoIdentificador[indice].charAt(3)) {
								
									case '1':
										
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> p";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> ~p";
											break;
										}
									break;
								
									case '2':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> q";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> ~q";
											break;
										}
									break;
									
									case '3':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> r";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> ~r";
											break;
										}
									break;
									
									case '4':
									
										switch (codigoIdentificador[indice].charAt(4)) {
										
											case '1':
												
												equacaoTranscrita += " <-> s";
											break;
											
											case '2':
												
												equacaoTranscrita += " <-> ~s";
											break;
										}
									break;							
								}
							}
						break;
					}
				break;
			}
		}
	}
	
	public void agrupandoOperacoes () {
		
		int flagSelecionado = 0, max = 0, contador = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0, flag = 0, indice = 0, indice2 = 0, flagSaida = 0, quantParentese = flagParentese;
		
		int indiceInicio = 0, indiceFinal = 0;
		
		String convert;
		
		char parenteseId;
		
		String[] operacao = new String[4];
		
		for (int i = 0; i < codigoIdentificador.length; i++) {
			
			if (codigoIdentificador[i] != null)
				max = i+1;
		}
		
		do {		
		
			if (quantParentese > 0) {
				
				convert = Integer.toString(quantParentese);
				
				parenteseId = convert.charAt(0);
			
				for (int i = 0; i < max; i++) {
					
					if (codigoIdentificador[i] != null)			
						if (codigoIdentificador[i].charAt(1) != '0') {
						
							if (codigoIdentificador[i].charAt(1) == parenteseId) {
							
								contador++;
							}
						}
				}
				
				if (contador == 2) {
					
					for (int i = 0; i < max; i++) {
						
						if (codigoIdentificador[i] != null)
							if (codigoIdentificador[i].charAt(1) == parenteseId) {
							
								if (flag == 0) {
									
									operacao[flag] = codigoIdentificador[i];
									flag++;
								}
								
								else if (flag == 1) {
								
									operacao[flag] = codigoIdentificador[i];
									flagSelecionado = 1;									
								}
									
								codigoIdentificador[i] = null;								
							}
					}
				}
				
				if (contador > 2) {
					
					for (int i = 0; i < max; i++) {
						
						if (codigoIdentificador[i] != null)
							if (codigoIdentificador[i].charAt(1) == parenteseId) {
							
								if (flag == 0)									
									indiceInicio = i;									
																
								else if (flag == (contador-1)) {
									
									indiceFinal = i;
									break;
								}
								
								flag++;
							}
					}
					
					for (int i = indiceInicio; i <= indiceFinal; i++) {
						
						if (codigoIdentificador[i] != null)
							if (codigoIdentificador[i].charAt(0) == '2')
								contador2++;
					}
					
					if (contador2 > 0) {
						
						for (int i = indiceInicio; i <= indiceFinal; i++) {
							
							if (codigoIdentificador[i] != null)
								if (codigoIdentificador[i].charAt(0) == '2') {
									indice = i;
									break;
								}
						}
						
						for (int i = (indice-1); i >= 0; i--) {
							
							if (codigoIdentificador[i] != null) {
								
								indice2 = i;
								break;
							}						
						}
						
						operacao[0] = codigoIdentificador[indice2];
						codigoIdentificador[indice2] = null;
						
						operacao[1] = codigoIdentificador[indice];
						codigoIdentificador[indice] = null;
						flagSelecionado = 1;
						flagSaidaParentese = Character.digit(parenteseId, 10);
					}
					
					else if (contador2 == 0) {
						
						for (int i = indiceInicio; i <= indiceFinal; i++) {
							
							if (codigoIdentificador[i] != null)
								if (codigoIdentificador[i].charAt(0) == '1')
									contador3++;
						}
						
						if (contador3 > 0) {
							
							for (int i = indiceInicio; i <= indiceFinal; i++) {
								
								if (codigoIdentificador[i] != null)
									if (codigoIdentificador[i].charAt(0) == '1') {
										indice = i;
										break;
									}
							}
							
							for (int i = (indice-1); i >= 0; i--) {
								
								if (codigoIdentificador[i] != null) {
									
									indice2 = i;
									break;
								}						
							}
							
							operacao[0] = codigoIdentificador[indice2];
							codigoIdentificador[indice2] = null;
							
							operacao[1] = codigoIdentificador[indice];
							codigoIdentificador[indice] = null;
							flagSelecionado = 1;
							flagSaidaParentese = Character.digit(parenteseId, 10);
						}
						
						else if (contador3 == 0) {
							
							for (int i = indiceInicio; i <= indiceFinal; i++) {
								
								if (codigoIdentificador[i] != null)
									if (codigoIdentificador[i].charAt(0) == '3')
										contador4++;
							}
							
							if (contador4 > 0) {
								
								for (int i = indiceInicio; i <= indiceFinal; i++) {
									
									if (codigoIdentificador[i] != null)
										if (codigoIdentificador[i].charAt(0) == '3') {
											indice = i;
											break;
										}
								}
								
								for (int i = (indice-1); i >= 0; i--) {
									
									if (codigoIdentificador[i] != null) {
										
										indice2 = i;
										break;
									}						
								}
								
								operacao[0] = codigoIdentificador[indice2];
								codigoIdentificador[indice2] = null;
								
								operacao[1] = codigoIdentificador[indice];
								codigoIdentificador[indice] = null;
								flagSelecionado = 1;
								flagSaidaParentese = Character.digit(parenteseId, 10);
							}
							
							else if (contador4 == 0) {
								
								for (int i = indiceInicio; i <= indiceFinal; i++) {
									
									if (codigoIdentificador[i] != null)
										if (codigoIdentificador[i].charAt(0) == '4')
											contador5++;
								}
								
								if (contador5 > 0) {
									
									for (int i = indiceInicio; i <= indiceFinal; i++) {
										
										if (codigoIdentificador[i] != null)
											if (codigoIdentificador[i].charAt(0) == '4') {
												indice = i;
												break;
											}
									}
									
									for (int i = (indice-1); i >= 0; i--) {
										
										if (codigoIdentificador[i] != null) {
											
											indice2 = i;
											break;
										}						
									}
									
									operacao[0] = codigoIdentificador[indice2];
									codigoIdentificador[indice2] = null;
									
									operacao[1] = codigoIdentificador[indice];
									codigoIdentificador[indice] = null;
									
									flagSelecionado = 1;
									flagSaidaParentese = Character.digit(parenteseId, 10);
								}
							}
						}
					}
				}
			}	
			quantParentese--;
		}
		while(flagSelecionado == 0 && quantParentese > 0);
						
		if (contador == 0) {
			
			for (int i = 0; i < max; i ++) {
				
				if (codigoIdentificador[i] != null)
					if (codigoIdentificador[i].charAt(0) == '2')
						contador2++;
			}
			
			if (contador2 > 0) {
				
				for (int i = 0; i < max; i ++) {
					
					if (codigoIdentificador[i] != null)
						if (codigoIdentificador[i].charAt(0) == '2') {
							indice = i;
							break;
						}
				}
				
				for (int i = (indice-1); i >= 0; i--) {
					
					if (codigoIdentificador[i] != null) {
						
						indice2 = i;
						break;
					}						
				}
				
				operacao[0] = codigoIdentificador[indice2];
				codigoIdentificador[indice2] = null;
				
				operacao[1] = codigoIdentificador[indice];
				codigoIdentificador[indice] = null;								
			}
			
			else if (contador2 == 0) {
				
				for (int i = 0; i < max; i ++) {
					
					if (codigoIdentificador[i] != null)
						if (codigoIdentificador[i].charAt(0) == '1')
							contador3++;
				}
				
				if (contador3 > 0) {
					
					for (int i = 0; i < max; i ++) {
						
						if (codigoIdentificador[i] != null)
							if (codigoIdentificador[i].charAt(0) == '1') {
								indice = i;
								break;
							}
					}
					
					for (int i = (indice-1); i >= 0; i--) {
						
						if (codigoIdentificador[i] != null) {
							
							indice2 = i;
							break;
						}						
					}
					
					operacao[0] = codigoIdentificador[indice2];
					codigoIdentificador[indice2] = null;
					
					operacao[1] = codigoIdentificador[indice];
					codigoIdentificador[indice] = null;	
				}
				
				else if (contador3 == 0) {
					
					for (int i = 0; i < max; i ++) {
						
						if (codigoIdentificador[i] != null)
							if (codigoIdentificador[i].charAt(0) == '3')
								contador4++;
					}
					
					if (contador4 > 0) {
						
						for (int i = 0; i < max; i ++) {
							
							if (codigoIdentificador[i] != null)
								if (codigoIdentificador[i].charAt(0) == '3') {
									indice = i;
									break;
								}
						}
						
						for (int i = (indice-1); i >= 0; i--) {
							
							if (codigoIdentificador[i] != null) {
								
								indice2 = i;
								break;
							}						
						}
						
						operacao[0] = codigoIdentificador[indice2];
						codigoIdentificador[indice2] = null;
						
						operacao[1] = codigoIdentificador[indice];
						codigoIdentificador[indice] = null;	
					}
					
					else if (contador4 == 0) {
						
						for (int i = 0; i < max; i ++) {
							
							if (codigoIdentificador[i] != null)
								if (codigoIdentificador[i].charAt(0) == '4')
									contador5++;
						}
						
						if (contador5 > 0) {
							
							for (int i = 0; i < max; i ++) {
								
								if (codigoIdentificador[i] != null)
									if (codigoIdentificador[i].charAt(0) == '4') {
										indice = i;
										break;
									}
							}
							
							for (int i = (indice-1); i >= 0; i--) {
								
								if (codigoIdentificador[i] != null) {
									
									indice2 = i;
									break;
								}						
							}
							
							operacao[0] = codigoIdentificador[indice2];
							codigoIdentificador[indice2] = null;
							
							operacao[1] = codigoIdentificador[indice];
							codigoIdentificador[indice] = null;
						}
					}
				}
			}
		}
		
		switch (operacao[0].charAt(0)) {
		
			case '0':
				
				codigoDeOperacao = "0";
			break;
		
			case '1':
				
				codigoDeOperacao = "1";
			break;
			
			case '2':
				
				codigoDeOperacao = "2";
			break;
			
			case '3':
				
				codigoDeOperacao = "3";
			break;
			
			case '4':
				
				codigoDeOperacao = "4";
			break;
		}
		
		switch (operacao[0].charAt(3)) {
		
			case '0':
				
				flagSaida = 1;
			break;
		
			case '1':
			
				if (operacao[0].charAt(4) == '1')					
					codigoDeOperacao += "-11";
				
				
				else if (operacao[0].charAt(4) == '2')
					codigoDeOperacao += "-12";
			break;
			
			case '2':
				
				if (operacao[0].charAt(4) == '1')					
					codigoDeOperacao += "-21";
				
				
				else if (operacao[0].charAt(4) == '2')
					codigoDeOperacao += "-22";
			break;
			
			case '3':
				
				if (operacao[0].charAt(4) == '1')					
					codigoDeOperacao += "-31";
				
				
				else if (operacao[0].charAt(4) == '2')
					codigoDeOperacao += "-32";
			break;
			
			case '4':
				
				if (operacao[0].charAt(4) == '1')					
					codigoDeOperacao += "-41";
				
				
				else if (operacao[0].charAt(4) == '2')
					codigoDeOperacao += "-42";
			break;
		}
		
		if (flagSaida == 1)
			if (operacao[0].charAt(6) == '1')
				codigoDeOperacao += "-50";
		
			else if (operacao[0].charAt(6) == '2')
				codigoDeOperacao += "-60";
		
		switch (operacao[1].charAt(0)) {
		
			case '1':
				
				codigoDeOperacao += "-1";
			break;
			
			case '2':
				
				codigoDeOperacao += "-2";
			break;
			
			case '3':
				
				codigoDeOperacao += "-3";
			break;
			
			case '4':
				
				codigoDeOperacao += "-4";
			break;
		}
		
		flagSaida = 0;
		
		switch (operacao[1].charAt(3)) {
		
			case '0':
		
				flagSaida = 1;				
			break;
				
			case '1':
				
				if (operacao[1].charAt(4) == '1')					
					codigoDeOperacao += "-11";
				
				
				else if (operacao[1].charAt(4) == '2')
					codigoDeOperacao += "-12";
			break;
			
			case '2':
				
				if (operacao[1].charAt(4) == '1')					
					codigoDeOperacao += "-21";
				
				
				else if (operacao[1].charAt(4) == '2')
					codigoDeOperacao += "-22";
			break;
			
			case '3':
				
				if (operacao[1].charAt(4) == '1')					
					codigoDeOperacao += "-31";
				
				
				else if (operacao[1].charAt(4) == '2')
					codigoDeOperacao += "-32";
			break;
			
			case '4':
				
				if (operacao[1].charAt(4) == '1')					
					codigoDeOperacao += "-41";
				
				
				else if (operacao[1].charAt(4) == '2')
					codigoDeOperacao += "-42";
			break;
		}
		
		if (flagSaida == 1)
			if (operacao[1].charAt(6) == '1')
				codigoDeOperacao += "-50";
		
			else if (operacao[1].charAt(6) == '2')
				codigoDeOperacao += "-60";		
	}
	
	public void resolvendoOperacao () {
		
		boolean p = false, q = false;
		
		switch (codigoDeOperacao.charAt(2)) {
		
			case '1':
				
				if (codigoDeOperacao.charAt(3) == '1')
					p = variaveis[0];
				
				else
					p = !variaveis[0];
			break;
			
			case '2':
				
				if (codigoDeOperacao.charAt(3) == '1')
					p = variaveis[1];
				
				else
					p = !variaveis[1];
			break;
			
			case '3':
				
				if (codigoDeOperacao.charAt(3) == '1')
					p = variaveis[2];
				
				else
					p = !variaveis[2];
			break;
			
			case '4':
				
				if (codigoDeOperacao.charAt(3) == '1')
					p = variaveis[3];
				
				else
					p = !variaveis[3];
			break;
			
			case '5':
				
				p = true;
			break;
			
			case '6':
				
				p = false;
			break;
		}
		
		switch (codigoDeOperacao.charAt(7)) {
		
			case '1':
				
				if (codigoDeOperacao.charAt(8) == '1')
					q = variaveis[0];
				
				else
					q = !variaveis[0];
			break;
			
			case '2':
				
				if (codigoDeOperacao.charAt(8) == '1')
					q = variaveis[1];
				
				else
					q = !variaveis[1];
			break;
			
			case '3':
				
				if (codigoDeOperacao.charAt(8) == '1')
					q = variaveis[2];
				
				else
					q = !variaveis[2];
			break;
			
			case '4':
				
				if (codigoDeOperacao.charAt(8) == '1')
					q = variaveis[3];
				
				else
					q = !variaveis[3];
			break;
			
			case '5':
				
				q = true;
			break;
			
			case '6':
				
				q = false;
			break;
		}
		
		switch (codigoDeOperacao.charAt(5)) {
		
			case '1':
				
				saida = Operacoes.or(p, q);
			break;
			
			case '2':
				
				saida = Operacoes.and(p, q);
			break;
			
			case '3':
				
				saida = Operacoes.conditional(p, q);
			break;
			
			case '4':
				
				saida = Operacoes.biconditional(p, q);
			break;
		}
	}
	
	public void gerandoCodigoSaida () {
		
		int indice2 = 0;
		
		for (int i = 0; i < codigoIdentificador.length; i++) {
			
			if (codigoIdentificador[i] == null) {
				
				indice2 = i;
				break;
			}
		}
		
		switch (codigoDeOperacao.charAt(0)) {
		
			case '0':
				
				if (flagSaidaParentese == 0)				
					if (saida)				
						codigoIdentificador[indice2] = "00-00-1";
				
					else
						codigoIdentificador[indice2] = "00-00-2";
				
				else
					if (saida)				
						codigoIdentificador[indice2] = "0" + flagSaidaParentese + "-00-1";
				
					else
						codigoIdentificador[indice2] = "0" + flagSaidaParentese + "-00-2";
			break;
			
			case '1':
				
				if (flagSaidaParentese == 0)				
					if (saida)				
						codigoIdentificador[indice2] = "10-00-1";
				
					else
						codigoIdentificador[indice2] = "10-00-2";
				
				else
					if (saida)				
						codigoIdentificador[indice2] = "1" + flagSaidaParentese + "-00-1";
				
					else
						codigoIdentificador[indice2] = "1" + flagSaidaParentese + "-00-2";
			break;
			
			case '2':
				
				if (flagSaidaParentese == 0)				
					if (saida)				
						codigoIdentificador[indice2] = "20-00-1";
				
					else
						codigoIdentificador[indice2] = "20-00-2";
				
				else
					if (saida)				
						codigoIdentificador[indice2] = "2" + flagSaidaParentese + "-00-1";
				
					else
						codigoIdentificador[indice2] = "2" + flagSaidaParentese + "-00-2";
			break;
			
			case '3':
				
				if (flagSaidaParentese == 0)				
					if (saida)				
						codigoIdentificador[indice2] = "30-00-1";
				
					else
						codigoIdentificador[indice2] = "30-00-2";
				
				else
					if (saida)				
						codigoIdentificador[indice2] = "3" + flagSaidaParentese + "-00-1";
				
					else
						codigoIdentificador[indice2] = "3" + flagSaidaParentese + "-00-2";
			break;
			
			case '4':
				
				if (flagSaidaParentese == 0)				
					if (saida)				
						codigoIdentificador[indice2] = "40-00-1";
				
					else
						codigoIdentificador[indice2] = "40-00-2";
				
				else
					if (saida)				
						codigoIdentificador[indice2] = "4" + flagSaidaParentese + "-00-1";
				
					else
						codigoIdentificador[indice2] = "4" + flagSaidaParentese + "-00-2";
			break;			
		}
		
		codigoDeOperacao = null;
		flagSaidaParentese = 0;
	}
	
	public boolean verificaResolucao () {
		
		int contador = 0;
		
		for (int i = 1; i < codigoIdentificador.length; i++) {
			
			if (codigoIdentificador[i] != null) {
				
				contador++;
				break;
			}
		}
		
		if (contador == 0)
			return true;
		
		else
			return false;
	}
	
	public String saidaFinal () {
		
		if (codigoIdentificador[0] == "00-00-1")
			return "Verdadeira";
		
		else
			return "Falso";
	}
	
	public boolean saidaFinalTabela () {
		
		if (codigoIdentificador[0] == "00-00-1")
			return true;
		
		else
			return false;
	}
	
	public void getBackup () {
		
		codigoIdentificador = null;
		this.setCodigoIdentificador(25);
		
		for (int i = 0; i < backupCodigoIdentificador.length; i++) {
			
			if (backupCodigoIdentificador[i] != null) {
				
				codigoIdentificador[i] = "";
				
				for (int j = 0; j < backupCodigoIdentificador[i].length(); j++) {
					
					codigoIdentificador[i] += backupCodigoIdentificador[i].charAt(j);
				}
			}
		}
	}
	
	public void insercaoLinhaTabela (int indice) {
		
		switch (tabelaVerdade.length) {
		
			case 4:
			
				tabelaVerdade[indice][0] = variaveis[0];
				tabelaVerdade[indice][1] = variaveis[1];
				tabelaVerdade[indice][2] = saidaFinalTabela();
			break;
			case 8:
				
				tabelaVerdade[indice][0] = variaveis[0];
				tabelaVerdade[indice][1] = variaveis[1];
				tabelaVerdade[indice][2] = variaveis[2];
				tabelaVerdade[indice][3] = saidaFinalTabela();
			break;
			
			case 16:
				
				tabelaVerdade[indice][0] = variaveis[0];
				tabelaVerdade[indice][1] = variaveis[1];
				tabelaVerdade[indice][2] = variaveis[2];
				tabelaVerdade[indice][3] = variaveis[3];
				tabelaVerdade[indice][4] = saidaFinalTabela();
			break;
		}
	}
		
	public String toString (boolean p) {
		
		if (p)
			return "V";
		
		else
			return "F";
	}
	
	public void imprimirValoracao () {
		
		switch (variaveis.length) {
		
			case 2:
				
				System.out.printf("| %s | %s | %s |\n", toString(variaveis[0]), toString(variaveis[1]), toString(saida));
				System.out.println("---------------");
			break;
			
			case 3:
				
				System.out.printf("| %s | %s | %s | %s |\n", toString(variaveis[0]), toString(variaveis[1]), toString(variaveis[2]), toString(saida));
				System.out.println("--------------------");
			break;
			
			case 4:
				
				System.out.printf("| %s | %s | %s | %s | %s |\n", toString(variaveis[0]), toString(variaveis[1]), toString(variaveis[2]), toString(variaveis[3]), toString(saida));
				System.out.println("-------------------------");
			break;
		}
	}
	
	public void imprimirTabelaVerdade (int indice) {
		
		switch (tabelaVerdade.length) {
		
			case 4:
				
				System.out.printf("| %s | %s | %s |\n", toString(tabelaVerdade[indice][0]), toString(tabelaVerdade[indice][1]), toString(tabelaVerdade[indice][2]));
				System.out.println("---------------");
			break;
			
			case 8:
				
				System.out.printf("| %s | %s | %s | %s |\n", toString(tabelaVerdade[indice][0]), toString(tabelaVerdade[indice][1]), toString(tabelaVerdade[indice][2]), toString(tabelaVerdade[indice][3]));
				System.out.println("-----------------");
			break;
			
			case 16:
				
				System.out.printf("| %s | %s | %s | %s | %s |\n", toString(tabelaVerdade[indice][0]), toString(tabelaVerdade[indice][1]), toString(tabelaVerdade[indice][2]), toString(tabelaVerdade[indice][3]), toString(tabelaVerdade[indice][4]));
				System.out.println("-----------------------");
			break;
		}
	}
}
