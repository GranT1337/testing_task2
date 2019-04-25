package com.ostanin.parsingandvalidate;

public class ParsToNormalView {

    public String parsingToNormalView(String string) {

        string = string.replace(" ", "")
                        .replace("(-","(0-")
                        .replace(",",".")
                        .replace("(+","(0+");

        if (string.charAt(0) == '-') {
            string = "0" + string;
        }
        return string;
    }
}
