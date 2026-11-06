package com.byazt.ndr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.cp.n;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1947})
public class TTRatingBar extends LinearLayout {
    public float l;
    public int n;
    public float q;
    public int qg;
    public float s;

    public TTRatingBar(Context context) {
        super(context);
        this.n = 5;
        this.qg = 0;
        n(context);
    }

    private void n(Context context) {
        setOrientation(0);
        this.s = n(context, 15.0f);
        this.q = n(context, 15.0f);
        this.l = n(context, 5.0f);
    }

    private int n(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStarFillNum() {
        return this.n;
    }

    public void setStarFillNum(int i) {
        this.n = i;
    }

    public int getStarEmptyNum() {
        return this.qg;
    }

    public void setStarEmptyNum(int i) {
        this.qg = i;
    }

    public float getStarImageWidth() {
        return this.s;
    }

    public void setStarImageWidth(float f) {
        this.s = f;
    }

    public float getStarImageHeight() {
        return this.q;
    }

    public void setStarImageHeight(float f) {
        this.q = f;
    }

    public float getStarImagePadding() {
        return this.l;
    }

    public void setStarImagePadding(float f) {
        this.l = f;
    }

    public void n() {
        removeAllViews();
        sz.n(getContext(), "tt_star_full_bg", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ndr.TTRatingBar.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar.this.getContext().getResources(), bitmap);
                for (int i = 0; i < TTRatingBar.this.getStarFillNum(); i++) {
                    ImageView starImageView = TTRatingBar.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar.this.addView(starImageView);
                }
                TTRatingBar.this.qg();
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        sz.n(getContext(), "tt_star_empty_bg", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.ndr.TTRatingBar.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
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
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.s), Math.round(this.q)));
        imageView.setPadding(0, 0, Math.round(this.l), 0);
        return imageView;
    }
}
