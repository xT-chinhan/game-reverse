package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 113})
public class d extends s<com.byazt.bgo.qg> {
    public final tj n;
    public final cp qg;

    @Override // com.byazt.yb.s, com.byazt.yb.hd
    public /* bridge */ /* synthetic */ boolean qg(Context context) {
        return super.qg(context);
    }

    public d() {
        super("com.hihonor.id");
        this.n = new tj();
        this.qg = new cp();
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bgo.qg, String> n() {
        return new hu.qg<com.byazt.bgo.qg, String>() { // from class: com.byazt.yb.d.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bgo.qg qg(IBinder iBinder) {
                return com.byazt.bgo.qg.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bgo.qg qgVar) throws Exception {
                if (qgVar == null) {
                    com.byazt.tk.k.qg("honor# ", "service is null");
                    return null;
                }
                qgVar.n(d.this.n);
                qgVar.qg(d.this.qg);
                return "";
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.byazt.yb.s, com.byazt.yb.hd
    public hd.n s(Context context) {
        new hu(context, n(context), n()).n();
        hd.n nVar = new hd.n();
        nVar.qg = this.n.n();
        nVar.s = this.qg.n();
        return nVar;
    }
}
