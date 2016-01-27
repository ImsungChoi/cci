package study;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 27..
 */
public class SocialNetwork {
    public static void main(String[] args) {

    }

    public static List<String> getDirectFriendsForUser(String user) {
        return null;
    }

    public static List<String> getAttendedCoursesForUser(String user) {
        return null;
    }

    public static List<String> getRankedCourses(String user) {
        HashMap<String, Boolean> myCourse = new HashMap<>();
        HashMap<String, Integer> courseMap = new HashMap<>();
        for(String course : getAttendedCoursesForUser(user)) {
            myCourse.put(course, true);
        }

        Queue<String> queue = new LinkedList<>();
        int numOfDirectFriends = 0;
        for(String direct : getDirectFriendsForUser(user)) {
            queue.offer(direct);
            numOfDirectFriends++;
        }

        while(!queue.isEmpty()) {
            String friend = queue.poll();

            for(String course : getAttendedCoursesForUser(friend)) {
                if(myCourse.containsKey(course)) {
                    continue;
                }
                if(courseMap.containsKey(course)) {
                    courseMap.put(course, courseMap.get(course)+1);
                } else {
                    courseMap.put(course, 0);
                }
            }

            if(numOfDirectFriends > 0) {
                for(String indirect : getDirectFriendsForUser(friend)) {
                    queue.offer(indirect);
                }
                numOfDirectFriends--;
            }
        }

        return sortByValue(courseMap);
    }

    public static List<String> sortByValue(final Map<String, Integer> map) {
        List<String> courses = new ArrayList<>(map.keySet());
        Collections.sort(courses, (s1, s2) -> (map.get(s1) > map.get(s2))? 1 : -1);
        return courses;
    }
}
