package com.byazt.hd;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.ihe.fw;
import com.byazt.ik.hn;
import com.byazt.n.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.INTERACTION_TYPE_CODE, 13})
public class hw extends hn<NativeVideoView> {
    public String fe;
    public String ks;
    public pr p;
    public boolean pr;
    public String qx;
    public x sr;
    public of wz;
    public boolean xb;

    public hw(Context context) {
        super(context);
        this.xb = false;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public NativeVideoView pr() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.hw);
        nativeVideoView.pr(this);
        return nativeVideoView;
    }

    private void pq() {
        if (this.pr) {
            if (!TextUtils.isEmpty(this.ks)) {
                try {
                    this.wz = com.byazt.sd.pr.pr(new JSONObject(this.ks));
                    this.ks = null;
                } catch (JSONException e) {
                }
            }
            of ofVar = this.wz;
            if (ofVar == null) {
                this.wz = new of();
                this.sr = new x();
                return;
            }
            x xVarHo = qv.ho(ofVar);
            this.sr = xVarHo;
            if (xVarHo == null) {
                this.sr = new x();
                return;
            }
            return;
        }
        this.wz = new of();
        this.sr = new x();
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        pq();
        this.sr.hn(this.qx);
        this.sr.pr(this.m + "x" + this.g);
        this.sr.hw(this.fe);
        this.wz.pr(this.sr);
        ((NativeVideoView) this.c).setMaterialMeta(this.wz);
        ((NativeVideoView) this.c).setIsAutoPlay(true);
        ((NativeVideoView) this.c).setIsQuiet(this.xb);
        ((NativeVideoView) this.c).setVisibility(0);
        ((NativeVideoView) this.c).setEnableAutoCheck(false);
        ((NativeVideoView) this.c).pr(this.hw, 25, this.fe);
        ((NativeVideoView) this.c).pr(0L, true, false);
        ((NativeVideoView) this.c).pr(this.fe);
        com.byazt.w.hn nativeVideoController = ((NativeVideoView) this.c).getNativeVideoController();
        if (nativeVideoController != null) {
            pr prVar = new pr();
            this.p = prVar;
            nativeVideoController.pr(prVar);
        }
    }

    public void x(boolean z) {
        this.xb = z;
        if (this.c != 0 && ((NativeVideoView) this.c).getNativeVideoController() != null) {
            ((NativeVideoView) this.c).getNativeVideoController().hw(z);
        }
    }

    public boolean zo() {
        if (this.c != 0 && ((NativeVideoView) this.c).getNativeVideoController() != null) {
            return ((NativeVideoView) this.c).getNativeVideoController().qa();
        }
        return this.xb;
    }

    public void lv() {
        pr((com.byazt.mm.pr) null);
    }

    public void pr(com.byazt.mm.pr prVar) {
        of ofVar;
        if (vk() != null && (ofVar = this.wz) != null) {
            if (ofVar.jg() == 0) {
                int iOptInt = vk().optInt("image_mode");
                this.wz.qn(iOptInt);
                this.wz.pr(new v(vk()));
                if (iOptInt == 166) {
                    this.wz.l(-2);
                    ((NativeVideoView) this.c).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.c).setPlayerType(0);
        }
        if (prVar != null) {
            com.byazt.w.hn nativeVideoController = ((NativeVideoView) this.c).getNativeVideoController();
            nativeVideoController.x(prVar.x);
            nativeVideoController.hw(prVar.zo);
            if (prVar.pr) {
                nativeVideoController.hw(0L);
            } else {
                nativeVideoController.hw(prVar.fw);
            }
        }
        ((NativeVideoView) this.c).x();
    }

    @Override // com.byazt.ik.hn
    public void pr(JSONObject jSONObject) {
        super.pr(jSONObject);
    }

    public void od() {
        if (this.c != 0) {
            ((NativeVideoView) this.c).Y_();
        }
    }

    public void vj() {
        if (this.c != 0) {
            ((NativeVideoView) this.c).zo();
            if (this.pr) {
                ((NativeVideoView) this.c).pr(true, false);
            } else {
                ((NativeVideoView) this.c).pr(this.fe);
            }
        }
    }

    public void mw() {
        if (this.c != 0) {
            ((NativeVideoView) this.c).c();
            ((NativeVideoView) this.c).pr(this.fe);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "src":
                this.qx = str2;
                break;
            case "coverSrc":
                this.fe = str2;
                break;
            case "mate":
                this.ks = str2;
                break;
            case "isLp":
                try {
                    this.pr = Boolean.valueOf(str2).booleanValue();
                    if (this.c != 0) {
                        ((NativeVideoView) this.c).setLp(this.pr);
                    }
                    break;
                } catch (Exception e) {
                    return;
                }
                break;
        }
    }

    public void pr(Map<String, Object> map) {
        if (this.c != 0) {
            ((NativeVideoView) this.c).setExtraMap(map);
        }
    }

    public boolean sv() {
        fw fwVarYb;
        if (this.c != 0 && ((NativeVideoView) this.c).getNativeVideoController() != null && (fwVarYb = ((NativeVideoView) this.c).getNativeVideoController().yb()) != null) {
            return fwVarYb.vk();
        }
        return false;
    }

    public boolean gu() {
        fw fwVarYb;
        if (this.c != 0 && ((NativeVideoView) this.c).getNativeVideoController() != null && (fwVarYb = ((NativeVideoView) this.c).getNativeVideoController().yb()) != null) {
            return fwVarYb.ho();
        }
        return false;
    }

    public void d() {
        if (gu()) {
            if (this.c != 0) {
                ((NativeVideoView) this.c).qa();
            }
        } else if (sv()) {
            vj();
        } else {
            od();
        }
    }

    public void c(boolean z) {
        if (this.c != 0) {
            ((NativeVideoView) this.c).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.INTERACTION_TYPE_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private class pr implements com.byazt.w.hn.pr {
        public com.byazt.w.hn.pr pr;

        private pr() {
        }

        @Override // com.byazt.w.hn.pr
        public void pr(long j, int i) {
            if (hw.this.pr) {
                if (hw.this.c != null) {
                    ((NativeVideoView) hw.this.c).setComplete(true);
                }
                if (hw.this.c != null) {
                    ((NativeVideoView) hw.this.c).pr(true, true);
                }
            }
            com.byazt.w.hn.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(j, i);
            }
        }

        @Override // com.byazt.w.hn.pr
        public void hw(long j, int i) {
            com.byazt.w.hn.pr prVar = this.pr;
            if (prVar != null) {
                prVar.hw(j, i);
            }
        }

        @Override // com.byazt.w.hn.pr
        public void pr() {
            com.byazt.w.hn.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr();
            }
        }

        @Override // com.byazt.w.hn.pr
        public void pr(long j, long j2) {
            com.byazt.w.hn.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(j, j2);
            }
        }
    }
}
