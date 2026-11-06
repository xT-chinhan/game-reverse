package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 18})
public final class l extends s<com.byazt.bo.w> {
    public l() {
        super("com.mdid.msa");
    }

    @Override // com.byazt.yb.s, com.byazt.yb.hd
    public hd.n s(Context context) {
        n(context, context.getPackageName());
        return super.s(context);
    }

    @Override // com.byazt.yb.s
    public hu.qg<com.byazt.bo.w, String> n() {
        return new hu.qg<com.byazt.bo.w, String>() { // from class: com.byazt.yb.l.1
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.w qg(IBinder iBinder) {
                return com.byazt.bo.w.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.w wVar) throws Exception {
                if (wVar == null) {
                    return null;
                }
                return wVar.n();
            }
        };
    }

    @Override // com.byazt.yb.s
    public Intent n(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void n(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            com.byazt.km.cp.n(e);
        }
    }
}
