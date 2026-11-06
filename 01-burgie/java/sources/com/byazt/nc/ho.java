package com.byazt.nc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.sd.a;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 19})
public class ho {
    public View aj;
    public hw c;
    public com.byazt.n.x fw;
    public Context hn;
    public TextView hw;
    public View pr;
    public boolean uc = false;
    public com.byazt.gz.hw x;
    public TTViewStub zo;

    public interface hw {
        void k();

        boolean vk();
    }

    public enum pr {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public void pr(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.aj = view;
            this.hn = a.getContext().getApplicationContext();
            try {
                this.zo = new TTViewStub(context, new com.byazt.jf.zo());
            } catch (Throwable th) {
            }
        }
    }

    private void pr(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.zo) == null || tTViewStub.getParent() == null || this.pr != null) {
            return;
        }
        this.zo.pr();
        this.pr = view.findViewById(2114387870);
        this.hw = (TextView) view.findViewById(2114387817);
        View viewFindViewById = view.findViewById(2114387880);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.ho.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ho.this.hn();
                    if (ho.this.x != null) {
                        ho.this.x.pr(pr.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void pr(com.byazt.gz.hw hwVar, hw hwVar2) {
        this.c = hwVar2;
        this.x = hwVar;
    }

    private void hw() {
        this.fw = null;
    }

    public boolean pr(int i, com.byazt.n.x xVar, boolean z) {
        Context context = this.hn;
        if (context == null || xVar == null) {
            return true;
        }
        try {
            pr(context, this.aj, z);
            this.fw = xVar;
            switch (i) {
                case 1:
                case 2:
                    return pr(i);
                default:
                    return true;
            }
        } catch (Throwable th) {
            return true;
        }
        return true;
    }

    private boolean pr(int i) {
        hw hwVar;
        if (pr() || this.uc) {
            return true;
        }
        if (this.x != null && (hwVar = this.c) != null) {
            if (hwVar.vk()) {
                this.x.c(null, null);
            }
            this.x.pr(pr.PAUSE_VIDEO, (String) null);
        }
        pr(this.fw, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        if (this.hn == null) {
            return;
        }
        x();
    }

    public void pr(boolean z) {
        if (z) {
            hw();
        }
        x();
    }

    public boolean pr() {
        View view = this.pr;
        return view != null && view.getVisibility() == 0;
    }

    private void x() {
        View view = this.pr;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void pr(com.byazt.n.x xVar, boolean z) {
        View view;
        String str;
        View view2;
        if (xVar == null || (view = this.pr) == null || this.hn == null || view.getVisibility() == 0) {
            return;
        }
        hw hwVar = this.c;
        if (hwVar != null) {
            hwVar.k();
        }
        int iCeil = (int) Math.ceil((xVar.c() * 1.0d) / 1048576.0d);
        if (z) {
            str = "播放将消耗" + iCeil + "MB流量";
        } else {
            str = "播放将消耗流量";
        }
        er.pr(this.pr, 0);
        er.pr(this.hw, str);
        if (er.x(this.pr) && (view2 = this.pr) != null) {
            view2.bringToFront();
        }
    }
}
