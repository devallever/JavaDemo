package com.allever.demo;

public class BarCode {
    public static void main(String[] args) {
        BarCode barCode = new BarCode();
        barCode.parseCode("XT0-09235660");
        barCode.parseCode("XT0-10958855");
        barCode.parseCode("XT0-1072301");
        barCode.parseCode("XT01271931");
        barCode.parseCode("XT0-");
        barCode.parseCode("XT0-");


    }

    private String parseCode(String scanCode) {
        if (scanCode == null) {
            return "";
        }
        if ("".equals(scanCode)) {
            return scanCode;
        }
        String result = scanCode;

        int scanCodeLength = scanCode.length();
        System.out.print(scanCodeLength + "位长度条码: ");
        switch (scanCodeLength) {
            case 12:
                //去掉XT0-和最后一位校验位
                if (scanCode.contains("-")) {
                    int startIndex = scanCode.indexOf("-") + 1;
                    result = scanCode.substring(startIndex, scanCodeLength - 1);
                }
                break;
            case 11:
                //去掉XT0-
                if (scanCode.contains("-")) {
                    int startIndex = scanCode.indexOf("-") + 1;
                    result = scanCode.substring(startIndex);
                }
                break;
            case 10:
                //不用去XT0
                break;
            case 9:
                //去掉最后一位校验位
                result = scanCode.substring(0, scanCodeLength - 1);
                break;
            default:
                break;

        }

        System.out.println(scanCode + " -> " +  result);
        return result;
    }
}
