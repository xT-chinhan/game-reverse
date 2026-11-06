package com.byazt.zf;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.anythink.core.d.b.e;
import com.byazt.fvm.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public boolean n;

    public void n(boolean z, com.byazt.yn.n nVar, com.byazt.zq.qg qgVar, final com.byazt.ua.qg qgVar2) {
        if (nVar == null || qgVar2 == null) {
            return;
        }
        this.n = z;
        nVar.n(qgVar, new com.byazt.ap.w(null) { // from class: com.byazt.zf.rv.1
            @Override // com.byazt.ap.w
            public void n(int i, String str) {
                qgVar2.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.w
            public void n(List<sz> list) {
                if (list == null || list.size() == 0) {
                    qgVar2.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (sz szVar : list) {
                    if (szVar != null) {
                        arrayList.add(rv.this.new n(szVar));
                    }
                }
                qgVar2.n(arrayList);
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 547, 160})
    class n extends com.byazt.sg.s {
        public com.byazt.fx.qg cp;
        public com.byazt.fx.s d;
        public volatile boolean sz = false;
        public sz tj;

        @Override // com.byazt.sg.s
        public boolean a() {
            return true;
        }

        public n(sz szVar) {
            Map<String, Object> mapFs;
            Function function = null;
            this.cp = new com.byazt.fx.qg(function) { // from class: com.byazt.zf.rv.n.2
                @Override // com.byazt.fx.qg
                public void n(View view, int i) {
                    if (n.this.n != null) {
                        n.this.n.n(view);
                    }
                }

                @Override // com.byazt.fx.qg
                public void qg(View view, int i) {
                    if (n.this.n != null) {
                        n.this.n.n();
                    }
                }

                @Override // com.byazt.fx.qg
                public void n(View view, String str, int i) {
                    if (n.this.n instanceof com.byazt.fz.x) {
                        ((com.byazt.fz.x) n.this.n).n(view, str, i);
                    }
                }

                @Override // com.byazt.fx.qg
                public void n(View view, float f, float f2) {
                    if (n.this.n instanceof com.byazt.fz.x) {
                        ((com.byazt.fz.x) n.this.n).n(f, f2);
                    }
                }
            };
            this.d = new com.byazt.fx.s(function) { // from class: com.byazt.zf.rv.n.3
                @Override // com.byazt.fx.s
                public void n() {
                    if (n.this.qg != null) {
                        n.this.qg.n();
                    }
                }

                @Override // com.byazt.fx.s
                public void n(int i, int i2) {
                    if (n.this.qg != null) {
                        n.this.qg.n(new com.byazt.mj.n(i, "MediaPlayer inter error code:".concat(String.valueOf(i2))));
                    }
                }

                @Override // com.byazt.fx.s
                public void qg() {
                    if (n.this.qg != null) {
                        n.this.qg.qg();
                    }
                }

                @Override // com.byazt.fx.s
                public void s() {
                    if (n.this.qg != null) {
                        n.this.qg.s();
                    }
                }

                @Override // com.byazt.fx.s
                public void q() {
                    if (n.this.qg != null) {
                        n.this.qg.q();
                    }
                }

                @Override // com.byazt.fx.s
                public void n(long j, long j2) {
                    if (n.this.qg != null) {
                        n.this.qg.n(j, j2);
                    }
                }

                @Override // com.byazt.fx.s
                public void l() {
                    if (n.this.qg != null) {
                        n.this.qg.l();
                    }
                }
            };
            this.tj = szVar;
            cp(szVar.qg());
            d(this.tj.s());
            x(true);
            if (rv.this.n && (mapFs = szVar.fs()) != null) {
                double dN = com.byazt.mt.qg.n(mapFs.get(e.a.h));
                com.byazt.rb.qg.n("TTMediationSDK_ECMP", "pangle 模板native 返回的 cpm价格：".concat(String.valueOf(dN)));
                n(dN <= 0.0d ? 0.0d : dN);
            }
            n(MediationConstant.EXTRA_ADID, Long.valueOf(c()));
            n("c_id", Long.valueOf(dz()));
            Map<String, Object> mapFs2 = this.tj.fs();
            if (mapFs2 != null) {
                q(mapFs2);
                n("log_extra", mapFs2.toString());
            }
            this.tj.n(this.cp);
            this.tj.n(this.d);
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapFs;
            sz szVar = this.tj;
            if (szVar == null || (mapFs = szVar.fs()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapFs.get("coupon"));
            map.put("live_room", mapFs.get("live_room"));
            map.put("product", mapFs.get("product"));
            s(map);
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public void cp() {
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.q();
            }
        }

        @Override // com.byazt.sg.s
        public View rv() {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.n();
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public String di() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.s(szVar.fs());
            }
            return null;
        }

        @Override // com.byazt.sg.s
        public void cd() {
            this.sz = true;
            com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zf.rv.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.tj != null) {
                        n.this.tj.l();
                    }
                }
            });
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.sz;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.n(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            sz szVar = this.tj;
            if (szVar != null) {
                return com.byazt.mt.qg.qg(szVar.fs());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, com.byazt.lr.n nVar) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + nVar);
                this.tj.n(activity, nVar);
            }
        }

        @Override // com.byazt.sg.s
        public void n(Dialog dialog, Integer[] numArr) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.tj.n(dialog, numArr);
            }
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.x n(Activity activity) {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.n(activity);
            }
            return super.n(activity);
        }

        @Override // com.byazt.sg.s
        public com.byazt.fvm.q qd() {
            sz szVar = this.tj;
            if (szVar != null) {
                return szVar.w();
            }
            return super.qd();
        }

        @Override // com.byazt.sg.s
        public void f(String str) {
            if (this.tj != null) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "pangle native express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.tj.n(str);
            }
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            sz szVar = this.tj;
            if (szVar != null) {
                szVar.n(qgVar);
            }
        }
    }
}
