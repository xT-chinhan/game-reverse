package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.ca.ho;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.hg.uc;
import com.byazt.nc.aj;
import com.byazt.nc.c;
import com.byazt.nc.hn;
import com.byazt.nc.hw;
import com.byazt.nc.m;
import com.byazt.nc.nt;
import com.byazt.nc.vk;
import com.byazt.nc.w;
import com.byazt.nc.x;
import com.byazt.nc.zo;
import com.byazt.sa.fw;
import com.byazt.sd.a;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private static String lb;
    private static fw nt;
    public static of pr = null;
    private static String yb;
    private zo aj;
    private vk c;
    private c fw;
    private aj g;
    private AlertDialog hn;
    private nt ho;
    private Intent hw;
    private hw k;
    private w m;
    private x uc;
    private Activity vk;
    private hn w;
    private com.byazt.pfl.hw x;
    private Dialog zo;

    public static void pr(String str, String[] strArr) {
        Intent intent = new Intent(a.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (a.getContext() != null) {
            com.byazt.ca.pr.pr(a.getContext(), intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.byazt.ca.pr.InterfaceC0030pr
                public void pr() {
                }

                @Override // com.byazt.ca.pr.InterfaceC0030pr
                public void pr(Throwable th) {
                    ho.pr("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    public static void pr(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 3);
        intentPr.putExtra("app_download_url", str);
        intentPr.putExtra("dialog_title", str2);
        intentPr.putExtra("dialog_content_key", str3);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    private static Intent pr(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        return intent;
    }

    public static void pr(fw fwVar) {
        nt = fwVar;
    }

    public static void pr(Context context, String str, String str2, String str3, fw fwVar, of ofVar) {
        try {
            pr = ofVar;
            nt = fwVar;
            if (context == null) {
                context = a.getContext();
            }
            Intent intentPr = pr(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentPr.putExtra("type", 7);
            intentPr.putExtra("app_download_url", str);
            intentPr.putExtra("dialog_app_manage_model", str2);
            if (ofVar != null) {
                intentPr.putExtra("event_adId", ofVar.x());
                intentPr.putExtra("event_extInfo", ofVar.B_());
                intentPr.putExtra("event_TAG", ls.hw(ofVar));
            }
            intentPr.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentPr.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentPr.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentPr.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.byazt.ca.pr.pr(context, intentPr, null);
        } catch (Exception e) {
        }
    }

    public static void pr(Context context, String str, String str2, String str3, of ofVar) {
        if (context == null) {
            try {
                context = a.getContext();
            } catch (Exception e) {
                return;
            }
        }
        Intent intentPr = pr(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentPr.putExtra("type", 7);
        intentPr.putExtra("app_download_url", str);
        intentPr.putExtra("dialog_app_manage_model", str2);
        if (ofVar != null) {
            intentPr.putExtra("event_adId", ofVar.x());
            intentPr.putExtra("event_extInfo", ofVar.B_());
            intentPr.putExtra("event_TAG", ls.hw(ofVar));
        }
        intentPr.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentPr.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentPr.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentPr.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void pr(Context context, String str, String str2) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 8);
        intentPr.putExtra("app_download_url", str);
        intentPr.putExtra("dialog_app_manage_model", str2);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void pr(Context context, String str) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 10);
        intentPr.putExtra("dialog_content_key", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void hw(Context context, String str, String str2) {
        if (context == null) {
            context = a.getContext();
        }
        uc ucVarPr = com.byazt.ri.c.pr(str2);
        if (ucVarPr == null) {
            return;
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 9);
        intentPr.putExtra("dialog_app_privacy_url", ucVarPr.zo());
        intentPr.putExtra("app_download_url", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void pr(Context context, String str, String str2, of ofVar) {
        if (context == null) {
            context = a.getContext();
        }
        uc ucVarPr = com.byazt.ri.c.pr(str2);
        if (ucVarPr == null) {
            return;
        }
        if (ofVar != null) {
            hw(ls.hw(ofVar), ofVar.B_(), ofVar.x());
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 16);
        intentPr.putExtra("dialog_app_registration_url", ucVarPr.w());
        intentPr.putExtra("app_download_url", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.pj.pr.pr(str, "click_other", str3, str2, new com.byazt.ttf.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    public static void hn(Context context, String str, String str2) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 14);
        intentPr.putExtra("dialog_app_desc_url", str2);
        intentPr.putExtra("app_download_url", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void x(Context context, String str, String str2) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 12);
        intentPr.putExtra("web_url", str);
        intentPr.putExtra("web_title", str2);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void pr(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 5);
        intentPr.putExtra("app_download_url", str);
        intentPr.putExtra("dialog_title", str2);
        intentPr.putExtra("dialog_content_key", str3);
        intentPr.putExtra("dialog_btn_yes_key", str4);
        intentPr.putExtra("dialog_btn_no_key", str5);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    public static void pr(Context context, of ofVar) {
        JSONObject jSONObject;
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 6);
        if (ofVar != null && (jSONObject = ofVar.to()) != null) {
            intentPr.putExtra("materialmeta", jSONObject.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentPr);
            } catch (Throwable th) {
            }
        }
    }

    public static void hw(Context context, String str) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 11);
        intentPr.putExtra("dialog_app_ad_info", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    private void hw() {
        try {
            if (this.g == null) {
                this.g = new aj(this.vk, getIntent());
            }
            if (this.g.isShowing()) {
                this.g.dismiss();
            }
            this.g.pr(new aj.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.byazt.nc.aj.pr
                public void pr(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.g.show();
        } catch (Throwable th) {
        }
    }

    private void hn() {
        if (!com.byazt.sd.zo.nt().o()) {
            return;
        }
        if (this.w != null || this.aj != null || this.m != null) {
            com.byazt.sd.zo.nt().zo(false);
            finish();
        }
    }

    public void pr(String str) {
        if (this.ho == null) {
            this.ho = new nt(this.vk, str);
        }
        if (this.ho.isShowing()) {
            this.ho.dismiss();
        }
        this.ho.pr(new nt.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.byazt.nc.nt.pr
            public void pr(String str2) {
                com.byazt.wt.c.hw(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.nc.nt.pr
            public void hw(String str2) {
                com.byazt.wt.c.x(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.ho.show();
    }

    public static void pr(Context context, String str, boolean z) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 15);
        if (!z) {
            intentPr.putExtra("web_url", str);
        }
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        zo zoVar = this.aj;
        if (zoVar != null) {
            yb = zoVar.pr();
        }
        hn hnVar = this.w;
        if (hnVar != null) {
            lb = hnVar.x();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        hn();
    }

    public static void pr(Context context, String str, of ofVar) {
        if (context == null) {
            context = a.getContext();
        }
        Intent intentPr = pr(context);
        intentPr.putExtra("type", 13);
        pr = ofVar;
        intentPr.putExtra("event_tag", str);
        com.byazt.ca.pr.pr(context, intentPr, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vk = this;
        x();
        this.hw = getIntent();
        if (a.getContext() == null) {
            a.pr(this.vk);
        }
    }

    private void x() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (a.getContext() == null) {
            a.pr(this.vk);
        }
        try {
            setIntent(intent);
            this.hw = intent;
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            c();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            pr = null;
            AlertDialog alertDialog = this.hn;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.hn.dismiss();
            }
            zo zoVar = this.aj;
            if (zoVar != null && zoVar.isShowing()) {
                com.byazt.wt.c.pr(this.aj.pr());
                if (this.aj.isShowing()) {
                    this.aj.dismiss();
                }
            } else {
                com.byazt.wt.c.pr(yb);
            }
            x xVar = this.uc;
            if (xVar != null && xVar.isShowing()) {
                this.uc.dismiss();
            }
            hn hnVar = this.w;
            if (hnVar != null) {
                if (hnVar.isShowing()) {
                    this.w.dismiss();
                }
                com.byazt.wt.c.pr(this.w.x());
            } else {
                com.byazt.wt.c.pr(lb);
            }
            hw hwVar = this.k;
            if (hwVar != null && hwVar.isShowing()) {
                this.k.dismiss();
            }
            c cVar = this.fw;
            if (cVar != null && cVar.isShowing()) {
                this.fw.dismiss();
            }
            w wVar = this.m;
            if (wVar != null && wVar.isShowing()) {
                this.m.dismiss();
            }
            Dialog dialog = this.zo;
            if (dialog != null && dialog.isShowing()) {
                this.zo.dismiss();
            }
            yb = null;
            lb = null;
        } catch (Throwable th) {
            ho.pr("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hn hnVar = this.w;
        if (hnVar == null || hnVar.isShowing()) {
            return;
        }
        this.w.pr();
    }

    private void c() {
        try {
            Intent intent = this.hw;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.hw.getStringExtra("app_download_url");
            this.hw.getStringExtra(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    uc();
                    break;
                case 3:
                    hn(stringExtra, this.hw.getStringExtra("dialog_title"), this.hw.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    hw(this.hw.getStringExtra("permission_id_key"), this.hw.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    hw(stringExtra, this.hw.getStringExtra("dialog_title"), this.hw.getStringExtra("dialog_content_key"), this.hw.getStringExtra("dialog_btn_yes_key"), this.hw.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    c(this.hw.getStringExtra("materialmeta"));
                    break;
                case 7:
                    hn(stringExtra);
                    break;
                case 8:
                    pr(this.hw.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    hn(this.hw.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    hw(this.hw.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    x(this.hw.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    hw(this.hw.getStringExtra("web_url"), this.hw.getStringExtra("web_title"));
                    break;
                case 13:
                    hw();
                    break;
                case 14:
                    pr(this.hw.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    pr(this.hw.getStringExtra("web_url"));
                    break;
                case 16:
                    pr(this.hw.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception e) {
            finish();
        }
    }

    private void hw(String str) {
        try {
            if (!er.aj(this.vk)) {
                return;
            }
            Dialog dialog = this.zo;
            if (dialog != null && dialog.isShowing()) {
                return;
            }
            com.byazt.nc.pr prVar = new com.byazt.nc.pr(this.vk, str);
            this.zo = prVar;
            prVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.zo.show();
        } catch (Throwable th) {
        }
    }

    private void hn(final String str) {
        String str2;
        String str3;
        final String strOptString;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        float f;
        String strW;
        String str8;
        String str9;
        Intent intent = this.hw;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.hw.getStringExtra("event_adId");
        final String stringExtra3 = this.hw.getStringExtra("event_TAG");
        String stringExtra4 = this.hw.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.hw.getStringExtra("dialog_title");
        final String stringExtra6 = this.hw.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.hw.getStringExtra("dialog_app_description");
        boolean booleanExtra = this.hw.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        float f2 = 0.0f;
        try {
            final JSONArray jSONArray = null;
            String str10 = "";
            if (TextUtils.isEmpty(stringExtra4)) {
                str2 = stringExtra4;
                str3 = null;
                strOptString = "";
                str4 = strOptString;
                str5 = str4;
                str6 = str5;
                str7 = str6;
                z = false;
                f = 0.0f;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                uc ucVarPr = com.byazt.ri.c.pr(stringExtra4);
                if (ucVarPr == null) {
                    strW = null;
                    str8 = "";
                    str5 = str8;
                    str9 = str5;
                } else {
                    String strC = ucVarPr.c();
                    String strFw = ucVarPr.fw();
                    String strVk = ucVarPr.vk();
                    String strG = ucVarPr.g();
                    if (!TextUtils.isEmpty(strG)) {
                        stringExtra5 = strG;
                    }
                    JSONArray jSONArrayX = ucVarPr.x();
                    float fHn = ucVarPr.hn();
                    strW = ucVarPr.w();
                    str10 = stringExtra5;
                    str8 = strC;
                    str5 = strFw;
                    f2 = fHn;
                    str9 = strVk;
                    jSONArray = jSONArrayX;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str10);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put(BundleKey.DESCRIPTION, stringExtra7);
                    z = true;
                    stringExtra4 = jSONObject.toString();
                } else {
                    z = false;
                }
                strOptString = jSONObject.optString("hand_icon_url");
                str2 = stringExtra4;
                str3 = strW;
                str7 = str9;
                str4 = str8;
                str6 = str10;
                f = f2;
            }
            if (booleanExtra) {
                pr(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            if (z) {
                final String str11 = str2;
                final float f3 = f;
                final String str12 = str4;
                final String str13 = str5;
                final String str14 = str6;
                final String str15 = str7;
                final String str16 = str3;
                pr(str, str2, new fw() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.byazt.sa.fw
                    public void pr(int i, String str17) {
                        TTDelegateActivity.this.pr(str, str11, stringExtra6, f3, stringExtra7, strOptString, jSONArray, str12, str13, str14, str15, str16, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.aj != null) {
                            TTDelegateActivity.this.aj.pr((fw) null);
                        }
                        if (TTDelegateActivity.nt != null) {
                            TTDelegateActivity.nt.pr(i, str17);
                        }
                    }

                    @Override // com.byazt.sa.fw
                    public void pr(com.byazt.ik.hn<View> hnVar) {
                        if (TTDelegateActivity.nt != null) {
                            TTDelegateActivity.nt.pr(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            pr(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable th) {
        }
    }

    private void pr(String str, String str2, fw fwVar, String str3, String str4, String str5) {
        if (!er.aj(this.vk)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            fwVar.pr(7, "uegnData is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            hn hnVar = this.w;
            if (hnVar != null && hnVar.isShowing()) {
                return;
            }
            hn hnVarAj = new m(this.vk, jSONObject, fwVar).aj(str);
            this.w = hnVarAj;
            ((m) hnVarAj).hw(pr(str, str2, str3, str4, str5));
            this.w.show();
        } catch (Exception e) {
        }
    }

    private void pr(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        pr(str, str2, str7, f, new fw() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.byazt.sa.fw
            public void pr(int i, String str13) {
                TTDelegateActivity.this.pr(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.aj != null) {
                    TTDelegateActivity.this.aj.pr((fw) null);
                }
                if (TTDelegateActivity.nt != null) {
                    TTDelegateActivity.nt.pr(i, str13);
                }
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                if (TTDelegateActivity.nt != null) {
                    TTDelegateActivity.nt.pr(null);
                }
            }
        }, str10, str11, str12);
    }

    private void pr(final String str, final String str2, String str3, float f, fw fwVar, final String str4, final String str5, final String str6) {
        if (!er.aj(this.vk)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            fwVar.pr(7, "uegnData is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str3);
            }
            jSONObject.put("score", f);
            JSONObject jSONObjectPr = com.byazt.ea.w.pr(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.byazt.ea.hn) null);
            if (jSONObjectPr == null) {
                fwVar.pr(8, "uegnTemplate is empty");
                return;
            }
            zo zoVar = this.aj;
            if (zoVar != null && zoVar.isShowing()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("easy_dl_dialog", jSONObject);
            zo zoVar2 = new zo(str, this.vk, jSONObjectPr, jSONObject2, fwVar, pr);
            this.aj = zoVar2;
            zoVar2.pr(new com.byazt.nc.fw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                public uc fw = null;

                @Override // com.byazt.nc.fw.pr
                public void pr(Dialog dialog) {
                    com.byazt.wt.c.hw(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.fw.pr
                public void hw(Dialog dialog) {
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    tTDelegateActivity.pr(str2, str, false, (Dialog) tTDelegateActivity.aj);
                    if (TTDelegateActivity.this.aj != null) {
                        TTDelegateActivity.this.aj.hide();
                    }
                }

                @Override // com.byazt.nc.fw.pr
                public void hn(Dialog dialog) {
                    com.byazt.wt.c.x(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.fw.pr
                public void x(Dialog dialog) {
                    if (this.fw == null) {
                        this.fw = com.byazt.ri.c.pr(str2);
                    }
                    uc ucVar = this.fw;
                    if (ucVar != null) {
                        TTDelegateActivity.this.pr(ucVar.zo(), str, 2, false, (Dialog) TTDelegateActivity.this.aj);
                    }
                    if (TTDelegateActivity.this.aj != null) {
                        TTDelegateActivity.this.aj.hide();
                    }
                }

                @Override // com.byazt.nc.fw.pr
                public void pr() {
                    if (this.fw == null) {
                        this.fw = com.byazt.ri.c.pr(str2);
                    }
                    uc ucVar = this.fw;
                    if (ucVar != null) {
                        TTDelegateActivity.this.pr(ucVar.aj(), str, 1, false, (Dialog) TTDelegateActivity.this.aj);
                    }
                    if (TTDelegateActivity.this.aj != null) {
                        TTDelegateActivity.this.aj.hide();
                    }
                }
            });
            this.aj.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (!er.aj(this.vk)) {
            return;
        }
        hn hnVar = this.w;
        if (hnVar != null && hnVar.isShowing()) {
            return;
        }
        hn hnVarPr = new hn(this.vk).pr(str8).c(str6).uc(str9).hw(str3).zo(str7).aj(str).hn(str5).pr(f).pr(jSONArray).fw(str10).x(str4).pr(pr(str, str2, str11, str12, str13));
        this.w = hnVarPr;
        hnVarPr.show();
    }

    private hn.pr pr(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new hn.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            public uc fw = null;

            @Override // com.byazt.nc.hn.pr
            public void pr(Dialog dialog) {
                com.byazt.wt.c.hw(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.nc.hn.pr
            public void hw(Dialog dialog) {
                TTDelegateActivity.this.pr(str2, str, false, (Dialog) null);
            }

            @Override // com.byazt.nc.hn.pr
            public void hn(Dialog dialog) {
                com.byazt.wt.c.x(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.nc.hn.pr
            public void x(Dialog dialog) {
                if (this.fw == null) {
                    this.fw = com.byazt.ri.c.pr(str2);
                }
                uc ucVar = this.fw;
                if (ucVar != null) {
                    TTDelegateActivity.this.pr(ucVar.zo(), str, 2, false, (Dialog) null);
                }
            }

            @Override // com.byazt.nc.hn.pr
            public void c(Dialog dialog) {
                if (this.fw == null) {
                    this.fw = com.byazt.ri.c.pr(str2);
                }
                uc ucVar = this.fw;
                if (ucVar != null) {
                    TTDelegateActivity.this.pr(ucVar.aj(), str, 1, false, (Dialog) null);
                }
            }

            @Override // com.byazt.nc.hn.pr
            public void uc(Dialog dialog) {
                TTDelegateActivity.hw(str4, str5, str3);
                if (this.fw == null) {
                    this.fw = com.byazt.ri.c.pr(str2);
                }
                uc ucVar = this.fw;
                if (ucVar != null) {
                    TTDelegateActivity.this.pr(ucVar.w(), str, 3, false, (Dialog) null);
                }
            }
        };
    }

    private void pr(String str, String str2) {
        if (this.hw == null) {
            return;
        }
        pr(str, str2, true, (Dialog) null);
    }

    private void hw(String str, String str2) {
        try {
            if (!er.aj(this.vk)) {
                return;
            }
            x xVar = this.uc;
            if (xVar != null) {
                xVar.dismiss();
            }
            x xVar2 = new x(this.vk, str, str2);
            this.uc = xVar2;
            xVar2.pr(new x.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                @Override // com.byazt.nc.x.pr
                public void pr(Dialog dialog) {
                    if (TTDelegateActivity.this.uc != null) {
                        TTDelegateActivity.this.uc.dismiss();
                        TTDelegateActivity.this.finish();
                    }
                }
            });
            this.uc.show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        try {
            if (!er.aj(this.vk)) {
                return;
            }
            c cVar = this.fw;
            if (cVar != null) {
                cVar.dismiss();
            }
            String str4 = null;
            if (i == 1) {
                str4 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                str3 = "应用简介";
            } else if (i == 2) {
                str4 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                str3 = "隐私政策";
            } else if (i != 3) {
                str3 = null;
            } else {
                str3 = "备案信息";
            }
            c cVar2 = new c(this.vk, str, str4, str3);
            this.fw = cVar2;
            cVar2.pr(new c.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                @Override // com.byazt.nc.c.pr
                public void pr(Dialog dialog2) {
                    com.byazt.wt.c.hw(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.c.pr
                public void hw(Dialog dialog2) {
                    com.byazt.wt.c.x(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.c.pr
                public void hn(Dialog dialog2) {
                    if (TTDelegateActivity.this.fw != null) {
                        if (z) {
                            com.byazt.wt.c.x(str2);
                            TTDelegateActivity.this.finish();
                        } else {
                            Dialog dialog3 = dialog;
                            if (dialog3 != null) {
                                dialog3.show();
                            }
                            TTDelegateActivity.this.fw.dismiss();
                        }
                    }
                }
            });
            this.fw.show();
        } catch (Throwable th) {
        }
    }

    private void hn(String str, String str2) {
        if (this.hw == null) {
            return;
        }
        pr(str, str2, 2, true, (Dialog) null);
    }

    private void x(String str) {
        try {
            if (!er.aj(this.vk)) {
                return;
            }
            w wVar = this.m;
            if (wVar != null) {
                wVar.dismiss();
            }
            w wVar2 = new w(this.vk, str);
            this.m = wVar2;
            wVar2.pr(new w.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                @Override // com.byazt.nc.w.pr
                public void pr(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.m.show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (!er.aj(this.vk)) {
                return;
            }
            hw hwVar = this.k;
            if (hwVar != null) {
                hwVar.dismiss();
            }
            hw hwVar2 = new hw(this.vk, str);
            this.k = hwVar2;
            hwVar2.pr(new hw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                @Override // com.byazt.nc.hw.pr
                public void pr(Dialog dialog2) {
                    com.byazt.wt.c.hw(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.hw.pr
                public void hw(Dialog dialog2) {
                    com.byazt.wt.c.x(str2);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.hw.pr
                public void hn(Dialog dialog2) {
                    if (TTDelegateActivity.this.k != null) {
                        if (z) {
                            com.byazt.wt.c.x(str2);
                            TTDelegateActivity.this.finish();
                        } else {
                            Dialog dialog3 = dialog;
                            if (dialog3 != null) {
                                dialog3.show();
                            }
                            TTDelegateActivity.this.k.dismiss();
                        }
                    }
                }
            });
            this.k.show();
        } catch (Throwable th) {
        }
    }

    private void c(String str) {
        if (!er.aj(this.vk)) {
            return;
        }
        if (str != null && this.x == null) {
            try {
                of ofVarPr = com.byazt.sd.pr.pr(new JSONObject(str));
                if (ofVarPr != null) {
                    com.byazt.pfl.hw hwVar = new com.byazt.pfl.hw(this.vk, ofVarPr.ae(), false, com.byazt.ub.hw.pr());
                    this.x = hwVar;
                    com.byazt.pw.hn.pr(this.vk, ofVarPr, hwVar);
                    this.x.pr(new com.byazt.pfl.hw.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                        @Override // com.byazt.pfl.hw.pr
                        public void pr() {
                        }

                        @Override // com.byazt.pfl.hw.pr
                        public void pr(int i, String str2, boolean z) {
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.byazt.pfl.hw.pr
                        public void hw() {
                            TTDelegateActivity.this.finish();
                        }
                    });
                }
            } catch (JSONException e) {
            }
        }
        com.byazt.pfl.hw hwVar2 = this.x;
        if (hwVar2 != null) {
            hwVar2.pr();
        }
    }

    private void hw(final String str, String str2, String str3, String str4, String str5) {
        if (!er.aj(this.vk)) {
            return;
        }
        AlertDialog alertDialog = this.hn;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.c == null) {
            this.c = new vk(this.vk).pr(str2).hw(str3).hn(str4).x(str5).pr(new vk.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                @Override // com.byazt.nc.vk.pr
                public void pr(Dialog dialog) {
                    com.byazt.wt.c.hw(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.nc.vk.pr
                public void hw(Dialog dialog) {
                    com.byazt.wt.c.hn(str);
                    TTDelegateActivity.this.finish();
                }
            }).pr(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.byazt.wt.c.x(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
        if (!this.c.isShowing()) {
            this.c.show();
        }
        this.hn = this.c;
    }

    private void hw(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                com.byazt.qam.c.pr().pr(this.vk, strArr, new com.byazt.qam.uc() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                    @Override // com.byazt.qam.uc
                    public void pr() {
                        com.byazt.wt.uc.pr(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.qam.uc
                    public void pr(String str2) {
                        com.byazt.wt.uc.pr(str, str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception e) {
            }
        }
        finish();
    }

    private void hn(final String str, String str2, String str3) {
        if (!er.aj(this.vk)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "提示";
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        pr(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.byazt.wt.c.hw(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.byazt.wt.c.hn(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.byazt.wt.c.x(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void uc() {
        ApplicationInfo applicationInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                com.byazt.qe.x xVarA = com.byazt.sd.zo.nt().a();
                boolean zHn = xVarA.hn();
                boolean zC = xVarA.c();
                ArrayList arrayList = new ArrayList();
                com.byazt.igw.hw.pr(xVarA, arrayList);
                if (zHn) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                Context context = a.getContext();
                if (context != null && (applicationInfo = context.getApplicationInfo()) != null) {
                    if (applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                        arrayList.add("android.permission.POST_NOTIFICATIONS");
                    } else if (zC) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.byazt.qam.c.pr().pr(this.vk, strArr, new com.byazt.qam.uc() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                    @Override // com.byazt.qam.uc
                    public void pr() {
                        com.byazt.xlm.c.pr(new pr("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.qam.uc
                    public void pr(String str) {
                        "android.permission.READ_PHONE_STATE".equals(str);
                        com.byazt.xlm.c.pr(new pr("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception e) {
            }
        }
        finish();
    }

    private void pr(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.hn == null) {
                this.hn = new AlertDialog.Builder(this.vk, R.style.Theme.DeviceDefault.Light.Dialog).create();
            }
            Window window = this.hn.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                window.setAttributes(attributes);
            }
            this.hn.setTitle(String.valueOf(str));
            this.hn.setMessage(String.valueOf(str2));
            this.hn.setButton(-1, "确定", onClickListener);
            this.hn.setButton(-2, "取消", onClickListener2);
            this.hn.setOnCancelListener(onCancelListener);
            if (!this.hn.isShowing()) {
                this.hn.show();
            }
        } catch (Exception e) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 78, 79, 80, 304, 307, 524, 968})
    public static class pr extends com.byazt.xlm.fw {
        public pr(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.lm.x xVarX = com.byazt.lm.m.x();
            if (xVarX != null) {
                Function<SparseArray<Object>, Object> functionLs = com.byazt.sd.zo.nt().ls();
                if (functionLs != null) {
                    xVarX.pr(com.byazt.xi.pr.hw(functionLs).booleanValue(1));
                }
                ((g) com.byazt.zs.uc.pr("device_info_new")).c((Boolean) null);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.byazt.qam.c.pr().pr(this.vk, strArr, iArr);
        com.byazt.xlm.c.pr(new pr("onRequestPermissionsResult"), 1);
        finish();
    }
}
