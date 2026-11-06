package com.bytedance.sdk.openadsdk.core.activity.base;

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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.c;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.ab.ab;
import com.bytedance.sdk.openadsdk.core.widget.ah;
import com.bytedance.sdk.openadsdk.core.widget.ao;
import com.bytedance.sdk.openadsdk.core.widget.ch;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.hi;
import com.bytedance.sdk.openadsdk.core.widget.ka;
import com.bytedance.sdk.openadsdk.core.widget.ny;
import com.bytedance.sdk.openadsdk.core.widget.x;
import com.bytedance.sdk.openadsdk.core.widget.xr;
import com.bytedance.sdk.openadsdk.core.widget.zb;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private static ab ao;
    private static String h;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static lm f1894ms;
    private static String qv;
    private ka ab;
    private AlertDialog ah;
    private d c;
    private Activity ch;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms d;
    private ah hi;
    private ch ka;
    private x ny;
    private xr sl;
    private ny u;
    private ao ub;
    private Dialog x;
    private Intent xr;
    private hi zb;

    public static void ms(String str, String[] strArr) {
        Intent intent = new Intent(re.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (re.getContext() != null) {
            com.bytedance.sdk.component.utils.xr.ms(re.getContext(), intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.xr.ms
                public void ms() {
                }

                @Override // com.bytedance.sdk.component.utils.xr.ms
                public void ms(Throwable th) {
                    sl.xr("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    public static void ms(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 3);
        intentMs.putExtra("app_download_url", str);
        intentMs.putExtra("dialog_title", str2);
        intentMs.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    private static Intent ms(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        return intent;
    }

    public static void ms(ab abVar) {
        ao = abVar;
    }

    public static void ms(Context context, String str, String str2, String str3, ab abVar, lm lmVar) {
        try {
            f1894ms = lmVar;
            ao = abVar;
            if (context == null) {
                context = re.getContext();
            }
            Intent intentMs = ms(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentMs.putExtra("type", 7);
            intentMs.putExtra("app_download_url", str);
            intentMs.putExtra("dialog_app_manage_model", str2);
            if (lmVar != null) {
                intentMs.putExtra("event_adId", lmVar.df());
                intentMs.putExtra("event_extInfo", lmVar.lx());
                intentMs.putExtra("event_TAG", f.xr(lmVar));
            }
            intentMs.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentMs.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentMs.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentMs.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public static void ms(Context context, String str, String str2, String str3, lm lmVar) {
        if (context == null) {
            try {
                context = re.getContext();
            } catch (Exception e) {
                sl.ms(e);
                return;
            }
        }
        Intent intentMs = ms(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentMs.putExtra("type", 7);
        intentMs.putExtra("app_download_url", str);
        intentMs.putExtra("dialog_app_manage_model", str2);
        if (lmVar != null) {
            intentMs.putExtra("event_adId", lmVar.df());
            intentMs.putExtra("event_extInfo", lmVar.lx());
            intentMs.putExtra("event_TAG", f.xr(lmVar));
        }
        intentMs.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentMs.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentMs.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentMs.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void ms(Context context, String str, String str2) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 8);
        intentMs.putExtra("app_download_url", str);
        intentMs.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void ms(Context context, String str) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 10);
        intentMs.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void xr(Context context, String str, String str2) {
        if (context == null) {
            context = re.getContext();
        }
        c cVarD = d(str2);
        if (cVarD == null) {
            return;
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 9);
        intentMs.putExtra("dialog_app_privacy_url", cVarD.x());
        intentMs.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void ms(Context context, String str, String str2, lm lmVar) {
        if (context == null) {
            context = re.getContext();
        }
        c cVarD = d(str2);
        if (cVarD == null) {
            return;
        }
        if (lmVar != null) {
            xr(f.xr(lmVar), lmVar.lx(), lmVar.df());
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 16);
        intentMs.putExtra("dialog_app_registration_url", cVarD.hi());
        intentMs.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(str, "click_other", str3, str2, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TTDownloadField.TT_REFER, "reg");
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void ah(Context context, String str, String str2) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 14);
        intentMs.putExtra("dialog_app_desc_url", str2);
        intentMs.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 12);
        intentMs.putExtra("web_url", str);
        intentMs.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void ms(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 5);
        intentMs.putExtra("app_download_url", str);
        intentMs.putExtra("dialog_title", str2);
        intentMs.putExtra("dialog_content_key", str3);
        intentMs.putExtra("dialog_btn_yes_key", str4);
        intentMs.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    public static void ms(Context context, lm lmVar) {
        JSONObject jSONObjectRm;
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 6);
        if (lmVar != null && (jSONObjectRm = lmVar.rm()) != null) {
            intentMs.putExtra("materialmeta", jSONObjectRm.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentMs);
            } catch (Throwable unused) {
            }
        }
    }

    public static void xr(Context context, String str) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 11);
        intentMs.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    private void xr() {
        try {
            if (this.u == null) {
                this.u = new ny(this.ch, getIntent());
            }
            if (this.u.isShowing()) {
                this.u.dismiss();
            }
            this.u.ms(new ny.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.ny.ms
                public void ms(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.u.show();
        } catch (Throwable unused) {
        }
    }

    private void ah() {
        if (com.bytedance.sdk.openadsdk.core.ch.ub().sa()) {
            if (this.hi == null && this.ny == null && this.zb == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ch.ub().ny(false);
            finish();
        }
    }

    public void ms(String str) {
        if (this.ub == null) {
            this.ub = new ao(this.ch, str);
        }
        if (this.ub.isShowing()) {
            this.ub.dismiss();
        }
        this.ub.ms(new ao.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.ao.ms
            public void ms(String str2) {
                com.bytedance.sdk.openadsdk.core.jw.c.xr(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ao.ms
            public void xr(String str2) {
                com.bytedance.sdk.openadsdk.core.jw.c.d(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.ub.show();
    }

    public static void ms(Context context, String str, boolean z) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 15);
        if (!z) {
            intentMs.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        x xVar = this.ny;
        if (xVar != null) {
            h = xVar.ms();
        }
        ah ahVar = this.hi;
        if (ahVar != null) {
            qv = ahVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        ah();
    }

    public static void ms(Context context, String str, lm lmVar) {
        if (context == null) {
            context = re.getContext();
        }
        Intent intentMs = ms(context);
        intentMs.putExtra("type", 13);
        f1894ms = lmVar;
        intentMs.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.xr.ms(context, intentMs, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ch = this;
        d();
        this.xr = getIntent();
        if (re.getContext() == null) {
            re.ms(this.ch);
        }
    }

    private void d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (re.getContext() == null) {
            re.ms(this.ch);
        }
        try {
            setIntent(intent);
            this.xr = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            ka();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            f1894ms = null;
            AlertDialog alertDialog = this.ah;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.ah.dismiss();
            }
            x xVar = this.ny;
            if (xVar != null && xVar.isShowing()) {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(this.ny.ms());
                if (this.ny.isShowing()) {
                    this.ny.dismiss();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(h);
            }
            d dVar = this.c;
            if (dVar != null && dVar.isShowing()) {
                this.c.dismiss();
            }
            ah ahVar = this.hi;
            if (ahVar != null) {
                if (ahVar.isShowing()) {
                    this.hi.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.jw.c.ms(this.hi.d());
            } else {
                com.bytedance.sdk.openadsdk.core.jw.c.ms(qv);
            }
            xr xrVar = this.sl;
            if (xrVar != null && xrVar.isShowing()) {
                this.sl.dismiss();
            }
            ka kaVar = this.ab;
            if (kaVar != null && kaVar.isShowing()) {
                this.ab.dismiss();
            }
            hi hiVar = this.zb;
            if (hiVar != null && hiVar.isShowing()) {
                this.zb.dismiss();
            }
            Dialog dialog = this.x;
            if (dialog != null && dialog.isShowing()) {
                this.x.dismiss();
            }
            h = null;
            qv = null;
        } catch (Throwable th) {
            sl.ah("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ah ahVar = this.hi;
        if (ahVar == null || ahVar.isShowing()) {
            return;
        }
        this.hi.ms();
    }

    private void ka() {
        try {
            Intent intent = this.xr;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.xr.getStringExtra("app_download_url");
            this.xr.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    ah(stringExtra, this.xr.getStringExtra("dialog_title"), this.xr.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    xr(this.xr.getStringExtra("permission_id_key"), this.xr.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    xr(stringExtra, this.xr.getStringExtra("dialog_title"), this.xr.getStringExtra("dialog_content_key"), this.xr.getStringExtra("dialog_btn_yes_key"), this.xr.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    c(this.xr.getStringExtra("materialmeta"));
                    break;
                case 7:
                    ah(stringExtra);
                    break;
                case 8:
                    ms(this.xr.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    ah(this.xr.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    xr(this.xr.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    ka(this.xr.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    xr(this.xr.getStringExtra("web_url"), this.xr.getStringExtra("web_title"));
                    break;
                case 13:
                    xr();
                    break;
                case 14:
                    ms(this.xr.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    ms(this.xr.getStringExtra("web_url"));
                    break;
                case 16:
                    ms(this.xr.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void xr(String str) {
        try {
            if (ul.ny(this.ch)) {
                Dialog dialog = this.x;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.ms msVar = new com.bytedance.sdk.openadsdk.core.widget.ms(this.ch, str);
                    this.x = msVar;
                    msVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.x.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void ah(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strHi;
        String str8;
        String str9;
        float fAh;
        String str10;
        Intent intent = this.xr;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.xr.getStringExtra("event_adId");
        final String stringExtra3 = this.xr.getStringExtra("event_TAG");
        String stringExtra4 = this.xr.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.xr.getStringExtra("dialog_title");
        final String stringExtra6 = this.xr.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.xr.getStringExtra("dialog_app_description");
        boolean z = false;
        boolean booleanExtra = this.xr.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String strOptString = "";
            float f = 0.0f;
            if (TextUtils.isEmpty(stringExtra4)) {
                str2 = stringExtra4;
                jSONArray = null;
                str3 = null;
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(jSONObject);
                if (cVarKa != null) {
                    String strKa = cVarKa.ka();
                    String strAb = cVarKa.ab();
                    String strCh = cVarKa.ch();
                    String strU = cVarKa.u();
                    if (!TextUtils.isEmpty(strU)) {
                        stringExtra5 = strU;
                    }
                    JSONArray jSONArrayD = cVarKa.d();
                    fAh = cVarKa.ah();
                    strHi = cVarKa.hi();
                    strOptString = stringExtra5;
                    str8 = strKa;
                    str10 = strAb;
                    jSONArray2 = jSONArrayD;
                    str9 = strCh;
                } else {
                    strHi = null;
                    str8 = "";
                    str9 = str8;
                    fAh = 0.0f;
                    str10 = str9;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put("app_name", strOptString);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put(BundleKey.DESCRIPTION, stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z = true;
                }
                str2 = stringExtra4;
                str6 = strOptString;
                str3 = strHi;
                str7 = str9;
                str4 = str8;
                strOptString = jSONObject.optString("hand_icon_url");
                jSONArray = jSONArray2;
                float f2 = fAh;
                str5 = str10;
                f = f2;
            }
            if (booleanExtra) {
                ms(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            if (z) {
                final String str11 = str2;
                final float f3 = f;
                final String str12 = strOptString;
                final JSONArray jSONArray3 = jSONArray;
                final String str13 = str4;
                final String str14 = str5;
                final String str15 = str6;
                final String str16 = str7;
                final String str17 = str3;
                ms(str, str2, new ab() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
                    public void ms(int i, String str18) {
                        TTDelegateActivity.this.ms(str, str11, stringExtra6, f3, stringExtra7, str12, jSONArray3, str13, str14, str15, str16, str17, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.ny != null) {
                            TTDelegateActivity.this.ny.ms((ab) null);
                        }
                        if (TTDelegateActivity.ao != null) {
                            TTDelegateActivity.ao.ms(i, str18);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
                    public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                        if (TTDelegateActivity.ao != null) {
                            TTDelegateActivity.ao.ms(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            ms(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable unused) {
        }
    }

    private static c d(String str) {
        try {
            return com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    private void ms(String str, String str2, ab abVar, String str3, String str4, String str5) {
        if (ul.ny(this.ch)) {
            if (TextUtils.isEmpty(str2)) {
                abVar.ms(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                ah ahVar = this.hi;
                if (ahVar == null || !ahVar.isShowing()) {
                    ah ahVarNy = new zb(this.ch, jSONObject, abVar).ny(str);
                    this.hi = ahVarNy;
                    ((zb) ahVarNy).xr(ms(str, str2, str3, str4, str5));
                    this.hi.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void ms(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        ms(str, str2, str7, f, new ab() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str13) {
                TTDelegateActivity.this.ms(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.ny != null) {
                    TTDelegateActivity.this.ny.ms((ab) null);
                }
                if (TTDelegateActivity.ao != null) {
                    TTDelegateActivity.ao.ms(i, str13);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                if (TTDelegateActivity.ao != null) {
                    TTDelegateActivity.ao.ms(null);
                }
            }
        }, str10, str11, str12);
    }

    private void ms(final String str, final String str2, String str3, float f, ab abVar, final String str4, final String str5, final String str6) {
        if (ul.ny(this.ch)) {
            if (TextUtils.isEmpty(str2)) {
                abVar.ms(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f);
                JSONObject jSONObjectXr = com.bytedance.sdk.openadsdk.core.ugeno.ch.xr(jSONObject.getString("ugen_dialog_md5"), jSONObject.getString("ugen_dialog_url"));
                if (jSONObjectXr == null) {
                    abVar.ms(8, "uegnTemplate is empty");
                    return;
                }
                x xVar = this.ny;
                if (xVar == null || !xVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    x xVar2 = new x(str, this.ch, jSONObjectXr, jSONObject2, abVar, f1894ms);
                    this.ny = xVar2;
                    xVar2.ms(new com.bytedance.sdk.openadsdk.core.widget.ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // com.bytedance.sdk.openadsdk.core.widget.ab.ms
                        public void ms(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.jw.c.xr(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ab.ms
                        public void xr(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.ms(str2, str, false, (Dialog) tTDelegateActivity.ny);
                            if (TTDelegateActivity.this.ny != null) {
                                TTDelegateActivity.this.ny.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ab.ms
                        public void ah(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.jw.c.d(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ab.ms
                        public void d(Dialog dialog) {
                            try {
                                c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(str2));
                                if (cVarKa != null) {
                                    TTDelegateActivity.this.ms(cVarKa.x(), str, 2, false, (Dialog) TTDelegateActivity.this.ny);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.ny != null) {
                                TTDelegateActivity.this.ny.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ab.ms
                        public void ms() {
                            try {
                                c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(str2));
                                if (cVarKa != null) {
                                    TTDelegateActivity.this.ms(cVarKa.ny(), str, 1, false, (Dialog) TTDelegateActivity.this.ny);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.ny != null) {
                                TTDelegateActivity.this.ny.hide();
                            }
                        }
                    });
                    this.ny.show();
                }
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (ul.ny(this.ch)) {
            ah ahVar = this.hi;
            if (ahVar == null || !ahVar.isShowing()) {
                ah ahVarMs = new ah(this.ch).ms(str8).ka(str6).c(str9).xr(str3).x(str7).ny(str).ah(str5).ms(f).ms(jSONArray).ab(str10).d(str4).ms(ms(str, str2, str11, str12, str13));
                this.hi = ahVarMs;
                ahVarMs.show();
            }
        }
    }

    private ah.ms ms(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void ms(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.jw.c.xr(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void xr(Dialog dialog) {
                TTDelegateActivity.this.ms(str2, str, false, (Dialog) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void ah(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.jw.c.d(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void d(Dialog dialog) {
                try {
                    c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(str2));
                    if (cVarKa != null) {
                        TTDelegateActivity.this.ms(cVarKa.x(), str, 2, false, (Dialog) null);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void ka(Dialog dialog) {
                try {
                    c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(str2));
                    if (cVarKa == null) {
                        return;
                    }
                    TTDelegateActivity.this.ms(cVarKa.ny(), str, 1, false, (Dialog) null);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ah.ms
            public void c(Dialog dialog) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    TTDelegateActivity.xr(str4, str5, str3);
                    c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(jSONObject);
                    if (cVarKa == null) {
                        return;
                    }
                    TTDelegateActivity.this.ms(cVarKa.hi(), str, 3, false, (Dialog) null);
                } catch (Exception unused) {
                }
            }
        };
    }

    private void ms(String str, String str2) {
        if (this.xr == null) {
            return;
        }
        ms(str, str2, true, (Dialog) null);
    }

    private void xr(String str, String str2) {
        try {
            if (ul.ny(this.ch)) {
                d dVar = this.c;
                if (dVar != null) {
                    dVar.dismiss();
                }
                d dVar2 = new d(this.ch, str, str2);
                this.c = dVar2;
                dVar2.ms(new d.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.d.ms
                    public void ms(Dialog dialog) {
                        if (TTDelegateActivity.this.c != null) {
                            TTDelegateActivity.this.c.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.c.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (ul.ny(this.ch)) {
                ka kaVar = this.ab;
                if (kaVar != null) {
                    kaVar.dismiss();
                }
                if (i == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                ka kaVar2 = new ka(this.ch, str, str3, str4);
                this.ab = kaVar2;
                kaVar2.ms(new ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.ka.ms
                    public void ms(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.jw.c.xr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.ka.ms
                    public void xr(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.jw.c.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.ka.ms
                    public void ah(Dialog dialog2) {
                        if (TTDelegateActivity.this.ab != null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.core.jw.c.d(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.ab.dismiss();
                            }
                        }
                    }
                });
                this.ab.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void ah(String str, String str2) {
        if (this.xr == null) {
            return;
        }
        ms(str, str2, 2, true, (Dialog) null);
    }

    private void ka(String str) {
        try {
            if (ul.ny(this.ch)) {
                hi hiVar = this.zb;
                if (hiVar != null) {
                    hiVar.dismiss();
                }
                hi hiVar2 = new hi(this.ch, str);
                this.zb = hiVar2;
                hiVar2.ms(new hi.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.hi.ms
                    public void ms(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.zb.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (ul.ny(this.ch)) {
                xr xrVar = this.sl;
                if (xrVar != null) {
                    xrVar.dismiss();
                }
                xr xrVar2 = new xr(this.ch, str);
                this.sl = xrVar2;
                xrVar2.ms(new xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.xr.ms
                    public void ms(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.jw.c.xr(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xr.ms
                    public void xr(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.jw.c.d(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xr.ms
                    public void ah(Dialog dialog2) {
                        if (TTDelegateActivity.this.sl != null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.core.jw.c.d(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.sl.dismiss();
                            }
                        }
                    }
                });
                this.sl.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        if (ul.ny(this.ch)) {
            if (str != null && this.d == null) {
                try {
                    lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(str));
                    if (lmVarMs != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(this.ch, lmVarMs.ca(), false);
                        this.d = msVar;
                        msVar.ms(new com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                            public void ms() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                            public void ms(int i, String str2, boolean z) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                            public void xr() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                        com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.ch, this.d, lmVarMs);
                    }
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar2 = this.d;
            if (msVar2 != null) {
                msVar2.ms();
            }
        }
    }

    private void xr(final String str, String str2, String str3, String str4, String str5) {
        if (ul.ny(this.ch)) {
            AlertDialog alertDialog = this.ah;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.ka == null) {
                this.ka = new ch(this.ch).ms(str2).xr(str3).ah(str4).d(str5).ms(new ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.ch.ms
                    public void ms(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.jw.c.xr(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.ch.ms
                    public void xr(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.jw.c.ah(str);
                        TTDelegateActivity.this.finish();
                    }
                }).ms(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        com.bytedance.sdk.openadsdk.core.jw.c.d(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.ka.isShowing()) {
                this.ka.show();
            }
            this.ah = this.ka;
        }
    }

    private void xr(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(this.ch, strArr, new com.bytedance.sdk.openadsdk.core.i.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.i.c
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.jw.ab.ms(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.i.c
                public void ms(String str2) {
                    com.bytedance.sdk.openadsdk.core.jw.ab.ms(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void ah(final String str, String str2, String str3) {
        if (ul.ny(this.ch)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = t.ms(this.ch, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            ms(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.bytedance.sdk.openadsdk.core.jw.c.xr(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.bytedance.sdk.openadsdk.core.jw.c.ah(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.bytedance.sdk.openadsdk.core.jw.c.d(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void c() {
        ApplicationInfo applicationInfo;
        try {
            com.bytedance.sdk.openadsdk.core.f.ka kaVarQv = com.bytedance.sdk.openadsdk.core.ch.ub().qv();
            boolean zAh = kaVarQv.ah();
            boolean zKa = kaVarQv.ka();
            ArrayList arrayList = new ArrayList();
            com.bytedance.sdk.openadsdk.ub.xr.ms(kaVarQv, arrayList);
            if (zAh) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            if (zKa) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            Context context = re.getContext();
            if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                arrayList.add("android.permission.POST_NOTIFICATIONS");
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(this.ch, strArr, new com.bytedance.sdk.openadsdk.core.i.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                @Override // com.bytedance.sdk.openadsdk.core.i.c
                public void ms() {
                    com.bytedance.sdk.component.ch.ab.ms(new ms("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.i.c
                public void ms(String str) {
                    "android.permission.READ_PHONE_STATE".equals(str);
                    com.bytedance.sdk.component.ch.ab.ms(new ms("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void ms(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.ah == null) {
                this.ah = new AlertDialog.Builder(this.ch, t.ab(this.ch, "Theme.Dialog.TTDownload")).create();
            }
            this.ah.setTitle(String.valueOf(str));
            this.ah.setMessage(String.valueOf(str2));
            this.ah.setButton(-1, t.ms(this.ch, "tt_label_ok"), onClickListener);
            this.ah.setButton(-2, t.ms(this.ch, "tt_label_cancel"), onClickListener2);
            this.ah.setOnCancelListener(onCancelListener);
            if (this.ah.isShowing()) {
                return;
            }
            this.ah.show();
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public static class ms extends com.bytedance.sdk.component.ch.ny {
        public ms(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            ITTDownloadVisitor iTTDownloadVisitorMs = com.bytedance.sdk.openadsdk.core.hi.ms.ms.ms();
            if (iTTDownloadVisitorMs != null) {
                Bridge bridgeUl = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
                if (bridgeUl != null) {
                    iTTDownloadVisitorMs.initPath(bridgeUl.values().booleanValue(1));
                }
                com.bytedance.sdk.openadsdk.core.t.u();
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(this.ch, strArr, iArr);
        com.bytedance.sdk.component.ch.ab.ms(new ms("onRequestPermissionsResult"), 1);
        finish();
    }
}
