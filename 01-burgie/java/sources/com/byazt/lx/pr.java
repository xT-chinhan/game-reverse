package com.byazt.lx;

import com.byazt.ea.w;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 111, 37})
public class pr {
    public static Class<?> pr(boolean z, of ofVar, boolean z2, Map<String, Object> map) {
        if (lb.c(ofVar)) {
            return TTSevenScreenWebPageActivity.class;
        }
        if (lb.uc(ofVar) && !ofVar.ww()) {
            return TTVideoWebPageActivity.class;
        }
        if (of.hn(ofVar) && !z && ls.zo(ofVar)) {
            if (w.uc(ofVar)) {
                return TTNativePageActivity.class;
            }
            if (ofVar.ww()) {
                return TTWebPageActivity.class;
            }
            return pr(TTVideoWebPageActivity.class, z2, ofVar, map);
        }
        if (w.uc(ofVar)) {
            return TTNativePageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0033 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0036 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:8:0x000e, B:9:0x002d, B:13:0x0036, B:15:0x003c, B:17:0x0044), top: B:24:0x000e }] */
    private static Class pr(Class cls, boolean z, of ofVar, Map<String, Object> map) {
        if (!TTVideoWebPageActivity.class.equals(cls) || !z) {
            return cls;
        }
        if (map != null) {
            try {
                com.byazt.mm.pr prVar = new com.byazt.mm.pr();
                prVar.fw = 100L;
                prVar.pr = true;
                prVar.x = ls.z(ofVar);
                map.put("multi_process_data", prVar.pr().toString());
                if (ofVar.xv() == 0) {
                    return TTVideoScrollWebPageActivity.class;
                }
                if (ofVar.xv() <= 0 && 100 > ofVar.xv() && ls.z(ofVar)) {
                    return TTVideoScrollWebPageActivity.class;
                }
            } catch (Throwable th) {
            }
        } else {
            if (ofVar.xv() == 0) {
                return TTVideoScrollWebPageActivity.class;
            }
            if (ofVar.xv() <= 0) {
            }
        }
        return cls;
    }
}
