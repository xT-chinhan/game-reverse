package com.byazt.vl;

import android.content.SharedPreferences;
import com.byazt.ug.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 160})
    private static class n {
        public static rv n = new rv();
    }

    public static rv n() {
        return n.n;
    }

    private rv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences s() {
        return com.byazt.qp.x.n(d.getContext(), "sp_ad_download_event", 0);
    }

    public ConcurrentHashMap<Long, com.byazt.h.qg> qg() {
        ConcurrentHashMap<Long, com.byazt.h.qg> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = s().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.byazt.h.qg qgVarQg = com.byazt.h.qg.qg(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && qgVarQg != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), qgVarQg);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    public void n(com.byazt.h.qg qgVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(qgVar);
        n((Collection<com.byazt.h.qg>) arrayList);
    }

    public synchronized void n(final Collection<com.byazt.h.qg> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.vl.rv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = rv.this.s().edit();
                        for (com.byazt.h.qg qgVar : collection) {
                            if (qgVar != null && qgVar.qg() != 0) {
                                editorEdit.putString(String.valueOf(qgVar.qg()), qgVar.z().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void n(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.vl.rv.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = rv.this.s().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
