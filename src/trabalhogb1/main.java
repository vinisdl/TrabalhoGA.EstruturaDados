package trabalhogb1;

import java.util.Arrays;

public class main {
	
	/*public static void main(String[] args) {
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
		
		System.out.println("Valores Crescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("linha "+ (valoresCrescentes[i].length) +" -- %f %n", executaBubble(valoresCrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Valores Decrescentes");
		for (int i = 0; i < 10; i++) {
			System.out.printf("linha "+ (valoresDecrescentes[i].length) +" -- %f %n", executaBubble(valoresDecrescentes[i].clone()));			
		}
		System.out.println();
		System.out.println("Valores Aleatórios");
		for (int i = 0; i < 10; i++) {
			System.out.printf("linha "+ (valoresAleatorios[i].length) +" -- %f %n", executaBubble(valoresAleatorios[i].clone()));			
		}
		
		System.out.println();
		System.out.println("Valores Aleatórios repetidos");
		for (int i = 0; i < 10; i++) {
			System.out.printf("linha "+ (valoresAleatoriosRepetidos[i].length) +" -- %f %n", executaBubble(valoresAleatoriosRepetidos[i].clone()));			
		}
	}*/

	private static double executaBubble(Integer[] values) {
		
		double[] tempos = new double[10];
		
		for (int i = 0; i < tempos.length; i++) {
			long start = System.nanoTime();
			BubbleSort.bubbleSort(values);
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
