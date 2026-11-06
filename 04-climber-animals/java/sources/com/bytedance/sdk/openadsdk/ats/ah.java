package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.g.c;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {"kv_store_factory"})
public class ah implements com.bytedance.sdk.component.d.xr {
    private static final Set<String> ah = new HashSet();
    private static File xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.d.ms.xr> f1828ms = new ConcurrentHashMap();

    public ah() {
        ah.add("sp_bidding_opt_libra");
    }

    @Override // com.bytedance.sdk.component.d.xr
    @ATSMethod(1)
    public com.bytedance.sdk.component.d.ms.xr ms(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.bytedance.sdk.component.d.ms.xr xrVar = this.f1828ms.get(str);
        if (xrVar != null) {
            return xrVar;
        }
        synchronized (this.f1828ms) {
            com.bytedance.sdk.component.d.ms.xr xrVar2 = this.f1828ms.get(str);
            if (xrVar2 != null) {
                return xrVar2;
            }
            com.bytedance.sdk.component.d.ms.xr xrVarD = d(str);
            this.f1828ms.put(str, xrVarD);
            return xrVarD;
        }
    }

    private com.bytedance.sdk.component.d.ms.xr d(String str) {
        int iIi = re.xr().ii();
        c cVarTc = re.xr().tc();
        if (iIi == 3 && Build.VERSION.SDK_INT != 27) {
            File fileAh = ah(str);
            return new com.bytedance.sdk.component.ab.ah.ah(fileAh, ms(fileAh, str), ms(str, cVarTc.f2506ms), cVarTc.xr);
        }
        return new com.bytedance.sdk.component.ab.ah.d(re.getContext().getSharedPreferences(ka(str), 0));
    }

    @Override // com.bytedance.sdk.component.d.xr
    @ATSMethod(2)
    public com.bytedance.sdk.component.d.ms.xr ms(String str, int i) {
        return ms(str);
    }

    private com.bytedance.sdk.component.ab.ms ms(File file, String str) {
        if (ah.contains(str)) {
            return ah();
        }
        if (g.xr >= 6900) {
            ms(file);
            return new com.bytedance.sdk.component.ab.ah.ms(null);
        }
        return ah();
    }

    private com.bytedance.sdk.component.ab.xr ms(String str, boolean z) {
        if (ah.contains(str)) {
            return d();
        }
        com.bytedance.sdk.component.ab.ms.ms msVar = z ? new com.bytedance.sdk.component.ab.ms.ms() : null;
        if (Build.VERSION.SDK_INT != 27 && g.xr >= 6900) {
            return new com.bytedance.sdk.component.ab.ah.ms(msVar);
        }
        return d();
    }

    private com.bytedance.sdk.component.ab.ms ah() {
        if (com.bytedance.sdk.component.ab.ah.ka.ms()) {
            return new com.bytedance.sdk.component.ab.ah.ka(null);
        }
        return new com.bytedance.sdk.component.ab.ah.c(null);
    }

    private com.bytedance.sdk.component.ab.xr d() {
        if (com.bytedance.sdk.component.ab.ah.ka.ms()) {
            return new com.bytedance.sdk.component.ab.ah.ka(null);
        }
        return new com.bytedance.sdk.component.ab.ah.c(null);
    }

    private void ms(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    @Override // com.bytedance.sdk.component.d.xr
    @ATSMethod(3)
    public com.bytedance.sdk.component.d.ms.ms ms(int i) {
        if (i != 32) {
            return null;
        }
        return new com.bytedance.sdk.component.ab.ms.ms();
    }

    @Override // com.bytedance.sdk.component.d.xr
    @ATSMethod(4)
    public void ms() {
        Iterator<String> it = this.f1828ms.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.d.ms.xr xrVar = this.f1828ms.get(it.next());
            if (xrVar != null) {
                xrVar.xr();
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.xr
    @ATSMethod(5)
    public void xr() {
        synchronized (this.f1828ms) {
            this.f1828ms.clear();
        }
    }

    public static com.bytedance.sdk.component.d.ms.xr xr(String str) {
        return ((com.bytedance.sdk.component.d.xr) AutoService.ms(com.bytedance.sdk.component.d.xr.class)).ms(str);
    }

    public static SharedPreferences ms(Context context, String str, int i) {
        return xr(str);
    }

    private static File ka() {
        String name;
        File filesDir = re.getContext().getFilesDir();
        do {
            name = filesDir.getName();
            if (name == null) {
                break;
            }
            filesDir = filesDir.getParentFile();
        } while (!name.equals("files"));
        return new File(filesDir, "shared_prefs");
    }

    public static File ah(String str) {
        if (xr == null) {
            xr = ka();
        }
        return new File(xr, ka(str) + ".xml");
    }

    private static String ka(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(String.valueOf(str)) : str;
    }
}
