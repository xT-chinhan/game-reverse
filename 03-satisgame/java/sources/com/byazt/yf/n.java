package com.byazt.yf;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.gu.w;
import com.byazt.ih.s;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 19})
public class n extends s<UgenGif> {
    public String n;
    public ImageView.ScaleType sq;

    public n(Context context) {
        super(context);
        this.sq = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UgenGif n() {
        this.l = new UgenGif(this.qg);
        ((UgenGif) this.l).n(this);
        return (UgenGif) this.l;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        fs();
        ((UgenGif) this.l).setScaleType(this.sq);
    }

    private void fs() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        if (this.n.startsWith("local://")) {
            try {
                sz.n(this.qg, this.n.replace("local://", ""), (ImageView) this.l, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        w.n().qg().n(this.rv, this.n, (ImageView) this.l, null);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.sq = d(str2);
        } else if (str.equals("src")) {
            this.n = str2;
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
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void l() {
        super.l();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void n(boolean z) {
        super.n(z);
        if (z) {
            qg();
        }
    }
}
