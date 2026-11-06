package com.byazt.ud;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.byazt.hb.fs;
import com.byazt.ih.s;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 106, 26})
public class qg extends s<UGTextView> {

    @Deprecated
    public TextUtils.TruncateAt bz;
    public float ct;
    public float dm;
    public int ei;
    public int eq;
    public TextUtils.TruncateAt il;
    public float jh;
    public float la;
    public float lg;
    public String n;
    public int nk;
    public int o;
    public boolean ox;
    public float qh;
    public int qn;
    public int sq;

    @Deprecated
    public float ti;
    public float vo;
    public float xb;

    @Deprecated
    public float xd;
    public int ze;

    public qg(Context context) {
        super(context);
        this.sq = ViewCompat.MEASURED_STATE_MASK;
        this.dm = 12.0f;
        this.vo = -1.0f;
        this.o = Integer.MAX_VALUE;
        this.ze = GravityCompat.START;
        this.il = TextUtils.TruncateAt.END;
        this.la = -1.0f;
        this.qh = 400.0f;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGTextView n() {
        UGTextView uGTextView = new UGTextView(this.qg);
        uGTextView.n(this);
        return uGTextView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, this.n)) {
            this.n = "";
        }
        oa(this.n);
        ((UGTextView) this.l).setTextSize(1, this.dm);
        ((UGTextView) this.l).setTextColor(this.sq);
        ((UGTextView) this.l).setLines(this.nk);
        ((UGTextView) this.l).setMaxLines(this.o);
        ((UGTextView) this.l).setGravity(this.ze);
        ((UGTextView) this.l).setIncludeFontPadding(false);
        ((UGTextView) this.l).setMinTextSize(fs.n(this.qg, this.vo));
        x(this.qn);
        if (ln()) {
            n(this.il);
        } else {
            n(this.bz);
        }
        if (this.la > 0.0f) {
            if (ln()) {
                cx();
            } else {
                fs();
            }
        }
        ((UGTextView) this.l).setBreakStrategy(0);
        if (ln()) {
            if (this.ox) {
                if (this.xb <= 0.0f) {
                    this.xb = 1.0E-5f;
                }
                ((UGTextView) this.l).setShadowLayer(this.xb, this.lg, this.jh, this.eq);
            }
        } else {
            ((UGTextView) this.l).setShadowLayer(this.xb, this.xd, this.ti, this.eq);
        }
        if (this.ei == 1) {
            ((UGTextView) this.l).setTypeface(Typeface.DEFAULT, this.ei);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((UGTextView) this.l).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.qh, this.ei == 2));
        } else if (this.qh >= 500.0f) {
            ((UGTextView) this.l).setTypeface(Typeface.DEFAULT, 1);
        }
        if (fs.n(this.qg, this.dm) > 0.0f) {
            ((UGTextView) this.l).setLetterSpacing(this.ct / fs.n(this.qg, this.dm));
        }
    }

    private void fs() {
        ((UGTextView) this.l).setLineSpacing(0.0f, this.la);
    }

    private void cx() {
        if (this.la <= 3.0f) {
            ((UGTextView) this.l).setLineSpacing(0.0f, this.la);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(fs.n(this.qg, (this.la - (this.dm * 1.2f)) / 2.0f));
            ((UGTextView) this.l).setPadding(((UGTextView) this.l).getPaddingLeft(), ((UGTextView) this.l).getPaddingTop() + iRound, ((UGTextView) this.l).getPaddingRight(), ((UGTextView) this.l).getPaddingBottom() + iRound);
            ((UGTextView) this.l).setLineHeight(Math.round(fs.n(this.qg, this.la)));
        }
    }

    public void oa(String str) {
        this.n = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, str)) {
            this.n = "";
        }
        ((UGTextView) this.l).setText(this.n);
        if (this.oa == -2.0f || this.sz == -2.0f) {
            b();
        }
    }

    public void w(int i) {
        this.sq = i;
        ((UGTextView) this.l).setTextColor(this.sq);
    }

    public void x(int i) {
        this.qn = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.l).setPaintFlags(i);
    }

    public void n(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.l).setEllipsize(truncateAt);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "shadowRadius":
            case "shadowBlur":
                this.xb = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "shadowColor":
                this.eq = com.byazt.hb.n.n(str2);
                this.ox = true;
                break;
            case "shadowOffsetX":
                this.lg = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "shadowOffsetY":
                this.jh = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
            case "textAlign":
                this.ze = cy(str2);
                break;
            case "textColor":
                this.sq = com.byazt.hb.n.n(str2);
                break;
            case "textStyle":
                this.ei = k(str2);
                break;
            case "textSize":
                this.dm = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "textDecoration":
                this.qn = hd(str2);
                break;
            case "shadowDx":
                this.xd = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "shadowDy":
                this.ti = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "fontWeight":
                float fN = com.byazt.hb.s.n(str2, -1.0f);
                this.qh = fN;
                if (fN < 1.0f || fN > 1000.0f) {
                    this.qh = 400.0f;
                    break;
                }
                break;
            case "lineHeight":
                this.la = com.byazt.hb.s.n(str2, 1.0f);
                break;
            case "text":
                this.n = str2;
                break;
            case "lines":
                this.nk = com.byazt.hb.s.n(str2, 0);
                break;
            case "ellipsis":
                this.il = sz(str2);
                break;
            case "minTextSize":
                this.vo = com.byazt.hb.s.n(str2, -1.0f);
                break;
            case "maxLines":
                int iN = com.byazt.hb.s.n(str2, Integer.MAX_VALUE);
                this.o = iN > 0 ? iN : Integer.MAX_VALUE;
                break;
            case "ellipsize":
                this.bz = d(str2);
                break;
            case "letterSpacing":
                this.ct = fs.n(this.qg, com.byazt.hb.s.n(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt d(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.bz = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.bz = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.bz = TextUtils.TruncateAt.START;
                break;
            default:
                this.bz = null;
                break;
        }
        return this.bz;
    }

    private TextUtils.TruncateAt sz(String str) {
        if (TextUtils.equals(str, LiveConfigKey.NONE)) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private int k(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals("bold")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("normal")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str.equals("italic")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            return b != 1 ? 0 : 2;
        }
        return 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int cy(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    b = 0;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    b = 1;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b = 2;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b = 3;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    private int hd(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
