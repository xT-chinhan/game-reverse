package com.byazt.ie;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 113})
public class d implements n {
    public final long n = 500;

    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        if (qgVarN.cy() == null && qgVarN.wm().um() == 3 && !com.byazt.qt.qg.n().u() && qgVarN.j() != null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "执行开启开屏兜底...............");
            n(interfaceC0201n, qgVarN, qgVarN.wm(), qgVarN.j());
        } else {
            interfaceC0201n.n(qgVarN);
        }
    }

    public void n(final n.InterfaceC0201n interfaceC0201n, final com.byazt.zb.qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.jp.cp cpVar) {
        if (cpVar != null && qgVar2 != null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar2.a()) + "settings config.......AdUnitId = " + qgVar2.a() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.byazt.sg.n.n(cpVar.n()));
        }
        com.byazt.gp.s.qg(qgVar2, -4);
        com.byazt.rb.qg.q(MediationConstant.TAG, "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + cpVar.n() + " getAppId = " + cpVar.s() + " getAppKey = " + cpVar.q() + " getAdNetworkSlotId = " + cpVar.qg());
        if (cpVar == null || TextUtils.isEmpty(cpVar.qg()) || (TextUtils.isEmpty(cpVar.s()) && TextUtils.isEmpty(cpVar.q()))) {
            n(qgVar, 840027);
            qgVar.n(new com.byazt.mj.n(840027, com.byazt.mj.n.n(840027)));
            return;
        }
        int iN = cpVar.n();
        final String strN = com.byazt.sg.n.n(iN);
        final String strQg = cpVar.qg();
        if (TextUtils.isEmpty(strN)) {
            n(qgVar, 840027);
            qgVar.n(new com.byazt.mj.n(840027, com.byazt.mj.n.n(840027)));
            return;
        }
        if (iN == 3) {
            new com.byazt.ww.n(cpVar).n(cpVar);
            Looper looperQg = com.byazt.rb.l.qg();
            if (looperQg != null) {
                new Handler(looperQg).postDelayed(new Runnable() { // from class: com.byazt.ie.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.n(interfaceC0201n, qgVar, strN, strQg);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (iN == 7 || iN == 6 || iN == 4 || iN == 8) {
            new com.byazt.ww.n(cpVar).n(cpVar);
            n(interfaceC0201n, qgVar, strN, strQg);
        } else if (iN == 1 || iN == 9) {
            new com.byazt.ww.n(cpVar).n(cpVar, new com.byazt.ju.s() { // from class: com.byazt.ie.d.2
                @Override // com.byazt.ju.s
                public void n() {
                    d.this.n(interfaceC0201n, qgVar, strN, strQg);
                }

                @Override // com.byazt.ju.s
                public void n(com.byazt.mj.n nVar) {
                    d.this.n(qgVar, 840027);
                    qgVar.n(new com.byazt.mj.n(840027, com.byazt.mj.n.n(840027)));
                }
            });
        } else {
            n(qgVar, 840027);
            qgVar.n(new com.byazt.mj.n(840027, com.byazt.mj.n.n(840027)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.zb.qg qgVar, int i) {
        com.byazt.gp.s.n(qgVar.wm(), (String) null, !qgVar.h(), qgVar.fi().n, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(n.InterfaceC0201n interfaceC0201n, com.byazt.zb.qg qgVar, String str, String str2) {
        qgVar.n(n(qgVar.wm().a(), str, str2));
        interfaceC0201n.n(qgVar);
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }

    private com.byazt.ws.qg n(String str, String str2, String str3) {
        com.byazt.ws.tj tjVarN = com.byazt.sq.s.n(str3, str2, -4, -4);
        if (tjVarN == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(tjVarN);
        com.byazt.ws.qg qgVar = new com.byazt.ws.qg();
        qgVar.q(str);
        qgVar.cy(3);
        qgVar.l(400L);
        qgVar.w(2000L);
        qgVar.x(5000L);
        qgVar.fs(3000L);
        qgVar.n(arrayList);
        return qgVar;
    }
}
