package com.allever.demo.designpatterns.factory.abstractfactory;

public abstract class SoftFactory {
    abstract SMS createSMS();
    abstract Email createEmail();
}
