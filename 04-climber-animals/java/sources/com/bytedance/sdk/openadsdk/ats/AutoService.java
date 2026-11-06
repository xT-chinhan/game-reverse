package com.bytedance.sdk.openadsdk.ats;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoService implements Function<Class, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static List<Function> f1827ms = new ArrayList();

    public static Function init(Function function) {
        if (function != null) {
            f1827ms.add(function);
        }
        return new AutoService();
    }

    public static <T> T ms(Class<T> cls) {
        T t = (T) ms.ms().ms(cls);
        if (t == null && f1827ms.size() > 0) {
            Iterator<Function> it = f1827ms.iterator();
            while (it.hasNext() && (t = (T) it.next().apply(cls)) == null) {
            }
        }
        return t;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public Object apply(Class cls) {
        return ms.ms().ms(cls);
    }
}
