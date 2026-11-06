package com.byazt.ndr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.cp.n;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1119})
public class TTRatingBar2 extends FrameLayout {
    public int fs;
    public double l;
    public LinearLayout n;
    public int q;
    public LinearLayout qg;
    public int rv;
    public int s;
    public int w;
    public int x;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new LinearLayout(getContext());
        this.qg = new LinearLayout(getContext());
        this.n.setOrientation(0);
        this.n.setGravity(GravityCompat.START);
        this.qg.setOrientation(0);
        this.qg.setGravity(GravityCompat.START);
    }

    public void setRating(double d) {
        this.l = d;
    }

    public void n(int i, int i2) {
        this.s = i2;
        this.q = i;
    }

    public void n() {
        removeAllViews();
        sz.n(getContext(), "tt_ratingbar_full_star2", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ndr.TTRatingBar2.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.qg.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        sz.n(getContext(), "tt_ratingbar_empty_star2", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ndr.TTRatingBar2.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.n.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.n);
        addView(this.qg);
        requestLayout();
    }

    public void n(int i, int i2, int i3, int i4) {
        this.w = i;
        this.x = i2;
        this.fs = i3;
        this.rv = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.s, this.q);
        layoutParams.leftMargin = this.w;
        layoutParams.topMargin = this.x;
        layoutParams.rightMargin = this.fs;
        layoutParams.bottomMargin = this.rv;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n.measure(i, i2);
        double dFloor = Math.floor(this.l);
        int i3 = this.w;
        int i4 = this.fs + i3;
        int i5 = this.s;
        this.qg.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.l - dFloor) * ((double) i5))), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(this.n.getMeasuredHeight(), C.ENCODING_PCM_32BIT));
    }
}
