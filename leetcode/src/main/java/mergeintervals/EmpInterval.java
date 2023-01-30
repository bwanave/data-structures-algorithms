package mergeintervals;

import java.util.*;

/**
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours. Our goal is to determine if there is a free interval which is common to all employees. You can assume that each list of employee working hours is sorted on the start time.
 * <p>
 * Example 1:
 * <p>
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: All the employees are free between [3,5].
 * Example 2:
 * <p>
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employees are free between [4,6] and [8,9].
 * Example 3:
 * <p>
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employees are free between [5,7].
 */
class EmpInterval {
    int start;
    int end;
    int empIdx;
    int intervalIdx;

    public EmpInterval(int start, int end, int empIdx, int intervalIdx) {
        this.start = start;
        this.end = end;
        this.empIdx = empIdx;
        this.intervalIdx = intervalIdx;
    }
};

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        Queue<EmpInterval> minHeap = new PriorityQueue<>((e1, e2) -> e1.start - e2.start);
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> empIntervals = schedule.get(i);
            Interval empInterval = empIntervals.get(0);
            minHeap.offer(new EmpInterval(empInterval.start, empInterval.end, i, 0));
        }

        EmpInterval prev = minHeap.poll();
        addNext(minHeap, prev, schedule);
        while (!minHeap.isEmpty()) {
            EmpInterval curr = minHeap.poll();
            if (prev.end < curr.start) result.add(new Interval(prev.end, curr.start));

            prev = curr;
            addNext(minHeap, curr, schedule);
        }

        return result;
    }

    private static void addNext(Queue<EmpInterval> minHeap, EmpInterval curr, List<List<Interval>> schedule) {
        int empIdx = curr.empIdx;
        int intervalIdx = curr.intervalIdx;
        List<Interval> empIntervals = schedule.get(empIdx);
        if (intervalIdx + 1 < empIntervals.size()) {
            intervalIdx += 1;
            Interval next = empIntervals.get(intervalIdx);
            minHeap.offer(new EmpInterval(next.start, next.end, empIdx, intervalIdx));
        }
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
