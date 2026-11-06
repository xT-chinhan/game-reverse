package com.byazt.rg;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.om.n {
    public final float[] ei;
    public String sq;

    public rv(Context context) {
        super(context);
        this.ei = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.sq = str2;
        } else {
            super.n(str, str2);
        }
    }

    @Override // com.byazt.om.n, com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        d(this.sq);
        super.qg();
    }

    private void d(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.ei[i] = Float.parseFloat(com.byazt.oa.n.n(str2.trim(), this.q));
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    public float[] lq() {
        return this.ei;
    }
}
