package com.taptap.sdk.update.download.core.listener;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.listener.assist.Listener4Assist;
import com.taptap.sdk.update.download.core.listener.assist.Listener4SpeedAssistExtend;
import com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadListener4WithSpeed extends DownloadListener4 implements Listener4SpeedAssistExtend.Listener4SpeedCallback {
    private DownloadListener4WithSpeed(Listener4SpeedAssistExtend assistExtend) {
        super(new Listener4Assist(new Listener4WithSpeedModelCreator()));
        assistExtend.setCallback(this);
        setAssistExtend(assistExtend);
    }

    public DownloadListener4WithSpeed() {
        this(new Listener4SpeedAssistExtend());
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Callback
    public final void infoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint, Listener4Assist.Listener4Model model) {
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Callback
    public final void progressBlock(DownloadTask task, int blockIndex, long currentBlockOffset) {
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Callback
    public final void progress(DownloadTask task, long currentOffset) {
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Callback
    public final void blockEnd(DownloadTask task, int blockIndex, BlockInfo info) {
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Callback
    public final void taskEnd(DownloadTask task, EndCause cause, Exception realCause, Listener4Assist.Listener4Model model) {
    }

    private static class Listener4WithSpeedModelCreator implements ListenerModelHandler.ModelCreator<Listener4SpeedAssistExtend.Listener4SpeedModel> {
        private Listener4WithSpeedModelCreator() {
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ModelCreator
        public Listener4SpeedAssistExtend.Listener4SpeedModel create(int id) {
            return new Listener4SpeedAssistExtend.Listener4SpeedModel(id);
        }
    }
}
