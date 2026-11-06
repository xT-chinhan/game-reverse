package com.smartdigimkt.f;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t {
    public static Object[] a(Object obj, ArrayList arrayList, File file, ArrayList arrayList2) throws NoSuchMethodException {
        Method methodA;
        try {
            methodA = m.a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
        } catch (NoSuchMethodException unused) {
            methodA = m.a(obj, "makeDexElements", List.class, File.class, List.class);
        }
        return (Object[]) methodA.invoke(obj, arrayList, file, arrayList2);
    }
}
