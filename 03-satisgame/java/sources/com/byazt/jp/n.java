package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 19})
public class n {
    public boolean cp;
    public JSONObject d;
    public q fs;
    public boolean k;
    public boolean l;
    public String n;
    public Map<String, Object> oa;
    public String q;
    public String qg;
    public w rv;
    public boolean s;
    public PluginValueSet sz;
    public Map<String, Object> tj;
    public d w;
    public fs x;

    private n(C0226n c0226n) {
        this.n = c0226n.n;
        this.qg = c0226n.qg;
        this.s = c0226n.s;
        this.q = c0226n.q;
        this.l = c0226n.l;
        if (c0226n.w == null) {
            this.w = new d.n().n();
        } else {
            this.w = c0226n.w;
        }
        if (c0226n.x == null) {
            this.x = new fs.n().n();
        } else {
            this.x = c0226n.x;
        }
        if (c0226n.fs == null) {
            this.fs = new q.n().n();
        } else {
            this.fs = c0226n.fs;
        }
        if (c0226n.rv == null) {
            this.rv = new w();
        } else {
            this.rv = c0226n.rv;
        }
        this.tj = c0226n.tj;
        this.cp = c0226n.cp;
        this.d = c0226n.d;
        this.oa = c0226n.oa;
        this.sz = c0226n.sz;
        this.k = c0226n.k;
    }

    /* JADX INFO: renamed from: com.byazt.jp.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0226n {
        public JSONObject d;
        public q fs;
        public boolean k;
        public String n;
        public Map<String, Object> oa;
        public String qg;
        public w rv;
        public PluginValueSet sz;
        public Map<String, Object> tj;
        public d w;
        public fs x;
        public boolean s = false;
        public String q = "";
        public boolean l = false;
        public boolean cp = false;

        public C0226n n(String str) {
            this.n = str;
            return this;
        }

        public C0226n qg(String str) {
            this.qg = str;
            return this;
        }

        public C0226n n(boolean z) {
            this.s = z;
            return this;
        }

        public C0226n s(String str) {
            this.q = str;
            return this;
        }

        public C0226n qg(boolean z) {
            this.l = z;
            return this;
        }

        public C0226n n(d dVar) {
            this.w = dVar;
            return this;
        }

        public C0226n n(fs fsVar) {
            this.x = fsVar;
            return this;
        }

        public C0226n n(w wVar) {
            this.rv = wVar;
            return this;
        }

        public C0226n n(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.tj == null) {
                    this.tj = new HashMap();
                }
                this.tj.putAll(map);
            }
            return this;
        }

        public C0226n s(boolean z) {
            this.cp = z;
            return this;
        }

        public C0226n n(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public C0226n n(PluginValueSet pluginValueSet) {
            this.sz = pluginValueSet;
            return this;
        }

        public C0226n q(boolean z) {
            this.k = z;
            return this;
        }

        public n n() {
            return new n(this);
        }
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    public String q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    public d w() {
        return this.w;
    }

    public fs x() {
        return this.x;
    }

    public q fs() {
        return this.fs;
    }

    public w rv() {
        return this.rv;
    }

    public Map<String, Object> tj() {
        return this.tj;
    }

    public boolean cp() {
        return this.cp;
    }

    public JSONObject d() {
        return this.d;
    }

    public Map<String, Object> oa() {
        return this.oa;
    }

    public PluginValueSet sz() {
        return this.sz;
    }

    public boolean k() {
        return this.k;
    }
}
