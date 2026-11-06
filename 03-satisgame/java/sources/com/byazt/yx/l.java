package com.byazt.yx;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 18})
public class l extends com.byazt.ih.n<FlexboxLayout> {
    public int dm;
    public int ei;
    public int o;
    public int sq;
    public int vo;

    public l(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout n() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.qg);
        flexboxLayout.n(this);
        return flexboxLayout;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        ((FlexboxLayout) this.l).setFlexDirection(this.sq);
        ((FlexboxLayout) this.l).setFlexWrap(this.ei);
        ((FlexboxLayout) this.l).setJustifyContent(this.dm);
        ((FlexboxLayout) this.l).setAlignItems(this.vo);
        ((FlexboxLayout) this.l).setAlignContent(this.o);
    }

    @Override // com.byazt.ih.n
    public com.byazt.ih.n.C0202n fs() {
        return new n(this);
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n extends com.byazt.ih.n.C0202n {
        public int an;
        public int bb;
        public int h;
        public int j;
        public int lh;
        public float ln;
        public float t;
        public float ur;
        public int v;

        public n(com.byazt.ih.n nVar) {
            super(nVar);
            this.h = 1;
            this.t = 0.0f;
            this.ur = 0.0f;
            this.bb = -1;
            this.ln = -1.0f;
            this.lh = -1;
            this.v = -1;
            this.j = ViewCompat.MEASURED_SIZE_MASK;
            this.an = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.byazt.ih.n.C0202n
        public void n(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.n(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.ln = q(str2);
                    break;
                case "order":
                    this.h = n(str2);
                    break;
                case "flexShrink":
                    this.ur = s(str2);
                    break;
                case "flexGrow":
                    this.t = qg(str2);
                    break;
                case "alignSelf":
                    this.bb = l(str2);
                    break;
            }
        }

        private int n(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float qg(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float s(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float q(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        private int l(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.byazt.ih.n.C0202n
        /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.n n() {
            FlexboxLayout.n nVar = new FlexboxLayout.n((int) this.n, (int) this.qg);
            nVar.leftMargin = (int) this.w;
            nVar.rightMargin = (int) this.x;
            nVar.topMargin = (int) this.fs;
            nVar.bottomMargin = (int) this.rv;
            nVar.s(this.h);
            nVar.q(this.bb);
            nVar.n(this.t);
            nVar.qg(this.ur);
            nVar.s(this.ln);
            return nVar;
        }

        @Override // com.byazt.ih.n.C0202n
        public String toString() {
            return "LayoutParams{mWidth=" + this.n + ", mHeight=" + this.qg + ", mMargin=" + this.l + ", mMarginLeft=" + this.w + ", mMarginRight=" + this.x + ", mMarginTop=" + this.fs + ", mMarginBottom=" + this.rv + ", mParams=" + this.m + ", mOrder=" + this.h + ", mFlexGrow=" + this.t + ", mFlexShrink=" + this.ur + ", mAlignSelf=" + this.bb + ", mFlexBasisPercent=" + this.ln + ", mMinWidth=" + this.lh + ", mMinHeight=" + this.v + ", mMaxWidth=" + this.j + ", mMaxHeight=" + this.an + "} " + super.toString();
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.vo = k(str2);
                break;
            case "flexDirection":
                this.sq = d(str2);
                break;
            case "alignContent":
                this.o = cy(str2);
                break;
            case "flexWrap":
                this.ei = oa(str2);
                break;
            case "justifyContent":
                this.dm = sz(str2);
                break;
        }
    }

    public int d(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int oa(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int sz(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private int k(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 4;
                break;
            case "baseline":
                b = 3;
                break;
            case "center":
                b = 2;
                break;
            case "flex_start":
                b = 0;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b != 2) {
            return b != 3 ? 4 : 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private int cy(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 5;
                break;
            case "center":
                b = 2;
                break;
            case "space_around":
                b = 3;
                break;
            case "flex_start":
                b = 0;
                break;
            case "space_between":
                b = 4;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b == 2) {
            return 2;
        }
        if (b != 3) {
            return b != 4 ? 5 : 3;
        }
        return 4;
    }
}
