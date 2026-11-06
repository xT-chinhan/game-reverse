package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes2.dex */
public abstract class pk {
    public static Bitmap a(Context context, Bitmap bitmap) {
        Bitmap bitmapCopy;
        float f = (bitmap.getWidth() > 1200 || bitmap.getHeight() > 1200) ? 0.25f : 0.5f;
        int i = 8;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                bitmapCopy = null;
                break;
            }
            try {
                bitmapCopy = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), false);
                break;
            } catch (Throwable th) {
                f /= 2.0f;
                i = i2;
            }
        }
        if (bitmapCopy == null) {
            return null;
        }
        Bitmap.Config config = bitmapCopy.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            bitmapCopy = bitmapCopy.copy(config2, true);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCopy);
        RenderScript renderScriptCreate = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCopy);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
        scriptIntrinsicBlurCreate.setRadius(20.0f);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
