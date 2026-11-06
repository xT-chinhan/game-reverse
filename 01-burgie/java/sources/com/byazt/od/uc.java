package com.byazt.od;

import android.app.Dialog;
import android.content.Context;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 5})
@com.byazt.qa.hw
public class uc implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hn;

    @com.byazt.qa.pr(hw = "ALL", pr = "ad_dislike")
    public com.byazt.pfl.hw hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "outer_dislike")
    public Dialog pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of x;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        Dialog dialog = this.pr;
        if (dialog != null) {
            dialog.show();
            prVar.pr(map2);
            return true;
        }
        com.byazt.pfl.hw hwVar = this.hw;
        if (hwVar != null) {
            hwVar.pr();
            prVar.pr(map2);
            return true;
        }
        TTDelegateActivity.pr(this.hn, this.x);
        prVar.pr(map2);
        return true;
    }
}
