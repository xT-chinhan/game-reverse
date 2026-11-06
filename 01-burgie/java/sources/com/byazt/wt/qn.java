package com.byazt.wt;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 467})
public class qn {
    public static volatile qn pr;
    public final Set<String> hn = Collections.synchronizedSet(new HashSet());
    public String hw;

    public static qn pr() {
        if (pr == null) {
            synchronized (qn.class) {
                if (pr == null) {
                    pr = new qn();
                }
            }
        }
        return pr;
    }

    public void pr(Set<com.byazt.hg.gz.hn> set, com.byazt.hg.gz.pr prVar) {
        hw(set, prVar);
        Iterator<com.byazt.hg.gz.hn> it = set.iterator();
        while (it.hasNext()) {
            pr(it.next(), prVar);
        }
    }

    private void pr(final com.byazt.hg.gz.hn hnVar, final com.byazt.hg.gz.pr prVar) {
        File[] fileArrListFiles;
        com.byazt.hg.gz.hn hnVarHw;
        com.byazt.hg.gz.x xVarHn = hnVar.hn();
        if (xVarHn == null) {
            return;
        }
        final String strPr = xVarHn.pr();
        if (this.hn.contains(strPr)) {
            return;
        }
        File file = new File(hw());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(hnVar.pr())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(com.byazt.ca.c.hw(xVarHn.hw()))) {
                            return;
                        }
                        com.byazt.ca.fw.hn(file2);
                        if (prVar != null && (hnVarHw = hw(hnVar.pr())) != null) {
                            prVar.hw(hnVarHw);
                        }
                    }
                }
            }
        }
        this.hn.add(strPr);
        File file3 = new File(hw(), com.byazt.ca.c.hw(strPr));
        com.byazt.tf.hn.pr(strPr, file3.getParent(), file3.getName()).pr(new com.byazt.hcx.fw() { // from class: com.byazt.wt.qn.1
            @Override // com.byazt.hcx.fw
            public void pr(final com.byazt.hcx.m mVar) {
                qn.this.hn.remove(strPr);
                if (mVar.fw() && mVar.vk() != null && mVar.vk().exists()) {
                    com.byazt.xlm.c.pr(new com.byazt.xlm.fw("downloadZip") { // from class: com.byazt.wt.qn.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.byazt.ca.gz.pr(mVar.vk().getAbsolutePath(), qn.this.hn(hnVar.x()));
                                if (prVar != null) {
                                    prVar.pr(hnVar);
                                }
                            } catch (Throwable th) {
                                com.byazt.ca.ho.pr("WebCacheResourceManager", "unzip web resources failed：" + qn.this.hn(hnVar.x()), th);
                            }
                            try {
                                mVar.vk().delete();
                            } catch (Throwable th2) {
                            }
                        }
                    }, 5);
                } else {
                    com.byazt.ca.ho.hw("WebCacheResourceManager", "download resources failed 1：" + strPr);
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                qn.this.hn.remove(strPr);
                com.byazt.ca.ho.hw("WebCacheResourceManager", "download resources failed 2：" + strPr);
            }
        });
    }

    private void pr(File file) {
        hw(file);
        try {
            com.byazt.sd.zo.nt().er().pr(file);
        } catch (Throwable th) {
        }
    }

    private void hw(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!file.setLastModified(jCurrentTimeMillis)) {
                    file.renameTo(file);
                    if (file.lastModified() < jCurrentTimeMillis) {
                        new Date(file.lastModified());
                        file.getAbsolutePath();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hn(String str) {
        File file = new File(hw(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String hw() {
        if (TextUtils.isEmpty(this.hw)) {
            try {
                File file = new File(com.byazt.ca.uc.hw(com.byazt.sd.a.getContext(), false, null), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.hw = file.getAbsolutePath();
            } catch (Throwable th) {
                com.byazt.ca.ho.hw("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.hw;
    }

    public Set<com.byazt.hg.gz.hn> pr(String str) {
        if (!com.byazt.hg.gz.pr || com.byazt.hg.gz.pr().isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (com.byazt.hg.gz.hn hnVar : com.byazt.hg.gz.pr()) {
                    if (path.contains(hnVar.hw())) {
                        hashSet.add(hnVar);
                    }
                }
                return hashSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public WebResourceResponse pr(WebResourceResponse webResourceResponse, String str, Set<com.byazt.hg.gz.hn> set, Map<String, pr> map) {
        pr prVar;
        com.byazt.hg.gz.x xVarHn;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                prVar = map.get(path);
                if (prVar == null) {
                    prVar = new pr(path);
                    map.put(path, prVar);
                }
            } else {
                prVar = new pr(path);
            }
            String strPr = "text/html";
            for (com.byazt.hg.gz.hn hnVar : set) {
                File file = new File(hn(hnVar.x()), path.substring(path.indexOf(hnVar.hw())).replace(hnVar.hw(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null && (xVarHn = hnVar.hn()) != null) {
                        for (com.byazt.hg.gz.hw hwVar : xVarHn.hn()) {
                            if (TextUtils.equals(hwVar.hw(), file.getName())) {
                                strPr = hwVar.pr();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strPr, "utf-8", fileInputStream);
                        try {
                            prVar.pr();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception e) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    pr(new File(hn(hnVar.x())));
                    return webResourceResponse;
                }
            }
            prVar.hw();
            return webResourceResponse;
        } catch (Exception e2) {
            return webResourceResponse;
        }
    }

    public void pr(com.byazt.hg.gz.pr prVar) {
        try {
            for (File file : new File(hw()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= 604800000) {
                    try {
                        com.byazt.ca.fw.hn(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (prVar != null) {
                            prVar.hw(hw(strSubstring));
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    public void hw(Set<com.byazt.hg.gz.hn> set, com.byazt.hg.gz.pr prVar) {
        File[] fileArrListFiles;
        boolean z;
        com.byazt.hg.gz.hn hnVarHw;
        File file = new File(hw());
        if (!file.exists() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.wt.qn.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<com.byazt.hg.gz.hn> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().pr().equals(strSubstring)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                com.byazt.ca.fw.hn(file2);
                if (prVar != null && (hnVarHw = hw(strSubstring)) != null) {
                    prVar.hw(hnVarHw);
                }
            }
        }
    }

    public static com.byazt.hg.gz.hn hw(String str) {
        if (com.byazt.hg.gz.pr().isEmpty()) {
            return null;
        }
        for (com.byazt.hg.gz.hn hnVar : com.byazt.hg.gz.pr()) {
            if (hnVar.pr().equals(str)) {
                return hnVar;
            }
        }
        return null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 1681})
    public static class pr {
        public final String pr;
        public final AtomicInteger hw = new AtomicInteger(0);
        public final AtomicInteger hn = new AtomicInteger(0);

        public pr(String str) {
            this.pr = str;
        }

        public void pr() {
            this.hw.incrementAndGet();
        }

        public void hw() {
            this.hn.incrementAndGet();
        }

        public String hn() {
            return this.pr;
        }

        public int x() {
            return this.hw.get();
        }

        public int c() {
            return this.hn.get();
        }
    }
}
