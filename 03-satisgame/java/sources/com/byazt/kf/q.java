package com.byazt.kf;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fz.d;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1116, 5})
public class q extends fs {
    public q(com.byazt.pl.qg qgVar, Function<SparseArray<Object>, Object> function) {
        super(qgVar, function);
        if (function != null) {
            function.apply(com.byazt.of.qg.n().n(8127).n(Void.class).n(8034, this).qg());
            kj();
        }
    }

    private void kj() {
        PluginValueSet pluginValueSetQg = com.byazt.of.n.qg(this.cp);
        if (pluginValueSetQg != null) {
            Map<String, Object> map = (Map) pluginValueSetQg.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
            String strStringValue = pluginValueSetQg.stringValue(8045);
            String strStringValue2 = pluginValueSetQg.stringValue(8046);
            String strStringValue3 = pluginValueSetQg.stringValue(8048);
            String strStringValue4 = pluginValueSetQg.stringValue(8049);
            String strStringValue5 = pluginValueSetQg.stringValue(8050);
            int iIntValue = pluginValueSetQg.intValue(8051);
            int iIntValue2 = pluginValueSetQg.intValue(8052);
            List<String> list = (List) pluginValueSetQg.objectValue(8053, List.class);
            String strStringValue6 = pluginValueSetQg.stringValue(8054);
            double dDoubleValue = pluginValueSetQg.doubleValue(8016);
            boolean zBooleanValue = pluginValueSetQg.booleanValue(8033);
            int iIntValue3 = pluginValueSetQg.intValue(8060);
            String strStringValue7 = pluginValueSetQg.stringValue(8061);
            double dDoubleValue2 = pluginValueSetQg.doubleValue(8082);
            int iIntValue4 = pluginValueSetQg.intValue(8420);
            int iIntValue5 = pluginValueSetQg.intValue(8421);
            int iIntValue6 = pluginValueSetQg.intValue(8059);
            Function function = (Function) pluginValueSetQg.objectValue(8315, Function.class);
            if (dDoubleValue > 0.0d) {
                n(dDoubleValue);
            }
            s(map);
            v(strStringValue);
            j(strStringValue2);
            ur(strStringValue3);
            bb(strStringValue5);
            cd(iIntValue2);
            um(iIntValue);
            ln(strStringValue7);
            lh(strStringValue6);
            py(iIntValue4);
            ou(iIntValue5);
            q(dDoubleValue2);
            n(list);
            an(strStringValue4);
            x(zBooleanValue);
            cp(iIntValue3);
            d(iIntValue6);
            if (function != null) {
                com.byazt.xq.n nVar = new com.byazt.xq.n(function);
                ou(nVar.s());
                wm(nVar.q());
                qg(nVar.l());
                m(nVar.w());
                hu(nVar.fs());
                h(nVar.rv());
                x(nVar.x());
                d(nVar.qg());
                tj(nVar.n());
            }
        }
    }

    @Override // com.byazt.sg.s
    public com.byazt.fvm.x n(Activity activity) {
        if (this.cp == null) {
            return null;
        }
        Object objApply = this.cp.apply(com.byazt.of.qg.n().n(6072).n(Object.class).n(20033, activity).qg());
        if (objApply == null) {
            return null;
        }
        final com.byazt.pch.w wVar = new com.byazt.pch.w(com.byazt.mp.s.n(objApply));
        return new com.byazt.fvm.x() { // from class: com.byazt.kf.q.1
            @Override // com.byazt.fvm.x
            public void n(String str) {
            }

            @Override // com.byazt.fvm.x
            public void qg() {
            }

            @Override // com.byazt.fvm.x
            public boolean s() {
                return false;
            }

            @Override // com.byazt.fvm.x
            public void n() {
                wVar.n();
            }

            @Override // com.byazt.fvm.x
            public void n(com.byazt.lr.n nVar) {
                wVar.n(new com.byazt.xq.qg(nVar));
            }
        };
    }

