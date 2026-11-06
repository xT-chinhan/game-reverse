package com.byazt.od;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 121})
@com.byazt.qa.hw
public class x implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "app_manage_model")
    public String c;

    @com.byazt.qa.pr(hw = "ALL", pr = "deny_event")
    public String fw;

    @com.byazt.qa.pr(hw = "ALL", pr = MediationConstant.EXTRA_ADID)
    public String hn;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of hw;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "confirm_event")
    public String uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "privacy_popup_listener")
    public com.byazt.wt.c.pr x;

    @com.byazt.qa.pr(hw = "ALL", pr = "cancel_event")
    public String zo;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.wt.c.pr(this.hn, pr());
        TTDelegateActivity.hw(this.pr, this.hn, this.c);
        prVar.pr(map2);
        return true;
    }

    private com.byazt.wt.c.pr pr() {
        return new com.byazt.wt.c.pr() { // from class: com.byazt.od.x.1
            @Override // com.byazt.wt.c.pr
            public void pr() {
                if (x.this.x != null) {
                    x.this.x.pr();
                    x xVar = x.this;
                    xVar.pr(xVar.uc);
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                if (x.this.x != null) {
                    x.this.x.hw();
                    x xVar = x.this;
                    xVar.pr(xVar.fw);
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                if (x.this.x != null) {
                    x.this.x.hn();
                    x xVar = x.this;
                    xVar.pr(xVar.zo);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str) {
        if (this.hw == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("material_meta", this.hw);
        map.put(d.R, this.pr);
        com.byazt.lx.hw.pr(str, this.hw.to(), map);
    }
}
