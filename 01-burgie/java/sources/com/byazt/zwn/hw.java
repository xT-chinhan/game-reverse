package com.byazt.zwn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.byazt.dx.aj;
import com.byazt.dx.x;
import com.byazt.ptr.uc;
import com.byazt.ptr.vk;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 969, 13})
public class hw {
    public static final Object pr = new Object();
    public final Map<String, aj> c;
    public final String hn;
    public final Context hw;
    public x x;

    public hw(Drawable.Callback callback, String str, x xVar, Map<String, aj> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.hn = str + '/';
        } else {
            this.hn = str;
        }
        this.c = map;
        pr(xVar);
        if (!(callback instanceof View)) {
            this.hw = null;
        } else {
            this.hw = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void pr(x xVar) {
        this.x = xVar;
    }

    public Bitmap pr(String str, Bitmap bitmap) {
        if (bitmap == null) {
            aj ajVar = this.c.get(str);
            Bitmap bitmapHo = ajVar.ho();
            ajVar.pr(null);
            return bitmapHo;
        }
        return this.c.get(str).ho();
    }

    public Bitmap pr(String str) {
        aj ajVar = this.c.get(str);
        if (ajVar == null) {
            return null;
        }
        Bitmap bitmapHo = ajVar.ho();
        if (bitmapHo != null) {
            return bitmapHo;
        }
        x xVar = this.x;
        if (xVar != null) {
            return xVar.pr(ajVar);
        }
        Context context = this.hw;
        if (context == null) {
            return null;
        }
        String strM = ajVar.m();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strM.startsWith("data:") && strM.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strM.substring(strM.indexOf(44) + 1), 0);
                return hw(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                uc.pr("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.hn)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.hn + strM), null, options);
                if (bitmapDecodeStream == null) {
                    uc.hw("Decoded image `" + str + "` is null.");
                    return null;
                }
                return hw(str, vk.pr(bitmapDecodeStream, ajVar.pr(), ajVar.hw()));
            } catch (IllegalArgumentException e2) {
                uc.pr("Unable to decode image `" + str + "`.", e2);
                return null;
            }
        } catch (IOException e3) {
            uc.pr("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean pr(Context context) {
        return (context == null && this.hw == null) || this.hw.equals(context);
    }

    private Bitmap hw(String str, Bitmap bitmap) {
        synchronized (pr) {
        }
        return bitmap;
    }
}
