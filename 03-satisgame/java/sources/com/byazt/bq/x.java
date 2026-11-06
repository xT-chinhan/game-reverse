package com.byazt.bq;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 21})
public class x {
    public static final List<String> n = new ArrayList(Arrays.asList("1", "3", "2"));

    public static String n(Context context, com.byazt.vf.n nVar) {
        return n(s.n(context, nVar));
    }

    public static String n(String str) {
        str.hashCode();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return "0";
        }
    }

    public static String n(com.byazt.vf.n nVar, Context context) {
        String strL = s.l(nVar, context);
        String strX = s.x(nVar, context);
        String strW = s.w(nVar, context);
        String strFs = s.fs(nVar, context);
        if (!s.qg(context)) {
            return "5";
        }
        if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(strX)) {
            return (TextUtils.isEmpty(strW) || TextUtils.isEmpty(strFs)) ? "4" : n(strW + strFs);
        }
        if (TextUtils.isEmpty(strW) || TextUtils.isEmpty(strFs)) {
            return n(strL + strX);
        }
        String strN = n(strL + strX);
        String strN2 = n(strW + strFs);
        List<String> list = n;
        if (list.contains(strN) && list.contains(strN2) && !strN2.equals(strN)) {
            return "6";
        }
        if (list.contains(strN)) {
            return strN;
        }
        return list.contains(strN2) ? strN2 : "0";
    }
}
