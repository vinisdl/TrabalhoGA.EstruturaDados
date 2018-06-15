package trabalhogb1;

public class BubbleSort {

	public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
		   boolean exchange;
		   do {
		      exchange = false;
		      for (int i = 0; i < a.length - 1; i++) {
		         if (a[i].compareTo(a[i + 1]) > 0) {
		            exchange(a, i, i + 1);
		            exchange = true;
		         }
		      }
		   } while (exchange);
		}
	
	private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
		   T tmp = a[i];
		   a[i] = a[j];
		   a[j] = tmp;
		}
}
