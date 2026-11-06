package com.byazt.mr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.lz.TTViewStub;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 210})
public class k {
    public TTViewStub fs;
    public qg l;
    public View n;
    public com.byazt.ia.qg q;
    public TextView qg;
    public View rv;
    public Context s;
    public boolean w = false;
    public com.byazt.zsl.s x;

    public enum n {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public interface qg {
        void w();

        boolean x();
    }

    public void n(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.rv = view;
        this.s = com.byazt.nf.rv.getContext().getApplicationContext();
        try {
            this.fs = new TTViewStub(context, new com.byazt.un.fs());
        } catch (Throwable unused) {
        }
    }

    private void n(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.fs) == null || tTViewStub.getParent() == null || this.n != null) {
            return;
        }
        this.fs.n();
        this.n = view.findViewById(2114387870);
        this.qg = (TextView) view.findViewById(2114387817);
        View viewFindViewById = view.findViewById(2114387880);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    k.this.s();
                    if (k.this.q != null) {
                        k.this.q.n(n.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void n(com.byazt.ia.qg qgVar, qg qgVar2) {
        this.l = qgVar2;
        this.q = qgVar;
    }

    private void qg() {
        this.x = null;
    }

    public boolean n(int i, com.byazt.zsl.s sVar, boolean z) {
        Context context = this.s;
        if (context != null && sVar != null) {
            try {
                n(context, this.rv, z);
                this.x = sVar;
                if (i == 1 || i == 2) {
                    return n(i);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private boolean n(int i) {
        qg qgVar;
        if (n() || this.w) {
            return true;
        }
        if (this.q != null && (qgVar = this.l) != null) {
            if (qgVar.x()) {
                this.q.l(null, null);
            }
            this.q.n(n.PAUSE_VIDEO, (String) null);
        }
        n(this.x, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.s == null) {
            return;
        }
        q();
    }

    public void n(boolean z) {
        if (z) {
            qg();
        }
        q();
    }

    public boolean n() {
        View view = this.n;
        return view != null && view.getVisibility() == 0;
    }

    private void q() {
        View view = this.n;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void n(com.byazt.zsl.s sVar, boolean z) {
        View view;
        View view2;
        if (sVar == null || (view = this.n) == null || this.s == null || view.getVisibility() == 0) {
            return;
        }
        qg qgVar = this.l;
        if (qgVar != null) {
            qgVar.w();
        }
        String str = z ? "播放将消耗" + ((int) Math.ceil((sVar.l() * 1.0d) / 1048576.0d)) + "MB流量" : "播放将消耗流量";
        com.byazt.okk.s.n(this.n, 0);
        com.byazt.okk.s.n(this.qg, str);
        if (!com.byazt.okk.s.q(this.n) || (view2 = this.n) == null) {
            return;
        }
        view2.bringToFront();
    }
}
