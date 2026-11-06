package com.byazt.lp;

import android.content.Context;
import com.byazt.nd.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 26})
public class qg extends n {
    public final File n;

    public void n() {
        com.byazt.cmv.n.n(new Runnable() { // from class: com.byazt.lp.qg.1
            @Override // java.lang.Runnable
            public void run() {
                qg.this.qg();
            }
        });
    }

    public void qg() {
        com.byazt.nd.s.n().qg();
        Context context = q.getContext();
        if (context != null) {
            com.byazt.frl.s.n(context).n(1);
        }
        for (File file : this.n.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.lp.n
    public File s(String str) {
        return l(str);
    }

    @Override // com.byazt.lp.n
    public File q(String str) {
        return l(str);
    }

    public File l(String str) {
        return new File(this.n, str);
    }
}
