package com.ostanin;


import com.ostanin.processes.Result;

public class Main {

    public static void main(String[] args) {
		Result result = new Result();
		String calculated = "5+5+5*5";
		System.out.println("Выражение: " + calculated);
		System.out.println("Результат: " + result.getResult(calculated));
    }
}
