package com.example.algorithm.exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTool {

    public static void getLight() {

        boolean[] lights = new boolean[100];

        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100; j++) {
                if (100 % j == 0) {
                    lights[i] = !lights[i];
                }
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (lights[i]) {
                list.add(i);
            }
        }
        return;

    }

}
