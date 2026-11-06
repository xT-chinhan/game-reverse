package com.byazt.dk;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.gct.pk;
import com.byazt.ih.s;
import com.byazt.vgx.qg;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 19})
public class n extends s<UpieImageView> {
    public ImageView.ScaleType n;
    public boolean sq;

    public n(Context context) {
        super(context);
        this.n = ImageView.ScaleType.FIT_XY;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UpieImageView n() {
        return new UpieImageView(this.qg, null, null, null);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.n = d(str2);
                break;
            case "isBgGaussianBlur":
                this.sq = com.byazt.hb.s.n(str2, false);
                break;
        }
    }

    private ImageView.ScaleType d(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        pk pkVarN = qg.n(this.q);
        if (pkVarN != null) {
            ((UpieImageView) this.l).n(com.byazt.aci.n.n(pkVarN, this.q), com.byazt.du.n.n(pkVarN), com.byazt.aci.n.d(pkVarN));
            ((UpieImageView) this.l).setScaleType(this.n);
        }
    }
}
