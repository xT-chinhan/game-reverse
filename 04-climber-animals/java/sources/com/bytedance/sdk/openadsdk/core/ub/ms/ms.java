package com.bytedance.sdk.openadsdk.core.ub.ms;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.c.xr;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f3377ms;

    public String toString() {
        JSONObject jSONObject = this.f3377ms;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean ms() {
        JSONObject jSONObject = this.f3377ms;
        if (jSONObject != null && jSONObject.optInt("type") > 0) {
            return xr.ms((float) this.f3377ms.optDouble("rate"), false);
        }
        return false;
    }

    public static ms ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static ms ms(JSONObject jSONObject) {
        ms msVar = new ms();
        msVar.f3377ms = jSONObject;
        return msVar;
    }

    public void ms(WebView webView, final lm lmVar) {
        View view;
        if (ms() && webView != null) {
            try {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 28 && webView.getLayerType() == 2 && (view = (View) webView.getParent()) != null) {
                    int measuredWidth = (int) (((double) view.getMeasuredWidth()) * 0.6d);
                    int measuredHeight = (int) (((double) view.getMeasuredHeight()) * 0.6d);
                    if (ms(re.getContext(), measuredWidth, measuredHeight)) {
                        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                        view.draw(new Canvas(bitmapCreateBitmap));
                        System.currentTimeMillis();
                        ab.xr(new ny("") { // from class: com.bytedance.sdk.openadsdk.core.ub.ms.ms.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    System.currentTimeMillis();
                                    ms.this.ms(bitmapCreateBitmap, lmVar);
                                    System.currentTimeMillis();
                                    try {
                                        if (bitmapCreateBitmap.isRecycled()) {
                                            return;
                                        }
                                        bitmapCreateBitmap.recycle();
                                    } catch (Throwable unused) {
                                    }
                                } catch (Throwable th) {
                                    try {
                                        th.getMessage();
                                        try {
                                            if (bitmapCreateBitmap.isRecycled()) {
                                            }
                                        } catch (Throwable unused2) {
                                        }
                                    } finally {
                                        try {
                                            if (!bitmapCreateBitmap.isRecycled()) {
                                                bitmapCreateBitmap.recycle();
                                            }
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Bitmap bitmap, lm lmVar) throws JSONException {
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        try {
            bitmap.recycle();
        } catch (Throwable th) {
            th.getMessage();
        }
        float width = bitmapCreateBitmap.getWidth() * bitmapCreateBitmap.getHeight();
        float f = 0.0f;
        for (int i = 0; i < bitmapCreateBitmap.getWidth(); i++) {
            for (int i2 = 0; i2 < bitmapCreateBitmap.getHeight(); i2++) {
                if (bitmapCreateBitmap.getPixel(i, i2) == -1) {
                    f += 1.0f;
                }
            }
        }
        try {
            bitmapCreateBitmap.recycle();
        } catch (Throwable th2) {
            th2.getMessage();
        }
        if ((f / width) * 100.0f > 95.0d) {
            JSONObject jSONObject = new JSONObject();
            if (lmVar != null) {
                jSONObject.put("url", lmVar.ir());
                jSONObject.put("ad_id", lmVar.cz());
                jSONObject.put("cid", lmVar.df());
            }
            u.ms().c(jSONObject);
        }
    }

    public boolean ms(Context context, int i, int i2) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                return false;
            }
            if (memoryInfo.availMem > Math.max((long) Math.max(memoryInfo.totalMem * 0.02d, 5.24288E7d), (long) (i * i2 * 2 * 2.0f))) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
