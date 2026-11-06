package com.byazt.of;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.hg.of;
import com.byazt.ik.hn;
import com.byazt.oc.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 37})
public class pr extends hn<UpieImageView> {
    public ImageView.ScaleType pr;
    public boolean qx;

    public pr(Context context) {
        super(context);
        this.pr = ImageView.ScaleType.FIT_XY;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UpieImageView pr() {
        return new UpieImageView(this.hw, null, null, null);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            super.pr(str, str2);
            switch (str) {
                case "scaleType":
                case "scaleMode":
                    this.pr = w(str2);
                    break;
                case "isBgGaussianBlur":
                    this.qx = com.byazt.aa.hn.pr(str2, false);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0071  */
    private ImageView.ScaleType w(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        switch (str) {
            case "fitXY":
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "fitCenter":
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "center":
                return ImageView.ScaleType.CENTER;
            case "centerCrop":
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        of ofVarPr = com.byazt.sd.pr.pr(this.x);
        if (ofVarPr != null) {
            ((UpieImageView) this.c).pr(com.byazt.ja.pr.pr(ofVarPr, this.x), com.byazt.vr.pr.pr(ofVarPr), com.byazt.ja.pr.w(ofVarPr));
            ((UpieImageView) this.c).setScaleType(this.pr);
        }
    }
}
