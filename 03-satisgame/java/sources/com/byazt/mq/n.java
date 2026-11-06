package com.byazt.mq;

import android.text.TextUtils;
import com.byazt.ih.s;
import com.byazt.xz.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE, 19})
public class n extends com.byazt.ss.n {
    public final String rv;

    public n(s sVar, String str, x.n nVar, String str2) {
        super(sVar, str, nVar);
        this.rv = str2;
    }

    @Override // com.byazt.ss.n
    public void n() {
        int iL;
        s sVarQg;
        Object obj = this.w != null ? this.w.get("exec_condition") : null;
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            if ((obj instanceof String) && "false".equalsIgnoreCase((String) obj)) {
                return;
            }
            String strN = n("id");
            if (this.s == null || TextUtils.isEmpty(strN) || (iL = l()) == Integer.MIN_VALUE || (sVarQg = this.s.qg(this.s)) == null) {
                return;
            }
            s sVarQ = sVarQg.q(strN);
            if (sVarQ instanceof com.byazt.sj.s) {
                com.byazt.sj.s sVar = (com.byazt.sj.s) sVarQ;
                if (sVar.fs() == null) {
                    return;
                }
                if ("game_action".equals(this.rv)) {
                    sVar.fs().qg(n("action"), iL);
                } else {
                    sVar.fs().n(this.rv, iL);
                }
            }
        }
    }

    private int l() {
        String strN = n("levelId");
        if (TextUtils.isEmpty(strN)) {
            strN = n("level");
        }
        if (TextUtils.isEmpty(strN)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(strN.trim());
        } catch (Throwable unused) {
            return Integer.MIN_VALUE;
        }
    }

    private String n(String str) {
        Object obj = this.w != null ? this.w.get(str) : null;
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }
}
