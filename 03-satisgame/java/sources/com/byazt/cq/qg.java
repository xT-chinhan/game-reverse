package com.byazt.cq;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 26})
public class qg {
    /* JADX WARN: Code duplicated, block: B:38:0x0083  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0092  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap n(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap2;
        try {
            if ((!com.byazt.twc.q.n() || Build.VERSION.SDK_INT >= 26) && bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                renderScriptCreate = RenderScript.create(context);
                if (renderScriptCreate == null) {
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
                try {
                    scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                            try {
                                scriptIntrinsicBlurCreate.setRadius(i);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != 0) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != 0) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                return bitmapCreateBitmap;
                            } catch (Throwable unused) {
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != 0) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != 0) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                return null;
                            }
                        } catch (Throwable unused2) {
                            allocationCreateFromBitmap2 = 0;
                        }
                    } catch (Throwable unused3) {
                        allocationCreateFromBitmap = null;
                        allocationCreateFromBitmap2 = 0;
                    }
                } catch (Throwable unused4) {
                    allocationCreateFromBitmap = null;
                    scriptIntrinsicBlurCreate = allocationCreateFromBitmap;
                    allocationCreateFromBitmap2 = scriptIntrinsicBlurCreate;
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (allocationCreateFromBitmap2 != 0) {
                        allocationCreateFromBitmap2.destroy();
                    }
                    if (scriptIntrinsicBlurCreate != 0) {
                        scriptIntrinsicBlurCreate.destroy();
                    }
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused5) {
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }
}
