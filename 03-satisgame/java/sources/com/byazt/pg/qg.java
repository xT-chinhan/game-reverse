package com.byazt.pg;

import android.view.View;
import com.byazt.xz.l;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 694, 26})
public final class qg {
    public final l fs;
    public final List<Map<String, Object>> l;
    public final String n;
    public final Map<String, Object> q;
    public final String qg;
    public final String s;
    public final WeakReference<View> w;
    public final String x;

    private qg(n nVar) {
        Map<String, Object> mapUnmodifiableMap;
        List<Map<String, Object>> listUnmodifiableList;
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        if (nVar.q == null) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(nVar.q));
        }
        this.q = mapUnmodifiableMap;
        if (nVar.l == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(nVar.l);
        }
        this.l = listUnmodifiableList;
        this.w = nVar.w == null ? null : new WeakReference<>(nVar.w);
        this.x = nVar.x;
        this.fs = nVar.fs;
    }

    public String n() {
        return this.qg;
    }

    public View qg() {
        WeakReference<View> weakReference = this.w;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("TriggerDefinition{eventType='").append(this.n).append("', eventName='").append(this.qg).append("', eventHost='").append(this.s).append("', conditionParams=").append(this.q).append(", actions=").append(this.l).append(", source='").append(this.x).append("', boundView=");
        View viewQg = qg();
        String str = AbstractJsonLexerKt.NULL;
        StringBuilder sbAppend2 = sbAppend.append(viewQg == null ? AbstractJsonLexerKt.NULL : "set").append(", listener=");
        if (this.fs != null) {
            str = "set";
        }
        return sbAppend2.append(str).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public static n s() {
        return new n();
    }

    @com.byazt.cp.n(n = {0, 1, 694, 48})
    public static final class n {
        public l fs;
        public List<Map<String, Object>> l;
        public String n;
        public Map<String, Object> q;
        public String qg;
        public String s;
        public View w;
        public String x;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n qg(String str) {
            this.qg = str;
            return this;
        }

        public n s(String str) {
            this.s = str;
            return this;
        }

        public n n(Map<String, Object> map) {
            this.q = map;
            return this;
        }

        public n n(l lVar) {
            this.fs = lVar;
            return this;
        }

        public qg n() {
            return new qg(this);
        }
    }
}
