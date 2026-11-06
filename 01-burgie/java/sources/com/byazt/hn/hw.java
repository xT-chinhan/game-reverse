package com.byazt.hn;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.ce.hn;
import com.byazt.ce.x;
import com.byazt.js.vk;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 20, 13})
public class hw extends hn {
    public static AtomicReference<com.byazt.qk.hw> c = new AtomicReference<>(null);
    public static volatile File hn;
    public static volatile hw pr;
    public AtomicBoolean hw = new AtomicBoolean(false);
    public AtomicBoolean x = new AtomicBoolean(false);

    public static hw hw() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void hn() {
        c.pr(new fw("enginecache-init") { // from class: com.byazt.hn.hw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hw.this.aj();
                    hw.this.fw();
                    hw.this.x();
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (c.get() != null) {
                    return;
                }
                File file = new File(pr(), "package_ugen_temp.json");
                Long lValueOf = Long.valueOf(file.length());
                if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        c.set(com.byazt.qk.hw.hw(new JSONObject(new String(bArr, "utf-8"))));
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            try {
                ho.pr("PlayComponentEngineCacheManager", "version init error", th);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
                throw th4;
            }
        } catch (IOException e2) {
        }
    }

    public void x() {
        try {
            if (this.hw.get()) {
                return;
            }
            boolean z = true;
            this.hw.set(true);
            com.byazt.qk.hw hwVar = new com.byazt.qk.hw(a.pr().pr(2));
            com.byazt.qk.hw hwVar2 = c.get();
            if (!hwVar.uc()) {
                this.hw.set(false);
                return;
            }
            if (!pr(hwVar2, hwVar.hn())) {
                this.hw.set(false);
                return;
            }
            lb.uc().post(new Runnable() { // from class: com.byazt.hn.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.kq.c.pr().hw();
                }
            });
            List<com.byazt.hfm.pr.C0084pr> listHw = hw(hwVar, hwVar2);
            if (listHw == null) {
                z = false;
            }
            if (listHw == null) {
                this.hw.set(false);
            }
            if (z && pr(hwVar.getResources())) {
                c.set(hwVar);
                pr(pr(), c.get(), "package_ugen_temp.json");
                hw(listHw);
            }
            fw();
            this.hw.set(false);
        } catch (Throwable th) {
        }
    }

    public void c() {
        hw(pr(), c.get(), "package_ugen_temp.json");
        c.set(null);
    }

    public void uc() {
        try {
            c();
            File filePr = pr();
            if (filePr != null && filePr.exists()) {
                if (filePr.getParentFile() != null) {
                    com.byazt.ca.fw.hn(filePr.getParentFile());
                } else {
                    com.byazt.ca.fw.hn(filePr);
                }
            }
        } catch (Throwable th) {
        }
    }

    public void fw() {
        com.byazt.qk.hw hwVar = c.get();
        if (hwVar == null || !hwVar.uc()) {
            return;
        }
        boolean zPr = pr(hwVar.getResources());
        if (!zPr) {
            c();
        }
        this.x.set(zPr);
    }

    public boolean zo() {
        AtomicBoolean atomicBoolean = this.x;
        return atomicBoolean != null && atomicBoolean.get();
    }

    @Override // com.byazt.ce.hn
    public File pr() {
        if (hn == null) {
            try {
                File file = new File(new File(x.pr(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                hn = file;
            } catch (Throwable th) {
                ho.pr("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return hn;
    }

    public WebResourceResponse pr(WebView webView, vk.pr prVar, String str) {
        File fileHw;
        try {
            if (TextUtils.isEmpty(str) || prVar == vk.pr.IMAGE || (fileHw = hw(str)) == null) {
                return null;
            }
            return new WebResourceResponse(prVar.getType(), "utf-8", new FileInputStream(fileHw));
        } catch (Throwable th) {
            ho.pr("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }

    private File hw(String str) {
        com.byazt.qk.hw hwVar;
        if (!zo() || (hwVar = c.get()) == null) {
            return null;
        }
        for (com.byazt.hfm.pr.C0084pr c0084pr : hwVar.getResources()) {
            if (c0084pr.pr() != null && c0084pr.pr().equals(str)) {
                File file = new File(pr(), com.byazt.ca.c.hw(c0084pr.pr()));
                String strPr = com.byazt.ca.c.pr(file);
                if (c0084pr.hw() == null || !c0084pr.hw().equals(strPr)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }
}
