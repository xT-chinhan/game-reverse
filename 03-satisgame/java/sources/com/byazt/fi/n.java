package com.byazt.fi;

import com.byazt.pg.qg;
import com.byazt.xz.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1748, 19})
public class n {
    public final Map<String, List<C0175n>> n = new HashMap();

    /* JADX INFO: renamed from: com.byazt.fi.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1748, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0175n {
        public final String n;
        public final qg q;
        public final Map<String, Object> qg;
        public final l s;

        public C0175n(String str, Map<String, Object> map, l lVar, qg qgVar) {
            Map<String, Object> mapUnmodifiableMap;
            this.n = str;
            if (map == null) {
                mapUnmodifiableMap = Collections.emptyMap();
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
            }
            this.qg = mapUnmodifiableMap;
            this.s = lVar;
            this.q = qgVar;
        }

        public Map<String, Object> n() {
            return this.qg;
        }

        public l qg() {
            return this.s;
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder("Registration{name='").append(this.n).append("', params=").append(this.qg).append(", listener=");
            l lVar = this.s;
            String strN = AbstractJsonLexerKt.NULL;
            StringBuilder sbAppend2 = sbAppend.append(lVar == null ? AbstractJsonLexerKt.NULL : "set").append(", definition=");
            qg qgVar = this.q;
            if (qgVar != null) {
                strN = qgVar.n();
            }
            return sbAppend2.append(strN).append(AbstractJsonLexerKt.END_OBJ).toString();
        }
    }

    public synchronized C0175n n(String str, String str2, Map<String, Object> map, l lVar) {
        if (str != null) {
            if (!str.isEmpty()) {
                qg qgVarN = qg.s().n(com.byazt.pg.n.n(str)).qg(str).s(str2).n(map).n(lVar).n();
                if (str2 != null && str2.startsWith("Lottie://")) {
                    str = str2;
                }
                C0175n c0175n = new C0175n(str, map, lVar, qgVarN);
                List<C0175n> arrayList = this.n.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.n.put(str, arrayList);
                }
                arrayList.add(c0175n);
                arrayList.size();
                return c0175n;
            }
        }
        return null;
    }

    public synchronized List<C0175n> n(String str) {
        List<C0175n> list = this.n.get(str);
        if (list != null && !list.isEmpty()) {
            return Collections.unmodifiableList(new ArrayList(list));
        }
        return Collections.emptyList();
    }
}
