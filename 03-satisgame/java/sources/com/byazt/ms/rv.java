package com.byazt.ms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.je.bb;
import com.byazt.je.t;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.ky.a;
import com.byazt.ky.cd;
import com.byazt.ky.cp;
import com.byazt.ky.oa;
import com.byazt.ky.py;
import com.byazt.ky.um;
import com.byazt.m.IDownloadHttpService;
import com.byazt.q.AdBaseConstants;
import com.byazt.tk.k;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.DownloaderBuilder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static com.byazt.mi.qg fs;
    public static volatile String n;
    public static final com.byazt.rn.n rv;
    public static ITTDownloadVisitor s;
    public static Context w;
    public static Map<Integer, com.byazt.ms.n.InterfaceC0249n> x;
    public static final AtomicBoolean q = new AtomicBoolean(false);
    public static final AtomicBoolean l = new AtomicBoolean(false);
    public static boolean qg = true;

    static {
        try {
            n = com.byazt.tk.w.n(getContext(), Environment.DIRECTORY_DOWNLOADS, false, null).getPath();
        } catch (Throwable unused) {
        }
        rv = new com.byazt.rn.n() { // from class: com.byazt.ms.rv.2
            @Override // com.byazt.rn.n
            public void n(DownloadInfo downloadInfo, String str) {
                rv.s(str);
            }
        };
    }

    public static void n(com.byazt.mi.qg qgVar) {
        fs = qgVar;
    }

    public static com.byazt.mi.qg n() {
        return fs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITTDownloadVisitor x() {
        if (s == null) {
            s = x.n();
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(String str) {
        com.byazt.h.qg qgVarN;
        JSONObject jSONObjectX;
        if (TextUtils.isEmpty(str) || (qgVarN = com.byazt.vl.w.n().n(str)) == null || (jSONObjectX = qgVarN.x()) == null || x() == null) {
            return;
        }
        x().checkAutoControl(jSONObjectX, str);
    }

    public static void n(Context context) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        if (context == null) {
            return;
        }
        String strQg = ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
        if (strQg != null && strQg.contains(":downloader") && com.byazt.nf.tj.l >= 7000) {
            com.byazt.xv.s.n(new w());
        }
        AtomicBoolean atomicBoolean = q;
        if (!atomicBoolean.get()) {
            synchronized (rv.class) {
                if (!atomicBoolean.get()) {
                    w = context.getApplicationContext();
                    if (x() != null) {
                        String strInitPath = x().initPath(qg);
                        if (!TextUtils.isEmpty(strInitPath)) {
                            n = strInitPath;
                        }
                    }
                    atomicBoolean.set(qg(w));
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = l;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((x() != null ? x().getTTDownloadEventLogger() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n = str;
    }

    public static com.byazt.s.tj qg() {
        n(getContext());
        return com.byazt.s.tj.n(getContext());
    }

    public static boolean n(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return qg().l().n(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean n(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return qg().l().n(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean n(Uri uri) {
        return com.byazt.t.tj.n(uri);
    }

    public static void s() {
        qg().x();
        if (x() != null) {
            x().clearAllData(n);
        }
    }

    public static void n(int i) {
        Map<Integer, com.byazt.ms.n.InterfaceC0249n> map = x;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void n(int i, com.byazt.ms.n.InterfaceC0249n interfaceC0249n) {
        if (interfaceC0249n != null) {
            if (x == null) {
                x = Collections.synchronizedMap(new WeakHashMap());
            }
            x.put(Integer.valueOf(i), interfaceC0249n);
        }
    }

    public static Map<Integer, com.byazt.ms.n.InterfaceC0249n> q() {
        return x;
    }

    public static boolean n(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, com.byazt.ms.n.InterfaceC0249n> mapQ;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapQ = q()) != null) {
            for (Map.Entry<Integer, com.byazt.ms.n.InterfaceC0249n> entry : mapQ.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                com.byazt.ms.n.InterfaceC0249n value = entry.getValue();
                if (value != null) {
                    boolean zN = value.n(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zN) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean fs() {
        return "internal".equals(com.byazt.nf.tj.rv);
    }

    private static boolean qg(final Context context) {
        com.byazt.cc.n nVarN;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (fs()) {
            try {
                nVarN = com.byazt.s.tj.n(applicationContext).n(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable unused) {
                nVarN = com.byazt.s.tj.n(applicationContext).n();
            }
        } else {
            nVarN = com.byazt.s.tj.n(applicationContext).n();
        }
        if (nVarN == null) {
            return false;
        }
        nVarN.n(new q()).n(new qg()).n(new l(applicationContext)).n(new s()).n(new com.byazt.z.x() { // from class: com.byazt.ms.rv.9
            @Override // com.byazt.z.x
            public Uri n(int i, String str, String str2) {
                return tj.n(context).n(str, str2);
            }
        }).n(new com.byazt.z.s() { // from class: com.byazt.ms.rv.8
            @Override // com.byazt.z.s
            public Map<String, Object> n(Object obj) {
                return tj.n(context).n(obj);
            }
        }).n(new cp() { // from class: com.byazt.ms.rv.7
            @Override // com.byazt.ky.cp
            public JSONObject n() {
                return rv.rv();
            }
        }).n(new n()).n(new com.byazt.ky.qg() { // from class: com.byazt.ms.rv.6
            @Override // com.byazt.ky.qg
            public boolean n() {
                if (rv.x() != null) {
                    return rv.x().getAppIsBackground();
                }
                return false;
            }
        }).n(new com.byazt.os.n.C0285n().qg("143").n("open_news").s(com.byazt.nf.tj.w).q(String.valueOf(com.byazt.nf.tj.l)).n()).n(new cd() { // from class: com.byazt.ms.rv.5
            @Override // com.byazt.ky.cd
            public byte[] n(byte[] bArr, int i) {
                return new byte[0];
            }
        }).n(packageName + ".TTFileProvider").n(new a() { // from class: com.byazt.ms.rv.4
            @Override // com.byazt.ky.a
            public void n(Context context2, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i) {
                rv.qg(downloadModel);
            }
        }).n(new com.byazt.ky.s() { // from class: com.byazt.ms.rv.1
            @Override // com.byazt.ky.s
            public void n(Context context2, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                rv.qg(downloadModel);
            }
        }).n(n(applicationContext, rv())).n();
        com.byazt.rz.n.n();
        if (!com.byazt.nf.tj.rv.equals("internal")) {
            com.byazt.s.tj.n(applicationContext).q().n(1);
            com.byazt.s.tj.n(applicationContext).n(rv);
            com.byazt.e.q.cp().n(new bb() { // from class: com.byazt.ms.rv.10
                @Override // com.byazt.je.bb
                public boolean n(Intent intent) {
                    return false;
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(DownloadModel downloadModel) {
        JSONObject extra;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null || (extra = downloadModel.getExtra()) == null || (jSONObjectOptJSONObject = extra.optJSONObject("open_ad_sdk_download_extra")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("material_meta");
        String strOptString2 = jSONObjectOptJSONObject.optString("tag");
        if (TextUtils.isEmpty(strOptString) || !strOptString.contains("self_reward_callback")) {
            return;
        }
        com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
        lVarS.n("save_jump_success_time", System.currentTimeMillis());
        lVarS.n("save_jump_success_ad_tag", strOptString2);
        lVarS.n("save_download_open_app_success_meta", strOptString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject rv() {
        try {
            ITTDownloadVisitor iTTDownloadVisitorX = x();
            if (iTTDownloadVisitorX != null) {
                JSONObject downloadSettings = iTTDownloadVisitorX.getDownloadSettings();
                if (downloadSettings.optInt("enable_app_install_receiver", 1) == 0) {
                    downloadSettings.put("enable_app_install_receiver", 0);
                }
                return downloadSettings;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static DownloaderBuilder n(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new t() { // from class: com.byazt.ms.rv.11
            @Override // com.byazt.je.t
            public JSONObject n() {
                return rv.rv();
            }
        }).httpService(new w());
    }

    public static boolean n(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listQg = com.byazt.e.q.cp().qg(context);
            if (!listQg.isEmpty()) {
                for (DownloadInfo downloadInfo : listQg) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Context getContext() {
        Context context = w;
        return context == null ? com.byazt.nf.rv.getContext() : context;
    }

    public static Bundle n(com.byazt.esa.n nVar, int i) {
        String str;
        boolean z;
        String str2;
        Bundle bundle = new Bundle();
        try {
            if (i == 101) {
                boolean zQg = com.byazt.vgx.w.qg(nVar.s());
                String str3 = zQg ? "open" : "install";
                if (zQg) {
                    com.byazt.vl.x xVarN = com.byazt.rz.rv.n(nVar.s());
                    str2 = xVarN.getType() + "_" + xVarN.n() + "_" + xVarN.qg();
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "open ".concat(String.valueOf(str2)));
                    z = true;
                } else {
                    boolean zN = com.byazt.e.q.n(w, nVar.q());
                    if (zN) {
                        str = "mem install";
                    } else {
                        str = "cache install";
                        zN = com.byazt.e.q.n(w, n(nVar.tj(), nVar.rv()));
                    }
                    String str4 = str;
                    z = zN;
                    str2 = str4;
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "install ".concat(String.valueOf(z)));
                }
                com.byazt.iz.l.n(nVar.x(), nVar, str3, "media_install", str2, z ? "success" : "failure");
            } else {
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "event_type:" + i + " not support");
                com.byazt.iz.l.n(nVar.x(), nVar, "notSupport_".concat(String.valueOf(i)), "media_install", "error", "failure");
            }
        } catch (Exception e) {
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
        }
        return bundle;
    }

    private static int n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strL = com.byazt.ta.w.l(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strL)) {
            return 0;
        }
        return strL.hashCode();
    }

    @com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME})
    private static class q implements com.byazt.ky.rv {
        @Override // com.byazt.ky.rv
        public void n(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.byazt.ky.rv
        public void n(Activity activity, String[] strArr, final py pyVar) {
            if (rv.x() != null) {
                rv.x().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.byazt.ms.rv.q.1
                    @Override // com.byazt.ms.ITTPermissionCallback
                    public void onGranted() {
                        py pyVar2 = pyVar;
                        if (pyVar2 != null) {
                            pyVar2.n();
                        }
                    }

                    @Override // com.byazt.ms.ITTPermissionCallback
                    public void onDenied(String str) {
                        py pyVar2 = pyVar;
                        if (pyVar2 != null) {
                            pyVar2.n(str);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.ky.rv
        public boolean n(Context context, String str) {
            if (rv.x() != null) {
                return rv.x().hasPermission(context, str);
            }
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, 160})
    private static class n implements com.byazt.ky.tj {
        private n() {
        }

        @Override // com.byazt.ky.tj
        public boolean n(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            ITTDownloadVisitor iTTDownloadVisitorX = rv.x();
            if (iTTDownloadVisitorX != null) {
                return iTTDownloadVisitorX.pushUnfinishedMessage(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.byazt.ky.tj
        public boolean qg(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            ITTDownloadVisitor iTTDownloadVisitorX = rv.x();
            if (iTTDownloadVisitorX != null) {
                return iTTDownloadVisitorX.pushUnInstalledMessage(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.byazt.ky.tj
        public boolean n(DownloadModel downloadModel) {
            ITTDownloadVisitor iTTDownloadVisitorX = rv.x();
            if (iTTDownloadVisitorX != null) {
                return iTTDownloadVisitorX.pushUnActiveFromMarketMessage(downloadModel);
            }
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME})
    private static class s implements com.byazt.ky.fs {
        private s() {
        }

        @Override // com.byazt.ky.fs
        public void n(String str, String str2, Map<String, Object> map, final um umVar) {
            str.hashCode();
            int i = 1;
            if (!str.equals(TapHttp.METHOD_GET) && str.equals(TapHttp.METHOD_POST)) {
                i = 2;
            }
            if (rv.x() != null) {
                rv.x().execute(i, str2, map, new ITTHttpCallback() { // from class: com.byazt.ms.rv.s.1
                    @Override // com.byazt.ms.ITTHttpCallback
                    public void onResponse(String str3) {
                        um umVar2 = umVar;
                        if (umVar2 != null) {
                            umVar2.n(str3);
                        }
                    }

                    @Override // com.byazt.ms.ITTHttpCallback
                    public void onError(Throwable th) {
                        um umVar2 = umVar;
                        if (umVar2 != null) {
                            umVar2.n(th);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.ky.fs
        public void n(String str, byte[] bArr, String str2, int i, final um umVar) {
            if (rv.x() != null) {
                rv.x().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.byazt.ms.rv.s.2
                    @Override // com.byazt.ms.ITTHttpCallback
                    public void onResponse(String str3) {
                        um umVar2 = umVar;
                        if (umVar2 != null) {
                            umVar2.n(str3);
                        }
                    }

                    @Override // com.byazt.ms.ITTHttpCallback
                    public void onError(Throwable th) {
                        um umVar2 = umVar;
                        if (umVar2 != null) {
                            umVar2.n(th);
                        }
                    }
                });
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, 1098})
    public static class w implements IDownloadHttpService {
        @Override // com.byazt.m.IDownloadHttpService
        public com.byazt.m.rv downloadWithConnection(int i, String str, List<com.byazt.wm.s> list) throws IOException {
            final fs.n nVarN = fs.n(str, list);
            if (nVarN != null) {
                return new com.byazt.m.rv() { // from class: com.byazt.ms.rv.w.1
                    @Override // com.byazt.m.x
                    public void s() {
                    }

                    @Override // com.byazt.m.rv
                    public InputStream n() {
                        return nVarN.n;
                    }

                    @Override // com.byazt.m.x
                    public String n(String str2) {
                        if (nVarN.qg != null) {
                            return nVarN.qg.get(str2);
                        }
                        return null;
                    }

                    @Override // com.byazt.m.x
                    public int qg() {
                        return nVarN.s;
                    }

                    @Override // com.byazt.m.rv
                    public void q() {
                        try {
                            nVarN.q.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                };
            }
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, 1097})
    public static class l implements oa {
        public final WeakReference<Context> n;

        public l(Context context) {
            this.n = new WeakReference<>(context);
        }

        @Override // com.byazt.ky.oa
        public void n(int i, final Context context, DownloadModel downloadModel, final String str, Drawable drawable, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                com.byazt.ag.qg.n((Runnable) new com.byazt.qit.x("tt_download_toast") { // from class: com.byazt.ms.rv.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, str, 0).show();
                    }
                });
            } catch (Exception e) {
                k.qg("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.byazt.ky.oa
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public AlertDialog qg(com.byazt.os.qg qgVar) {
            if (qgVar != null && rv.x() != null) {
                if (qgVar.n != null && (qgVar.n instanceof Activity)) {
                    return rv.x().showDialogBySelf((Activity) qgVar.n, qgVar.tj == 1, s(qgVar));
                }
                rv.x().showDialogByDelegate(this.n, qgVar.tj == 1, s(qgVar));
            }
            return null;
        }

        private DialogBuilder s(final com.byazt.os.qg qgVar) {
            return DialogBuilder.builder().setTitle(qgVar.qg).setMessage(qgVar.s).setNegativeBtnText(qgVar.l).setPositiveBtnText(qgVar.q).setIcon(qgVar.x).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.byazt.ms.rv.l.2
                @Override // com.byazt.ms.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    if (qgVar.fs != null) {
                        qgVar.fs.n(dialogInterface);
                    }
                }

                @Override // com.byazt.ms.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    if (qgVar.fs != null) {
                        try {
                            qgVar.fs.qg(dialogInterface);
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // com.byazt.ms.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (qgVar.fs != null) {
                        qgVar.fs.s(dialogInterface);
                    }
                }
            });
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, 529})
    public static class qg implements com.byazt.ky.x {
        @Override // com.byazt.ky.x
        public void n(com.byazt.os.s sVar) {
            n(sVar, true);
        }

        @Override // com.byazt.ky.x
        public void qg(com.byazt.os.s sVar) {
            n(sVar, false);
            s(sVar);
        }

        private void s(com.byazt.os.s sVar) {
            if (sVar == null) {
                return;
            }
            Object objD = sVar.d();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(sVar.qg()).setExtJson(sVar.fs()).setMaterialMeta(objD instanceof JSONObject ? (JSONObject) objD : null).setLabel(sVar.s());
            boolean z = "download_notification".equals(sVar.qg()) || "landing_h5_download_ad_button".equals(sVar.qg());
            if (rv.x() != null) {
                rv.x().executeLogUpload(label, z);
            }
        }

        private void n(com.byazt.os.s sVar, boolean z) {
            com.byazt.ms.qg tTDownloadEventLogger;
            if (rv.x() == null || (tTDownloadEventLogger = rv.x().getTTDownloadEventLogger()) == null || sVar == null) {
                return;
            }
            if (tTDownloadEventLogger.n() && rv.x().isOpenSdkEvent(sVar.toString())) {
                return;
            }
            if (z) {
                rv.qg(sVar);
            } else {
                rv.qg(sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject qg(com.byazt.os.s sVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", sVar.n());
            jSONObject.put("tag", sVar.qg());
            jSONObject.put("label", sVar.s());
            jSONObject.put("isAd", sVar.q());
            jSONObject.put("adId", sVar.l());
            jSONObject.put("logExtra", sVar.w());
            jSONObject.put("extValue", sVar.x());
            jSONObject.put("extJson", sVar.fs());
            jSONObject.put("paramsJson", sVar.rv());
            jSONObject.put("eventSource", sVar.cp());
            jSONObject.put("extraObject", sVar.d());
            jSONObject.put("clickTrackUrl", sVar.tj());
            jSONObject.put("isV3", sVar.oa());
            jSONObject.put("V3EventName", sVar.sz());
            jSONObject.put("V3EventParams", sVar.k());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static boolean n(Activity activity, final com.byazt.mi.n nVar) {
        return com.byazt.bn.n.n().n(activity, false, new com.byazt.bn.n.InterfaceC0138n() { // from class: com.byazt.ms.rv.3
            @Override // com.byazt.bn.n.InterfaceC0138n
            public void n() {
                com.byazt.mi.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n();
                }
            }
        });
    }
}
