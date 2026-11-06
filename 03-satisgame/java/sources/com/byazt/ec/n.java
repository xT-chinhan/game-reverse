package com.byazt.ec;

import android.text.TextUtils;
import com.byazt.bok.s;
import com.byazt.wea.fs;
import com.byazt.wea.q;
import com.byazt.yvo.qg;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1674, 19})
public class n {
    public static void n(Map<String, Object> map, String str) {
        q qVar;
        List<qg> list;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        fs context = s.n(1).getContext(str);
        if (!(context instanceof q) || (list = (qVar = (q) context).k) == null || list.isEmpty()) {
            return;
        }
        map.put("node_line", com.byazt.yvo.q.n(list));
        map.put("node_line_detail", com.byazt.yvo.q.qg(list));
        map.put("unexpected_type", Integer.valueOf(qVar.l));
        if (!TextUtils.isEmpty(qVar.n())) {
            map.put("ad_show_id", qVar.n());
        }
        if (TextUtils.isEmpty(qVar.x)) {
            return;
        }
        map.put("ad_load_id", qVar.x);
    }
}
