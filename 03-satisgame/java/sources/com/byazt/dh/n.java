package com.byazt.dh;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsTestSpeedVersion, 19})
public abstract class n implements qg {
    public SparseArray<Method> n = new SparseArray<>();
    public Object qg;

    public abstract String n();

    @Override // com.byazt.dh.qg
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.n.get(i);
        if (method == null || (obj = this.qg) == null) {
            n();
            return null;
        }
        try {
            if (obj instanceof Class) {
                return (T) method.invoke(null, objArr);
            }
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            n();
            th.getMessage();
            return null;
        }
    }

    @Override // com.byazt.dh.qg
    public void n(int i, Method method) {
        this.n.put(i, method);
    }

    @Override // com.byazt.dh.qg
    public void n(Object obj) {
        this.qg = obj;
    }
}
