package com.byazt.eld;

import android.os.SystemClock;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 108})
public class m {
    public static final String pr = m.class.getSimpleName();

    @com.byazt.vzx.pr(pr = {0, 1, 128, 1468})
    private static class hw {
        public static m pr = new m();
    }

    private m() {
    }

    public static m pr() {
        return hw.pr;
    }

    public void pr(com.byazt.tia.hw hwVar) {
        com.byazt.uk.k.pr().pr(pr, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.byazt.cvl.c.pr().hn(new pr(hwVar));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 128, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW})
    private class pr implements Runnable {
        public final com.byazt.tia.hw hw;

        public pr(com.byazt.tia.hw hwVar) {
            this.hw = hwVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.hw.vk(true);
                m.this.hw(this.hw);
            } catch (Exception e) {
            } finally {
                this.hw.vk(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.tia.hw hwVar) {
        JSONObject jSONObject = new JSONObject();
        int iPr = com.byazt.uk.c.pr(hwVar);
        int iHw = com.byazt.uk.c.hw(hwVar);
        if (com.byazt.uk.c.c(hwVar) && com.byazt.uk.c.x(hwVar)) {
            com.byazt.uk.k.pr().pr(pr, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            pr(hwVar, iPr, iHw, jSONObject);
        } else {
            com.byazt.uk.k.pr().pr(pr, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            hw(hwVar, 15, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, jSONObject);
        }
    }

    private void pr(com.byazt.tia.hw hwVar, int i, int i2, JSONObject jSONObject) {
        int iUc;
        if (hwVar.er() == 4) {
            iUc = k.aj().optInt("market_install_finish_check_time", 600);
        } else {
            iUc = com.byazt.uk.c.uc(hwVar);
        }
        int i3 = ((iUc * 1000) / AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS) + 1;
        com.byazt.uk.k kVarPr = com.byazt.uk.k.pr();
        String str = pr;
        kVarPr.pr(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (hw(hwVar, i3, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, jSONObject)) {
            return;
        }
        if (((long) iUc) * 1000 < com.byazt.uk.c.fw(hwVar)) {
            com.byazt.uk.k.pr().pr(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (!hw(hwVar, i, i2, jSONObject)) {
                com.byazt.uk.k.pr().pr(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
                return;
            }
            return;
        }
        com.byazt.uk.k.pr().pr(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean hw(com.byazt.tia.hw hwVar, int i, int i2, JSONObject jSONObject) {
        com.byazt.uk.k.pr().pr(pr, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.byazt.uk.m.hw(hwVar)) {
                com.byazt.cvl.pr.pr().pr(hwVar.c());
                com.byazt.uk.k.pr().pr(pr, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i != 0) {
                SystemClock.sleep(j);
            } else {
                return false;
            }
        }
        return false;
    }
}
