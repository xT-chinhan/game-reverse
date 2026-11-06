package com.byazt.jys;

import android.util.SparseArray;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1564, 37})
public abstract class pr implements hw {
    public Object hw;
    public SparseArray<Method> pr = new SparseArray<>();

    public abstract String pr();

    @Override // com.byazt.jys.hw
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.pr.get(i);
        if (method == null || (obj = this.hw) == null) {
            pr();
            return null;
        }
        try {
            if (obj instanceof Class) {
                return (T) method.invoke(null, objArr);
            }
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            pr();
            th.getMessage();
            return null;
        }
    }

    @Override // com.byazt.jys.hw
    public void pr(int i, Method method) {
        this.pr.put(i, method);
    }

    @Override // com.byazt.jys.hw
    public void pr(Object obj) {
        this.hw = obj;
    }
}
