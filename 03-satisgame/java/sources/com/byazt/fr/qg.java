package com.byazt.fr;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 671, 26})
public class qg {
    public static boolean n() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        int i = calendar.get(7);
        return i == 1 || i == 7;
    }

    public static boolean qg() {
        return Calendar.getInstance().get(11) >= 18;
    }

    public static boolean s() {
        int i = Calendar.getInstance().get(11);
        return i >= 6 && i < 18;
    }
}
