package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t {
    public List<g> n;

    public t(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.n = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.n.add(new g(jSONArray.optJSONObject(i), 4));
        }
    }

    public static List<g> n(pk pkVar) {
        t tVarRt;
        if (pkVar == null || (tVarRt = pkVar.rt()) == null) {
            return null;
        }
        return tVarRt.n;
    }

    public static boolean qg(pk pkVar) {
        t tVarRt;
        List<g> list;
        return (pkVar == null || (tVarRt = pkVar.rt()) == null || (list = tVarRt.n) == null || list.isEmpty()) ? false : true;
    }

    public static g s(pk pkVar) {
        List<g> listN;
        if (qg(pkVar) && (listN = n(pkVar)) != null && !listN.isEmpty()) {
            for (g gVar : listN) {
                if (gVar != null && gVar.k()) {
                    boolean z = gVar.q() == 1;
                    if (1 == gVar.tj() && z) {
                        return gVar;
                    }
                }
            }
        }
        return null;
    }

    public static List<g> q(pk pkVar) {
        List<g> listN;
        if (!qg(pkVar) || (listN = n(pkVar)) == null || listN.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (g gVar : listN) {
            if (gVar != null && gVar.k() && gVar.tj() == 0) {
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    public static boolean l(pk pkVar) {
        return (pkVar == null || com.byazt.nf.rv.qg().es() || !qg(pkVar) || s(pkVar) == null) ? false : true;
    }
}
