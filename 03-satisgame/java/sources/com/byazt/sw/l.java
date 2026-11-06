package com.byazt.sw;

import android.os.SystemClock;
import com.byazt.gx.oa;
import com.byazt.gx.rv;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 96, 18})
public class l {

    interface n {
        boolean n(String str, int i);
    }

    public static void n() {
        GlobalParam.getInstance().getReporter().n("zeus_stage_dex_opt", "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((rv.w() || rv.fs()) && com.byazt.zi.q.qg(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().n("zeus_stage_dex_opt", "post");
            com.byazt.zi.l.qg(new Runnable() { // from class: com.byazt.sw.l.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().n("zeus_stage_dex_opt", "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    l.qg();
                }
            });
        }
    }

    public static synchronized void qg() {
        Map<String, ?> all = qg.n(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (s().n(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    qg.n(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    oa.n().qg(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static n s() {
        if (rv.fs()) {
            return new q();
        }
        if (rv.w()) {
            return new s();
        }
        return new n() { // from class: com.byazt.sw.l.2
            @Override // com.byazt.sw.l.n
            public boolean n(String str, int i) {
                return true;
            }
        };
    }
}
