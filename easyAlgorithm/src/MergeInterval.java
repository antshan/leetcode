import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 56 合并区间
 * 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res= new ArrayList<>();
        if (intervals==null || intervals.size()==0) return intervals;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int start= intervals.get(0).start;
        int end= intervals.get(0).end;
        for (Interval interval:intervals){
            if (interval.start<=end){
                end= Math.max(end,interval.end);
            }else {
                res.add(new Interval(start,end));
                start= interval.start;
                end= interval.end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
