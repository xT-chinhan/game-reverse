package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.auw.DownloadInfo;
import com.byazt.cvl.vk;
import com.byazt.eld.ho;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fi.BaseConstants;
import com.byazt.hja.pr;
import com.byazt.lj.Downloader;
import com.byazt.mdu.hn;
import com.byazt.shh.uc;
import com.byazt.tia.hw;
import com.byazt.uk.m;
import com.byazt.uk.zo;
import com.byazt.wc.c;
import com.byazt.zv.cz;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private static pr x;
    private hw hn;
    private boolean hw;
    protected Intent pr = null;

    public static void pr(String str, String[] strArr) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    public static void pr(String str, com.byazt.tia.pr prVar) {
        Intent intentHn = hn(prVar);
        intentHn.addFlags(C.ENCODING_PCM_MU_LAW);
        intentHn.putExtra("type", 2);
        intentHn.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (k.getContext() != null) {
            k.getContext().startActivity(intentHn);
        }
    }

    public static void hw(String str, com.byazt.tia.pr prVar) {
        Intent intentHn = hn(prVar);
        intentHn.addFlags(C.ENCODING_PCM_MU_LAW);
        intentHn.putExtra("type", 11);
        intentHn.putExtra("package_name", str);
        if (k.getContext() != null) {
            k.getContext().startActivity(intentHn);
        }
    }

    public static void pr(com.byazt.tia.pr prVar) {
        Intent intentHn = hn(prVar);
        intentHn.addFlags(C.ENCODING_PCM_MU_LAW);
        intentHn.putExtra("type", 4);
        intentHn.putExtra("model_id", prVar.hw());
        if (k.getContext() != null) {
            k.getContext().startActivity(intentHn);
        }
    }

    public static void pr(com.byazt.tia.pr prVar, pr prVar2) {
        Intent intentHn = hn(prVar);
        intentHn.addFlags(C.ENCODING_PCM_MU_LAW);
        intentHn.putExtra("type", 9);
        x = prVar2;
        if (k.getContext() != null) {
            k.getContext().startActivity(intentHn);
        }
    }

    public static void pr(long j) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    public static void pr(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    public static void pr(String str, long j, String str2) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    public static void hw(String str, long j, String str2) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    public static void pr(String str, long j) {
        Intent intent = new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (k.getContext() != null) {
            k.getContext().startActivity(intent);
        }
    }

    private static Intent hn(com.byazt.tia.pr prVar) {
        return new Intent(k.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void hw(com.byazt.tia.pr prVar) {
        pr(prVar, 5, "", "", "", "");
    }

    public static void pr(com.byazt.tia.pr prVar, String str) {
        pr(prVar, 19, "", "", "", str);
    }

    public static void pr(com.byazt.tia.pr prVar, String str, String str2, String str3) {
        pr(prVar, 8, str, str2, str3, "");
    }

    public static void pr(com.byazt.tia.pr prVar, String str, String str2, String str3, String str4) {
        pr(prVar, 21, str, str2, str3, str4);
    }

    public static void hw(com.byazt.tia.pr prVar, String str, String str2, String str3) {
        pr(prVar, 7, str, str2, str3, "");
    }

    public static void hw(com.byazt.tia.pr prVar, String str, String str2, String str3, String str4) {
        pr(prVar, 20, str, str2, str3, str4);
    }

    private static void pr(com.byazt.tia.pr prVar, int i, String str, String str2, String str3, String str4) {
        Intent intentHn = hn(prVar);
        intentHn.addFlags(C.ENCODING_PCM_MU_LAW);
        intentHn.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentHn.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentHn.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentHn.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentHn.putExtra("message_text", str);
        }
        intentHn.putExtra("model_id", prVar.hw());
        if (k.getContext() != null) {
            k.getContext().startActivity(intentHn);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hw();
        this.pr = getIntent();
        k.hw(this);
        pr();
    }

    private void hw() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.pr = intent;
        k.hw(this);
        pr();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        k.c().pr(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        hw hwVar;
        DownloadInfo downloadInfoHw;
        super.onStop();
        if (this.hw && (hwVar = this.hn) != null) {
            if (!TextUtils.isEmpty(hwVar.gu())) {
                downloadInfoHw = vk.pr(k.getContext()).pr(this.hn.gu(), null, true);
            } else {
                downloadInfoHw = vk.pr(k.getContext()).hw(this.hn.pr());
            }
            if (downloadInfoHw != null && downloadInfoHw.getCurBytes() >= downloadInfoHw.getTotalBytes() && !isFinishing()) {
                finish();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void pr() {
        Intent intent = this.pr;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    hw(this.pr.getStringExtra("permission_id_key"), this.pr.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    pr(this.pr.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    hn.pr((Activity) this);
                    break;
                case 4:
                    hw(this.pr.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    pr(this.pr.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    hn();
                    break;
                case 9:
                    pr prVar = x;
                    if (prVar != null) {
                        prVar.pr();
                    }
                    hn.pr((Activity) this);
                    break;
                case 10:
                    hn(this.pr.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    hw(this.pr.getStringExtra("package_name"));
                    break;
                case 12:
                    zo.pr(this, this.pr.getStringExtra("package_name"), this.pr.getLongExtra("model_id", 0L), this.pr.getStringExtra("param"), this.pr.getStringExtra("ext_json"));
                    hn.pr((Activity) this);
                    break;
                case 13:
                    zo.pr(this, this.pr.getStringExtra("package_name"), this.pr.getLongExtra("model_id", 0L), this.pr.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    hn.pr((Activity) this);
                    break;
                case 14:
                    zo.hw(this, this.pr.getStringExtra("package_name"), this.pr.getLongExtra("model_id", 0L), this.pr.getStringExtra("market_app_id"));
                    hn.pr((Activity) this);
                    break;
                case 15:
                    zo.pr((Activity) this, this.pr.getStringExtra("package_name"), this.pr.getLongExtra("model_id", 0L));
                    hn.pr((Activity) this);
                    break;
                case 16:
                    zo.pr((Context) this, this.pr.getStringExtra("package_name"), this.pr.getLongExtra("model_id", 0L));
                    hn.pr((Activity) this);
                    break;
                case 19:
                    pr(this.pr.getLongExtra("model_id", 0L), this.pr.getStringExtra("delete_button_text"));
                    break;
            }
            this.pr = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:22:0x00cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:24:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:26:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:30:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:32:0x0100  */
    /* JADX WARN: Code duplicated, block: B:39:0x012a  */
    /* JADX WARN: Code duplicated, block: B:41:0x012e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0158  */
    /* JADX WARN: Code duplicated, block: B:51:0x0161  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bf A[ORIG_RETURN, RETURN] */
    private void hn() {
        int iPr;
        int i;
        int i2;
        c.pr prVarHn;
        CharSequence charSequence;
        JSONObject jSONObject;
        DownloadInfo downloadInfoHw;
        long longExtra = this.pr.getLongExtra("model_id", 0L);
        String stringExtra = this.pr.getStringExtra("message_text");
        String stringExtra2 = this.pr.getStringExtra("positive_button_text");
        String stringExtra3 = this.pr.getStringExtra("negative_button_text");
        String stringExtra4 = this.pr.getStringExtra("delete_button_text");
        int intExtra = this.pr.getIntExtra("type", 0);
        hw hwVarX = uc.pr().x(longExtra);
        if (hwVarX != null) {
            if (!TextUtils.isEmpty(hwVarX.gu())) {
                downloadInfoHw = vk.pr(k.getContext()).pr(hwVarX.gu(), null, true);
            } else {
                downloadInfoHw = vk.pr(k.getContext()).hw(hwVarX.pr());
            }
            if (downloadInfoHw != null) {
                long curBytes = downloadInfoHw.getCurBytes();
                long totalBytes = downloadInfoHw.getTotalBytes();
                if (curBytes > 0 && totalBytes > 0) {
                    stringExtra3 = stringExtra3;
                    i2 = (int) (curBytes / 1048576);
                    i = (int) (totalBytes / 1048576);
                    iPr = com.byazt.eld.vk.pr(downloadInfoHw.getId(), (int) ((curBytes * 100) / totalBytes));
                }
                prVarHn = new c.pr(this).pr(false).pr(stringExtra).hw(stringExtra2).hn(stringExtra3);
                if (intExtra == 7) {
                    if (com.byazt.yey.uc.pr() == null) {
                        return;
                    }
                    prVarHn.pr(com.byazt.yey.uc.pr());
                    prVarHn.pr().show();
                    charSequence = "download_percent";
                } else if (intExtra == 8) {
                    if (com.byazt.yey.pr.pr() == null) {
                        return;
                    }
                    prVarHn.pr(com.byazt.yey.pr.pr());
                    prVarHn.pr().show();
                    charSequence = Constants.APK_SIZE_FIELD;
                } else if (intExtra == 20) {
                    if (com.byazt.yey.hn.pr() != null || com.byazt.yey.hn.hw() == null) {
                        return;
                    }
                    prVarHn.pr(com.byazt.yey.hn.pr()).x(stringExtra4).pr(com.byazt.yey.hn.hw());
                    prVarHn.pr().show();
                    charSequence = "download_percent_cancel";
                } else if (intExtra == 21) {
                    charSequence = "";
                } else {
                    if (com.byazt.yey.hw.pr() != null || com.byazt.yey.hw.hw() == null) {
                        return;
                    }
                    prVarHn.pr(com.byazt.yey.hw.pr()).x(stringExtra4).pr(com.byazt.yey.hw.hw());
                    prVarHn.pr().show();
                    charSequence = "apk_size_cancel";
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    this.hw = true;
                    this.hn = hwVarX;
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", charSequence);
                        jSONObject.putOpt("pause_optimise_action", "show_dialog");
                        jSONObject.putOpt("download_percent", Integer.valueOf(iPr));
                        jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
                        jSONObject.putOpt(Constants.DOWNLOAD_TOTAL_BYTES_FIELD, Integer.valueOf(i));
                    } catch (JSONException e) {
                    }
                    if (!TextUtils.equals(charSequence, "download_percent") || TextUtils.equals(charSequence, Constants.APK_SIZE_FIELD)) {
                        com.byazt.mf.pr.pr().pr("pause_optimise", jSONObject, hwVarX);
                    } else {
                        if (TextUtils.equals(charSequence, "download_percent_cancel") || TextUtils.equals(charSequence, "apk_size_cancel")) {
                            com.byazt.mf.pr.pr().pr("pause_cancel_optimise", jSONObject, hwVarX);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        iPr = -1;
        i = 0;
        i2 = 0;
        prVarHn = new c.pr(this).pr(false).pr(stringExtra).hw(stringExtra2).hn(stringExtra3);
        if (intExtra == 7) {
            if (com.byazt.yey.uc.pr() == null) {
                return;
            }
            prVarHn.pr(com.byazt.yey.uc.pr());
            prVarHn.pr().show();
            charSequence = "download_percent";
        } else if (intExtra == 8) {
            if (com.byazt.yey.pr.pr() == null) {
                return;
            }
            prVarHn.pr(com.byazt.yey.pr.pr());
            prVarHn.pr().show();
            charSequence = Constants.APK_SIZE_FIELD;
        } else if (intExtra == 20) {
            if (com.byazt.yey.hn.pr() != null) {
                return;
            } else {
                return;
            }
        } else if (intExtra == 21) {
            charSequence = "";
        } else if (com.byazt.yey.hw.pr() != null) {
            return;
        } else {
            return;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.hw = true;
            this.hn = hwVarX;
            jSONObject = new JSONObject();
            jSONObject.putOpt("pause_optimise_type", charSequence);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
            jSONObject.putOpt("download_percent", Integer.valueOf(iPr));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt(Constants.DOWNLOAD_TOTAL_BYTES_FIELD, Integer.valueOf(i));
            if (!TextUtils.equals(charSequence, "download_percent")) {
            }
            com.byazt.mf.pr.pr().pr("pause_optimise", jSONObject, hwVarX);
        }
    }

    private void pr(long j, String str) {
        if (ho.pr() == null) {
            return;
        }
        hw hwVarX = uc.pr().x(j);
        if (hwVarX != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVarX.qa());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - hwVarX.nw()));
                jSONObject.putOpt("click_download_size", Long.valueOf(hwVarX.ie()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt(Constants.DOWNLOAD_TOTAL_BYTES_FIELD, Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e) {
            }
            if (!TextUtils.isEmpty(str)) {
                com.byazt.mf.pr.pr().pr("cancel_pause_reserve_wifi_dialog_show", jSONObject, hwVarX);
            } else {
                com.byazt.mf.pr.pr().hw("pause_reserve_wifi_dialog_show", jSONObject, hwVarX);
            }
        }
        c.pr prVarPr = new c.pr(this).pr(false).pr(ho.pr());
        if (!TextUtils.isEmpty(str)) {
            prVarPr.x(str).pr(ho.hw());
        }
        prVarPr.pr().show();
        this.hw = true;
        this.hn = hwVarX;
    }

    private void hw(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            hn.pr((Activity) this);
            return;
        }
        cz czVar = new cz() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            public WeakReference<Activity> hn;

            {
                this.hn = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.byazt.zv.cz
            public void pr() {
                com.byazt.uk.vk.pr(str);
                hn.pr(this.hn.get());
            }

            @Override // com.byazt.zv.cz
            public void pr(String str2) {
                com.byazt.uk.vk.pr(str, str2);
                hn.pr(this.hn.get());
            }
        };
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                k.c().pr(this, strArr, czVar);
                return;
            } catch (Exception e) {
                k.a().pr(e, "requestPermission");
            }
        }
        czVar.pr();
    }

    private void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            hn.pr((Activity) this);
            return;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            if (com.byazt.ew.pr.hn().pr("fix_app_link_flag")) {
                intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intent);
        } catch (Exception e) {
        } finally {
            hn.pr((Activity) this);
        }
    }

    private void hw(String str) {
        Intent intentFw = m.fw(this, str);
        if (intentFw == null) {
            hn.pr((Activity) this);
            return;
        }
        try {
            intentFw.addFlags(C.ENCODING_PCM_MU_LAW);
            intentFw.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intentFw);
        } catch (Exception e) {
        } finally {
            hn.pr((Activity) this);
        }
    }

    private void hw(long j) {
        final hw hwVarX = uc.pr().x(j);
        if (hwVarX == null) {
            com.byazt.vi.hn.pr().pr("showOpenAppDialogInner nativeModel null");
            hn.pr((Activity) this);
            return;
        }
        com.byazt.zv.m mVarHn = k.hn();
        com.byazt.cxa.hw.pr prVarPr = new com.byazt.cxa.hw.pr(this).pr("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(hwVarX.qn()) ? "刚刚下载的应用" : hwVarX.qn();
        mVarHn.hw(prVarPr.hw(String.format("%1$s已安装完成，是否立即打开？", objArr)).hn("打开").x("取消").pr(false).pr(m.x(this, hwVarX.c())).pr(new com.byazt.cxa.hw.InterfaceC0036hw() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void pr(DialogInterface dialogInterface) {
                com.byazt.ds.pr.hw(hwVarX);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                hn.pr((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hw(DialogInterface dialogInterface) {
                com.byazt.mf.pr.pr().hw("market_openapp_cancel", hwVarX);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                hn.pr((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.cxa.hw.InterfaceC0036hw
            public void hn(DialogInterface dialogInterface) {
                hn.pr((Activity) TTDelegateActivity.this);
            }
        }).pr(2).pr());
        com.byazt.mf.pr.pr().hw("market_openapp_window_show", hwVarX);
    }

    private void hn(long j) {
        new com.byazt.xqu.pr(this, j).show();
    }
}
