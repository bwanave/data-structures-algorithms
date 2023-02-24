//desing an api to return a list of active connected friends for a given user at a given timestamp

// User table
// A 1
// B 2
// C 3

// User_friends_table
// user_id friend_id timestamp
// 1     2   time 10
// 2     1

// 1     3   time  9
// 1     4   time  6

// 1     5   time 2


//1, time -> 1 , 7

// select user_id, friend_id from User_friends_table where user_id = <input_user_id> and to_date(timestamp, "dd-MM-yyyy HH:mm:ss") <=  to_date(t1, "dd-MM-yyyy HH:mm:ss");

//UNION ALL
//        select friend_id from User_friends_table where friend_id = <input_user_id> and to_date(timestamp, "dd-MM-yyyy HH:mm:ss") <=  to_date(t1, "dd-MM-yyyy HH:mm:ss");
public class Solution {
}
