package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.download.api.config.sl;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.ms.xr;
import com.ss.android.downloadlib.ab.x;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.ms.ka;
import com.ss.android.downloadlib.addownload.u;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.downloadlib.ch;
import com.ss.android.downloadlib.guide.install.ms;
import com.ss.android.socialbase.appdownloader.ah;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static ms d;
    private xr ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Intent f4352ms = null;
    private boolean xr;

    public static void ms(String str, String[] strArr) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void ms(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        Intent intentAh = ah(msVar);
        intentAh.addFlags(C.ENCODING_PCM_MU_LAW);
        intentAh.putExtra("type", 2);
        intentAh.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intentAh);
        }
    }

    public static void xr(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        Intent intentAh = ah(msVar);
        intentAh.addFlags(C.ENCODING_PCM_MU_LAW);
        intentAh.putExtra("type", 11);
        intentAh.putExtra("package_name", str);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intentAh);
        }
    }

    public static void ms(com.ss.android.downloadad.api.ms.ms msVar) {
        Intent intentAh = ah(msVar);
        intentAh.addFlags(C.ENCODING_PCM_MU_LAW);
        intentAh.putExtra("type", 4);
        intentAh.putExtra("model_id", msVar.xr());
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intentAh);
        }
    }

    public static void ms(com.ss.android.downloadad.api.ms.ms msVar, ms msVar2) {
        Intent intentAh = ah(msVar);
        intentAh.addFlags(C.ENCODING_PCM_MU_LAW);
        intentAh.putExtra("type", 9);
        d = msVar2;
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intentAh);
        }
    }

    public static void ms(long j) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void ms(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void ms(String str, long j, String str2) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void xr(String str, long j, String str2) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void ms(String str, long j) {
        Intent intent = new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intent);
        }
    }

    public static void ms(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 16);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private static Intent ah(com.ss.android.downloadad.api.ms.ms msVar) {
        return new Intent(hi.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void xr(com.ss.android.downloadad.api.ms.ms msVar) {
        ms(msVar, 5, "", "", "", "");
    }

    public static void ms(com.ss.android.downloadad.api.ms.ms msVar, String str) {
        ms(msVar, 19, "", "", "", str);
    }

    public static void ms(com.ss.android.downloadad.api.ms.ms msVar, String str, String str2, String str3) {
        ms(msVar, 8, str, str2, str3, "");
    }

    public static void ms(com.ss.android.downloadad.api.ms.ms msVar, String str, String str2, String str3, String str4) {
        ms(msVar, 21, str, str2, str3, str4);
    }

    public static void xr(com.ss.android.downloadad.api.ms.ms msVar, String str, String str2, String str3) {
        ms(msVar, 7, str, str2, str3, "");
    }

    public static void xr(com.ss.android.downloadad.api.ms.ms msVar, String str, String str2, String str3, String str4) {
        ms(msVar, 20, str, str2, str3, str4);
    }

    private static void ms(com.ss.android.downloadad.api.ms.ms msVar, int i, String str, String str2, String str3, String str4) {
        Intent intentAh = ah(msVar);
        intentAh.addFlags(C.ENCODING_PCM_MU_LAW);
        intentAh.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentAh.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentAh.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentAh.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentAh.putExtra("message_text", str);
        }
        intentAh.putExtra("model_id", msVar.xr());
        if (hi.getContext() != null) {
            hi.getContext().startActivity(intentAh);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xr();
        this.f4352ms = getIntent();
        hi.xr(this);
        ms();
    }

    private void xr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f4352ms = intent;
        hi.xr(this);
        ms();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        hi.ka().ms(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        xr xrVar;
        DownloadInfo downloadInfoXr;
        super.onStop();
        if (!this.xr || (xrVar = this.ah) == null) {
            return;
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = ch.ms(hi.getContext()).ms(this.ah.vy(), null, true);
        } else {
            downloadInfoXr = ch.ms(hi.getContext()).xr(this.ah.ms());
        }
        if (downloadInfoXr == null || downloadInfoXr.getCurBytes() < downloadInfoXr.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void ms() {
        Intent intent = this.f4352ms;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    xr(this.f4352ms.getStringExtra("permission_id_key"), this.f4352ms.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    ms(this.f4352ms.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    ah.ms((Activity) this);
                    break;
                case 4:
                    xr(this.f4352ms.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    ms(this.f4352ms.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    ah();
                    break;
                case 9:
                    ms msVar = d;
                    if (msVar != null) {
                        msVar.ms();
                    }
                    ah.ms((Activity) this);
                    break;
                case 10:
                    ah(this.f4352ms.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    xr(this.f4352ms.getStringExtra("package_name"));
                    break;
                case 12:
                    x.ms(this, this.f4352ms.getStringExtra("package_name"), this.f4352ms.getLongExtra("model_id", 0L), this.f4352ms.getStringExtra("param"), this.f4352ms.getStringExtra("ext_json"));
                    ah.ms((Activity) this);
                    break;
                case 13:
                    x.ms(this, this.f4352ms.getStringExtra("package_name"), this.f4352ms.getLongExtra("model_id", 0L), this.f4352ms.getStringExtra("need_comment"));
                    ah.ms((Activity) this);
                    break;
                case 14:
                    x.xr(this, this.f4352ms.getStringExtra("package_name"), this.f4352ms.getLongExtra("model_id", 0L), this.f4352ms.getStringExtra("market_app_id"));
                    ah.ms((Activity) this);
                    break;
                case 15:
                    x.ms(this, this.f4352ms.getStringExtra("package_name"), this.f4352ms.getLongExtra("model_id", 0L));
                    ah.ms((Activity) this);
                    break;
                case 16:
                    x.xr(this, this.f4352ms.getStringExtra("package_name"), this.f4352ms.getLongExtra("model_id", 0L));
                    ah.ms((Activity) this);
                    break;
                case 19:
                    ms(this.f4352ms.getLongExtra("model_id", 0L), this.f4352ms.getStringExtra("delete_button_text"));
                    break;
            }
            this.f4352ms = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0098  */
    private void ah() {
        int iMs;
        int i;
        int i2;
        CharSequence charSequence;
        DownloadInfo downloadInfoXr;
        long longExtra = this.f4352ms.getLongExtra("model_id", 0L);
        String stringExtra = this.f4352ms.getStringExtra("message_text");
        String stringExtra2 = this.f4352ms.getStringExtra("positive_button_text");
        String stringExtra3 = this.f4352ms.getStringExtra("negative_button_text");
        String stringExtra4 = this.f4352ms.getStringExtra("delete_button_text");
        int intExtra = this.f4352ms.getIntExtra("type", 0);
        xr xrVarD = c.ms().d(longExtra);
        if (xrVarD == null) {
            iMs = -1;
            i = 0;
            i2 = 0;
        } else {
            if (!TextUtils.isEmpty(xrVarD.vy())) {
                downloadInfoXr = ch.ms(hi.getContext()).ms(xrVarD.vy(), null, true);
            } else {
                downloadInfoXr = ch.ms(hi.getContext()).xr(xrVarD.ms());
            }
            if (downloadInfoXr != null) {
                long curBytes = downloadInfoXr.getCurBytes();
                long totalBytes = downloadInfoXr.getTotalBytes();
                if (curBytes <= 0 || totalBytes <= 0) {
                    iMs = -1;
                    i = 0;
                    i2 = 0;
                } else {
                    i2 = (int) (curBytes / BaseConstants.MB_VALUE);
                    i = (int) (totalBytes / BaseConstants.MB_VALUE);
                    iMs = com.ss.android.downloadlib.addownload.ch.ms(downloadInfoXr.getId(), (int) ((curBytes * 100) / totalBytes));
                }
            } else {
                iMs = -1;
                i = 0;
                i2 = 0;
            }
        }
        ka.ms msVarAh = new ka.ms(this).ms(false).ms(stringExtra).xr(stringExtra2).ah(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.d.c.ms() == null) {
                return;
            }
            msVarAh.ms(com.ss.android.downloadlib.addownload.d.c.ms());
            msVarAh.ms().show();
            charSequence = "download_percent";
        } else if (intExtra == 8) {
            if (com.ss.android.downloadlib.addownload.d.ms.ms() == null) {
                return;
            }
            msVarAh.ms(com.ss.android.downloadlib.addownload.d.ms.ms());
            msVarAh.ms().show();
            charSequence = "apk_size";
        } else if (intExtra == 20) {
            if (com.ss.android.downloadlib.addownload.d.ah.ms() == null || com.ss.android.downloadlib.addownload.d.ah.xr() == null) {
                return;
            }
            msVarAh.ms(com.ss.android.downloadlib.addownload.d.ah.ms()).d(stringExtra4).ms(com.ss.android.downloadlib.addownload.d.ah.xr());
            msVarAh.ms().show();
            charSequence = "download_percent_cancel";
        } else if (intExtra != 21) {
            charSequence = "";
        } else {
            if (com.ss.android.downloadlib.addownload.d.xr.ms() == null || com.ss.android.downloadlib.addownload.d.xr.xr() == null) {
                return;
            }
            msVarAh.ms(com.ss.android.downloadlib.addownload.d.xr.ms()).d(stringExtra4).ms(com.ss.android.downloadlib.addownload.d.xr.xr());
            msVarAh.ms().show();
            charSequence = "apk_size_cancel";
        }
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.xr = true;
        this.ah = xrVarD;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", charSequence);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
            jSONObject.putOpt("download_percent", Integer.valueOf(iMs));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i));
        } catch (JSONException e) {
            ab.ms(e);
        }
        if (TextUtils.equals(charSequence, "download_percent") || TextUtils.equals(charSequence, "apk_size")) {
            com.ss.android.downloadlib.d.ms.ms().ms("pause_optimise", jSONObject, xrVarD);
        } else if (TextUtils.equals(charSequence, "download_percent_cancel") || TextUtils.equals(charSequence, "apk_size_cancel")) {
            com.ss.android.downloadlib.d.ms.ms().ms("pause_cancel_optimise", jSONObject, xrVarD);
        }
    }

    private void ms(long j, String str) {
        if (u.ms() == null) {
            return;
        }
        xr xrVarD = c.ms().d(j);
        if (xrVarD != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVarD.y());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - xrVarD.qf()));
                jSONObject.putOpt("click_download_size", Long.valueOf(xrVarD.l()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / BaseConstants.MB_VALUE)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / BaseConstants.MB_VALUE)));
                }
            } catch (Exception e) {
                ab.ms(e);
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_dialog_show", jSONObject, xrVarD);
            } else {
                com.ss.android.downloadlib.d.ms.ms().xr("pause_reserve_wifi_dialog_show", jSONObject, xrVarD);
            }
        }
        ka.ms msVarMs = new ka.ms(this).ms(false).ms(u.ms());
        if (!TextUtils.isEmpty(str)) {
            msVarMs.d(str).ms(u.xr());
        }
        msVarMs.ms().show();
        this.xr = true;
        this.ah = xrVarD;
    }

    private void xr(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            ah.ms((Activity) this);
            return;
        }
        t tVar = new t() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            private WeakReference<Activity> ah;

            {
                this.ah = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.config.t
            public void ms() {
                com.ss.android.downloadlib.ab.ch.ms(str);
                ah.ms(this.ah.get());
            }

            @Override // com.ss.android.download.api.config.t
            public void ms(String str2) {
                com.ss.android.downloadlib.ab.ch.ms(str, str2);
                ah.ms(this.ah.get());
            }
        };
        try {
            hi.ka().ms(this, strArr, tVar);
        } catch (Exception e) {
            hi.t().ms(e, "requestPermission");
            tVar.ms();
        }
    }

    private void ms(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                ah.ms((Activity) this);
                return;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_app_link_flag")) {
                intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            intent.putExtra("start_only_for_android", true);
            startActivity(intent);
        } catch (Exception e) {
            ab.ms(e);
        } finally {
            ah.ms((Activity) this);
        }
    }

    private void xr(String str) {
        Intent intentAb = zb.ab(this, str);
        if (intentAb == null) {
            ah.ms((Activity) this);
            return;
        }
        try {
            intentAb.addFlags(C.ENCODING_PCM_MU_LAW);
            intentAb.putExtra("start_only_for_android", true);
            startActivity(intentAb);
        } catch (Exception e) {
            ab.ms(e);
        } finally {
            ah.ms((Activity) this);
        }
    }

    private void xr(long j) {
        final xr xrVarD = c.ms().d(j);
        if (xrVarD == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("showOpenAppDialogInner nativeModel null");
            ah.ms((Activity) this);
            return;
        }
        sl slVarAh = hi.ah();
        com.ss.android.download.api.model.xr.ms msVarMs = new com.ss.android.download.api.model.xr.ms(this).ms("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(xrVarD.e()) ? "刚刚下载的应用" : xrVarD.e();
        slVarAh.xr(msVarMs.xr(String.format("%1$s已安装完成，是否立即打开？", objArr)).ah("打开").d("取消").ms(false).ms(zb.d(this, xrVarD.ka())).ms(new com.ss.android.download.api.model.xr.InterfaceC0531xr() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ms(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.xr.ms.xr(xrVarD);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ah.ms((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void xr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.ms.ms().xr("market_openapp_cancel", xrVarD);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                ah.ms((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.xr.InterfaceC0531xr
            public void ah(DialogInterface dialogInterface) {
                ah.ms((Activity) TTDelegateActivity.this);
            }
        }).ms(2).ms());
        com.ss.android.downloadlib.d.ms.ms().xr("market_openapp_window_show", xrVarD);
    }

    private void ah(long j) {
        new com.ss.android.downloadlib.addownload.compliance.ms(this, j).show();
    }
}
