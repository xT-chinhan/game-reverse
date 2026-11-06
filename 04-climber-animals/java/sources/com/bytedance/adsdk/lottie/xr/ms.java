package com.bytedance.adsdk.lottie.xr;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.ah;
import com.bytedance.adsdk.lottie.ka.ka;
import com.bytedance.adsdk.lottie.model.ab;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private final AssetManager d;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ab<String> f292ms = new ab<>();
    private final Map<ab<String>, Typeface> xr = new HashMap();
    private final Map<String, Typeface> ah = new HashMap();
    private String c = ".ttf";

    public ms(Drawable.Callback callback, ah ahVar) {
        this.ka = ahVar;
        if (!(callback instanceof View)) {
            ka.xr("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        } else {
            this.d = ((View) callback).getContext().getAssets();
        }
    }

    public void ms(ah ahVar) {
        this.ka = ahVar;
    }

    public void ms(String str) {
        this.c = str;
    }

    public Typeface ms(com.bytedance.adsdk.lottie.model.ah ahVar) {
        this.f292ms.ms(ahVar.ms(), ahVar.ah());
        Typeface typeface = this.xr.get(this.f292ms);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceMs = ms(xr(ahVar), ahVar.ah());
        this.xr.put(this.f292ms, typefaceMs);
        return typefaceMs;
    }

    private Typeface xr(com.bytedance.adsdk.lottie.model.ah ahVar) {
        Typeface typefaceCreateFromAsset;
        String strMs = ahVar.ms();
        Typeface typeface = this.ah.get(strMs);
        if (typeface != null) {
            return typeface;
        }
        String strAh = ahVar.ah();
        String strXr = ahVar.xr();
        ah ahVar2 = this.ka;
        if (ahVar2 != null) {
            typefaceCreateFromAsset = ahVar2.ms(strMs, strAh, strXr);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.ka.ms(strMs);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        ah ahVar3 = this.ka;
        if (ahVar3 != null && typefaceCreateFromAsset == null) {
            String strXr2 = ahVar3.xr(strMs, strAh, strXr);
            if (strXr2 == null) {
                strXr2 = this.ka.xr(strMs);
            }
            if (strXr2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.d, strXr2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (ahVar.d() != null) {
            return ahVar.d();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + strMs + this.c);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.ah.put(strMs, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface ms(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else {
            i = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
