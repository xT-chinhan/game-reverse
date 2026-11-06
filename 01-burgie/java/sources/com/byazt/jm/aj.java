package com.byazt.jm;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.gu;
import com.byazt.hg.of;
import com.byazt.sd.EmptyView;
import com.byazt.sd.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 61})
public class aj {
    public Handler aj = new Handler(Looper.getMainLooper());
    public com.byazt.az.pr c;
    public SoftReference<com.byazt.jm.pr> fw;
    public FrameLayout hn;
    public of hw;
    public Context pr;
    public com.byazt.nv.hn uc;
    public hn x;
    public SoftReference<com.byazt.rkl.hn> zo;

    public interface pr {
        Context getActivity();

        void hw();

        void pr();

        void pr(long j);
    }

    public void pr(Context context, of ofVar) {
        this.pr = context;
        this.hw = ofVar;
        this.hn = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.hn.setLayoutParams(layoutParams);
        gu.hw(this.hw);
    }

    public ViewGroup pr() {
        return this.hn;
    }

    public void pr(String str, int i, com.byazt.jm.pr prVar, com.byazt.rkl.hn hnVar) {
        this.fw = new SoftReference<>(prVar);
        if (hnVar != null) {
            this.zo = new SoftReference<>(hnVar);
        }
        HashMap map = new HashMap();
        map.put("splash_show_type", Integer.valueOf(i));
        com.byazt.az.pr prVar2 = new com.byazt.az.pr(this.pr, this.hw, str, 4);
        ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).pr(this);
        ((com.byazt.yx.pr) prVar2.pr(com.byazt.yx.pr.class)).pr(map);
        SoftReference<com.byazt.rkl.hn> softReference = this.zo;
        if (softReference == null) {
            pr(str, this.hn, null);
        } else {
            pr(str, this.hn, softReference.get());
        }
        ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).pr(this.uc);
        com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.jm.aj.1
            @Override // com.byazt.dl.pr.InterfaceC0041pr
            public void pr(View view, int i2) {
                if (aj.this.fw != null && aj.this.fw.get() != null) {
                    ((com.byazt.jm.pr) aj.this.fw.get()).hw();
                }
                aj.this.hn();
            }
        };
        ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr);
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.hw(ofVar.le(), interfaceC0041pr, com.byazt.dl.pr.InterfaceC0041pr.class);
        }
        this.c = prVar2;
        hn hnVar2 = this.x;
        if (hnVar2 != null) {
            hnVar2.pr(prVar2);
        }
    }

    private com.byazt.nv.hn pr(of ofVar, String str) {
        if (ofVar.aj() == 4) {
            return com.byazt.jx.zo.pr(this.pr, ofVar, str);
        }
        return null;
    }

    private void pr(String str, final ViewGroup viewGroup, com.byazt.rkl.hn hnVar) {
        of ofVar = this.hw;
        if (ofVar == null || this.pr == null || viewGroup == null) {
            return;
        }
        this.uc = pr(ofVar, str);
        EmptyView emptyView = new EmptyView(this.pr, viewGroup, this.hw.ov());
        emptyView.pr(this.hw, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (hnVar != null) {
            pr(hnVar);
        }
        emptyView.setCallback(new EmptyView.pr() { // from class: com.byazt.jm.aj.2
            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z) {
                if (aj.this.uc != null && z) {
                    aj.this.uc.hw();
                }
                aj.this.pr(z);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                ViewGroup viewGroup2;
                if (aj.this.uc != null) {
                    aj.this.uc.pr();
                }
                if (aj.this.uc == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                Context context = null;
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception e) {
                }
                if (context != null && (context instanceof Activity)) {
                    aj.this.uc.pr((Activity) context, false);
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                if (aj.this.uc != null) {
                    aj.this.uc.hn();
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(View view, Map<String, Object> map) {
            }
        });
    }

    private void pr(final com.byazt.rkl.hn hnVar) {
        com.byazt.nv.hn hnVar2 = this.uc;
        if (hnVar2 == null) {
            return;
        }
        hnVar2.pr(new com.byazt.nv.pr() { // from class: com.byazt.jm.aj.3
            @Override // com.byazt.nv.pr
            public void pr() {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.pr();
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, long j2, String str, String str2) {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.pr(j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hw(long j, long j2, String str, String str2) {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.hw(j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hn(long j, long j2, String str, String str2) {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.hn(j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, String str, String str2) {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.pr(j, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(String str, String str2) {
                com.byazt.rkl.hn hnVar3 = hnVar;
                if (hnVar3 != null) {
                    hnVar3.pr(str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        this.aj.postDelayed(new Runnable() { // from class: com.byazt.jm.aj.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.wr.uc.pr) {
                    com.byazt.wr.uc.pr = false;
                    if (aj.this.uc instanceof com.byazt.ri.pr) {
                        ((com.byazt.ri.pr) aj.this.uc).fw().pr(new com.byazt.rx.pr() { // from class: com.byazt.jm.aj.4.1
                            @Override // com.byazt.rx.pr
                            public void pr() {
                            }

                            @Override // com.byazt.rx.pr
                            public void hw() {
                            }

                            @Override // com.byazt.rx.pr
                            public void hn() {
                                aj.this.hw();
                            }
                        });
                        return;
                    }
                    return;
                }
                aj.this.hw();
            }
        }, 100L);
    }

    public void pr(int i) {
        switch (i) {
            case 2:
                if (gu.pr(this.hw)) {
                    this.x = new x();
                }
                break;
        }
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr(this.pr, this.hn, this.hw);
            this.x.pr(this.c);
        }
    }

    public void pr(com.byazt.gz.x xVar, pr prVar) {
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr(xVar, prVar);
        }
    }

    public void hw() {
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.hw();
        }
    }

    public void pr(boolean z) {
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr(z);
        }
    }
}
