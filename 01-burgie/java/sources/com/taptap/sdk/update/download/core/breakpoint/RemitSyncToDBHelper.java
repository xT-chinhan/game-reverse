package com.taptap.sdk.update.download.core.breakpoint;

/* JADX INFO: loaded from: classes3.dex */
class RemitSyncToDBHelper {
    long delayMillis;
    private final RemitSyncExecutor executor;

    RemitSyncToDBHelper(RemitSyncExecutor.RemitAgent agent) {
        this(new RemitSyncExecutor(agent));
    }

    RemitSyncToDBHelper(RemitSyncExecutor executor) {
        this.executor = executor;
        this.delayMillis = 1500L;
    }

    void shutdown() {
        this.executor.shutdown();
    }

    boolean isNotFreeToDatabase(int id) {
        return !this.executor.isFreeToDatabase(id);
    }

    void onTaskStart(int id) {
        this.executor.removePostWithId(id);
        this.executor.postSyncInfoDelay(id, this.delayMillis);
    }

    void endAndEnsureToDB(int id) {
        this.executor.removePostWithId(id);
        try {
            if (this.executor.isFreeToDatabase(id)) {
                return;
            }
            this.executor.postSync(id);
        } finally {
            this.executor.postRemoveFreeId(id);
        }
    }

    void discard(int id) {
        this.executor.removePostWithId(id);
        this.executor.postRemoveInfo(id);
    }
}
