package com.smartdigimkt.b2;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final /* synthetic */ int a = 0;

    public static String a(com.smartdigimkt.b3.c cVar) {
        if (cVar == null) {
            return "";
        }
        if (!TextUtils.isEmpty(cVar.m)) {
            return cVar.m;
        }
        if (TextUtils.isEmpty(cVar.K)) {
            return !TextUtils.isEmpty(cVar.R) ? cVar.R : "";
        }
        return cVar.K;
    }

    public static boolean a(Context context, com.smartdigimkt.b3.c cVar) {
        if (cVar == null || context == null) {
            return false;
        }
        int i = cVar.o;
        if (i != 1) {
            if (i == 6) {
                if (TextUtils.isEmpty(cVar.A)) {
                    return true;
                }
                return true ^ com.smartdigimkt.r4.k.c(context, "com.tencent.mm");
            }
            if (i == 3) {
                if (TextUtils.isEmpty(cVar.k) || TextUtils.isEmpty(cVar.m)) {
                    return true;
                }
                String strA = a(cVar);
                if (TextUtils.isEmpty(strA)) {
                    return true;
                }
                return true ^ com.smartdigimkt.r4.k.c(context, strA);
            }
            if (i != 4) {
                return false;
            }
        }
        if (TextUtils.isEmpty(cVar.m)) {
            return true;
        }
        return com.smartdigimkt.r4.k.c(context, cVar.m);
    }
}
