package com.byazt.iu;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.tk.bb;
import com.byazt.tk.k;
import com.byazt.tk.l;
import com.byazt.tk.sz;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1305, 8})
public class s {
    public static volatile s n;
    public AtomicBoolean q = new AtomicBoolean(false);
    public String qg;
    public String s;

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    public void qg() {
        new com.byazt.gv.qg(131072).n(new Runnable() { // from class: com.byazt.iu.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.l();
            }
        });
    }

    public void n(String str) {
        try {
            String strS = s();
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(strS)) {
                return;
            }
            new com.byazt.gv.qg(262144).n(new Runnable() { // from class: com.byazt.iu.s.2
                @Override // java.lang.Runnable
                public void run() {
                    s.this.l();
                }
            });
        } catch (Throwable th) {
            k.qg("LocalDrawableResCacheManager", "doUpdateWhenSetting reszip failed：" + th.getMessage());
        }
    }

    public String s() {
        String strCa = rv.qg().ca();
        return TextUtils.isEmpty(strCa) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/3f0fb79faf3171023734d003d2a64219-MjAyNjAxMTg.zip" : strCa;
    }

    public String q() {
        String strS = s();
        String str = this.qg;
        if (str != null && str.equalsIgnoreCase(strS)) {
            return this.s;
        }
        String strN = com.byazt.wvr.s.n(strS);
        this.s = strN;
        this.qg = strS;
        return strN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            String strS = s();
            if (qg(strS)) {
                s(strS);
            }
        } catch (Throwable th) {
            k.qg("LocalDrawableResCacheManager", "processUpdate reszip failed：" + th.getMessage());
        }
    }

    private boolean qg(String str) {
        File[] fileArrListFiles;
        String strQg = l.qg(str);
        if (TextUtils.isEmpty(strQg)) {
            return false;
        }
        File file = new File(sz.n(rv.getContext()), strQg);
        return !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0;
    }

    private void s(final String str) {
        if (this.q.get()) {
            return;
        }
        this.q.set(true);
        com.byazt.qit.l.qg(new x("downloadZip") { // from class: com.byazt.iu.s.3
            @Override // java.lang.Runnable
            public void run() {
                s.this.q(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final String str) {
        final String strQg = l.qg(str);
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        com.byazt.phf.s.n(str, sz.n(rv.getContext()).getAbsolutePath(), strQg + ".temp").n(new com.byazt.qk.x() { // from class: com.byazt.iu.s.4
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                s.this.q.set(false);
                String strQg2 = l.qg(s.this.s());
                if (TextUtils.isEmpty(strQg2) || strQg2.equalsIgnoreCase(strQg)) {
                    if (oaVar.x() && oaVar.tj() != null && oaVar.tj().exists()) {
                        try {
                            File fileN = sz.n(rv.getContext());
                            oaVar.tj().getAbsolutePath();
                            File file = new File(fileN.getAbsolutePath(), strQg);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            bb.n(oaVar.tj().getAbsolutePath(), file.getAbsolutePath());
                            File[] fileArrListFiles = fileN.listFiles();
                            if (fileArrListFiles != null) {
                                for (File file2 : fileArrListFiles) {
                                    if (!strQg.equalsIgnoreCase(file2.getName()) || !file2.isDirectory()) {
                                        com.byazt.tk.x.s(file2);
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            k.n("LocalDrawableResCacheManager", "unzip reszip failed：", th);
                            return;
                        }
                    }
                    k.qg("LocalDrawableResCacheManager", "download reszip failed 1：" + str);
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                s.this.q.set(false);
                k.qg("LocalDrawableResCacheManager", "download resources failed 2：" + str);
            }
        });
    }
}
