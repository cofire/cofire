package com.cofire.designPattern.Template;

public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // ģ��
    public final void play() {

        // ��ʼ����Ϸ
        initialize();

        // ��ʼ��Ϸ
        startPlay();

        // ������Ϸ
        endPlay();
    }
}
