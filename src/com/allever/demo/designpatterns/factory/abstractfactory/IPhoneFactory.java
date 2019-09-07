package com.allever.demo.designpatterns.factory.abstractfactory;

public class IPhoneFactory extends SoftFactory {

    @Override
    SMS createSMS() {
        return new IPhoneSMS();
    }

    @Override
    Email createEmail() {
        return new IPhoneEmail();
    }
}
