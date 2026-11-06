package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ao;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.nw.w;
import com.bytedance.sdk.openadsdk.core.re;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.tencent.bugly.Bugly;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static AtomicInteger f3415ms = new AtomicInteger();
    private static final HashSet<String> xr;

    static {
        HashSet<String> hashSet = new HashSet<>();
        xr = hashSet;
        hashSet.add("1473");
        hashSet.add("3682");
        hashSet.add("4760");
    }

    public static int ms(lm lmVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe;
        JSONObject jSONObjectAh;
        int iOptInt;
        if (lmVar == null || (msVarLe = lmVar.le()) == null || (jSONObjectAh = msVarLe.ah()) == null || (iOptInt = jSONObjectAh.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    public static boolean xr(lm lmVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.ms msVarLe;
        JSONObject jSONObjectAh;
        return (lmVar == null || (msVarLe = lmVar.le()) == null || (jSONObjectAh = msVarLe.ah()) == null || jSONObjectAh.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean ah(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        int iYu = lmVar.yu();
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarOp = lmVar.op();
        return msVarOp != null && iYu == 1 && msVarOp.d() == 4;
    }

    public static boolean d(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        int iYu = lmVar.yu();
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarOp = lmVar.op();
        return msVarOp != null && iYu == 1 && msVarOp.d() == 3;
    }

    public static boolean ka(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        int iYu = lmVar.yu();
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVarOp = lmVar.op();
        return msVarOp != null && iYu == 1 && msVarOp.d() == 2;
    }

    public static boolean c(lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        return ab(lmVar) || x(lmVar);
    }

    public static boolean ab(lm lmVar) {
        return (lmVar == null || lmVar.yu() != 1 || t.ms(lmVar)) ? false : true;
    }

    public static boolean x(lm lmVar) {
        return lmVar != null && lmVar.qv() > 0;
    }

    public static boolean ny(lm lmVar) {
        return lmVar != null && lmVar.du() == 7;
    }

    public static boolean ch(lm lmVar) {
        return lmVar != null && lmVar.du() == 10;
    }

    public static JSONObject ms(lm lmVar, View view, boolean z) {
        int i;
        JSONObject jSONObjectRm = lmVar.rm();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.g.ms msVarQv = re.xr().qv(String.valueOf(f.ny(lmVar)));
            if (com.bytedance.sdk.openadsdk.core.component.reward.d.d.ms(lmVar) == 4) {
                i = msVarQv.ah;
            } else {
                i = msVarQv.hi;
            }
            if (f.ka(lmVar)) {
                i = msVarQv.ah;
            }
            boolean z2 = false;
            jSONObject.put("voice_control", i == 1);
            Context context = re.getContext();
            jSONObject3.put("width", ul.d(context, ul.d(context)));
            jSONObject3.put("height", ul.d(context, ul.ka(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", ul.d(context, width) * 1.0f);
                jSONObject4.put("height", ul.d(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            jSONObjectRm.put("env_info", jSONObject2);
            jSONObjectRm.put("setting", jSONObject);
            jSONObjectRm.put("meta_hashcode", lmVar.ka());
            if (z && re.xr().cc()) {
                z2 = true;
            }
            jSONObjectRm.put("gesture_through_enable", z2);
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObjectRm;
    }

    public static void ms(List<lm> list, ao aoVar) {
        if (list == null || list.size() <= 0) {
            if (aoVar != null) {
                aoVar.xr();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (lm lmVar : list) {
            if (lmVar != null && lmVar.si() != null && ny(lmVar) && (!TextUtils.isEmpty(lmVar.si().ny()) || !TextUtils.isEmpty(lmVar.si().ch()))) {
                arrayList.add(lmVar.si());
            }
        }
        if (arrayList.size() <= 0) {
            aoVar.xr();
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ms((lm.ms) it.next(), aoVar);
        }
    }

    public static void ms(lm.ms msVar) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs;
        if (msVar == null) {
            return;
        }
        final String strNy = msVar.ny();
        final String strCh = msVar.ch();
        if ((TextUtils.isEmpty(strNy) && TextUtils.isEmpty(strCh)) || (xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms()) == null) {
            return;
        }
        if (TextUtils.isEmpty(strCh) || TextUtils.isEmpty(xrVarMs.xr(strCh, ""))) {
            com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.component.ch.ny("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.1
                @Override // java.lang.Runnable
                public void run() {
                    ch.d(strCh, strNy);
                }
            }, 10);
        }
    }

    public static void ms(String str, String str2) {
        com.bytedance.sdk.component.d.ms.xr xrVarMs;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms()) == null) {
            return;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(xrVarMs.xr(str2, ""))) {
            d(str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        if (ahVarAh == null) {
            return;
        }
        ahVarAh.ms(str2);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.2
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar != null) {
                    try {
                        if (!xrVar.x() || xrVar.d() == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.xr.ms().ms(str, xrVar.d());
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public static void ms(final String str, String str2, final ah ahVar) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        if (ahVarAh == null) {
            return;
        }
        ahVarAh.ms(str2);
        ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.3
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                String str3 = "tt_ugen_tpl";
                if (xrVar != null) {
                    try {
                        if (xrVar.x() && xrVar.d() != null) {
                            com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
                            final String strD = xrVar.d();
                            xrVarMs.ms(str, strD);
                            com.bytedance.sdk.component.utils.x.xr().post(new com.bytedance.sdk.component.ch.ny(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ahVar.ms(strD);
                                }
                            });
                            return;
                        }
                    } catch (Exception unused) {
                        com.bytedance.sdk.component.utils.x.xr().post(new com.bytedance.sdk.component.ch.ny(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.3.3
                            @Override // java.lang.Runnable
                            public void run() {
                            }
                        });
                        return;
                    }
                }
                com.bytedance.sdk.component.utils.x.xr().post(new com.bytedance.sdk.component.ch.ny(str3) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                com.bytedance.sdk.component.utils.x.xr().post(new com.bytedance.sdk.component.ch.ny("tt_ugen_tpl") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.3.4
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
    }

    public static JSONObject xr(String str, String str2) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        if (xrVarMs == null) {
            return null;
        }
        try {
            return new JSONObject(xrVarMs.xr(str, ""));
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static boolean hi(lm lmVar) {
        return (lmVar == null || lmVar.si() == null || xr(lmVar.si().ch(), lmVar.si().ny()) == null) ? false : true;
    }

    private static void ms(lm.ms msVar, ao aoVar) {
        String strNy = msVar.ny();
        String strCh = msVar.ch();
        if (TextUtils.isEmpty(strNy) && TextUtils.isEmpty(strCh)) {
            if (aoVar != null) {
                aoVar.xr();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(strCh)) {
            strCh = strNy;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        if (xrVarMs == null) {
            if (aoVar != null) {
                aoVar.xr();
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(xrVarMs.xr(strCh, ""))) {
                if (TextUtils.isEmpty(strNy)) {
                    aoVar.xr();
                }
                ms(strCh, strNy, aoVar);
            } else if (aoVar != null) {
                aoVar.ms();
            }
        } catch (Exception e) {
            sl.ms(e);
            if (aoVar != null) {
                aoVar.xr();
            }
        }
    }

    public static void ms(final String str, final String str2, final ao aoVar) {
        if (com.bytedance.sdk.openadsdk.core.xr.ms() == null) {
            aoVar.xr();
        } else {
            com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.component.ch.ny("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ch.4
                @Override // java.lang.Runnable
                public void run() {
                    ch.ah(str, str2, aoVar);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(String str, String str2, ao aoVar) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
        if (ahVarAh == null) {
            if (aoVar != null) {
                aoVar.xr();
                return;
            }
            return;
        }
        ahVarAh.ms(str2);
        com.bytedance.sdk.component.ny.xr xrVarMs = ahVarAh.ms();
        if (xrVarMs != null) {
            try {
                if (xrVarMs.x() && xrVarMs.d() != null) {
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms(str, xrVarMs.d());
                    if (aoVar != null) {
                        aoVar.ms();
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                sl.ms(e);
                if (aoVar != null) {
                    aoVar.xr();
                    return;
                }
                return;
            }
        }
        if (aoVar != null) {
            aoVar.xr();
        }
    }

    public static JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    public static boolean sl(lm lmVar) {
        return (lmVar == null || lmVar.jc() == null) ? false : true;
    }

    public static boolean ms(Context context, lm lmVar, String str) {
        return xr(context, lmVar, str) == 1;
    }

    public static int xr(Context context, lm lmVar, String str) {
        if (lmVar == null) {
            return -1;
        }
        w wVarJc = lmVar.jc();
        if (wVarJc == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String strXr = wVarJc.xr();
        if (xr(wVarJc.ah(), strXr) == null) {
            return TextUtils.isEmpty(strXr) ? 2 : 3;
        }
        return 1;
    }

    public static String ms(Context context, String str, lm lmVar, String str2) {
        w wVarJc = lmVar.jc();
        JSONObject jSONObjectSz = lmVar.sz();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String strFs = lmVar.fs();
            if (!TextUtils.isEmpty(strFs)) {
                jSONObject.put(BundleKey.DESCRIPTION, strFs);
            }
            if (jSONObjectSz != null) {
                jSONObject.put("easy_pl_material", jSONObjectSz.toString());
            }
            if (wVarJc != null) {
                jSONObject.put("ugen_dialog_url", wVarJc.xr());
                jSONObject.put("ugen_dialog_md5", wVarJc.ah());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", Bugly.SDK_IS_DEV);
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            sl.ms(e);
            return "";
        }
    }
}
