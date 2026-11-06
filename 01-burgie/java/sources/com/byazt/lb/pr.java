package com.byazt.lb;

import android.support.v4.app.Fragment;
import android.support.v4.util.SimpleArrayMap;
import com.byazt.dea.uc;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 48, 37})
public class pr {
    public static void pr(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) pr(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldPr = pr(Fragment.class, "sClassMap");
            if (fieldPr != null) {
                ((SimpleArrayMap) fieldPr.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsPr = pr("androidx.fragment.app.FragmentFactory");
            if (clsPr == null) {
                return;
            }
            Field fieldPr2 = pr(clsPr, "sClassMap");
            if (fieldPr2 != null) {
                ((SimpleArrayMap) fieldPr2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldPr3 = pr(clsPr, "sClassCacheMap");
            if (fieldPr3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldPr3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            uc.pr(e);
        }
    }

    private static Field pr(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private static Class pr(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
