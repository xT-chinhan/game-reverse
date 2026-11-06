package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.xr.ms<UGFrameLayout> {
    private UGFrameLayout vf;

    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout ms() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.xr);
        this.vf = uGFrameLayout;
        uGFrameLayout.ms(this);
        return this.vf;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        this.vf.setEventMap(this.nn);
        super.xr();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public com.bytedance.adsdk.ugeno.xr.ms.C0201ms x() {
        return new C0198ms(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.frame.ms$ms, reason: collision with other inner class name */
    public static class C0198ms extends com.bytedance.adsdk.ugeno.xr.ms.C0201ms {
        protected int yu;

        public C0198ms(com.bytedance.adsdk.ugeno.xr.ms msVar) {
            super(msVar);
            this.yu = -1;
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        public void ms(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.ms(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.yu = ms(str2);
            }
        }

        private int ms(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iXr = 0;
            for (String str2 : strArrSplit) {
                iXr |= xr(str2);
            }
            return iXr;
        }

        private int xr(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams ms() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f439ms, (int) this.xr);
            layoutParams.leftMargin = (int) this.c;
            layoutParams.rightMargin = (int) this.ab;
            layoutParams.topMargin = (int) this.x;
            layoutParams.bottomMargin = (int) this.ny;
            layoutParams.gravity = this.yu;
            return layoutParams;
        }
    }
}
