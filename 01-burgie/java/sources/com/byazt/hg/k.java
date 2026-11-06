package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 250})
public class k extends com.byazt.mr.hn {
    public uc pr;

    public k(of ofVar) {
        if (ofVar == null) {
            return;
        }
        this.pr = ofVar.lb();
    }

    @Override // com.byazt.mr.hn
    public String pr() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return "";
        }
        return ucVar.g();
    }

    @Override // com.byazt.mr.hn
    public String hw() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return "";
        }
        return ucVar.c();
    }

    @Override // com.byazt.mr.hn
    public String hn() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return "";
        }
        return ucVar.fw();
    }

    @Override // com.byazt.mr.hn
    public String x() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return "";
        }
        return ucVar.zo();
    }

    @Override // com.byazt.mr.hn
    public Map<String, String> c() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return null;
        }
        return ucVar.pr();
    }

    @Override // com.byazt.mr.hn
    public String uc() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return null;
        }
        return ucVar.hw();
    }

    @Override // com.byazt.mr.hn
    public String fw() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return null;
        }
        return ucVar.aj();
    }

    @Override // com.byazt.mr.hn
    public String zo() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return null;
        }
        return ucVar.vk();
    }

    @Override // com.byazt.mr.hn
    public String aj() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return null;
        }
        return ucVar.w();
    }
}
