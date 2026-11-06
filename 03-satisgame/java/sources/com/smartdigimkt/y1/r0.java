package com.smartdigimkt.y1;

import android.widget.SeekBar;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ PicVerifyG2CV2View a;

    public r0(PicVerifyG2CV2View picVerifyG2CV2View) {
        this.a = picVerifyG2CV2View;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (!z) {
            this.a.h.move(i);
            if (i == 100) {
                this.a.h.loose();
                return;
            }
            return;
        }
        PicVerifyG2CV2View picVerifyG2CV2View = this.a;
        if (picVerifyG2CV2View.l) {
            picVerifyG2CV2View.l = false;
            if (i > 30) {
                picVerifyG2CV2View.k = false;
            } else {
                picVerifyG2CV2View.k = true;
            }
        }
        if (!picVerifyG2CV2View.k) {
            seekBar.setProgress(0);
        } else if (i > 30) {
            PicVerifyG2CV2View.a(picVerifyG2CV2View, i);
        } else {
            picVerifyG2CV2View.h.move(i);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        PicVerifyG2CV2View picVerifyG2CV2View = this.a;
        picVerifyG2CV2View.l = true;
        PicVerifyG2CV2View.b(picVerifyG2CV2View);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        PicVerifyG2CV2View picVerifyG2CV2View = this.a;
        if (picVerifyG2CV2View.k) {
            picVerifyG2CV2View.h.loose();
        }
        PicVerifyG2CV2View.a(this.a);
    }
}
