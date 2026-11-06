package com.bytedance.sdk.component.ah.xr.ms.xr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class ka extends RuntimeException {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Method f1129ms;
    private IOException xr;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f1129ms = declaredMethod;
    }

    public ka(IOException iOException) {
        super(iOException);
        this.xr = iOException;
    }

    public IOException ms() {
        return this.xr;
    }

    public void ms(IOException iOException) {
        ms(iOException, this.xr);
        this.xr = iOException;
    }

    private void ms(IOException iOException, IOException iOException2) {
        Method method = f1129ms;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
