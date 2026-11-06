package com.byazt.vy;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 113})
public class d {
    public static final HashSet n = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String n() {
        StackTraceElement[] stackTrace;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && !n.contains(stackTraceElement.getClassName() + i.E + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError unused2) {
            return "";
        }
    }

    public static String n(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (n(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError unused) {
            return "";
        }
    }

    private static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Class.forName(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String qg() {
        StackTraceElement[] stackTrace;
        Map<String, List<String>> mapY;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace != null && stackTrace.length != 0 && (mapY = com.byazt.qt.qg.n().y()) != null && !mapY.isEmpty()) {
            for (String str : mapY.keySet()) {
                if (n(mapY.get(str), stackTrace)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static boolean n(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i))) {
                                return true;
                            }
                        } catch (OutOfMemoryError unused) {
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean n(com.byazt.sg.s sVar) {
        if (sVar == null || !sVar.rg()) {
            return false;
        }
        return q();
    }

    public static boolean n(com.byazt.ws.tj tjVar) {
        if (tjVar == null || !tjVar.oj()) {
            return false;
        }
        return q();
    }

    private static boolean q() {
        Map<String, List<String>> mapY = com.byazt.qt.qg.n().y();
        if (mapY == null || mapY.size() == 0) {
            return false;
        }
        return n(com.byazt.qt.qg.n().rf());
    }

    public static boolean n(double d) {
        return d > 0.0d && Math.random() <= d;
    }

    public static double s() {
        return com.byazt.qt.qg.n().rf();
    }
}
