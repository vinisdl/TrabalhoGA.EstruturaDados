package trabalhogb1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class SortUtils {
	/*public static void main(String[] args) {
	
		double[] test = new double[10];
		test[0] = 27633;
		test[1] = 16974;
		test[2] = 30396;
		test[3] = 24081;
		test[4] = 23686;
		test[5] = 13816;
		test[6] = 23291;
		test[7] = 21317;
		test[8] = 39081;
		test[9] = 25264;
									
		System.out.println(computacaoDoTempo(test));
						
	}*/
	
	public static double computacaoDoTempo(double[] array) {
		return mediaAritimetica(computacao(array));
	}
	
	private static double[] computacao(double[] array) {
		double media = mediaAritimetica(array);
		double desvio = desvioPadrao(array);
				
		ArrayList<Double> lst = new ArrayList<Double>();
		
		for(double a : array) {
			if((media + desvio) >= a &&  (media-desvio) <= a) {
				lst.add(a);
			}
		}
						
		double[] arr = new double[lst.size()];
		
		for (int i = 0; i < lst.size() ; i++) {
			arr[i] = lst.get(i).doubleValue();
		}
		return arr;
	}
	
	public static double desvioPadrao(double[] objetos) {
		if (objetos.length == 1) {
			return 0.0;
		} else {
			double mediaAritimetica = mediaAritimetica(objetos);
			double somatorio = 0l;
			for (int i = 0; i < objetos.length; i++) {
				double result = objetos[i] - mediaAritimetica;
				somatorio = somatorio + result * result;
			}
			return Math.sqrt(((double) 1 /( objetos.length-1))
					* somatorio);
		}
	}

	public static double mediaAritimetica(double[] objetos) {
		double somatorio = 0l;
		for (double d : objetos) {
			somatorio += d;
		}
		return somatorio / objetos.length;
	}
	
	public static Integer[] gerrarValoresCrescentes(int length) {
		Integer[] array = new Integer[length];
				
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		return array;
	}
	
	public static Integer[] gerrarValoresDecrescentes(int length) {
		Integer[] array = new Integer[length];
				
		for (int i = array.length; i > 0; i--) {
			array[i -1] = i;
		}
					
		return array;
	}
	
	public static Integer[] gerarValoresAleatorios(int length) {
		Integer[] array = new Integer[length];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		array = RandomizeArray(array);
		
		return array;
	}

	private static Integer[] RandomizeArray(Integer[] array) {
		Random r = new Random();
         for (int i = 0; i < array.length; i++)
         {
             int rand = r.nextInt(array.length);
             Integer old = array[i];
             array[i] = array[rand];
             array[rand] = old;
         }
         return array;
	}
		
	public static Integer[] gerarValoresAleatoriosRepetidos(int length) {
		Integer[] array = new Integer[length];
          int repetValues = (int)(length * 0.06);

          int count = 1;
          for(int i = 0; i < array.length; i++){

              for (int j = 0; j < repetValues && i < array.length; j++)
              {
                  array[i] = count;
                  i++;
              }

              count++;
          }
          
          for (int i = 0; i < array.length; i++) {
			if(array[i] == null)
				array[i] = i;
		}
          

          RandomizeArray(array);
		return array;
	}		
}
