package com.byazt.pi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.ca.g;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, InputDeviceCompat.SOURCE_GAMEPAD})
public class TTRatingBar2 extends FrameLayout {
    public int aj;
    public double c;
    public int fw;
    public int hn;
    public LinearLayout hw;
    public LinearLayout pr;
    public int uc;
    public int x;
    public int zo;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pr = new LinearLayout(getContext());
        this.hw = new LinearLayout(getContext());
        this.pr.setOrientation(0);
        this.pr.setGravity(GravityCompat.START);
        this.hw.setOrientation(0);
        this.hw.setGravity(GravityCompat.START);
    }

    public void setRating(double d) {
        this.c = d;
    }

    public void pr(int i, int i2) {
        this.hn = i2;
        this.x = i;
    }

    public void pr() {
        removeAllViews();
        g.pr(getContext(), "tt_ratingbar_full_star2", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.pi.TTRatingBar2.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.hw.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        g.pr(getContext(), "tt_ratingbar_empty_star2", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.pi.TTRatingBar2.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.pr.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.pr);
        addView(this.hw);
        requestLayout();
    }

    public void pr(int i, int i2, int i3, int i4) {
        this.uc = i;
        this.fw = i2;
        this.zo = i3;
        this.aj = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hn, this.x);
        layoutParams.leftMargin = this.uc;
        layoutParams.topMargin = this.fw;
        layoutParams.rightMargin = this.zo;
        layoutParams.bottomMargin = this.aj;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pr.measure(i, i2);
        double dFloor = Math.floor(this.c);
        int i3 = this.uc;
        int i4 = this.zo + i3;
        int i5 = this.hn;
        this.hw.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.c - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.pr.getMeasuredHeight(), 1073741824));
    }
}
