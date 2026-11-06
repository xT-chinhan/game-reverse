package com.byazt.cf;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 866})
public class py {
    public final Collection<String> n;
    public final Set<n> q;
    public final Map<String, a> qg;
    public final cp s;

    interface n {
    }

    public a n(String str) {
        if (!this.n.contains(str) && !TextUtils.equals(str, f.bU)) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return n(str, null);
    }

    public void n(n nVar) {
        this.q.add(nVar);
    }

    public void qg(n nVar) {
        this.q.remove(nVar);
    }

    private a n(String str, JSONObject jSONObject) {
        a aVar = this.qg.get(str);
        if (aVar == null) {
            a aVar2 = new a(str, this.s.s(), this.s.n(), this.s.qg(), jSONObject);
            this.qg.put(str, aVar2);
            return aVar2;
        }
        if (jSONObject == null) {
            return aVar;
        }
        aVar.update(jSONObject);
        return aVar;
    }
}
