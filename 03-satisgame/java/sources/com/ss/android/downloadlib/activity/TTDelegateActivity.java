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
import com.byazt.bn.l;
import com.byazt.e.s;
import com.byazt.gs.n;
import com.byazt.h.qg;
import com.byazt.ho.BaseConstants;
import com.byazt.ky.py;
import com.byazt.q.AdBaseConstants;
import com.byazt.rz.fs;
import com.byazt.rz.oa;
import com.byazt.s.tj;
import com.byazt.ug.d;
import com.byazt.ug.k;
import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTDelegateActivity extends Activity {
    private static n q;
    protected Intent n = null;
    private boolean qg;
    private qg s;

    public static void n(String str, String[] strArr) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    public static void n(String str, com.byazt.h.n nVar) {
        Intent intentS = s(nVar);
        intentS.addFlags(C.ENCODING_PCM_MU_LAW);
        intentS.putExtra("type", 2);
        intentS.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (d.getContext() != null) {
            d.getContext().startActivity(intentS);
        }
    }

    public static void qg(String str, com.byazt.h.n nVar) {
        Intent intentS = s(nVar);
        intentS.addFlags(C.ENCODING_PCM_MU_LAW);
        intentS.putExtra("type", 11);
        intentS.putExtra("package_name", str);
        if (d.getContext() != null) {
            d.getContext().startActivity(intentS);
        }
    }

    public static void n(com.byazt.h.n nVar) {
        Intent intentS = s(nVar);
        intentS.addFlags(C.ENCODING_PCM_MU_LAW);
        intentS.putExtra("type", 4);
        intentS.putExtra("model_id", nVar.qg());
        if (d.getContext() != null) {
            d.getContext().startActivity(intentS);
        }
    }

    public static void n(com.byazt.h.n nVar, n nVar2) {
        Intent intentS = s(nVar);
        intentS.addFlags(C.ENCODING_PCM_MU_LAW);
        intentS.putExtra("type", 9);
        q = nVar2;
        if (d.getContext() != null) {
            d.getContext().startActivity(intentS);
        }
    }

    public static void n(long j) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    public static void n(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    public static void n(String str, long j, String str2) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    public static void qg(String str, long j, String str2) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    public static void n(String str, long j) {
        Intent intent = new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (d.getContext() != null) {
            d.getContext().startActivity(intent);
        }
    }

    private static Intent s(com.byazt.h.n nVar) {
        return new Intent(d.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void qg(com.byazt.h.n nVar) {
        n(nVar, 5, "", "", "", "");
    }

    public static void n(com.byazt.h.n nVar, String str) {
        n(nVar, 19, "", "", "", str);
    }

    public static void n(com.byazt.h.n nVar, String str, String str2, String str3) {
        n(nVar, 8, str, str2, str3, "");
    }

    public static void n(com.byazt.h.n nVar, String str, String str2, String str3, String str4) {
        n(nVar, 21, str, str2, str3, str4);
    }

    public static void qg(com.byazt.h.n nVar, String str, String str2, String str3) {
        n(nVar, 7, str, str2, str3, "");
    }

    public static void qg(com.byazt.h.n nVar, String str, String str2, String str3, String str4) {
        n(nVar, 20, str, str2, str3, str4);
    }

    private static void n(com.byazt.h.n nVar, int i, String str, String str2, String str3, String str4) {
        Intent intentS = s(nVar);
        intentS.addFlags(C.ENCODING_PCM_MU_LAW);
        intentS.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentS.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentS.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentS.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentS.putExtra("message_text", str);
        }
        intentS.putExtra("model_id", nVar.qg());
        if (d.getContext() != null) {
            d.getContext().startActivity(intentS);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qg();
        this.n = getIntent();
        d.qg(this);
        n();
    }

    private void qg() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.n = intent;
        d.qg(this);
        n();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        d.l().n(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        qg qgVar;
        DownloadInfo downloadInfoQg;
        super.onStop();
        if (!this.qg || (qgVar = this.s) == null) {
            return;
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = tj.n(d.getContext()).n(this.s.hf(), null, true);
        } else {
            downloadInfoQg = tj.n(d.getContext()).qg(this.s.n());
        }
        if (downloadInfoQg == null || downloadInfoQg.getCurBytes() < downloadInfoQg.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void n() {
        Intent intent = this.n;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    qg(this.n.getStringExtra("permission_id_key"), this.n.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    n(this.n.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    s.n((Activity) this);
                    break;
                case 4:
                    qg(this.n.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    n(this.n.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    s();
                    break;
                case 9:
                    n nVar = q;
                    if (nVar != null) {
                        nVar.n();
                    }
                    s.n((Activity) this);
                    break;
                case 10:
                    s(this.n.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    qg(this.n.getStringExtra("package_name"));
                    break;
                case 12:
                    fs.n(this, this.n.getStringExtra("package_name"), this.n.getLongExtra("model_id", 0L), this.n.getStringExtra("param"), this.n.getStringExtra("ext_json"));
                    s.n((Activity) this);
                    break;
                case 13:
                    fs.n(this, this.n.getStringExtra("package_name"), this.n.getLongExtra("model_id", 0L), this.n.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    s.n((Activity) this);
                    break;
                case 14:
                    fs.qg(this, this.n.getStringExtra("package_name"), this.n.getLongExtra("model_id", 0L), this.n.getStringExtra("market_app_id"));
                    s.n((Activity) this);
                    break;
                case 15:
                    fs.n((Activity) this, this.n.getStringExtra("package_name"), this.n.getLongExtra("model_id", 0L));
                    s.n((Activity) this);
                    break;
                case 16:
                    fs.n((Context) this, this.n.getStringExtra("package_name"), this.n.getLongExtra("model_id", 0L));
                    s.n((Activity) this);
                    break;
                case 19:
                    n(this.n.getLongExtra("model_id", 0L), this.n.getStringExtra("delete_button_text"));
                    break;
            }
            this.n = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0098  */
    private void s() {
        int iN;
        int i;
        int i2;
        String str;
        DownloadInfo downloadInfoQg;
        long longExtra = this.n.getLongExtra("model_id", 0L);
        String stringExtra = this.n.getStringExtra("message_text");
        String stringExtra2 = this.n.getStringExtra("positive_button_text");
        String stringExtra3 = this.n.getStringExtra("negative_button_text");
        String stringExtra4 = this.n.getStringExtra("delete_button_text");
        int intExtra = this.n.getIntExtra("type", 0);
        qg qgVarQ = w.n().q(longExtra);
        if (qgVarQ == null) {
            iN = -1;
            i = 0;
            i2 = 0;
        } else {
            if (!TextUtils.isEmpty(qgVarQ.hf())) {
                downloadInfoQg = tj.n(d.getContext()).n(qgVarQ.hf(), null, true);
            } else {
                downloadInfoQg = tj.n(d.getContext()).qg(qgVarQ.n());
            }
            if (downloadInfoQg != null) {
                long curBytes = downloadInfoQg.getCurBytes();
                long totalBytes = downloadInfoQg.getTotalBytes();
                if (curBytes <= 0 || totalBytes <= 0) {
                    iN = -1;
                    i = 0;
                    i2 = 0;
                } else {
                    i = (int) (curBytes / 1048576);
                    i2 = (int) (totalBytes / 1048576);
                    iN = com.byazt.ug.tj.n(downloadInfoQg.getId(), (int) ((curBytes * 100) / totalBytes));
                }
            } else {
                iN = -1;
                i = 0;
                i2 = 0;
            }
        }
        l.n nVarS = new l.n(this).n(false).n(stringExtra).qg(stringExtra2).s(stringExtra3);
        if (intExtra == 7) {
            if (com.byazt.mx.w.n() == null) {
                return;
            }
            nVarS.n(com.byazt.mx.w.n());
            nVarS.n().show();
            str = "download_percent";
        } else if (intExtra == 8) {
            if (com.byazt.mx.n.n() == null) {
                return;
            }
            nVarS.n(com.byazt.mx.n.n());
            nVarS.n().show();
            str = "apk_size";
        } else if (intExtra == 20) {
            if (com.byazt.mx.s.n() == null || com.byazt.mx.s.qg() == null) {
                return;
            }
            nVarS.n(com.byazt.mx.s.n()).q(stringExtra4).n(com.byazt.mx.s.qg());
            nVarS.n().show();
            str = "download_percent_cancel";
        } else if (intExtra != 21) {
            str = "";
        } else {
            if (com.byazt.mx.qg.n() == null || com.byazt.mx.qg.qg() == null) {
                return;
            }
            nVarS.n(com.byazt.mx.qg.n()).q(stringExtra4).n(com.byazt.mx.qg.qg());
            nVarS.n().show();
            str = "apk_size_cancel";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.qg = true;
        this.s = qgVarQ;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
            jSONObject.putOpt("download_percent", Integer.valueOf(iN));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException unused) {
        }
        if (TextUtils.equals(str, "download_percent") || TextUtils.equals(str, "apk_size")) {
            com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVarQ);
        } else if (TextUtils.equals(str, "download_percent_cancel") || TextUtils.equals(str, "apk_size_cancel")) {
            com.byazt.vj.n.n().n("pause_cancel_optimise", jSONObject, qgVarQ);
        }
    }

    private void n(long j, String str) {
        if (k.n() == null) {
            return;
        }
        qg qgVarQ = w.n().q(j);
        if (qgVarQ != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVarQ.um());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - qgVarQ.rf()));
                jSONObject.putOpt("click_download_size", Long.valueOf(qgVarQ.dh()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                com.byazt.vj.n.n().n("cancel_pause_reserve_wifi_dialog_show", jSONObject, qgVarQ);
            } else {
                com.byazt.vj.n.n().qg("pause_reserve_wifi_dialog_show", jSONObject, qgVarQ);
            }
        }
        l.n nVarN = new l.n(this).n(false).n(k.n());
        if (!TextUtils.isEmpty(str)) {
            nVarN.q(str).n(k.qg());
        }
        nVarN.n().show();
        this.qg = true;
        this.s = qgVarQ;
    }

    private void qg(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            s.n((Activity) this);
            return;
        }
        py pyVar = new py() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            public WeakReference<Activity> s;

            {
                this.s = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.byazt.ky.py
            public void n() {
                com.byazt.rz.tj.n(str);
                s.n(this.s.get());
            }

            @Override // com.byazt.ky.py
            public void n(String str2) {
                com.byazt.rz.tj.n(str, str2);
                s.n(this.s.get());
            }
        };
        try {
            d.l().n(this, strArr, pyVar);
        } catch (Exception e) {
            d.a().n(e, "requestPermission");
            pyVar.n();
        }
    }

    private void n(String str) {
        if (TextUtils.isEmpty(str)) {
            s.n((Activity) this);
            return;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            if (com.byazt.f.n.s().n("fix_app_link_flag")) {
                intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intent);
        } catch (Exception unused) {
        } finally {
            s.n((Activity) this);
        }
    }

    private void qg(String str) {
        Intent intentX = oa.x(this, str);
        if (intentX == null) {
            s.n((Activity) this);
            return;
        }
        try {
            intentX.addFlags(C.ENCODING_PCM_MU_LAW);
            intentX.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intentX);
        } catch (Exception unused) {
        } finally {
            s.n((Activity) this);
        }
    }

    private void qg(long j) {
        final qg qgVarQ = w.n().q(j);
        if (qgVarQ == null) {
            com.byazt.ch.s.n().n("showOpenAppDialogInner nativeModel null");
            s.n((Activity) this);
            return;
        }
        com.byazt.ky.oa oaVarS = d.s();
        com.byazt.os.qg.n nVarN = new com.byazt.os.qg.n(this).n("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(qgVarQ.dg()) ? "刚刚下载的应用" : qgVarQ.dg();
        oaVarS.qg(nVarN.qg(String.format("%1$s已安装完成，是否立即打开？", objArr)).s("打开").q("取消").n(false).n(oa.q(this, qgVarQ.l())).n(new com.byazt.os.qg.InterfaceC0286qg() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void n(DialogInterface dialogInterface) {
                com.byazt.t.n.qg(qgVarQ);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                s.n((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void qg(DialogInterface dialogInterface) {
                com.byazt.vj.n.n().qg("market_openapp_cancel", qgVarQ);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                s.n((Activity) TTDelegateActivity.this);
            }

            @Override // com.byazt.os.qg.InterfaceC0286qg
            public void s(DialogInterface dialogInterface) {
                s.n((Activity) TTDelegateActivity.this);
            }
        }).n(2).n());
        com.byazt.vj.n.n().qg("market_openapp_window_show", qgVarQ);
    }

    private void s(long j) {
        new com.byazt.su.n(this, j).show();
    }
}
