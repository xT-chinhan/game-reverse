package com.byazt.om;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1390, 19})
public class n extends com.byazt.ih.n<UGFrameLayout> {
    public UGFrameLayout sq;

    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout n() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.qg);
        this.sq = uGFrameLayout;
        uGFrameLayout.n(this);
        return this.sq;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        this.sq.setEventMap(this.xi);
        super.qg();
    }

    @Override // com.byazt.ih.n
    public com.byazt.ih.n.C0202n fs() {
        return new C0283n(this);
    }

    /* JADX INFO: renamed from: com.byazt.om.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1390, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0283n extends com.byazt.ih.n.C0202n {
        public int h;

        public C0283n(com.byazt.ih.n nVar) {
            super(nVar);
            this.h = -1;
        }

        @Override // com.byazt.ih.n.C0202n
        public void n(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.n(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.h = n(str2);
            }
        }

        private int n(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iQg = 0;
            for (String str2 : strArrSplit) {
                iQg |= qg(str2);
            }
            return iQg;
        }

        private int qg(String str) {
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

        @Override // com.byazt.ih.n.C0202n
        /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams n() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.n, (int) this.qg);
            layoutParams.leftMargin = (int) this.w;
            layoutParams.rightMargin = (int) this.x;
            layoutParams.topMargin = (int) this.fs;
            layoutParams.bottomMargin = (int) this.rv;
            layoutParams.gravity = this.h;
            return layoutParams;
        }
    }
}
