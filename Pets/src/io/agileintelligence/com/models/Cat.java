package io.agileintelligence.com.models;

public class Cat extends Animal implements Pet {
	

	public Cat(String n, String b, double w){
		
		name = n;
		breed = b;
		weight = w;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		return "Your "+breed+" cat, "+name+", looked at you with affection";
	}

}
