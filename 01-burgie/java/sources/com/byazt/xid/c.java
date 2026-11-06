package com.byazt.xid;

import android.os.SystemClock;
import com.byazt.gs.aj;
import com.byazt.gs.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 582, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {

    interface pr {
        boolean pr(String str, int i);
    }

    public static void pr() {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_dex_opt", TrackAction.START);
        if (!GlobalParam.getInstance().isCloseBgDex2oat()) {
            if ((!aj.uc() && !aj.zo()) || !com.byazt.wo.x.hw(Zeus.getAppApplication())) {
                return;
            }
            GlobalParam.getInstance().getReporter().pr("zeus_stage_dex_opt", "post");
            com.byazt.wo.c.hw(new Runnable() { // from class: com.byazt.xid.c.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().pr("zeus_stage_dex_opt", "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    c.hw();
                }
            });
        }
    }

    public static synchronized void hw() {
        Map<String, ?> all = hw.pr(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (hn().pr(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    hw.pr(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    m.pr().hw(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static pr hn() {
        if (aj.zo()) {
            return new x();
        }
        if (aj.uc()) {
            return new hn();
        }
        return new pr() { // from class: com.byazt.xid.c.2
            @Override // com.byazt.xid.c.pr
            public boolean pr(String str, int i) {
                return true;
            }
        };
    }
}
