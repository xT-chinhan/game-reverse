package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.tapsdk.tapad.lottie.LottieAnimationView;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.LottieCompositionFactory;
import com.tapsdk.tapad.lottie.LottieResult;
import com.umeng.analytics.pro.an;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DirichletLottieView extends LottieAnimationView {
    private static final String BUNDLE_ASSET_SCHEME = "asset://";
    private static final OkHttpClient PROVIDER_LOTTIE_CLIENT;
    private static final String TAG = "DirichletLottieView";
    private volatile boolean autoplay;
    private volatile long loadGeneration;
    private volatile String pendingUrl;
    private volatile boolean playing;
    private volatile boolean released;

    static {
        OkHttpClient.Builder builderRetryOnConnectionFailure = new OkHttpClient.Builder().cache(null).retryOnConnectionFailure(false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PROVIDER_LOTTIE_CLIENT = builderRetryOnConnectionFailure.connectTimeout(12L, timeUnit).readTimeout(25L, timeUnit).build();
    }

    public DirichletLottieView(Context context) {
        super(context);
        this.autoplay = true;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public static String bundleAssetPath(String str) {
        if (str != null && !str.isEmpty() && str.startsWith(BUNDLE_ASSET_SCHEME)) {
            int i = 8;
            while (i < str.length() && str.charAt(i) == '/') {
                i++;
            }
            if (i < str.length()) {
                return str.substring(i);
            }
        }
        return null;
    }

    private void clearAnimationState() {
        this.playing = false;
        cancelAnimation();
        clearAnimation();
    }

    private static Object cloneJson(Object obj) {
        if (obj instanceof JSONObject) {
            return new JSONObject(obj.toString());
        }
        return obj instanceof JSONArray ? new JSONArray(obj.toString()) : obj;
    }

    private void fetchAndLoad(final String str, final long j) {
        AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.view.DirichletLottieView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m339lambda$fetchAndLoad$1$comtapsdktapadinternalruntimeviewDirichletLottieView(str, j);
            }
        });
    }

    private static Object findNext(JSONArray jSONArray, int i) {
        while (true) {
            i++;
            if (i >= jSONArray.length()) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(an.aB)) {
                return jSONObjectOptJSONObject.get(an.aB);
            }
        }
    }

    private static Object findPrev(JSONArray jSONArray, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                if (jSONObjectOptJSONObject.has("e")) {
                    return jSONObjectOptJSONObject.get("e");
                }
                if (jSONObjectOptJSONObject.has(an.aB)) {
                    return jSONObjectOptJSONObject.get(an.aB);
                }
            }
        }
        return null;
    }

    private boolean isCurrentLoad(String str, long j) {
        return !this.released && j == this.loadGeneration && str.equals(this.pendingUrl);
    }

    private String loadLottieJson(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (RustResolvedAsset.isLocalFileUri(str)) {
            try {
                return RustResolvedAsset.readUtf8Bounded(str, 4194304);
            } catch (IOException e) {
                return null;
            }
        }
        if (!str.startsWith(BUNDLE_ASSET_SCHEME)) {
            return readProviderLottieJson(str);
        }
        String strBundleAssetPath = bundleAssetPath(str);
        if (TextUtils.isEmpty(strBundleAssetPath)) {
            return null;
        }
        byte[] bundleAsset = DirichletRuntime.getInstance().readBundleAsset("core", strBundleAssetPath);
        if (bundleAsset == null && strBundleAssetPath.indexOf(46) < 0) {
            bundleAsset = DirichletRuntime.getInstance().readBundleAsset("core", strBundleAssetPath.concat(".json"));
        }
        if (bundleAsset == null) {
            return null;
        }
        return new String(bundleAsset, StandardCharsets.UTF_8);
    }

    private void onCompositionLoaded(LottieComposition lottieComposition) {
        setComposition(lottieComposition);
        if (this.autoplay || this.playing) {
            this.playing = true;
            if (isAttachedToWindow()) {
                playAnimation();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00a7 A[SYNTHETIC] */
    private String readProviderLottieJson(String str) {
        if (!str.startsWith("https://")) {
            return null;
        }
        try {
            Request requestBuild = new Request.Builder().url(str).get().build();
            for (int i = 0; i < 3; i++) {
                if (i > 0) {
                    try {
                        Thread.sleep(((long) i) * 400);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return null;
                    }
                }
                try {
                    Response responseExecute = PROVIDER_LOTTIE_CLIENT.newCall(requestBuild).execute();
                    try {
                        ResponseBody responseBodyBody = responseExecute.body();
                        if (responseExecute.isSuccessful() && responseBodyBody != null && responseBodyBody.contentLength() <= 4194304) {
                            InputStream inputStreamByteStream = responseBodyBody.byteStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[8192];
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = inputStreamByteStream.read(bArr);
                                        if (i3 == -1) {
                                            String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                                            byteArrayOutputStream.close();
                                            inputStreamByteStream.close();
                                            responseExecute.close();
                                            return string;
                                        }
                                        i2 += i3;
                                        if (i2 > 4194304) {
                                            byteArrayOutputStream.close();
                                            inputStreamByteStream.close();
                                            responseExecute.close();
                                            return null;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i3);
                                        if (inputStreamByteStream != null) {
                                            try {
                                                inputStreamByteStream.close();
                                            } catch (Throwable th) {
                                                th.addSuppressed(th);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th4) {
                                if (inputStreamByteStream != null) {
                                    inputStreamByteStream.close();
                                }
                                throw th4;
                            }
                        }
                        responseExecute.close();
                        return null;
                    } catch (Throwable th5) {
                        if (responseExecute != null) {
                            try {
                                responseExecute.close();
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e2) {
                }
            }
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        }
    }

    private static void sanitizeKeyframes(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                boolean zHas = jSONObjectOptJSONObject.has(an.aB);
                boolean zHas2 = jSONObjectOptJSONObject.has("e");
                if (zHas || zHas2) {
                    if (!zHas) {
                        Object objFindPrev = findPrev(jSONArray, i);
                        if (objFindPrev == null && zHas2) {
                            objFindPrev = jSONObjectOptJSONObject.get("e");
                        }
                        if (objFindPrev != null) {
                            jSONObjectOptJSONObject.put(an.aB, cloneJson(objFindPrev));
                        }
                    }
                    if (!zHas2) {
                        Object objFindNext = findNext(jSONArray, i);
                        if (objFindNext == null && jSONObjectOptJSONObject.has(an.aB)) {
                            objFindNext = jSONObjectOptJSONObject.get(an.aB);
                        }
                        if (objFindNext != null) {
                            jSONObjectOptJSONObject.put("e", cloneJson(objFindNext));
                        }
                    }
                }
            }
        }
    }

    private static String sanitizeLottieJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                sanitizeNode(jSONObject);
                return jSONObject.toString();
            } catch (JSONException e) {
            }
        }
        return str;
    }

    private static void sanitizeNode(Object obj) throws JSONException {
        int i = 0;
        if (!(obj instanceof JSONObject)) {
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                while (i < jSONArray.length()) {
                    sanitizeNode(jSONArray.get(i));
                    i++;
                }
                return;
            }
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        Object objOpt = jSONObject.opt("k");
        if (objOpt instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) objOpt;
            if (jSONArray2.length() > 0 && jSONArray2.optJSONObject(0) != null) {
                sanitizeKeyframes(jSONArray2);
            }
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames != null) {
            while (i < jSONArrayNames.length()) {
                String strOptString = jSONArrayNames.optString(i);
                if (strOptString != null && !strOptString.isEmpty()) {
                    sanitizeNode(jSONObject.opt(strOptString));
                }
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: lambda$fetchAndLoad$0$com-tapsdk-tapad-internal-runtime-view-DirichletLottieView, reason: not valid java name */
    /* synthetic */ void m338lambda$fetchAndLoad$0$comtapsdktapadinternalruntimeviewDirichletLottieView(String str, long j, LottieComposition lottieComposition, long j2) {
        if (isCurrentLoad(str, j)) {
            onCompositionLoaded(lottieComposition);
            lottieComposition.getBounds().width();
            lottieComposition.getBounds().height();
        }
    }

    /* JADX INFO: renamed from: lambda$fetchAndLoad$1$com-tapsdk-tapad-internal-runtime-view-DirichletLottieView, reason: not valid java name */
    /* synthetic */ void m339lambda$fetchAndLoad$1$comtapsdktapadinternalruntimeviewDirichletLottieView(final String str, final long j) {
        String strLoadLottieJson = loadLottieJson(str);
        if (TextUtils.isEmpty(strLoadLottieJson) || !isCurrentLoad(str, j)) {
            TextUtils.isEmpty(strLoadLottieJson);
            return;
        }
        String strSanitizeLottieJson = sanitizeLottieJson(strLoadLottieJson);
        long jNanoTime = System.nanoTime();
        LottieResult<LottieComposition> lottieResultFromJsonStringSync = LottieCompositionFactory.fromJsonStringSync(strSanitizeLottieJson, null);
        final LottieComposition value = lottieResultFromJsonStringSync.getValue();
        if (value != null) {
            final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.view.DirichletLottieView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m338lambda$fetchAndLoad$0$comtapsdktapadinternalruntimeviewDirichletLottieView(str, j, value, millis);
                }
            });
        } else {
            Throwable exception = lottieResultFromJsonStringSync.getException();
            if (exception != null) {
                exception.getMessage();
            }
        }
    }

    @Override // com.tapsdk.tapad.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.playing || getComposition() == null || isAnimating()) {
            return;
        }
        playAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.getMessage();
            cancelAnimation();
        }
    }

    public void release() {
        this.released = true;
        this.loadGeneration++;
        this.pendingUrl = null;
        clearAnimationState();
    }

    public void setAutoplay(boolean z) {
        this.autoplay = z;
        if (!z) {
            this.playing = false;
            pauseAnimation();
        } else if (getComposition() != null) {
            this.playing = true;
            if (isAttachedToWindow()) {
                playAnimation();
            }
        }
    }

    public void setLooping(boolean z) {
        setRepeatCount(z ? -1 : 0);
    }

    @Override // com.tapsdk.tapad.lottie.LottieAnimationView
    public void setProgress(float f) {
        boolean z = this.autoplay || this.playing;
        super.setProgress(f);
        if (!z || getComposition() == null) {
            return;
        }
        this.playing = true;
        if (isAttachedToWindow()) {
            playAnimation();
        }
    }

    @Override // com.tapsdk.tapad.lottie.LottieAnimationView
    public void setSpeed(float f) {
        super.setSpeed(f);
    }

    public void setUrl(String str) {
        if (this.released) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.loadGeneration++;
            this.pendingUrl = null;
            clearAnimationState();
            invalidate();
            return;
        }
        if (str.equals(this.pendingUrl)) {
            return;
        }
        long j = this.loadGeneration + 1;
        this.loadGeneration = j;
        this.pendingUrl = str;
        clearAnimationState();
        fetchAndLoad(str, j);
    }
}
