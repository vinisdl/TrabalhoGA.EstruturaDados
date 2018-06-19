package trabalhogb1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class SortUtils {
		
	public static double computacaoDoTempo(double[] array) {
		//Calcula os valores dentro do range desvio padrão e calcula a média aritimética
		return mediaAritimetica(computacao(array));
	}
	
	//calcula e retorna os valores dentro do desvio padrão
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
	
	// calcula o desvio padrão;
	public static double desvioPadrao(double[] objetos) {
		//se o array estiver vazio ou com length == 1 seu desvio padrão é 0 
		if (objetos.length <= 1) {
			return 0.0;
		} else {
			//calcula a média aritimética dos objetos
			double mediaAritimetica = mediaAritimetica(objetos);
			double somatorio = 0l;
			// para cada objeto, é descontada a média aritimética para realizar  o calculo de desvio padrão
			for (int i = 0; i < objetos.length; i++) {
				double result = objetos[i] - mediaAritimetica;
				somatorio = somatorio + result * result;
			}
			return Math.sqrt(((double) 1 /( objetos.length-1))
					* somatorio);
		}
	}

	//Calcula a média aritimética soma total / quantidade de elementos do array
	public static double mediaAritimetica(double[] objetos) {
		double somatorio = 0l;
		for (double d : objetos) {
			somatorio += d;
		}
		return somatorio / objetos.length;
	}
	
	// Gera valores crescentes de 0 até o tamanho -1 do array
	public static Integer[] gerrarValoresCrescentes(int length) {
		Integer[] array = new Integer[length];
				
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		return array;
	}

	// Gera valores decrescentes partindo do valor do array -1 até 0 
	public static Integer[] gerrarValoresDecrescentes(int length) {
		Integer[] array = new Integer[length];
				
		for (int i = array.length; i > 0; i--) {
			array[i -1] = i;
		}
					
		return array;
	}
	
	//gera valores aleatórios utilizado o metodo gera valores crescentes
	public static Integer[] gerarValoresAleatorios(int length) {
		Integer[] array = gerrarValoresCrescentes(length);		
		array = RandomizeArray(array);
		
		return array;
	}

	// realiza uma mesclagem aleatória de um array
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
		
	// gera um array com tamanho length com 6% de repetição de cada valor. 
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
