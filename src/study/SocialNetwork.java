package study;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 27..
 */
public class SocialNetwork {
    public static void main(String[] args) {
    }

    public static List<String> getDirectFriendsForUser(String user) {
        return new ArrayList<>();
    }

    public static List<String> getAttendedCoursesForUser(String user) {
        return new ArrayList<>();
    }

    public static List<String> getRankedCourses(String user) {
        HashMap<String, Boolean> myCourse = new HashMap<>();
        HashMap<String, Integer> courseMap = new HashMap<>();
        for(String course : getAttendedCoursesForUser(user)) {
            myCourse.put(course, true);
        }

        Set<String> friends = new HashSet<>();
        for(String direct : getDirectFriendsForUser(user)) {
            friends.add(direct);
            for(String indirect : getDirectFriendsForUser(direct)) {
                friends.add(indirect);
            }
        }

        for(String friend : friends) {
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
        }

        return sortByValue(courseMap);
    }

    public static List<String> sortByValue(final Map<String, Integer> map) {
        List<String> courses = new ArrayList<>(map.keySet());
        Collections.sort(courses, (s1, s2) -> (map.get(s1) > map.get(s2))? 1 : -1);
        return courses;
    }
}
