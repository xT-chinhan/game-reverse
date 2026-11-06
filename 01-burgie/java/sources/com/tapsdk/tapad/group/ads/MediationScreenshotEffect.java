package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MediationScreenshotEffect {
    private static final int ERROR_CAPTURE_FAILED = 3;
    private static final int ERROR_INVALID_ACTIVITY = 1;
    private static final int ERROR_VIEW_NOT_READY = 2;
    private static final int MAX_BITMAP_LONG_SIDE = 576;
    private static final int MIN_BITMAP_SHORT_SIDE = 256;
    private static final int TARGET_ENCODED_BYTES = 49152;
    private volatile boolean cancelled;
    private static final int[] WEBP_QUALITIES = {72, 64, 56, 48, 40};
    private static final Bitmap.Config CAPTURE_CONFIG = Bitmap.Config.RGB_565;
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    public interface CaptureCallback {
        void onError(int i, String str);

        void onSuccess(Bitmap bitmap);
    }

    private static float calculateScale(int i, int i2) {
        int iMax = Math.max(i, i2);
        if (iMax <= MAX_BITMAP_LONG_SIDE) {
            return 1.0f;
        }
        int iMin = Math.min(i, i2);
        float f = 576.0f / iMax;
        if (iMin > 0) {
            float f2 = iMin;
            if (f2 * f < 256.0f) {
                return Math.min(1.0f, 256.0f / f2);
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: capture, reason: merged with bridge method [inline-methods] */
    public void m70lambda$request$0$comtapsdktapadgroupadsMediationScreenshotEffect(final DirichletAd dirichletAd, final View view) {
        if (this.cancelled) {
            return;
        }
        final Activity currentActivity = AndroidLifecycleHost.getInstance().getCurrentActivity();
        if (ActivityUtil.isActivityNotAlive(currentActivity)) {
            reportError(dirichletAd, view, currentActivity, 1, "Activity is null or destroyed.", 0L);
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            captureActivity(currentActivity, new CaptureCallback() { // from class: com.tapsdk.tapad.group.ads.MediationScreenshotEffect.1
                @Override // com.tapsdk.tapad.group.ads.MediationScreenshotEffect.CaptureCallback
                public void onError(int i, String str) {
                    MediationScreenshotEffect.this.reportError(dirichletAd, view, currentActivity, i, str, MediationScreenshotEffect.elapsed(jCurrentTimeMillis));
                }

                @Override // com.tapsdk.tapad.group.ads.MediationScreenshotEffect.CaptureCallback
                public void onSuccess(Bitmap bitmap) {
                    MediationScreenshotEffect.this.encode(dirichletAd, view, currentActivity, bitmap, jCurrentTimeMillis);
                }
            });
        }
    }

    private static void captureActivity(Activity activity, CaptureCallback captureCallback) {
        View rootView;
        if (activity.isFinishing() || activity.isDestroyed()) {
            captureCallback.onError(1, "Activity is finishing or destroyed.");
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            captureCallback.onError(1, "Activity window is null.");
            return;
        }
        View decorView = window.getDecorView();
        int width = decorView.getWidth();
        int height = decorView.getHeight();
        if ((width <= 0 || height <= 0) && (rootView = decorView.getRootView()) != null) {
            width = rootView.getWidth();
            height = rootView.getHeight();
        }
        if (width <= 0 || height <= 0) {
            width = decorView.getMeasuredWidth();
            height = decorView.getMeasuredHeight();
        }
        if (width <= 0 || height <= 0) {
            captureCallback.onError(2, "View size is invalid.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            captureWithPixelCopy(window, decorView, width, height, captureCallback);
            return;
        }
        Bitmap bitmapCaptureFromView = captureFromView(decorView, width, height);
        if (bitmapCaptureFromView != null) {
            captureCallback.onSuccess(bitmapCaptureFromView);
        } else {
            captureCallback.onError(3, "Failed to capture view.");
        }
    }

    private static Bitmap captureFromView(View view, int i, int i2) {
        Bitmap bitmapCreateBitmap;
        if (view != null && i > 0 && i2 > 0) {
            float fCalculateScale = calculateScale(i, i2);
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(Math.max(1, Math.round(i * fCalculateScale)), Math.max(1, Math.round(i2 * fCalculateScale)), CAPTURE_CONFIG);
                try {
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    if (fCalculateScale < 1.0f) {
                        canvas.scale(fCalculateScale, fCalculateScale);
                    }
                    view.draw(canvas);
                    return bitmapCreateBitmap;
                } catch (Exception e) {
                    recycle(bitmapCreateBitmap);
                    return null;
                } catch (OutOfMemoryError e2) {
                    recycle(bitmapCreateBitmap);
                    return null;
                }
            } catch (Exception | OutOfMemoryError e3) {
                bitmapCreateBitmap = null;
            }
        }
        return null;
    }

    private static void captureWithPixelCopy(Window window, final View view, final int i, final int i2, final CaptureCallback captureCallback) {
        try {
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            try {
                PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.tapsdk.tapad.group.ads.MediationScreenshotEffect$$ExternalSyntheticLambda3
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i3) {
                        MediationScreenshotEffect.lambda$captureWithPixelCopy$3(captureCallback, bitmapCreateBitmap, view, i, i2, i3);
                    }
                }, MAIN_HANDLER);
            } catch (Exception e) {
                Bitmap bitmapCaptureFromView = captureFromView(view, i, i2);
                recycle(bitmapCreateBitmap);
                if (bitmapCaptureFromView != null) {
                    captureCallback.onSuccess(bitmapCaptureFromView);
                } else {
                    captureCallback.onError(3, "PixelCopy request failed.");
                }
            }
        } catch (OutOfMemoryError e2) {
            captureCallback.onError(3, "Out of memory when creating bitmap.");
        }
    }

    private static Bitmap compact(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                float fCalculateScale = calculateScale(width, height);
                if (fCalculateScale < 0.999f || bitmap.getConfig() != CAPTURE_CONFIG) {
                    Bitmap bitmapCreateBitmap = null;
                    try {
                        int iMax = Math.max(1, Math.round(width * fCalculateScale));
                        int iMax2 = Math.max(1, Math.round(height * fCalculateScale));
                        bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, CAPTURE_CONFIG);
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, iMax, iMax2), new Paint(3));
                        recycle(bitmap);
                        return bitmapCreateBitmap;
                    } catch (Exception | OutOfMemoryError e) {
                        recycle(bitmapCreateBitmap);
                    }
                }
            }
        }
        return bitmap;
    }

    private static byte[] compress(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(compressFormat, i, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    private static byte[] compressToWebp(Bitmap bitmap) {
        byte[] bArr = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap.CompressFormat compressFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
            for (int i : WEBP_QUALITIES) {
                byte[] bArrCompress = compress(bitmap, compressFormat, i);
                if (bArrCompress != null && bArrCompress.length != 0) {
                    if (bArr == null || bArrCompress.length < bArr.length) {
                        bArr = bArrCompress;
                    }
                    if (bArrCompress.length <= TARGET_ENCODED_BYTES) {
                        return bArrCompress;
                    }
                }
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long elapsed(long j) {
        return Math.max(0L, System.currentTimeMillis() - j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encode(final DirichletAd dirichletAd, final View view, final Activity activity, final Bitmap bitmap, final long j) {
        if (DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationScreenshotEffect$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m69lambda$encode$2$comtapsdktapadgroupadsMediationScreenshotEffect(bitmap, dirichletAd, view, activity, j);
            }
        })) {
            return;
        }
        recycle(bitmap);
        reportError(dirichletAd, view, activity, 3, "Screenshot worker unavailable.", elapsed(j));
    }

    static /* synthetic */ void lambda$captureWithPixelCopy$3(CaptureCallback captureCallback, Bitmap bitmap, View view, int i, int i2, int i3) {
        if (i3 == 0) {
            captureCallback.onSuccess(bitmap);
            return;
        }
        Bitmap bitmapCaptureFromView = captureFromView(view, i, i2);
        recycle(bitmap);
        if (bitmapCaptureFromView != null) {
            captureCallback.onSuccess(bitmapCaptureFromView);
        } else {
            captureCallback.onError(3, b.a("PixelCopy failed: ", i3));
        }
    }

    private static void recycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(DirichletAd dirichletAd, View view, Activity activity, int i, String str, long j) {
        if (this.cancelled) {
            return;
        }
        Map<String, Object> mapStatusFacts = MediationCandidateEffects.statusFacts(dirichletAd, i, str, activity, view);
        if (j > 0) {
            mapStatusFacts.put(Constants.DELAY_FIELD, Long.valueOf(j));
        }
        MediationControlBridge.submitCandidateFact(52, mapStatusFacts);
    }

    public void cancel() {
        this.cancelled = true;
    }

    /* JADX INFO: renamed from: lambda$encode$2$com-tapsdk-tapad-group-ads-MediationScreenshotEffect, reason: not valid java name */
    /* synthetic */ void m69lambda$encode$2$comtapsdktapadgroupadsMediationScreenshotEffect(Bitmap bitmap, DirichletAd dirichletAd, View view, Activity activity, long j) {
        if (this.cancelled) {
            recycle(bitmap);
            return;
        }
        Bitmap bitmapCompact = compact(bitmap);
        try {
            try {
                byte[] bArrCompressToWebp = compressToWebp(bitmapCompact);
                String strEncodeToString = bArrCompressToWebp == null ? "" : Base64.encodeToString(bArrCompressToWebp, 2);
                if (strEncodeToString.isEmpty()) {
                    reportError(dirichletAd, view, activity, 3, "Screenshot encode failed.", elapsed(j));
                    return;
                }
                try {
                    Map<String, Object> mapStatusFacts = MediationCandidateEffects.statusFacts(dirichletAd, 0, "", activity, view);
                    mapStatusFacts.put(Constants.SCREENSHOT_BASE64_FIELD, strEncodeToString);
                    mapStatusFacts.put("width", Integer.valueOf(bitmapCompact.getWidth()));
                    mapStatusFacts.put("height", Integer.valueOf(bitmapCompact.getHeight()));
                    mapStatusFacts.put(Constants.DELAY_FIELD, Long.valueOf(elapsed(j)));
                    mapStatusFacts.put(Constants.SCREENSHOT_BASE64_SIZE_FIELD, Integer.valueOf(strEncodeToString.getBytes(StandardCharsets.UTF_8).length));
                    MediationControlBridge.submitCandidateFact(52, mapStatusFacts);
                    return;
                } catch (Exception e) {
                } catch (OutOfMemoryError e2) {
                }
            } finally {
                recycle(bitmapCompact);
            }
        } catch (Exception | OutOfMemoryError e3) {
        }
        reportError(dirichletAd, view, activity, 3, "Screenshot encode failed.", elapsed(j));
    }

    /* JADX INFO: renamed from: lambda$request$1$com-tapsdk-tapad-group-ads-MediationScreenshotEffect, reason: not valid java name */
    /* synthetic */ void m71lambda$request$1$comtapsdktapadgroupadsMediationScreenshotEffect(final DirichletAd dirichletAd, final View view) {
        long jClaimCandidateScreenshot = MediationRuntimeCoreBridge.claimCandidateScreenshot(dirichletAd.getTrackId());
        if (jClaimCandidateScreenshot <= 0 || this.cancelled) {
            return;
        }
        MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationScreenshotEffect$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m70lambda$request$0$comtapsdktapadgroupadsMediationScreenshotEffect(dirichletAd, view);
            }
        }, jClaimCandidateScreenshot);
    }

    public void request(final DirichletAd dirichletAd, final View view) {
        if (this.cancelled) {
            return;
        }
        DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationScreenshotEffect$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m71lambda$request$1$comtapsdktapadgroupadsMediationScreenshotEffect(dirichletAd, view);
            }
        });
    }
}
