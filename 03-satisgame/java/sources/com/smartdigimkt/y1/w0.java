package com.smartdigimkt.y1;

import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PuzzleV2G2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ PuzzleV2G2CV2View a;

    public w0(PuzzleV2G2CV2View puzzleV2G2CV2View) {
        this.a = puzzleV2G2CV2View;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2;
        PuzzleV2G2CV2View puzzleV2G2CV2View = this.a;
        int i3 = PuzzleV2G2CV2View.t;
        puzzleV2G2CV2View.getClass();
        if (i < 15) {
            i2 = 0;
        } else {
            i2 = i > 85 ? 100 : i - 15;
        }
        if (!z) {
            PuzzleV2G2CV2View.b(this.a, i2);
            if (i2 == 100 && i == 100) {
                PuzzleV2G2CV2View puzzleV2G2CV2View2 = this.a;
                puzzleV2G2CV2View2.removeAllViews();
                puzzleV2G2CV2View2.b();
                return;
            }
            return;
        }
        PuzzleV2G2CV2View puzzleV2G2CV2View3 = this.a;
        if (puzzleV2G2CV2View3.q) {
            puzzleV2G2CV2View3.q = false;
            if (i2 > 30) {
                puzzleV2G2CV2View3.p = false;
            } else {
                puzzleV2G2CV2View3.p = true;
            }
        }
        if (!puzzleV2G2CV2View3.p) {
            seekBar.setProgress(0);
        } else if (i2 > 30) {
            PuzzleV2G2CV2View.a(puzzleV2G2CV2View3, i);
        } else {
            PuzzleV2G2CV2View.b(puzzleV2G2CV2View3, i2);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        PuzzleV2G2CV2View puzzleV2G2CV2View = this.a;
        puzzleV2G2CV2View.q = true;
        ImageView imageView = puzzleV2G2CV2View.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TranslateAnimation translateAnimation = this.a.m;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        PuzzleV2G2CV2View puzzleV2G2CV2View = this.a;
        if (puzzleV2G2CV2View.p) {
            PuzzleV2G2CV2View.b(puzzleV2G2CV2View, 0);
            ImageView imageView = this.a.k;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TranslateAnimation translateAnimation = this.a.m;
            if (translateAnimation != null) {
                translateAnimation.start();
            }
        }
    }
}
