package org.example.allnewfeaturesinjava27.vectorapi;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Arrays;

public class VectorApiDemo {
    private static final VectorSpecies<Integer> INT_SPECIES = IntVector.SPECIES_PREFERRED;
    private static final VectorSpecies<Float> FLOAT_SPECIES = FloatVector.SPECIES_PREFERRED;

    public static int[] addScalar(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array lengths must match");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public static int[] addVector(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array lengths must match");
        }
        int[] result = new int[a.length];
        int i = 0;
        int bound = INT_SPECIES.loopBound(a.length);
        for (; i < bound; i += INT_SPECIES.length()) {
            IntVector va = IntVector.fromArray(INT_SPECIES, a, i);
            IntVector vb = IntVector.fromArray(INT_SPECIES, b, i);
            IntVector sum = va.add(vb);
            sum.intoArray(result, i);
        }
        for (; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public static float[] brightenScalar(float[] pixels, float factor) {
        float[] result = new float[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            float adjusted = pixels[i] * factor;
//            result[i] = Math.max(0.0f, Math.min(255.0f, adjusted));
            result[i] = Math.clamp(adjusted, 0.0f, 255.0f);
        }
        return result;
    }

    public static float[] brightenVector(float[] pixels, float factor) {
        float[] result = new float[pixels.length];
        int i = 0;
        int bound = FLOAT_SPECIES.loopBound(pixels.length);
        for (; i < bound; i += FLOAT_SPECIES.length()) {
            FloatVector values = FloatVector.fromArray(FLOAT_SPECIES, pixels, i);
            FloatVector adjusted = values.mul(factor).min(255.0f).max(0.0f);
            adjusted.intoArray(result, i);
        }
        for (; i < pixels.length; i++) {
            float adjusted = pixels[i] * factor;
            result[i] = Math.clamp(adjusted, 0.0f, 255.0f);
        }
        return result;
    }

    void main() {
        IO.println("=== JAVA 27 VECTOR API ===");
        IO.println("Integer vector lanes: " + INT_SPECIES.length());
        IO.println("Float vector lanes: " + FLOAT_SPECIES.length());
        int[] a = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100,
                110, 120, 130, 140, 150,
                160, 170, 180, 190
        };
        int[] b = {
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19
        };
        int[] normalResult = addScalar(a, b);
        int[] vectorResult = addVector(a, b);
        IO.println("\n=== ARRAY ADDITION ===");
        IO.println("Traditional: " + Arrays.toString(normalResult));
        IO.println("Vector API:  " + Arrays.toString(vectorResult));
        IO.println("Results match: " + Arrays.equals(normalResult, vectorResult));
        float[] pixels = {
                0, 20, 40, 80, 100,
                150, 180, 200, 240, 250,
                255, 5, 10, 60, 120,
                160, 190, 230, 254
        };
        float factor = 1.25f;
        float[] scalarPixels = brightenScalar(pixels, factor);
        float[] vectorPixels = brightenVector(pixels, factor);
        IO.println("\n=== IMAGE BRIGHTNESS ===");
        IO.println("Original:    " + Arrays.toString(pixels));
        IO.println("Traditional: " + Arrays.toString(scalarPixels));
        IO.println("Vector API:  " + Arrays.toString(vectorPixels));
        IO.println("Results match: " + Arrays.equals(scalarPixels, vectorPixels));
    }
}

