package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 5})
public class uc {
    public static com.byazt.sd.g hw;
    public static final Map<String, pr> pr = Collections.synchronizedMap(new HashMap());

    public interface pr {
        void pr();

        void pr(String str);
    }

    public static void pr(String str, String[] strArr, pr prVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.pr(str, strArr);
    }

    public static void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.iy.hw.pr()) {
            com.byazt.xlm.c.hn().execute(new com.byazt.xlm.fw("handleYes", 5) { // from class: com.byazt.wt.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uc.hw().pr(str, (String) null);
                    } catch (Throwable th) {
                    }
                }
            });
        } else {
            pr prVarHw = hw(str);
            if (prVarHw == null) {
                return;
            }
            prVarHw.pr();
        }
    }

    public static void pr(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.iy.hw.pr()) {
            com.byazt.xlm.c.hn().execute(new com.byazt.xlm.fw("handleNo", 5) { // from class: com.byazt.wt.uc.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uc.hw().pr(str, str2);
                    } catch (Throwable th) {
                    }
                }
            });
        } else {
            pr prVarHw = hw(str);
            if (prVarHw == null) {
                return;
            }
            prVarHw.pr(str2);
        }
    }

    private static void pr(final String str, final pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        if (com.byazt.iy.hw.pr()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("addListener") { // from class: com.byazt.wt.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.ca.ho.hw("MultiProcess", "getListenerManager().registerPermissionListener...");
                        uc.hw().pr(str, new com.byazt.ku.hw(prVar));
                    } catch (Throwable th) {
                        com.byazt.ca.ho.hw("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            pr.put(str, prVar);
        }
    }

    private static pr hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return pr.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.sd.g hw() {
        if (hw == null) {
            hw = com.byazt.us.x.pr(com.byazt.gt.pr.pr(com.byazt.sd.a.getContext()).pr(4));
        }
        return hw;
    }
}
