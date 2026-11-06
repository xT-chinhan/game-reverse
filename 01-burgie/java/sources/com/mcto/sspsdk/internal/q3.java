package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.taptap.sdk.compliance.constants.ComplianceMessage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q3 {
    public static Bitmap a(Context context, Bitmap bitmap, float f) {
        Bitmap bitmapCopy;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 25.0f) {
            f = 25.0f;
        }
        if (f <= 0.0f) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0 || (width <= 1200 && height <= 1200)) {
                bitmapCopy = bitmap;
            } else {
                float f2 = width;
                float f3 = ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR;
                float f4 = height;
                float fMax = Math.max(f2 / f3, f4 / f3);
                try {
                    bitmapCopy = Bitmap.createScaledBitmap(bitmap, Math.max(1, Math.round(f2 / fMax)), Math.max(1, Math.round(f4 / fMax)), false);
                } catch (Throwable th) {
                    bitmapCopy = bitmap;
                }
            }
            Bitmap.Config config = bitmapCopy.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                bitmapCopy = bitmapCopy.copy(config2, true);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCopy);
            RenderScript renderScriptCreate = RenderScript.create(context.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCopy);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            r9.a("ssp_ImageView2", "blurBitmap failed", th2);
            return bitmap;
        }
    }
}
