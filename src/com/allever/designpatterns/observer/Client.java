package com.allever.designpatterns.observer;

public class Client {
    public static void main(String[] args) {
        Forground forground = new Forground();
        Employee xiaoming = new Employee("xiao ming");
        Employee xiaohong = new Employee("xiao hong");

        forground.regist(xiaoming);
        forground.regist(xiaohong);
        forground.setMessage("领导来了");
        forground.notifyDataSetChanged();


        DevTech devTech = new DevTech();
        Coder devMing = new Coder("XiaoMing");
        Coder devHong = new Coder("XiaoHOng");
        devTech.addObserver(devHong);
        devTech.addObserver(devMing);
        devTech.postMsg("干货来了");
    }
}
