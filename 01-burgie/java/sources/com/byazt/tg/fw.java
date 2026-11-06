package com.byazt.tg;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.byazt.mq.g;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 62})
public class fw extends com.byazt.tg.pr {
    public View fw;
    public pr uc;

    public interface pr {
        void pr();

        void pr(ViewGroup viewGroup);
    }

    public fw(of ofVar, com.byazt.uq.pr prVar, bh bhVar) {
        super(ofVar, prVar, bhVar);
    }

    public void pr(pr prVar) {
        this.uc = prVar;
    }

    @Override // com.byazt.tg.pr
    public void pr(ViewGroup viewGroup, View view, View view2, float[] fArr, g gVar) {
        if (viewGroup == null || view2 == null) {
            pr(viewGroup);
            return;
        }
        View view3 = this.fw;
        if (view3 != null && view3 != view2) {
            w();
        }
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        this.fw = view2;
        view2.setVisibility(0);
        FrameLayout frameLayoutNt = gVar instanceof com.byazt.gu.hn ? ((com.byazt.gu.hn) gVar).nt() : null;
        pr prVar = this.uc;
        if (prVar != null) {
            prVar.pr(frameLayoutNt);
        }
    }

    public void vk() {
        w();
    }

    private void w() {
        View view = this.fw;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.fw = null;
    }

    @Override // com.byazt.tg.pr
    public void pr(ViewGroup viewGroup) {
        final pr prVar = this.uc;
        if (prVar == null) {
            return;
        }
        zo.pr(new Runnable() { // from class: com.byazt.tg.fw.1
            @Override // java.lang.Runnable
            public void run() {
                prVar.pr();
            }
        });
    }
}
