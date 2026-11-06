package com.byazt.fq;

import android.content.Context;
import com.byazt.hg.b;
import com.byazt.hg.m;
import com.byazt.hg.of;
import com.byazt.sd.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 149, 37})
public class pr {
    public of c;
    public hw hn;
    public JSONObject hw;
    public com.byazt.ti.hw pr;
    public m uc;
    public final Context x = a.getContext();

    public pr(of ofVar, m mVar) {
        this.c = ofVar;
        this.uc = mVar;
    }

    public void pr(com.byazt.ti.hw hwVar) {
        this.pr = hwVar;
    }

    public void pr(hw hwVar) {
        this.hn = hwVar;
    }

    public void pr(m mVar) {
        this.uc = mVar;
    }

    public of pr() {
        return this.c;
    }

    public Context getContext() {
        return this.x;
    }

    public void pr(of ofVar) {
        if (this.pr != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(b.c(ofVar)));
            } catch (JSONException e) {
            }
            this.pr.pr(jSONObject);
        }
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        if (!b.pr()) {
            return jSONObject;
        }
        try {
            com.byazt.ti.hw hwVar = this.pr;
            if (hwVar != null) {
                JSONObject jSONObjectPr = hwVar.pr();
                this.hw = jSONObjectPr;
                return jSONObjectPr;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public void pr(boolean z, JSONObject jSONObject) {
        com.byazt.ti.hw hwVar;
        if (b.pr() && (hwVar = this.pr) != null) {
            if (z) {
                hwVar.hw(jSONObject);
                return;
            }
            HashMap map = new HashMap();
            map.put("estimatedArea", this.hw);
            map.put("realArea", this.hn.getMaxRectJson());
            map.put("exceedAreaRate", Double.valueOf(this.hn.getExceedAreaRate()));
            map.put("widgetArea", this.hn.getActualRectJson());
            com.byazt.uq.hn.hw(this.c, this.uc, false, 100, new JSONObject(map));
            this.pr.hn(jSONObject);
        }
    }

    public void hn() {
        com.byazt.ti.hw hwVar;
        if (b.pr() && (hwVar = this.pr) != null) {
            hwVar.hw();
        }
    }

    public void pr(of ofVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            e.getMessage();
        }
        com.byazt.uq.hn.hw(ofVar, this.uc, false, jSONObject);
    }
}
