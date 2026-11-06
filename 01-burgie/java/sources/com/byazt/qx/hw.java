package com.byazt.qx;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 13})
public abstract class hw extends com.byazt.mr.g {
    public Dialog aj;
    public Integer[] pr;
    public pr zo;

    public abstract of fw();

    @Override // com.byazt.mr.g
    public View pr() {
        return null;
    }

    @Override // com.byazt.mr.g
    public int hw() {
        return 0;
    }

    @Override // com.byazt.mr.g
    public com.byazt.mr.x hn() {
        return null;
    }

    @Override // com.byazt.mr.g
    public void pr(com.byazt.qh.hw hwVar) {
    }

    @Override // com.byazt.mr.g
    public void pr(com.byazt.qh.pr prVar) {
    }

    @Override // com.byazt.mr.g
    public void pr(com.byazt.rkl.hn hnVar) {
    }

    @Override // com.byazt.mr.g
    public int x() {
        return 0;
    }

    @Override // com.byazt.mr.g
    public void c() {
    }

    @Override // com.byazt.mr.g
    public void uc() {
        if (fw() != null) {
            com.byazt.sd.cz.pr(fw().cz());
            com.byazt.sd.cz.pr(fw().le());
        }
    }

    @Override // com.byazt.mr.g
    public void pr(Activity activity, com.byazt.rz.pr prVar) {
    }

    @Override // com.byazt.mr.g
    public void pr(Dialog dialog, Integer[] numArr) {
        this.aj = dialog;
        this.pr = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.qx.hw.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (hw.this.fw() != null) {
                        hw hwVar = hw.this;
                        hwVar.pr(hwVar.fw().ae());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable th) {
        }
        pr(this.aj);
    }

    public void pr(Dialog dialog) {
    }

    @Override // com.byazt.mr.g
    public com.byazt.mr.fw pr(Activity activity) {
        return null;
    }

    @Override // com.byazt.mr.g
    public void pr(int i) {
    }

    @Override // com.byazt.mr.g
    public void pr(com.byazt.qh.hn hnVar) {
    }

    @Override // com.byazt.mr.g
    public void pr(boolean z) {
    }

    public com.byazt.mm.pr k() {
        return null;
    }

    @Override // com.byazt.mr.g
    public Map<String, Object> zo() {
        return null;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d) {
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
    }

    @Override // com.byazt.mr.zo
    public void hw(Double d) {
    }

    public void pr(com.byazt.dw.hw hwVar) {
        Dialog dialog;
        if (hwVar != null && (dialog = this.aj) != null) {
            com.byazt.rc.hw.pr(hwVar, dialog, this.pr);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    protected static class pr implements com.byazt.nv.pr {
        public String hw;
        public WeakReference<com.byazt.nv.pr> pr;

        public pr(com.byazt.nv.pr prVar, String str) {
            this.hw = "";
            this.pr = new WeakReference<>(prVar);
            this.hw = str;
        }

        public void pr(com.byazt.nv.pr prVar) {
            this.pr = new WeakReference<>(prVar);
        }

        @Override // com.byazt.nv.pr
        public void pr() {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().pr();
            }
            com.byazt.dp.pr.pr(this.hw);
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().pr(j, j2, str, str2);
            }
            com.byazt.dp.pr.pr(this.hw, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void hw(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().hw(j, j2, str, str2);
            }
            com.byazt.dp.pr.hw(this.hw, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void hn(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().hn(j, j2, str, str2);
            }
            com.byazt.dp.pr.hn(this.hw, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, String str, String str2) {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().pr(j, str, str2);
            }
            com.byazt.dp.pr.hw(this.hw);
        }

        @Override // com.byazt.nv.pr
        public void pr(String str, String str2) {
            WeakReference<com.byazt.nv.pr> weakReference = this.pr;
            if (weakReference != null && weakReference.get() != null) {
                this.pr.get().pr(str, str2);
            }
            com.byazt.dp.pr.hn(this.hw);
        }
    }

    @Override // com.byazt.mr.zo
    public void pr(com.byazt.rkl.hw hwVar) {
        if (fw() != null) {
            com.byazt.sd.cz.pr(fw().cz(), hwVar, com.byazt.rkl.hw.class);
        }
    }
}
