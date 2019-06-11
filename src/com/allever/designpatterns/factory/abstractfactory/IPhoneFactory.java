package com.allever.designpatterns.factory.abstractfactory;

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
