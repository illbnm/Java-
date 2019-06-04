package src.Collection;

import java.util.Arrays;

public class 拷贝 {
    public static void main(String[] args) {
        Integer[] arr = {1, 45, 65, 76, 89, 33, 98, 77};
        Integer[] brr = new Integer[arr.length];
       Integer[] crr = new Integer[arr.length];
        crr = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.copyOf"+ Arrays.toString(crr));
        System.arraycopy(arr, 0, brr, 0, brr.length);
        System.out.println("System.arraycopy"+ Arrays.toString(brr));
        Integer []drr = arr.clone();
        System.out.println("clone"+Arrays.toString(drr));


        System.out.println("Arrays.copyOf"+ Arrays.toString(crr));
        System.out.println("System.arraycopy"+ Arrays.toString(brr));

        System.out.println("clone"+Arrays.toString(drr));

    }


}
