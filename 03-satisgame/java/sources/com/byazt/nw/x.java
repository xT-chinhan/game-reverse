package com.byazt.nw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fz.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 21})
public class x extends q {
    public com.byazt.lr.n d;
    public com.byazt.ua.s oa;

    public x(com.byazt.dd.n nVar, com.byazt.ua.s sVar) {
        super(nVar);
        this.oa = sVar;
    }

    @Override // com.byazt.nw.q
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8130) {
            if (ct() == 5) {
                if (dg() == 5) {
                    if (this.fs != null) {
                        this.fs.n(null);
                    }
                } else if (this.n != null) {
                    this.n.n(null);
                }
            } else if (ct() == 9 && this.fs != null) {
                this.fs.n(null);
            }
        } else if (i == 8113) {
            if (ct() == 5) {
                if (dg() == 5) {
                    if (this.fs != null) {
                        this.fs.n();
                    }
                } else if (this.n != null) {
                    this.n.n();
                }
            } else if (ct() == 9 && this.fs != null) {
                this.fs.n();
            }
        } else if (i == 8131) {
            if (this.oa != null) {
                this.oa.n(this, pluginValueSet.stringValue(8036));
            }
        } else if (i == 8132) {
            if (this.cp != null) {
                com.byazt.mv.n.n(this.cp.qg());
            }
            if (this.d != null) {
                this.d.n(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            if (ct() == 5) {
                if (dg() == 5) {
                    if (this.fs instanceof com.byazt.us.q) {
                        ((com.byazt.us.q) this.fs).n(fFloatValue, fFloatValue2);
                    }
                } else if (this.n instanceof com.byazt.fz.x) {
                    ((com.byazt.fz.x) this.n).n(fFloatValue, fFloatValue2);
                }
            } else if (ct() == 9 && (this.fs instanceof com.byazt.us.q)) {
                ((com.byazt.us.q) this.fs).n(fFloatValue, fFloatValue2);
            }
        } else if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (ct() == 5) {
                if (dg() == 5) {
                    if (this.fs instanceof com.byazt.us.q) {
                        ((com.byazt.us.q) this.fs).n(view, strStringValue, iIntValue);
                    }
                } else if (this.n instanceof com.byazt.fz.x) {
                    ((com.byazt.fz.x) this.n).n(view, strStringValue, iIntValue);
                }
            } else if (ct() == 9 && (this.fs instanceof com.byazt.us.q)) {
                ((com.byazt.us.q) this.fs).n(view, strStringValue, iIntValue);
            }
        } else if (i == 8140) {
            String strStringValue2 = pluginValueSet.stringValue(8045);
            String strStringValue3 = pluginValueSet.stringValue(8046);
            int iIntValue2 = pluginValueSet.intValue(8047);
            String strStringValue4 = pluginValueSet.stringValue(8048);
            String strStringValue5 = pluginValueSet.stringValue(8049);
            String strStringValue6 = pluginValueSet.stringValue(8050);
            int iIntValue3 = pluginValueSet.intValue(8051);
            int iIntValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String strStringValue7 = pluginValueSet.stringValue(8054);
            boolean zBooleanValue = pluginValueSet.booleanValue(8055);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            String strStringValue9 = pluginValueSet.stringValue(8057);
            Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
            String strStringValue10 = pluginValueSet.stringValue(8058);
            double dDoubleValue = pluginValueSet.doubleValue(8016);
            boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
            int iIntValue5 = pluginValueSet.intValue(8060);
            String strStringValue11 = pluginValueSet.stringValue(8061);
            String strStringValue12 = pluginValueSet.stringValue(8061);
            long jLongValue = pluginValueSet.longValue(8078);
            String strStringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String strStringValue14 = pluginValueSet.stringValue(8080);
            String strStringValue15 = pluginValueSet.stringValue(8081);
            double dDoubleValue2 = pluginValueSet.doubleValue(8082);
            int iIntValue6 = pluginValueSet.intValue(8059);
            String strStringValue16 = pluginValueSet.stringValue(8551);
            String strStringValue17 = pluginValueSet.stringValue(8559);
            int iIntValue7 = pluginValueSet.intValue(8553);
            Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            Map map3 = (Map) pluginValueSet.objectValue(8564, Map.class);
            v(strStringValue2);
            j(strStringValue3);
            a(iIntValue2);
            ur(strStringValue4);
            an(strStringValue5);
            bb(strStringValue6);
            um(iIntValue3);
            cd(iIntValue4);
            n(list);
            lh(strStringValue7);
            fs(zBooleanValue);
            ou(strStringValue8);
            wm(strStringValue9);
            if (TextUtils.equals(lq(), "baidu")) {
                n(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
            }
            sz(strStringValue10);
            n(dDoubleValue);
            x(zBooleanValue2);
            cp(iIntValue5);
            ln(strStringValue11);
            py(strStringValue12);
            qg(jLongValue);
            m(strStringValue13);
            x(map);
            hu(strStringValue14);
            h(strStringValue15);
            q(dDoubleValue2);
            d(iIntValue6);
            d(strStringValue16);
            tj(strStringValue17);
            qg(iIntValue7);
            l(map2);
            w(map3);
        } else {
            if (i == 8143) {
                return (T) Double.valueOf(ta());
            }
            if (i == 8145) {
                if (this.qg != null) {
                    this.qg.qg();
                }
            } else if (i == 8146) {
                if (this.qg != null) {
                    this.qg.s();
                }
            } else if (i == 8118) {
                if (this.qg != null) {
                    this.qg.l();
                }
            } else if (i == 8117) {
                int iIntValue8 = pluginValueSet.intValue(8014);
                String strStringValue18 = pluginValueSet.stringValue(8015);
                if (this.qg != null) {
                    this.qg.n(new com.byazt.mj.n(iIntValue8, strStringValue18));
                }
            } else if (i == 8150) {
                if (this.qg != null) {
                    this.qg.q();
                }
            } else if (i == 1025) {
                if (this.qg != null) {
                    this.qg.n(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i == 8152) {
                if (this.s != null) {
                    this.s.n();
                }
            } else if (i == 8153) {
                if (this.s != null) {
                    this.s.qg();
                }
            } else if (i == 8187) {
                if (this.s != null) {
                    this.s.n(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i == 8155) {
                if (this.s != null) {
                    this.s.n(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8156) {
                if (this.s != null) {
                    this.s.n(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8157) {
                if (this.s != null) {
                    this.s.qg(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8158) {
                if (this.s != null) {
                    this.s.n(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i == 8160) {
                    return (T) Boolean.valueOf(an());
                }
                if (i == 6069) {
                    return (T) Integer.valueOf(dn());
                }
                if (i == 8185) {
                    com.byazt.lr.n nVar = this.d;
                    if (nVar != null) {
                        nVar.n();
                    }
                } else if (i == 8184) {
                    com.byazt.lr.n nVar2 = this.d;
                    if (nVar2 != null) {
                        nVar2.qg();
                    }
                } else {
                    if (i == 8196) {
                        return (T) Boolean.valueOf(kc());
                    }
                    if (i == 8197) {
                        if (this.q != null) {
                            this.q.n();
                        }
                    } else if (i == 8227) {
                        if (pluginValueSet != null) {
                            q((Map<String, Object>) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i == 6107 && this.x != null) {
                        this.x.n(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.byazt.ef.n.n(cls);
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, com.byazt.lr.n nVar) {
        this.d = nVar;
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(6085).n(Void.class).n(20033, activity).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void cp() {
        super.cp();
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(6083).n(Void.class).qg());
        }
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
    public View tj() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(6164).n(View.class).qg());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tj();
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
    public Integer w() {
        return n(this.tj);
    }

    @Override // com.byazt.sg.s
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar, List<View> list4) {
        super.n(activity, viewGroup, list, list2, list3, dVar, list4);
        qg(activity, viewGroup, list, list2, list3, dVar, list4);
    }

    private void qg(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, d dVar, List<View> list4) {
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8159).n(Void.class).n(20033, activity).n(8067, viewGroup).n(8068, list).n(8069, list2).n(8070, list3).n(8071, d.n(dVar)).n(8053, list4).qg());
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
    public int wf() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8161).n(Integer.class).qg());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.wf();
    }

    @Override // com.byazt.sg.s
    public int lr() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8162).n(Integer.class).qg());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.wf();
    }

    @Override // com.byazt.sg.s
    public String x() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8163).n(String.class).qg());
            return objApply instanceof String ? objApply.toString() : "";
        }
        return super.x();
    }

    @Override // com.byazt.sg.s
    public com.byazt.fvm.d es() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8269).n(Map.class).qg());
            if (objApply instanceof Map) {
                Map map = (Map) objApply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get("width");
                final Object obj3 = map.get("height");
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get(MediationConstant.EXTRA_DURATION);
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new com.byazt.fvm.d() { // from class: com.byazt.nw.x.1
                            @Override // com.byazt.fvm.d
                            public int n() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.byazt.fvm.d
                            public int qg() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.byazt.fvm.d
                            public String s() {
                                return str;
                            }

                            @Override // com.byazt.fvm.d
                            public double q() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            @Override // com.byazt.fvm.d
                            public boolean l() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }
                        };
                    }
                }
            }
        }
        return super.es();
    }

    @Override // com.byazt.sg.s
    public Bitmap dx() {
        if (TextUtils.equals(ci(), MediationConstant.ADN_GDT)) {
            return com.byazt.iu.qg.n(2);
        }
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8267).n(Bitmap.class).qg());
            if (objApply instanceof Bitmap) {
                return (Bitmap) objApply;
            }
            return null;
        }
        return super.dx();
    }

    @Override // com.byazt.sg.s
    public double on() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8268).n(Double.class).qg());
            if (objApply instanceof Double) {
                return ((Double) objApply).doubleValue();
            }
            return 0.0d;
        }
        return super.on();
    }

    @Override // com.byazt.sg.s
    public com.byazt.fz.l fs() {
        if (this.tj == null) {
            return null;
        }
        Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8320).n(Function.class).qg());
        if (objApply instanceof Function) {
            return com.byazt.qj.n.n((Function) objApply);
        }
        return null;
    }

    @Override // com.byazt.sg.s
    public void n() {
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8191).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void qg() {
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8192).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void s() {
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(6093).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public int q() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8193).n(Integer.class).qg());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.q();
    }
}
