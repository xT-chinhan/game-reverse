package com.tapsdk.tapad.internal.runtime.web;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.byazt.ewn.AbsServerManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import com.umeng.analytics.pro.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DirichletCreativeView extends FrameLayout {
    private static final int MAX_ARCHIVE_BYTES = 33554432;
    private DirichletCreativeWebBridge bridge;
    private String currentConfig;
    private volatile boolean destroyed;
    private final AtomicInteger generation;
    private final int instanceId;
    private final ExecutorService io;
    private final Handler main;
    private final DirichletRuntime runtime;
    private final int surfaceId;
    private volatile boolean webMediaMuted;
    private WebView webView;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView$1, reason: invalid class name */
    public class AnonymousClass1 implements DirichletCreativeWebBridge.Listener {
        final /* synthetic */ WebView val$next;
        final /* synthetic */ int val$token;

        public AnonymousClass1(int i, WebView webView) {
            this.val$token = i;
            this.val$next = webView;
        }

        /* JADX INFO: renamed from: lambda$onAccepted$0$com-tapsdk-tapad-internal-runtime-web-DirichletCreativeView$1, reason: not valid java name */
        /* synthetic */ void m343lambda$onAccepted$0$comtapsdktapadinternalruntimewebDirichletCreativeView$1(int i, WebView webView) {
            if (DirichletCreativeView.this.isCurrent(i) && webView == DirichletCreativeView.this.webView) {
                webView.setVisibility(0);
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.web.DirichletCreativeWebBridge.Listener
        public void onAccepted(JSONObject jSONObject) {
            if ("creative.ready".equals(jSONObject.optString("type")) && DirichletCreativeView.this.isCurrent(this.val$token)) {
                Handler handler = DirichletCreativeView.this.main;
                final int i = this.val$token;
                final WebView webView = this.val$next;
                handler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m343lambda$onAccepted$0$comtapsdktapadinternalruntimewebDirichletCreativeView$1(i, webView);
                    }
                });
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.web.DirichletCreativeWebBridge.Listener
        public void onRejected(String str, String str2) {
        }
    }

    public DirichletCreativeView(Context context, DirichletRuntime dirichletRuntime, int i, int i2) {
        super(context);
        this.main = new Handler(Looper.getMainLooper());
        this.io = Executors.newSingleThreadExecutor();
        this.generation = new AtomicInteger();
        this.runtime = dirichletRuntime;
        this.instanceId = i;
        this.surfaceId = i2;
        setClipChildren(true);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void destroyMountedWebView() {
        DirichletCreativeWebBridge dirichletCreativeWebBridge = this.bridge;
        if (dirichletCreativeWebBridge != null) {
            dirichletCreativeWebBridge.detach();
            this.bridge = null;
        }
        WebView webView = this.webView;
        if (webView != null) {
            this.webView = null;
            removeView(webView);
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.removeAllViews();
            webView.destroy();
        }
    }

    private void dispatchHostError(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "creative.host_error");
            jSONObject.put("bridge_version", DirichletCreativeWebBridge.BRIDGE_VERSION);
            jSONObject.put("nonce", str2);
            jSONObject.put("session_id", str3);
            jSONObject.put("creative_key", str);
            jSONObject.put(MediationConstant.KEY_REASON, str4);
            this.runtime.dispatchCreativeWebEvent(this.instanceId, this.surfaceId, jSONObject.toString());
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrent(int i) {
        return !this.destroyed && this.generation.get() == i;
    }

    private static Set<String> jsonStrings(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!strOptString.isEmpty()) {
                    hashSet.add(strOptString);
                }
            }
        }
        return hashSet;
    }

    private void mount(DirichletCreativePackage dirichletCreativePackage, JSONObject jSONObject, Set<String> set, JSONObject jSONObject2, int i) {
        destroyMountedWebView();
        try {
            try {
                jSONObject.put("media_muted", this.webMediaMuted);
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
        }
        WebView webView = new WebView(getContext());
        webView.setVisibility(4);
        addView(webView, new FrameLayout.LayoutParams(-1, -1));
        DirichletCreativeWebBridge dirichletCreativeWebBridge = new DirichletCreativeWebBridge(this.runtime, this.instanceId, this.surfaceId, jSONObject, set, jsonStrings(jSONObject2.optJSONArray("allowed_actions")), new AnonymousClass1(i, webView));
        this.bridge = dirichletCreativeWebBridge;
        this.webView = webView;
        dirichletCreativePackage.loadInto(webView, dirichletCreativeWebBridge, networkPolicy(jSONObject2));
    }

    private static JSONObject networkPolicy(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("network_policy");
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public void m342lambda$setPackageConfig$0$comtapsdktapadinternalruntimewebDirichletCreativeView(String str, final int i) {
        String str2 = "";
        String str3 = "n-" + UUID.randomUUID();
        String str4 = "s-" + UUID.randomUUID();
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (!"web-creative-host/v1".equals(jSONObject.optString("contract")) || jSONObject.optInt(BaseAdActivity.EXTRA_INSTANCE_ID, -1) != this.instanceId || jSONObject.optInt(BaseAdActivity.EXTRA_SURFACE_ID, -1) != this.surfaceId) {
                throw new Exception("WEB_CREATIVE_SURFACE_IDENTITY_MISMATCH");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            String string = jSONObject2.getString("creative_key");
            try {
                final DirichletCreativePackage dirichletCreativePackageOpenVerifiedArchive = DirichletCreativePackage.openVerifiedArchive(readRustOwnedArchive(jSONObject2.getString("archive_uri"), jSONObject2.optInt("maximum_archive_bytes", 33554432)), jSONObject2.getString("entrypoint"));
                final JSONObject jSONObject3 = new JSONObject(jSONObject.getJSONObject(d.R).toString());
                jSONObject3.put("bridge_version", DirichletCreativeWebBridge.BRIDGE_VERSION);
                jSONObject3.put("nonce", str3);
                jSONObject3.put("session_id", str4);
                jSONObject3.put("creative_key", string);
                jSONObject3.put("package_hash", jSONObject2.getString("package_hash"));
                jSONObject3.put("allowed_actions", jSONObject.optJSONArray("allowed_actions"));
                final Set<String> setJsonStrings = jsonStrings(jSONObject.optJSONArray("allowed_events"));
                jSONObject3.put("allowed_events", new JSONArray((Collection) setJsonStrings));
                jSONObject3.put("telemetry_schema", jSONObject.optJSONObject("telemetry_schema"));
                jSONObject3.put("network_policy", jSONObject.optJSONObject("network_policy"));
                this.main.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m341lambda$prepare$1$comtapsdktapadinternalruntimewebDirichletCreativeView(i, dirichletCreativePackageOpenVerifiedArchive, jSONObject3, setJsonStrings, jSONObject);
                    }
                });
            } catch (Throwable th) {
                th = th;
                str2 = string;
                if (isCurrent(i)) {
                    dispatchHostError(str2, str3, str4, th.getMessage() == null ? "WEB_CREATIVE_HOST_PREPARE_FAILED" : th.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] readBounded(InputStream inputStream, int i) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[16384];
                int i2 = 0;
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStream.close();
                        return byteArray;
                    }
                    i2 += i3;
                    if (i2 > i) {
                        throw new Exception("WEB_CREATIVE_ARCHIVE_TOO_LARGE");
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    private static byte[] readRustOwnedArchive(String str, int i) throws Exception {
        Uri uri = Uri.parse(str);
        int iMin = i > 0 ? Math.min(i, 33554432) : 33554432;
        if (!"file".equalsIgnoreCase(uri.getScheme()) || uri.getAuthority() != null || uri.getPath() == null) {
            throw new Exception("WEB_CREATIVE_LOCAL_ARCHIVE_URI_REQUIRED");
        }
        File file = new File(uri.getPath());
        if (!file.isFile() || file.length() <= 0 || file.length() > iMin) {
            throw new Exception("WEB_CREATIVE_LOCAL_ARCHIVE_INVALID");
        }
        return readBounded(new FileInputStream(file), iMin);
    }

    public void destroy() {
        if (this.destroyed) {
            return;
        }
        this.destroyed = true;
        this.generation.incrementAndGet();
        this.io.shutdownNow();
        destroyMountedWebView();
        removeAllViews();
    }

    /* JADX INFO: renamed from: lambda$prepare$1$com-tapsdk-tapad-internal-runtime-web-DirichletCreativeView, reason: not valid java name */
    /* synthetic */ void m341lambda$prepare$1$comtapsdktapadinternalruntimewebDirichletCreativeView(int i, DirichletCreativePackage dirichletCreativePackage, JSONObject jSONObject, Set set, JSONObject jSONObject2) {
        if (isCurrent(i)) {
            mount(dirichletCreativePackage, jSONObject, set, jSONObject2, i);
        }
    }

    public void onHostPause() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void onHostResume() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void setPackageConfig(final String str) {
        if (this.destroyed || str == null || str.isEmpty() || str.equals(this.currentConfig)) {
            return;
        }
        this.currentConfig = str;
        final int iIncrementAndGet = this.generation.incrementAndGet();
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(4);
        }
        this.io.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m342lambda$setPackageConfig$0$comtapsdktapadinternalruntimewebDirichletCreativeView(str, iIncrementAndGet);
            }
        });
    }

    public void setWebMediaMuted(boolean z) {
        this.webMediaMuted = z;
        final WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        final String str = z ? "true" : "false";
        webView.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.web.DirichletCreativeView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                webView.evaluateJavascript("(function(m){window.__dirichletWebMediaMuted=m;[].slice.call(document.querySelectorAll('video')).forEach(function(v){v.muted=m});return m})(" + str + ")", null);
            }
        });
    }
}
