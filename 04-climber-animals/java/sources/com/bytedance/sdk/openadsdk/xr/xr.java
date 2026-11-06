package com.bytedance.sdk.openadsdk.xr;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bykv.vk.openvk.component.video.api.ah.ah;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.bytedance.sdk.openadsdk.op.ny;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private Set<String> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.openadsdk.xr.ms> f4306ms;
    private ReentrantLock xr;

    private static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final xr f4310ms = new xr();
    }

    public static xr ms() {
        return ms.f4310ms;
    }

    private xr() {
        this.f4306ms = new HashMap();
        this.xr = new ReentrantLock();
        this.ah = new HashSet();
        String strXr = com.bytedance.sdk.openadsdk.core.xr.ms().xr("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(strXr)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strXr);
            for (int i = 0; i < jSONArray.length(); i++) {
                xr(jSONArray.optJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private com.bytedance.sdk.component.ny.ms xr() {
        return ka.ms().xr();
    }

    private void xr(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.xr.ms msVar = new com.bytedance.sdk.openadsdk.xr.ms(jSONObject);
            this.f4306ms.put(msVar.xr(), msVar);
        }
    }

    public void ms(JSONObject jSONObject) {
        final JSONArray jSONArrayAh = ah(jSONObject);
        if (jSONArrayAh == null || jSONArrayAh.length() == 0) {
            return;
        }
        x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xr.xr.1
            @Override // java.lang.Runnable
            public void run() {
                jSONArrayAh.length();
                xr.this.ms(jSONArrayAh);
            }
        }, 20000L);
    }

    private JSONArray ah(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray2 == null) {
            return jSONArray;
        }
        for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("precache_brand_video")) != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    jSONArray.put(jSONArrayOptJSONArray.opt(i2));
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONArray jSONArray) {
        try {
            this.xr.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                xr(jSONArray.optJSONObject(i));
            }
            Map<String, com.bytedance.sdk.openadsdk.xr.ms> mapKa = ka();
            int iAh = ah();
            d();
            delete(mapKa);
            this.xr.unlock();
            ms(iAh);
        } catch (Throwable th) {
            this.xr.unlock();
            throw th;
        }
    }

    private void ms(int i) {
        File[] fileArrListFiles = new File(ny.ms()).listFiles();
        int iVi = re.xr().vi();
        if (fileArrListFiles == null || fileArrListFiles.length <= iVi - i) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            String strMs = ms(fileArrListFiles[i2]);
            if (!this.f4306ms.containsKey(strMs) && fileArrListFiles[i2].exists()) {
                fileArrListFiles[i2].delete();
                sl.xr("BrandVideoCacheManager", "delete not need:".concat(String.valueOf(strMs)));
            }
        }
    }

    private String ms(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(j.z);
        return iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.xr.ms> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).xr(ny.ms());
        }
    }

    private int ah() {
        Iterator<String> it = this.f4306ms.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            d dVarMs = ms(this.f4306ms.get(it.next()));
            if (dVarMs != null) {
                String strKa = dVarMs.ka();
                String strH = dVarMs.h();
                String strAo = dVarMs.ao();
                File file = new File(strKa, strH);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (this.ah.contains(strH)) {
                        sl.ms("BrandVideoCacheManager", " task :" + strH + " is running!");
                    } else {
                        this.ah.add(strH);
                        ms(strAo, strKa, strH);
                    }
                }
            }
        }
        return i;
    }

    private void ms(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.ny.xr.xr xrVarD = xr().d();
        xrVarD.ms(str);
        xrVarD.ms(str2, str3);
        xrVarD.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.xr.xr.2
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                xr.this.ms(str3);
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                sl.xr("BrandVideoCacheManager", "download " + str + " failed: " + iOException);
                xr.this.ms(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str) {
        try {
            this.xr.lock();
            this.ah.remove(str);
        } finally {
            this.xr.unlock();
        }
    }

    private d ms(com.bytedance.sdk.openadsdk.xr.ms msVar) {
        if (msVar == null) {
            return null;
        }
        String strXr = msVar.xr();
        if (TextUtils.isEmpty(strXr)) {
            strXr = com.bytedance.sdk.component.utils.ka.xr(msVar.ms());
        }
        ah ahVar = new ah();
        ahVar.ah(msVar.ms());
        ahVar.ka(strXr);
        ahVar.ka(0);
        d dVar = new d(ny.ms(), ahVar, ahVar, 0, 0);
        dVar.ms(ny.ms());
        return dVar;
    }

    private void d() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f4306ms.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.xr.ms msVar = this.f4306ms.get(it.next());
            if (msVar != null) {
                jSONArray.put(msVar.ka());
            }
        }
        com.bytedance.sdk.openadsdk.core.xr.ms().ms("sdk_brand_video_cahce", jSONArray.toString());
    }

    private Map<String, com.bytedance.sdk.openadsdk.xr.ms> ka() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.xr.ms>> it = this.f4306ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.xr.ms> next = it.next();
            if (next.getValue().d()) {
                map.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.f4306ms.size() - re.xr().vi();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.xr.ms>() { // from class: com.bytedance.sdk.openadsdk.xr.xr.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public int compare(com.bytedance.sdk.openadsdk.xr.ms msVar, com.bytedance.sdk.openadsdk.xr.ms msVar2) {
                    long jAh = msVar2.ah() - msVar.ah();
                    if (jAh == 0) {
                        String strMs = ny.ms();
                        jAh = msVar.ms(strMs) - msVar2.ms(strMs);
                    }
                    return (int) jAh;
                }
            });
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.openadsdk.xr.ms msVar = (com.bytedance.sdk.openadsdk.xr.ms) arrayList.get(i);
                this.f4306ms.remove(msVar.xr());
                map.put(msVar.xr(), msVar);
            }
        }
        return map;
    }
}
