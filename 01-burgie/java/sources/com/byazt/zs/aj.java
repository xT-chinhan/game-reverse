package com.byazt.zs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.byazt.sd.a;
import com.byazt.vkw.lb;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 61})
public class aj implements lb, Function {
    public static final int TYPE_NEW_SHARED_PREFERENCES = 3;
    public static final Set<String> hn = new HashSet();
    public static File hw;
    public Map<String, com.byazt.cr.c> pr = new ConcurrentHashMap();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                com.byazt.cr.c cVarPr = pr((String) sparseArray.get(1));
                return cVarPr != null ? new com.byazt.cr.uc(cVarPr) : cVarPr;
            case 2:
                com.byazt.cr.c cVarPr2 = pr((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                return cVarPr2 != null ? new com.byazt.cr.uc(cVarPr2) : cVarPr2;
            case 3:
                com.byazt.cr.hn hnVarPr = pr(((Integer) sparseArray.get(1)).intValue());
                return hnVarPr != null ? new com.byazt.cr.x(hnVarPr) : hnVarPr;
            case 4:
                pr();
                return null;
            case 5:
                hw();
                return null;
            default:
                return null;
        }
    }

    public aj() {
        hn.add("sp_bidding_opt_libra");
    }

    @Override // com.byazt.vkw.lb
    public com.byazt.cr.c pr(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.byazt.cr.c cVar = this.pr.get(str);
        if (cVar != null) {
            return cVar;
        }
        synchronized (this.pr) {
            com.byazt.cr.c cVar2 = this.pr.get(str);
            if (cVar2 != null) {
                return cVar2;
            }
            com.byazt.cr.c cVarX = x(str);
            this.pr.put(str, cVarX);
            return cVarX;
        }
    }

    private com.byazt.cr.c x(String str) {
        int iBt = a.hw().bt();
        com.byazt.is.uc ucVarTk = a.hw().tk();
        if (iBt == 3 && Build.VERSION.SDK_INT != 27) {
            File fileHn = hn(str);
            return new com.byazt.qz.hn(fileHn, pr(fileHn, str), pr(str, ucVarTk.pr), ucVarTk.hw);
        }
        String strC = c(str);
        try {
            return new com.byazt.qz.x(a.getContext().getSharedPreferences(strC, 0));
        } catch (Error e) {
            File file = new File(c(), strC + ".xml");
            return new com.byazt.qz.hn(file, pr(file, str), pr(str, ucVarTk.pr), ucVarTk.hw);
        }
    }

    @Override // com.byazt.vkw.lb
    public com.byazt.cr.c pr(String str, int i) {
        return pr(str);
    }

    private com.byazt.to.pr pr(File file, String str) {
        if (hn.contains(str)) {
            return hn();
        }
        pr(file);
        return new com.byazt.qz.pr(null);
    }

    private com.byazt.to.hw pr(String str, boolean z) {
        if (hn.contains(str)) {
            return x();
        }
        com.byazt.ox.pr prVar = z ? new com.byazt.ox.pr() : null;
        if (Build.VERSION.SDK_INT != 27) {
            return new com.byazt.qz.pr(prVar);
        }
        return x();
    }

    private com.byazt.to.pr hn() {
        if (com.byazt.qz.c.pr()) {
            return new com.byazt.qz.c(null);
        }
        return new com.byazt.qz.uc(null);
    }

    private com.byazt.to.hw x() {
        if (com.byazt.qz.c.pr()) {
            return new com.byazt.qz.c(null);
        }
        return new com.byazt.qz.uc(null);
    }

    private void pr(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            file.delete();
        }
    }

    @Override // com.byazt.vkw.lb
    public com.byazt.cr.hn pr(int i) {
        switch (i) {
            case 32:
                return new com.byazt.ox.pr();
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.lb
    public void pr() {
        Iterator<String> it = this.pr.keySet().iterator();
        while (it.hasNext()) {
            com.byazt.cr.c cVar = this.pr.get(it.next());
            if (cVar != null) {
                cVar.hw();
            }
        }
    }

    @Override // com.byazt.vkw.lb
    public void hw() {
        synchronized (this.pr) {
            this.pr.clear();
        }
    }

    public static com.byazt.cr.c hw(String str) {
        return ((lb) uc.pr("kv_store_factory")).pr(str);
    }

    public static SharedPreferences pr(Context context, String str, int i) {
        return hw(str);
    }

    private static File c() {
        String name;
        File filePr = com.byazt.ca.uc.pr(a.getContext(), false, null);
        do {
            name = filePr.getName();
            if (name == null) {
                break;
            }
            filePr = filePr.getParentFile();
        } while (!name.equals("files"));
        return new File(filePr, "shared_prefs");
    }

    public static File hn(String str) {
        if (hw == null) {
            hw = c();
        }
        return new File(hw, c(str) + ".xml");
    }

    private static String c(String str) {
        if (!str.startsWith("pangle_")) {
            return "pangle_com.byted.pangle_".concat(String.valueOf(str));
        }
        return str;
    }
}
