package trabalhogb1;

import java.util.Arrays;

public class main {
	
	public static void main(String[] args) {
		int[] n = getLoopValues();	
								
		Integer[][] valoresCrescentes = new Integer[10][];
		Integer[][] valoresDecrescentes = new Integer[10][];
		Integer[][] valoresAleatorios = new Integer[10][];
		Integer[][] valoresAleatoriosRepetidos = new Integer[10][];
		
		
		for (int i = 0; i < 10; i++) {
			valoresCrescentes[i] = SortUtils.gerrarValoresCrescentes(n[i]);
			valoresDecrescentes[i] = SortUtils.gerrarValoresDecrescentes(n[i]);
			valoresAleatorios[i] = SortUtils.gerarValoresAleatorios(n[i]);
			valoresAleatoriosRepetidos[i] =SortUtils.gerarValoresAleatoriosRepetidos(n[i]);
		}
		System.out.printf("PRINT BUBBLE %n %n %n %n");
		printBubble(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT INSERTION %n%n%n%n");		
		printInsertion(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT SELECTION %n%n%n%n");
		printSelection(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT HEAP %n%n%n%n");
		printHeap(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT SHELL %n%n%n%n");
		printShell(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT MERGE %n %n %n %n");
		printMerge(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
		System.out.printf("PRINT QUICK %n%n%n%n");
		printQuick(valoresCrescentes.clone(), valoresDecrescentes.clone(), valoresAleatorios.clone(), valoresAleatoriosRepetidos.clone());
		
	}

	private static void printBubble(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Bubble Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaBubble(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Bubble Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaBubble(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Bubble Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaBubble(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Bubble Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaBubble(valoresAleatoriosRepetidos[i].clone()));			
		}
	}

	
	private static void printInsertion(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Insertion Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaInsertion(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Insertion Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaInsertion(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Insertion Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaInsertion(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Insertion Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaInsertion(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static void printSelection(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Selection Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaSelection(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Selection Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaSelection(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Selection Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaSelection(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Selection Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaSelection(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static void printHeap(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Heap Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaHeap(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Heap Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaHeap(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Heap Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaHeap(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Heap Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaHeap(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static void printShell(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Shell Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaShell(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Shell Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaShell(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Shell Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaShell(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Shell Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaShell(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static void printMerge(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Merge Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaMerge(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Merge Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaMerge(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Merge Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaMerge(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Merge Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaMerge(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static void printQuick(Integer[][] valoresCrescentes, Integer[][] valoresDecrescentes,
			Integer[][] valoresAleatorios, Integer[][] valoresAleatoriosRepetidos) {
		System.out.println("Quick Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaQuick(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Quick Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaQuick(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Quick Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaQuick(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Quick Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%f %n", executaQuick(valoresAleatoriosRepetidos[i].clone()));			
		}
	}
	
	private static double executaQuick(Integer[] values) {
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.quickSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
		
	private static double executaMerge(Integer[] values) {
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.mergeSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static double executaShell(Integer[] values) {
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.shellSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static double executaHeap(Integer[] values) {
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.heapSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static double executaSelection(Integer[] values) {
		
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.selectionSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static double executaInsertion(Integer[] values) {
		
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.insertionSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static double executaBubble(Integer[] values) {
		
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			Sort.bubbleSort(values.clone());
			tempos[i] =  (System.nanoTime() - start);
		}
		
		return SortUtils.computacaoDoTempo(tempos);
	}
	
	private static int[] getLoopValues() {
		int[] n = new int[10];
		n[0] = 128; 
		n[1] = 256;
		n[2] = 512; 
		n[3] = 1024; 
		n[4] = 2048; 
		n[5] = 4096; 
		n[6] = 8192; 
		n[7] = 16384;
		n[8] = 32768;
		n[9] = 65536;
		return n;
	}
}
