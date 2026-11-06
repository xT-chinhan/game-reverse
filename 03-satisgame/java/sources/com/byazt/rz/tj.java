package com.byazt.rz;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static Map<String, n> n = Collections.synchronizedMap(new HashMap());

    public interface n {
        void n();

        void n(String str);
    }

    public static void n(String[] strArr, n nVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        n(strValueOf, nVar);
        TTDelegateActivity.n(strValueOf, strArr);
    }

    public static void n(String str) {
        n nVarS;
        if (TextUtils.isEmpty(str) || (nVarS = s(str)) == null) {
            return;
        }
        nVarS.n();
    }

    public static void n(String str, String str2) {
        n nVarS;
        if (TextUtils.isEmpty(str) || (nVarS = s(str)) == null) {
            return;
        }
        nVarS.n(str2);
    }

    private static void n(String str, n nVar) {
        if (TextUtils.isEmpty(str) || nVar == null) {
            return;
        }
        n.put(str, nVar);
    }

    private static n s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.remove(str);
    }

    public static boolean qg(String str) {
        return com.byazt.ug.d.l().n(com.byazt.ug.d.getContext(), str);
    }
}
