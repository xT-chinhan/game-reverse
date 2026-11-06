package com.byazt.osx;

import com.byazt.jv.gz;
import com.byazt.jv.lb;
import com.byazt.jv.m;
import com.byazt.jv.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public static final Pattern pr = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long pr(gz gzVar) {
        return pr(gzVar.zo());
    }

    public static long pr(lb lbVar) {
        return pr(lbVar.pr(Util.CONTENT_LENGTH));
    }

    private static long pr(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static Set<String> hw(lb lbVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iPr = lbVar.pr();
        for (int i = 0; i < iPr; i++) {
            if ("Vary".equalsIgnoreCase(lbVar.pr(i))) {
                String strHw = lbVar.hw(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strHw.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static lb hw(gz gzVar) {
        return pr(gzVar.w().hw().hn(), gzVar.zo());
    }

    public static lb pr(lb lbVar, lb lbVar2) {
        Set<String> setHw = hw(lbVar2);
        if (setHw.isEmpty()) {
            return new lb.pr().pr();
        }
        lb.pr prVar = new lb.pr();
        int iPr = lbVar.pr();
        for (int i = 0; i < iPr; i++) {
            String strPr = lbVar.pr(i);
            if (setHw.contains(strPr)) {
                prVar.pr(strPr, lbVar.hw(i));
            }
        }
        return prVar.pr();
    }

    public static void pr(m mVar, qa qaVar, lb lbVar) {
        if (mVar == m.pr) {
            return;
        }
        com.byazt.jv.k.pr(qaVar, lbVar).isEmpty();
    }

    public static boolean hn(gz gzVar) {
        if (gzVar.hw().hw().equals(Util.METHOD_HEAD)) {
            return false;
        }
        int iX = gzVar.x();
        return (((iX >= 100 && iX < 200) || iX == 204 || iX == 304) && pr(gzVar) == -1 && !"chunked".equalsIgnoreCase(gzVar.hw(Util.TRANSFER_ENCODING))) ? false : true;
    }

    public static int pr(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int pr(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int hw(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
