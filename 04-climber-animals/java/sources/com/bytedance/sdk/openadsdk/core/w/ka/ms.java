package com.bytedance.sdk.openadsdk.core.w.ka;

import com.bytedance.sdk.openadsdk.ats.ah;
import com.bytedance.sdk.openadsdk.core.w.xr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3686ms;

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms() {
        return "ugen_render";
    }

    public static ms xr() {
        if (f3686ms == null) {
            synchronized (ms.class) {
                if (f3686ms == null) {
                    f3686ms = new ms();
                }
            }
        }
        return f3686ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms(String str) {
        int iXr = ah.xr(ms()).xr(str, 0);
        return (iXr == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(iXr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public void ms(String str, String str2) {
        com.bytedance.sdk.component.d.ms.xr xrVarXr = ah.xr(ms());
        synchronized (xrVarXr) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(xrVarXr.xr("key_h5_render_result_list", new HashSet()));
                if (linkedHashSet.size() >= 100) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if ((System.currentTimeMillis() - Long.parseLong(str3.substring(0, str3.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet.size() < 100) {
                            break;
                        }
                        it.remove();
                        if (str3.endsWith("0")) {
                            xrVarXr.ms("h5_render_success", xrVarXr.xr("h5_render_success", 0) - 1);
                        } else if (str3.endsWith("1")) {
                            xrVarXr.ms("h5_render_fail", xrVarXr.xr("h5_render_fail", 0) - 1);
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    xrVarXr.ms("h5_render_success", xrVarXr.xr("h5_render_success", 0) + 1);
                } else {
                    xrVarXr.ms("h5_render_fail", xrVarXr.xr("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                xrVarXr.ms("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(xrVarXr.xr("native_key_render_result_list", new HashSet()));
                if (linkedHashSet2.size() >= 100) {
                    Iterator it2 = linkedHashSet2.iterator();
                    while (it2.hasNext()) {
                        String str4 = (String) it2.next();
                        if ((System.currentTimeMillis() - Long.parseLong(str4.substring(0, str4.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet2.size() < 100) {
                            break;
                        }
                        it2.remove();
                        if (str4.endsWith("0")) {
                            xrVarXr.ms("native_render_success", xrVarXr.xr("native_render_success", 0) - 1);
                        } else if (str4.endsWith("1")) {
                            xrVarXr.ms("native_render_fail", xrVarXr.xr("native_render_fail", 0) - 1);
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    xrVarXr.ms("native_render_success", xrVarXr.xr("native_render_success", 0) + 1);
                } else {
                    xrVarXr.ms("native_render_fail", xrVarXr.xr("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                xrVarXr.ms("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
