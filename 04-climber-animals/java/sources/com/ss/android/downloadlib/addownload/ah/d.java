package com.ss.android.downloadlib.addownload.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f4357ms;
    private long xr = 0;
    private ConcurrentHashMap<String, ka> ah = new ConcurrentHashMap<>();
    private HashMap<String, Integer> d = new HashMap<>();
    private List<String> ka = new CopyOnWriteArrayList();

    public static d ms() {
        if (f4357ms == null) {
            synchronized (d.class) {
                if (f4357ms == null) {
                    f4357ms = new d();
                }
            }
        }
        return f4357ms;
    }

    public void ms(String str, ka kaVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ah.put(str, kaVar);
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ah.remove(str);
    }

    long xr() {
        return this.xr;
    }

    void ah() {
        this.xr = System.currentTimeMillis();
    }

    public int xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.d == null) {
            this.d = new HashMap<>();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str).intValue();
        }
        return 0;
    }

    public static void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        DownloadInfo downloadInfo;
        if (xrVar == null || xrVar.xr() <= 0 || (downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVar.y())) == null) {
            return;
        }
        ms(downloadInfo);
    }

    public static void ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("delete_file_after_install", 0) == 0) {
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
        } catch (Exception e) {
            ab.ms(e);
        }
    }
}
