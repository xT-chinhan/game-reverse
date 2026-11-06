package com.byazt.uq;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 108})
public class m extends com.byazt.ik.hn<InteractWebView> {
    public String pr;
    public Map<String, Object> qx;

    public m(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public InteractWebView pr() {
        this.c = new InteractWebView(this.hw);
        return (InteractWebView) this.c;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        this.qx = this.aj.hw();
        ((InteractWebView) this.c).setUGenExtraMap(this.qx);
        ((InteractWebView) this.c).setUGenContext(this.aj);
        ((InteractWebView) this.c).uc();
        ((InteractWebView) this.c).fw();
        JSONObject jSONObjectVk = vk();
        if (jSONObjectVk != null) {
            com.byazt.st.pr prVar = new com.byazt.st.pr();
            prVar.pr(jSONObjectVk.optInt("meta_hashcode", 0));
            ((InteractWebView) this.c).setMaterialMeta(prVar);
        }
        zo();
    }

    public void zo() {
        if (TextUtils.isEmpty(this.pr)) {
            this.pr = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.c).loadUrl(this.pr);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "src":
                if (TextUtils.isEmpty(this.pr) || !this.pr.startsWith("http")) {
                    this.pr = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
                    break;
                } else {
                    this.pr = str2;
                    break;
                }
                break;
        }
    }
}
