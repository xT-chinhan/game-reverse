package com.byazt.pl;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 13})
public class w extends qg {
    public com.byazt.kf.s rv;

    public w(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void n(double d, Map<String, Object> map) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
            com.byazt.kf.x xVar = new com.byazt.kf.x(this, this.s);
            this.rv = xVar;
            n(xVar, d, map);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void s() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.1
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    w.this.qg(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.1.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.sr.n nVar = (com.byazt.sr.n) w.this.rv.rn();
                            if (nVar != null) {
                                nVar.n();
                            }
                        }
                    });
                }
            });
        }
    }

    public void q() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.2
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    w.this.s(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.2.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.sr.n nVar = (com.byazt.sr.n) w.this.rv.rn();
                            if (nVar != null) {
                                nVar.qg();
                            }
                        }
                    });
                }
            });
        }
    }

    public void l() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.3
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.sr.n nVar = (com.byazt.sr.n) w.this.rv.rn();
                    if (nVar != null) {
                        nVar.s();
                    }
                }
            });
        }
    }

    public void sz() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.4
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.sr.n nVar = (com.byazt.sr.n) w.this.rv.rn();
                    if (nVar != null) {
                        nVar.q();
                    }
                }
            });
        }
    }

    public void k() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.w.5
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.sr.n nVar = (com.byazt.sr.n) w.this.rv.rn();
                    if (nVar != null) {
                        nVar.l();
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
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            n(dDoubleValue, map);
        } else if (i == 1008) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialShow");
            s();
        } else if (i == 1009) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdClick");
            q();
        } else if (i == 1014) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialClosed");
            l();
        } else if (i == 1015) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdOpened");
            sz();
        } else if (i == 1016) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            k();
        }
        return null;
    }
}
