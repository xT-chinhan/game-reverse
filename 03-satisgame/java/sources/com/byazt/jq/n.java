package com.byazt.jq;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.ld.fs;
import com.byazt.nu.w;
import com.byazt.pp.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, 19})
public class n {
    public s l;
    public final AssetManager q;
    public final fs<String> n = new fs<>();
    public final Map<fs<String>, Typeface> qg = new HashMap();
    public final Map<String, Typeface> s = new HashMap();
    public String w = ".ttf";

    public n(Drawable.Callback callback, s sVar) {
        this.l = sVar;
        if (!(callback instanceof View)) {
            w.qg("LottieDrawable must be inside of a view for images to work.");
            this.q = null;
        } else {
            this.q = ((View) callback).getContext().getAssets();
        }
    }

    public void n(s sVar) {
        this.l = sVar;
    }

    public void n(String str) {
        this.w = str;
    }

    public Typeface n(com.byazt.ld.s sVar) {
        this.n.n(sVar.n(), sVar.s());
        Typeface typeface = this.qg.get(this.n);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceN = n(qg(sVar), sVar.s());
        this.qg.put(this.n, typefaceN);
        return typefaceN;
    }

    private Typeface qg(com.byazt.ld.s sVar) {
        Typeface typefaceCreateFromAsset;
        String strN = sVar.n();
        Typeface typeface = this.s.get(strN);
        if (typeface != null) {
            return typeface;
        }
        String strS = sVar.s();
        String strQg = sVar.qg();
        s sVar2 = this.l;
        if (sVar2 != null) {
            typefaceCreateFromAsset = sVar2.n(strN, strS, strQg);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.l.n(strN);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        s sVar3 = this.l;
        if (sVar3 != null && typefaceCreateFromAsset == null) {
            String strQg2 = sVar3.qg(strN, strS, strQg);
            if (strQg2 == null) {
                strQg2 = this.l.qg(strN);
            }
            if (strQg2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.q, strQg2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (sVar.q() != null) {
            return sVar.q();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.q, "fonts/" + strN + this.w);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.s.put(strN, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface n(Typeface typeface, String str) {
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
