package com.byazt.sd;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT})
public class n {
    public static boolean pr(of ofVar, String str, boolean z) {
        if (ofVar == null) {
            return false;
        }
        String strZo = ofVar.zo();
        if (TextUtils.isEmpty(strZo)) {
            return false;
        }
        return pr(strZo, ofVar, str, z);
    }

    public static boolean pr(String str, of ofVar, String str2, boolean z) {
        return pr(a.getContext(), str, ofVar, ls.x(str2), str2, z);
    }

    public static boolean pr(Context context, String str, of ofVar, int i, String str2, boolean z) {
        try {
            Intent intentPr = pr(context, str, ofVar, i, null, str2, false);
            intentPr.putExtra("web_dl_factors", z);
            return com.byazt.ca.pr.pr(context, intentPr, null);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean pr(Object obj) {
        if (obj == null || !(obj instanceof com.byazt.mm.pr.InterfaceC0136pr)) {
            return false;
        }
        try {
            return ((com.byazt.mm.pr.InterfaceC0136pr) obj).l_();
        } catch (Throwable th) {
            return false;
        }
    }

    private static Intent pr(Context context, String str, of ofVar, int i, Object obj, String str2, boolean z) {
        Class cls;
        boolean z2 = false;
        if (com.byazt.hg.lb.c(ofVar)) {
            cls = TTSevenScreenWebPageActivity.class;
        } else if (com.byazt.hg.lb.uc(ofVar) && ofVar != null && !ofVar.ww()) {
            cls = TTVideoWebPageActivity.class;
        } else if (com.byazt.ea.w.uc(ofVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.byazt.mr.aj) && of.hn(ofVar) && !pr(obj) && ls.zo(ofVar) && (ofVar == null || !ofVar.ww())) {
            cls = TTVideoWebPageActivity.class;
            z2 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z2) {
            pr(context, ofVar, obj, z, intent);
        }
        pr(context, str, ofVar, i, str2, intent);
        return intent;
    }

    private static void pr(Context context, of ofVar, Object obj, boolean z, Intent intent) {
        int i;
        com.byazt.mm.pr prVarK = null;
        if (obj != null) {
            prVarK = obj instanceof com.byazt.mm.pr.InterfaceC0136pr ? ((com.byazt.mm.pr.InterfaceC0136pr) obj).q_() : null;
            if (prVarK != null) {
                intent.putExtra("multi_process_data", prVarK.pr().toString());
            }
        }
        if ((obj instanceof com.byazt.qx.hw) && (prVarK = ((com.byazt.qx.hw) obj).k()) != null) {
            intent.putExtra("multi_process_data", prVarK.pr().toString());
        }
        if (prVarK != null) {
            intent.putExtra("video_is_auto_play", prVarK.x);
            prVarK.pr();
        }
        if (prVarK != null || z) {
            try {
                if (prVarK != null) {
                    i = (int) ((prVarK.fw / prVarK.c) * 100.0f);
                } else {
                    i = 100;
                    com.byazt.mm.pr prVar = new com.byazt.mm.pr();
                    prVar.fw = 100L;
                    prVar.pr = true;
                    prVar.x = ls.z(ofVar);
                    intent.putExtra("multi_process_data", prVar.pr().toString());
                }
                if (ofVar.xv() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else if (ofVar.xv() > 0 && i > ofVar.xv() && ls.z(ofVar)) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable th) {
            }
        }
    }

    private static void pr(Context context, String str, of ofVar, int i, String str2, Intent intent) {
        if (!new com.byazt.wr.hn(context, ofVar).x(false)) {
            ofVar.hn(true);
        }
        intent.putExtra(BreakpointSQLiteKey.URL, str);
        intent.putExtra("gecko_id", ofVar.hn());
        intent.putExtra(BundleKey.TITLE, ofVar.A_());
        intent.putExtra("sdk_version", iu.x);
        intent.putExtra(MediationConstant.EXTRA_ADID, ofVar.x());
        intent.putExtra("log_extra", ofVar.B_());
        intent.putExtra("icon_url", ofVar.mo() == null ? null : ofVar.mo().pr());
        intent.putExtra("event_tag", str2);
        intent.putExtra("landing_page_source", i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", ofVar.fw());
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        ls.pr(intent, ofVar);
    }

    public static boolean pr(Context context, of ofVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            pr(context, (String) null, ofVar, i, str, intent);
            if (of.hn(ofVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.byazt.ca.pr.pr(context, intent, null);
        } catch (Throwable th) {
            return false;
        }
    }
}
