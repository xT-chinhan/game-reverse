package com.byazt.js;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 13})
public class hw {
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x009e  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap pr(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap2;
        try {
            if ((!com.byazt.dj.x.pr() || Build.VERSION.SDK_INT >= 26) && bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                renderScriptCreate = RenderScript.create(context);
                if (renderScriptCreate != null) {
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
                                } catch (Throwable th) {
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
                            } catch (Throwable th2) {
                                allocationCreateFromBitmap2 = 0;
                            }
                        } catch (Throwable th3) {
                            allocationCreateFromBitmap = null;
                            allocationCreateFromBitmap2 = 0;
                        }
                    } catch (Throwable th4) {
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
                } else {
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th5) {
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }
}
