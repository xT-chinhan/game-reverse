package com.byazt.jq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.byazt.nu.tj;
import com.byazt.nu.w;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, 26})
public class qg {
    public static final Object n = new Object();
    public final Map<String, rv> l;
    public q q;
    public final Context qg;
    public final String s;

    public qg(Drawable.Callback callback, String str, q qVar, Map<String, rv> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.s = str + '/';
        } else {
            this.s = str;
        }
        this.l = map;
        n(qVar);
        if (!(callback instanceof View)) {
            this.qg = null;
        } else {
            this.qg = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void n(q qVar) {
        this.q = qVar;
    }

    public Bitmap n(String str, Bitmap bitmap) {
        if (bitmap == null) {
            rv rvVar = this.l.get(str);
            Bitmap bitmapK = rvVar.k();
            rvVar.n(null);
            return bitmapK;
        }
        return this.l.get(str).k();
    }

    public Bitmap n(String str) {
        rv rvVar = this.l.get(str);
        if (rvVar == null) {
            return null;
        }
        Bitmap bitmapK = rvVar.k();
        if (bitmapK != null) {
            return bitmapK;
        }
        q qVar = this.q;
        if (qVar != null) {
            return qVar.n(rvVar);
        }
        Context context = this.qg;
        if (context == null) {
            return null;
        }
        String strOa = rvVar.oa();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strOa.startsWith("data:") && strOa.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strOa.substring(strOa.indexOf(44) + 1), 0);
                return qg(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                w.n("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.s)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.s + strOa), null, options);
                if (bitmapDecodeStream == null) {
                    w.qg("Decoded image `" + str + "` is null.");
                    return null;
                }
                return qg(str, tj.n(bitmapDecodeStream, rvVar.n(), rvVar.qg()));
            } catch (IllegalArgumentException e2) {
                w.n("Unable to decode image `" + str + "`.", e2);
                return null;
            }
        } catch (IOException e3) {
            w.n("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean n(Context context) {
        return (context == null && this.qg == null) || this.qg.equals(context);
    }

    private Bitmap qg(String str, Bitmap bitmap) {
        synchronized (n) {
        }
        return bitmap;
    }
}
