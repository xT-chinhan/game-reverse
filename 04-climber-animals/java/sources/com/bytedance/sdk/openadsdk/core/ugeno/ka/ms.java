package com.bytedance.sdk.openadsdk.core.ugeno.ka;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.d.ch;
import com.bytedance.sdk.component.adexpress.ka.ka;
import com.bytedance.sdk.component.adexpress.ms.xr.ah;
import com.bytedance.sdk.component.adexpress.ms.xr.d;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.c.xr;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah {
    private static volatile File ah;
    private static AtomicReference<xr> ka = new AtomicReference<>(null);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3554ms;
    private AtomicBoolean xr = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);

    public static ms xr() {
        if (f3554ms == null) {
            synchronized (ms.class) {
                if (f3554ms == null) {
                    f3554ms = new ms();
                }
            }
        }
        return f3554ms;
    }

    public void ah() {
        ab.ms(new ny("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.ms.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ms.this.ny();
                    ms.this.ab();
                    ms.this.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (ka.get() != null) {
                return;
            }
            File file = new File(ms(), "package_ugen_temp.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    ka.set(xr.xr(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (IOException e) {
                    sl.ms(e);
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        try {
            sl.ah("PlayComponentEngineCacheManager", "version init error", th);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    sl.ms(e2);
                }
            }
        }
    }

    public void d() {
        try {
            if (this.xr.get()) {
                return;
            }
            boolean z = true;
            this.xr.set(true);
            xr xrVar = new xr(re.ms().ms(2));
            xr xrVar2 = ka.get();
            if (!xrVar.c()) {
                this.xr.set(false);
                return;
            }
            if (!ms(xrVar2, xrVar.ah())) {
                this.xr.set(false);
                return;
            }
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    ka.ms().xr();
                }
            });
            List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> listXr = xr(xrVar, xrVar2);
            if (listXr == null) {
                z = false;
            }
            if (listXr == null) {
                this.xr.set(false);
            }
            if (z && ms(xrVar.getResources())) {
                ka.set(xrVar);
                ms(ms(), ka.get(), "package_ugen_temp.json");
                xr(listXr);
            }
            ab();
            this.xr.set(false);
        } catch (Throwable unused) {
        }
    }

    public void ka() {
        xr(ms(), ka.get(), "package_ugen_temp.json");
        ka.set(null);
    }

    public void c() {
        try {
            ka();
            File fileMs = ms();
            if (fileMs == null || !fileMs.exists()) {
                return;
            }
            if (fileMs.getParentFile() != null) {
                c.ah(fileMs.getParentFile());
            } else {
                c.ah(fileMs);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public void ab() {
        xr xrVar = ka.get();
        if (xrVar == null || !xrVar.c()) {
            return;
        }
        boolean zMs = ms(xrVar.getResources());
        if (!zMs) {
            ka();
        }
        this.d.set(zMs);
    }

    public boolean x() {
        AtomicBoolean atomicBoolean = this.d;
        return atomicBoolean != null && atomicBoolean.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.ms.xr.ah
    public File ms() {
        if (ah == null) {
            try {
                File file = new File(new File(d.ms(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                ah = file;
            } catch (Throwable th) {
                sl.ah("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return ah;
    }

    public WebResourceResponse ms(WebView webView, ch.ms msVar, String str) {
        File fileXr;
        try {
            if (TextUtils.isEmpty(str) || msVar == ch.ms.IMAGE || (fileXr = xr(str)) == null) {
                return null;
            }
            return new WebResourceResponse(msVar.getType(), "utf-8", new FileInputStream(fileXr));
        } catch (Throwable th) {
            sl.ah("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }

    private File xr(String str) {
        xr xrVar;
        if (!x() || (xrVar = ka.get()) == null) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : xrVar.getResources()) {
            if (c0231ms.ms() != null && c0231ms.ms().equals(str)) {
                File file = new File(ms(), com.bytedance.sdk.component.utils.ka.xr(c0231ms.ms()));
                String strMs = com.bytedance.sdk.component.utils.ka.ms(file);
                if (c0231ms.xr() == null || !c0231ms.xr().equals(strMs)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }
}
