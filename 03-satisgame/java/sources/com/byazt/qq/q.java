package com.byazt.qq;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.ep.cp;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 5})
public class q {
    public static boolean n(pk pkVar, String str, boolean z) {
        if (pkVar == null) {
            return false;
        }
        String strFs = pkVar.fs();
        if (TextUtils.isEmpty(strFs)) {
            return false;
        }
        return n(strFs, pkVar, str, z);
    }

    public static boolean n(String str, pk pkVar, String str2, boolean z) {
        return n(rv.getContext(), str, pkVar, w.q(str2), str2, z);
    }

    public static boolean n(Context context, String str, pk pkVar, int i, String str2, boolean z) {
        try {
            Intent intentN = n(context, str, pkVar, i, null, str2, false);
            intentN.putExtra("web_dl_factors", z);
            return com.byazt.tk.n.n(context, intentN, null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean n(Object obj) {
        if (obj == null || !(obj instanceof com.byazt.cs.n.InterfaceC0149n)) {
            return false;
        }
        try {
            return ((com.byazt.cs.n.InterfaceC0149n) obj).ur();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent n(Context context, String str, pk pkVar, int i, Object obj, String str2, boolean z) {
        Class cls;
        boolean z2 = false;
        if (cd.l(pkVar)) {
            cls = TTSevenScreenWebPageActivity.class;
        } else if (cd.w(pkVar) && pkVar != null && !pkVar.an()) {
            cls = TTVideoWebPageActivity.class;
        } else if (cp.w(pkVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.byazt.fvm.rv) && pk.s(pkVar) && !n(obj) && w.fs(pkVar) && (pkVar == null || !pkVar.an())) {
            cls = TTVideoWebPageActivity.class;
            z2 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z2) {
            n(context, pkVar, obj, z, intent);
        }
        n(context, str, pkVar, i, str2, intent);
        return intent;
    }

    private static void n(Context context, pk pkVar, Object obj, boolean z, Intent intent) {
        int i;
        com.byazt.cs.n nVarD = null;
        if (obj != null) {
            nVarD = obj instanceof com.byazt.cs.n.InterfaceC0149n ? ((com.byazt.cs.n.InterfaceC0149n) obj).t() : null;
            if (nVarD != null) {
                intent.putExtra("multi_process_data", nVarD.n().toString());
            }
        }
        if ((obj instanceof com.byazt.za.qg) && (nVarD = ((com.byazt.za.qg) obj).d()) != null) {
            intent.putExtra("multi_process_data", nVarD.n().toString());
        }
        if (nVarD != null) {
            intent.putExtra("video_is_auto_play", nVarD.q);
            nVarD.n();
        }
        if (nVarD != null || z) {
            try {
                if (nVarD != null) {
                    i = (int) ((nVarD.x / nVarD.l) * 100.0f);
                } else {
                    com.byazt.cs.n nVar = new com.byazt.cs.n();
                    nVar.x = 100L;
                    nVar.n = true;
                    nVar.q = w.ur(pkVar);
                    intent.putExtra("multi_process_data", nVar.n().toString());
                    i = 100;
                }
                if (pkVar.cf() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (pkVar.cf() <= 0 || i <= pkVar.cf() || !w.ur(pkVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void n(Context context, String str, pk pkVar, int i, String str2, Intent intent) {
        if (!new com.byazt.wif.s(context, pkVar).q(false)) {
            pkVar.l(true);
        }
        intent.putExtra(ImagesContract.URL, str);
        intent.putExtra("gecko_id", pkVar.s());
        intent.putExtra("title", pkVar.E_());
        intent.putExtra("sdk_version", tj.l);
        intent.putExtra(MediationConstant.EXTRA_ADID, pkVar.q());
        intent.putExtra("log_extra", pkVar.F_());
        intent.putExtra(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, pkVar.xu() == null ? null : pkVar.xu().n());
        intent.putExtra("event_tag", str2);
        intent.putExtra("landing_page_source", i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", pkVar.x());
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        w.n(intent, pkVar);
    }

    public static boolean n(Context context, pk pkVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            n(context, (String) null, pkVar, i, str, intent);
            if (pk.s(pkVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.byazt.tk.n.n(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
