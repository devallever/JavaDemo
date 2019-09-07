package com.allever.demo.designpatterns.bridge;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractBaseMobileSystem {
    protected List<AbstractSoft> mSoftList = new ArrayList<>();
    protected void setupSoft(AbstractSoft soft) {
        mSoftList.add(soft);
    }

    protected void run() {
        for (AbstractSoft soft: mSoftList) {
            soft.run();
        }
    }
    abstract void run(AbstractSoft soft);
}
