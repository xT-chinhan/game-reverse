package com.byazt.s;

import com.byazt.rz.d;
import com.byazt.rz.oa;
import com.byazt.z.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static final String n = "rv";
    public static boolean qg = false;

    @com.byazt.cp.n(n = {0, 1, 8, 160})
    private static class n {
        public static rv n = new rv();
    }

    private rv() {
    }

    public static rv n() {
        return n.n;
    }

    public void n(com.byazt.vl.l lVar, final com.byazt.h.qg qgVar) {
        if (!com.byazt.rz.l.s(qgVar)) {
            d.n().n(n, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (qgVar == null) {
            d.n().qg(n, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (qgVar.pe()) {
            d.n().qg(n, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            d dVarN = d.n();
            String str = n;
            dVarN.n(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.byazt.rz.l.q(qgVar)) {
                d.n().n(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.byazt.ug.d.rv().optInt("market_install_finish_check_time", 600);
                if (qgVar.kc() == 0 || System.currentTimeMillis() - qgVar.kc() > ((long) iOptInt) * 1000) {
                    qgVar.tj(System.currentTimeMillis());
                    n(iOptInt, new k() { // from class: com.byazt.s.rv.1
                        @Override // com.byazt.z.k
                        public void n() {
                            d.n().n(rv.n, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - qgVar.kc()));
                            qgVar.tj(true);
                            com.byazt.vl.w.n().n(qgVar);
                        }

                        @Override // com.byazt.z.k
                        public void qg() {
                            d.n().n(rv.n, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!oa.qg(qgVar)) {
                                d.n().n(rv.n, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            qgVar.tj(false);
                            com.byazt.vl.w.n().n(qgVar);
                        }
                    });
                } else {
                    d.n().n(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.byazt.rz.l.l(qgVar)) {
                d.n().n(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.byazt.ug.oa.n().n(qgVar);
            }
            com.byazt.vl.rv.n().n(qgVar);
        } catch (Exception unused) {
            com.byazt.ch.s.n().n(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void n(final com.byazt.h.qg qgVar) {
        if (!com.byazt.rz.l.s(qgVar)) {
            d.n().n(n, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (qgVar == null) {
            d.n().qg(n, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (qgVar.l.get() && System.currentTimeMillis() - qgVar.kc() > 30000) {
            d.n().n(n, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.byazt.rz.l.q(qgVar)) {
            long jOptInt = ((long) com.byazt.ug.d.rv().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - qgVar.kc() >= jOptInt) {
                d.n().n(n, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                n((int) (((qgVar.kc() + jOptInt) - System.currentTimeMillis()) / 1000), new k() { // from class: com.byazt.s.rv.2
                    @Override // com.byazt.z.k
                    public void n() {
                        d.n().n(rv.n, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        qgVar.l.compareAndSet(false, true);
                        com.byazt.vl.rv.n().n(qgVar);
                    }

                    @Override // com.byazt.z.k
                    public void qg() {
                        d.n().n(rv.n, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!oa.qg(qgVar)) {
                            d.n().n(rv.n, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        qgVar.l.compareAndSet(true, false);
                        qgVar.tj(false);
                        com.byazt.vl.rv.n().n(qgVar);
                    }
                });
            }
        }
    }

    public void n(int i, k kVar) {
        d.n().n(n, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!qg) {
            com.byazt.e.q.cp().n(kVar);
            qg = true;
        }
        com.byazt.e.q.cp().n(i);
    }
}
