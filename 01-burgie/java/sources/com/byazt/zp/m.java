package com.byazt.zp;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 108})
public final class m {
    public static Map<String, Field> pr = new HashMap();

    public static void pr(String str, int i) {
        if (i > 0) {
            try {
                if (iu.x < 7500) {
                    hw(str, i);
                    return;
                }
            } catch (Throwable th) {
                return;
            }
        }
        Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
        if (functionUc != null) {
            functionUc.apply(com.byazt.xi.hw.pr().pr(100).pr(Void.class).pr(0, str).pr(1, Integer.valueOf(i)).hw());
        }
    }

    public static void hw(String str, int i) {
        try {
            File[] fileArrPr = pr(str);
            if (fileArrPr != null) {
                for (File file : fileArrPr) {
                    if (Integer.parseInt(file.getName().split("-")[1]) == i) {
                        c.hw(file);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static File[] pr(String str) {
        return new File(com.byazt.ca.uc.pr(a.getContext(), false, null).getParent() + "/pangle_p/" + str).listFiles(new FileFilter() { // from class: com.byazt.zp.m.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
    }

    public static int hw(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return iu.x;
        }
        return hn(str, 101);
    }

    public static int hn(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7714;
        }
        return hn(str, 103);
    }

    public static String x(String str) {
        return (String) com.byazt.sd.zo.nt().ie().apply(com.byazt.xi.hw.pr().pr(8).pr(String.class).pr(0, str).hw());
    }

    public static List<Integer> c(String str) {
        if (iu.x < 7500) {
            File[] fileArrPr = pr(str);
            ArrayList arrayList = new ArrayList();
            if (fileArrPr != null) {
                for (File file : fileArrPr) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(file.getName().split("-")[1])));
                }
            }
            return arrayList;
        }
        Object objX = x(str, 110);
        if (objX instanceof List) {
            return (List) objX;
        }
        return null;
    }

    public static int uc(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return iu.x;
        }
        return hn(str, 102);
    }

    public static int hn(String str, int i) {
        Object objX = x(str, i);
        if (objX instanceof Integer) {
            return ((Integer) objX).intValue();
        }
        return 0;
    }

    private static Object x(String str, int i) {
        try {
            Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
            if (functionUc != null) {
                return functionUc.apply(com.byazt.xi.hw.pr().pr(i).pr(Integer.class).pr(0, str).hw());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean fw(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
            if (functionUc != null && (objApply = functionUc.apply(com.byazt.xi.hw.pr().pr(5).pr(Boolean.class).pr(0, str).hw())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean zo(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
            if (functionUc != null && (objApply = functionUc.apply(com.byazt.xi.hw.pr().pr(104).pr(Boolean.class).pr(0, str).hw())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean aj(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
            if (functionUc != null && (objApply = functionUc.apply(com.byazt.xi.hw.pr().pr(105).pr(Boolean.class).pr(0, str).hw())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static void pr() {
        try {
            Function<SparseArray<Object>, Object> functionUc = com.byazt.sd.zo.nt().uc(4);
            if (functionUc != null) {
                functionUc.apply(com.byazt.xi.hw.pr().pr(109).pr(Boolean.class).hw());
            }
        } catch (Throwable th) {
        }
    }
}
