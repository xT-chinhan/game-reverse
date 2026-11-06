package com.byazt.kir;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.byazt.eji.s;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.wz.qg;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1413, 19})
public class n {
    public JSONObject n;

    public String toString() {
        JSONObject jSONObject = this.n;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean n() {
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.optInt("type") > 0) {
            return qg.n((float) this.n.optDouble("rate"), false);
        }
        return false;
    }

    public static n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static n n(JSONObject jSONObject) {
        n nVar = new n();
        nVar.n = jSONObject;
        return nVar;
    }

    public void n(WebView webView, final pk pkVar) {
        View view;
        if (n() && webView != null) {
            try {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 28 && webView.getLayerType() == 2 && (view = (View) webView.getParent()) != null) {
                    int measuredWidth = (int) (((double) view.getMeasuredWidth()) * 0.6d);
                    int measuredHeight = (int) (((double) view.getMeasuredHeight()) * 0.6d);
                    if (n(rv.getContext(), measuredWidth, measuredHeight)) {
                        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
                        view.draw(new Canvas(bitmapCreateBitmap));
                        System.currentTimeMillis();
                        l.qg(new x("") { // from class: com.byazt.kir.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    System.currentTimeMillis();
                                    n.this.n(bitmapCreateBitmap, pkVar);
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
    public void n(Bitmap bitmap, pk pkVar) throws JSONException {
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
            if (pkVar != null) {
                jSONObject.put(ImagesContract.URL, pkVar.fs());
                jSONObject.put(MediationConstant.EXTRA_ADID, pkVar.wm());
                jSONObject.put("cid", pkVar.q());
            }
            s.n().cp(jSONObject);
        }
    }

    public boolean n(Context context, int i, int i2) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
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
