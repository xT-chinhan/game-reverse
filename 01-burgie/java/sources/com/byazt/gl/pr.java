package com.byazt.gl;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.ik.hn;
import com.byazt.llk.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 840, 37})
public class pr extends hn<UgenGif> {
    public String pr;
    public ImageView.ScaleType qx;

    public pr(Context context) {
        super(context);
        this.qx = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UgenGif pr() {
        this.c = new UgenGif(this.hw);
        ((UgenGif) this.c).pr(this);
        return (UgenGif) this.c;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        zo();
        ((UgenGif) this.c).setScaleType(this.qx);
    }

    private void zo() {
        if (TextUtils.isEmpty(this.pr)) {
            return;
        }
        if (this.pr.startsWith("local://")) {
            try {
                g.pr(this.hw, this.pr.replace("local://", ""), (ImageView) this.c, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            } catch (Exception e) {
                return;
            }
        }
        uc.pr().hw().pr(this.aj, this.pr, (ImageView) this.c, null);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        switch (str) {
            case "src":
                this.pr = str2;
                break;
            case "scaleType":
                this.qx = w(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    private ImageView.ScaleType w(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        switch (str) {
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "center":
                return ImageView.ScaleType.CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void c() {
        super.c();
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void pr(boolean z) {
        super.pr(z);
        if (z) {
            hw();
        }
    }
}
