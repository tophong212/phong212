package model;

import ManagerChoose.ChonKhu;
import java.util.Scanner;

public class KhuVuiChoi{
    private String maKhu;
    private String tenKhu;
    private String viTri;
    private String dienTich;
    private String gioMo;
    private String gioDong;


    public String getMaKhu() {
        return maKhu;
    }

    public boolean setMaKhu(String maKhu) {
        if (maKhu != null && maKhu.length() == 5) {
            this.maKhu = maKhu;
            return true;
        } else {
            System.err.println("||Vui lòng nhập mã khu có độ dài 5 kí tự: ");
            return false;
        }
    }

    public String getTenKhu() {
        return tenKhu;
    }

    public boolean setGioMo(String gioMo) {
        if (gioMo != null) {
            this.gioMo = gioMo;
            return true;
        } else {
            System.err.println("||Vui lòng nhập giờ đóng cửa !");
            return false;
        }
    }

    public boolean setGioDong(String gioDong) {
        if (gioDong != null) {
            this.gioDong = gioDong;
            return true;
        } else {
            System.err.println("||Vui lòng nhập giờ mở cửa !");
            return false;
        }
    }

    public KhuVuiChoi() {
    }

    public KhuVuiChoi(String maKhu, String tenKhu, String viTri, String dienTich, String gioMo, String gioDong) {
        this.maKhu = maKhu;
        this.tenKhu = tenKhu;
        this.viTri = viTri;
        this.dienTich = dienTich;
        this.gioMo = gioMo;
        this.gioDong = gioDong;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập mã khu: ");
//        while (!setMaKhu(scanner.nextLine())) ;
        while (true){
            String ma = scanner.nextLine();
            boolean check = setMaKhu(ma);
            if (check) break;
        }

        do {
            System.out.print("|| Nhập Vị trí: ");
            viTri = scanner.nextLine();
        } while ("".equals(viTri));

        do {
            System.out.print("|| Nhập Diện tích: ");
            dienTich = scanner.nextLine();
        } while ("".equals(dienTich));

        System.out.print("|| Nhập giờ mở cửa: ");
        while (true) {
            String hmo = scanner.nextLine();
            boolean check = setGioMo(hmo);
            if (check) {
                break;
            } else {
                System.err.println("||Vui lòng nhập giờ mở cửa!");
            }
        }

        System.out.print("|| Nhập giờ đóng cửa: ");
        while (true) {
            String hdong = scanner.nextLine();
            boolean check = setGioDong(hdong);
            if (check) {
                break;
            } else {
                System.err.println("||Vui lòng nhập giờ đóng cửa!");
            }
        }
        System.out.println("||______________________________________________||");
    }

    public void input(ChonKhu chonKhu) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("|| Nhập Tên khu: ");
        while (true) {
            tenKhu = scanner.nextLine();
            if (chonKhu.checkKhu(tenKhu)) {
                break;
            } else {
                chonKhu.danhSachKhu();
                System.err.print("||Nhập lại tên khu: ");
            }
        }
        input();
    }

    public void display() {
        System.out.printf("\n\t| %-7s| %-25s| %-15s| %-10s| %-11s| %-11s|", this.maKhu, this.tenKhu, this.viTri,
                this.dienTich, this.gioMo, this.gioDong);
    }

    @Override
    public String toString() {
        return this.maKhu + "#" + this.tenKhu + "#" + this.viTri + "#" + this.dienTich + "#" + this.gioMo +
                "#" + this.gioDong +"\n";
    }
}