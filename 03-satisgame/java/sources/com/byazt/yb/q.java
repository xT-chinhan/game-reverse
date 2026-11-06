package com.byazt.yb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 5})
public final class q {
    public static qg<String> n = new qg<String>() { // from class: com.byazt.yb.q.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public String n(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("cdid", string2).apply();
            return string2;
        }
    };

    public static String n(SharedPreferences sharedPreferences) {
        return n.qg(sharedPreferences);
    }
}
