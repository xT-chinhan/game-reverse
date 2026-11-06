package com.byazt.cvl;

import com.byazt.uk.k;
import com.byazt.uk.m;
import com.byazt.zkm.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 61})
public class aj {
    public static final String pr = aj.class.getSimpleName();
    public static boolean hw = false;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    private static class pr {
        public static aj pr = new aj();
    }

    private aj() {
    }

    public static aj pr() {
        return pr.pr;
    }

    public void pr(com.byazt.shh.c cVar, final com.byazt.tia.hw hwVar) {
        if (!com.byazt.uk.c.hn(hwVar)) {
            k.pr().pr(pr, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (hwVar == null) {
            k.pr().hw(pr, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hwVar.jn()) {
            k.pr().hw(pr, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            k kVarPr = k.pr();
            String str = pr;
            kVarPr.pr(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.byazt.uk.c.x(hwVar)) {
                k.pr().pr(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.byazt.eld.k.aj().optInt("market_install_finish_check_time", 600);
                if (hwVar.d() == 0 || System.currentTimeMillis() - hwVar.d() > ((long) iOptInt) * 1000) {
                    hwVar.vk(System.currentTimeMillis());
                    pr(iOptInt, new ho() { // from class: com.byazt.cvl.aj.1
                        @Override // com.byazt.zkm.ho
                        public void pr() {
                            k.pr().pr(aj.pr, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - hwVar.d()));
                            hwVar.vk(true);
                            com.byazt.shh.uc.pr().pr(hwVar);
                        }

                        @Override // com.byazt.zkm.ho
                        public void hw() {
                            k.pr().pr(aj.pr, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!m.hw(hwVar)) {
                                k.pr().pr(aj.pr, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            hwVar.vk(false);
                            com.byazt.shh.uc.pr().pr(hwVar);
                        }
                    });
                } else {
                    k.pr().pr(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.byazt.uk.c.c(hwVar)) {
                k.pr().pr(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.byazt.eld.m.pr().pr(hwVar);
            }
            com.byazt.shh.aj.pr().pr(hwVar);
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void pr(final com.byazt.tia.hw hwVar) {
        if (!com.byazt.uk.c.hn(hwVar)) {
            k.pr().pr(pr, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (hwVar == null) {
            k.pr().hw(pr, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hwVar.c.get() && System.currentTimeMillis() - hwVar.d() > 30000) {
            k.pr().pr(pr, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.byazt.uk.c.x(hwVar)) {
            long jOptInt = ((long) com.byazt.eld.k.aj().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - hwVar.d() >= jOptInt) {
                k.pr().pr(pr, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                pr((int) (((hwVar.d() + jOptInt) - System.currentTimeMillis()) / 1000), new ho() { // from class: com.byazt.cvl.aj.2
                    @Override // com.byazt.zkm.ho
                    public void pr() {
                        k.pr().pr(aj.pr, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        hwVar.c.compareAndSet(false, true);
                        com.byazt.shh.aj.pr().pr(hwVar);
                    }

                    @Override // com.byazt.zkm.ho
                    public void hw() {
                        k.pr().pr(aj.pr, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!m.hw(hwVar)) {
                            k.pr().pr(aj.pr, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        hwVar.c.compareAndSet(true, false);
                        hwVar.vk(false);
                        com.byazt.shh.aj.pr().pr(hwVar);
                    }
                });
            }
        }
    }

    public void pr(int i, ho hoVar) {
        k.pr().pr(pr, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!hw) {
            com.byazt.mdu.x.w().pr(hoVar);
            hw = true;
        }
        com.byazt.mdu.x.w().pr(i);
    }
}
