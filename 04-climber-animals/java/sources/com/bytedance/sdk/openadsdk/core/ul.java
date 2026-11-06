package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ul {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f3579ms = false;

    public static void ms(boolean z) {
        f3579ms = z;
    }

    public static boolean ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.c cVar, String str, boolean z, boolean z2, JSONObject jSONObject) {
        Object objXr;
        String strIr;
        if (cVar == null) {
            return false;
        }
        Context context = cVar.getContext();
        lm lmVarXr = cVar.xr();
        int iNy = cVar.ny();
        Object objZb = cVar.zb();
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarX = cVar.x();
        boolean zSl = cVar.sl();
        try {
            jSONObject.putOpt("source", Integer.valueOf(iNy));
        } catch (JSONException unused) {
        }
        if (context == null || lmVarXr == null || iNy == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.nw.h hVarTc = lmVarXr.tc();
        if (cVar.qv() != null && cVar.qv().ms()) {
            try {
                jSONObject.putOpt("pip", Boolean.TRUE);
            } catch (JSONException unused2) {
            }
            return true;
        }
        if (hVarTc != null) {
            try {
                objXr = hVarTc.xr();
            } catch (JSONException unused3) {
            }
        } else {
            objXr = "";
        }
        jSONObject.putOpt("url", objXr);
        if (hVarTc != null) {
            com.bytedance.sdk.openadsdk.core.hi.ah ahVar = new com.bytedance.sdk.openadsdk.core.hi.ah(lmVarXr, str, context);
            Boolean boolMs = ahVar.ms(iNy, jSONObject);
            try {
                jSONObject.putOpt("dpl_result", boolMs);
            } catch (JSONException unused4) {
            }
            if (boolMs != null) {
                return boolMs.booleanValue();
            }
            if (ahVar.ms(ahVarX, z, z2)) {
                return true;
            }
            strIr = ahVar.ms();
        } else {
            strIr = lmVarXr.ir();
        }
        return ms(context, lmVarXr, iNy, objZb, str, zSl, strIr);
    }

    private static boolean ms(Context context, lm lmVar, int i, Object obj, String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (lmVar.jr() != 2) {
            com.bytedance.sdk.component.utils.xr.ms(context, ms(context, str2, lmVar, i, obj, str, z), null);
            f3579ms = false;
            return true;
        }
        if (!com.bytedance.sdk.component.utils.u.ms(str2)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str2));
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.component.utils.xr.ms(context, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ms(lm lmVar, String str) {
        if (lmVar == null) {
            return false;
        }
        String strIr = lmVar.ir();
        if (TextUtils.isEmpty(strIr)) {
            return false;
        }
        return ms(strIr, lmVar, str);
    }

    public static boolean ms(String str, lm lmVar, String str2) {
        return ms(re.getContext(), str, lmVar, com.bytedance.sdk.openadsdk.core.jw.f.xr(str2), str2);
    }

    public static boolean ms(Context context, String str, lm lmVar, String str2) {
        return ms(context, str, lmVar, com.bytedance.sdk.openadsdk.core.jw.f.xr(str2), str2);
    }

    public static boolean ms(Context context, String str, lm lmVar, int i, String str2) {
        try {
            return com.bytedance.sdk.component.utils.xr.ms(context, ms(context, str, lmVar, i, (Object) null, str2, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean ms(Object obj) {
        if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms)) {
            return false;
        }
        try {
            return ((com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms) obj).m_();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent ms(Context context, String str, lm lmVar, int i, Object obj, String str2, boolean z) {
        Class cls;
        boolean z2 = false;
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.c(lmVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.bytedance.sdk.openadsdk.ao.xr.xr.ny) && lm.xr(lmVar) && !f3579ms && !ms(obj) && com.bytedance.sdk.openadsdk.core.jw.f.ka(lmVar) && (lmVar == null || !lmVar.ab())) {
            cls = TTVideoWebPageActivity.class;
            z2 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z2) {
            ms(context, lmVar, obj, z, intent);
        }
        ms(context, str, lmVar, i, str2, intent);
        return intent;
    }

    private static void ms(Context context, lm lmVar, Object obj, boolean z, Intent intent) {
        int i;
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVarHi = null;
        if (obj != null) {
            msVarHi = obj instanceof com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms ? ((com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms) obj).r_() : null;
            if (msVarHi != null) {
                intent.putExtra("multi_process_data", msVarHi.ms().toString());
            }
        }
        if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.xr) && (msVarHi = ((com.bytedance.sdk.openadsdk.core.nativeexpress.xr) obj).hi()) != null) {
            intent.putExtra("multi_process_data", msVarHi.ms().toString());
        }
        if (msVarHi != null) {
            intent.putExtra("video_is_auto_play", msVarHi.d);
            com.bytedance.sdk.component.utils.sl.ms("videoDataModel", "videoDataModel=" + msVarHi.ms().toString());
        }
        if (msVarHi != null || z) {
            try {
                if (msVarHi != null) {
                    i = (int) ((msVarHi.ab / msVarHi.ka) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
                    msVar.ab = 100L;
                    msVar.f2932ms = true;
                    msVar.d = com.bytedance.sdk.openadsdk.core.jw.f.nw(lmVar);
                    intent.putExtra("multi_process_data", msVar.ms().toString());
                    i = 100;
                }
                if (lmVar.jj() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (lmVar.jj() <= 0 || i <= lmVar.jj() || !com.bytedance.sdk.openadsdk.core.jw.f.nw(lmVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void ms(Context context, String str, lm lmVar, int i, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(context, lmVar).d(false)) {
            lmVar.ah(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", lmVar.so());
        intent.putExtra("title", lmVar.eh());
        intent.putExtra("sdk_version", g.xr);
        intent.putExtra("ad_id", lmVar.df());
        intent.putExtra("log_extra", lmVar.lx());
        intent.putExtra("icon_url", lmVar.qd() == null ? null : lmVar.qd().ms());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("has_phone_num_status", lmVar.ah());
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        com.bytedance.sdk.openadsdk.core.jw.f.ms(intent, lmVar);
    }

    public static boolean ms(Context context, lm lmVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            ms(context, null, lmVar, i, str, intent);
            if (lm.xr(lmVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.xr.ms(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
