package com.byazt.ewt;

import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ewt.hw;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1073, 121})
public abstract class x<T, F extends hw> {
    public final Map<String, hn<T, F>> pr = new ConcurrentHashMap();
    public final List<Object> hw = new CopyOnWriteArrayList();
    public Map<String, String> hn = new ConcurrentHashMap();

    public interface pr {
        void pr(hw hwVar);
    }

    public void pr(String str, pr prVar) {
        hn<T, F> hnVar;
        if (prVar != null && str != null && (hnVar = this.pr.get(str)) != null) {
            prVar.pr(hnVar.getContext());
        }
    }

    public hw getContext(String str) {
        hn<T, F> hnVar;
        if (str != null && (hnVar = this.pr.get(str)) != null) {
            return hnVar.getContext();
        }
        return null;
    }

    public final void pr(String str, uc<? extends hw> ucVar) {
        hn<T, F> hnVar;
        if (str != null && (hnVar = this.pr.get(str)) != null) {
            hnVar.pr(ucVar);
        }
    }

    private void pr(final hn<?, ?> hnVar) {
        if (hnVar == null) {
            return;
        }
        aj.hn().post(new Runnable() { // from class: com.byazt.ewt.x.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = x.this.hw.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    public void pr(String str, hn<T, F> hnVar) {
        if (str != null && hnVar != null) {
            this.pr.put(str, hnVar);
        }
        pr((hn<?, ?>) hnVar);
    }

    public hn<T, F> pr(String str) {
        if (str != null) {
            return this.pr.get(str);
        }
        return null;
    }

    public void pr(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.hn.put(str, str2);
        }
    }

    public String hw(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = this.hn.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next) && str.contains(next)) {
                str2 = this.hn.get(next);
                str3 = next;
                break;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            this.hn.remove(str3);
        }
        return str2;
    }
}
