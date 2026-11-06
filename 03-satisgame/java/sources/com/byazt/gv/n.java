package com.byazt.gv;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.w;
import com.byazt.vyf.s;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 687, 19})
public class n {
    public static AtomicBoolean n;

    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    public static boolean n() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = n;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(w.n(rv.getContext(), false, null).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.gv.n.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = tj.l;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String strGroup = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > i;
                        } catch (Exception unused) {
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            n(z);
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void n(boolean z) {
        if (n == null) {
            n = new AtomicBoolean();
        }
        n.set(z);
        s.cy().k();
    }

    public static boolean qg() {
        return w() && q() && n();
    }

    public static boolean s() {
        boolean z = tj.s;
        return false;
    }

    public static boolean q() {
        return com.byazt.ed.qg.n().rv() == 0;
    }

    public static int l() {
        return tj.s ? 1 : 0;
    }

    public static boolean w() {
        return tj.s;
    }

    public static boolean x() {
        return w() && s.cy().lh();
    }

    public static boolean fs() {
        return com.byazt.ed.qg.n().tj();
    }
}
