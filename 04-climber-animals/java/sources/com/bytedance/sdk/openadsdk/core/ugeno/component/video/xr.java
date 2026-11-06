package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.ul;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ah<NativeVideoView> {
    private ms cc;
    private String gs;
    private String kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3484ms;
    private lm nl;
    private boolean qo;
    private com.bykv.vk.openvk.component.video.api.ah.ah r;
    private String vf;

    public xr(Context context) {
        super(context);
        this.qo = false;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public NativeVideoView ms() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.xr);
        nativeVideoView.ms(this);
        return nativeVideoView;
    }

    private void vm() {
        if (this.f3484ms) {
            if (!TextUtils.isEmpty(this.gs)) {
                try {
                    this.nl = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(this.gs));
                    this.gs = null;
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
            lm lmVar = this.nl;
            if (lmVar == null) {
                this.nl = new lm();
                this.r = new com.bykv.vk.openvk.component.video.api.ah.ah();
                return;
            }
            com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(lmVar);
            this.r = ahVarU;
            if (ahVarU == null) {
                this.r = new com.bykv.vk.openvk.component.video.api.ah.ah();
                return;
            }
            return;
        }
        this.nl = new lm();
        this.r = new com.bykv.vk.openvk.component.video.api.ah.ah();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        vm();
        this.r.ah(this.vf);
        this.r.ms(this.zb + "x" + this.u);
        this.r.xr(this.kl);
        this.nl.ms(this.r);
        ((NativeVideoView) this.ka).setMaterialMeta(this.nl);
        ((NativeVideoView) this.ka).setIsAutoPlay(true);
        ((NativeVideoView) this.ka).setIsQuiet(this.qo);
        ((NativeVideoView) this.ka).setVisibility(0);
        ((NativeVideoView) this.ka).setEnableAutoCheck(false);
        ((NativeVideoView) this.ka).ms(this.xr, 25, this.kl);
        ((NativeVideoView) this.ka).ms(0L, true, false);
        ((NativeVideoView) this.ka).ms(this.kl);
        com.bykv.vk.openvk.component.video.api.d.ah nativeVideoController = ((NativeVideoView) this.ka).getNativeVideoController();
        if (nativeVideoController != null) {
            ms msVar = new ms();
            this.cc = msVar;
            nativeVideoController.ms(msVar);
        }
    }

    public void d(boolean z) {
        this.qo = z;
        if (this.ka == 0 || ((NativeVideoView) this.ka).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.ka).getNativeVideoController().xr(z);
    }

    public boolean x() {
        if (this.ka != 0 && ((NativeVideoView) this.ka).getNativeVideoController() != null) {
            return ((NativeVideoView) this.ka).getNativeVideoController().y();
        }
        return this.qo;
    }

    public void am() {
        ms((com.bytedance.sdk.openadsdk.core.multipro.xr.ms) null);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar) {
        lm lmVar;
        if (ch() != null && (lmVar = this.nl) != null) {
            if (lmVar.kz() == 0) {
                int iOptInt = ch().optInt("image_mode");
                this.nl.f(iOptInt);
                this.nl.ms(new ul(ch()));
                if (iOptInt == 166) {
                    this.nl.tz(-2);
                    ((NativeVideoView) this.ka).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.ka).setPlayerType(0);
        }
        if (msVar != null) {
            com.bykv.vk.openvk.component.video.api.d.ah nativeVideoController = ((NativeVideoView) this.ka).getNativeVideoController();
            nativeVideoController.d(msVar.d);
            nativeVideoController.xr(msVar.x);
            if (msVar.f2932ms) {
                nativeVideoController.xr(0L);
            } else {
                nativeVideoController.xr(msVar.ab);
            }
        }
        ((NativeVideoView) this.ka).d();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(JSONObject jSONObject) {
        super.ms(jSONObject);
    }

    public void sa() {
        if (this.ka != 0) {
            ((NativeVideoView) this.ka).N_();
        }
    }

    public void tz() {
        if (this.ka != 0) {
            ((NativeVideoView) this.ka).x();
            if (this.f3484ms) {
                ((NativeVideoView) this.ka).ms(true, false);
            } else {
                ((NativeVideoView) this.ka).ms(this.kl);
            }
        }
    }

    public void ti() {
        if (this.ka != 0) {
            ((NativeVideoView) this.ka).ka();
            ((NativeVideoView) this.ka).ms(this.kl);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "coverSrc":
                this.kl = str2;
                break;
            case "src":
                this.vf = str2;
                break;
            case "isLp":
                try {
                    this.f3484ms = Boolean.valueOf(str2).booleanValue();
                    if (this.ka != 0) {
                        ((NativeVideoView) this.ka).setLp(this.f3484ms);
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.gs = str2;
                break;
        }
    }

    public void ms(Map<String, Object> map) {
        if (this.ka != 0) {
            ((NativeVideoView) this.ka).setExtraMap(map);
        }
    }

    public boolean s() {
        com.bykv.vk.openvk.component.video.api.ms msVarH;
        if (this.ka == 0 || ((NativeVideoView) this.ka).getNativeVideoController() == null || (msVarH = ((NativeVideoView) this.ka).getNativeVideoController().h()) == null) {
            return false;
        }
        return msVarH.zb();
    }

    public boolean v() {
        com.bykv.vk.openvk.component.video.api.ms msVarH;
        if (this.ka == 0 || ((NativeVideoView) this.ka).getNativeVideoController() == null || (msVarH = ((NativeVideoView) this.ka).getNativeVideoController().h()) == null) {
            return false;
        }
        return msVarH.ny();
    }

    public void qk() {
        if (v()) {
            if (this.ka != 0) {
                ((NativeVideoView) this.ka).qv();
            }
        } else if (s()) {
            tz();
        } else {
            sa();
        }
    }

    public void ka(boolean z) {
        if (this.ka != 0) {
            ((NativeVideoView) this.ka).setNeedNativeVideoPlayBtnVisible(z);
        }
    }

    private class ms implements com.bykv.vk.openvk.component.video.api.d.ah.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        com.bykv.vk.openvk.component.video.api.d.ah.ms f3485ms;

        private ms() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
        public void ms(long j, int i) {
            if (xr.this.f3484ms) {
                if (xr.this.ka != null) {
                    ((NativeVideoView) xr.this.ka).setComplete(true);
                }
                if (xr.this.ka != null) {
                    ((NativeVideoView) xr.this.ka).ms(true, true);
                }
            }
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.f3485ms;
            if (msVar != null) {
                msVar.ms(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
        public void xr(long j, int i) {
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.f3485ms;
            if (msVar != null) {
                msVar.xr(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
        public void ms() {
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.f3485ms;
            if (msVar != null) {
                msVar.ms();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.d.ah.ms
        public void ms(long j, long j2) {
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.f3485ms;
            if (msVar != null) {
                msVar.ms(j, j2);
            }
        }
    }
}
