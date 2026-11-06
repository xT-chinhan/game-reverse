package com.byazt.qi;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 101})
public final class fs {
    public SharedPreferences n;

    public fs(Context context) {
        this.n = com.byazt.qyu.qg.qg(context, "npth", 0);
    }

    public void n(String str) {
        this.n.edit().putString(TapEventParamConstants.PARAM_DEVICE_ID, str).apply();
    }

    public String n() {
        String strL = com.byazt.qf.fs.n().l();
        return (TextUtils.isEmpty(strL) || "0".equals(strL)) ? this.n.getString(TapEventParamConstants.PARAM_DEVICE_ID, "0") : strL;
    }
}
