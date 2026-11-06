package com.bytedance.adsdk.lottie.xr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.ka.ka;
import com.bytedance.adsdk.lottie.ny;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Object f293ms = new Object();
    private final String ah;
    private d d;
    private final Map<String, ny> ka;
    private final Context xr;

    public xr(Drawable.Callback callback, String str, d dVar, Map<String, ny> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.ah = str + '/';
        } else {
            this.ah = str;
        }
        this.ka = map;
        ms(dVar);
        if (!(callback instanceof View)) {
            this.xr = null;
        } else {
            this.xr = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void ms(d dVar) {
        this.d = dVar;
    }

    public Bitmap ms(String str, Bitmap bitmap) {
        if (bitmap == null) {
            ny nyVar = this.ka.get(str);
            Bitmap bitmapU = nyVar.u();
            nyVar.ms(null);
            return bitmapU;
        }
        return this.ka.get(str).u();
    }

    public Bitmap ms(String str) {
        ny nyVar = this.ka.get(str);
        if (nyVar == null) {
            return null;
        }
        Bitmap bitmapU = nyVar.u();
        if (bitmapU != null) {
            return bitmapU;
        }
        d dVar = this.d;
        if (dVar != null) {
            return dVar.ms(nyVar);
        }
        Context context = this.xr;
        if (context == null) {
            return null;
        }
        String strSl = nyVar.sl();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strSl.startsWith("data:") && strSl.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strSl.substring(strSl.indexOf(44) + 1), 0);
                return xr(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                ka.ms("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.ah)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.ah + strSl), null, options);
                if (bitmapDecodeStream == null) {
                    ka.xr("Decoded image `" + str + "` is null.");
                    return null;
                }
                return xr(str, com.bytedance.adsdk.lottie.ka.ny.ms(bitmapDecodeStream, nyVar.ms(), nyVar.xr()));
            } catch (IllegalArgumentException e2) {
                ka.ms("Unable to decode image `" + str + "`.", e2);
                return null;
            }
        } catch (IOException e3) {
            ka.ms("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean ms(Context context) {
        return (context == null && this.xr == null) || this.xr.equals(context);
    }

    private Bitmap xr(String str, Bitmap bitmap) {
        synchronized (f293ms) {
        }
        return bitmap;
    }
}
