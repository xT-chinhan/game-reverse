package com.byazt.qq;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.anythink.core.e.i;
import com.byazt.gct.ln;
import com.byazt.nf.rv;
import com.byazt.qk.oa;
import com.byazt.tk.bb;
import com.byazt.tk.k;
import com.byazt.tk.l;
import com.byazt.tk.w;
import com.byazt.tk.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 8})
public class s {
    public static volatile s n;
    public String qg;
    public final Set<String> s = Collections.synchronizedSet(new HashSet());

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

    public void n(Set<ln.s> set, ln.n nVar) {
        qg(set, nVar);
        Iterator<ln.s> it = set.iterator();
        while (it.hasNext()) {
            n(it.next(), nVar);
        }
    }

    private void n(final ln.s sVar, final ln.n nVar) {
        File[] fileArrListFiles;
        ln.s sVarQg;
        ln.q qVarS = sVar.s();
        if (qVarS == null) {
            return;
        }
        final String strN = qVarS.n();
        if (this.s.contains(strN)) {
            return;
        }
        File file = new File(qg());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(sVar.n())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(l.qg(qVarS.qg()))) {
                            return;
                        }
                        x.s(file2);
                        if (nVar != null && (sVarQg = qg(sVar.n())) != null) {
                            nVar.qg(sVarQg);
                        }
                    }
                }
            }
        }
        this.s.add(strN);
        File file3 = new File(qg(), l.qg(strN));
        com.byazt.phf.s.n(strN, file3.getParent(), file3.getName()).n(new com.byazt.qk.x() { // from class: com.byazt.qq.s.1
            @Override // com.byazt.qk.x
            public void n(final oa oaVar) {
                s.this.s.remove(strN);
                if (oaVar.x() && oaVar.tj() != null && oaVar.tj().exists()) {
                    com.byazt.qit.l.n(new com.byazt.qit.x("downloadZip") { // from class: com.byazt.qq.s.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                bb.n(oaVar.tj().getAbsolutePath(), s.this.s(sVar.q()));
                                if (nVar != null) {
                                    nVar.n(sVar);
                                }
                            } catch (Throwable th) {
                                k.n("WebCacheResourceManager", "unzip web resources failed：" + s.this.s(sVar.q()), th);
                            }
                            try {
                                oaVar.tj().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                } else {
                    k.qg("WebCacheResourceManager", "download resources failed 1：" + strN);
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                s.this.s.remove(strN);
                k.qg("WebCacheResourceManager", "download resources failed 2：" + strN);
            }
        });
    }

    private void n(File file) {
        qg(file);
        try {
            com.byazt.vyf.s.cy().df().n(file);
        } catch (Throwable unused) {
        }
    }

    private void qg(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    new Date(file.lastModified());
                    file.getAbsolutePath();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s(String str) {
        File file = new File(qg(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String qg() {
        if (TextUtils.isEmpty(this.qg)) {
            try {
                File file = new File(w.qg(rv.getContext(), false, null), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.qg = file.getAbsolutePath();
            } catch (Throwable th) {
                k.qg("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.qg;
    }

    public Set<ln.s> n(String str) {
        if (!ln.n || ln.n().isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (ln.s sVar : ln.n()) {
                    if (path.contains(sVar.qg())) {
                        hashSet.add(sVar);
                    }
                }
                return hashSet;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse n(WebResourceResponse webResourceResponse, String str, Set<ln.s> set, Map<String, n> map) {
        n nVar;
        ln.q qVarS;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                nVar = map.get(path);
                if (nVar == null) {
                    nVar = new n(path);
                    map.put(path, nVar);
                }
            } else {
                nVar = new n(path);
            }
            String strN = "text/html";
            for (ln.s sVar : set) {
                File file = new File(s(sVar.q()), path.substring(path.indexOf(sVar.qg())).replace(sVar.qg(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null && (qVarS = sVar.s()) != null) {
                        for (ln.qg qgVar : qVarS.s()) {
                            if (TextUtils.equals(qgVar.qg(), file.getName())) {
                                strN = qgVar.n();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strN, "utf-8", fileInputStream);
                        try {
                            nVar.n();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    n(new File(s(sVar.q())));
                    return webResourceResponse;
                }
            }
            nVar.qg();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void n(ln.n nVar) {
        try {
            for (File file : new File(qg()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= i.f) {
                    try {
                        x.s(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (nVar != null) {
                            nVar.qg(qg(strSubstring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void qg(Set<ln.s> set, ln.n nVar) {
        File[] fileArrListFiles;
        boolean z;
        ln.s sVarQg;
        File file = new File(qg());
        if (file.exists() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.qq.s.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) != null) {
            for (File file2 : fileArrListFiles) {
                String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
                Iterator<ln.s> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().n().equals(strSubstring)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    x.s(file2);
                    if (nVar != null && (sVarQg = qg(strSubstring)) != null) {
                        nVar.qg(sVarQg);
                    }
                }
            }
        }
    }

    public static ln.s qg(String str) {
        if (ln.n().isEmpty()) {
            return null;
        }
        for (ln.s sVar : ln.n()) {
            if (sVar.n().equals(str)) {
                return sVar;
            }
        }
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 546})
    public static class n {
        public final String n;
        public final AtomicInteger qg = new AtomicInteger(0);
        public final AtomicInteger s = new AtomicInteger(0);

        public n(String str) {
            this.n = str;
        }

        public void n() {
            this.qg.incrementAndGet();
        }

        public void qg() {
            this.s.incrementAndGet();
        }

        public String s() {
            return this.n;
        }

        public int q() {
            return this.qg.get();
        }

        public int l() {
            return this.s.get();
        }
    }
}
