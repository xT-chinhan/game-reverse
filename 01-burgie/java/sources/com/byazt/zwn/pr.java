package com.byazt.zwn;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.dx.hn;
import com.byazt.ptr.uc;
import com.byazt.uxi.zo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 969, 37})
public class pr {
    public hn c;
    public final AssetManager x;
    public final zo<String> pr = new zo<>();
    public final Map<zo<String>, Typeface> hw = new HashMap();
    public final Map<String, Typeface> hn = new HashMap();
    public String uc = ".ttf";

    public pr(Drawable.Callback callback, hn hnVar) {
        this.c = hnVar;
        if (!(callback instanceof View)) {
            uc.hw("LottieDrawable must be inside of a view for images to work.");
            this.x = null;
        } else {
            this.x = ((View) callback).getContext().getAssets();
        }
    }

    public void pr(hn hnVar) {
        this.c = hnVar;
    }

    public void pr(String str) {
        this.uc = str;
    }

    public Typeface pr(com.byazt.uxi.hn hnVar) {
        this.pr.pr(hnVar.pr(), hnVar.hn());
        Typeface typeface = this.hw.get(this.pr);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefacePr = pr(hw(hnVar), hnVar.hn());
        this.hw.put(this.pr, typefacePr);
        return typefacePr;
    }

    private Typeface hw(com.byazt.uxi.hn hnVar) {
        String strPr = hnVar.pr();
        Typeface typeface = this.hn.get(strPr);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = null;
        String strHn = hnVar.hn();
        String strHw = hnVar.hw();
        hn hnVar2 = this.c;
        if (hnVar2 != null && (typefaceCreateFromAsset = hnVar2.pr(strPr, strHn, strHw)) == null) {
            typefaceCreateFromAsset = this.c.pr(strPr);
        }
        hn hnVar3 = this.c;
        if (hnVar3 != null && typefaceCreateFromAsset == null) {
            String strHw2 = hnVar3.hw(strPr, strHn, strHw);
            if (strHw2 == null) {
                strHw2 = this.c.hw(strPr);
            }
            if (strHw2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.x, strHw2);
                } catch (Throwable th) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (hnVar.x() != null) {
            return hnVar.x();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.x, "fonts/" + strPr + this.uc);
            } catch (Throwable th2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.hn.put(strPr, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface pr(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else if (!zContains2) {
            i = 0;
        } else {
            i = 1;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
