package com.byazt.uh;

import android.content.Context;
import com.byazt.gq.hn;
import com.byazt.gq.hw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1591, 37})
public abstract class pr {
    public final com.byazt.xg.pr hn;
    public final Context hw;
    public final List<Future<com.byazt.jdi.pr>> pr = new ArrayList();
    public final hw x;

    public abstract List<String> pr();

    public pr(Context context, hw hwVar, com.byazt.xg.pr prVar) {
        this.x = hwVar;
        this.hn = prVar;
        this.hw = context;
    }

    public boolean pr(JSONObject jSONObject) {
        return false;
    }

    public void pr(com.byazt.gq.pr prVar, Long l) {
        this.pr.add(com.byazt.jcn.pr.pr(new hn(prVar, l)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    public void pr(Map<String, JSONObject> map, long j) {
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                if (pr().contains(entry.getKey())) {
                    com.byazt.gq.pr prVar = null;
                    switch (key) {
                        case "d_a0":
                            prVar = new com.byazt.cs.pr(this.hw, entry.getValue());
                            break;
                        case "d_i0":
                            prVar = new com.byazt.cs.hw(this.hw, entry.getValue());
                            break;
                    }
                    if (prVar != null) {
                        pr(prVar, Long.valueOf(j));
                    }
                }
            } catch (Exception e) {
                com.byazt.wx.pr.x("__kite", "error " + e.getMessage());
            }
        }
    }
}
