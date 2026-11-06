package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4434ms = "sl";

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static sl f4436ms = new sl();
    }

    private sl() {
    }

    public static sl ms() {
        return xr.f4436ms;
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        com.ss.android.downloadlib.ab.sl.ms().ms(f4434ms, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.ka.ms().ah(new ms(xrVar));
    }

    private class ms implements Runnable {
        private final com.ss.android.downloadad.api.ms.xr xr;

        ms(com.ss.android.downloadad.api.ms.xr xrVar) {
            this.xr = xrVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.xr.ch(true);
                    sl.this.xr(this.xr);
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            } finally {
                this.xr.ch(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        JSONObject jSONObject = new JSONObject();
        int iMs = com.ss.android.downloadlib.ab.ka.ms(xrVar);
        int iXr = com.ss.android.downloadlib.ab.ka.xr(xrVar);
        if (com.ss.android.downloadlib.ab.ka.ka(xrVar) && com.ss.android.downloadlib.ab.ka.d(xrVar)) {
            com.ss.android.downloadlib.ab.sl.ms().ms(f4434ms, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            ms(xrVar, iMs, iXr, jSONObject);
        } else {
            com.ss.android.downloadlib.ab.sl.ms().ms(f4434ms, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            xr(xrVar, 15, 20000, jSONObject);
        }
    }

    private void ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, int i2, JSONObject jSONObject) {
        int iC;
        if (xrVar.az() == 4) {
            iC = hi.ny().optInt("market_install_finish_check_time", 600);
        } else {
            iC = com.ss.android.downloadlib.ab.ka.c(xrVar);
        }
        int i3 = ((iC * 1000) / 20000) + 1;
        com.ss.android.downloadlib.ab.sl slVarMs = com.ss.android.downloadlib.ab.sl.ms();
        String str = f4434ms;
        slVarMs.ms(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (xr(xrVar, i3, 20000, jSONObject)) {
            return;
        }
        if (((long) iC) * 1000 < com.ss.android.downloadlib.ab.ka.ab(xrVar)) {
            com.ss.android.downloadlib.ab.sl.ms().ms(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (xr(xrVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.ab.sl.ms().ms(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.ab.sl.ms().ms(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean xr(com.ss.android.downloadad.api.ms.xr xrVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.ab.sl.ms().ms(f4434ms, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.ab.zb.xr(xrVar)) {
                com.ss.android.downloadlib.ms.ms().ms(xrVar.ka());
                com.ss.android.downloadlib.ab.sl.ms().ms(f4434ms, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
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
