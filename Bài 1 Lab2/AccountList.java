/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abcbank;

/**
 *
 * @author ADMIN
 */


public class AccountList {
	private Account [] ds;
	private int soLuongHienTai;
	
	public AccountList(int soLuong) {
		soLuongHienTai = 0;
		if(soLuong > 0) {
			ds = new Account[soLuong];
		}
		else {
			System.out.println("Số lượng tài khoản phải lớn hơn 0 !");
			ds = new Account[5];
		}
	}
	
	public Account[] getDS() {
		return ds;
	}
	
	//Phương thức trả về tổng số lượng tài khoản hiện có
	public int getSoLuongHienTai() {
		return soLuongHienTai;
	}
	
	//Phương thức tăng kích thước danh sách
	public void tangKichThuoc() {
		Account[] temp = new Account[ds.length*2];
		for(int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}
	
	//Phương thức tìm kiếm VỊ TRÍ của 1 tài khoản trong danh sách
	public int timKiem(long stk) {
		for(int i = 0; i < soLuongHienTai; i++) {
			if(ds[i].getStk() == stk) {
				return i;
			}
		}
		return -1;
	}
	
	//Phương thức thêm 1 tài khoản vào danh sách
	public void them(Account a) {
		if(soLuongHienTai == ds.length) {
			tangKichThuoc();
		}
		if(timKiem(a.getStk()) == -1) {
			ds[soLuongHienTai] = a;
			soLuongHienTai++;
			return;
		}
		else {
			System.out.println("Số tài khoản này đã tồn tại trong danh sách !");
		}
	}
	
	//Phương thức xóa 1 tài khoản
	public void xoa(Account a) {
		int pos = timKiem(a.getStk());
		for(int i = pos; i < soLuongHienTai-1; i++) {
			ds[i] = ds[i+1];
		}
		soLuongHienTai--;
	}
	
	
	
}