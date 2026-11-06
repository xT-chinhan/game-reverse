package com.byazt.uk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 50})
public class vk {
    public static Map<String, pr> pr = Collections.synchronizedMap(new HashMap());

    public interface pr {
        void pr();

        void pr(String str);
    }

    public static void pr(String[] strArr, pr prVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        pr(strValueOf, prVar);
        TTDelegateActivity.pr(strValueOf, strArr);
    }

    public static void pr(String str) {
        pr prVarHn;
        if (TextUtils.isEmpty(str) || (prVarHn = hn(str)) == null) {
            return;
        }
        prVarHn.pr();
    }

    public static void pr(String str, String str2) {
        pr prVarHn;
        if (TextUtils.isEmpty(str) || (prVarHn = hn(str)) == null) {
            return;
        }
        prVarHn.pr(str2);
    }

    private static void pr(String str, pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr.put(str, prVar);
    }

    private static pr hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return pr.remove(str);
    }

    public static boolean hw(String str) {
        return com.byazt.eld.k.c().pr(com.byazt.eld.k.getContext(), str);
    }
}
