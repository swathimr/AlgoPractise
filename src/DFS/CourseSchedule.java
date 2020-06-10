package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build the course graph and check for iscyclic
 * DFS with backtracking
 * space and time O(E+V) , E is no of courses, V is no of prerequisites
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDict = new HashMap<>();

        // key is 1
        for(int[] relation : prerequisites) {
            if(courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> course = new ArrayList<>();
                course.add(relation[0]);
                courseDict.put(relation[1], course);
            }
        }

        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int currCourse = 0; currCourse < numCourses; currCourse++) {
            if(isCyclic(currCourse, path, visited, courseDict))
                return false;
        }
        return true;
    }


    public boolean isCyclic(int currCourse, boolean[] path, boolean[] visited, Map<Integer, List<Integer>> courseDict) {
        if(visited[currCourse])
            return false;

        if(path[currCourse])
            return true;

        if(!courseDict.containsKey(currCourse))
            return false;

        path[currCourse] = true;
        boolean ret = false;
        for(int val : courseDict.get(currCourse)) {
            ret = isCyclic(val, path, visited, courseDict);
            if(ret)
                break;
        }

        path[currCourse] = false;
        visited[currCourse] = true;
        return ret;
    }
}
