package com.byazt.shh;

import android.content.SharedPreferences;
import com.byazt.eld.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 61})
public class aj {

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    private static class pr {
        public static aj pr = new aj();
    }

    public static aj pr() {
        return pr.pr;
    }

    private aj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences hn() {
        return com.byazt.zs.aj.pr(k.getContext(), "sp_ad_download_event", 0);
    }

    public ConcurrentHashMap<Long, com.byazt.tia.hw> hw() {
        ConcurrentHashMap<Long, com.byazt.tia.hw> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = hn().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.byazt.tia.hw hwVarHw = com.byazt.tia.hw.hw(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && hwVarHw != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), hwVarHw);
                    }
                } catch (Exception e) {
                }
            }
        }
        return concurrentHashMap;
    }

    public void pr(com.byazt.tia.hw hwVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hwVar);
        pr((Collection<com.byazt.tia.hw>) arrayList);
    }

    public synchronized void pr(final Collection<com.byazt.tia.hw> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.shh.aj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = aj.this.hn().edit();
                        for (com.byazt.tia.hw hwVar : collection) {
                            if (hwVar != null && hwVar.hw() != 0) {
                                editorEdit.putString(String.valueOf(hwVar.hw()), hwVar.pq().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void pr(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.shh.aj.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = aj.this.hn().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
