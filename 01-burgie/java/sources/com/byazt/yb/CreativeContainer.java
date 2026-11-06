package com.byazt.yb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.iu;
import com.byazt.hg.of;
import com.byazt.oc.UpieImageView;
import com.byazt.tg.fw;
import com.byazt.uq.uc;
import com.byazt.wt.er;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.Constants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, Constants.OAIDErrorCode.OAID_INVALID_RESULT})
public class CreativeContainer extends FrameLayout implements fw.pr {
    public boolean c;
    public UpieImageView hn;
    public fw hw;
    public final uc pr;
    public View.OnLayoutChangeListener uc;
    public View x;

    public CreativeContainer(Context context, of ofVar, uc ucVar) {
        super(context);
        this.pr = ucVar;
        if (!of.hn(ofVar)) {
            UpieImageView upieImageView = new UpieImageView(context, com.byazt.ja.pr.vk(ofVar), com.byazt.vr.pr.pr(ofVar), null);
            this.hn = upieImageView;
            addView(upieImageView, new FrameLayout.LayoutParams(-1, -1));
            this.hn.setVisibility(4);
            hw();
        }
    }

    public static boolean pr(of ofVar) {
        return of.pr(ofVar) && !of.hw(ofVar);
    }

    public static boolean hw(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        if (of.hn(ofVar)) {
            if (pr(ofVar) || com.byazt.lpk.pr.pr(ofVar) || k.pr(ofVar)) {
                return false;
            }
            return iu.c(ofVar);
        }
        return hn(ofVar);
    }

    public void setSizeView(View view) {
        if (view == null) {
            return;
        }
        View view2 = this.x;
        if (view2 != view) {
            er.zo(view2);
            this.c = false;
            View.OnLayoutChangeListener onLayoutChangeListener = this.uc;
            if (onLayoutChangeListener != null) {
                removeOnLayoutChangeListener(onLayoutChangeListener);
                this.uc = null;
            }
            fw fwVar = this.hw;
            if (fwVar != null) {
                fwVar.vk();
            }
            this.x = view;
        }
        er.zo(this.x);
        hw();
    }

    private void hw() {
        if (this.hn == null && this.x == null) {
            return;
        }
        uc ucVar = this.pr;
        if (ucVar == null) {
            x();
            return;
        }
        if (this.hw == null) {
            fw fwVarPr = ucVar.pr();
            this.hw = fwVarPr;
            if (fwVarPr == null) {
                x();
                return;
            }
            fwVarPr.pr((fw.pr) this);
        }
        hn();
    }

    private void hn() {
        if (this.c || this.hw == null) {
            return;
        }
        View view = this.hn;
        if (view == null) {
            view = this;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            this.c = true;
            this.hw.hw(this, view);
        } else {
            if (this.uc != null) {
                return;
            }
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.byazt.yb.CreativeContainer.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int i9 = i3 - i;
                    int i10 = i4 - i2;
                    if (!CreativeContainer.this.c && i9 > 0 && i10 > 0) {
                        CreativeContainer.this.c = true;
                        CreativeContainer.this.removeOnLayoutChangeListener(this);
                        CreativeContainer.this.uc = null;
                        CreativeContainer.this.hw.hw(CreativeContainer.this, CreativeContainer.this.hn != null ? CreativeContainer.this.hn : CreativeContainer.this);
                    }
                }
            };
            this.uc = onLayoutChangeListener;
            addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.byazt.tg.fw.pr
    public void pr(ViewGroup viewGroup) {
        View view;
        UpieImageView upieImageView = this.hn;
        if (upieImageView != null) {
            upieImageView.setVisibility(8);
        } else {
            if (viewGroup == null || (view = this.x) == null) {
                return;
            }
            er.zo(view);
            viewGroup.addView(this.x, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.byazt.tg.fw.pr
    public void pr() {
        x();
    }

    private void x() {
        fw fwVar = this.hw;
        if (fwVar != null) {
            fwVar.vk();
        }
        UpieImageView upieImageView = this.hn;
        if (upieImageView != null) {
            upieImageView.setVisibility(0);
            return;
        }
        View view = this.x;
        if (view == null || view.getParent() == this) {
            return;
        }
        er.zo(this.x);
        addView(this.x, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public static boolean hn(of ofVar) {
        if (pr(ofVar) || ofVar == null || of.hn(ofVar)) {
            return false;
        }
        return iu.c(ofVar) || com.byazt.ja.pr.zo(ofVar);
    }
}
