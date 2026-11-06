package com.byazt.dm;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.byazt.hg.of;
import com.byazt.ip.hw;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1212, 37})
public class pr {
    public JSONObject pr;

    public String toString() {
        JSONObject jSONObject = this.pr;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean pr() {
        JSONObject jSONObject = this.pr;
        if (jSONObject != null && jSONObject.optInt("type") > 0) {
            return hw.pr((float) this.pr.optDouble("rate"), false);
        }
        return false;
    }

    public static pr pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static pr pr(JSONObject jSONObject) {
        pr prVar = new pr();
        prVar.pr = jSONObject;
        return prVar;
    }

    public void pr(WebView webView, final of ofVar) {
        View view;
        if (!pr() || webView == null) {
            return;
        }
        try {
            System.currentTimeMillis();
            if (Build.VERSION.SDK_INT < 28 || webView.getLayerType() != 2 || (view = (View) webView.getParent()) == null) {
                return;
            }
            int measuredWidth = (int) (((double) view.getMeasuredWidth()) * 0.6d);
            int measuredHeight = (int) (((double) view.getMeasuredHeight()) * 0.6d);
            if (!pr(a.getContext(), measuredWidth, measuredHeight)) {
                return;
            }
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.RGB_565);
            view.draw(new Canvas(bitmapCreateBitmap));
            System.currentTimeMillis();
            c.hw(new fw("") { // from class: com.byazt.dm.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            System.currentTimeMillis();
                            pr.this.pr(bitmapCreateBitmap, ofVar);
                            System.currentTimeMillis();
                            if (!bitmapCreateBitmap.isRecycled()) {
                                bitmapCreateBitmap.recycle();
                            }
                        } catch (Throwable th) {
                            try {
                                th.getMessage();
                                if (!bitmapCreateBitmap.isRecycled()) {
                                    bitmapCreateBitmap.recycle();
                                }
                            } catch (Throwable th2) {
                                try {
                                    if (!bitmapCreateBitmap.isRecycled()) {
                                        bitmapCreateBitmap.recycle();
                                    }
                                } catch (Throwable th3) {
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bitmap bitmap, of ofVar) throws JSONException {
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
            if (ofVar != null) {
                jSONObject.put(BreakpointSQLiteKey.URL, ofVar.zo());
                jSONObject.put(MediationConstant.EXTRA_ADID, ofVar.fo());
                jSONObject.put("cid", ofVar.x());
            }
            com.byazt.xk.hw.pr().vk(jSONObject);
        }
    }

    public boolean pr(Context context, int i, int i2) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                return false;
            }
            return memoryInfo.availMem > Math.max((long) Math.max(((double) memoryInfo.totalMem) * 0.02d, 5.24288E7d), (long) (((float) ((i * i2) * 2)) * 2.0f));
        } catch (Exception e) {
            return false;
        }
    }
}
