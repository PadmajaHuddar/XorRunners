package com.example.huddar_p.navtrial1;

/**
 * Created by narayanswamy_s on 20-09-2017.
 */

public class WorkOutHelper {
    public WorkOut[] workout_array;
    WorkOutHelper(){
        workout_array  = new WorkOut[]{
                new WorkOut(){{
                    level = 0;
                    workout_type = new String[]{"push ups","squat jumps","step ups"};
                    workout_count =  new int[]{1,2,3};

                }},
                new WorkOut(){{
                    level = 1;
                    workout_type = new String[]{"mountain climbers","plank jacks","lunge jumps"};
                    workout_count =  new int[]{7,8,9};
                }}
        };
    }
}
