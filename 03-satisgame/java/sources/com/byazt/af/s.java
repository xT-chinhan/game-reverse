package com.byazt.af;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 8})
public class s {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    public static int n(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }
}
