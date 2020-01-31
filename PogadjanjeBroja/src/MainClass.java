import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int[] niz = new int[4];
		int[] proveraNiza = new int[4];
		int[] pomocnaProvera = new int[4];
		
		int brojac = 0;
		int pogodjeniNaMestu = 0;
		int pogodjeniLoseMesto = 0;
		int krajIgra = 0;
		int brojPartija = 0;
		int brojPoena = 0;
		
		boolean upis = true;
		
		System.out.println("             *** DOBRODOSLI U IGRU ***");
		System.out.println("*** POTREBNO JE DA POGODITE KOMBINACIJU 4 BROJA ***");
		
		proveraNiza = getRandom(proveraNiza, rand);
		
		do {
			
			brojPartija++;
			
			do {
				
				pogodjeniNaMestu = 0;
				pogodjeniLoseMesto = 0;
				
				System.out.println("_______________________");
				System.out.println(" ");
				System.out.println("Unesite pojedinacno 4 broja. Brojevi moraju biti u intervalu od 1 do 6!");
				
				
				
				do{
					
					for(int i = 0; i < 4; i++) {
						
						niz[i] = scanner.nextInt();
							if (niz[i] > 6 || niz[i] < 1) {
								System.out.println("Broj mora biti u intervalu od 1 do 6! Pokusajte ponovo: ");
								upis = false;
								break;
							}else {
								upis = true;
							}
						}
				}while (upis == false);
				
				
				for(int i = 0; i < 4; i++) {
					
					pomocnaProvera[i] = proveraNiza[i];
					
					if (pomocnaProvera[i] == niz[i]) {
						pogodjeniNaMestu++;
						niz[i] = -1;
						pomocnaProvera[i] = -1;
					}
				}
	
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if ((pomocnaProvera[i] > 0) && (niz[j] > 0)) {
							if (pomocnaProvera[i] == niz[j]) {
								pogodjeniLoseMesto++;
								niz[j] = -1;
								pomocnaProvera[i] = -1;
							}
						}
					}
				}
				
				
					
				
				if (pogodjeniNaMestu == 4) {
					System.out.println("Bravo, pogodili ste trazenu kombinaciju!");
					if (brojac > 6){
						brojPoena = brojPoena + 20;
					}else{
						brojPoena = brojPoena + 30;
					}
					
					System.out.println("Imate " + brojPoena + " poena");
					break;
				
				}else {
					System.out.println("Broj pogodjenih na pravom mestu; " + pogodjeniNaMestu + ", broj pogodjenih na losem mestu " + pogodjeniLoseMesto + ".");
				}	
				
				brojac++;
				
				
			}while(brojac < 7);
				
			
			System.out.println("_____________________________________");
			System.out.println(" ");
			
			if (brojac >= 7) {
				System.out.println("Zao nam je, niste uspeli da pogodite kombinaciju!");
				System.out.print ("Kombinacija koju je trebalo pogoditi je: ");
				for (int i = 0; i < 4; i++) {
					System.out.print(proveraNiza[i]+" ");
				}
				System.out.println("");
			}
			System.out.println("Da li zelite ponovo da igrate? (1-Da, 0-NE)");
			
			
			krajIgra = scanner.nextInt();
			
			
			while (krajIgra > 1 || krajIgra < 0) {
				System.out.println("Losa opcija, probajte ponovo: ");
				krajIgra = scanner.nextInt();
			}
			if (krajIgra == 1) {
				proveraNiza = getRandom(proveraNiza, rand);
				brojac = 0;
			}
			
			
		}while(krajIgra == 1);
		
		System.out.println("Broj osvojenih poena: " + brojPoena);
		System.out.println("Igrali ste ukupuno " + brojPartija + " partija.");
		
		scanner.close();
	}
	
	
	public static int[] getRandom(int[] znak, Random rand) {
		for(int i = 0; i < 4; i++) {
			
			znak[i] = rand.nextInt(6) +1;
		
		}
		return znak;
	}
	
}
