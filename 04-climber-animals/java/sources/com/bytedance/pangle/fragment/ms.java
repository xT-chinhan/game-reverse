package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.ab;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
class ms {
    public static void ms(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) ms(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldMs = ms(Fragment.class, "sClassMap");
            if (fieldMs != null) {
                ((SimpleArrayMap) fieldMs.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsMs = ms("androidx.fragment.app.FragmentFactory");
            if (clsMs == null) {
                return;
            }
            Field fieldMs2 = ms(clsMs, "sClassMap");
            if (fieldMs2 != null) {
                ((SimpleArrayMap) fieldMs2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldMs3 = ms(clsMs, "sClassCacheMap");
            if (fieldMs3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldMs3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            ab.ms(e);
        }
    }

    private static Field ms(Class cls, String str) {
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

    private static Class ms(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
