package com.byazt.pcc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hb.fs;
import com.byazt.hb.qg;
import com.byazt.ih.s;
import com.byazt.vh.k;
import com.byazt.vh.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 19})
public class n extends com.byazt.ih.n<UgenGridView> {
    public rv.n bz;
    public int dm;
    public JSONArray ei;
    public int il;
    public int la;
    public int nk;
    public int o;
    public s qn;
    public String sq;
    public int vo;
    public int ze;

    public n(Context context) {
        super(context);
        this.sq = "column";
        this.dm = 3;
        this.vo = 3;
        this.nk = Integer.MIN_VALUE;
        this.ze = Integer.MIN_VALUE;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public UgenGridView n() {
        UgenGridView ugenGridView = new UgenGridView(this.qg);
        ugenGridView.n(this);
        return ugenGridView;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        UgenGridView ugenGridViewHe = he();
        if (ugenGridViewHe == null) {
            return;
        }
        ugenGridViewHe.setGridDirection(this.sq);
        ugenGridViewHe.setHorizontalSpacing(ci());
        ugenGridViewHe.setVerticalSpacing(hf());
        n(ugenGridViewHe);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "columnGap":
                this.ze = (int) fs.n(this.qg, str2);
                break;
            case "rowGap":
                this.nk = (int) fs.n(this.qg, str2);
                break;
            case "gap":
                this.o = (int) fs.n(this.qg, str2);
                break;
            case "rows":
                this.vo = d(str2);
                break;
            case "gridDirection":
                if ("row".equals(str2)) {
                    this.sq = "row";
                    break;
                } else {
                    this.sq = "column";
                    break;
                }
                break;
            case "columns":
                this.dm = d(str2);
                break;
            case "dataList":
                this.ei = qg.n(str2, (JSONArray) null);
                break;
        }
    }

    @Override // com.byazt.ih.n
    public void n(s sVar) {
        l(sVar);
    }

    @Override // com.byazt.ih.n
    public void n(s sVar, ViewGroup.LayoutParams layoutParams) {
        l(sVar);
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void qg(int i, int i2, int i3, int i4) {
        super.qg(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        n(he());
    }

    private int d(String str) {
        int iN = com.byazt.hb.s.n(str, 3);
        if (iN > 0) {
            return iN;
        }
        return 3;
    }

    private int lq() {
        JSONArray jSONArray = this.ei;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    private int ic() {
        if (kc()) {
            return lq();
        }
        return 0;
    }

    private int ci() {
        int i = this.ze;
        return i != Integer.MIN_VALUE ? i : this.o;
    }

    private int hf() {
        int i = this.nk;
        return i != Integer.MIN_VALUE ? i : this.o;
    }

    private boolean kc() {
        if (this.bz == null) {
            return false;
        }
        if ("row".equals(this.sq)) {
            return this.il > 0;
        }
        return this.la > 0;
    }

    private void l(s sVar) {
        if (sVar == null || this.qn != null) {
            return;
        }
        this.qn = sVar;
        this.bz = sVar.ur();
        this.n.add(sVar);
        this.il = Math.max(sVar.an(), 0);
        this.la = Math.max(sVar.ae(), 0);
    }

    private void n(UgenGridView ugenGridView) {
        int iIc;
        if (ugenGridView == null) {
            return;
        }
        ugenGridView.n();
        if (this.bz == null || !kc() || (iIc = ic()) <= 0) {
            return;
        }
        int width = ugenGridView.getWidth();
        int height = ugenGridView.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int iX = x(width);
        int iFs = fs(height);
        int iZ = z();
        int iQg = qg(iIc, iZ);
        int i = 0;
        while (i < iIc) {
            int i2 = i / iZ;
            boolean z = i % iZ == iZ + (-1) || i == iIc + (-1);
            boolean z2 = i2 == iQg + (-1);
            C0292n c0292nDn = dn();
            if (c0292nDn != null) {
                ugenGridView.n(c0292nDn.qg, i2, z, z2, iX, iFs);
                c0292nDn.n.qg(w(i));
            }
            i++;
        }
    }

    private int z() {
        if ("row".equals(this.sq)) {
            int i = this.vo;
            if (i > 0) {
                return i;
            }
            return 3;
        }
        int i2 = this.dm;
        if (i2 > 0) {
            return i2;
        }
        return 3;
    }

    private int qg(int i, int i2) {
        if (i <= 0) {
            return 0;
        }
        return Math.max(((i + Math.max(i2, 1)) - 1) / Math.max(i2, 1), 1);
    }

    private JSONObject w(int i) {
        JSONArray jSONArray;
        Object objOpt = (i < 0 || (jSONArray = this.ei) == null) ? null : jSONArray.opt(i);
        return objOpt instanceof JSONObject ? (JSONObject) objOpt : new JSONObject();
    }

    private int x(int i) {
        if ("row".equals(this.sq)) {
            return this.il;
        }
        return Math.max((((i - ((int) this.t)) - ((int) this.ur)) - ((this.dm - 1) * ci())) / this.dm, 1);
    }

    private int fs(int i) {
        if ("column".equals(this.sq)) {
            return this.la;
        }
        return Math.max((((i - ((int) this.bb)) - ((int) this.ln)) - ((this.vo - 1) * hf())) / this.vo, 1);
    }

    private C0292n dn() {
        k kVar = new k(this.qg);
        kVar.n((String) null, this.rv);
        kVar.n(this.ry);
        kVar.n(this.ju);
        kVar.n(this.ta);
        s<View> sVarN = kVar.n(this.bz);
        if (sVarN == null || sVarN.rv() == null) {
            return null;
        }
        kVar.n(sVarN);
        View viewRv = sVarN.rv();
        viewRv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new C0292n(kVar, viewRv);
    }

    private UgenGridView he() {
        if (this.l instanceof UgenGridView) {
            return (UgenGridView) this.l;
        }
        return null;
    }

    /* JADX INFO: renamed from: com.byazt.pcc.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0292n {
        public final k n;
        public final View qg;

        private C0292n(k kVar, View view) {
            this.n = kVar;
            this.qg = view;
        }
    }
}
