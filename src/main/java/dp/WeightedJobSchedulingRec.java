package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Given N jobs where every job is represented by following three elements of it.
 * <p>
 * Start Time
 * <p>
 * Finish Time
 * <p>
 * Profit or Value Associated (>= 0)
 * <p>
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: Number of Jobs n = 4
 * <p>
 * Job Details {Start Time, Finish Time, Profit}
 * <p>
 * Job 1:  {1, 2, 50}
 * <p>
 * Job 2:  {3, 5, 20}
 * <p>
 * Job 3:  {6, 19, 100}
 * <p>
 * Job 4:  {2, 100, 200}
 * <p>
 * Output: The maximum profit is 250.
 * <p>
 * We can get the maximum profit by scheduling jobs 1 and 4.
 * Note that there is longer schedules possible Jobs 1, 2 and 3
 * but the profit with this schedule is 20+50+100 which is less than 250.
 */
public class WeightedJobSchedulingRec {

    private int getLatestNonConflictJob(Job[] jobs, int size) {
        Job job = jobs[size - 1];
        for (int i = size - 1; i >= 0; i--) {
            if (job.getStartTime() >= jobs[i].getFinishTime())
                return i;
        }
        return -1;
    }

    public int findMaxProfit(Job[] jobs, int size) {
        // Base case
        if (size == 1)
            return jobs[0].getProfit();

        int inclusiveProfit = jobs[size - 1].getProfit();
        int latestNonConflictJobIndex = getLatestNonConflictJob(jobs, size);
        if (latestNonConflictJobIndex != -1)
            inclusiveProfit += findMaxProfit(jobs, latestNonConflictJobIndex + 1);
        int exclusiveProfit = findMaxProfit(jobs, size - 1);
        return Math.max(inclusiveProfit, exclusiveProfit);
    }

    public int findMaxProfit(Job[] jobs) {

        Job[] sortedJobs = Arrays.stream(jobs)
                .sorted(Comparator.comparing(Job::getFinishTime))
                .collect(Collectors.toList())
                .toArray(Job[]::new);
        return findMaxProfit(sortedJobs, sortedJobs.length);
    }

    public static void main(String[] args) {

        Job job1 = new Job(1, 2, 50);
        Job job2 = new Job(3, 5, 20);
        Job job3 = new Job(6, 19, 100);
        Job job4 = new Job(2, 100, 200);

        WeightedJobSchedulingRec weightedJobSchedulingRec = new WeightedJobSchedulingRec();
        System.out.println(weightedJobSchedulingRec.findMaxProfit(new Job[]{job1, job2, job3, job4}));
    }
}

class Job {
    private final int startTime;
    private final int finishTime;
    private final int profit;

    Job(int startTime, int finishTime, int profit) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.profit = profit;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getProfit() {
        return profit;
    }
}
