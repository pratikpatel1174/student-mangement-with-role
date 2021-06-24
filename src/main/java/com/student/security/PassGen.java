package com.student.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGen {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		
		System.out.println(bCryptPasswordEncoder.encode("nilesh"));  // USER
 		System.out.println(bCryptPasswordEncoder.encode("mahesh"));   // CREATOR
		System.out.println(bCryptPasswordEncoder.encode("suresh"));  // EDITOR
		System.out.println(bCryptPasswordEncoder.encode("ramesh"));   // CREATOR , EDITOR
		System.out.println(bCryptPasswordEncoder.encode("admin"));     // ADMIN

	}

}
