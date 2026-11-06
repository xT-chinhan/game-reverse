package com.byazt.nw;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 101})
public class fs extends q {
    public fs(com.byazt.dd.n nVar) {
        super(nVar);
    }

    private com.byazt.me.n to() {
        return (com.byazt.me.n) this.rv;
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
                return objApply.toString();
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
        if (i == 8115) {
            if (this.rv instanceof com.byazt.me.n) {
                to().i_();
            }
        } else if (i == 8116) {
            if (this.rv instanceof com.byazt.me.n) {
                to().j_();
            }
        } else if (i == 8117) {
            if (this.rv instanceof com.byazt.me.n) {
                to().l();
            }
        } else if (i == 8118) {
            if (this.rv instanceof com.byazt.me.n) {
                to().q();
            }
        } else if (i == 8119) {
            if (this.rv instanceof com.byazt.me.n) {
                to().w();
            }
        } else if (i == 8230) {
            if (this.rv instanceof com.byazt.me.n) {
                to().n();
            }
        } else if (i == 8231) {
            if (this.rv instanceof com.byazt.me.n) {
                final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
                final float fIntValue = pluginValueSet.intValue(8018);
                final String strStringValue2 = pluginValueSet.stringValue(8019);
                Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map2 = new HashMap();
                if (map != null) {
                    map2.putAll(map);
                }
                com.byazt.fd.n nVar = new com.byazt.fd.n() { // from class: com.byazt.nw.fs.1
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

                    @Override // com.byazt.fd.n
                    public Map<String, Object> q() {
                        return map2;
                    }
                };
                com.byazt.xll.s.n(nVar, "GMRewardAd reward verify");
                to().n(nVar);
            }
        } else if (i == 1017) {
            if (this.rv instanceof com.byazt.me.n) {
                int iIntValue = 0;
                if (pluginValueSet != null) {
                    iIntValue = pluginValueSet.intValue(8014, 0);
                    strStringValue = pluginValueSet.stringValue(8015);
                } else {
                    strStringValue = "";
                }
                to().n(new com.byazt.mj.n(iIntValue, strStringValue));
            }
        } else if (i == 8111) {
            n(pluginValueSet.doubleValue(8016));
        }
        return (T) com.byazt.ef.n.n(cls);
    }
}
