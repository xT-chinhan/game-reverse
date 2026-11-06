package com.byazt.pl;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 19})
public class n extends qg {
    public com.byazt.kf.s rv;

    public n(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void n(double d, Map<String, Object> map) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
            com.byazt.kf.qg qgVar = new com.byazt.kf.qg(this, this.s);
            this.rv = qgVar;
            qgVar.s(this.l);
            this.rv.sz(this.q.h());
            if (d > 0.0d && rv() == 1) {
                this.rv.n(d);
            }
            if (map != null) {
                this.l.putAll(map);
            }
            this.rv.q(this.l);
            n(this.rv);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void s() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.n.1
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.gl.n nVar = (com.byazt.gl.n) n.this.rv.rn();
                    if (nVar != null) {
                        nVar.qg(null);
                    }
                }
            });
        }
    }

    public void q() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.n.2
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    n.this.s(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.n.2.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.gl.n nVar = (com.byazt.gl.n) n.this.rv.rn();
                            if (nVar != null) {
                                nVar.n((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void l() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.n.3
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.gl.n nVar = (com.byazt.gl.n) n.this.rv.rn();
                    if (nVar != null) {
                        nVar.n();
                    }
                }
            });
        }
    }

    @Override // com.byazt.pl.qg
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom banner loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom banner loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            n(dDoubleValue, map);
        } else if (i == 1008) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom banner loader : callBannerAdShow");
            s();
        } else if (i == 1009) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClick");
            q();
        } else if (i == 1014) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClosed");
            l();
        }
        return null;
    }
}
