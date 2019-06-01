package p03_Activities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] startTime = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] endTime = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < endTime.length; i++) {
            Activity activity = new Activity(startTime[i], endTime[i]);

            activities.add(activity);
        }

        List<Activity> activitiesSorted = activities.stream().sorted((x, y) -> {
            if (x.getEndTime() > y.getEndTime()) {
                return 1;
            } else if(x.getEndTime() == y.getEndTime()){
                return 0;
            }
            return -1;
        }).collect(Collectors.toList());

        Activity last = activitiesSorted.get(0);
        System.out.printf("%d - %d\n", last.getStartTime(), last.getEndTime());

        for (int i = 1; i < activitiesSorted.size(); i++) {
            Activity currentActivity = activities.get(i);
            if(currentActivity.getStartTime() >= last.getEndTime()){
                last = currentActivity;
                System.out.printf("%d - %d\n", last.getStartTime(), last.getEndTime());
            }
        }

        System.out.println();
    }
}
