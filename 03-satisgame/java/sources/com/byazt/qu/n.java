package com.byazt.qu;

import android.util.SparseArray;
import com.byazt.xmw.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 19})
public class n {
    public PluginValueSet n;
    public com.byazt.zq.n qg;
    public com.byazt.xmw.n s;

    public static n n(PluginValueSet pluginValueSet) {
        return new n(pluginValueSet);
    }

    private n(PluginValueSet pluginValueSet) {
        this.n = pluginValueSet;
        if (pluginValueSet != null) {
            com.byazt.zq.n nVar = new com.byazt.zq.n(pluginValueSet.sparseArray());
            this.qg = nVar;
            this.s = nVar.k();
        }
    }

    public boolean n() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.cy();
        }
        return false;
    }

    public PluginValueSet qg() {
        return this.n;
    }

    public Function<SparseArray<Object>, Object> s() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(15, Function.class);
        }
        return null;
    }

    public boolean q() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.fs();
        }
        return false;
    }

    public String l() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.n();
        }
        return null;
    }

    public String w() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.qg();
        }
        return null;
    }

    public boolean x() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.s();
        }
        return false;
    }

    public String fs() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.q();
        }
        return null;
    }

    public String rv() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.l();
        }
        return null;
    }

    public int tj() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.w();
        }
        return 0;
    }

    public boolean cp() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.x();
        }
        return false;
    }

    public boolean d() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.tj();
        }
        return false;
    }

    public int[] oa() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.rv();
        }
        return null;
    }

    public Map<String, Object> sz() {
        com.byazt.zq.n nVar = this.qg;
        if (nVar != null) {
            return nVar.hd();
        }
        return null;
    }

    public String k() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.n();
        }
        return null;
    }

    public boolean cy() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.qg();
        }
        return false;
    }

    public s hd() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.s();
        }
        return null;
    }

    public Map<String, Object> cd() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.q();
        }
        return null;
    }

    public boolean um() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.l();
        }
        return false;
    }

    public JSONObject a() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.w();
        }
        return null;
    }

    public String py() {
        com.byazt.xmw.n nVar = this.s;
        return nVar != null ? nVar.x() : "";
    }

    public boolean ou() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.fs();
        }
        return false;
    }

    public boolean wm() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.rv();
        }
        return false;
    }

    public boolean m() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null) {
            return nVar.tj();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> hu() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null && nVar.q() != null) {
            Object obj = this.s.q().get("qa_config_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> h() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null && nVar.q() != null) {
            Object obj = this.s.q().get("qa_event_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> t() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null && nVar.q() != null) {
            Object obj = this.s.q().get("qa_preview_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> ur() {
        com.byazt.xmw.n nVar = this.s;
        if (nVar != null && nVar.q() != null) {
            Object obj = this.s.q().get("qa_common_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }
}
