package com.example.algorithm.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseTool {

    public static void getLight() {

        boolean[] lights = new boolean[100];
        Arrays.fill(lights, false);

        for (int i = 0; i < 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if ((i + 1) % j == 0) {
                    lights[i] = !lights[i];
                }
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (lights[i]) {
                list.add(i+1);
            }
        }
        return;

    }

}
