package com.allever.demo.designpatterns.factory.abstractfactory;

public class AndroidFactory extends SoftFactory {

    @Override
    SMS createSMS() {
        return new AndroidSMS();
    }

    @Override
    Email createEmail() {
        return new AndroidEmail();
    }
}
