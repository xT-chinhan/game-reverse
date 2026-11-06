package com.ss.android.downloadlib;

import com.ss.android.downloadlib.ab.sl;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.appdownloader.ah.ub;

/* JADX INFO: loaded from: classes3.dex */
public class ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4516ms = "ny";
    private static boolean xr = false;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ny f4519ms = new ny();
    }

    private ny() {
    }

    public static ny ms() {
        return ms.f4519ms;
    }

    public void ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, final com.ss.android.downloadad.api.ms.xr xrVar) {
        if (!com.ss.android.downloadlib.ab.ka.ah(xrVar)) {
            sl.ms().ms(f4516ms, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (xrVar == null) {
            sl.ms().xr(f4516ms, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (xrVar.ti()) {
            sl.ms().xr(f4516ms, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            sl slVarMs = sl.ms();
            String str = f4516ms;
            slVarMs.ms(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.ss.android.downloadlib.ab.ka.d(xrVar)) {
                sl.ms().ms(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = hi.ny().optInt("market_install_finish_check_time", 600);
                if (xrVar.sk() == 0 || System.currentTimeMillis() - xrVar.sk() > ((long) iOptInt) * 1000) {
                    xrVar.ch(System.currentTimeMillis());
                    ms(iOptInt, new ub() { // from class: com.ss.android.downloadlib.ny.1
                        @Override // com.ss.android.socialbase.appdownloader.ah.ub
                        public void ms() {
                            sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - xrVar.sk()));
                            xrVar.ch(true);
                            com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVar);
                        }

                        @Override // com.ss.android.socialbase.appdownloader.ah.ub
                        public void xr() {
                            sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!zb.xr(xrVar)) {
                                sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            xrVar.ch(false);
                            com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVar);
                        }
                    });
                } else {
                    sl.ms().ms(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.ss.android.downloadlib.ab.ka.ka(xrVar)) {
                sl.ms().ms(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.sl.ms().ms(xrVar);
            }
            com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.ka.ah.ms().ms(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void ms(final com.ss.android.downloadad.api.ms.xr xrVar) {
        if (!com.ss.android.downloadlib.ab.ka.ah(xrVar)) {
            sl.ms().ms(f4516ms, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (xrVar == null) {
            sl.ms().xr(f4516ms, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (xrVar.ka.get() && System.currentTimeMillis() - xrVar.sk() > 30000) {
            sl.ms().ms(f4516ms, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.ss.android.downloadlib.ab.ka.d(xrVar)) {
            long jOptInt = ((long) hi.ny().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - xrVar.sk() >= jOptInt) {
                sl.ms().ms(f4516ms, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                ms((int) (((xrVar.sk() + jOptInt) - System.currentTimeMillis()) / 1000), new ub() { // from class: com.ss.android.downloadlib.ny.2
                    @Override // com.ss.android.socialbase.appdownloader.ah.ub
                    public void ms() {
                        sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        xrVar.ka.compareAndSet(false, true);
                        com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.ah.ub
                    public void xr() {
                        sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!zb.xr(xrVar)) {
                            sl.ms().ms(ny.f4516ms, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        xrVar.ka.compareAndSet(true, false);
                        xrVar.ch(false);
                        com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
                    }
                });
            }
        }
    }

    public void ms(int i, ub ubVar) {
        sl.ms().ms(f4516ms, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!xr) {
            com.ss.android.socialbase.appdownloader.d.ch().ms(ubVar);
            xr = true;
        }
        com.ss.android.socialbase.appdownloader.d.ch().ms(i);
    }
}
