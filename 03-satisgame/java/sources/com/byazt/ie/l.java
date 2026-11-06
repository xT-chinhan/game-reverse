package com.byazt.ie;

import android.text.TextUtils;
import com.byazt.vy.py;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 18})
public class l implements n {
    private int n(int i) {
        switch (i) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        com.byazt.qn.qg qgVarWm = qgVarN.wm();
        com.byazt.pu.n nVar = !com.byazt.qt.qg.n().n(qgVarN.wm().a(), qgVarN.wm().um()) ? new com.byazt.pu.n(840031, com.byazt.mj.n.n(840031)) : null;
        if (nVar == null && !com.byazt.qt.qg.n().qg(qgVarN.wm().um())) {
            nVar = new com.byazt.pu.n(n(qgVarN.wm().um()), com.byazt.mj.n.n(n(qgVarN.wm().um())));
        }
        if (nVar == null && !com.byazt.it.s.qg()) {
            nVar = new com.byazt.pu.n(1, com.byazt.mj.n.n(1));
        }
        if (nVar == null && qgVarN.tj()) {
            nVar = new com.byazt.pu.n(41044, com.byazt.mj.n.n(41044));
        }
        if (nVar == null && qgVarN.getContext() == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "Context为null！！！");
            nVar = new com.byazt.pu.n(41005, com.byazt.mj.n.n(41005));
        }
        if (nVar == null && TextUtils.isEmpty(qgVarN.wm().a())) {
            nVar = new com.byazt.pu.n(840026, "广告位id不能为空");
        }
        if (nVar == null && (qgVarN.cy() == null || py.n(qgVarN.cy().y()))) {
            if (com.byazt.ir.q.n().s()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVarWm.a()) + "settings config.......没有settings config配置信息,AdUnitId = " + qgVarWm.a());
                nVar = new com.byazt.pu.n(840040, com.byazt.mj.n.n(840040));
                com.byazt.gp.s.qg(qgVarWm, 1);
            } else if (qgVarN.cy() != null && py.n(qgVarN.cy().y())) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVarWm.a()) + "settings config.......注意，AdUnitId = " + qgVarWm.a() + "  没有对应的waterfall配置信息");
                com.byazt.gp.s.qg(qgVarWm, 3);
            } else {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVarWm.a()) + "settings config.......注意，AdUnitId = " + qgVarWm.a() + " 的配置信息为 null ！！");
                nVar = new com.byazt.pu.n(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.byazt.gp.s.qg(qgVarWm, 2);
            }
            com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(1);
        }
        if (nVar == null) {
            String strDf = qgVarWm.df();
            if (!TextUtils.isEmpty(strDf) && !qgVarWm.oj() && !com.byazt.yc.q.n(qgVarWm.a(), strDf)) {
                nVar = new com.byazt.pu.n(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.byazt.pu.n nVar2 = nVar;
        if (nVar2 != null) {
            com.byazt.gp.s.n(qgVarWm, qgVarN.cy() != null ? qgVarN.cy().rf() : null, !qgVarN.h(), qgVarN.fi().n, nVar2.n, (Map<String, Object>) null);
            qgVarN.n(nVar2);
        } else {
            interfaceC0201n.n(interfaceC0201n.n());
        }
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        if (qgVarN.tj()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "调用过销毁方法_destroy()！！！");
            qgVarN.n(new com.byazt.mj.n(41044, com.byazt.mj.n.n(41044)));
        } else if (qgVarN.hd().l()) {
            qgVarN.n(new com.byazt.mj.n(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0201n.n((String) null);
        }
    }
}
