/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abcbank;

/**
 *
 * @author ADMIN
 */

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountList ds = null;
		int n, chon;
		System.out.println("\n----oOo-- CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG --oOo----\n");
		System.out.println("Nhập số lượng tài khoản để khởi tạo danh sách :");
		n = sc.nextInt();
		ds = new AccountList(n);
		System.out.println("Danh sách đã được khởi tạo !\n");
		
		do {
			menu();
			System.out.println("-Lựa chọn : ");
			chon = sc.nextInt();
			
			switch(chon) {
				case 1 :
					nhapCung(ds);
					break;
				case 2 :
					nhapMem(ds);
					break;
				case 3 :
					System.out.println("Tổng số tài khoản hiện có : "+ds.getSoLuongHienTai());
					break;
				case 4 :
					xuat(ds);
					break;
				case 5 :
					napTien(ds);
					break;
				case 6 :
					rutTien(ds);
					break;
				case 7 :
					chuyenTien(ds);
					break;
				case 8 :
					timKiem(ds);
					break;
				case 9 :
					System.out.println("Cảm ơn đã sử dụng chương trình <33.");
					break;
			}
		}while(chon != 9);
	}
	static void menu() {
		System.out.println("=====================================");
		System.out.println("1/ Nhập cứng.");
		System.out.println("2/ Thêm.");
		System.out.println("3/ Số lượng TK hiện có.");
		System.out.println("4/ Xuất thông tin tất cả tài khoản.");
		System.out.println("5/ Nạp tiền.");
		System.out.println("6/ Rút tiền.");
		System.out.println("7/ Chuyển tiền.");
		System.out.println("8/ Tìm 1 tài khoản.");
		System.out.println("9/ Kết thúc.");
		System.out.println("=====================================");
	}
	
	static void nhapCung(AccountList ds) {
		Account temp = null;
		temp = new Account(111, "Nguyễn Văn A", 70000);
		ds.them(temp);
		temp = new Account(222, "Trần Minh B", 100000);
		ds.them(temp);
		temp = new Account(333, "Võ Đức C", 65000);
		ds.them(temp);
	}
	
	static void nhapMem(AccountList ds) {
		Scanner sc = new Scanner(System.in);
		long stk; String ten; double tien;
		System.out.println("Nhập số tài khoản :");
		stk = sc.nextLong(); sc.nextLine();
		System.out.println("Nhập tên tài khoản :");
		ten = sc.nextLine();
		System.out.println("Nhập số dư :");
		tien = sc.nextDouble();
		Account temp = new Account(stk, ten, tien);
		ds.them(temp);
	}
	
	static void xuat(AccountList ds) {
		for(int i = 0; i < ds.getSoLuongHienTai(); i++) {
			System.out.println(ds.getDS()[i]);
		}
	}
	
	static void napTien(AccountList ds) {
		Scanner sc = new Scanner(System.in);
		long stk; double amount;
		System.out.println("Nhập số tài khoản cần nạp tiền : ");
		stk = sc.nextLong();
		int pos = ds.timKiem(stk);
		if(pos == -1) {
			System.out.println("Số tài khoản không tồn tại trong danh sách !");
		}
		else {
			System.out.println("Nhập số tiền cần nạp : ");
			amount = sc.nextDouble();
			if(ds.getDS()[pos].napTien(amount)) {
				System.out.println("Nạp tiền thành công !");
			}
			else {
				System.out.println("Nạp tiền thất bại !");
			}
		}
	}
	
	static void rutTien(AccountList ds) {
		Scanner sc = new Scanner(System.in);
		long stk; double amount;
		System.out.println("Nhập số tài khoản cần rút tiền : ");
		stk = sc.nextLong();
		int pos = ds.timKiem(stk);
		if(pos == -1) {
			System.out.println("Số tài khoản không tồn tại trong danh sách !");
		}
		else {
			System.out.println("Nhập số tiền cần rút : ");
			amount = sc.nextDouble();
			if(ds.getDS()[pos].rutTien(amount)) {
				System.out.println("Rút tiền thành công !");
			}
			else {
				System.out.println("Rút tiền thất bại !");
			}
		}
	}
	
	static void chuyenTien(AccountList ds) {
		Scanner sc = new Scanner(System.in);
		long stk; double amount; int pos1, pos2;
		System.out.println("Nhập số tài khoản chuyển tiền : ");
		stk = sc.nextLong();
		pos1 = ds.timKiem(stk);
		if(pos1 == -1) {
			System.out.println("Số tài khoản không tồn tại trong danh sách !");
		}
		else {
			System.out.println("Nhập số tài khoản nhận tiền : ");
			stk = sc.nextLong();
			pos2 = ds.timKiem(stk);
			if(pos2 == -1) {
				System.out.println("Số tài khoản không tồn tại trong danh sách !");
				return;
			}
			System.out.println("Nhập số tiền cần chuyển : ");
			amount = sc.nextDouble();
			if(ds.getDS()[pos1].chuyenTien(ds.getDS()[pos2], amount)) {
				System.out.println("Chuyển tiền thành công !");
			}
			else {
				System.out.println("Chuyển tiền thất bại !");
			}
		}
	}
	
	static void timKiem(AccountList ds) {
		Scanner sc = new Scanner(System.in);
		long stk;
		System.out.println("Nhập số tài khoản cần tìm : ");
		stk = sc.nextLong(); int pos;
		pos = ds.timKiem(stk);
		if(pos == -1) {
			System.out.println("Không tìm thấy số tài khoản vừa nhập trong danh sách !");
		}
		else {
			System.out.println("Tìm thấy tài khoản ở vị trí "+(pos+1)+" trong danh sách !");
		}
	}
}
