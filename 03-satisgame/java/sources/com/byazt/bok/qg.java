package com.byazt.bok;

import android.text.TextUtils;
import com.byazt.tk.rv;
import com.byazt.wea.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 26})
public abstract class qg<T, F extends fs> {
    public final Map<String, com.byazt.bok.n<T, F>> n = new ConcurrentHashMap();
    public final List<Object> qg = new CopyOnWriteArrayList();
    public Map<String, String> s = new ConcurrentHashMap();

    public interface n {
        void n(fs fsVar);
    }

    public void n(String str, n nVar) {
        com.byazt.bok.n<T, F> nVar2;
        if (nVar == null || str == null || (nVar2 = this.n.get(str)) == null) {
            return;
        }
        nVar.n(nVar2.getContext());
    }

    public fs getContext(String str) {
        com.byazt.bok.n<T, F> nVar;
        if (str == null || (nVar = this.n.get(str)) == null) {
            return null;
        }
        return nVar.getContext();
    }

    public final void n(String str, l<? extends fs> lVar) {
        com.byazt.bok.n<T, F> nVar;
        if (str == null || (nVar = this.n.get(str)) == null) {
            return;
        }
        nVar.n(lVar);
    }

    private void n(final com.byazt.bok.n<?, ?> nVar) {
        if (nVar == null || this.qg.isEmpty()) {
            return;
        }
        rv.s().post(new Runnable() { // from class: com.byazt.bok.qg.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = qg.this.qg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    public void n(String str, com.byazt.bok.n<T, F> nVar) {
        if (str != null && nVar != null) {
            this.n.put(str, nVar);
        }
        n((com.byazt.bok.n<?, ?>) nVar);
    }

    public com.byazt.bok.n<T, F> n(String str) {
        if (str != null) {
            return this.n.get(str);
        }
        return null;
    }

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.s.put(str, str2);
    }

    public String qg(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = this.s.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next) && str.contains(next)) {
                str2 = this.s.get(next);
                str3 = next;
                break;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            this.s.remove(str3);
        }
        return str2;
    }
}
