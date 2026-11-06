package com.byazt.sqs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 18})
public final class l extends RuntimeException {
    public static final Method n;
    public IOException qg;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        n = declaredMethod;
    }

    public l(IOException iOException) {
        super(iOException);
        this.qg = iOException;
    }

    public IOException n() {
        return this.qg;
    }

    public void n(IOException iOException) {
        n(iOException, this.qg);
        this.qg = iOException;
    }

    private void n(IOException iOException, IOException iOException2) {
        Method method = n;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
