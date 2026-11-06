package com.byazt.ki;

import android.view.View;
import com.byazt.dd.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1163, 13})
public final class hw {
    public final String aj;
    public final Map<String, Object> c;
    public final WeakReference<View> fw;
    public final String hn;
    public final String hw;
    public final String pr;
    public final List<Map<String, Object>> uc;
    public final c vk;
    public final String x;
    public final String zo;

    private hw(pr prVar) {
        Map<String, Object> mapUnmodifiableMap;
        List<Map<String, Object>> listUnmodifiableList;
        this.pr = prVar.pr == null ? UUID.randomUUID().toString() : prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        if (prVar.c == null) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(prVar.c));
        }
        this.c = mapUnmodifiableMap;
        if (prVar.uc == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(prVar.uc);
        }
        this.uc = listUnmodifiableList;
        this.fw = prVar.fw == null ? null : new WeakReference<>(prVar.fw);
        this.zo = prVar.zo;
        this.aj = prVar.aj;
        this.vk = prVar.vk;
    }

    public String pr() {
        return this.pr;
    }

    public View hw() {
        WeakReference<View> weakReference = this.fw;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String hn() {
        return this.aj;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("TriggerDefinition{triggerId='").append(this.pr).append("', eventType='").append(this.hw).append("', eventName='").append(this.hn).append("', eventHost='").append(this.x).append("', conditionParams=").append(this.c).append(", actions=").append(this.uc).append(", source='").append(this.zo).append("', framework='").append(this.aj).append("', boundView=");
        View viewHw = hw();
        String str = AbstractJsonLexerKt.NULL;
        StringBuilder sbAppend2 = sbAppend.append(viewHw == null ? AbstractJsonLexerKt.NULL : "set").append(", listener=");
        if (this.vk != null) {
            str = "set";
        }
        return sbAppend2.append(str).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public static pr x() {
        return new pr();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1163, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public String aj;
        public Map<String, Object> c;
        public View fw;
        public String hn;
        public String hw;
        public String pr;
        public List<Map<String, Object>> uc;
        public c vk;
        public String x;
        public String zo;

        public pr pr(String str) {
            this.hw = str;
            return this;
        }

        public pr hw(String str) {
            this.hn = str;
            return this;
        }

        public pr hn(String str) {
            this.x = str;
            return this;
        }

        public pr pr(Map<String, Object> map) {
            this.c = map;
            return this;
        }

        public pr x(String str) {
            this.aj = str;
            return this;
        }

        public pr pr(c cVar) {
            this.vk = cVar;
            return this;
        }

        public hw pr() {
            return new hw(this);
        }
    }
}
