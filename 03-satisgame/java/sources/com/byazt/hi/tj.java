package com.byazt.hi;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.dn;
import com.byazt.gct.pk;
import com.byazt.mr.EmptyView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public SoftReference<com.byazt.mi.s> fs;
    public com.byazt.ys.n l;
    public Context n;
    public s q;
    public pk qg;
    public Handler rv = new Handler(Looper.getMainLooper());
    public FrameLayout s;
    public ITTInnerDownloadAdapter w;
    public SoftReference<com.byazt.hi.n> x;

    public interface n {
        Context getActivity();

        void n();

        void n(long j);

        void qg();
    }

    public void n(Context context, pk pkVar) {
        this.n = context;
        this.qg = pkVar;
        this.s = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.s.setLayoutParams(layoutParams);
        dn.qg(this.qg);
    }

    public ViewGroup n() {
        return this.s;
    }

    public void n(String str, int i, com.byazt.hi.n nVar, com.byazt.mi.s sVar) {
        this.x = new SoftReference<>(nVar);
        if (sVar != null) {
            this.fs = new SoftReference<>(sVar);
        }
        HashMap map = new HashMap();
        map.put("splash_show_type", Integer.valueOf(i));
        com.byazt.ys.n nVar2 = new com.byazt.ys.n(this.n, this.qg, str, 4);
        ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).n(this);
        ((com.byazt.fq.n) nVar2.n(com.byazt.fq.n.class)).n(map);
        SoftReference<com.byazt.mi.s> softReference = this.fs;
        if (softReference == null) {
            n(str, this.s, null);
        } else {
            n(str, this.s, softReference.get());
        }
        ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).n(this.w);
        com.byazt.zct.n.InterfaceC0409n interfaceC0409n = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.hi.tj.1
            @Override // com.byazt.zct.n.InterfaceC0409n
            public void n(View view, int i2) {
                if (tj.this.x != null && tj.this.x.get() != null) {
                    ((com.byazt.hi.n) tj.this.x.get()).qg();
                }
                tj.this.s();
            }
        };
        ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).n(interfaceC0409n);
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), interfaceC0409n, com.byazt.zct.n.InterfaceC0409n.class);
        }
        this.l = nVar2;
        s sVar2 = this.q;
        if (sVar2 != null) {
            sVar2.n(nVar2);
        }
    }

    private ITTInnerDownloadAdapter n(pk pkVar, String str) {
        if (pkVar.rv() == 4) {
            return com.byazt.iz.fs.n(this.n, pkVar, str);
        }
        return null;
    }

    private void n(String str, final ViewGroup viewGroup, com.byazt.mi.s sVar) {
        pk pkVar = this.qg;
        if (pkVar == null || this.n == null || viewGroup == null) {
            return;
        }
        this.w = n(pkVar, str);
        EmptyView emptyView = new EmptyView(this.n, viewGroup, this.qg.yq());
        emptyView.n(this.qg, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (sVar != null) {
            n(sVar);
        }
        emptyView.setCallback(new EmptyView.n() { // from class: com.byazt.hi.tj.2
            @Override // com.byazt.mr.EmptyView.n
            public void n(View view, Map<String, Object> map) {
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z) {
                if (tj.this.w != null) {
                    if (z) {
                        tj.this.w.onResume();
                    } else {
                        tj.this.w.onPause();
                    }
                }
                tj.this.n(z);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                ViewGroup viewGroup2;
                Context context;
                if (tj.this.w != null) {
                    tj.this.w.init();
                }
                if (tj.this.w == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                tj.this.w.setActivity((Activity) context, false);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                if (tj.this.w != null) {
                    tj.this.w.onDestroy();
                }
            }
        });
    }

    private void n(final com.byazt.mi.s sVar) {
        ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.w;
        if (iTTInnerDownloadAdapter == null) {
            return;
        }
        iTTInnerDownloadAdapter.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.hi.tj.3
            @Override // com.byazt.pmn.AppDownloadListener
            public void onIdle() {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n();
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.qg(j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.s(j, j2, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(j, str, str2);
                }
            }

            @Override // com.byazt.pmn.AppDownloadListener
            public void onInstalled(String str, String str2) {
                com.byazt.mi.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.rv.postDelayed(new Runnable() { // from class: com.byazt.hi.tj.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.byazt.wif.w.n) {
                    com.byazt.wif.w.n = false;
                    if (tj.this.w instanceof com.byazt.oh.n) {
                        ((com.byazt.oh.n) tj.this.w).n().n(new com.byazt.pma.n() { // from class: com.byazt.hi.tj.4.1
                            @Override // com.byazt.pma.n
                            public void n() {
                            }

                            @Override // com.byazt.pma.n
                            public void qg() {
                            }

                            @Override // com.byazt.pma.n
                            public void s() {
                                tj.this.qg();
                            }
                        });
                        return;
                    }
                    return;
                }
                tj.this.qg();
            }
        }, 100L);
    }

    public void n(int i) {
        if (i == 2 && dn.n(this.qg)) {
            this.q = new q();
        }
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(this.n, this.s, this.qg);
            this.q.n(this.l);
        }
    }

    public void n(com.byazt.ia.q qVar, n nVar) {
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(qVar, nVar);
        }
    }

    public void qg() {
        s sVar = this.q;
        if (sVar != null) {
            sVar.qg();
        }
    }

    public void n(boolean z) {
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(z);
        }
    }
}
