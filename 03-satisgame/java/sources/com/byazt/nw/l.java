package com.byazt.nw;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 18})
public class l extends q {
    public l(com.byazt.dd.n nVar) {
        super(nVar);
    }

    private com.byazt.pf.n to() {
        return (com.byazt.pf.n) this.rv;
    }

    @Override // com.byazt.sg.s
    public Integer w() {
        return n(this.tj);
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, Object obj, String str) {
        super.n(activity, obj, str);
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8113).n(Void.class).n(20033, activity).qg());
        }
    }

    @Override // com.byazt.sg.s
    public String di() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8147).n(String.class).qg());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        }
        return super.di();
    }

    @Override // com.byazt.sg.s
    public boolean rm() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8211).n(Boolean.class).qg());
            if (objApply instanceof Boolean) {
                return ((Boolean) objApply).booleanValue();
            }
            return super.rm();
        }
        return super.rm();
    }

    @Override // com.byazt.nw.q
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(ta());
        }
        if (i == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!tv() && !nk()) {
                return null;
            }
            n(pluginValueSet.doubleValue(8016));
            return null;
        }
        int iIntValue = 0;
        if (i == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            x(Boolean.valueOf(pluginValueSet.booleanValue(8033, false)).booleanValue());
            return null;
        }
        if (i == 1008) {
            if (to() == null) {
                return null;
            }
            to().n();
            return null;
        }
        if (i == 1017) {
            if (to() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            to().n(new com.byazt.mj.n(iIntValue, strStringValue));
            return null;
        }
        if (i == 1009) {
            if (to() == null) {
                return null;
            }
            to().g_();
            return null;
        }
        if (i == 1014) {
            if (to() == null) {
                return null;
            }
            to().h_();
            return null;
        }
        if (i == 1026) {
            if (to() == null) {
                return null;
            }
            to().q();
            return null;
        }
        if (i == 1021) {
            if (to() == null) {
                return null;
            }
            to().l();
            return null;
        }
        if (i == 1037) {
            if (to() == null) {
                return null;
            }
            to().w();
            return null;
        }
        if (i != 1018 || to() == null) {
            return null;
        }
        final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
        final float fIntValue = pluginValueSet.intValue(8018);
        final String strStringValue2 = pluginValueSet.stringValue(8019);
        to().n(new com.byazt.fd.n() { // from class: com.byazt.nw.l.1
            @Override // com.byazt.fd.n
            public Map<String, Object> q() {
                return null;
            }

            @Override // com.byazt.fd.n
            public boolean n() {
                return zBooleanValue;
            }

            @Override // com.byazt.fd.n
            public float qg() {
                return fIntValue;
            }

            @Override // com.byazt.fd.n
            public String s() {
                return strStringValue2;
            }
        });
        return null;
    }
}
