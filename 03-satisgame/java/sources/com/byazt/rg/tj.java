package com.byazt.rg;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends com.byazt.ih.s<InteractWebView> {
    public String n;
    public Map<String, Object> sq;

    public tj(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public InteractWebView n() {
        this.l = new InteractWebView(this.qg);
        return (InteractWebView) this.l;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        this.sq = this.rv.qg();
        ((InteractWebView) this.l).setUGenExtraMap(this.sq);
        ((InteractWebView) this.l).setUGenContext(this.rv);
        ((InteractWebView) this.l).w();
        ((InteractWebView) this.l).x();
        JSONObject jSONObjectTj = tj();
        if (jSONObjectTj != null) {
            com.byazt.wrp.n nVar = new com.byazt.wrp.n();
            nVar.n(jSONObjectTj.optInt("meta_hashcode", 0));
            ((InteractWebView) this.l).setMaterialMeta(nVar);
        }
        fs();
    }

    public void fs() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.l).loadUrl(this.n);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.n) || !this.n.startsWith("http")) {
                this.n = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.n = str2;
            }
        }
    }
}
