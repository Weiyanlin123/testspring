package com.citycloud.dcm.street.test.enumtest;

public class TEST {

    public static void main(String[] args) {
        Color[] values = Color.values();

        for (int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }

        System.out.println(values.length);
    }
}
