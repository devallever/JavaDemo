package com.allever.demo.designpatterns.bridge;

/**
 * @author allever
 */
public class Android extends AbstractBaseMobileSystem {
    public Android() {}
    public Android(AbstractSoft soft) {
        mSoftList.add(soft);
    }

    @Override
    protected void run() {
        System.out.println("Android系统：");
        super.run();
    }

    @Override
    void run(AbstractSoft soft) {
        soft.run();
    }
}
