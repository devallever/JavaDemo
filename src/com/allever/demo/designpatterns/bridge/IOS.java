package com.allever.demo.designpatterns.bridge;

/**
 * @author allever
 */
public class IOS extends AbstractBaseMobileSystem {
    public IOS() {}
    public IOS (AbstractSoft soft) {
        mSoftList.add(soft);
    }

    @Override
    protected void run() {
        System.out.println("IOS系统：");
        super.run();
    }

    @Override
    void run(AbstractSoft soft) {
        soft.run();
    }
}
