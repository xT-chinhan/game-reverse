package com.bytedance.sdk.component.adexpress.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ab f894ms;
    private AtomicBoolean xr = new AtomicBoolean(false);

    public interface ms {
        void ms();

        void xr();
    }

    public static ab ms() {
        if (f894ms == null) {
            synchronized (ab.class) {
                if (f894ms == null) {
                    f894ms = new ab();
                }
            }
        }
        return f894ms;
    }

    private ab() {
    }

    public com.bytedance.sdk.component.adexpress.ms.ah.xr ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.ms().ms(str);
    }

    public Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> xr(String str) {
        return c.ms().xr(str);
    }

    private void xr() {
        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() == null) {
            return;
        }
        int iMs = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().ms();
        if (iMs <= 0) {
            iMs = 100;
        }
        List<com.bytedance.sdk.component.adexpress.ms.ah.xr> listXr = c.ms().xr();
        if (listXr == null || listXr.isEmpty() || iMs >= listXr.size()) {
            if (listXr != null) {
                listXr.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar : listXr) {
            treeMap.put(xrVar.ab(), xrVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listXr.size() - (iMs * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar2 = (com.bytedance.sdk.component.adexpress.ms.ah.xr) entry.getValue();
                if (xrVar2 != null) {
                    hashSet.add(xrVar2.xr());
                }
            }
        }
        ms(hashSet);
        this.xr.set(false);
    }

    private JSONObject ms(String str, ms msVar) {
        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() == null) {
            msVar.xr();
            return null;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarKa = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().ka();
        ahVarKa.ms(str);
        com.bytedance.sdk.component.ny.xr xrVarMs = ahVarKa.ms();
        if (xrVarMs != null) {
            try {
                if (xrVarMs.x() && xrVarMs.d() != null) {
                    return new JSONObject(xrVarMs.d());
                }
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        msVar.xr();
        return null;
    }

    private JSONObject ah(String str) {
        com.bytedance.sdk.component.adexpress.ms.ms.ah ahVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah();
        if (ahVarAh == null) {
            return null;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarKa = ahVarAh.ka();
        ahVarKa.ms(str);
        com.bytedance.sdk.component.ny.xr xrVarMs = ahVarKa.ms();
        if (xrVarMs != null) {
            try {
                if (xrVarMs.x() && xrVarMs.d() != null) {
                    return new JSONObject(xrVarMs.d());
                }
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        return null;
    }

    public void ms(com.bytedance.sdk.component.adexpress.ms.ah.d dVar, String str) {
        if (dVar == null) {
            sl.d("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = dVar.f888ms;
        final String str3 = dVar.ah;
        final String str4 = dVar.xr;
        final String str5 = dVar.d;
        final String str6 = dVar.ka;
        final String strC = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null ? com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().c() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            sl.d("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.d.ka.ms(new ny("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.ms.xr.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    ab.this.ms(str2, str3, str4, str5, str6, strC);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(String str, String str2, String str3, String str4, String str5, String str6) {
        if (ms(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                xr(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            ms(str2, str6, str);
        } else {
            xr(str6, str, str3, str2, str4, str5);
        }
        boolean zMs = x.ms(str5);
        if (!xr.ka() || zMs) {
            ka.xr().ms(true);
        }
    }

    private void ms(String str, String str2, String str3) {
        JSONObject jSONObjectAh;
        if (TextUtils.isEmpty(str) || (jSONObjectAh = ah(str)) == null) {
            return;
        }
        String strOptString = jSONObjectAh.optString("md5");
        String strOptString2 = jSONObjectAh.optString("version");
        String strOptString3 = jSONObjectAh.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs = new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(str2).xr(str3).ah(strOptString).d(str).ka(strOptString3).c(strOptString2).ms(Long.valueOf(System.currentTimeMillis()));
        c.ms().ms(xrVarMs, false);
        xr();
        if (x.ms(strOptString2)) {
            xrVarMs.c(strOptString2);
            ka.xr().ms(true);
        }
    }

    public synchronized void ms(String str, String str2, String str3, String str4, String str5, String str6, ms msVar) {
        if (ms(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                xr(str6, str, str3, str2, str4, str5);
                msVar.ms();
            }
            msVar.ms();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            ms(str2, str6, str, msVar);
        } else {
            xr(str6, str, str3, str2, str4, str5);
            msVar.ms();
        }
        boolean zMs = x.ms(str5);
        if (!xr.ka() || zMs) {
            ka.xr().ms(true);
        }
    }

    private void xr(String str, String str2, String str3, String str4, String str5, String str6) {
        c.ms().ms(new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(str).xr(str2).ah(str3).d(str4).ka(str5).c(str6).ms(Long.valueOf(System.currentTimeMillis())), false);
        xr();
    }

    private void ms(String str, String str2, String str3, ms msVar) {
        if (TextUtils.isEmpty(str)) {
            msVar.xr();
            return;
        }
        JSONObject jSONObjectMs = ms(str, msVar);
        if (jSONObjectMs != null) {
            String strOptString = jSONObjectMs.optString("md5");
            String strOptString2 = jSONObjectMs.optString("version");
            String strOptString3 = jSONObjectMs.optString("data");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                msVar.xr();
                return;
            }
            com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs = new com.bytedance.sdk.component.adexpress.ms.ah.xr().ms(str2).xr(str3).ah(strOptString).d(str).ka(strOptString3).c(strOptString2).ms(Long.valueOf(System.currentTimeMillis()));
            if (xrVarMs == null || com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().xr() == null) {
                msVar.xr();
                return;
            }
            if (TextUtils.isEmpty(xrVarMs.xr())) {
                msVar.xr();
                return;
            }
            c.ms().ms(xrVarMs, false);
            xr();
            if (x.ms(strOptString2)) {
                xrVarMs.c(strOptString2);
                ka.xr().ms(true);
            }
            msVar.ms();
        }
    }

    public void ms(Set<String> set) {
        try {
            c.ms().ms(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
