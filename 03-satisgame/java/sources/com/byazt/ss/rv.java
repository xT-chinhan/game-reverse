package com.byazt.ss;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public rv(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        if (this.w == null || this.w.size() <= 0) {
            return;
        }
        Object obj = this.w.get("id");
        if (obj == null) {
            n(this.s);
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            n(this.s);
            return;
        }
        com.byazt.ih.s sVarQg = this.s.qg(this.s);
        if (sVarQg == null) {
            return;
        }
        n(sVarQg.q(strValueOf));
    }

    private void n(com.byazt.ih.s sVar) {
        Object obj;
        if (sVar == null) {
            return;
        }
        boolean z = false;
        for (String str : this.w.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id") && (obj = this.w.get(str)) != null) {
                sVar.n(str, String.valueOf(obj));
                z |= !"visibility".equals(str);
            }
        }
        if (z) {
            sVar.n(this.w.containsKey("width"), this.w.containsKey("height"));
            sVar.qg();
        }
    }
}
