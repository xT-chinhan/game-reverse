package com.byazt.y;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ca.uc;
import com.byazt.nzn.k;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 13})
public class hw {
    public static Context hw = null;
    public static String hn = null;
    public static boolean x = false;
    public static k c = null;
    public static int uc = 1;
    public static boolean pr = false;

    public static Context getContext() {
        return hw;
    }

    public static String pr() {
        if (TextUtils.isEmpty(hn)) {
            try {
                File file = new File(uc.pr(getContext(), false, null), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                hn = file.getAbsolutePath();
            } catch (Throwable th) {
            }
        }
        return hn;
    }

    public static void pr(Context context, String str) {
        hw = context.getApplicationContext();
        hn = str;
    }

    public static boolean hw() {
        return x;
    }

    public static void pr(boolean z) {
        x = z;
    }

    public static k hn() {
        if (c == null) {
            c = new k.pr("v_config").pr(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hw(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hn(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).pr();
        }
        return c;
    }

    public static void pr(k kVar) {
        c = kVar;
    }

    public static boolean x() {
        return pr;
    }

    public static int c() {
        return uc;
    }
}
