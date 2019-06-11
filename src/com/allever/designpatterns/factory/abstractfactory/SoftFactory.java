package com.allever.designpatterns.factory.abstractfactory;

public abstract class SoftFactory {
    abstract SMS createSMS();
    abstract Email createEmail();
}
