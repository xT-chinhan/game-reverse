package com.byazt.gp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 19})
public class n {
    public static volatile n n;
    public List<C0183n> qg = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.byazt.gp.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0183n {
        public qg n;
        public JSONObject qg;

        public C0183n(qg qgVar, JSONObject jSONObject) {
            this.n = qgVar;
            this.qg = jSONObject;
        }

        public qg n() {
            return this.n;
        }

        public JSONObject qg() {
            return tj.n(this.n, this.qg);
        }
    }

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public List<C0183n> qg() {
        return this.qg;
    }

    public void n(qg qgVar, JSONObject jSONObject) {
        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- event 保存到埋点辅助模块");
        this.qg.add(new C0183n(qgVar, jSONObject));
    }

    public void s() {
        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- event 清空埋点辅助模块");
        List<C0183n> list = this.qg;
        if (list != null) {
            list.clear();
        }
    }
}
