package com.byazt.rd;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 89, 13})
public class hw {
    public static boolean pr() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        int i = calendar.get(7);
        return i == 1 || i == 7;
    }

    public static boolean hw() {
        return Calendar.getInstance().get(11) >= 18;
    }

    public static boolean hn() {
        int i = Calendar.getInstance().get(11);
        return i >= 6 && i < 18;
    }
}
