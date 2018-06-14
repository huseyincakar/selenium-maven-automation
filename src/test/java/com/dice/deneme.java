package com.dice;

import java.util.ArrayList;
import java.util.List;

public class deneme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
List <String> keywords = new ArrayList<>();
		
		
		String[] arr = {
				"User interface (UI) developer",
				"Business intelligence developer",
				"Systems analyst",
				"Data analyst",
				"Data engineer",
				"Reliability engineer",
				"Process engineer",
				"Solutions architect",
				"User experience (UX) designer",
				"Database administrator",
				"Quality assurance (QA) manager",
				"Hardware engineer",
				"Software engineer",
				"Analytics manager",
				"Site reliability engineer",
				"Front end engineer",
				"Product manager",
				"Mobile developer",
				"Software development",
				"Data scientist"};
		
		for (int i = 0; i < arr.length; i++) {
			keywords.add(arr[i]);
	//		System.out.println(keywords.get(i));

		}
		
		System.out.println(keywords + "\n");
		
		keywords.set(1,  "- 375" );

	}

}
