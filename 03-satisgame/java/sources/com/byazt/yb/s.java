package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 8})
public abstract class s<SERVICE> implements hd {
    public final String n;
    public qg<Boolean> qg = new qg<Boolean>() { // from class: com.byazt.yb.s.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Boolean n(Object... objArr) {
            return Boolean.valueOf(fs.n((Context) objArr[0], s.this.n));
        }
    };

    public abstract Intent n(Context context);

    public abstract hu.qg<SERVICE, String> n();

    public s(String str) {
        this.n = str;
    }

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        if (context == null) {
            return false;
        }
        return this.qg.qg(context).booleanValue();
    }

    @Override // com.byazt.yb.hd
    public hd.n s(Context context) {
        return n((String) new hu(context, n(context), n()).n());
    }

    private hd.n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hd.n nVar = new hd.n();
        nVar.qg = str;
        return nVar;
    }
}
