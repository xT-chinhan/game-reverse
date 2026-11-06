package com.byazt.pi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.ca.g;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 1787})
public class TTRatingBar extends LinearLayout {
    public float c;
    public float hn;
    public int hw;
    public int pr;
    public float x;

    public TTRatingBar(Context context) {
        super(context);
        this.pr = 5;
        this.hw = 0;
        pr(context);
    }

    private void pr(Context context) {
        setOrientation(0);
        this.hn = pr(context, 15.0f);
        this.x = pr(context, 15.0f);
        this.c = pr(context, 5.0f);
    }

    private int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStarFillNum() {
        return this.pr;
    }

    public void setStarFillNum(int i) {
        this.pr = i;
    }

    public int getStarEmptyNum() {
        return this.hw;
    }

    public void setStarEmptyNum(int i) {
        this.hw = i;
    }

    public float getStarImageWidth() {
        return this.hn;
    }

    public void setStarImageWidth(float f) {
        this.hn = f;
    }

    public float getStarImageHeight() {
        return this.x;
    }

    public void setStarImageHeight(float f) {
        this.x = f;
    }

    public float getStarImagePadding() {
        return this.c;
    }

    public void setStarImagePadding(float f) {
        this.c = f;
    }

    public void pr() {
        removeAllViews();
        g.pr(getContext(), "tt_star_full_bg", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.pi.TTRatingBar.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar.this.getContext().getResources(), bitmap);
                for (int i = 0; i < TTRatingBar.this.getStarFillNum(); i++) {
                    ImageView starImageView = TTRatingBar.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar.this.addView(starImageView);
                }
                TTRatingBar.this.hw();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        g.pr(getContext(), "tt_star_empty_bg", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.pi.TTRatingBar.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar.this.getContext().getResources(), bitmap);
                for (int i = 0; i < TTRatingBar.this.getStarEmptyNum(); i++) {
                    ImageView starImageView = TTRatingBar.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar.this.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.hn), Math.round(this.x)));
        imageView.setPadding(0, 0, Math.round(this.c), 0);
        return imageView;
    }
}
