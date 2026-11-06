package com.umeng.commonsdk.deeplink;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.analytics.pro.ab;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class UMCommonDeepLink {
    private static volatile UMCommonDeepLink sInstance;
    private static volatile a sPendingAttribution;
    private static volatile b sPendingInstall;
    private UMCommonDeepLinkCallback mCallback;
    private Handler mCallbackHandler;

    private UMCommonDeepLink() {
    }

    public static UMCommonDeepLink getInstance() {
        if (sInstance == null) {
            synchronized (UMCommonDeepLink.class) {
                if (sInstance == null) {
                    sInstance = new UMCommonDeepLink();
                }
            }
        }
        return sInstance;
    }

    public void setCallback(UMCommonDeepLinkCallback uMCommonDeepLinkCallback, Handler handler) {
        this.mCallback = uMCommonDeepLinkCallback;
        this.mCallbackHandler = handler;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] setCallback: registered, handler=".concat(handler != null ? "custom" : "mainThread"));
    }

    public void getInstallParams(Context context, Handler handler, InstallParamsCallback installParamsCallback) {
        Map<String, Object> mapA;
        if (context == null || installParamsCallback == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (d.b(applicationContext) && (mapA = d.a(applicationContext)) != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] getInstallParams: cache hit");
                callbackInstallSuccess(handler, installParamsCallback, mapA);
                return;
            }
            if (UMConfigure.needSendZcfgEnv(applicationContext)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] getInstallParams: pending for ZERO_RECV_RESPONSE");
                b bVar = new b(applicationContext, handler, installParamsCallback);
                sPendingInstall = bVar;
                scheduleTimeout(applicationContext, bVar);
                return;
            }
            if (!UMConfigure.getInitStatus()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] getInstallParams: pending for LOAD_CFGFD_COMPLETE");
                b bVar2 = new b(applicationContext, handler, installParamsCallback);
                sPendingInstall = bVar2;
                scheduleTimeout(applicationContext, bVar2);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] getInstallParams: execute immediately");
            dispatchInstallRequest(applicationContext, handler, installParamsCallback);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            callbackInstallFailure(handler, installParamsCallback, -3, "内部错误。");
        }
    }

    public boolean handleOpenURL(Context context, Uri uri) {
        if (uri == null) {
            return false;
        }
        return handleOpenURL(context, uri.toString());
    }

    public boolean handleOpenURL(Context context, String str) {
        return processUrlInternal(context, str, "url");
    }

    public boolean handlePasteboardURL(Context context, String str) {
        return processUrlInternal(context, str, "pb_url");
    }

    private boolean processUrlInternal(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Context applicationContext = context.getApplicationContext();
                Uri uri = Uri.parse(str);
                String queryParameter = uri.getQueryParameter("_umlnk_refid");
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processUrl: urlKey=" + str2 + ", url=" + str);
                if (TextUtils.isEmpty(queryParameter)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processUrl: no _umlnk_refid found");
                    return false;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processUrl: _umlnk_refid=" + queryParameter);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processUrl: callback ".concat(this.mCallback != null ? "will fire" : "is null, skip"));
                if (this.mCallback != null) {
                    final Map<String, Object> mapBuildHandleOpenURLParams = buildHandleOpenURLParams(uri);
                    Handler handler = this.mCallbackHandler;
                    if (handler == null) {
                        handler = new Handler(Looper.getMainLooper());
                    }
                    final UMCommonDeepLinkCallback uMCommonDeepLinkCallback = this.mCallback;
                    handler.post(new Runnable() { // from class: com.umeng.commonsdk.deeplink.UMCommonDeepLink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                uMCommonDeepLinkCallback.onResolveDeepLink(mapBuildHandleOpenURLParams);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
                dispatchAttribution(applicationContext, str, queryParameter, str2);
                return true;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
        return false;
    }

    public static void processPendingTasks(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        b bVar = sPendingInstall;
        if (bVar != null && !bVar.d) {
            bVar.d = true;
            sPendingInstall = null;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processPending: dispatch install request");
            getInstance().dispatchInstallRequest(applicationContext, bVar.b, bVar.c);
        }
        a aVar = sPendingAttribution;
        if (aVar == null || aVar.e) {
            return;
        }
        if (TextUtils.isEmpty(ab.a().d(applicationContext))) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processPending: attribution held, sessionId still empty, wait for START_SESSION");
            return;
        }
        aVar.e = true;
        sPendingAttribution = null;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processPending: dispatch attribution report");
        UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.I, com.umeng.commonsdk.internal.b.a(applicationContext).a(), aVar);
    }

    public static void executeInstallRequest(Object obj) {
        if (obj instanceof b) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] executeInstallRequest: start DDL request");
            b bVar = (b) obj;
            final Context context = bVar.a;
            final Handler handler = bVar.b;
            final InstallParamsCallback installParamsCallback = bVar.c;
            try {
                f.a(g.a(context), new f.a() { // from class: com.umeng.commonsdk.deeplink.UMCommonDeepLink.2
                    @Override // com.umeng.commonsdk.deeplink.f.a
                    public void a(JSONObject jSONObject, String str, String str2) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL onSuccess: path=" + str + ", refId=" + str2);
                        d.a(context, jSONObject, str);
                        Map mapA = d.a(context);
                        if (mapA == null) {
                            mapA = new HashMap();
                        }
                        UMCommonDeepLink.callbackInstallSuccess(handler, installParamsCallback, mapA);
                    }

                    @Override // com.umeng.commonsdk.deeplink.f.a
                    public void a(int i, Throwable th) {
                        String message = th != null ? th.getMessage() : "Unknown error";
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL onFailure: code=" + i + ", msg=" + message);
                        UMCommonDeepLink.callbackInstallFailure(handler, installParamsCallback, i, message);
                    }
                });
            } catch (Throwable th) {
                callbackInstallFailure(handler, installParamsCallback, -4, "Request error: " + th.getMessage());
            }
        }
    }

    public static void executeAttributionReport(Object obj) {
        if (obj instanceof a) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] executeAttributionReport: start");
            a aVar = (a) obj;
            c.a(aVar.a, aVar.b, aVar.c, aVar.d);
        }
    }

    public static void handleTimeout(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.d) {
                return;
            }
            bVar.d = true;
            sPendingInstall = null;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] timeout: callback with error");
            callbackInstallFailure(bVar.b, bVar.c, -5, "处理超时。");
        }
    }

    public static void processPendingAttributionOnSessionStart(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        a aVar = sPendingAttribution;
        if (aVar == null || aVar.e) {
            return;
        }
        aVar.e = true;
        sPendingAttribution = null;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] processPendingOnSessionStart: dispatch attribution report");
        UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.I, com.umeng.commonsdk.internal.b.a(applicationContext).a(), aVar);
    }

    private void dispatchInstallRequest(Context context, Handler handler, InstallParamsCallback installParamsCallback) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.H, com.umeng.commonsdk.internal.b.a(context).a(), new b(context, handler, installParamsCallback));
    }

    private void dispatchAttribution(Context context, String str, String str2, String str3) {
        a aVar = new a(context, str, str2, str3);
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] dispatchAttribution: pending for ZERO_RECV_RESPONSE");
            sPendingAttribution = aVar;
        } else if (!UMConfigure.getInitStatus()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] dispatchAttribution: pending for SDK init");
            sPendingAttribution = aVar;
        } else if (TextUtils.isEmpty(ab.a().d(context))) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] dispatchAttribution: pending for START_SESSION (sessionId empty)");
            sPendingAttribution = aVar;
        } else {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] dispatchAttribution: execute immediately");
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.I, com.umeng.commonsdk.internal.b.a(context).a(), aVar);
        }
    }

    private void scheduleTimeout(Context context, b bVar) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.J, com.umeng.commonsdk.internal.b.a(context).a(), bVar, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callbackInstallSuccess(Handler handler, final InstallParamsCallback installParamsCallback, final Map<String, Object> map) {
        if (installParamsCallback == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] callbackInstallSuccess: params=" + (map != null ? map.toString() : AbstractJsonLexerKt.NULL));
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.umeng.commonsdk.deeplink.UMCommonDeepLink.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    installParamsCallback.onSuccess(map);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callbackInstallFailure(Handler handler, final InstallParamsCallback installParamsCallback, final int i, final String str) {
        if (installParamsCallback == null) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] callbackInstallFailure: code=" + i + ", msg=" + str);
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.umeng.commonsdk.deeplink.UMCommonDeepLink.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    installParamsCallback.onFailure(i, str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static Map<String, Object> buildHandleOpenURLParams(Uri uri) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null) {
            for (String str : queryParameterNames) {
                map2.put(str, uri.getQueryParameter(str));
            }
        }
        map.put("install_params", map2);
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            map.put("install_path", path);
        }
        return map;
    }

    static class b {
        final Context a;
        final Handler b;
        final InstallParamsCallback c;
        volatile boolean d = false;

        b(Context context, Handler handler, InstallParamsCallback installParamsCallback) {
            this.a = context;
            this.b = handler;
            this.c = installParamsCallback;
        }
    }

    static class a {
        final Context a;
        final String b;
        final String c;
        final String d;
        volatile boolean e = false;

        a(Context context, String str, String str2, String str3) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = TextUtils.isEmpty(str3) ? "url" : str3;
        }
    }
}
