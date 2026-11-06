package com.byazt.vo;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ap.x;
import com.byazt.fb.l;
import com.byazt.np.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 8})
public class s implements l {
    public d n;
    public n q;
    public com.byazt.pch.n qg;
    public x s;

    public s(Context context, com.byazt.pch.n nVar, x xVar) {
        this.qg = nVar;
        if (nVar != null) {
            this.n = new d(context);
            this.s = xVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        HashMap map = new HashMap();
        String strOa = this.qg.oa();
        if (!TextUtils.isEmpty(strOa)) {
            map.put(MediationConstant.ADN_GDT, strOa);
        }
        this.n.n(new com.byazt.qn.qg(7, this.qg.lh(), this.qg.an()), new com.byazt.me.qg() { // from class: com.byazt.vo.s.1
            @Override // com.byazt.me.qg
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || s.this.s == null) {
                    return;
                }
                s.this.s.n(nVar.n, nVar.qg);
            }

            @Override // com.byazt.me.qg
            public void n() {
                if (s.this.s != null) {
                    if (s.this.q == null) {
                        s.this.q = new n(s.this.n);
                    }
                    s.this.s.n(s.this.q);
                }
            }

            @Override // com.byazt.me.qg
            public void qg() {
                if (s.this.s != null) {
                    s.this.s.n();
                    if (s.this.q == null) {
                        s.this.q = new n(s.this.n);
                    }
                    s.this.s.qg(s.this.q);
                }
            }
        });
    }
}
