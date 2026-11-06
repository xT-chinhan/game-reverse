package com.byazt.yb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 13})
public class w extends s<com.byazt.bo.n> {
    public final Context n;

    @Override // com.byazt.yb.s, com.byazt.yb.hd
    public /* bridge */ /* synthetic */ boolean qg(Context context) {
        return super.qg(context);
    }

    public w(Context context) {
        super("com.coolpad.deviceidsupport");
        this.n = context;
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bo.n, String> n() {
        return new hu.qg<com.byazt.bo.n, String>() { // from class: com.byazt.yb.w.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.n qg(IBinder iBinder) {
                return com.byazt.bo.n.AbstractBinderC0140n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.n nVar) throws Exception {
                if (nVar == null) {
                    return null;
                }
                return nVar.qg(w.this.n.getPackageName());
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.byazt.yb.s, com.byazt.yb.hd
    public hd.n s(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                hd.n nVar = new hd.n();
                nVar.qg = string;
                return nVar;
            }
        } catch (Throwable unused) {
        }
        return super.s(context);
    }
}
