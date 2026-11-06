package com.byazt.ivn;

import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 591, 18})
public class l {
    public static final AtomicInteger n;
    public static com.byazt.vyf.n qg;
    public static PluginValueSet s;

    static {
        com.byazt.gwu.s sVarQg = qg();
        n = new AtomicInteger(sVarQg != null ? sVarQg.getInt("status", 1) : 1);
    }

    public static boolean n() {
        return n.get() == 1;
    }

    public static void n(int i) {
        com.byazt.vyf.n nVar;
        if (i == 1 || i == 2) {
            com.byazt.gwu.s sVarQg = qg();
            if (sVarQg != null) {
                sVarQg.n("status", i);
            }
            AtomicInteger atomicInteger = n;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (nVar = qg) == null || nVar.n()) {
                return;
            }
            try {
                qg.n(rv.getContext(), s, new com.byazt.gf.qg((Function) s.objectValue(15, Function.class)));
                qg = null;
                s = null;
            } catch (Throwable th) {
                k.n("SdkSwitch", "init sdk error", th);
            }
        }
    }

    private static com.byazt.gwu.s qg() {
        return com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "sync_switch", 1, com.byazt.p001if.n.n());
    }
}
