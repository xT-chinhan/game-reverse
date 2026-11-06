package com.ss.android.downloadlib.addownload.xr;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final ConcurrentHashMap<Long, DownloadEventConfig> ah;
    private final ConcurrentHashMap<Long, DownloadController> d;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile boolean f4449ms;
    private final ConcurrentHashMap<Long, DownloadModel> xr;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static c f4451ms = new c();
    }

    public static c ms() {
        return ms.f4451ms;
    }

    private c() {
        this.f4449ms = false;
        this.xr = new ConcurrentHashMap<>();
        this.ah = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.ka = new ConcurrentHashMap<>();
    }

    public void xr() {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.addownload.xr.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f4449ms) {
                    return;
                }
                synchronized (c.class) {
                    if (!c.this.f4449ms) {
                        c.this.ka.putAll(ny.ms().xr());
                        c.this.f4449ms = true;
                    }
                }
            }
        }, true);
    }

    public void ms(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.xr.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public void ms(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.ah.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void ms(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.d.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        this.ka.put(Long.valueOf(xrVar.xr()), xrVar);
        ny.ms().ms(xrVar);
    }

    public DownloadModel ms(long j) {
        return this.xr.get(Long.valueOf(j));
    }

    public DownloadEventConfig xr(long j) {
        return this.ah.get(Long.valueOf(j));
    }

    public DownloadController ah(long j) {
        return this.d.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.ms.xr d(long j) {
        return this.ka.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> ah() {
        return this.ka;
    }

    public com.ss.android.downloadad.api.ms.xr ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ms.xr xrVar : this.ka.values()) {
            if (xrVar != null && str.equals(xrVar.ka())) {
                return xrVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ms.xr xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.ms.xr xrVar : this.ka.values()) {
            if (xrVar != null && str.equals(xrVar.ms())) {
                return xrVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ms.xr ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.ms.xr xrVar : this.ka.values()) {
            if (xrVar != null && xrVar.y() == downloadInfo.getId()) {
                return xrVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jMs = zb.ms(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jMs != 0) {
                    for (com.ss.android.downloadad.api.ms.xr xrVar2 : this.ka.values()) {
                        if (xrVar2 != null && xrVar2.xr() == jMs) {
                            return xrVar2;
                        }
                    }
                    com.ss.android.downloadlib.ka.ah.ms().ms("getNativeModelByInfo");
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        for (com.ss.android.downloadad.api.ms.xr xrVar3 : this.ka.values()) {
            if (xrVar3 != null && TextUtils.equals(xrVar3.ms(), downloadInfo.getUrl())) {
                return xrVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.ms.xr ms(int i) {
        for (com.ss.android.downloadad.api.ms.xr xrVar : this.ka.values()) {
            if (xrVar != null && xrVar.y() == i) {
                return xrVar;
            }
        }
        return null;
    }

    public ka ka(long j) {
        ka kaVar = new ka();
        kaVar.f4454ms = j;
        kaVar.xr = ms(j);
        kaVar.ah = xr(j);
        if (kaVar.ah == null) {
            kaVar.ah = new com.ss.android.download.api.download.ah();
        }
        kaVar.d = ah(j);
        if (kaVar.d == null) {
            kaVar.d = new com.ss.android.download.api.download.xr();
        }
        return kaVar;
    }

    public void c(long j) {
        this.xr.remove(Long.valueOf(j));
        this.ah.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }

    public Map<Long, com.ss.android.downloadad.api.ms.xr> ms(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.ms.xr xrVar : this.ka.values()) {
                if (xrVar != null && TextUtils.equals(xrVar.ms(), str)) {
                    xrVar.xr(str2);
                    map.put(Long.valueOf(xrVar.xr()), xrVar);
                }
            }
        }
        return map;
    }

    public void xr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.xr.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public synchronized void ms(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.ka.remove(Long.valueOf(jLongValue));
        }
        ny.ms().ms((List<String>) arrayList);
    }
}
