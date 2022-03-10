/*
 * Estudante: Mauro Ernesto Pequenino
 * Codigo: 2021101005
 * Turma: 1P2LDS1
 * 
 * */


package gestao_propriedades;

import java.util.*;

public class PropriedadeApp {
	private ArrayList<Propriedade> propriedadeList = new ArrayList<Propriedade>();
	
	//Adicionar ao array
	private void addPropriedade(Propriedade propriedade) {
		propriedadeList.add(propriedade);
	}
	
	//Exibir menu
	private void mostrarMenu() {
		System.out.println();
		System.out.println("\n          MENU     " + 
							"\n1- Adicionar propriedade " + 
							"\n2- Lista de propriedades" + 
							"\n3- Apuramento" + 
							"\n4- Terminar");
	}
	
	//Exibir as propriedades inseridas com detalhes em colunas
	private void mostrarListaPropriedades() {	
	     System.out.printf("%n%-5s","Id");
	     System.out.printf("%-20s","Local");
	     System.out.printf("%-10s","Tipo");
	     System.out.printf("%-10s","Quartos");
	     System.out.printf("%-10s","Valor");
	     System.out.printf("%-10s","Desconto");
	     System.out.printf("%-10s","Total");
	     System.out.println();
	     for(Propriedade propriedade: propriedadeList) {  
	    	 System.out.printf("%-5s",(propriedadeList.indexOf(propriedade)+1));
	    	 System.out.printf("%-20s",propriedade.getLocalizacao());
	    	 System.out.printf("%-10s",propriedade.getTipo());
	    	 System.out.printf("%-10d",propriedade.getQuarto());
	    	 System.out.printf("%-10.2f",propriedade.getPreco());
	    	 System.out.printf("%-10.2f",propriedade.getDesconto());
	    	 System.out.printf("%-10.2f%n",(propriedade.getPreco()-propriedade.getDesconto()));    	 
	     }
	     
	     //Calcular o numero total de flats e vivendas
	     int flatsTotal = 0, vivendasTotal = 0;
		 for (Propriedade tipo : propriedadeList) {
			if(tipo.getTipo().equalsIgnoreCase("flat")) {
				flatsTotal += 1;
			}else if(tipo.getTipo().equalsIgnoreCase("vivenda")) {
				vivendasTotal += 1;
			}
		 }
		 
		 System.out.printf("%nTotal de flats: %d%n",flatsTotal);
		 System.out.printf("Total de vivendas: %d",vivendasTotal);
	     System.out.printf("%nTotal de propriedades: %d", propriedadeList.size());
	     System.out.println("\n-----------------------");
	}
	
	//Inserir dados das propriedades
	private Propriedade propriedadeInput() {
		Scanner scan = new Scanner(System.in);
		//Obter a localizacao da propriedade
        System.out.print("\nLocalizacao (T- Triunfo ou S- Sommerschield): ");
        String l = scan.next();
        String localizacao = "";
        
        if (l.equalsIgnoreCase("t")){
      	 localizacao = "Triunfo";
        } else if(l.equalsIgnoreCase("s")) {
      	 localizacao = "Sommerschield";
        } 
        
        //Obter o tipo da propriedade
        System.out.print("Tipo (F- Flat ou V- Vivenda): ");
        String t = scan.next();
        String tipo = "";
        
        //Obter o numero de quartos
        //Calcular o valor da vivenda de acordo com o numero de quartos
        //Calcular o desconto
        double preco = 0, desconto = 0;
        int quarto = 0;
 
        if (t.equalsIgnoreCase("f")) {
      	  tipo = "Flat";
      	  quarto = 1;
      	  preco = 17000;
      	  
        }else if(t.equalsIgnoreCase("v")) {
      	  tipo = "Vivenda"; 
      	  System.out.print("Quartos: ");
	          quarto = scan.nextInt();
	          
	          //valor da vivenda
	          preco = quarto * 24999;  
	          
	          //desconto
	          if(quarto == 2) {
	        	  desconto = preco*0.05;
	          } else if(quarto == 3) {
	        	  desconto = preco*0.10;
	          }
        }
        
        //Adicionar os dados no constructor
        Propriedade novaPropriedade = new Propriedade(localizacao, tipo, quarto, preco, desconto);
	    System.out.println("\n-----------------------");
        return novaPropriedade;
        
	}
	
