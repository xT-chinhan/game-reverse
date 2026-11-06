package com.byazt.sa;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.hb.fs;
import com.byazt.ih.s;
import com.byazt.mcb.qg;
import com.byazt.si.cy;
import com.byazt.si.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 401, 19})
public class n extends s<UGProgressBarView> {
    public float bz;
    public float dm;
    public int ei;
    public boolean il;
    public boolean la;
    public float n;
    public int nk;
    public float o;
    public float qn;
    public int sq;
    public float vo;
    public int ze;

    public n(Context context) {
        super(context);
        this.sq = -924195;
        this.ei = -38315;
        this.nk = -1;
        this.ze = -593426;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGProgressBarView n() {
        UGProgressBarView uGProgressBarView = new UGProgressBarView(this.qg);
        uGProgressBarView.n(this);
        return uGProgressBarView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((UGProgressBarView) this.l).setTrackColor(this.sq);
        ((UGProgressBarView) this.l).setFillColor(this.ei);
        ((UGProgressBarView) this.l).setLineHeight(this.dm);
        ((UGProgressBarView) this.l).setCornerRadius(this.vo);
        ((UGProgressBarView) this.l).setThumbSize(this.o);
        ((UGProgressBarView) this.l).setThumbColor(this.nk);
        ((UGProgressBarView) this.l).setThumbBorderColor(this.ze);
        ((UGProgressBarView) this.l).setThumbBorderWidth(this.qn);
        ((UGProgressBarView) this.l).setHorizontalInset(this.bz);
        ((UGProgressBarView) this.l).setInteractive(this.il);
        fs();
        ((UGProgressBarView) this.l).setProgress(this.n);
    }

    private void fs() {
        int iD;
        if (this.la) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = m() != null ? m().optJSONObject("milestones") : null;
        if (jSONObjectOptJSONObject != null && (iD = d(jSONObjectOptJSONObject.optString("count"))) > 0) {
            this.la = true;
            ((UGProgressBarView) this.l).n(iD, fs.n(this.qg, jSONObjectOptJSONObject.optString("node_size", "30")), fs.n(this.qg, jSONObjectOptJSONObject.optString("node_gap", "0")));
            if (jSONObjectOptJSONObject.has("dot_radius")) {
                ((UGProgressBarView) this.l).setMilestoneDotRadius(fs.n(this.qg, jSONObjectOptJSONObject.optString("dot_radius")));
            }
            if (jSONObjectOptJSONObject.has("dot_color")) {
                ((UGProgressBarView) this.l).setMilestoneDotColor(com.byazt.hb.n.n(jSONObjectOptJSONObject.optString("dot_color"), this.ei));
            }
            if (jSONObjectOptJSONObject.has("dot_reached_color")) {
                ((UGProgressBarView) this.l).setMilestoneDotReachedColor(com.byazt.hb.n.n(jSONObjectOptJSONObject.optString("dot_reached_color"), this.ei));
            }
            n(jSONObjectOptJSONObject.optString("normal_src"), 0);
            n(jSONObjectOptJSONObject.optString("reached_src"), 1);
        }
    }

    private int d(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.contains("${")) {
            str = qg.n(str, tj());
        }
        return com.byazt.hb.s.n(str, 0);
    }

    private void n(String str, final int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        com.byazt.imu.s.n(str).s(2).n(new m<Bitmap>() { // from class: com.byazt.sa.n.1
            @Override // com.byazt.si.m
            public void n(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                Bitmap bitmapS = cyVar != null ? cyVar.s() : null;
                if (bitmapS == null || n.this.l == null) {
                    return;
                }
                ((UGProgressBarView) n.this.l).n(i, bitmapS);
            }
        });
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "thumb_border_color":
                this.ze = com.byazt.hb.n.n(str2, -593426);
                break;
            case "thumb_border_width":
                this.qn = fs.n(this.qg, str2);
                break;
            case "thumb_size":
                this.o = fs.n(this.qg, str2);
                break;
            case "thumb_color":
                this.nk = com.byazt.hb.n.n(str2, -1);
                break;
            case "horizontal_inset":
                this.bz = fs.n(this.qg, str2);
                break;
            case "progress":
                this.n = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "fill_color":
                this.ei = com.byazt.hb.n.n(str2, -38315);
                break;
            case "corner_radius":
                this.vo = fs.n(this.qg, str2);
                break;
            case "line_height":
                this.dm = fs.n(this.qg, str2);
                break;
            case "track_color":
                this.sq = com.byazt.hb.n.n(str2, -924195);
                break;
            case "interactive":
                this.il = Boolean.parseBoolean(str2);
                break;
        }
    }
}
