package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.ny;
import com.ss.android.download.api.config.qv;
import com.ss.android.download.api.config.sl;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.downloadlib.ch;
import com.ss.android.socialbase.downloader.depend.cv;
import com.ss.android.socialbase.downloader.depend.op;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
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
public class ah {
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> ab;
    public static ITTDownloadVisitor ah;
    private static Context c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile String f3903ms;
    private static final com.ss.android.download.api.download.ms.ms x;
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static final AtomicBoolean ka = new AtomicBoolean(false);
    public static boolean xr = true;

    private static boolean ab() {
        return false;
    }

    static {
        try {
            f3903ms = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        x = new com.ss.android.download.api.download.ms.ms() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.6
            @Override // com.ss.android.download.api.download.ms.ms
            public void ms(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                ab.xr("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.ms.ms
            public void ms(DownloadInfo downloadInfo, String str) {
                ab.xr("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.ms.ms
            public void xr(DownloadInfo downloadInfo, String str) {
                ab.xr("TTDownloadVisitor", "completeListener: onInstalled");
                ah.ah(str);
            }

            @Override // com.ss.android.download.api.download.ms.ms
            public void ms(DownloadInfo downloadInfo, BaseException baseException, String str) {
                ab.xr("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.ms.ms
            public void ms(DownloadInfo downloadInfo) {
                ab.xr("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITTDownloadVisitor c() {
        ITTDownloadVisitor iTTDownloadVisitor = ah;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.ms.ms(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(String str) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        JSONObject jSONObjectAb;
        if (TextUtils.isEmpty(str) || (xrVarMs = c.ms().ms(str)) == null || (jSONObjectAb = xrVarMs.ab()) == null || c() == null) {
            return;
        }
        c().checkAutoControl(jSONObjectAb, str);
    }

    public static void ms(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        if (!d.get()) {
            try {
                com.ss.android.socialbase.appdownloader.d.ch().ms(true);
            } catch (Throwable unused) {
            }
            synchronized (ah.class) {
                AtomicBoolean atomicBoolean = d;
                if (!atomicBoolean.get()) {
                    c = context.getApplicationContext();
                    if (c() != null) {
                        String strInitPath = c().initPath(xr);
                        if (!TextUtils.isEmpty(strInitPath)) {
                            f3903ms = strInitPath;
                        }
                    }
                    atomicBoolean.set(xr(c));
                }
            }
        }
        if (d.get()) {
            AtomicBoolean atomicBoolean2 = ka;
            if (atomicBoolean2.compareAndSet(false, true)) {
                TTDownloadEventLogger tTDownloadEventLogger = c() != null ? c().getTTDownloadEventLogger() : null;
                if (tTDownloadEventLogger == null) {
                    atomicBoolean2.set(false);
                } else {
                    tTDownloadEventLogger.onDownloadConfigReady();
                }
            }
        }
    }

    public static void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f3903ms = str;
    }

    public static ch ms() {
        ms(getContext());
        return ch.ms(getContext());
    }

    public static boolean ms(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ms().ka().ms(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean ms(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ms().ka().ms(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean ms(Uri uri) {
        return com.ss.android.downloadlib.xr.ch.ms(uri);
    }

    public static void xr() {
        ms().ab();
        if (c() != null) {
            c().clearAllData(f3903ms);
        }
    }

    public static void ms(int i) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = ab;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void ms(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (ab == null) {
                ab = Collections.synchronizedMap(new WeakHashMap());
            }
            ab.put(Integer.valueOf(i), onEventLogHandler);
        }
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> ah() {
        return ab;
    }

    public static boolean ms(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> mapAh;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapAh = ah()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : mapAh.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean zOnEventLog = value.onEventLog(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zOnEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean xr(Context context) {
        com.ss.android.download.api.ms msVarMs;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (ab()) {
            try {
                msVarMs = ch.ms(applicationContext).ms("pangolin");
            } catch (Throwable unused) {
                msVarMs = ch.ms(applicationContext).ms();
            }
        } else {
            msVarMs = ch.ms(applicationContext).ms();
        }
        if (msVarMs == null) {
            return false;
        }
        msVarMs.ms(new C0333ah()).ms(new ms()).ms(new d(applicationContext)).ms(new xr()).ms(new com.ss.android.download.api.config.ch() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.3
            @Override // com.ss.android.download.api.config.ch
            public JSONObject ms() {
                return ah.x();
            }
        }).ms(new com.ss.android.download.api.config.xr() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.2
            @Override // com.ss.android.download.api.config.xr
            public boolean ms() {
                if (ah.c() != null) {
                    return ah.c().getAppIsBackground();
                }
                return false;
            }
        }).ms(new com.ss.android.download.api.model.ms.C0530ms().xr("143").ms("open_news").ah("6.9.2.3").d("6923").ms()).ms(new h() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.1
            @Override // com.ss.android.download.api.config.h
            public byte[] ms(byte[] bArr, int i) {
                return new byte[0];
            }
        }).ms(packageName + ".TTFileProvider").ms(ms(applicationContext, x())).ms();
        com.ss.android.downloadlib.ab.ms.ms();
        ch.ms(applicationContext).d().ms(1);
        ch.ms(applicationContext).ms(x);
        com.ss.android.socialbase.appdownloader.d.ch().ms(new cv() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.4
            @Override // com.ss.android.socialbase.downloader.depend.cv
            public boolean ms(Intent intent) {
                return false;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject x() {
        try {
            ITTDownloadVisitor iTTDownloadVisitorC = c();
            if (iTTDownloadVisitorC != null) {
                JSONObject downloadSettings = iTTDownloadVisitorC.getDownloadSettings();
                if (downloadSettings.optInt("enable_app_install_receiver", 1) == 0) {
                    downloadSettings.put("enable_app_install_receiver", 0);
                }
                return downloadSettings;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static DownloaderBuilder ms(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new op() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.5
            @Override // com.ss.android.socialbase.downloader.depend.op
            public JSONObject ms() {
                return ah.x();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new ka());
    }

    public static boolean ms(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listXr = com.ss.android.socialbase.appdownloader.d.ch().xr(context);
            if (!listXr.isEmpty()) {
                for (DownloadInfo downloadInfo : listXr) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Context getContext() {
        Context context = c;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.downloadnew.ah$ah, reason: collision with other inner class name */
    private static class C0333ah implements ny {
        @Override // com.ss.android.download.api.config.ny
        public void ms(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.ny
        public void ms(Activity activity, String[] strArr, final t tVar) {
            if (ah.c() != null) {
                ah.c().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.ah.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.ms();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.ms(str);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.ny
        public boolean ms(Context context, String str) {
            if (ah.c() != null) {
                return ah.c().hasPermission(context, str);
            }
            return false;
        }
    }

    private static class xr implements x {
        private xr() {
        }

        @Override // com.ss.android.download.api.config.x
        public void ms(String str, String str2, Map<String, Object> map, final qv qvVar) {
            str.hashCode();
            int i = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i = 1;
            }
            if (ah.c() != null) {
                ah.c().execute(i, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.xr.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        qv qvVar2 = qvVar;
                        if (qvVar2 != null) {
                            qvVar2.ms(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        qv qvVar2 = qvVar;
                        if (qvVar2 != null) {
                            qvVar2.ms(th);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.x
        public void ms(String str, byte[] bArr, String str2, int i, final qv qvVar) {
            if (ah.c() != null) {
                ah.c().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.xr.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        qv qvVar2 = qvVar;
                        if (qvVar2 != null) {
                            qvVar2.ms(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        qv qvVar2 = qvVar;
                        if (qvVar2 != null) {
                            qvVar2.ms(th);
                        }
                    }
                });
            }
        }
    }

    public static class ka implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public com.ss.android.socialbase.downloader.network.ny downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws IOException {
            final com.bytedance.sdk.openadsdk.downloadnew.xr.ms msVarMs = com.bytedance.sdk.openadsdk.downloadnew.xr.ms(str, list);
            if (msVarMs != null) {
                return new com.ss.android.socialbase.downloader.network.ny() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.ka.1
                    @Override // com.ss.android.socialbase.downloader.network.ab
                    public void ah() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.ny
                    public InputStream ms() {
                        return msVarMs.f3915ms;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.ab
                    public String ms(String str2) {
                        if (msVarMs.xr != null) {
                            return msVarMs.xr.get(str2);
                        }
                        return null;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.ab
                    public int xr() {
                        return msVarMs.ah;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.ny
                    public void d() {
                        try {
                            msVarMs.d.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                };
            }
            return null;
        }
    }

    public static class d implements sl {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<Context> f3906ms;

        public d(Context context) {
            this.f3906ms = new WeakReference<>(context);
        }

        @Override // com.ss.android.download.api.config.sl
        public void ms(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                com.ss.android.socialbase.downloader.ah.ms.ka("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.sl
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public AlertDialog xr(com.ss.android.download.api.model.xr xrVar) {
            if (xrVar != null && ah.c() != null) {
                if (xrVar.f4329ms != null && (xrVar.f4329ms instanceof Activity)) {
                    return ah.c().showDialogBySelf((Activity) xrVar.f4329ms, xrVar.ch == 1, ah(xrVar));
                }
                ah.c().showDialogByDelegate(this.f3906ms, xrVar.ch == 1, ah(xrVar));
            }
            return null;
        }

        private DialogBuilder ah(final com.ss.android.download.api.model.xr xrVar) {
            return DialogBuilder.builder().setTitle(xrVar.xr).setMessage(xrVar.ah).setNegativeBtnText(xrVar.ka).setPositiveBtnText(xrVar.d).setIcon(xrVar.ab).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.d.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    if (xrVar.x != null) {
                        xrVar.x.ms(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    if (xrVar.x != null) {
                        try {
                            xrVar.x.xr(dialogInterface);
                        } catch (Exception e) {
                            ab.ms(e);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (xrVar.x != null) {
                        xrVar.x.ah(dialogInterface);
                    }
                }
            });
        }
    }

    public static class ms implements com.ss.android.download.api.config.ab {
        @Override // com.ss.android.download.api.config.ab
        public void ms(com.ss.android.download.api.model.ah ahVar) {
            ab.xr("LibEventLogger", "onV3Event");
            ms(ahVar, true);
        }

        @Override // com.ss.android.download.api.config.ab
        public void xr(com.ss.android.download.api.model.ah ahVar) {
            ab.xr("LibEventLogger", "onEvent called");
            ms(ahVar, false);
            ah(ahVar);
        }

        private void ah(com.ss.android.download.api.model.ah ahVar) {
            if (ahVar == null) {
                return;
            }
            Object objSl = ahVar.sl();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(ahVar.xr()).setExtJson(ahVar.x()).setMaterialMeta(objSl instanceof JSONObject ? (JSONObject) objSl : null).setLabel(ahVar.ah());
            boolean z = "download_notification".equals(ahVar.xr()) || "landing_h5_download_ad_button".equals(ahVar.xr());
            if (ah.c() != null) {
                ah.c().executeLogUpload(label, z);
            }
        }

        private void ms(com.ss.android.download.api.model.ah ahVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (ah.c() == null || (tTDownloadEventLogger = ah.c().getTTDownloadEventLogger()) == null || ahVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && ah.c().isOpenSdkEvent(ahVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(ah.xr(ahVar));
            } else {
                tTDownloadEventLogger.onEvent(ah.xr(ahVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject xr(com.ss.android.download.api.model.ah ahVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", ahVar.ms());
            jSONObject.put(TTDownloadField.TT_TAG, ahVar.xr());
            jSONObject.put(TTDownloadField.TT_LABEL, ahVar.ah());
            jSONObject.put(TTDownloadField.TT_IS_AD, ahVar.d());
            jSONObject.put("adId", ahVar.ka());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, ahVar.c());
            jSONObject.put("extValue", ahVar.ab());
            jSONObject.put("extJson", ahVar.x());
            jSONObject.put(TTDownloadField.TT_PARAMS_JSON, ahVar.ny());
            jSONObject.put("eventSource", ahVar.hi());
            jSONObject.put(TTDownloadField.TT_EXTRA_OBJECT, ahVar.sl());
            jSONObject.put(TTDownloadField.TT_CLICK_TRACK_URL, ahVar.ch());
            jSONObject.put("isV3", ahVar.zb());
            jSONObject.put("V3EventName", ahVar.u());
            jSONObject.put("V3EventParams", ahVar.ub());
        } catch (JSONException e) {
            ab.ms(e);
        }
        return jSONObject;
    }

    public static boolean ms(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.ms.ms.ms().ms(activity, false, new com.ss.android.downloadlib.addownload.ms.ms.InterfaceC0535ms() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ah.7
            @Override // com.ss.android.downloadlib.addownload.ms.ms.InterfaceC0535ms
            public void ms() {
                ExitInstallListener exitInstallListener2 = exitInstallListener;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
