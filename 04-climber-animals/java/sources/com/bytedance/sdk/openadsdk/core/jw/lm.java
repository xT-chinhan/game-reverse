package com.bytedance.sdk.openadsdk.core.jw;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class lm {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile lm f2711ms;
    private final Set<String> ah = Collections.synchronizedSet(new HashSet());
    private String xr;

    public static lm ms() {
        if (f2711ms == null) {
            synchronized (lm.class) {
                if (f2711ms == null) {
                    f2711ms = new lm();
                }
            }
        }
        return f2711ms;
    }

    public void ms(List<com.bytedance.sdk.openadsdk.core.nw.cv.ah> list, com.bytedance.sdk.openadsdk.core.nw.cv.ms msVar) {
        xr(list, msVar);
        Iterator<com.bytedance.sdk.openadsdk.core.nw.cv.ah> it = list.iterator();
        while (it.hasNext()) {
            ms(it.next(), msVar);
        }
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.nw.cv.ah ahVar, final com.bytedance.sdk.openadsdk.core.nw.cv.ms msVar) {
        File[] fileArrListFiles;
        com.bytedance.sdk.openadsdk.core.nw.cv.d dVarAh = ahVar.ah();
        final String strMs = ahVar.ah().ms();
        if (this.ah.contains(strMs)) {
            return;
        }
        File file = new File(xr());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(ahVar.ms())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(com.bytedance.sdk.component.utils.ka.xr(dVarAh.xr()))) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.c.ah(file2);
                        if (msVar != null) {
                            msVar.xr(xr(ahVar.ms()));
                        }
                    }
                }
            }
        }
        this.ah.add(strMs);
        File file3 = new File(xr(), com.bytedance.sdk.component.utils.ka.xr(strMs));
        com.bytedance.sdk.component.ny.xr.xr xrVarD = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().d();
        xrVarD.ms(strMs);
        xrVarD.ms(file3.getParent(), file3.getName());
        xrVarD.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.lm.1
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, final com.bytedance.sdk.component.ny.xr xrVar) {
                lm.this.ah.remove(strMs);
                if (xrVar.x() && xrVar.ab() != null && xrVar.ab().exists()) {
                    com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.component.ch.ny("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.jw.lm.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.bytedance.sdk.component.utils.g.ms(xrVar.ab().getAbsolutePath(), lm.this.ah(ahVar.d()));
                                if (msVar != null) {
                                    msVar.ms(ahVar);
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.sl.ah("WebCacheResourceManager", "unzip web resources failed：" + lm.this.ah(ahVar.d()), th);
                            }
                            try {
                                xrVar.ab().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                } else {
                    com.bytedance.sdk.component.utils.sl.d("WebCacheResourceManager", "download resources failed 1：" + strMs);
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                lm.this.ah.remove(strMs);
                com.bytedance.sdk.component.utils.sl.d("WebCacheResourceManager", "download resources failed 2：" + strMs);
            }
        });
    }

    private void ms(File file) {
        xr(file);
        try {
            com.bytedance.sdk.openadsdk.core.ch.ub().m().ms(file);
        } catch (Throwable unused) {
        }
    }

    private void xr(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    com.bytedance.sdk.component.utils.sl.xr("WebCacheResourceManager", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ah(String str) {
        File file = new File(xr(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String xr() {
        if (TextUtils.isEmpty(this.xr)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(com.bytedance.sdk.openadsdk.core.re.getContext()), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.xr = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.xr;
    }

    public List<com.bytedance.sdk.openadsdk.core.nw.cv.ah> ms(String str) {
        if (!com.bytedance.sdk.openadsdk.core.nw.cv.f3041ms || com.bytedance.sdk.openadsdk.core.nw.cv.ms().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.nw.cv.ah ahVar : com.bytedance.sdk.openadsdk.core.nw.cv.ms()) {
                    if (path.contains(ahVar.xr())) {
                        arrayList.add(ahVar);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse ms(WebResourceResponse webResourceResponse, String str, List<com.bytedance.sdk.openadsdk.core.nw.cv.ah> list, Map<String, ms> map) {
        ms msVar;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                msVar = map.get(path);
                if (msVar == null) {
                    msVar = new ms(path);
                    map.put(path, msVar);
                }
            } else {
                msVar = new ms(path);
            }
            String strMs = "text/html";
            for (com.bytedance.sdk.openadsdk.core.nw.cv.ah ahVar : list) {
                File file = new File(ah(ahVar.d()), path.substring(path.indexOf(ahVar.xr())).replace(ahVar.xr(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null) {
                        for (com.bytedance.sdk.openadsdk.core.nw.cv.xr xrVar : ahVar.ah().ah()) {
                            if (TextUtils.equals(xrVar.xr(), file.getName())) {
                                strMs = xrVar.ms();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strMs, "utf-8", fileInputStream);
                        try {
                            msVar.ms();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    ms(new File(ah(ahVar.d())));
                    return webResourceResponse;
                }
            }
            msVar.xr();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nw.cv.ms msVar) {
        try {
            for (File file : new File(xr()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= 604800000) {
                    try {
                        com.bytedance.sdk.component.utils.c.ah(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (msVar != null) {
                            msVar.xr(xr(strSubstring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void xr(List<com.bytedance.sdk.openadsdk.core.nw.cv.ah> list, com.bytedance.sdk.openadsdk.core.nw.cv.ms msVar) {
        File[] fileArrListFiles;
        boolean z;
        File file = new File(xr());
        if (!file.exists() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.jw.lm.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<com.bytedance.sdk.openadsdk.core.nw.cv.ah> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().ms().equals(strSubstring)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                com.bytedance.sdk.component.utils.c.ah(file2);
                if (msVar != null) {
                    msVar.xr(xr(strSubstring));
                }
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.core.nw.cv.ah xr(String str) {
        if (com.bytedance.sdk.openadsdk.core.nw.cv.ms().isEmpty()) {
            return null;
        }
        for (com.bytedance.sdk.openadsdk.core.nw.cv.ah ahVar : com.bytedance.sdk.openadsdk.core.nw.cv.ms()) {
            if (ahVar.ms().equals(str)) {
                return ahVar;
            }
        }
        return null;
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final String f2715ms;
        private final AtomicInteger xr = new AtomicInteger(0);
        private final AtomicInteger ah = new AtomicInteger(0);

        ms(String str) {
            this.f2715ms = str;
        }

        void ms() {
            this.xr.incrementAndGet();
        }

        void xr() {
            this.ah.incrementAndGet();
        }

        public String ah() {
            return this.f2715ms;
        }

        public int d() {
            return this.xr.get();
        }

        public int ka() {
            return this.ah.get();
        }
    }
}
