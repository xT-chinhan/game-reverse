package com.byazt.id;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.byazt.ik.hn;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.umeng.analytics.pro.cc;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 92, 13})
public class hw extends hn<UGTextView> {
    public int fe;
    public TextUtils.TruncateAt fs;

    @Deprecated
    public float h;
    public float ks;
    public int ku;
    public boolean lj;
    public int oj;
    public float om;
    public int p;
    public String pr;
    public int qx;
    public float sr;
    public float sx;

    @Deprecated
    public float t;
    public float tv;
    public float uk;
    public float vv;
    public int wz;
    public int xb;

    @Deprecated
    public TextUtils.TruncateAt xg;
    public float yj;

    public hw(Context context) {
        super(context);
        this.qx = ViewCompat.MEASURED_STATE_MASK;
        this.ks = 12.0f;
        this.sr = -1.0f;
        this.wz = Integer.MAX_VALUE;
        this.p = GravityCompat.START;
        this.fs = TextUtils.TruncateAt.END;
        this.sx = -1.0f;
        this.uk = 400.0f;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UGTextView pr() {
        UGTextView uGTextView = new UGTextView(this.hw);
        uGTextView.pr(this);
        return uGTextView;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, this.pr)) {
            this.pr = "";
        }
        k(this.pr);
        ((UGTextView) this.c).setTextSize(1, this.ks);
        ((UGTextView) this.c).setTextColor(this.qx);
        ((UGTextView) this.c).setLines(this.xb);
        ((UGTextView) this.c).setMaxLines(this.wz);
        ((UGTextView) this.c).setGravity(this.p);
        ((UGTextView) this.c).setIncludeFontPadding(false);
        ((UGTextView) this.c).setMinTextSize(zo.pr(this.hw, this.sr));
        uc(this.ku);
        if (nl()) {
            pr(this.fs);
        } else {
            pr(this.xg);
        }
        if (this.sx > 0.0f) {
            if (nl()) {
                lv();
            } else {
                zo();
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ((UGTextView) this.c).setBreakStrategy(0);
        }
        if (nl()) {
            if (this.lj) {
                if (this.tv <= 0.0f) {
                    this.tv = 1.0E-5f;
                }
                ((UGTextView) this.c).setShadowLayer(this.tv, this.yj, this.vv, this.oj);
            }
        } else {
            ((UGTextView) this.c).setShadowLayer(this.tv, this.h, this.t, this.oj);
        }
        if (this.fe == 1) {
            ((UGTextView) this.c).setTypeface(Typeface.DEFAULT, this.fe);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((UGTextView) this.c).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.uk, this.fe == 2));
        } else if (this.uk >= 500.0f) {
            ((UGTextView) this.c).setTypeface(Typeface.DEFAULT, 1);
        }
        if (Build.VERSION.SDK_INT >= 21 && zo.pr(this.hw, this.ks) > 0.0f) {
            ((UGTextView) this.c).setLetterSpacing(this.om / zo.pr(this.hw, this.ks));
        }
    }

    private void zo() {
        ((UGTextView) this.c).setLineSpacing(0.0f, this.sx);
    }

    private void lv() {
        if (this.sx <= 3.0f) {
            ((UGTextView) this.c).setLineSpacing(0.0f, this.sx);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(zo.pr(this.hw, (this.sx - (this.ks * 1.2f)) / 2.0f));
            ((UGTextView) this.c).setPadding(((UGTextView) this.c).getPaddingLeft(), ((UGTextView) this.c).getPaddingTop() + iRound, ((UGTextView) this.c).getPaddingRight(), ((UGTextView) this.c).getPaddingBottom() + iRound);
            ((UGTextView) this.c).setLineHeight(Math.round(zo.pr(this.hw, this.sx)));
        }
    }

    public void k(String str) {
        this.pr = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, str)) {
            this.pr = "";
        }
        ((UGTextView) this.c).setText(this.pr);
    }

    public void uc(int i) {
        this.ku = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.c).setPaintFlags(i);
    }

    public void pr(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.c).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = cc.m;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 12;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 18;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 19;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 8;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 1;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 3;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = cc.n;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 2;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = cc.k;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = cc.l;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 11;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = 10;
                }
                break;
            case 3556653:
                if (str.equals(TextViewManager.NAME)) {
                    b = 0;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = 4;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = 7;
                }
                break;
            case 351195968:
                if (str.equals("minTextSize")) {
                    b = 20;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 5;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 6;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = 17;
                }
                break;
        }
        switch (b) {
            case 0:
                this.pr = str2;
                break;
            case 1:
                this.qx = com.byazt.aa.pr.pr(str2);
                break;
            case 2:
                this.ks = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 3:
                this.fe = g(str2);
                break;
            case 4:
                this.xb = com.byazt.aa.hn.pr(str2, 0);
                break;
            case 5:
                int iPr = com.byazt.aa.hn.pr(str2, Integer.MAX_VALUE);
                this.wz = iPr > 0 ? iPr : Integer.MAX_VALUE;
                break;
            case 6:
                this.xg = w(str2);
                break;
            case 7:
                this.fs = m(str2);
                break;
            case 8:
                this.p = ho(str2);
                break;
            case 9:
                this.ku = nt(str2);
                break;
            case 10:
                this.sx = com.byazt.aa.hn.pr(str2, 1.0f);
                break;
            case 11:
                float fPr = com.byazt.aa.hn.pr(str2, -1.0f);
                this.uk = fPr;
                if (fPr < 1.0f || fPr > 1000.0f) {
                    this.uk = 400.0f;
                }
                break;
            case 12:
                this.oj = com.byazt.aa.pr.pr(str2);
                this.lj = true;
                break;
            case 13:
                this.h = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 14:
                this.t = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 15:
            case 16:
                this.tv = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case 17:
                this.om = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 18:
                this.yj = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 19:
                this.vv = zo.pr(this.hw, com.byazt.aa.hn.pr(str2, 0.0f));
                break;
            case 20:
                this.sr = com.byazt.aa.hn.pr(str2, -1.0f);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private TextUtils.TruncateAt w(String str) {
        switch (str) {
            case "start":
                this.xg = TextUtils.TruncateAt.START;
                break;
            case "center":
                this.xg = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.xg = TextUtils.TruncateAt.END;
                break;
            default:
                this.xg = null;
                break;
        }
        return this.xg;
    }

    private TextUtils.TruncateAt m(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    private int g(String str) {
        switch (str) {
            case "bold":
                return 1;
            case "italic":
                return 2;
            case "normal":
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private int ho(String str) {
        switch (str) {
            case "left":
                return 3;
            case "right":
                return 5;
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "center_horizontal":
                return 1;
            default:
                return 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    private int nt(String str) {
        switch (str) {
            case "strikethrough":
                return 16;
            case "underline":
                return 8;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
