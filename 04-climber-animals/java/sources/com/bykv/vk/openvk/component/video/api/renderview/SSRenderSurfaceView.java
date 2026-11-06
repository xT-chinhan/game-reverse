package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, xr {
    private static final ArrayList<ah> ah = new ArrayList<>();
    private xr.ms d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<ms> f24ms;
    private ah xr;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public View getView() {
        return this;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(ms msVar) {
        this.f24ms = new WeakReference<>(msVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<ah> it = ah.iterator();
        while (it.hasNext()) {
            ah next = it.next();
            if (next != null && next.ms() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.xr);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xr
    public void ms(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<ms> weakReference = this.f24ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f24ms.get().ms(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<ms> weakReference = this.f24ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f24ms.get().ms(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<ms> weakReference = this.f24ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f24ms.get().xr(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(xr.ms msVar) {
        this.d = msVar;
    }
}
