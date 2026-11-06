package com.byazt.yb;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 210})
public final class k implements hd {
    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.byazt.yb.hd
    public hd.n s(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                hd.n nVar = new hd.n();
                nVar.qg = bundleCall.getString("id");
                return nVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                com.byazt.km.cp.qg(string);
            }
            return null;
        } catch (Exception e) {
            com.byazt.km.cp.n(e);
            return null;
        }
    }
}
