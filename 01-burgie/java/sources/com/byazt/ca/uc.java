package com.byazt.ca;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 5})
public final class uc {
    public static File pr(Context context, boolean z, String str) {
        File filePr;
        if (context == null || (filePr = com.byazt.mg.hw.pr(context)) == null) {
            return null;
        }
        if (z && !TextUtils.isEmpty(str)) {
            return new File(filePr.getParent(), filePr.getName() + "_" + str);
        }
        return filePr;
    }

    public static File hw(Context context, boolean z, String str) {
        File fileHw;
        if (context == null || (fileHw = com.byazt.mg.hw.hw(context)) == null) {
            return null;
        }
        if (z && !TextUtils.isEmpty(str)) {
            return new File(fileHw.getParent(), fileHw.getName() + "_" + str);
        }
        return fileHw;
    }

    public static File hn(Context context, boolean z, String str) {
        return pr(context, null, z, str);
    }

    public static File pr(Context context, String str, boolean z, String str2) {
        File filePr;
        if (context == null || (filePr = com.byazt.mg.hw.pr(context, str)) == null) {
            return null;
        }
        if (z && !TextUtils.isEmpty(str2)) {
            return new File(filePr.getParent(), filePr.getName() + "_" + str2);
        }
        return filePr;
    }

    public static File x(Context context, boolean z, String str) {
        File fileHn;
        if (context == null || (fileHn = com.byazt.mg.hw.hn(context)) == null) {
            return null;
        }
        if (z && !TextUtils.isEmpty(str)) {
            return new File(fileHn.getParent(), fileHn.getName() + "_" + str);
        }
        return fileHn;
    }
}
