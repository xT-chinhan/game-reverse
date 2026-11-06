package com.byazt.qz;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.byazt.vx.w;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.VALUE_CLICK_AREA_OTHER, 19})
public class n {
    public static void n(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) n(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldN = n(Fragment.class, "sClassMap");
            if (fieldN != null) {
                ((SimpleArrayMap) fieldN.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsN = n("androidx.fragment.app.FragmentFactory");
            if (clsN == null) {
                return;
            }
            Field fieldN2 = n(clsN, "sClassMap");
            if (fieldN2 != null) {
                ((SimpleArrayMap) fieldN2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldN3 = n(clsN, "sClassCacheMap");
            if (fieldN3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldN3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            w.n(e);
        }
    }

    private static Field n(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class n(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
