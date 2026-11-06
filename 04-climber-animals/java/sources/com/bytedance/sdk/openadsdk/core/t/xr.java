package com.bytedance.sdk.openadsdk.core.t;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static final Set<String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final String f3363ms = UUID.randomUUID().toString();
    public static AtomicInteger xr = new AtomicInteger(0);
    private static String d = "_create";
    public static final AtomicBoolean ah = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        ka = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
    }

    public static void ms(Context context, boolean z) {
        if (ah.compareAndSet(false, true) || com.bytedance.sdk.component.x.xr.ms.ms("csj")) {
            xr(context, z);
            com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.t.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.x.xr.ms.d("csj");
                }
            }, com.bytedance.sdk.openadsdk.core.ch.ub().ab() ? 20000L : 30000L);
        }
    }

    private static void xr(Context context, boolean z) {
        if (context == null) {
            return;
        }
        int iJw = re.xr().jw();
        if (iJw <= 0 || iJw == Integer.MAX_VALUE) {
            iJw = 100;
        }
        int iYu = re.xr().yu();
        if (iYu > iJw) {
            iYu = 5;
            iJw = 10;
        }
        com.bytedance.sdk.component.x.xr.ms.ms(new com.bytedance.sdk.component.x.ms.ms.C0254ms().ah(com.bytedance.sdk.component.x.xr.d.xr.ms.ms(iYu, iJw)).ms(com.bytedance.sdk.component.x.xr.d.xr.ms.ms(1, iJw)).xr(com.bytedance.sdk.component.x.xr.d.xr.ms.ms(1, iJw)).xr(z).ms("csj").ms(context).ms(new ny()).ms(x.f3362ms).ms(re.xr().cv()).ms());
    }

    public static void ms() {
        com.bytedance.sdk.component.x.xr.ms.ms(false, "csj");
    }

    public static void ms(com.bytedance.sdk.component.x.xr.d.ms.ms msVar, String str, int i) {
        if (com.bytedance.sdk.component.x.xr.ms.ms("csj")) {
            ms(re.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
        }
        if (re.xr().gs()) {
            return;
        }
        com.bytedance.sdk.component.x.xr.ms.ms(msVar, "csj");
    }

    public static void xr() {
        com.bytedance.sdk.component.x.xr.ms.ms(x.f3362ms, "csj");
    }

    private static void ms(String str, com.bytedance.sdk.component.x.xr.d.ms.ms msVar) {
        if (re.xr().nw()) {
            try {
                msVar.ah(com.bytedance.sdk.component.x.xr.ah.ms.xr(str));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.xr(e.getMessage());
            }
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.zb.ms msVar, String str) {
        if (!re.xr().gs() || ka.contains(str)) {
            com.bytedance.sdk.component.x.xr.d.ms.ms msVar2 = new com.bytedance.sdk.component.x.xr.d.ms.ms(msVar.d(), msVar);
            msVar2.xr(msVar.c() ? (byte) 1 : (byte) 2);
            msVar2.ms((byte) 0);
            ms(msVar.ah(), msVar2);
            if (com.bytedance.sdk.component.x.xr.ms.ms("csj")) {
                ms(re.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
            }
            com.bytedance.sdk.component.x.xr.ms.ms(msVar2, "csj");
            com.bytedance.sdk.openadsdk.core.w.ah ahVar = (com.bytedance.sdk.openadsdk.core.w.ah) AutoService.ms(com.bytedance.sdk.openadsdk.core.w.ah.class);
            if (ahVar != null) {
                ahVar.ms(str, msVar2);
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.core.t.ah.ms ah() {
        return zb.f3364ms;
    }

    public static void ms(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.bytedance.sdk.component.x.xr.ms.ms("csj")) {
            ms(re.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
        }
        com.bytedance.sdk.component.x.xr.ms.ms("csj", str, ms(list, b.ms(false)), z, map, jSONObject);
    }

    public static List<String> ms(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String strReplace = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("{OAID}") || strReplace.contains("__OAID__")) {
                        strReplace = strReplace.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(strReplace);
                }
            }
        }
        return list;
    }

    public static void ms(String str) {
        if (com.bytedance.sdk.component.x.xr.ms.ms("csj")) {
            ms(re.getContext(), com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
        }
        com.bytedance.sdk.component.x.xr.ms.ms("csj", str);
    }

    public static void d() {
        try {
            com.bytedance.sdk.component.x.xr.ms.xr("csj");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d(d, e.getMessage());
        }
    }
}
