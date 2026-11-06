package com.byazt.wl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.w;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 888, 18})
public final class l {
    public static Map<String, Field> n = new HashMap();

    public static void n(String str, int i) {
        if (i > 0) {
            try {
                if (tj.l < 7500) {
                    qg(str, i);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
        if (functionW != null) {
            functionW.apply(com.byazt.of.qg.n().n(100).n(Void.class).n(0, str).n(1, Integer.valueOf(i)).qg());
        }
    }

    public static void qg(String str, int i) {
        try {
            File[] fileArrN = n(str);
            if (fileArrN != null) {
                for (File file : fileArrN) {
                    if (Integer.parseInt(file.getName().split("-")[1]) == i) {
                        com.byazt.xu.s.qg(file);
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static File[] n(String str) {
        return new File(w.n(rv.getContext(), false, null).getParent() + "/pangle_p/" + str).listFiles(new FileFilter() { // from class: com.byazt.wl.l.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
    }

    public static int qg(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return tj.l;
        }
        return s(str, 101);
    }

    public static int s(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7814;
        }
        return s(str, 103);
    }

    public static String q(String str) {
        return (String) com.byazt.vyf.s.cy().b().apply(com.byazt.of.qg.n().n(8).n(String.class).n(0, str).qg());
    }

    public static List<Integer> l(String str) {
        if (tj.l < 7500) {
            File[] fileArrN = n(str);
            ArrayList arrayList = new ArrayList();
            if (fileArrN != null) {
                for (File file : fileArrN) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(file.getName().split("-")[1])));
                }
            }
            return arrayList;
        }
        Object objQ = q(str, 110);
        if (objQ instanceof List) {
            return (List) objQ;
        }
        return null;
    }

    public static int w(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return tj.l;
        }
        return s(str, 102);
    }

    public static int s(String str, int i) {
        Object objQ = q(str, i);
        if (objQ instanceof Integer) {
            return ((Integer) objQ).intValue();
        }
        return 0;
    }

    private static Object q(String str, int i) {
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null) {
                return functionW.apply(com.byazt.of.qg.n().n(i).n(Integer.class).n(0, str).qg());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean x(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null && (objApply = functionW.apply(com.byazt.of.qg.n().n(5).n(Boolean.class).n(0, str).qg())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static JSONObject fs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null) {
                Object objApply = functionW.apply(com.byazt.of.qg.n().n(13).n(JSONObject.class).n(0, str).qg());
                if (objApply instanceof JSONObject) {
                    return (JSONObject) objApply;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean rv(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null && (objApply = functionW.apply(com.byazt.of.qg.n().n(104).n(Boolean.class).n(0, str).qg())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean tj(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null && (objApply = functionW.apply(com.byazt.of.qg.n().n(105).n(Boolean.class).n(0, str).qg())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void n() {
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null) {
                functionW.apply(com.byazt.of.qg.n().n(109).n(Boolean.class).qg());
            }
        } catch (Throwable unused) {
        }
    }

    public static ClassLoader cp(String str) {
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null) {
                return (ClassLoader) functionW.apply(com.byazt.of.qg.n().n(4).n(ClassLoader.class).n(0, str).qg());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
