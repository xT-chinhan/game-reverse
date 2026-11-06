package com.byazt.cr;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.cq.tj;
import com.byazt.mzw.q;
import com.byazt.mzw.s;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.tk.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 753, 26})
public class qg extends s {
    public static AtomicReference<com.byazt.ai.qg> l = new AtomicReference<>(null);
    public static volatile qg n;
    public static volatile File s;
    public AtomicBoolean qg = new AtomicBoolean(false);
    public AtomicBoolean q = new AtomicBoolean(false);

    public static qg qg() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public void s() {
        l.n(new x("enginecache-init") { // from class: com.byazt.cr.qg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    qg.this.rv();
                    qg.this.x();
                    qg.this.q();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (l.get() != null) {
                return;
            }
            File file = new File(n(), "package_ugen_temp.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    l.set(com.byazt.ai.qg.qg(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        try {
            k.n("PlayComponentEngineCacheManager", "version init error", th);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public void q() {
        try {
            if (this.qg.get()) {
                return;
            }
            boolean z = true;
            this.qg.set(true);
            com.byazt.ai.qg qgVar = new com.byazt.ai.qg(rv.n().n(2));
            com.byazt.ai.qg qgVar2 = l.get();
            if (!qgVar.w()) {
                this.qg.set(false);
                return;
            }
            if (!n(qgVar2, qgVar.s())) {
                this.qg.set(false);
                return;
            }
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.cr.qg.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.gjp.l.n().qg();
                }
            });
            List<com.byazt.px.n.C0308n> listQg = qg(qgVar, qgVar2);
            if (listQg == null) {
                z = false;
            }
            if (listQg == null) {
                this.qg.set(false);
            }
            if (z && n(qgVar.getResources())) {
                l.set(qgVar);
                n(n(), l.get(), "package_ugen_temp.json");
                qg(listQg);
            }
            x();
            this.qg.set(false);
        } catch (Throwable unused) {
        }
    }

    public void l() {
        qg(n(), l.get(), "package_ugen_temp.json");
        l.set(null);
    }

    public void w() {
        try {
            l();
            File fileN = n();
            if (fileN == null || !fileN.exists()) {
                return;
            }
            if (fileN.getParentFile() != null) {
                com.byazt.tk.x.s(fileN.getParentFile());
            } else {
                com.byazt.tk.x.s(fileN);
            }
        } catch (Throwable unused) {
        }
    }

    public void x() {
        com.byazt.ai.qg qgVar = l.get();
        if (qgVar == null || !qgVar.w()) {
            return;
        }
        boolean zN = n(qgVar.getResources());
        if (!zN) {
            l();
        }
        this.q.set(zN);
    }

    public boolean fs() {
        AtomicBoolean atomicBoolean = this.q;
        return atomicBoolean != null && atomicBoolean.get();
    }

    @Override // com.byazt.mzw.s
    public File n() {
        if (s == null) {
            try {
                File file = new File(new File(q.n(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                s = file;
            } catch (Throwable th) {
                k.n("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return s;
    }

    public WebResourceResponse n(WebView webView, tj.n nVar, String str) {
        File fileQg;
        try {
            if (TextUtils.isEmpty(str) || nVar == tj.n.IMAGE || (fileQg = qg(str)) == null) {
                return null;
            }
            return new WebResourceResponse(nVar.getType(), "utf-8", new FileInputStream(fileQg));
        } catch (Throwable th) {
            k.n("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }

    private File qg(String str) {
        com.byazt.ai.qg qgVar;
        if (!fs() || (qgVar = l.get()) == null) {
            return null;
        }
        for (com.byazt.px.n.C0308n c0308n : qgVar.getResources()) {
            if (c0308n.n() != null && c0308n.n().equals(str)) {
                File file = new File(n(), com.byazt.tk.l.qg(c0308n.n()));
                String strN = com.byazt.tk.l.n(file);
                if (c0308n.qg() == null || !c0308n.qg().equals(strN)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }
}
