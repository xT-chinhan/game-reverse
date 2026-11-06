package com.byazt.nb;

import android.text.TextUtils;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1478, 5})
public class q {
    public static volatile q n;
    public long qg = 0;
    public ConcurrentHashMap<String, l> s = new ConcurrentHashMap<>();
    public HashMap<String, Integer> q = new HashMap<>();
    public List<String> l = new CopyOnWriteArrayList();

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public void n(String str, l lVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.put(str, lVar);
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.remove(str);
    }

    public long qg() {
        return this.qg;
    }

    public void s() {
        this.qg = System.currentTimeMillis();
    }

    public int qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.q == null) {
            this.q = new HashMap<>();
        }
        if (this.q.containsKey(str)) {
            return this.q.get(str).intValue();
        }
        return 0;
    }

    public static void n(com.byazt.h.qg qgVar) {
        DownloadInfo downloadInfo;
        if (qgVar == null || qgVar.qg() <= 0 || (downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVar.um())) == null) {
            return;
        }
        n(downloadInfo);
    }

    public static void n(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.byazt.f.n.n(downloadInfo.getId()).n("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }
}
