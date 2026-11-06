package com.byazt.as;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.jp.cp;
import com.byazt.np.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 8})
public class s implements com.byazt.oq.qg {
    public oa n;
    public boolean q;
    public com.byazt.pch.n qg;
    public com.byazt.ap.n s;

    public s(Context context, com.byazt.pch.n nVar, com.byazt.ap.n nVar2, boolean z) {
        this.qg = nVar;
        this.q = z;
        com.byazt.rb.qg.qg(MediationConstant.TAG, "CSJMSplashLoader 构造函数创建 mAdSlotValueSet = " + this.qg + " mAdSlotValueSet.getCodeId() = " + this.qg.q());
        if (this.qg != null) {
            this.n = new oa(context);
            this.s = nVar2;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        n(-1);
    }

    @Override // com.byazt.oq.qg
    public void n(int i) {
        final com.byazt.he.s sVarOa;
        com.byazt.rb.qg.qg(MediationConstant.TAG, "CSJMSplashLoader load timeout = ".concat(String.valueOf(i)));
        com.byazt.zs.n.n().qg();
        com.byazt.qn.qg qgVar = new com.byazt.qn.qg(3, this.qg.lh(), this.qg.an());
        qgVar.n(this.q);
        if (i != -1) {
            qgVar.w(i);
        }
        com.byazt.pch.qg qgVarUr = this.qg.ur();
        this.n.n(qgVar, (qgVarUr == null || (sVarOa = qgVarUr.oa()) == null || TextUtils.isEmpty(sVarOa.n()) || TextUtils.isEmpty(sVarOa.s()) || TextUtils.isEmpty(sVarOa.qg())) ? null : new cp() { // from class: com.byazt.as.s.1
            @Override // com.byazt.jp.cp
            public int n() {
                String strN = sVarOa.n();
                strN.hashCode();
                switch (strN) {
                    case "klevin":
                        return 9;
                    case "pangle":
                        return 1;
                    case "sigmob":
                        return 8;
                    case "xiaomi":
                        return 10;
                    case "ks":
                        return 7;
                    case "gdt":
                        return 3;
                    case "baidu":
                        return 6;
                    case "mintegral":
                        return 4;
                    default:
                        return super.n();
                }
            }

            @Override // com.byazt.jp.cp
            public String qg() {
                return sVarOa.qg();
            }

            @Override // com.byazt.jp.cp
            public String s() {
                return sVarOa.s();
            }

            @Override // com.byazt.jp.cp
            public String q() {
                return sVarOa.q();
            }
        }, new com.byazt.vv.s() { // from class: com.byazt.as.s.2
            @Override // com.byazt.vv.s
            public void n(com.byazt.mj.n nVar) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadFail");
                if (nVar == null || s.this.s == null) {
                    return;
                }
                com.byazt.fb.n nVar2 = new com.byazt.fb.n(nVar.n, nVar.qg);
                s.this.s.n(nVar2);
                s.this.s.n(null, nVar2);
            }

            @Override // com.byazt.vv.s
            public void n() {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadSuccess");
                if (s.this.s != null) {
                    n nVar = new n(s.this.n, s.this.s);
                    s.this.s.n(nVar);
                    s.this.s.qg(nVar);
                }
            }
        });
    }
}
