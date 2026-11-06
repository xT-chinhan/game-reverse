package com.byazt.ih;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hb.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 219, 19})
public class n<E extends ViewGroup> extends s {
    public List<s<View>> n;

    public n(Context context) {
        this(context, null);
    }

    public n(Context context, n nVar) {
        super(context, nVar);
        this.n = new ArrayList();
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
    }

    public void n(s sVar) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
        View viewRv = sVar.rv();
        if (viewRv != null) {
            ((ViewGroup) this.l).addView(viewRv);
        }
    }

    public void n(s sVar, ViewGroup.LayoutParams layoutParams) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
        View viewRv = sVar.rv();
        if (viewRv != null) {
            ((ViewGroup) this.l).addView(viewRv, layoutParams);
        }
    }

    public List<s<View>> x() {
        return this.n;
    }

    @Override // com.byazt.ih.s
    public s n(String str) {
        s<T> sVarQ;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.cp)) {
            return this;
        }
        for (s<View> sVar : this.n) {
            if (sVar != null && (sVarQ = sVar.q(str)) != 0) {
                return sVarQ;
            }
        }
        return null;
    }

    @Override // com.byazt.ih.s
    public s qg(String str) {
        s<T> sVarL;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.d)) {
            return this;
        }
        for (s<View> sVar : this.n) {
            if (sVar != null && (sVarL = sVar.l(str)) != 0) {
                return sVarL;
            }
        }
        return null;
    }

    @Override // com.byazt.ih.s
    public s s(String str) {
        s<T> sVarW;
        if (!TextUtils.isEmpty(str) && tj(str) != null) {
            return this;
        }
        for (s<View> sVar : this.n) {
            if (sVar != null && (sVarW = sVar.w(str)) != 0) {
                return sVarW;
            }
        }
        return null;
    }

    public C0202n fs() {
        return new C0202n(this);
    }

    /* JADX INFO: renamed from: com.byazt.ih.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 219, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0202n {
        public boolean a;
        public boolean cd;
        public float cp;
        public boolean cy;
        public float d;
        public float fs;
        public boolean hd;
        public n hu;
        public boolean k;
        public float l;
        public ViewGroup.LayoutParams m;
        public float oa;
        public boolean ou;
        public boolean py;
        public float rv;
        public float sz;
        public float tj;
        public boolean um;
        public float w;
        public boolean wm;
        public float x;
        public float n = -2.0f;
        public float qg = -2.0f;
        public float s = 0.0f;
        public float q = 0.0f;

        public C0202n(n nVar) {
            this.hu = nVar;
        }

        public void n(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            switch (str) {
                case "paddingLeft":
                    this.cp = fs.n(context, str2);
                    this.cy = true;
                    break;
                case "minWidth":
                    this.s = fs.n(context, str2);
                    break;
                case "height":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.qg = -1.0f;
                        break;
                    } else {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.qg = -2.0f;
                        } else {
                            this.qg = fs.n(context, str2);
                        }
                        break;
                    }
                    break;
                case "margin":
                    this.l = fs.n(context, str2);
                    break;
                case "marginTop":
                    this.fs = fs.n(context, str2);
                    this.ou = true;
                    break;
                case "padding":
                    this.tj = fs.n(context, str2);
                    this.k = true;
                    break;
                case "marginBottom":
                    this.rv = fs.n(context, str2);
                    this.wm = true;
                    break;
                case "minHeight":
                    this.q = fs.n(context, str2);
                    break;
                case "paddingTop":
                    this.d = fs.n(context, str2);
                    this.cd = true;
                    break;
                case "width":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.n = -1.0f;
                        break;
                    } else {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.n = -2.0f;
                        } else {
                            this.n = fs.n(context, str2);
                        }
                        break;
                    }
                    break;
                case "paddingBottom":
                    this.sz = fs.n(context, str2);
                    this.um = true;
                    break;
                case "paddingRight":
                    this.oa = fs.n(context, str2);
                    this.hd = true;
                    break;
                case "marginRight":
                    this.x = fs.n(context, str2);
                    this.py = true;
                    break;
                case "marginLeft":
                    this.w = fs.n(context, str2);
                    this.a = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.n + ", mHeight=" + this.qg + ", mMargin=" + this.l + ", mMarginLeft=" + this.w + ", mMarginRight=" + this.x + ", mMarginTop=" + this.fs + ", mMarginBottom=" + this.rv + ", mParams=" + this.m + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams n() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.n, (int) this.qg);
            marginLayoutParams.leftMargin = (int) (this.a ? this.w : this.l);
            marginLayoutParams.rightMargin = (int) (this.py ? this.x : this.l);
            marginLayoutParams.topMargin = (int) (this.ou ? this.fs : this.l);
            marginLayoutParams.bottomMargin = (int) (this.wm ? this.rv : this.l);
            return marginLayoutParams;
        }
    }
}
