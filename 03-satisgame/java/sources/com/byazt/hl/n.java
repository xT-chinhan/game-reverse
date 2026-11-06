package com.byazt.hl;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1041, 19})
public class n implements View.OnClickListener {
    public final Activity n;
    public Method q;
    public final String qg;
    public final int s;

    public n(Activity activity, int i, String str) {
        this.n = activity;
        this.qg = str;
        this.s = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.q == null) {
            n(this.n, this.qg);
        }
        try {
            this.q.invoke(this.n, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void n(Activity activity, String str) {
        try {
            Method method = activity.getClass().getMethod(this.qg, View.class);
            if (method != null) {
                this.q = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.qg + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.s);
    }
}
