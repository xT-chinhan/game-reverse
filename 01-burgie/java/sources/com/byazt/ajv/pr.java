package com.byazt.ajv;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1342, 37})
public class pr extends com.byazt.ik.pr<UGFrameLayout> {
    public UGFrameLayout qx;

    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: lv, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout pr() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.hw);
        this.qx = uGFrameLayout;
        uGFrameLayout.pr(this);
        return this.qx;
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        this.qx.setEventMap(this.na);
        super.hw();
    }

    @Override // com.byazt.ik.pr
    public com.byazt.ik.pr.C0097pr zo() {
        return new C0013pr(this);
    }

    /* JADX INFO: renamed from: com.byazt.ajv.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1342, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0013pr extends com.byazt.ik.pr.C0097pr {
        public int b;

        public C0013pr(com.byazt.ik.pr prVar) {
            super(prVar);
            this.b = -1;
        }

        @Override // com.byazt.ik.pr.C0097pr
        public void pr(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.pr(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.b = pr(str2);
            }
        }

        private int pr(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iHw = 0;
            for (String str2 : strArrSplit) {
                iHw |= hw(str2);
            }
            return iHw;
        }

        private int hw(String str) {
            switch (str) {
                case "top":
                    return 48;
                case "bottom":
                    return 80;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center":
                    return 17;
                case "center_horizontal":
                    return 1;
                case "center_vertical":
                    return 16;
                default:
                    return -1;
            }
        }

        @Override // com.byazt.ik.pr.C0097pr
        /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams pr() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.pr, (int) this.hw);
            layoutParams.leftMargin = (int) this.uc;
            layoutParams.rightMargin = (int) this.fw;
            layoutParams.topMargin = (int) this.zo;
            layoutParams.bottomMargin = (int) this.aj;
            layoutParams.gravity = this.b;
            return layoutParams;
        }
    }
}