	//Calcular o local com maior vendas
	private void localMaiorVendas() {
		double localTriunfoTotal = 0, localSchieldTotal = 0;
		for (Propriedade local : propriedadeList) {
			if(local.getLocalizacao().equalsIgnoreCase("triunfo")) {
				localTriunfoTotal += local.getPreco();
			}else if(local.getLocalizacao().equalsIgnoreCase("Sommerschield")) {
				localSchieldTotal += local.getPreco();
			}
		}
		if((localTriunfoTotal > 0) || (localSchieldTotal > 0)) {
			if(localTriunfoTotal > localSchieldTotal) {
				System.out.println("\nLocal com maior vendas: Triunfo");
				System.out.printf("Total: %.2f",localTriunfoTotal);
			} else {
				System.out.println("\nLocal com maior vendas: Sommerschield");
				System.out.printf("Total: %.2f",localSchieldTotal);
			}
			System.out.println("\n-----------------------");
		}	
	}
	
	//Apurar total de flat, vivendas, venda, descontos, despesas e o lucro
	private void apuramento() {
		
		//total de flat e vendas
		double flatsTotal = 0, vivendasTotal = 0;
		for (Propriedade tipo : propriedadeList) {
			if(tipo.getTipo().equalsIgnoreCase("flat")) {
				flatsTotal += tipo.getPreco();
			}else if(tipo.getTipo().equalsIgnoreCase("vivenda")) {
				vivendasTotal += tipo.getPreco();
			}
		}
		
		
		//total de vendas, descontos e lucro
		double descontosTotal = 0, vendasTotal = 0;
		for(Propriedade vendas : propriedadeList) {
			descontosTotal += vendas.getDesconto();
			vendasTotal += vendas.getPreco();
		}
		
		double despesasTotal = vendasTotal * 0.70;	
		double lucro = vendasTotal - descontosTotal - despesasTotal;
		
		System.out.printf("%nTotal de flats: %.2f%n",flatsTotal);
		System.out.printf("Total de vivendas: %.2f%n",vivendasTotal);
		System.out.printf("Total de vendas: %.2f%n",vendasTotal);
		System.out.printf("Total de descontos: %.2f%n", descontosTotal);
		System.out.printf("Total de despesas: %.2f%n", despesasTotal);
		System.out.printf("Lucro: %.2f%n", lucro);
		System.out.println("\n-----------------------");
	}
	
	//App ===============
	public static void main(String[] args)  {
		PropriedadeApp propriedadeApp = new PropriedadeApp();
	    Scanner scan = new Scanner(System.in);
	    int menu;
	    
	    System.out.println("   GESTAO DE PROPRIEDADES  ");
	    System.out.println("\n        Bem vindo");
	    
	    do {
	    	propriedadeApp.mostrarMenu();
	    	menu = scan.nextInt();
	    	
	    	switch(menu) {
	    	case 1:
	    		System.out.println();
	    		Propriedade propriedade = propriedadeApp.propriedadeInput();
	    		//Adicionar o objecto no arraylist
	    		propriedadeApp.addPropriedade(propriedade);
	    		break;
	    	 case 2: 
	    		System.out.println("======================   LISTA DE PROPRIEADADES   =====================\n");
	    		propriedadeApp.mostrarListaPropriedades();
	    		break;
	    	 case 3:
	    		 System.out.println("\n==========================  APURAMENTO  =========================\n");
	    		 propriedadeApp.mostrarListaPropriedades();
	    		 propriedadeApp.apuramento();
	    		 propriedadeApp.localMaiorVendas();
	    		break;
	    	 case 4: 	    		
	    		System.exit(1);
	    		break; 	
	    	}		
	    } while(menu != 4);	   
	}	
}
	  
