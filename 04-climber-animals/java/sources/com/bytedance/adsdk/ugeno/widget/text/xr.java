package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.umeng.analytics.pro.ek;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ah<UGTextView> {
    private boolean a;
    private int cc;

    @Deprecated
    private TextUtils.TruncateAt cj;
    private int di;
    private float dv;
    private int gs;
    private float kk;
    private float kl;

    @Deprecated
    private float mh;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f430ms;
    private int nl;
    private float ph;
    private float pl;
    private int qo;
    private int r;
    private float si;
    protected int vf;

    @Deprecated
    private float wp;
    private TextUtils.TruncateAt wq;
    private float zx;

    public xr(Context context) {
        super(context);
        this.vf = ViewCompat.MEASURED_STATE_MASK;
        this.kl = 12.0f;
        this.r = Integer.MAX_VALUE;
        this.qo = GravityCompat.START;
        this.wq = TextUtils.TruncateAt.END;
        this.si = -1.0f;
        this.pl = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UGTextView ms() {
        UGTextView uGTextView = new UGTextView(this.xr);
        uGTextView.ms(this);
        return uGTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, this.f430ms)) {
            this.f430ms = "";
        }
        x(this.f430ms);
        ((UGTextView) this.ka).setTextSize(1, this.kl);
        ((UGTextView) this.ka).setTextColor(this.vf);
        ((UGTextView) this.ka).setLines(this.nl);
        ((UGTextView) this.ka).setMaxLines(this.r);
        ((UGTextView) this.ka).setGravity(this.qo);
        ((UGTextView) this.ka).setIncludeFontPadding(false);
        c(this.cc);
        if (cv()) {
            ms(this.wq);
        } else {
            ms(this.cj);
        }
        if (this.si > 0.0f) {
            if (cv()) {
                am();
            } else {
                x();
            }
        }
        ((UGTextView) this.ka).setBreakStrategy(0);
        if (cv()) {
            if (this.a) {
                if (this.zx <= 0.0f) {
                    this.zx = 1.0E-5f;
                }
                ((UGTextView) this.ka).setShadowLayer(this.zx, this.kk, this.ph, this.di);
            }
        } else {
            ((UGTextView) this.ka).setShadowLayer(this.zx, this.mh, this.wp, this.di);
        }
        if (this.gs == 1) {
            ((UGTextView) this.ka).setTypeface(Typeface.DEFAULT, this.gs);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((UGTextView) this.ka).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.pl, this.gs == 2));
        } else if (this.pl >= 500.0f) {
            ((UGTextView) this.ka).setTypeface(Typeface.DEFAULT, 1);
        }
        if (x.ms(this.xr, this.kl) > 0.0f) {
            ((UGTextView) this.ka).setLetterSpacing(this.dv / x.ms(this.xr, this.kl));
        }
    }

    private void x() {
        ((UGTextView) this.ka).setLineSpacing(0.0f, this.si);
    }

    private void am() {
        if (this.si <= 3.0f) {
            ((UGTextView) this.ka).setLineSpacing(0.0f, this.si);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(x.ms(this.xr, (this.si - (this.kl * 1.2f)) / 2.0f));
            ((UGTextView) this.ka).setPadding(((UGTextView) this.ka).getPaddingLeft(), ((UGTextView) this.ka).getPaddingTop() + iRound, ((UGTextView) this.ka).getPaddingRight(), ((UGTextView) this.ka).getPaddingBottom() + iRound);
            ((UGTextView) this.ka).setLineHeight(Math.round(x.ms(this.xr, this.si)));
        }
    }

    public void x(String str) {
        this.f430ms = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, str)) {
            this.f430ms = "";
        }
        ((UGTextView) this.ka).setText(this.f430ms);
    }

    public void c(int i) {
        this.cc = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.ka).setPaintFlags(i);
    }

    public void ms(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.ka).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = 11;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 12;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = ek.k;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = ek.l;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = ek.m;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = ek.n;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 17;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 18;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = 19;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.zx = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 1:
                this.di = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                this.a = true;
                break;
            case 2:
                this.kk = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 3:
                this.ph = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
            case 4:
                this.qo = sl(str2);
                break;
            case 5:
                this.vf = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case 6:
                this.gs = hi(str2);
                break;
            case 8:
                this.kl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 9:
                this.cc = zb(str2);
                break;
            case 10:
                this.mh = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 11:
                this.wp = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case 12:
                float fMs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, -1.0f);
                this.pl = fMs;
                if (fMs < 1.0f || fMs > 1000.0f) {
                    this.pl = 400.0f;
                }
                break;
            case 13:
                this.si = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1.0f);
                break;
            case 14:
                this.f430ms = str2;
                break;
            case 15:
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0);
                break;
            case 16:
                this.wq = ch(str2);
                break;
            case 17:
                int iMs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, Integer.MAX_VALUE);
                this.r = iMs > 0 ? iMs : Integer.MAX_VALUE;
                break;
            case 18:
                this.cj = ny(str2);
                break;
            case 19:
                this.dv = x.ms(this.xr, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt ny(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.cj = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.cj = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.cj = TextUtils.TruncateAt.START;
                break;
            default:
                this.cj = null;
                break;
        }
        return this.cj;
    }

    private TextUtils.TruncateAt ch(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private int hi(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals("bold")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(PrerollVideoResponse.NORMAL)) {
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
    private int sl(String str) {
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

    private int zb(String str) {
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
