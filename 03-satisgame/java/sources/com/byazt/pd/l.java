package com.byazt.pd;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 18})
public class l {
    public static volatile l n;
    public q l;
    public qg q;
    public Context qg;
    public Map<com.byazt.qf.s, s> s = new HashMap();

    private l(Context context) {
        this.qg = context;
        this.q = new qg(this.qg);
        this.l = new q(this.qg);
    }

    public static l n() {
        if (n == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return n;
    }

    public static void n(Context context) {
        if (n == null) {
            n = new l(context);
        }
    }

    private s n(com.byazt.qf.s sVar) {
        s xVar = this.s.get(sVar);
        if (xVar != null) {
            return xVar;
        }
        int i = AnonymousClass1.n[sVar.ordinal()];
        if (i == 1) {
            xVar = new x(this.qg, this.q, this.l);
        } else if (i == 2) {
            xVar = new n(this.qg, this.q, this.l);
        } else if (i == 3) {
            xVar = new w(this.qg, this.q, this.l);
        }
        if (xVar != null) {
            this.s.put(sVar, xVar);
        }
        return xVar;
    }

    /* JADX INFO: renamed from: com.byazt.pd.l$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 24, 98})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.qf.s.values().length];
            n = iArr;
            try {
                iArr[com.byazt.qf.s.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.qf.s.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.qf.s.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public com.byazt.ub.n n(com.byazt.qf.s sVar, com.byazt.ub.n nVar) {
        s sVarN;
        return (sVar == null || (sVarN = n(sVar)) == null) ? nVar : sVarN.n(nVar);
    }
}
