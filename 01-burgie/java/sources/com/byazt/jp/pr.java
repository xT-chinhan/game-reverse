package com.byazt.jp;

import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.vkw.qi;
import com.byazt.xlm.aj;
import com.byazt.zs.uc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2210, 37})
public class pr {
    public static volatile boolean pr = false;
    public static boolean hw = false;

    public static void pr() {
        if (hw) {
            return;
        }
        hw = true;
        aj ajVar = aj.hw;
        ajVar.pr(11);
        ajVar.x(iu.pr());
        ajVar.hn(true);
        ajVar.pr(true);
        ajVar.hw(true);
    }

    public static void hw() {
        JSONObject jSONObjectU = a.hw().u();
        if (jSONObjectU == null) {
            return;
        }
        ((qi) uc.pr("thread_service")).pr(jSONObjectU);
        pr = jSONObjectU.optBoolean("can_set_crash", true);
    }
}
