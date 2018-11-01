package com.jcoder.okhttpdemo;

import android.util.Log;

/**
 * @author wang
 * @date 2017/12/29.
 */

public class Logger {
    public static final String TAG = "pepe";
    public static boolean isRelease = false;

    public static void d(String msg) {
        if (!isRelease) {
            Log.d(TAG, getClassName() + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (!isRelease) {
            Log.d(tag, getClassName() + msg);
        }
    }

    public static void i(String msg) {
        if (!isRelease) {
            Log.i(TAG, getClassName() + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (!isRelease) {
            Log.i(tag, getClassName() + msg);
        }
    }

    public static void e(String msg) {
        if (!isRelease) {
            Log.e(TAG, getClassName() + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (!isRelease) {
            Log.e(tag, getClassName() + msg);
        }
    }

    private static String getClassName() {
        String result;
        // 这里的数组的index2是根据你工具类的层级做不同的定义，这里仅仅是关键代码
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1, result.length());
        return result + "   ";
    }
}
