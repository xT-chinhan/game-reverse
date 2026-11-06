package com.byazt.gx;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 26})
public class qg {
    public static String n;

    public static String n(Context context) {
        if (n == null) {
            String[] strArrN = s.n(new File(context.getApplicationInfo().sourceDir));
            String str = strArrN[0];
            n = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrN[2]);
            }
        }
        return n;
    }

    public static boolean n() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
