package com.byazt.ug;

import android.os.SystemClock;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static final String n = "oa";

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 716})
    private static class qg {
        public static oa n = new oa();
    }

    private oa() {
    }

    public static oa n() {
        return qg.n;
    }

    public void n(com.byazt.h.qg qgVar) {
        com.byazt.rz.d.n().n(n, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.byazt.s.l.n().s(new n(qgVar));
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, TTAdConstant.IMAGE_URL_CODE})
    private class n implements Runnable {
        public final com.byazt.h.qg qg;

        public n(com.byazt.h.qg qgVar) {
            this.qg = qgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.qg.tj(true);
                oa.this.qg(this.qg);
            } catch (Exception unused) {
            } finally {
                this.qg.tj(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.h.qg qgVar) {
        JSONObject jSONObject = new JSONObject();
        int iN = com.byazt.rz.l.n(qgVar);
        int iQg = com.byazt.rz.l.qg(qgVar);
        if (com.byazt.rz.l.l(qgVar) && com.byazt.rz.l.q(qgVar)) {
            com.byazt.rz.d.n().n(n, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            n(qgVar, iN, iQg, jSONObject);
        } else {
            com.byazt.rz.d.n().n(n, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            qg(qgVar, 15, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, jSONObject);
        }
    }

    private void n(com.byazt.h.qg qgVar, int i, int i2, JSONObject jSONObject) {
        int iW;
        if (qgVar.fi() == 4) {
            iW = d.rv().optInt("market_install_finish_check_time", 600);
        } else {
            iW = com.byazt.rz.l.w(qgVar);
        }
        int i3 = ((iW * 1000) / AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS) + 1;
        com.byazt.rz.d dVarN = com.byazt.rz.d.n();
        String str = n;
        dVarN.n(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (qg(qgVar, i3, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, jSONObject)) {
            return;
        }
        if (((long) iW) * 1000 < com.byazt.rz.l.x(qgVar)) {
            com.byazt.rz.d.n().n(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (qg(qgVar, i, i2, jSONObject)) {
                return;
            }
            com.byazt.rz.d.n().n(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.byazt.rz.d.n().n(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean qg(com.byazt.h.qg qgVar, int i, int i2, JSONObject jSONObject) {
        com.byazt.rz.d.n().n(n, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.byazt.rz.oa.qg(qgVar)) {
                com.byazt.s.n.n().n(qgVar.l());
                com.byazt.rz.d.n().n(n, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
