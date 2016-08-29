

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author xenxui
 * 2016/8/29
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 */

public class MergeInterval {
	
	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(4,8));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(5,6));
		System.out.println(intervals);
		
		System.out.println(merge(intervals));

	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size()<2) {
			return intervals;
		}
		Collections.sort(intervals, (l,r) -> l.start<r.start? -1: l.start == r.start? 0: 1);
		
		List<Interval> result = new ArrayList<>();
		Interval check = new Interval(intervals.get(0).start, intervals.get(0).end);	
		result.add(check);
		
		for (Interval interval : intervals) {
			if (check.end < interval.start) {
				check = new Interval(interval.start, interval.end);
				result.add(check);
			}else if (check.end < interval.end){
				check.end = interval.end;			
			}
		}
	
		return result;
	}
}

class Interval {
	int start;
	int end;
	
	public Interval() {
		this(0, 0);
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "["+start+"," + end + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		
		if (obj instanceof Interval) {
			if (this.start != ((Interval)obj).start || this.end != ((Interval)obj).end) {
				return false;
			}
			return true;
		}
		return false;
	}
}
