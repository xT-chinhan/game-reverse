package com.bytedance.sdk.component.adexpress.ms.xr;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.d.ch;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static Object f904ms = new Object();

    public static void ms() {
        ka.xr();
    }

    public static void xr() {
        try {
            x.d();
            File fileAb = ka.ab();
            if (fileAb == null || !fileAb.exists()) {
                return;
            }
            if (fileAb.getParentFile() != null) {
                com.bytedance.sdk.component.utils.c.ah(fileAb.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.c.ah(fileAb);
            }
        } catch (Throwable unused) {
        }
    }

    public static String ah() {
        return c.ah();
    }

    public static void ms(com.bytedance.sdk.component.adexpress.ms.ah.d dVar) {
        ab.ms().ms(dVar, dVar.c);
    }

    public static Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> ms(String str, boolean z) {
        final Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> setXr = ab.ms().xr(str);
        if (setXr != null && setXr.size() > 0) {
            if (z) {
                com.bytedance.sdk.component.adexpress.d.ka.ms(new ny("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.ms.xr.xr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.xr((Set<com.bytedance.sdk.component.adexpress.ms.ah.xr>) setXr);
                    }
                }, 5);
            } else {
                xr(setXr);
            }
        }
        return setXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar : set) {
                xrVar.ms(Long.valueOf(System.currentTimeMillis()));
                c.ms().ms(xrVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.ms.ah.xr ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs = ab.ms().ms(str);
        if (xrVarMs != null) {
            xrVarMs.ms(Long.valueOf(System.currentTimeMillis()));
            ms(xrVarMs);
        }
        return xrVarMs;
    }

    private static void ms(final com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar) {
        com.bytedance.sdk.component.adexpress.d.ka.ms(new ny("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.ms.xr.xr.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (xr.f904ms) {
                    c.ms().ms(xrVar, true);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.ms.ah.ms d() {
        return ka.xr().ka();
    }

    @Deprecated
    private static String c() {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD = d();
        if (msVarD == null) {
            return null;
        }
        return msVarD.d();
    }

    public static String xr(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVar;
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD = d();
        if (msVarD == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs = msVarD.ms();
            if (mapMs == null || mapMs.size() <= 0 || (msVar = mapMs.get(str)) == null) {
                return null;
            }
            return msVar.d();
        }
        return c();
    }

    public static boolean ka() {
        return ka.xr().d();
    }

    public static ms ms(String str, ch.ms msVar, String str2, String str3) {
        File fileD;
        ms msVar2 = new ms();
        if (TextUtils.isEmpty(str3)) {
            fileD = null;
        } else {
            fileD = xr(str3, str);
            if (fileD != null) {
                msVar2.ms(1);
            }
        }
        if (fileD == null && (fileD = ka(str)) != null) {
            msVar2.ms(3);
        }
        if (fileD == null && (fileD = d(str)) != null) {
            msVar2.ms(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!ms(str, str3)) {
                msVar2.ms(4);
            }
        } else if (!ah(str)) {
            msVar2.ms(6);
        }
        msVar2.getType();
        if (fileD != null) {
            try {
                msVar2.ms(new WebResourceResponse(msVar.getType(), "utf-8", new FileInputStream(fileD)));
            } catch (Throwable th) {
                sl.ah("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return msVar2;
    }

    private static boolean ms(String str, String str2) {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD;
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVar;
        if (!ka() || (msVarD = d()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs = msVarD.ms();
        if (mapMs.size() == 0 || (msVar = mapMs.get(str2)) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : msVar.getResources()) {
            if (c0231ms != null && TextUtils.equals(str, c0231ms.ms())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ah(String str) {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD;
        List<com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms> resources;
        if (!ka() || (msVarD = d()) == null || (resources = msVarD.getResources()) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : resources) {
            if (c0231ms != null && TextUtils.equals(str, c0231ms.ms())) {
                return true;
            }
        }
        return false;
    }

    private static File d(String str) {
        if (!ka()) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : d().getResources()) {
            if (c0231ms.ms() != null && c0231ms.ms().equals(str)) {
                File file = new File(ka.ab(), com.bytedance.sdk.component.utils.ka.xr(c0231ms.ms()));
                String strMs = com.bytedance.sdk.component.utils.ka.ms(file);
                if (c0231ms.xr() == null || !c0231ms.xr().equals(strMs)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static File ka(String str) {
        List<Pair<String, String>> listXr;
        com.bytedance.sdk.component.adexpress.ms.ah.ms.xr xrVarKa = d().ka();
        if (xrVarKa == null || (listXr = xrVarKa.xr()) == null || listXr.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listXr) {
            if (pair.second != null && ((String) pair.second).equals(str)) {
                return new File(ka.ab(), (String) pair.first);
            }
        }
        return null;
    }

    private static File xr(String str, String str2) {
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVar;
        com.bytedance.sdk.component.adexpress.ms.ah.ms msVarD = d();
        if (msVarD == null || !ka()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.ms.ah.ms> mapMs = msVarD.ms();
        if (mapMs.size() == 0 || (msVar = mapMs.get(str)) == null) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : msVar.getResources()) {
            if (c0231ms.ms() != null && c0231ms.ms().equals(str2)) {
                File file = new File(ka.ab(), com.bytedance.sdk.component.utils.ka.xr(c0231ms.ms()));
                String strMs = com.bytedance.sdk.component.utils.ka.ms(file);
                if (c0231ms.xr() == null || !c0231ms.xr().equals(strMs)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean ms(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean xr(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static boolean ah(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
