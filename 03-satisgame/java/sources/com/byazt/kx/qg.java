package com.byazt.kx;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.af.x;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.ih.s;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1706, 26})
public class qg extends s<NativeVideoView> {
    public String dm;
    public String ei;
    public boolean n;
    public boolean nk;
    public pk o;
    public String sq;
    public com.byazt.zsl.s vo;
    public n ze;

    public qg(Context context) {
        super(context);
        this.nk = false;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public NativeVideoView n() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.qg);
        nativeVideoView.n(this);
        return nativeVideoView;
    }

    private void dn() {
        if (this.n) {
            if (!TextUtils.isEmpty(this.dm)) {
                try {
                    this.o = com.byazt.vgx.qg.n(new JSONObject(this.dm));
                    this.dm = null;
                } catch (JSONException unused) {
                }
            }
            pk pkVar = this.o;
            if (pkVar == null) {
                this.o = new pk();
                this.vo = new com.byazt.zsl.s();
                return;
            }
            com.byazt.zsl.s sVarK = ta.k(pkVar);
            this.vo = sVarK;
            if (sVarK == null) {
                this.vo = new com.byazt.zsl.s();
                return;
            }
            return;
        }
        this.o = new pk();
        this.vo = new com.byazt.zsl.s();
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        dn();
        this.vo.s(this.sq);
        this.vo.n(this.oa + x.n + this.sz);
        this.vo.qg(this.ei);
        this.o.n(this.vo);
        ((NativeVideoView) this.l).setMaterialMeta(this.o);
        ((NativeVideoView) this.l).setIsAutoPlay(true);
        ((NativeVideoView) this.l).setIsQuiet(this.nk);
        ((NativeVideoView) this.l).setVisibility(0);
        ((NativeVideoView) this.l).setEnableAutoCheck(false);
        ((NativeVideoView) this.l).n(this.qg, 25, this.ei);
        ((NativeVideoView) this.l).n(0L, true, false);
        ((NativeVideoView) this.l).n(this.ei);
        com.byazt.iag.s nativeVideoController = ((NativeVideoView) this.l).getNativeVideoController();
        if (nativeVideoController != null) {
            n nVar = new n();
            this.ze = nVar;
            nativeVideoController.n(nVar);
        }
    }

    public void q(boolean z) {
        this.nk = z;
        if (this.l == 0 || ((NativeVideoView) this.l).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.l).getNativeVideoController().qg(z);
    }

    public boolean fs() {
        if (this.l != 0 && ((NativeVideoView) this.l).getNativeVideoController() != null) {
            return ((NativeVideoView) this.l).getNativeVideoController().um();
        }
        return this.nk;
    }

    public void cx() {
        n((com.byazt.cs.n) null);
    }

    public void n(com.byazt.cs.n nVar) {
        pk pkVar;
        if (tj() != null && (pkVar = this.o) != null) {
            if (pkVar.ge() == 0) {
                int iOptInt = tj().optInt("image_mode");
                this.o.pk(iOptInt);
                this.o.n(new oj(tj()));
                if (iOptInt == 166) {
                    this.o.cx(-2);
                    ((NativeVideoView) this.l).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.l).setPlayerType(0);
        }
        if (nVar != null) {
            com.byazt.iag.s nativeVideoController = ((NativeVideoView) this.l).getNativeVideoController();
            nativeVideoController.q(nVar.q);
            nativeVideoController.qg(nVar.fs);
            if (nVar.n) {
                nativeVideoController.qg(0L);
            } else {
                nativeVideoController.qg(nVar.x);
            }
        }
        ((NativeVideoView) this.l).q();
    }

    @Override // com.byazt.ih.s
    public void n(JSONObject jSONObject) {
        super.n(jSONObject);
    }

    public void lq() {
        if (this.l != 0) {
            ((NativeVideoView) this.l).l();
        }
    }

    public void ic() {
        if (this.l != 0) {
            ((NativeVideoView) this.l).w();
            if (this.n) {
                ((NativeVideoView) this.l).qg(true, false);
            } else {
                ((NativeVideoView) this.l).n(this.ei);
            }
        }
    }

    public void ci() {
        if (this.l != 0) {
            ((NativeVideoView) this.l).k();
            ((NativeVideoView) this.l).n(this.ei);
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "coverSrc":
                this.ei = str2;
                break;
            case "src":
                this.sq = str2;
                break;
            case "isLp":
                try {
                    this.n = Boolean.valueOf(str2).booleanValue();
                    if (this.l != 0) {
                        ((NativeVideoView) this.l).setLp(this.n);
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.dm = str2;
                break;
        }
    }

    public void n(Map<String, Object> map) {
        if (this.l != 0) {
            ((NativeVideoView) this.l).setExtraMap(map);
        }
    }

    public boolean hf() {
        com.byazt.ej.x xVarHd;
        if (this.l == 0 || ((NativeVideoView) this.l).getNativeVideoController() == null || (xVarHd = ((NativeVideoView) this.l).getNativeVideoController().hd()) == null) {
            return false;
        }
        return xVarHd.tj();
    }

    public boolean kc() {
        com.byazt.ej.x xVarHd;
        if (this.l == 0 || ((NativeVideoView) this.l).getNativeVideoController() == null || (xVarHd = ((NativeVideoView) this.l).getNativeVideoController().hd()) == null) {
            return false;
        }
        return xVarHd.k();
    }

    public void z() {
        if (kc()) {
            if (this.l != 0) {
                ((NativeVideoView) this.l).py();
            }
        } else if (hf()) {
            ic();
        } else {
            lq();
        }
    }

    public void l(boolean z) {
        if (this.l != 0) {
            ((NativeVideoView) this.l).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1706, 48})
    private class n implements com.byazt.iag.s.n {
        public com.byazt.iag.s.n n;

        private n() {
        }

        @Override // com.byazt.iag.s.n
        public void n(long j, int i) {
            if (qg.this.n) {
                if (qg.this.l != null) {
                    ((NativeVideoView) qg.this.l).setComplete(true);
                }
                if (qg.this.l != null) {
                    ((NativeVideoView) qg.this.l).qg(true, true);
                }
            }
            com.byazt.iag.s.n nVar = this.n;
            if (nVar != null) {
                nVar.n(j, i);
            }
        }

        @Override // com.byazt.iag.s.n
        public void qg(long j, int i) {
            com.byazt.iag.s.n nVar = this.n;
            if (nVar != null) {
                nVar.qg(j, i);
            }
        }

        @Override // com.byazt.iag.s.n
        public void n() {
            com.byazt.iag.s.n nVar = this.n;
            if (nVar != null) {
                nVar.n();
            }
        }

        @Override // com.byazt.iag.s.n
        public void n(long j, long j2) {
            com.byazt.iag.s.n nVar = this.n;
            if (nVar != null) {
                nVar.n(j, j2);
            }
        }
    }
}
