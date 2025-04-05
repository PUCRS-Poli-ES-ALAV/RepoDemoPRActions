package br.pucrs.progdinam;

import br.pucrs.progdinam.KnapSack.KnapSackPiece;
import br.pucrs.util.ContagemRes;

public class AppDemo {
	public static void printKnapSack(KnapSackPiece[] p, long c) {
		System.out.println("**********");
		System.out.println("Capacidade da Mochila = " + c);
		System.out.println("Pares: (peso, valor)");
		for (int i = 0; i < p.length; i++) {
			System.out.print("(" + p[i].getPeso() + ", " + p[i].getValor() + ")");
		}
		System.out.println("\n");
	}

	public static void printStats(String subtitle, ContagemRes resCont) {
		System.out.print("Resultado (" + subtitle + ") = ");
		
		for (int i = 0; i < resCont.getResult().length; i++)
		     System.out.print(resCont.getResult()[i] + " ");

		System.out.println("\nNúmero de Iterações (" + subtitle + ") = " + resCont.getIteracoes());
		System.out.println("Número de Instruções (" + subtitle + ") = " + resCont.getInstrucoes() + "\n");
	}

	public static void main(String[] args) {
		ContagemRes resCont;
		KnapSackPiece[] pieces;

		System.out.println("----> Fibonacci");
		Fibonacci fibo = new Fibonacci();
		int n = 4;	
		System.out.println("\nFibonacci Recursivo: " + n + " - " + fibo.fiboRec(n));
		System.out.println("Fibonacci Iterativo: " + n + " - " + fibo.fiboIter(n));
		System.out.println("Fibonacci com Memoization: " + n + " - " + fibo.fiboMemo(n));

		n = 8;	
		System.out.println("\nFibonacci Recursivo: " + n + " - " + fibo.fiboRec(n));
		System.out.println("Fibonacci Iterativo: " + n + " - " + fibo.fiboIter(n));
		System.out.println("Fibonacci com Memoization: " + n + " - " + fibo.fiboMemo(n));

		n = 32;	
		System.out.println("\nFibonacci Recursivo: " + n + " - " + fibo.fiboRec(n));
		System.out.println("Fibonacci Iterativo: " + n + " - " + fibo.fiboIter(n));
		System.out.println("Fibonacci com Memoization: " + n + " - " + fibo.fiboMemo(n));

		System.out.println("\n\n----> Knapsack Problem");
		pieces = new KnapSack.KnapSackPiece[10];
		pieces[0] = new KnapSack.KnapSackPiece(23, 92);
		pieces[1] = new KnapSack.KnapSackPiece(31, 57);
		pieces[2] = new KnapSack.KnapSackPiece(29, 49);
		pieces[3] = new KnapSack.KnapSackPiece(44, 68);
		pieces[4] = new KnapSack.KnapSackPiece(53, 60);
		pieces[5] = new KnapSack.KnapSackPiece(38, 43);
		pieces[6] = new KnapSack.KnapSackPiece(63, 67);
		pieces[7] = new KnapSack.KnapSackPiece(85, 84);
		pieces[8] = new KnapSack.KnapSackPiece(89, 87);
		pieces[9] = new KnapSack.KnapSackPiece(82, 72);

		printKnapSack(pieces, 165);
		resCont = KnapSack.knapSackRecursive(165, pieces);
		printStats("Recursive", resCont);
		resCont = KnapSack.knapSackProgDinam(165, pieces);
		printStats("Prog. Dinâmica", resCont);

		pieces = new KnapSack.KnapSackPiece[6];
		pieces[0] = new KnapSack.KnapSackPiece(56, 50);
		pieces[1] = new KnapSack.KnapSackPiece(59, 50);
		pieces[2] = new KnapSack.KnapSackPiece(80, 64);
		pieces[3] = new KnapSack.KnapSackPiece(64, 46);
		pieces[4] = new KnapSack.KnapSackPiece(75, 50);
		pieces[5] = new KnapSack.KnapSackPiece(17, 05);

		printKnapSack(pieces, 190);
		resCont = KnapSack.knapSackRecursive(190, pieces);
		printStats("Recursive", resCont);
		resCont = KnapSack.knapSackProgDinam(190, pieces);
		printStats("Prog. Dinâmica", resCont);

		pieces = new KnapSack.KnapSackPiece[30];
		for (int i = 0; i < 30; i++) {
			pieces[i] = new KnapSack.KnapSackPiece(1, i % 20);
		}

		printKnapSack(pieces, 190);
		resCont = KnapSack.knapSackRecursive(190, pieces);
		printStats("Recursive", resCont);
		resCont = KnapSack.knapSackProgDinam(190, pieces);
		printStats("Prog. Dinâmica", resCont);

	}

}