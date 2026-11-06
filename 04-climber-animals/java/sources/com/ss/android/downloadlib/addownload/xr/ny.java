package com.ss.android.downloadlib.addownload.xr;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.addownload.hi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ny {

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ny f4458ms = new ny();
    }

    public static ny ms() {
        return ms.f4458ms;
    }

    private ny() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences ah() {
        return com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), "sp_ad_download_event", 0);
    }

    ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> xr() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = ah().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.ms.xr xrVarXr = com.ss.android.downloadad.api.ms.xr.xr(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && xrVarXr != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), xrVarXr);
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
        }
        return concurrentHashMap;
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(xrVar);
        ms((Collection<com.ss.android.downloadad.api.ms.xr>) arrayList);
    }

    public synchronized void ms(final Collection<com.ss.android.downloadad.api.ms.xr> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.addownload.xr.ny.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = ny.this.ah().edit();
                        for (com.ss.android.downloadad.api.ms.xr xrVar : collection) {
                            if (xrVar != null && xrVar.xr() != 0) {
                                editorEdit.putString(String.valueOf(xrVar.xr()), xrVar.gy().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void ms(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.addownload.xr.ny.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = ny.this.ah().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
