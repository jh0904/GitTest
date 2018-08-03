package java8.fork_join;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * java8.fork_join
 *
 * @author jh
 * @date 2018/8/2 17:00
 * description:使用Fork/Join框架
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

	private long start;
	private long end;
	private static final long THRESHOLD = 10000;

	public ForkJoinCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length=end-start;
		if(length<=THRESHOLD){
			long sum=0;
			for (long i = start; i <= end; i++) {
				sum+=i;
			}
			return sum;
		}else{
			long middle = (start + end) / 2;
			ForkJoinCalculate left=new ForkJoinCalculate (start,middle);
			left.fork ();//拆分子任务，加入线程队列

			ForkJoinCalculate right=new ForkJoinCalculate (middle+1,end);
			right.fork ();//拆分子任务，加入线程队列

			return left.join ()+right.join ();
		}
	}
}
