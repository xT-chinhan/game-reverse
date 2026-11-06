package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements View.OnClickListener {
    private final int ah;
    private Method d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Activity f618ms;
    private final String xr;

    public ms(Activity activity, int i, String str) {
        this.f618ms = activity;
        this.xr = str;
        this.ah = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null) {
            ms(this.f618ms, this.xr);
        }
        try {
            this.d.invoke(this.f618ms, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void ms(Activity activity, String str) {
        try {
            Method method = activity.getClass().getMethod(this.xr, View.class);
            if (method != null) {
                this.d = method;
                return;
            }
        } catch (NoSuchMethodException unused) {
        }
        throw new IllegalStateException("Could not find method " + this.xr + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.ah);
    }
}
