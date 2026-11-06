package com.byazt.od;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 37})
@com.byazt.qa.hw
public class pr implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hn;

    @com.byazt.qa.pr(hw = "ALL", pr = BundleKey.TITLE)
    public String hw;

    @com.byazt.qa.pr(hw = "ALL", pr = BreakpointSQLiteKey.URL)
    public String pr;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        TTDelegateActivity.x(this.hn, this.pr, this.hw);
        prVar.pr(map2);
        return true;
    }
}
