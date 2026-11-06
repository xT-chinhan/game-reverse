package com.byazt.iip;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 4, 18})
public class l {
    private static List<String> qg(List<String> list) {
        if (list != null && !list.isEmpty()) {
            String[] strArr = {"abc_", "$avd_hide_", "avd_hide_", "$avd_show_", "avd_show_", "m3_avd_", "$m3_avd_", "ic_mtrl_", "$mtrl_", "mtrl_", "btn_checkbox_", "bd_progress_", "bd_bg_", "btn_radio_", "pangle_", "ksad_", "anythink_", "gdt_", "ksadsdk_", "mbridge_", "sig_", "tt_appdownloader_", "tt_mediation_", "ttdownloader_", "com.qq.e.", MediationConstant.ADN_KLEVIN, "kssdk_", "mobads_", "tapad_", "umeng_", "bdxadsdk.jar", "bugly_", "vivo_module_", "notplugmapnaveinfoox111.dex", "notplugmappoiinfoxo.db", "notplugmaprouteextradata.db", "-journal"};
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                for (int i = 0; i < 37; i++) {
                    String str = strArr[i];
                    if (!TextUtils.isEmpty(str) && (next.startsWith(str) || next.endsWith(str))) {
                        it.remove();
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static String n(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        List<String> listQg = qg(new ArrayList(new TreeSet(list)));
        return l$$ExternalSyntheticBackport0.m("|", listQg.subList(0, Math.min(listQg.size(), 100)));
    }
}
