package test;

import java.util.*;


/**
 * test
 *
 * @author jh
 * @date 2018/8/11 15:41
 * description:
 * 5
 * 2,7,3,4,9
 * 3
 * 1,25,11
 */
public class Demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int count = sc.nextInt ();
		List<Integer> list = new ArrayList<> ();
		for (int i = 0; i < count; i++) {
			list.add (sc.nextInt ());
		}
		int[] ask = new int[sc.nextInt ()];
		int aa=0;
		for (int i = 0; i < ask.length; i++) {
			if(ask[i]>0){
				ask[i]=sc.nextInt ();

			}else{

			}
		}
		for (int i = 0; i < list.size (); i++) {

		}
		//List<Integer> integers = testAsk (ask, list);
		//integers.forEach (System.out::println);
	}

	private static List<Integer> testAsk(int[] ask, List<Integer> queue) {
		List<Integer> list = new ArrayList<> ();
		int count = 0;
		for (int i = 0; i < ask.length; i++) {
			while (ask[i] > 0) {
				Integer peek = queue.get(count);
				ask[i] = ask[i] - peek;
				count++;
			}
			list.add (count);
			count = 0;
		}
	return list;
	}
}
