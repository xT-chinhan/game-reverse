package com.byazt.ik;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aa.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import com.umeng.analytics.pro.cc;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 37})
public class pr<E extends ViewGroup> extends hn {
    public List<hn<View>> pr;

    public pr(Context context) {
        this(context, null);
    }

    public pr(Context context, pr prVar) {
        super(context, prVar);
        this.pr = new ArrayList();
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
    }

    public void pr(hn hnVar) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
        View viewAj = hnVar.aj();
        if (viewAj != null) {
            ((ViewGroup) this.c).addView(viewAj);
        }
    }

    public void pr(hn hnVar, ViewGroup.LayoutParams layoutParams) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
        View viewAj = hnVar.aj();
        if (viewAj != null) {
            ((ViewGroup) this.c).addView(viewAj, layoutParams);
        }
    }

    public List<hn<View>> fw() {
        return this.pr;
    }

    @Override // com.byazt.ik.hn
    public hn pr(String str) {
        hn<T> hnVarX;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.w)) {
            return this;
        }
        for (hn<View> hnVar : this.pr) {
            if (hnVar != null && (hnVarX = hnVar.x(str)) != 0) {
                return hnVarX;
            }
        }
        return null;
    }

    @Override // com.byazt.ik.hn
    public hn hw(String str) {
        hn<T> hnVarC;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.k)) {
            return this;
        }
        for (hn<View> hnVar : this.pr) {
            if (hnVar != null && (hnVarC = hnVar.c(str)) != 0) {
                return hnVarC;
            }
        }
        return null;
    }

    @Override // com.byazt.ik.hn
    public hn hn(String str) {
        hn<T> hnVarUc;
        if (!TextUtils.isEmpty(str) && vk(str) != null) {
            return this;
        }
        for (hn<View> hnVar : this.pr) {
            if (hnVar != null && (hnVarUc = hnVar.uc(str)) != 0) {
                return hnVarUc;
            }
        }
        return null;
    }

    public C0097pr zo() {
        return new C0097pr(this);
    }

    /* JADX INFO: renamed from: com.byazt.ik.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0097pr {
        public boolean a;
        public float aj;
        public float c;
        public boolean cz;
        public boolean fo;
        public float fw;
        public float g;
        public boolean ho;
        public float k;
        public boolean lb;
        public float m;
        public boolean nt;
        public boolean ny;
        public boolean qa;
        public ViewGroup.LayoutParams rc;
        public float uc;
        public float vk;
        public float w;
        public boolean yb;
        public pr z;
        public float zo;
        public float pr = -2.0f;
        public float hw = -2.0f;
        public float hn = 0.0f;
        public float x = 0.0f;

        public C0097pr(pr prVar) {
            this.z = prVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void pr(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            byte b = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b = 10;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b = 2;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 1;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 4;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b = 7;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 9;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b = 8;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b = 3;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b = 12;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 0;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b = cc.k;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b = 11;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b = 6;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b = 5;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.pr = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.pr = -2.0f;
                    } else {
                        this.pr = zo.pr(context, str2);
                    }
                    break;
                case 1:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.hw = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.hw = -2.0f;
                    } else {
                        this.hw = zo.pr(context, str2);
                    }
                    break;
                case 2:
                    this.hn = zo.pr(context, str2);
                    break;
                case 3:
                    this.x = zo.pr(context, str2);
                    break;
                case 4:
                    this.c = zo.pr(context, str2);
                    break;
                case 5:
                    this.uc = zo.pr(context, str2);
                    this.a = true;
                    break;
                case 6:
                    this.fw = zo.pr(context, str2);
                    this.cz = true;
                    break;
                case 7:
                    this.zo = zo.pr(context, str2);
                    this.ny = true;
                    break;
                case 8:
                    this.aj = zo.pr(context, str2);
                    this.fo = true;
                    break;
                case 9:
                    this.vk = zo.pr(context, str2);
                    this.ho = true;
                    break;
                case 10:
                    this.w = zo.pr(context, str2);
                    this.nt = true;
                    break;
                case 11:
                    this.m = zo.pr(context, str2);
                    this.yb = true;
                    break;
                case 12:
                    this.k = zo.pr(context, str2);
                    this.lb = true;
                    break;
                case 13:
                    this.g = zo.pr(context, str2);
                    this.qa = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.pr + ", mHeight=" + this.hw + ", mMargin=" + this.c + ", mMarginLeft=" + this.uc + ", mMarginRight=" + this.fw + ", mMarginTop=" + this.zo + ", mMarginBottom=" + this.aj + ", mParams=" + this.rc + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams pr() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.pr, (int) this.hw);
            marginLayoutParams.leftMargin = (int) (this.a ? this.uc : this.c);
            marginLayoutParams.rightMargin = (int) (this.cz ? this.fw : this.c);
            marginLayoutParams.topMargin = (int) (this.ny ? this.zo : this.c);
            marginLayoutParams.bottomMargin = (int) (this.fo ? this.aj : this.c);
            return marginLayoutParams;
        }
    }
}
