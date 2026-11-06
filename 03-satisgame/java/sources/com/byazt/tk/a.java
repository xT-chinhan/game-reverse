package com.byazt.tk;

import android.content.Context;
import android.content.res.Resources;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public final class a {
    public static Context n = null;
    public static boolean q = false;
    public static Resources qg = null;
    public static boolean s = false;

    public static Resources n(Context context) {
        Resources resources = qg;
        if (resources == null) {
            resources = null;
        }
        Context context2 = n;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }
}
