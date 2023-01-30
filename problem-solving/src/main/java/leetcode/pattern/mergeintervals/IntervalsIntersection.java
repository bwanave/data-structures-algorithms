package leetcode.pattern.mergeintervals;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 * <p>
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
class IntervalsIntersection {

    public static Interval[] merge(Interval[] firstArr, Interval[] secondArr) {
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstArr.length && j < secondArr.length) {
            Interval first = firstArr[i];
            Interval second = secondArr[j];
            if ((first.start >= second.start && first.start <= second.end) || (second.start >= first.start && second.start <= first.end)) {
                result.add(new Interval(max(first.start, second.start), min(first.end, second.end)));
            }

            if (first.end < second.end) i += 1;
            else j += 1;
        }

        return result.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
