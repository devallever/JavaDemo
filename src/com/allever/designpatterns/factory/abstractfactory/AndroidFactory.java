package com.allever.designpatterns.factory.abstractfactory;

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
