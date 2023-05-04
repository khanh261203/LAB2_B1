/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abcbank;

/**
 *
 * @author ADMIN
 */
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private long stk;
	private String ten;
	private double soDu;
	private final double laiSuat = 0.035;
	
	public Account() {
		stk = 999999;
		ten = "Chưa xác định";
		soDu = 50;
	}

	public Account(long stk, String ten, double soDu) {
		setStk(stk);
		setTen(ten);
		setSoDu(soDu);
	}

	public Account(long stk, String ten) {
		setStk(stk);
		setTen(ten);
	}

	public long getStk() {
		return stk;
	}

	public void setStk(long stk) {
		if(stk > 0) {
			this.stk = stk;
		}
		else {
			this.stk = 999999;
		}
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		if(!ten.equals("")) {
			this.ten = ten;
		}
		else {
			this.ten = "Chưa xác định";
		}
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		if(soDu >= 50000) {
			this.soDu = soDu;
		}
		else {
			this.soDu = 50000;
		}
	}

	public double getLaiSuat() {
		return laiSuat;
	}
	
	public boolean napTien(double soTienNap) {
		if(soTienNap > 0) {
			setSoDu( getSoDu() + soTienNap );
			return true;
		}
		return false;
	}
	
	public boolean rutTien(double soTienRut) {
		if( (soTienRut + 50000 + laiSuat) <= getSoDu() ) {
			setSoDu( getSoDu() - (soTienRut + laiSuat) );
			return true;
		}
		return false;
	}
	
	public boolean chuyenTien(Account a, double soTienChuyen) {
		if( (soTienChuyen + 50000 + laiSuat) <= getSoDu() ) {
			setSoDu( getSoDu()-(laiSuat + soTienChuyen) ); 
			a.napTien(soTienChuyen);
			return true;
		}
		return false;
	}

	public void themLaiSuat() {
		double tienThemLaiSuat;
		tienThemLaiSuat = getSoDu() + getLaiSuat()*laiSuat;
		setSoDu(tienThemLaiSuat);
	}

	@Override
	public String toString() {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
		String strBalance = numberFormat.format(getSoDu());
		return String.format("|%-25s |%16s|%16s|", ten, stk, strBalance);
	}
}

