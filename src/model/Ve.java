package model;

import ManagerChoose.ChonVe;

import java.util.Scanner;

public class Ve {
    private String maVe;
    private String tenVe;
    private int soTE, soNL;
    private int veTE, veNL;

    public Ve() {

    }

    public Ve(String maVe, String tenVe, int soTE, int soNL, int veTE, int veNL) {
        this.maVe = maVe;
        this.tenVe = tenVe;
        this.soTE = soTE;
        this.soNL = soNL;
        this.veTE = veTE;
        this.veNL = veNL;
    }

    public String getMaVe() {
        return maVe;
    }

    public boolean setMaVe(String maVe) {
        if (maVe != null && maVe.length() == 5) {
            this.maVe = maVe;
            return true;
        } else {
            System.err.println("||Vui lòng nhập mã vé chứa đủ 5 kí tự !");
            return false;
        }
    }

    public String getTenVe() {
        return tenVe;
    }

    public int getSoTE() {
        return soTE;
    }

    public int getSoNL() {
        return soNL;
    }

    public int getVeTE() {
        return veTE;
    }

    public void setVeTE(int veTE) {
        this.veTE = veTE;
    }

    public int getVeNL() {
        return veNL;
    }

    public void inputTE(ChonVe cVe) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập tên vé: ");
        while (true) {
            tenVe = scanner.nextLine();
            if (cVe.checkVe(tenVe)) {
                break;
            } else {
                cVe.danhSachVe();
                System.err.println("||Nhập lại tên Vé");
            }
        }
        NhapTE();
    }

    public void NhapTE() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập mã vé: ");
        while (true){  //        while (!setMaVe(scanner.nextLine())) ;
            String mavte = scanner.nextLine();
            boolean check = setMaVe(mavte);
            if (check) break;
        }

        do {
            System.out.print("|| Số trẻ em: ");
            soTE = Integer.parseInt(scanner.nextLine());
        } while (soTE < 0);

        do {
            System.out.print("|| Giá vé Trẻ em: ");
            veTE = Integer.parseInt(scanner.nextLine());
        } while (veTE <= 0);
        System.out.println("||_________________________________||");
    }

    public void inputNL(ChonVe cVe) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập tên vé: ");
        while (true) {
            tenVe = scanner.nextLine();
            if (cVe.checkVe(tenVe)) {
                break;
            } else {
                cVe.danhSachVe();
                System.err.println("Nhập lại tên Vé");
            }
        }
        NhapNL();
    }

    public void NhapNL() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập mã vé: ");
//        while (!setMaVe(scanner.nextLine())) ;
        while (true){
            String ma = scanner.nextLine();
            boolean check = setMaVe(ma);
            if (check) break;
        }

        do {
            System.out.print("|| Số người lớn: ");
            soNL = Integer.parseInt(scanner.nextLine());
        } while (soNL < 0);

        do {
            System.out.print("|| Giá vé người lớn: ");
            veNL = Integer.parseInt(scanner.nextLine());
        } while (veNL <= 0);
        System.out.println("||_____________________________||");
    }

    //Hiển thị
    public void display() {
        System.out.printf("\n\t| %-7s| %-20s| %-12s| %-12s| %-12s| %-12s| %-13s|", this.maVe, this.tenVe, this.soTE,
                this.soNL, this.veTE, this.veNL, this.tienAll());
    }

    public void displayTE() {
        System.out.printf("\n\t| %-6s| %-15s| %-12s| %-12s| %-12s|", this.maVe, this.tenVe, this.soTE, this.veTE,
                this.tienTE());
    }

    public void displayNL() {
        System.out.printf("\n\t| %-6s| %-15s| %-12s| %-12s| %-12s|", this.maVe, this.tenVe, this.soNL, this.veNL,
                this.tienNL());
    }

    @Override
    public String toString() {
        return this.maVe + "#" + this.tenVe + "#" + this.soTE + "#" + this.soNL + "#" + this.veTE + "#" + this.veNL +
                "#" + this.tienTE() + "#" + this.tienNL() + "#" + this.tienAll() + "\n";
    }

    public long tienTE() {
        return getSoTE() * getVeTE();
    }

    public long tienNL() {
        return getSoNL() * getVeNL();
    }

    public long tienAll() {
        return tienNL() + tienTE();
    }
}