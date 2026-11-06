package com.tapsdk.tapad.group.ads;

import android.view.View;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.internal.selfrender.ProviderEvent;
import com.tapsdk.tapad.internal.selfrender.ProviderEventSink;

/* JADX INFO: loaded from: classes2.dex */
abstract class NativeProviderEventRelay implements AdapterAdEventSink {
    private volatile ProviderEventSink eventSink;

    private void emit(ProviderEvent providerEvent) {
        ProviderEventSink providerEventSink = this.eventSink;
        if (providerEventSink == null || providerEvent == null || !canRelayProviderEvent()) {
            return;
        }
        providerEventSink.accept(providerEvent);
    }

    private void emitClicked(View view) {
        if (canRelayProviderEvent()) {
            onProviderClicked(view);
            emit(ProviderEvent.clicked(view));
        }
    }

    public final void bindProviderEventSink(ProviderEventSink providerEventSink) {
        this.eventSink = providerEventSink;
    }

    public boolean canRelayProviderEvent() {
        return true;
    }

    public final void clearProviderEventSink() {
        this.eventSink = null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onClick(View view) {
        emitClicked(view);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onClose() {
        emit(ProviderEvent.simple(14));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onCreativeClick(View view) {
        emitClicked(view);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onDownloadComplete(long j, long j2, String str, String str2) {
        emit(ProviderEvent.download(11, 100, j, j2, j2, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onDownloadFailure(long j, long j2, long j3, String str, String str2, int i, String str3) {
        emit(ProviderEvent.downloadFailed(i, j, j2, j3, str, str2, str3));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onDownloadPause(long j, long j2, long j3, String str, String str2) {
        emit(ProviderEvent.download(10, 0, j, j2, j3, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onDownloadProgress(long j, long j2, long j3, String str, String str2) {
        emit(ProviderEvent.download(15, j2 <= 0 ? 0 : (int) Math.min(100L, (Math.max(0L, j3) * 100) / j2), j, j2, j3, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onDownloadStart(long j, String str, String str2) {
        emit(ProviderEvent.download(9, 0, j, 0L, 0L, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onInstalled(long j, String str, String str2) {
        emit(ProviderEvent.download(12, 100, j, j, j, str, str2));
    }

    public void onProviderClicked(View view) {
    }

    public void onProviderShown(View view) {
    }

    public void onProviderViewAcquired(View view) {
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onRenderFailure(View view, int i, String str) {
        emit(ProviderEvent.failed(13, i, str));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onShow(View view) {
        if (canRelayProviderEvent()) {
            onProviderShown(view);
            emit(ProviderEvent.simple(3));
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoComplete(long j) {
        emit(ProviderEvent.simple(8, (int) Math.min(2147483647L, Math.max(0L, j))));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoFailure(int i, String str) {
        emit(ProviderEvent.failed(18, i, str));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoPause() {
        emit(ProviderEvent.simple(6));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoPrepared() {
        emit(ProviderEvent.simple(17));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoResume() {
        emit(ProviderEvent.simple(7));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onVideoStart() {
        emit(ProviderEvent.simple(5));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onViewAcquired(View view) {
        if (canRelayProviderEvent()) {
            onProviderViewAcquired(view);
        }
    }
}
