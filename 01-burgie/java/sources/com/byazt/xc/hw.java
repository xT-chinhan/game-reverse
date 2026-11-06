package com.byazt.xc;

import com.byazt.vlp.fw;
import com.byazt.vlp.zo;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 422, 13})
public class hw implements fw {
    public zo hw;
    public final com.byazt.or.pr pr;

    public hw(com.byazt.or.pr prVar) {
        this.pr = prVar;
    }

    @Override // com.byazt.vlp.fw
    public String pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.vlp.fw
    public boolean hw() {
        return this.pr.hw();
    }

    @Override // com.byazt.vlp.fw
    public zo hn() {
        if (this.hw == null) {
            com.byazt.or.hn hnVarHn = this.pr.hn();
            if (hnVarHn == null) {
                return null;
            }
            this.hw = new hn(hnVarHn);
        }
        return this.hw;
    }

    @Override // com.byazt.vlp.fw
    public Map<String, Object> x() {
        return this.pr.x();
    }

    @Override // com.byazt.vlp.fw
    public boolean c() {
        return this.pr.c();
    }

    @Override // com.byazt.vlp.fw
    public JSONObject uc() {
        return this.pr.uc();
    }

    @Override // com.byazt.vlp.fw
    public String fw() {
        return this.pr.fw();
    }

    @Override // com.byazt.vlp.fw
    public boolean zo() {
        return this.pr.zo();
    }

    @Override // com.byazt.vlp.fw
    public boolean aj() {
        return this.pr.aj();
    }

    @Override // com.byazt.vlp.fw
    public boolean vk() {
        return this.pr.vk();
    }

    @Override // com.byazt.vlp.fw
    public String w() {
        return this.pr.w();
    }
}
