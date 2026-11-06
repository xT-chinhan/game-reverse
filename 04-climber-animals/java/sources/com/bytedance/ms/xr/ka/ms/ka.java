package com.bytedance.ms.xr.ka.ms;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ka f576ms;
    private Map<com.bytedance.ms.xr.ah, ah> ah = new HashMap();
    private xr d;
    private d ka;
    private Context xr;

    private ka(Context context) {
        this.xr = context;
        this.d = new xr(this.xr);
        this.ka = new d(this.xr);
    }

    public static ka ms() {
        if (f576ms == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return f576ms;
    }

    public static void ms(Context context) {
        if (f576ms == null) {
            f576ms = new ka(context);
        }
    }

    private ah ms(com.bytedance.ms.xr.ah ahVar) {
        ah abVar = this.ah.get(ahVar);
        if (abVar != null) {
            return abVar;
        }
        int i = AnonymousClass1.f577ms[ahVar.ordinal()];
        if (i == 1) {
            abVar = new ab(this.xr, this.d, this.ka);
        } else if (i == 2) {
            abVar = new ms(this.xr, this.d, this.ka);
        } else if (i == 3) {
            abVar = new c(this.xr, this.d, this.ka);
        }
        if (abVar != null) {
            this.ah.put(ahVar, abVar);
        }
        return abVar;
    }

    /* JADX INFO: renamed from: com.bytedance.ms.xr.ka.ms.ka$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f577ms;

        static {
            int[] iArr = new int[com.bytedance.ms.xr.ah.values().length];
            f577ms = iArr;
            try {
                iArr[com.bytedance.ms.xr.ah.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f577ms[com.bytedance.ms.xr.ah.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f577ms[com.bytedance.ms.xr.ah.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public com.bytedance.ms.xr.ah.ms ms(com.bytedance.ms.xr.ah ahVar, com.bytedance.ms.xr.ah.ms msVar) {
        ah ahVarMs;
        return (ahVar == null || (ahVarMs = ms(ahVar)) == null) ? msVar : ahVarMs.ms(msVar);
    }
}
