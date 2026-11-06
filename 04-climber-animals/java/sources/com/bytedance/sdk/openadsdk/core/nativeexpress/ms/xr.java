package com.bytedance.sdk.openadsdk.core.nativeexpress.ms;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.rt;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.umeng.analytics.pro.bv;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f2976ms;

    public interface ms {
    }

    public static xr ms() {
        if (f2976ms == null) {
            synchronized (xr.class) {
                if (f2976ms == null) {
                    f2976ms = new xr();
                }
            }
        }
        return f2976ms;
    }

    public void ms(rt rtVar, String str, String str2) {
        if (rtVar == null) {
            return;
        }
        if (TextUtils.isEmpty(rtVar.ms())) {
            sl.d("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + rtVar.ms();
        final String strAh = rtVar.ah();
        final String strXr = rtVar.xr();
        final String strD = rtVar.d();
        if (TextUtils.isEmpty(str) && str2.equals(bv.aw)) {
            str = ch.ub().t();
        }
        final String str4 = str;
        ab.ms(new ny("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                xr.this.ms(str3, strAh, strXr, strD, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, String str2, String str3, String str4, String str5) {
        if (ms(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            xr(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            ms(str2, str, str3, str5, (ms) null);
        } else {
            xr(str2, str3, str5, str4, str);
        }
    }

    private void ms(final String str, final String str2, final String str3, final String str4, final ms msVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = ka.ms().xr().ah();
        ahVarAh.ms(str);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.2
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar != null && xrVar.x()) {
                    String strD = xrVar.d();
                    if (TextUtils.isEmpty(strD)) {
                        return;
                    }
                    ah.ms().ms(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms().ms(str2).xr(str3).ah(str).ka(str4).d(strD).ms(Long.valueOf(System.currentTimeMillis())), false);
                    xr.this.xr();
                    if (msVar != null) {
                        try {
                            new JSONObject(strD);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, IOException iOException) {
                if (msVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms> ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ah.ms().ms(str);
    }

    public String ms(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVarMs = ms(str + "_" + str2, str3);
        if (msVarMs == null) {
            return null;
        }
        ms(msVarMs);
        return msVarMs.ka();
    }

    private com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return ah.ms().ms(str, str2);
    }

    private void xr(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms();
        msVar.ah(str).ka(str3).d(str4).xr(str2).ms(str5).ms(Long.valueOf(System.currentTimeMillis()));
        ah.ms().ms(msVar, false);
        xr();
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar) {
        msVar.ms(Long.valueOf(System.currentTimeMillis()));
        ab.ms(new ny("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.3
            @Override // java.lang.Runnable
            public void run() {
                ah.ms().ms(msVar, true);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        int iZx = re.xr().zx();
        if (iZx <= 0) {
            iZx = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms> listXr = ah.ms().xr();
        if (listXr == null || listXr.isEmpty() || iZx >= listXr.size()) {
            if (listXr != null) {
                listXr.size();
                return;
            }
            return;
        }
        int size = (int) (listXr.size() - (iZx * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar : listXr) {
            treeMap.put(msVar.d(), msVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms) entry.getValue();
                if (msVar2 != null) {
                    hashSet.add(msVar2.ms());
                }
            }
        }
        ms(hashSet);
    }

    public void ms(Set<String> set) {
        try {
            ah.ms().ms(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
