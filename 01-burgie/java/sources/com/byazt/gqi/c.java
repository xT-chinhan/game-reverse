package com.byazt.gqi;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 600, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.ik.pr<FlexboxLayout> {
    public int fe;
    public int ks;
    public int qx;
    public int sr;
    public int wz;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: lv, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout pr() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.hw);
        flexboxLayout.pr(this);
        return flexboxLayout;
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((FlexboxLayout) this.c).setFlexDirection(this.qx);
        ((FlexboxLayout) this.c).setFlexWrap(this.fe);
        ((FlexboxLayout) this.c).setJustifyContent(this.ks);
        ((FlexboxLayout) this.c).setAlignItems(this.sr);
        ((FlexboxLayout) this.c).setAlignContent(this.wz);
    }

    @Override // com.byazt.ik.pr
    public com.byazt.ik.pr.C0097pr zo() {
        return new pr(this);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 600, 169})
    public static class pr extends com.byazt.ik.pr.C0097pr {
        public int b;
        public int e;
        public int gz;
        public float iu;
        public int n;
        public float nl;
        public float ve;
        public int ww;
        public int y;

        public pr(com.byazt.ik.pr prVar) {
            super(prVar);
            this.b = 1;
            this.iu = 0.0f;
            this.ve = 0.0f;
            this.gz = -1;
            this.nl = -1.0f;
            this.y = -1;
            this.ww = -1;
            this.n = ViewCompat.MEASURED_SIZE_MASK;
            this.e = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.byazt.ik.pr.C0097pr
        public void pr(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.pr(context, str, str2);
            switch (str) {
                case "order":
                    this.b = pr(str2);
                    break;
                case "flexGrow":
                    this.iu = hw(str2);
                    break;
                case "flexShrink":
                    this.ve = hn(str2);
                    break;
                case "flexBasisPercent":
                    this.nl = x(str2);
                    break;
                case "alignSelf":
                    this.gz = c(str2);
                    break;
            }
        }

        private int pr(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 1;
            }
        }

        private float hw(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                return 0.0f;
            }
        }

        private float hn(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                return 0.0f;
            }
        }

        private float x(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                return -1.0f;
            }
        }

        private int c(String str) {
            switch (str) {
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                case "center":
                    return 2;
                case "baseline":
                    return 3;
                case "stretch":
                    return 4;
                default:
                    return -1;
            }
        }

        @Override // com.byazt.ik.pr.C0097pr
        /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.pr pr() {
            FlexboxLayout.pr prVar = new FlexboxLayout.pr((int) this.pr, (int) this.hw);
            prVar.leftMargin = (int) this.uc;
            prVar.rightMargin = (int) this.fw;
            prVar.topMargin = (int) this.zo;
            prVar.bottomMargin = (int) this.aj;
            prVar.hn(this.b);
            prVar.x(this.gz);
            prVar.pr(this.iu);
            prVar.hw(this.ve);
            prVar.hn(this.nl);
            return prVar;
        }

        @Override // com.byazt.ik.pr.C0097pr
        public String toString() {
            return "LayoutParams{mWidth=" + this.pr + ", mHeight=" + this.hw + ", mMargin=" + this.c + ", mMarginLeft=" + this.uc + ", mMarginRight=" + this.fw + ", mMarginTop=" + this.zo + ", mMarginBottom=" + this.aj + ", mParams=" + this.rc + ", mOrder=" + this.b + ", mFlexGrow=" + this.iu + ", mFlexShrink=" + this.ve + ", mAlignSelf=" + this.gz + ", mFlexBasisPercent=" + this.nl + ", mMinWidth=" + this.y + ", mMinHeight=" + this.ww + ", mMaxWidth=" + this.n + ", mMaxHeight=" + this.e + "} " + super.toString();
        }
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        switch (str) {
            case "flexDirection":
                this.qx = w(str2);
                break;
            case "flexWrap":
                this.fe = k(str2);
                break;
            case "justifyContent":
                this.ks = m(str2);
                break;
            case "alignItems":
                this.sr = g(str2);
                break;
            case "alignContent":
                this.wz = ho(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public int w(String str) {
        switch (str) {
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            case "column_reverse":
                return 3;
            default:
                return 0;
        }
    }

    private int k(String str) {
        switch (str) {
            case "wrap":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    private int m(String str) {
        switch (str) {
            case "flex_end":
                return 1;
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private int g(String str) {
        switch (str) {
            case "flex_start":
                return 0;
            case "flex_end":
                return 1;
            case "center":
                return 2;
            case "baseline":
                return 3;
            case "stretch":
            default:
                return 4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private int ho(String str) {
        switch (str) {
            case "flex_start":
                return 0;
            case "flex_end":
                return 1;
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "stretch":
            default:
                return 5;
        }
    }
}
