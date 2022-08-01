package leetcode.pattern.mergeintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 * <p>
 * Example 1:
 * <p>
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 * <p>
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:
 * <p>
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 * <p>
 * Example 4:
 * <p>
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 * <p>
 * Here is a visual representation of Example 4:
 */
class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {

        meetings.sort((m1, m2) -> m1.start - m2.start);

        int minRoom = Integer.MIN_VALUE;

        Queue<Integer> minHeap = new PriorityQueue<>((v1, v2) -> v1 - v2);
        for (Meeting meeting : meetings) {
            while (!minHeap.isEmpty() && minHeap.peek() <= meeting.start) minHeap.poll();

            minHeap.offer(meeting.end);

            minRoom = Math.max(minRoom, minHeap.size());
        }

        return minRoom;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
