package com.bytedance.sdk.openadsdk.core.pc.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final List<String> f3275ms = new ArrayList(Arrays.asList("1", "3", "2"));

    private static String ms(String str) {
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

    public static String ms() {
        String strH = t.h();
        String strY = t.y();
        String strQv = t.qv();
        String strT = t.t();
        if (!t.ao()) {
            return "5";
        }
        if (TextUtils.isEmpty(strH) || TextUtils.isEmpty(strY)) {
            return (TextUtils.isEmpty(strQv) || TextUtils.isEmpty(strT)) ? "4" : ms(strQv + strT);
        }
        if (TextUtils.isEmpty(strQv) || TextUtils.isEmpty(strT)) {
            return ms(strH + strY);
        }
        String strMs = ms(strH + strY);
        String strMs2 = ms(strQv + strT);
        List<String> list = f3275ms;
        if (list.contains(strMs) && list.contains(strMs2) && !strMs2.equals(strMs)) {
            return "6";
        }
        if (list.contains(strMs)) {
            return strMs;
        }
        return list.contains(strMs2) ? strMs2 : "0";
    }
}
