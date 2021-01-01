package model;

import ManagerChoose.ChonTro;

import java.util.Scanner;

public class Trochoi {
    private String maTro, tenTro, dichvu, maKhu;
    private int soLuong, donGia;

    public Trochoi() {

    }

    public Trochoi(String maTro, String tenTro, String dichvu, int soLuong, int donGia, String maKhu) {
        this.maTro = maTro;
        this.tenTro = tenTro;
        this.dichvu = dichvu;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maKhu = maKhu;
    }

    public String getMaTro() {
        return maTro;
    }

    public String getTenTro() {
        return tenTro;
    }


    public boolean setMaTro(String maTro) {
        if (maTro != null && maTro.length() == 5) {
            this.maTro = maTro;
            return true;
        } else {
            System.err.println("||Mã Trò chơi phải chứa 5 kí tự !!!");
            return false;
        }
    }

    public boolean setMaKhu(String maKhu) {
        if (maKhu != null && maKhu.length() == 5) {
            this.maKhu = maKhu;
            return true;
        } else {
            System.err.println("||Vui lòng nhập mã khu chứa đủ 5 kí tự !");
            return false;
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public boolean setDichvu(String dichvu) {
        if (dichvu != null && dichvu.contains(" ") && dichvu.length() <= 25) {
            this.dichvu = dichvu;
            return true;
        } else {
            System.err.println("||Vui lòng nhập tên dịch vụ !");
            return false;
        }
    }

    public int getDonGia() {
        return donGia;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập mã trò chơi: ");
        while (!setMaTro(scanner.nextLine())) ;

        System.out.print("|| Nhập Dịch vụ: ");
        while (!setDichvu(scanner.nextLine())) ;
        do {
            System.out.print("|| Nhập số lượng: ");
            soLuong = Integer.parseInt(scanner.nextLine());
        } while (soLuong < 0);

        do {
            System.out.print("|| Nhập đơn giá: ");
            donGia = Integer.parseInt(scanner.nextLine());
        } while (soLuong < 0);

        System.out.print("|| Nhập mã khu: ");
        while (!setMaKhu(scanner.nextLine())) ;
        System.out.println("||__________________________________________________||");
    }

    public void input(ChonTro chonTro) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập tên trò: ");
        while (true) {
            tenTro = scanner.nextLine();
            if (chonTro.checkTro(tenTro)) {
                break;
            } else {
                chonTro.danhSachTro();
                System.err.print("||Nhập lại tên trò: ");
            }
        }
        input();
    }

    public void display() {
        System.out.printf("\n\t| %-7s| %-20s| %-20s| %-9s| %-9s| %-6s|", this.maTro, this.tenTro, this.dichvu,
                this.soLuong, this.donGia, this.maKhu);
    }

    @Override
    public String toString() {
        return this.maTro + "#" + this.tenTro + "#" + this.dichvu + "#" + this.soLuong + "#" + this.donGia +
                "#" + this.maKhu + "#" + tienDv()+"\n";
    }

    public int tienDv() {
        return getDonGia() * getSoLuong();
    }
}