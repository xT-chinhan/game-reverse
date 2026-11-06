package com.bytedance.pangle.c;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.zb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    interface ms {
        boolean ms(String str, int i);
    }

    public static void ms() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((ny.ab() || ny.ny() || ny.ah()) && com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.ka.ka.xr(new Runnable() { // from class: com.bytedance.pangle.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    c.xr();
                }
            });
        }
    }

    public static synchronized void xr() {
        Map<String, ?> all = xr.ms(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (ah().ms(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    xr.ms(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    zb.ms().ah(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static ms ah() {
        if (ny.ny()) {
            return new ka();
        }
        if (ny.ab()) {
            return new d();
        }
        if (ny.ah()) {
            return new ah();
        }
        return new ms() { // from class: com.bytedance.pangle.c.c.2
            @Override // com.bytedance.pangle.c.c.ms
            public boolean ms(String str, int i) {
                return true;
            }
        };
    }
}
