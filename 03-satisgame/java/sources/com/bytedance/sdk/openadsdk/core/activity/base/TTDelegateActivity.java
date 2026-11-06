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
import com.anythink.china.b.c;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.mr.cp;
import com.byazt.mr.cy;
import com.byazt.mr.fs;
import com.byazt.mr.l;
import com.byazt.mr.oa;
import com.byazt.mr.q;
import com.byazt.mr.qg;
import com.byazt.mr.rv;
import com.byazt.mr.s;
import com.byazt.mr.tj;
import com.byazt.ms.ITTDownloadVisitor;
import com.byazt.ozc.x;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private static String cd;
    private static x cy;
    private static String hd;
    public static pk n;
    private s cp;
    private qg d;
    private Dialog fs;
    private cy k;
    private tj l;
    private cp oa;
    private com.byazt.wg.qg q;
    private Intent qg;
    private fs rv;
    private AlertDialog s;
    private rv sz;
    private Activity tj;
    private q w;
    private l x;

    public static void n(String str, String[] strArr) {
        Intent intent = new Intent(com.byazt.nf.rv.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (com.byazt.nf.rv.getContext() != null) {
            com.byazt.tk.n.n(com.byazt.nf.rv.getContext(), intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.byazt.tk.n.InterfaceC0352n
                public void n() {
                }

                @Override // com.byazt.tk.n.InterfaceC0352n
                public void n(Throwable th) {
                    k.n("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    public static void n(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 3);
        intentN.putExtra("app_download_url", str);
        intentN.putExtra("dialog_title", str2);
        intentN.putExtra("dialog_content_key", str3);
        com.byazt.tk.n.n(context, intentN, null);
    }

    private static Intent n(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        return intent;
    }

    public static void n(x xVar) {
        cy = xVar;
    }

    public static void n(Context context, String str, String str2, String str3, x xVar, pk pkVar) {
        try {
            n = pkVar;
            cy = xVar;
            if (context == null) {
                context = com.byazt.nf.rv.getContext();
            }
            Intent intentN = n(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentN.putExtra("type", 7);
            intentN.putExtra("app_download_url", str);
            intentN.putExtra("dialog_app_manage_model", str2);
            if (pkVar != null) {
                intentN.putExtra("event_adId", pkVar.q());
                intentN.putExtra("event_extInfo", pkVar.F_());
                intentN.putExtra("event_TAG", w.qg(pkVar));
            }
            intentN.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentN.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentN.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentN.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.byazt.tk.n.n(context, intentN, null);
        } catch (Exception unused) {
        }
    }

    public static void n(Context context, String str, String str2, String str3, pk pkVar) {
        if (context == null) {
            try {
                context = com.byazt.nf.rv.getContext();
            } catch (Exception unused) {
                return;
            }
        }
        Intent intentN = n(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentN.putExtra("type", 7);
        intentN.putExtra("app_download_url", str);
        intentN.putExtra("dialog_app_manage_model", str2);
        if (pkVar != null) {
            intentN.putExtra("event_adId", pkVar.q());
            intentN.putExtra("event_extInfo", pkVar.F_());
            intentN.putExtra("event_TAG", w.qg(pkVar));
        }
        intentN.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentN.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentN.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentN.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void n(Context context, String str, String str2) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 8);
        intentN.putExtra("app_download_url", str);
        intentN.putExtra("dialog_app_manage_model", str2);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void n(Context context, String str) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 10);
        intentN.putExtra("dialog_content_key", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void qg(Context context, String str, String str2) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        com.byazt.gct.w wVarN = com.byazt.oh.l.n(str2);
        if (wVarN == null) {
            return;
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 9);
        intentN.putExtra("dialog_app_privacy_url", wVarN.fs());
        intentN.putExtra("app_download_url", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void n(Context context, String str, String str2, pk pkVar) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        com.byazt.gct.w wVarN = com.byazt.oh.l.n(str2);
        if (wVarN == null) {
            return;
        }
        if (pkVar != null) {
            qg(w.qg(pkVar), pkVar.F_(), pkVar.q());
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 16);
        intentN.putExtra("dialog_app_registration_url", wVarN.cp());
        intentN.putExtra("app_download_url", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.hm.n.n(str, "click_other", str3, str2, new com.byazt.rs.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                return jSONObject2;
            }
        });
    }

    public static void s(Context context, String str, String str2) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 14);
        intentN.putExtra("dialog_app_desc_url", str2);
        intentN.putExtra("app_download_url", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void q(Context context, String str, String str2) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 12);
        intentN.putExtra("web_url", str);
        intentN.putExtra("web_title", str2);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void n(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 5);
        intentN.putExtra("app_download_url", str);
        intentN.putExtra("dialog_title", str2);
        intentN.putExtra("dialog_content_key", str3);
        intentN.putExtra("dialog_btn_yes_key", str4);
        intentN.putExtra("dialog_btn_no_key", str5);
        com.byazt.tk.n.n(context, intentN, null);
    }

    public static void n(Context context, pk pkVar) {
        JSONObject jSONObjectPv;
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 6);
        if (pkVar != null && (jSONObjectPv = pkVar.pv()) != null) {
            intentN.putExtra("materialmeta", jSONObjectPv.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentN);
            } catch (Throwable unused) {
            }
        }
    }

    public static void qg(Context context, String str) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 11);
        intentN.putExtra("dialog_app_ad_info", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    private void qg() {
        try {
            if (this.sz == null) {
                this.sz = new rv(this.tj, getIntent());
            }
            if (this.sz.isShowing()) {
                this.sz.dismiss();
            }
            this.sz.n(new rv.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.byazt.mr.rv.n
                public void n(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.sz.show();
        } catch (Throwable unused) {
        }
    }

    private void s() {
        if (com.byazt.vyf.s.cy().ri()) {
            if (this.cp == null && this.rv == null && this.oa == null) {
                return;
            }
            com.byazt.vyf.s.cy().tj(false);
            finish();
        }
    }

    public void n(String str) {
        if (this.k == null) {
            this.k = new cy(this.tj, str);
        }
        if (this.k.isShowing()) {
            this.k.dismiss();
        }
        this.k.n(new cy.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.byazt.mr.cy.n
            public void n(String str2) {
                com.byazt.okk.n.qg(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.mr.cy.n
            public void qg(String str2) {
                com.byazt.okk.n.q(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.k.show();
    }

    public static void n(Context context, String str, boolean z) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 15);
        if (!z) {
            intentN.putExtra("web_url", str);
        }
        com.byazt.tk.n.n(context, intentN, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        fs fsVar = this.rv;
        if (fsVar != null) {
            hd = fsVar.n();
        }
        s sVar = this.cp;
        if (sVar != null) {
            cd = sVar.q();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        s();
    }

    public static void n(Context context, String str, pk pkVar) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        Intent intentN = n(context);
        intentN.putExtra("type", 13);
        n = pkVar;
        intentN.putExtra("event_tag", str);
        com.byazt.tk.n.n(context, intentN, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tj = this;
        q();
        this.qg = getIntent();
        if (com.byazt.nf.rv.getContext() == null) {
            com.byazt.nf.rv.n(this.tj);
        }
    }

    private void q() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (com.byazt.nf.rv.getContext() == null) {
            com.byazt.nf.rv.n(this.tj);
        }
        try {
            setIntent(intent);
            this.qg = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            l();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            n = null;
            AlertDialog alertDialog = this.s;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.s.dismiss();
            }
            fs fsVar = this.rv;
            if (fsVar != null && fsVar.isShowing()) {
                com.byazt.okk.n.n(this.rv.n());
                if (this.rv.isShowing()) {
                    this.rv.dismiss();
                }
            } else {
                com.byazt.okk.n.n(hd);
            }
            q qVar = this.w;
            if (qVar != null && qVar.isShowing()) {
                this.w.dismiss();
            }
            s sVar = this.cp;
            if (sVar != null) {
                if (sVar.isShowing()) {
                    this.cp.dismiss();
                }
                com.byazt.okk.n.n(this.cp.q());
            } else {
                com.byazt.okk.n.n(cd);
            }
            qg qgVar = this.d;
            if (qgVar != null && qgVar.isShowing()) {
                this.d.dismiss();
            }
            l lVar = this.x;
            if (lVar != null && lVar.isShowing()) {
                this.x.dismiss();
            }
            cp cpVar = this.oa;
            if (cpVar != null && cpVar.isShowing()) {
                this.oa.dismiss();
            }
            Dialog dialog = this.fs;
            if (dialog != null && dialog.isShowing()) {
                this.fs.dismiss();
            }
            hd = null;
            cd = null;
        } catch (Throwable th) {
            k.n("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s sVar = this.cp;
        if (sVar == null || sVar.isShowing()) {
            return;
        }
        this.cp.n();
    }

    private void l() {
        try {
            Intent intent = this.qg;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.qg.getStringExtra("app_download_url");
            this.qg.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    w();
                    break;
                case 3:
                    s(stringExtra, this.qg.getStringExtra("dialog_title"), this.qg.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    qg(this.qg.getStringExtra("permission_id_key"), this.qg.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    qg(stringExtra, this.qg.getStringExtra("dialog_title"), this.qg.getStringExtra("dialog_content_key"), this.qg.getStringExtra("dialog_btn_yes_key"), this.qg.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    l(this.qg.getStringExtra("materialmeta"));
                    break;
                case 7:
                    s(stringExtra);
                    break;
                case 8:
                    n(this.qg.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    s(this.qg.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    qg(this.qg.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    q(this.qg.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    qg(this.qg.getStringExtra("web_url"), this.qg.getStringExtra("web_title"));
                    break;
                case 13:
                    qg();
                    break;
                case 14:
                    n(this.qg.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    n(this.qg.getStringExtra("web_url"));
                    break;
                case 16:
                    n(this.qg.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void qg(String str) {
        try {
            if (com.byazt.okk.s.rv(this.tj)) {
                Dialog dialog = this.fs;
                if (dialog == null || !dialog.isShowing()) {
                    com.byazt.mr.n nVar = new com.byazt.mr.n(this.tj, str);
                    this.fs = nVar;
                    nVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.fs.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void s(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strCp;
        String str8;
        String str9;
        float fS;
        String str10;
        Intent intent = this.qg;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.qg.getStringExtra("event_adId");
        final String stringExtra3 = this.qg.getStringExtra("event_TAG");
        String stringExtra4 = this.qg.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.qg.getStringExtra("dialog_title");
        final String stringExtra6 = this.qg.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.qg.getStringExtra("dialog_app_description");
        boolean z = false;
        boolean booleanExtra = this.qg.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
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
                com.byazt.gct.w wVarN = com.byazt.oh.l.n(stringExtra4);
                if (wVarN != null) {
                    String strL = wVarN.l();
                    String strX = wVarN.x();
                    String strTj = wVarN.tj();
                    String strSz = wVarN.sz();
                    if (!TextUtils.isEmpty(strSz)) {
                        stringExtra5 = strSz;
                    }
                    JSONArray jSONArrayQ = wVarN.q();
                    fS = wVarN.s();
                    strCp = wVarN.cp();
                    strOptString = stringExtra5;
                    str8 = strL;
                    str10 = strX;
                    jSONArray2 = jSONArrayQ;
                    str9 = strTj;
                } else {
                    strCp = null;
                    str8 = "";
                    str9 = str8;
                    fS = 0.0f;
                    str10 = str9;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put("app_name", strOptString);
                    jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, stringExtra6);
                    jSONObject.put(BundleKey.DESCRIPTION, stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z = true;
                }
                str2 = stringExtra4;
                str6 = strOptString;
                str3 = strCp;
                str7 = str9;
                str4 = str8;
                strOptString = jSONObject.optString("hand_icon_url");
                jSONArray = jSONArray2;
                float f2 = fS;
                str5 = str10;
                f = f2;
            }
            if (booleanExtra) {
                n(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
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
                n(str, str2, new x() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.byazt.ozc.x
                    public void n(int i, String str18) {
                        TTDelegateActivity.this.n(str, str11, stringExtra6, f3, stringExtra7, str12, jSONArray3, str13, str14, str15, str16, str17, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.rv != null) {
                            TTDelegateActivity.this.rv.n((x) null);
                        }
                        if (TTDelegateActivity.cy != null) {
                            TTDelegateActivity.cy.n(i, str18);
                        }
                    }

                    @Override // com.byazt.ozc.x
                    public void n(com.byazt.ih.s<View> sVar) {
                        if (TTDelegateActivity.cy != null) {
                            TTDelegateActivity.cy.n(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            n(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable unused) {
        }
    }

    private void n(String str, String str2, x xVar, String str3, String str4, String str5) {
        if (com.byazt.okk.s.rv(this.tj)) {
            if (TextUtils.isEmpty(str2)) {
                xVar.n(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                s sVar = this.cp;
                if (sVar == null || !sVar.isShowing()) {
                    s sVarRv = new oa(this.tj, jSONObject, xVar).rv(str);
                    this.cp = sVarRv;
                    ((oa) sVarRv).qg(n(str, str2, str3, str4, str5));
                    this.cp.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void n(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        n(str, str2, str7, f, new x() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.byazt.ozc.x
            public void n(int i, String str13) {
                TTDelegateActivity.this.n(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.rv != null) {
                    TTDelegateActivity.this.rv.n((x) null);
                }
                if (TTDelegateActivity.cy != null) {
                    TTDelegateActivity.cy.n(i, str13);
                }
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                if (TTDelegateActivity.cy != null) {
                    TTDelegateActivity.cy.n(null);
                }
            }
        }, str10, str11, str12);
    }

    private void n(final String str, final String str2, String str3, float f, x xVar, final String str4, final String str5, final String str6) {
        if (com.byazt.okk.s.rv(this.tj)) {
            if (TextUtils.isEmpty(str2)) {
                xVar.n(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f);
                JSONObject jSONObjectN = com.byazt.ep.cp.n(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.byazt.ep.s) null);
                if (jSONObjectN == null) {
                    xVar.n(8, "uegnTemplate is empty");
                    return;
                }
                fs fsVar = this.rv;
                if (fsVar == null || !fsVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    fs fsVar2 = new fs(str, this.tj, jSONObjectN, jSONObject2, xVar, n);
                    this.rv = fsVar2;
                    fsVar2.n(new com.byazt.mr.x.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        public com.byazt.gct.w x = null;

                        @Override // com.byazt.mr.x.n
                        public void n(Dialog dialog) {
                            com.byazt.okk.n.qg(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.byazt.mr.x.n
                        public void qg(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.n(str2, str, false, (Dialog) tTDelegateActivity.rv);
                            if (TTDelegateActivity.this.rv != null) {
                                TTDelegateActivity.this.rv.hide();
                            }
                        }

                        @Override // com.byazt.mr.x.n
                        public void s(Dialog dialog) {
                            com.byazt.okk.n.q(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.byazt.mr.x.n
                        public void q(Dialog dialog) {
                            if (this.x == null) {
                                this.x = com.byazt.oh.l.n(str2);
                            }
                            com.byazt.gct.w wVar = this.x;
                            if (wVar != null) {
                                TTDelegateActivity.this.n(wVar.fs(), str, 2, false, (Dialog) TTDelegateActivity.this.rv);
                            }
                            if (TTDelegateActivity.this.rv != null) {
                                TTDelegateActivity.this.rv.hide();
                            }
                        }

                        @Override // com.byazt.mr.x.n
                        public void n() {
                            if (this.x == null) {
                                this.x = com.byazt.oh.l.n(str2);
                            }
                            com.byazt.gct.w wVar = this.x;
                            if (wVar != null) {
                                TTDelegateActivity.this.n(wVar.rv(), str, 1, false, (Dialog) TTDelegateActivity.this.rv);
                            }
                            if (TTDelegateActivity.this.rv != null) {
                                TTDelegateActivity.this.rv.hide();
                            }
                        }
                    });
                    this.rv.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (com.byazt.okk.s.rv(this.tj)) {
            s sVar = this.cp;
            if (sVar == null || !sVar.isShowing()) {
                s sVarN = new s(this.tj).n(str8).l(str6).w(str9).qg(str3).fs(str7).rv(str).s(str5).n(f).n(jSONArray).x(str10).q(str4).n(n(str, str2, str11, str12, str13));
                this.cp = sVarN;
                sVarN.show();
            }
        }
    }

    private s.n n(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new s.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            public com.byazt.gct.w x = null;

            @Override // com.byazt.mr.s.n
            public void n(Dialog dialog) {
                com.byazt.okk.n.qg(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.mr.s.n
            public void qg(Dialog dialog) {
                TTDelegateActivity.this.n(str2, str, false, (Dialog) null);
            }

            @Override // com.byazt.mr.s.n
            public void s(Dialog dialog) {
                com.byazt.okk.n.q(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.mr.s.n
            public void q(Dialog dialog) {
                if (this.x == null) {
                    this.x = com.byazt.oh.l.n(str2);
                }
                com.byazt.gct.w wVar = this.x;
                if (wVar != null) {
                    TTDelegateActivity.this.n(wVar.fs(), str, 2, false, (Dialog) null);
                }
            }

            @Override // com.byazt.mr.s.n
            public void l(Dialog dialog) {
                if (this.x == null) {
                    this.x = com.byazt.oh.l.n(str2);
                }
                com.byazt.gct.w wVar = this.x;
                if (wVar == null) {
                    return;
                }
                TTDelegateActivity.this.n(wVar.rv(), str, 1, false, (Dialog) null);
            }

            @Override // com.byazt.mr.s.n
            public void w(Dialog dialog) {
                TTDelegateActivity.qg(str4, str5, str3);
                if (this.x == null) {
                    this.x = com.byazt.oh.l.n(str2);
                }
                com.byazt.gct.w wVar = this.x;
                if (wVar == null) {
                    return;
                }
                TTDelegateActivity.this.n(wVar.cp(), str, 3, false, (Dialog) null);
            }
        };
    }

    private void n(String str, String str2) {
        if (this.qg == null) {
            return;
        }
        n(str, str2, true, (Dialog) null);
    }

    private void qg(String str, String str2) {
        try {
            if (com.byazt.okk.s.rv(this.tj)) {
                q qVar = this.w;
                if (qVar != null) {
                    qVar.dismiss();
                }
                q qVar2 = new q(this.tj, str, str2);
                this.w = qVar2;
                qVar2.n(new q.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.byazt.mr.q.n
                    public void n(Dialog dialog) {
                        if (TTDelegateActivity.this.w != null) {
                            TTDelegateActivity.this.w.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.w.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (com.byazt.okk.s.rv(this.tj)) {
                l lVar = this.x;
                if (lVar != null) {
                    lVar.dismiss();
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
                l lVar2 = new l(this.tj, str, str3, str4);
                this.x = lVar2;
                lVar2.n(new l.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.byazt.mr.l.n
                    public void n(Dialog dialog2) {
                        com.byazt.okk.n.qg(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.mr.l.n
                    public void qg(Dialog dialog2) {
                        com.byazt.okk.n.q(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.mr.l.n
                    public void s(Dialog dialog2) {
                        if (TTDelegateActivity.this.x != null) {
                            if (z) {
                                com.byazt.okk.n.q(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.x.dismiss();
                            }
                        }
                    }
                });
                this.x.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void s(String str, String str2) {
        if (this.qg == null) {
            return;
        }
        n(str, str2, 2, true, (Dialog) null);
    }

    private void q(String str) {
        try {
            if (com.byazt.okk.s.rv(this.tj)) {
                cp cpVar = this.oa;
                if (cpVar != null) {
                    cpVar.dismiss();
                }
                cp cpVar2 = new cp(this.tj, str);
                this.oa = cpVar2;
                cpVar2.n(new cp.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.byazt.mr.cp.n
                    public void n(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.oa.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (com.byazt.okk.s.rv(this.tj)) {
                qg qgVar = this.d;
                if (qgVar != null) {
                    qgVar.dismiss();
                }
                qg qgVar2 = new qg(this.tj, str);
                this.d = qgVar2;
                qgVar2.n(new qg.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.byazt.mr.qg.n
                    public void n(Dialog dialog2) {
                        com.byazt.okk.n.qg(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.mr.qg.n
                    public void qg(Dialog dialog2) {
                        com.byazt.okk.n.q(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.mr.qg.n
                    public void s(Dialog dialog2) {
                        if (TTDelegateActivity.this.d != null) {
                            if (z) {
                                com.byazt.okk.n.q(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.d.dismiss();
                            }
                        }
                    }
                });
                this.d.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void l(String str) {
        if (com.byazt.okk.s.rv(this.tj)) {
            if (str != null && this.q == null) {
                try {
                    pk pkVarN = com.byazt.vgx.qg.n(new JSONObject(str));
                    if (pkVarN != null) {
                        com.byazt.wg.qg qgVar = new com.byazt.wg.qg(this.tj, pkVarN.pt(), false, com.byazt.imu.s.n());
                        this.q = qgVar;
                        com.byazt.yo.s.n(this.tj, pkVarN, qgVar);
                        this.q.n(new com.byazt.wg.qg.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.byazt.wg.qg.n
                            public void n() {
                            }

                            @Override // com.byazt.wg.qg.n
                            public void n(int i, String str2, boolean z) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.byazt.wg.qg.n
                            public void qg() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException unused) {
                }
            }
            com.byazt.wg.qg qgVar2 = this.q;
            if (qgVar2 != null) {
                qgVar2.n();
            }
        }
    }

    private void qg(final String str, String str2, String str3, String str4, String str5) {
        if (com.byazt.okk.s.rv(this.tj)) {
            AlertDialog alertDialog = this.s;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.l == null) {
                this.l = new tj(this.tj).n(str2).qg(str3).s(str4).q(str5).n(new tj.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.byazt.mr.tj.n
                    public void n(Dialog dialog) {
                        com.byazt.okk.n.qg(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.mr.tj.n
                    public void qg(Dialog dialog) {
                        com.byazt.okk.n.s(str);
                        TTDelegateActivity.this.finish();
                    }
                }).n(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        com.byazt.okk.n.q(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.l.isShowing()) {
                this.l.show();
            }
            this.s = this.l;
        }
    }

    private void qg(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            com.byazt.af.x.n().n(this.tj, strArr, new com.byazt.af.fs() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                @Override // com.byazt.af.fs
                public void n() {
                    com.byazt.af.n.n(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.af.fs
                public void n(String str2) {
                    com.byazt.af.n.n(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void s(final String str, String str2, String str3) {
        if (com.byazt.okk.s.rv(this.tj)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "提示";
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            n(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.byazt.okk.n.qg(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.byazt.okk.n.s(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.byazt.okk.n.q(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void w() {
        ApplicationInfo applicationInfo;
        try {
            com.byazt.zq.q qVarA = com.byazt.vyf.s.cy().a();
            boolean zQ = qVarA.q();
            boolean zFs = qVarA.fs();
            ArrayList arrayList = new ArrayList();
            com.byazt.hnb.n.n(qVarA, arrayList);
            if (zQ) {
                arrayList.add(c.a);
            }
            Context context = com.byazt.nf.rv.getContext();
            if (context != null && (applicationInfo = context.getApplicationInfo()) != null) {
                if (applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                } else if (zFs) {
                    arrayList.add(c.b);
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            com.byazt.af.x.n().n(this.tj, strArr, new com.byazt.af.fs() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                @Override // com.byazt.af.fs
                public void n() {
                    com.byazt.qit.l.n(new n("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.af.fs
                public void n(String str) {
                    c.a.equals(str);
                    com.byazt.qit.l.n(new n("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void n(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.s == null) {
                this.s = new AlertDialog.Builder(this.tj, R.style.Theme.DeviceDefault.Light.Dialog).create();
            }
            Window window = this.s.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                window.setAttributes(attributes);
            }
            this.s.setTitle(String.valueOf(str));
            this.s.setMessage(String.valueOf(str2));
            this.s.setButton(-1, "确定", onClickListener);
            this.s.setButton(-2, "取消", onClickListener2);
            this.s.setOnCancelListener(onCancelListener);
            if (this.s.isShowing()) {
                return;
            }
            this.s.show();
        } catch (Exception unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 55, 56, 57, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 1552})
    public static class n extends com.byazt.qit.x {
        public n(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            ITTDownloadVisitor iTTDownloadVisitorN = com.byazt.ms.x.n();
            if (iTTDownloadVisitorN != null) {
                Function<SparseArray<Object>, Object> functionFi = com.byazt.vyf.s.cy().fi();
                if (functionFi != null) {
                    iTTDownloadVisitorN.initPath(com.byazt.of.n.qg(functionFi).booleanValue(1));
                }
                ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).l((Boolean) null);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.byazt.af.x.n().n(this.tj, strArr, iArr);
        com.byazt.qit.l.n(new n("onRequestPermissionsResult"), 1);
        finish();
    }
}
