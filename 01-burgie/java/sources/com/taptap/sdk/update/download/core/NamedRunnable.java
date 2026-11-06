package com.taptap.sdk.update.download.core;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    protected abstract void execute() throws InterruptedException;

    protected abstract void finished();

    protected abstract void interrupted(InterruptedException interruptedException);

    public NamedRunnable(String name) {
        this.name = name;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String oldName = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            try {
                execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                interrupted(e);
            }
        } finally {
            Thread.currentThread().setName(oldName);
            finished();
        }
    }
}
