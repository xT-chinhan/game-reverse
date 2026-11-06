package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.adsdk.ugeno.xr.ms<FlexboxLayout> {
    private int gs;
    private int kl;
    private int nl;
    private int r;
    private int vf;

    public ka(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout ms() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.xr);
        flexboxLayout.ms(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((FlexboxLayout) this.ka).setFlexDirection(this.vf);
        ((FlexboxLayout) this.ka).setFlexWrap(this.kl);
        ((FlexboxLayout) this.ka).setJustifyContent(this.gs);
        ((FlexboxLayout) this.ka).setAlignItems(this.r);
        ((FlexboxLayout) this.ka).setAlignContent(this.nl);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public com.bytedance.adsdk.ugeno.xr.ms.C0201ms x() {
        return new ms(this);
    }

    public static class ms extends com.bytedance.adsdk.ugeno.xr.ms.C0201ms {
        public int cv;
        public float g;
        public int jw;
        public float le;
        public int of;
        public float op;
        public int p;
        public int pc;
        public int yu;

        public ms(com.bytedance.adsdk.ugeno.xr.ms msVar) {
            super(msVar);
            this.yu = 1;
            this.op = 0.0f;
            this.le = 0.0f;
            this.cv = -1;
            this.g = -1.0f;
            this.of = -1;
            this.p = -1;
            this.pc = ViewCompat.MEASURED_SIZE_MASK;
            this.jw = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        public void ms(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.ms(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.g = d(str2);
                    break;
                case "order":
                    this.yu = ms(str2);
                    break;
                case "flexShrink":
                    this.le = ah(str2);
                    break;
                case "flexGrow":
                    this.op = xr(str2);
                    break;
                case "alignSelf":
                    this.cv = ka(str2);
                    break;
            }
        }

        private int ms(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                sl.ms(e);
                return 1;
            }
        }

        private float xr(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                sl.ms(e);
                return 0.0f;
            }
        }

        private float ah(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                sl.ms(e);
                return 0.0f;
            }
        }

        private float d(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                sl.ms(e);
                return -1.0f;
            }
        }

        private int ka(String str) {
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

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.ms ms() {
            FlexboxLayout.ms msVar = new FlexboxLayout.ms((int) this.f439ms, (int) this.xr);
            msVar.leftMargin = (int) this.c;
            msVar.rightMargin = (int) this.ab;
            msVar.topMargin = (int) this.x;
            msVar.bottomMargin = (int) this.ny;
            msVar.ah(this.yu);
            msVar.d(this.cv);
            msVar.ms(this.op);
            msVar.xr(this.le);
            msVar.ah(this.g);
            return msVar;
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        public String toString() {
            return "LayoutParams{mWidth=" + this.f439ms + ", mHeight=" + this.xr + ", mMargin=" + this.ka + ", mMarginLeft=" + this.c + ", mMarginRight=" + this.ab + ", mMarginTop=" + this.x + ", mMarginBottom=" + this.ny + ", mParams=" + this.i + ", mOrder=" + this.yu + ", mFlexGrow=" + this.op + ", mFlexShrink=" + this.le + ", mAlignSelf=" + this.cv + ", mFlexBasisPercent=" + this.g + ", mMinWidth=" + this.of + ", mMinHeight=" + this.p + ", mMaxWidth=" + this.pc + ", mMaxHeight=" + this.jw + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.r = hi(str2);
                break;
            case "flexDirection":
                this.vf = x(str2);
                break;
            case "alignContent":
                this.nl = sl(str2);
                break;
            case "flexWrap":
                this.kl = ny(str2);
                break;
            case "justifyContent":
                this.gs = ch(str2);
                break;
        }
    }

    int x(String str) {
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

    private int ny(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int ch(String str) {
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
    private int hi(String str) {
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
    private int sl(String str) {
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
