package com.byazt.sd;

import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 789})
public class AdSdkInitializerHolder implements com.byazt.vkw.vk, Function {
    public static volatile hn pr = null;
    public static volatile Object hw = null;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return pr((Bundle) sparseArray.get(1));
            default:
                return null;
        }
    }

    public static Object getNewInstance(Bundle bundle) {
        com.byazt.vkw.a aVar;
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        if (pr == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (pr == null) {
                    pr = new hn(bundle);
                    if (iu.pr.booleanValue() && (aVar = (com.byazt.vkw.a) com.byazt.zs.uc.pr("m")) != null) {
                        hw = aVar.pr(bundle, pr);
                    }
                }
            }
        }
        return hw != null ? hw : pr;
    }

    public static boolean pr() {
        return hw != null;
    }

    public static boolean hw() {
        if (pr != null) {
            return pr.pr();
        }
        return false;
    }

    @Override // com.byazt.vkw.vk
    public Object pr(Bundle bundle) {
        return getNewInstance(bundle);
    }
}
