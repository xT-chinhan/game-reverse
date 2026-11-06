package com.byazt.nz;

import com.byazt.hg.of;
import com.byazt.wt.rc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 684, 121})
public class x {
    public static x c = new x();
    public int hn;
    public int hw;
    public of pr;
    public volatile com.byazt.utw.pr x;

    public static x pr() {
        return c;
    }

    private boolean hw() {
        this.x = com.byazt.hs.hw.pr;
        return this.x != null;
    }

    public x pr(of ofVar) {
        if (hw()) {
            this.pr = ofVar;
        }
        return this;
    }

    public x pr(int i) {
        if (hw()) {
            this.hw = i;
        }
        return this;
    }

    public x hw(int i) {
        if (hw()) {
            this.hn = i;
        }
        return this;
    }

    public void pr(Thread thread, Throwable th) {
        String str;
        if (hw()) {
            if (thread == null) {
                str = "";
            } else {
                str = thread.getName() + "-" + thread.getId();
            }
            this.x.pr(str, "-------fatal----------");
            this.x.pr(str, "last show rit:" + this.hn);
            this.x.pr(str, "last show adtype:" + this.hw);
            this.x.pr(str, hn());
            this.x.pr(str, th);
            this.x.pr(str, "-------finish----------");
            com.byazt.hs.hw.pr.pr().pr();
        }
    }

    private String hn() {
        of ofVar = this.pr;
        if (ofVar != null) {
            JSONObject jSONObject = ofVar.to();
            return rc.pr(jSONObject == null ? null : jSONObject.toString()).toString();
        }
        return "";
    }
}
