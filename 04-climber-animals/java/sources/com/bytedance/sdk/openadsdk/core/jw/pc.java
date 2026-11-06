package com.bytedance.sdk.openadsdk.core.jw;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class pc {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Set<Integer> f2726ms = new CopyOnWriteArraySet();
    private static final com.bytedance.sdk.component.utils.re xr = new com.bytedance.sdk.component.utils.re() { // from class: com.bytedance.sdk.openadsdk.core.jw.pc.1
        @Override // com.bytedance.sdk.component.utils.re
        public boolean ms(int i) {
            if (com.bytedance.sdk.openadsdk.core.re.xr().sh()) {
                return pc.f2726ms.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.bytedance.sdk.component.widget.xr.ms ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        com.bytedance.sdk.component.widget.xr.ms msVar = new com.bytedance.sdk.component.widget.xr.ms();
        msVar.ms(lmVar.ka());
        msVar.ms(lmVar.lx());
        msVar.xr(lmVar.df());
        return msVar;
    }

    public static void ms() {
        if (com.bytedance.sdk.openadsdk.core.re.xr().sh()) {
            com.bytedance.sdk.component.utils.b.ms(xr);
        } else {
            f2726ms.clear();
        }
    }

    public static void ms(int i) {
        if (com.bytedance.sdk.openadsdk.core.re.xr().sh()) {
            f2726ms.add(Integer.valueOf(i));
        }
        xr.ah(i);
    }

    public static void xr(int i) {
        f2726ms.remove(Integer.valueOf(i));
        xr.xr(i);
    }
}
