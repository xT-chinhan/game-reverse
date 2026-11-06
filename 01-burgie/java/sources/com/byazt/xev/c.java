package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c extends hn<com.byazt.otj.uc> {
    public c() {
        super("com.mdid.msa");
    }

    @Override // com.byazt.xev.hn, com.byazt.xev.yb
    public yb.pr hn(Context context) {
        pr(context, context.getPackageName());
        return super.hn(context);
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.otj.uc, String> pr() {
        return new z.hw<com.byazt.otj.uc, String>() { // from class: com.byazt.xev.c.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.uc hw(IBinder iBinder) {
                return com.byazt.otj.uc.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.uc ucVar) throws Exception {
                if (ucVar == null) {
                    return null;
                }
                return ucVar.pr();
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void pr(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            com.byazt.ec.w.pr(e);
        }
    }
}
