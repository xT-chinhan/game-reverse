package com.byazt.yn;

import com.byazt.hcx.m;
import com.byazt.hcx.vk;
import com.byazt.nzn.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, 121})
public class x implements m {
    public final com.byazt.tf.x pr;

    public x(com.byazt.tf.x xVar) {
        this.pr = xVar;
    }

    @Override // com.byazt.hcx.m
    public int pr() {
        return this.pr.hw();
    }

    @Override // com.byazt.hcx.m
    public String hw() {
        return this.pr.hn();
    }

    @Override // com.byazt.hcx.m
    public Map<String, String> hn() {
        return this.pr.x();
    }

    @Override // com.byazt.hcx.m
    public String pr(String str) {
        return this.pr.x().get(str);
    }

    @Override // com.byazt.hcx.m
    public String pr(String str, String str2) {
        return this.pr.x().getOrDefault(str, str2);
    }

    @Override // com.byazt.hcx.m
    public byte[] x() {
        return this.pr.w();
    }

    @Override // com.byazt.hcx.m
    public JSONObject c() {
        String strC = this.pr.c();
        if (strC == null) {
            return null;
        }
        try {
            return new JSONObject(strC);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.byazt.hcx.m
    public vk uc() {
        final w wVarK = this.pr.k();
        return new vk() { // from class: com.byazt.yn.x.1
            @Override // com.byazt.hcx.vk
            public long pr() {
                return wVarK.pr;
            }

            @Override // com.byazt.hcx.vk
            public long hw() {
                return wVarK.hw;
            }

            @Override // com.byazt.hcx.vk
            public long hn() {
                return wVarK.hn;
            }

            @Override // com.byazt.hcx.vk
            public long x() {
                return wVarK.x;
            }

            @Override // com.byazt.hcx.vk
            public long c() {
                return wVarK.c;
            }

            @Override // com.byazt.hcx.vk
            public long uc() {
                return wVarK.uc;
            }

            @Override // com.byazt.hcx.vk
            public long fw() {
                return wVarK.fw;
            }

            @Override // com.byazt.hcx.vk
            public long zo() {
                return x.this.pr.uc();
            }

            @Override // com.byazt.hcx.vk
            public long aj() {
                return x.this.pr.fw();
            }
        };
    }

    @Override // com.byazt.hcx.m
    public boolean fw() {
        return this.pr.aj();
    }

    @Override // com.byazt.hcx.m
    public String zo() {
        return this.pr.c();
    }

    @Override // com.byazt.hcx.m
    public long aj() {
        return this.pr.vk();
    }

    @Override // com.byazt.hcx.m
    public File vk() {
        return this.pr.zo();
    }

    @Override // com.byazt.hcx.m
    public Throwable w() {
        return this.pr.pr();
    }

    @Override // com.byazt.hcx.m
    public String k() {
        com.byazt.tf.x xVar = this.pr;
        if (xVar != null) {
            return xVar.m();
        }
        return null;
    }
}