    @Override // com.byazt.kf.s
    public void n(boolean z, double d, int i, Map<String, Object> map) {
        super.n(z, d, i, map);
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8225).n(Void.class).n(8406, Boolean.valueOf(z)).n(8407, Double.valueOf(d)).n(8408, Integer.valueOf(i)).n(8075, map).qg());
        }
    }

    @Override // com.byazt.sg.s
    public View rv() {
        if (this.cp != null) {
            Object objApply = this.cp.apply(com.byazt.of.qg.n().n(6081).n(View.class).qg());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.rv();
    }

    @Override // com.byazt.sg.s
    public View tj() {
        if (this.cp != null) {
            Object objApply = this.cp.apply(com.byazt.of.qg.n().n(6164).n(View.class).qg());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tj();
    }

    @Override // com.byazt.kf.fs
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar) {
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8159).n(Void.class).n(20033, activity).n(8067, viewGroup).n(8068, list).n(8069, list2).n(8070, list3).n(8071, d.n(dVar)).qg());
        }
    }

    @Override // com.byazt.sg.s
    public com.byazt.fz.l fs() {
        if (this.cp != null) {
            Object objApply = this.cp.apply(com.byazt.of.qg.n().n(8320).n(Function.class).qg());
            if (objApply instanceof Function) {
                return com.byazt.qj.n.n((Function) objApply);
            }
        }
        return super.fs();
    }

    @Override // com.byazt.sg.s
    public boolean a() {
        if (this.cp != null) {
            Object objApply = this.cp.apply(com.byazt.of.qg.n().n(8135).n(Boolean.class).qg());
            return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
        }
        return super.a();
    }

    @Override // com.byazt.kf.s, com.byazt.sg.s
    public void cy() {
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8149).n(Void.class).qg());
        }
    }

    @Override // com.byazt.kf.s, com.byazt.sg.s
    public void hd() {
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8148).n(Void.class).qg());
        }
    }

    @Override // com.byazt.kf.s, com.byazt.sg.s
    public void cd() {
        if (this.cp != null) {
            this.cp.apply(com.byazt.of.qg.n().n(8109).n(Void.class).qg());
        }
    }

    @Override // com.byazt.kf.s, com.byazt.sg.s
    public Integer w() {
        if (this.cp != null) {
            Integer numN = com.byazt.lpr.n.n(this.cp.apply(com.byazt.of.qg.n().n(8121).n(20068, 1).n(Object.class).qg()));
            if (numN != null) {
                return numN;
            }
        }
        return 1;
    }

    @Override // com.byazt.sg.s
    public String x() {
        if (this.cp != null) {
            Object objApply = this.cp.apply(com.byazt.of.qg.n().n(8228).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.x();
    }

    public void n(View view, String str, int i) {
        if (k() instanceof com.byazt.us.q) {
            try {
                ((com.byazt.us.q) k()).n(view, str, i);
            } catch (Exception unused) {
            }
        }
    }

    public void n(float f, float f2) {
        if (k() instanceof com.byazt.us.q) {
            try {
                ((com.byazt.us.q) k()).n(f, f2);
            } catch (Exception unused) {
            }
        }
    }

    public void tv() {
        n(new n() { // from class: com.byazt.kf.q.2
            @Override // com.byazt.kf.n
            public void n() {
                if (q.this.k() != null) {
                    q.this.k().n(null);
                }
            }
        });
    }

    public void to() {
        qg(new n() { // from class: com.byazt.kf.q.3
            @Override // com.byazt.kf.n
            public void n() {
                if (q.this.k() != null) {
                    q.this.k().n();
                }
            }
        });
    }

    public void kk() {
        if (oa() != null) {
            oa().qg();
        }
    }

    public void br() {
        if (oa() != null) {
            oa().s();
        }
    }

    public void nn() {
        if (oa() != null) {
            oa().q();
        }
    }

    public void lx() {
        if (oa() != null) {
            oa().l();
        }
    }

    public void n(com.byazt.cn.n nVar) {
        if (oa() != null) {
            oa().n(new com.byazt.mj.n(49012, com.byazt.mj.n.n(49012), nVar == null ? -1 : nVar.n(), nVar == null ? "" : nVar.qg()));
        }
    }

    public void n(long j, long j2) {
        if (oa() != null) {
            oa().n(j, j2);
        }
    }

    public void xa() {
        if (sz() != null) {
            sz().n();
        }
    }

    public void n(long j, long j2, String str, String str2) {
        if (sz() != null) {
            sz().n(j, j2, -1, 1, str, str2);
        }
    }

    public void qg(long j, long j2, String str, String str2) {
        if (sz() != null) {
            sz().n(j, j2, str, str2);
        }
    }

    public void s(long j, long j2, String str, String str2) {
        if (sz() != null) {
            sz().qg(j, j2, str, str2);
        }
    }

    public void n(long j, String str, String str2) {
        if (sz() != null) {
            sz().n(j, str, str2);
        }
    }

    public void n(String str, String str2) {
        if (sz() != null) {
            sz().n(str, str2);
        }
    }

    public void fh() {
        if (um() != null) {
            um().n();
        }
    }

    public void kz() {
        if (um() != null) {
            um().qg();
        }
    }

    public void n(int i, String str) {
        if (this.tj != null) {
            this.tj.n(this, str);
        }
        if (um() != null) {
            um().n(i, str, false);
        }
    }

    @Override // com.byazt.sg.s, com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderFail code:" + iIntValue + " msg:" + strStringValue + " view" + view);
            n(view, strStringValue, iIntValue);
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeRenderSuccess width:" + fFloatValue + " height:" + fFloatValue2);
            n(fFloatValue, fFloatValue2);
        } else if (i == 8130) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeAdClick");
            tv();
        } else if (i == 8113) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeAdShow");
            to();
        } else if (i == 8145) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoStart");
            kk();
        } else if (i == 8146) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoPause");
            br();
        } else if (i == 8150) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoResume");
            nn();
        } else if (i == 8118) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoCompleted");
            lx();
        } else if (i == 8117) {
            int iIntValue2 = pluginValueSet.intValue(8014);
            String strStringValue2 = pluginValueSet.stringValue(8015);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError code:" + iIntValue2 + " msg:" + strStringValue2);
            n(new com.byazt.cn.n(iIntValue2, strStringValue2));
        } else if (i == 8154) {
            long jLongValue = pluginValueSet.longValue(8072);
            long jLongValue2 = pluginValueSet.longValue(8073);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeVideoError current:" + jLongValue + " duration:" + jLongValue2);
            n(jLongValue, jLongValue2);
        } else if (i == 8152) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnIdle");
            xa();
        } else if (i == 8187) {
            long jLongValue3 = pluginValueSet.longValue(8062);
            long jLongValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadActive totalBytes:" + jLongValue3 + " curlBytes:" + jLongValue4);
            n(jLongValue3, jLongValue4, "", "");
        } else if (i == 8158) {
            long jLongValue5 = pluginValueSet.longValue(8062);
            long jLongValue6 = pluginValueSet.longValue(8063);
            String strStringValue3 = pluginValueSet.stringValue(8066);
            String strStringValue4 = pluginValueSet.stringValue(8056);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadPaused totalBytes:" + jLongValue5 + " curlBytes:" + jLongValue6 + " fileName:" + strStringValue3 + " appName:" + strStringValue4);
            qg(jLongValue5, jLongValue6, strStringValue3, strStringValue4);
        } else if (i == 8157) {
            long jLongValue7 = pluginValueSet.longValue(8062);
            long jLongValue8 = pluginValueSet.longValue(8063);
            String strStringValue5 = pluginValueSet.stringValue(8066);
            String strStringValue6 = pluginValueSet.stringValue(8056);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFailed totalBytes:" + jLongValue7 + " curlBytes:" + jLongValue8 + " fileName:" + strStringValue5 + " appName:" + strStringValue6);
            s(jLongValue7, jLongValue8, strStringValue5, strStringValue6);
        } else if (i == 8155) {
            long jLongValue9 = pluginValueSet.longValue(8062);
            String strStringValue7 = pluginValueSet.stringValue(8066);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished totalBytes:" + jLongValue9 + " fileName:" + strStringValue7 + " appName:" + strStringValue8);
            n(jLongValue9, strStringValue7, strStringValue8);
        } else if (i == 8156) {
            String strStringValue9 = pluginValueSet.stringValue(8066);
            String strStringValue10 = pluginValueSet.stringValue(8056);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeOnDownloadFinished  fileName:" + strStringValue9 + " appName:" + strStringValue10);
            n(strStringValue9, strStringValue10);
        } else if (i == 8185) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeShow");
            fh();
        } else if (i == 8184) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeCancel");
            kz();
        } else if (i != 6085) {
            if (i == 8110) {
                boolean zO = o();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : isClientBiddingAd :".concat(String.valueOf(zO)));
                return (T) Boolean.valueOf(zO);
            }
            if (i == 8136) {
                boolean zDm = dm();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : isServerBiddingAd :".concat(String.valueOf(zDm)));
                return (T) Boolean.valueOf(zDm);
            }
            if (i == 8160) {
                boolean zAn = an();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : isUseCustomVideo :".concat(String.valueOf(zAn)));
                return (T) Boolean.valueOf(zAn);
            }
            if (i == 8226) {
                int iBz = bz();
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : getBiddingType :".concat(String.valueOf(iBz)));
                return (T) Integer.valueOf(iBz);
            }
            if (i == 8132) {
                int iIntValue3 = pluginValueSet.intValue(8038);
                String strStringValue11 = pluginValueSet.stringValue(8039);
                com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw ad : callNativeDislikeSelected postion:" + iIntValue3 + " value:" + strStringValue11);
                n(iIntValue3, strStringValue11);
            }
        }
        return (T) com.byazt.ef.n.n(cls);
    }
}
