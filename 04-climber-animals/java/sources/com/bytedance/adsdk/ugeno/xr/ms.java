package com.bytedance.adsdk.ugeno.xr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.c.x;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ms<E extends ViewGroup> extends ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected List<ah<View>> f438ms;

    public ms(Context context) {
        this(context, null);
    }

    public ms(Context context, ms msVar) {
        super(context, msVar);
        this.f438ms = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
    }

    public void ms(ah ahVar) {
        if (ahVar == null) {
            return;
        }
        this.f438ms.add(ahVar);
        View viewNy = ahVar.ny();
        if (viewNy != null) {
            ((ViewGroup) this.ka).addView(viewNy);
        }
    }

    public void ms(ah ahVar, ViewGroup.LayoutParams layoutParams) {
        if (ahVar == null) {
            return;
        }
        this.f438ms.add(ahVar);
        View viewNy = ahVar.ny();
        if (viewNy != null) {
            ((ViewGroup) this.ka).addView(viewNy, layoutParams);
        }
    }

    public List<ah<View>> ab() {
        return this.f438ms;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public ah ms(String str) {
        ah<T> ahVarAh;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.hi)) {
            return this;
        }
        for (ah<View> ahVar : this.f438ms) {
            if (ahVar != null && (ahVarAh = ahVar.ah(str)) != 0) {
                return ahVarAh;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public ah xr(String str) {
        ah<T> ahVarD;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.sl)) {
            return this;
        }
        for (ah<View> ahVar : this.f438ms) {
            if (ahVar != null && (ahVarD = ahVar.d(str)) != 0) {
                return ahVarD;
            }
        }
        return null;
    }

    public C0201ms x() {
        return new C0201ms(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.xr.ms$ms, reason: collision with other inner class name */
    public static class C0201ms {
        protected float ab;
        protected boolean ao;
        protected boolean b;
        protected float c;
        protected float ch;
        protected boolean h;
        protected float hi;
        protected ViewGroup.LayoutParams i;
        protected float ka;
        protected boolean nw;
        protected float ny;
        protected boolean qv;
        protected boolean re;
        protected float sl;
        protected boolean t;
        protected float u;
        protected boolean ub;
        protected ms w;
        protected float x;
        protected boolean y;
        protected float zb;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        protected float f439ms = -2.0f;
        protected float xr = -2.0f;
        protected float ah = 0.0f;
        protected float d = 0.0f;

        public C0201ms(ms msVar) {
            this.w = msVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void ms(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b = 0;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b = 1;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 2;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 3;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b = 4;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 5;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b = 6;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b = 7;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b = 8;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 9;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b = 10;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b = 11;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b = 12;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b = ek.k;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    this.hi = x.ms(context, str2);
                    this.ao = true;
                    break;
                case 1:
                    this.ah = x.ms(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.xr = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.xr = -2.0f;
                    } else {
                        this.xr = x.ms(context, str2);
                    }
                    break;
                case 3:
                    this.ka = x.ms(context, str2);
                    break;
                case 4:
                    this.x = x.ms(context, str2);
                    this.b = true;
                    break;
                case 5:
                    this.ch = x.ms(context, str2);
                    this.ub = true;
                    break;
                case 6:
                    this.ny = x.ms(context, str2);
                    this.re = true;
                    break;
                case 7:
                    this.d = x.ms(context, str2);
                    break;
                case 8:
                    this.sl = x.ms(context, str2);
                    this.qv = true;
                    break;
                case 9:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.f439ms = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.f439ms = -2.0f;
                    } else {
                        this.f439ms = x.ms(context, str2);
                    }
                    break;
                case 10:
                    this.u = x.ms(context, str2);
                    this.y = true;
                    break;
                case 11:
                    this.zb = x.ms(context, str2);
                    this.h = true;
                    break;
                case 12:
                    this.ab = x.ms(context, str2);
                    this.nw = true;
                    break;
                case 13:
                    this.c = x.ms(context, str2);
                    this.t = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.f439ms + ", mHeight=" + this.xr + ", mMargin=" + this.ka + ", mMarginLeft=" + this.c + ", mMarginRight=" + this.ab + ", mMarginTop=" + this.x + ", mMarginBottom=" + this.ny + ", mParams=" + this.i + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams ms() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.f439ms, (int) this.xr);
            marginLayoutParams.leftMargin = (int) (this.t ? this.c : this.ka);
            marginLayoutParams.rightMargin = (int) (this.nw ? this.ab : this.ka);
            marginLayoutParams.topMargin = (int) (this.b ? this.x : this.ka);
            marginLayoutParams.bottomMargin = (int) (this.re ? this.ny : this.ka);
            return marginLayoutParams;
        }
    }
}
