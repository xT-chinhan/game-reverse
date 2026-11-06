package com.byazt.ca;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 19})
public final class ho {
    public static com.byazt.utw.pr hn;
    public static boolean pr = false;
    public static int hw = 4;
    public static String x = "";

    public static void pr(com.byazt.utw.pr prVar) {
        hn = prVar;
    }

    public static void pr(int i) {
        hw = i;
    }

    public static boolean pr() {
        return hw <= 3;
    }

    public static void hw() {
        pr = true;
        pr(3);
    }

    public static boolean hn() {
        return pr;
    }

    public static void pr(String str, String str2) {
        com.byazt.utw.pr prVar = hn;
        if (prVar != null) {
            prVar.pr(hw(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        hw(str);
    }

    public static void pr(String str) {
        if (!pr) {
            return;
        }
        hw("Logger", str);
    }

    public static void hw(String str, String str2) {
        com.byazt.utw.pr prVar = hn;
        if (prVar != null) {
            prVar.hw(hw(str), str2);
        }
        if (pr && str2 != null && hw <= 6) {
            Log.e(hw(str), str2);
        }
    }

    public static void pr(String str, String str2, Throwable th) {
        com.byazt.utw.pr prVar = hn;
        if (prVar != null) {
            prVar.pr(hw(str), str2, th);
        }
        if (!pr) {
            return;
        }
        if ((str2 != null || th != null) && hw <= 6) {
            Log.e(hw(str), str2, th);
        }
    }

    public static void pr(String str, Throwable th) {
        pr(str, "", th);
    }

    public static void pr(String str, Object... objArr) {
        com.byazt.utw.pr prVar = hn;
        if (prVar != null) {
            prVar.hw(hw(str), pr(objArr));
        }
        if (pr && objArr != null && hw <= 6) {
            Log.e(hw(str), pr(objArr));
        }
    }

    private static String pr(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String hw(String str) {
        return TextUtils.isEmpty(x) ? str : pr("[" + x + "]-[" + str + "]");
    }
}
