package com.mcto.sspsdk.internal;

import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c8 {
    /* JADX WARN: Code duplicated, block: B:44:0x00b7  */
    public static int a(d8 d8Var) {
        boolean zBooleanValue;
        View view = d8Var.a;
        boolean z = true;
        if (view == null || !view.isShown()) {
            return 1;
        }
        try {
            PowerManager powerManager = (PowerManager) view.getContext().getSystemService("power");
            Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
            Object objInvoke = method != null ? method.invoke(powerManager, new Object[0]) : null;
            if (objInvoke == null) {
                objInvoke = Boolean.FALSE;
            }
            zBooleanValue = ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            r9.a("ssp_sdk", "", e);
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            return 4;
        }
        int i = d8Var.c;
        if (!(view.getWidth() >= i && view.getHeight() >= i)) {
            return 6;
        }
        View view2 = d8Var.a;
        if (view2 == null || view2.getVisibility() != 0 || view2.getParent() == null) {
            z = false;
        } else {
            Rect rect = new Rect();
            if (view2.getGlobalVisibleRect(rect)) {
                long jHeight = ((long) rect.height()) * ((long) rect.width());
                int height = view2.getHeight();
                int width = view2.getWidth();
                long j = ((long) height) * ((long) width);
                if (j <= 0 || jHeight * 100 < ((long) d8Var.b) * j) {
                    z = false;
                } else {
                    AtomicInteger atomicInteger = gj.a;
                    d8Var.g = System.currentTimeMillis();
                    d8Var.d = gj.a(view2);
                    d8Var.e = width;
                    d8Var.f = height;
                }
            } else {
                z = false;
            }
        }
        return !z ? 3 : 0;
    }
}
