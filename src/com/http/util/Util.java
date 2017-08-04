package com.http.util;

import com.sun.istack.internal.Nullable;

/**
 * Created by smart on 2017/8/3.
 */
public class Util {
    private static boolean log  = true;
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
    public static void logInfo(String msg){
        if (log) {
            System.out.println(msg);
        }
    }
}
