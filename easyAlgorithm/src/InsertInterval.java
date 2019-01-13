import java.util.*;

/**
 * 57 插入区间
 */
public class InsertInterval {

    //1
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        if (intervals==null || intervals.size()==0) return intervals;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int start= intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval:intervals){
            if (interval.start<=end){
                end= Math.max(interval.end,end);
            }else {
                res.add(new Interval(start,end));
                start= interval.start;
                end= interval.end;
            }
        }

        res.add(new Interval(start,end));
        return res;
    }

    //2
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval){

        List<Interval> res = new ArrayList<>();
        if (newInterval==null) return intervals;
        int i=0;
        while (i<intervals.size() && intervals.get(i).end<newInterval.start){
            res.add(intervals.get(i++));
        }
        while (i<intervals.size() && intervals.get(i).start<= newInterval.end){
            newInterval.start= Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end= Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        res.add(newInterval);
        while (i<intervals.size()){
            res.add(intervals.get(i++));
        }
        return res;
    }
}
