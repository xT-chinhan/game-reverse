package com.byazt.fd;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 43, 37})
public class pr implements View.OnClickListener {
    public final int hn;
    public final String hw;
    public final Activity pr;
    public Method x;

    public pr(Activity activity, int i, String str) {
        this.pr = activity;
        this.hw = str;
        this.hn = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.x == null) {
            pr(this.pr, this.hw);
        }
        try {
            this.x.invoke(this.pr, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }

    private void pr(Activity activity, String str) {
        try {
            Method method = activity.getClass().getMethod(this.hw, View.class);
            if (method != null) {
                this.x = method;
                return;
            }
        } catch (NoSuchMethodException e) {
        }
        throw new IllegalStateException("Could not find method " + this.hw + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.hn);
    }
}
