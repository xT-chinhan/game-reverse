package com.byazt.nw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fz.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 8})
public class s extends q {
    public s(com.byazt.dd.n nVar) {
        super(nVar);
    }

    private com.byazt.gl.n to() {
        return (com.byazt.gl.n) this.rv;
    }

    @Override // com.byazt.sg.s
    public Integer w() {
        return n(this.tj);
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
    public View rv() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(6081).n(View.class).qg());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.rv();
    }

    @Override // com.byazt.sg.s
    public boolean a() {
        try {
            if (this.tj != null) {
                Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8135).n(Boolean.class).qg());
                return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
            }
        } catch (Exception unused) {
        }
        return super.a();
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar, List<View> list4) {
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8159).n(Void.class).n(20033, activity).n(8067, viewGroup).n(8068, list).n(8069, list2).n(8070, list3).n(8071, d.n(dVar)).qg());
        }
    }

    @Override // com.byazt.nw.q
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 1008) {
            if (!(this.rv instanceof com.byazt.gl.n)) {
                return null;
            }
            to().qg(null);
            return null;
        }
        if (i != 1009) {
            if (i != 1014) {
                if (i == 1016) {
                    boolean z = this.rv instanceof com.byazt.gl.n;
                } else if (i == 8111) {
                    n(pluginValueSet.doubleValue(8016));
                } else if (i == 8140) {
                    String strStringValue = pluginValueSet.stringValue(8045);
                    String strStringValue2 = pluginValueSet.stringValue(8046);
                    int iIntValue = pluginValueSet.intValue(8047);
                    String strStringValue3 = pluginValueSet.stringValue(8048);
                    String strStringValue4 = pluginValueSet.stringValue(8049);
                    String strStringValue5 = pluginValueSet.stringValue(8050);
                    int iIntValue2 = pluginValueSet.intValue(8051);
                    int iIntValue3 = pluginValueSet.intValue(8052);
                    List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                    String strStringValue6 = pluginValueSet.stringValue(8054);
                    boolean zBooleanValue = pluginValueSet.booleanValue(8055);
                    String strStringValue7 = pluginValueSet.stringValue(8056);
                    String strStringValue8 = pluginValueSet.stringValue(8057);
                    Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
                    String strStringValue9 = pluginValueSet.stringValue(8058);
                    double dDoubleValue = pluginValueSet.doubleValue(8016);
                    boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
                    int iIntValue4 = pluginValueSet.intValue(8060);
                    String strStringValue10 = pluginValueSet.stringValue(8061);
                    String strStringValue11 = pluginValueSet.stringValue(8061);
                    long jLongValue = pluginValueSet.longValue(8078);
                    String strStringValue12 = pluginValueSet.stringValue(8079);
                    Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                    String strStringValue13 = pluginValueSet.stringValue(8080);
                    String strStringValue14 = pluginValueSet.stringValue(8081);
                    double dDoubleValue2 = pluginValueSet.doubleValue(8082);
                    int iIntValue5 = pluginValueSet.intValue(8059);
                    String strStringValue15 = pluginValueSet.stringValue(8551);
                    String strStringValue16 = pluginValueSet.stringValue(8559);
                    Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
                    Map map3 = (Map) pluginValueSet.objectValue(8564, Map.class);
                    v(strStringValue);
                    j(strStringValue2);
                    a(iIntValue);
                    ur(strStringValue3);
                    an(strStringValue4);
                    bb(strStringValue5);
                    um(iIntValue2);
                    cd(iIntValue3);
                    n(list);
                    lh(strStringValue6);
                    fs(zBooleanValue);
                    ou(strStringValue7);
                    wm(strStringValue8);
                    if (TextUtils.equals(lq(), "baidu")) {
                        n(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
                    }
                    sz(strStringValue9);
                    n(dDoubleValue);
                    x(zBooleanValue2);
                    cp(iIntValue4);
                    d(iIntValue5);
                    ln(strStringValue10);
                    py(strStringValue11);
                    qg(jLongValue);
                    m(strStringValue12);
                    x(map);
                    hu(strStringValue13);
                    h(strStringValue14);
                    q(dDoubleValue2);
                    d(strStringValue15);
                    tj(strStringValue16);
                    l(map2);
                    w(map3);
                } else if (i == 8207) {
                    sz(pluginValueSet.stringValue(8058));
                }
            } else if (this.rv instanceof com.byazt.gl.n) {
                if (this.cp != null) {
                    com.byazt.mv.n.n(this.cp.qg());
                }
                to().n();
            }
        } else if (this.rv instanceof com.byazt.gl.n) {
            to().n((View) null);
            return null;
        }
        return null;
    }
}
