package com.byazt.zf;

import android.content.Context;
import com.byazt.zo.DispatchAdSdkInitializerHolder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 26})
public abstract class qg extends com.byazt.ua.qg {
    public static final String VERSION_00 = "0.0";

    public qg(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    public com.byazt.yn.n n(Context context) {
        com.byazt.yn.n csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            n(new com.byazt.mj.n("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    @Override // com.byazt.nw.n
    public String n(String str) {
        try {
            return com.byazt.zo.qg.s();
        } catch (Exception unused) {
            return "0.0";
        }
    }
}
