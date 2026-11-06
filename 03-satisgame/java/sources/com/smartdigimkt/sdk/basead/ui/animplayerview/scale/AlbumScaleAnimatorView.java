package com.smartdigimkt.sdk.basead.ui.animplayerview.scale;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.q1.m;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.s1.a;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlbumScaleAnimatorView extends FrameLayout implements m {
    public List a;
    public AlbumScaleMainView b;
    public AlbumScaleItemView01 c;
    public AlbumScaleItemView02 d;
    public AlbumScaleItemView03 e;
    public boolean f;

    public AlbumScaleAnimatorView(Context context) {
        this(context, null);
    }

    @Override // com.smartdigimkt.q1.m
    public void addMainView(Bitmap bitmap, WrapRoundImageView... wrapRoundImageViewArr) {
        if (bitmap == null) {
            return;
        }
        AlbumScaleMainView albumScaleMainView = new AlbumScaleMainView(getContext());
        this.b = albumScaleMainView;
        boolean zB = k.b(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(zB ? k.a(getContext(), 90) : k.a(getContext(), 42), zB ? k.a(getContext(), 42) : k.a(getContext(), 90));
        layoutParams.gravity = 17;
        albumScaleMainView.setLayoutParams(layoutParams);
        addView(this.b);
        this.b.initView(bitmap, true);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        AlbumScaleItemView03 albumScaleItemView03 = new AlbumScaleItemView03(getContext());
        albumScaleItemView03.setBitmapResources(this.a);
        albumScaleItemView03.setOrientation(k.b(getContext()));
        addView(albumScaleItemView03, layoutParams2);
        this.e = albumScaleItemView03;
        ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        AlbumScaleItemView02 albumScaleItemView02 = new AlbumScaleItemView02(getContext());
        albumScaleItemView02.setOrientation(k.b(getContext()));
        albumScaleItemView02.setBitmapResources(this.a);
        addView(albumScaleItemView02, layoutParams3);
        this.d = albumScaleItemView02;
        ViewGroup.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        AlbumScaleItemView01 albumScaleItemView01 = new AlbumScaleItemView01(getContext());
        albumScaleItemView01.setBitmapResources(this.a);
        albumScaleItemView01.setOrientation(k.b(getContext()));
        addView(albumScaleItemView01, layoutParams4);
        this.c = albumScaleItemView01;
    }

    @Override // com.smartdigimkt.q1.l
    public void pause() {
        AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.pause();
        }
        AlbumScaleItemView01 albumScaleItemView01 = this.c;
        if (albumScaleItemView01 != null) {
            albumScaleItemView01.pause();
        }
        AlbumScaleItemView02 albumScaleItemView02 = this.d;
        if (albumScaleItemView02 != null) {
            albumScaleItemView02.pause();
        }
        AlbumScaleItemView03 albumScaleItemView03 = this.e;
        if (albumScaleItemView03 != null) {
            albumScaleItemView03.pause();
        }
    }

    @Override // com.smartdigimkt.q1.m
    public void release() {
        List<Bitmap> list = this.a;
        if (list != null) {
            for (Bitmap bitmap : list) {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.a.clear();
        }
        AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.release();
        }
        AlbumScaleItemView01 albumScaleItemView01 = this.c;
        if (albumScaleItemView01 != null) {
            albumScaleItemView01.release();
        }
        AlbumScaleItemView02 albumScaleItemView02 = this.d;
        if (albumScaleItemView02 != null) {
            albumScaleItemView02.release();
        }
        AlbumScaleItemView03 albumScaleItemView03 = this.e;
        if (albumScaleItemView03 != null) {
            albumScaleItemView03.release();
        }
        removeAllViews();
    }

    public void resume() {
        AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.resume();
        }
        AlbumScaleItemView01 albumScaleItemView01 = this.c;
        if (albumScaleItemView01 != null) {
            albumScaleItemView01.resume();
        }
        AlbumScaleItemView02 albumScaleItemView02 = this.d;
        if (albumScaleItemView02 != null) {
            albumScaleItemView02.resume();
        }
        AlbumScaleItemView03 albumScaleItemView03 = this.e;
        if (albumScaleItemView03 != null) {
            albumScaleItemView03.resume();
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
        this.a = list;
    }

    @Override // com.smartdigimkt.q1.l
    public void start() {
        if (this.b == null || this.c == null || this.d == null || this.e == null) {
            return;
        }
        if (this.f) {
            resume();
        } else {
            post(new a(this));
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void stop() {
        AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.stop();
        }
        AlbumScaleItemView01 albumScaleItemView01 = this.c;
        if (albumScaleItemView01 != null) {
            albumScaleItemView01.stop();
        }
        AlbumScaleItemView02 albumScaleItemView02 = this.d;
        if (albumScaleItemView02 != null) {
            albumScaleItemView02.stop();
        }
        AlbumScaleItemView03 albumScaleItemView03 = this.e;
        if (albumScaleItemView03 != null) {
            albumScaleItemView03.stop();
        }
        this.f = false;
    }

    public AlbumScaleAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleAnimatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
    }
}
