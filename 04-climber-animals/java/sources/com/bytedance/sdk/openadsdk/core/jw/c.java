package com.bytedance.sdk.openadsdk.core.jw;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.tapsdk.tapad.constants.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<String, ms> f2675ms = Collections.synchronizedMap(new HashMap());
    private static com.bytedance.sdk.openadsdk.core.ao xr;

    public interface ms {
        void ah();

        void ms();

        void xr();
    }

    public static void ms(Context context, String str, String str2, String str3, ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.ms(context, str, str2, str3);
    }

    public static void ms(final Context context, final String str, final String str2, final String str3, final ms msVar, final com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar, final com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zMs = com.bytedance.sdk.openadsdk.core.ch.ub().ms(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    if (c.f2675ms.containsKey(str)) {
                        return;
                    }
                    if (!f.d() && !zMs) {
                        return;
                    }
                }
                c.ms(str, msVar);
                TTDelegateActivity.ms(context, str, str2, str3, abVar, lmVar);
            }
        });
    }

    public static void ms(final Context context, final String str, final String str2, final String str3, final ms msVar, final com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zMs = com.bytedance.sdk.openadsdk.core.ch.ub().ms(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                    if (c.f2675ms.containsKey(str)) {
                        return;
                    }
                    if (!f.d() && !zMs) {
                        return;
                    }
                }
                c.ms(str, msVar);
                TTDelegateActivity.ms(context, str, str2, str3, lmVar);
            }
        });
    }

    public static void ms(String str) {
        Map<String, ms> map = f2675ms;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void ms(Context context, String str, ms msVar, String str2, com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.ms(context, str, str2, lmVar);
    }

    public static void ms(final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final Context context, final String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ms(context, lmVar.df(), new ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.3
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                c.d(lmVar, context, str);
            }
        }, lmVar.zx(), lmVar);
    }

    public static void ms(Context context, String str, ms msVar, String str2) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.xr(context, str, str2);
    }

    public static void xr(final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final Context context, final String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ms(context, lmVar.df(), new ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.4
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                c.d(lmVar, context, str);
            }
        }, lmVar.zx());
    }

    public static void ms(Context context, String str, String str2, ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.ms(context, str, str2);
    }

    public static void ah(final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final Context context, final String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ms(context, lmVar.df(), lmVar.zx(), new ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.5
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                c.d(lmVar, context, str);
            }
        });
    }

    public static void ms(final Context context, final com.bytedance.sdk.openadsdk.core.nw.lm lmVar, final String str) {
        if (lmVar == null) {
            return;
        }
        String strDf = lmVar.df();
        if (TextUtils.isEmpty(strDf)) {
            return;
        }
        ms(strDf, new ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.6
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                c.d(lmVar, context, str);
            }
        });
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh = lmVar.ph();
        if (cVarPh == null) {
            return;
        }
        TTDelegateActivity.ah(context, strDf, cVarPh.ny());
    }

    public static void xr(Context context, String str, String str2, ms msVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ms(str2, msVar);
        TTDelegateActivity.ah(context, str2, str);
    }

    public static void ms(Context context, String str) {
        TTDelegateActivity.ms(context, str);
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(str);
    }

    public static void d(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, Context context, String str) {
        int iQv = com.bytedance.sdk.openadsdk.core.nw.nw.qv(lmVar);
        if (lmVar == null || context == null) {
            return;
        }
        if (lmVar.jr() == 4 || iQv != 0) {
            com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms(context, lmVar, str, false);
            if (ahVarMs instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
                ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ahVarMs).hi().ms(false);
            }
            ahVarMs.ms(lmVar, false);
        }
    }

    public static void ms(Context context, String str, String str2, String str3, String str4, String str5, ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.ms(context, str, str2, str3, str4, str5);
    }

    public static void ms(Context context, String str, boolean z, ms msVar) {
        if (z) {
            TTDelegateActivity.ms(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || msVar == null) {
                return;
            }
            ms(str, msVar);
            TTDelegateActivity.ms(context, str, z);
        }
    }

    public static void xr(String str) {
        ms(str, 1);
    }

    public static void ah(String str) {
        ms(str, 2);
    }

    public static void d(String str) {
        ms(str, 3);
    }

    public static void ms(final String str, final ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.jw.c.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.ah().ms(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ms(msVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            f2675ms.put(str, msVar);
        }
    }

    public static ms ka(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f2675ms.remove(str);
    }

    private static void ms(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.jw.c.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.ah().ms(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        ms msVarKa = ka(str);
        if (msVarKa == null) {
            return;
        }
        if (i == 1) {
            msVarKa.ms();
            return;
        }
        if (i == 2) {
            msVarKa.xr();
        } else if (i == 3) {
            msVarKa.ah();
        } else {
            msVarKa.ah();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.ao ah() {
        if (xr == null) {
            xr = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ah.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(com.bytedance.sdk.openadsdk.core.re.getContext()).ms(2));
        }
        return xr;
    }

    public static void ms(Context context, String str, com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        TTDelegateActivity.ms(context, str, lmVar);
    }

    public static void ms(Context context, final com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return;
        }
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(lmVar.df()).ms("pangle_logo").xr("open_policy").d(lmVar.lx()).ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.c.9
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Constants.p.a, lmVar.zg());
                jSONObject2.put("ad_slot_type", f.x(lmVar));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
        TTDelegateActivity.xr(context, lmVar.zg());
    }

    public static boolean ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null || lmVar.sh() || lmVar.mh() == null || com.bytedance.sdk.openadsdk.core.nw.nw.zb(lmVar) == 1 || lmVar.jr() != 4 || com.bytedance.sdk.openadsdk.core.nw.nw.sl(lmVar) == 0) {
            return false;
        }
        int iQv = lmVar.qv();
        return iQv == 4 || iQv == 5;
    }
}
