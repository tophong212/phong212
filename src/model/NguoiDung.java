package model;

import java.util.Scanner;

public class NguoiDung {
    private String username;
    private String password;
    private String name;
    private String addread;
    private String phonenumber;
    private String email;

    public NguoiDung() {

    }

    public NguoiDung(String username, String password, String name, String addread, String phonenumber, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.addread = addread;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        String pattern = "[0-9a-zA-Z]{8,30}";
        this.username = username;
        return username.matches(pattern);
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        String set = "[0-9a-zA-Z]{8,30}";
        this.password = password;
        return password.matches(set);
    }

    public boolean setName(String name) {
        if (name != null && name.contains(" ") && name.length() <= 25) {
            this.name = name;
            return true;
        } else {
            System.err.print("\t\t\t||Vui lòng nhập đúng họ và tên !");
            return false;
        }
    }

    public boolean setAddread(String addread) {
        if (addread != null && addread.contains(" ")) {
            this.addread = addread;
            return true;
        } else {
            System.err.print("\t\t\t||Vui lòng nhập đúng địa chỉ(Xã,Huyện hoặc thành phố)");
            return false;
        }
    }


    public boolean setPhonenumber(String phonenumber) {
        String set = "0[0-9]{9}";
        this.phonenumber = phonenumber;
        return phonenumber.matches(set);
    }

    public boolean setEmail(String email) {
        String set = "[A-Za-z]+\\w+@+(.\\w+)+";
        this.email = email;
        return email.matches(set);
    }

    public void Dangky() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t|| Nhập Tài Khoản: ");
        while (true) {
            String username = scanner.nextLine();
            boolean check = setUsername(username);
            if (check) {
                break;
            } else {
                System.err.print("\t\t\t||Tài khoản viết liền không dấu, trên 8 kí tự !");
            }
        }
        Doimk();
        update();
    }

    public void Doimk() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t|| Nhập Mật khẩu: ");
        while (true) {
            String pass = scanner.nextLine();
            boolean check = setPassword(pass);
            if (check) {
                break;
            } else {
                System.err.print("\t\t\t||Mật khẩu viết liền không dấu, trên 8 kí tự !");
            }
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t|| Họ và tên: ");
        while (!(setName(scanner.nextLine()))) ;
        System.out.print("\t\t\t|| Địa chỉ: ");
        while (!(setAddread(scanner.nextLine()))) ;
        System.out.print("\t\t\t|| Số điện thoại: ");
        while (true) {
            String sdt = scanner.nextLine();
            boolean check = setPhonenumber(sdt);
            if (check) {
                break;
            } else {
                System.err.print("\t\t\t||Số điện thoại (có đầu 0 và độ dài 10 số)");
            }
        }
        System.out.print("\t\t\t|| Nhập Email: ");
        while (true) {
            String email = scanner.nextLine();
            boolean check = setEmail(email);
            if (check) {
                break;
            } else {
                System.err.print("\t\t\t||Email viết liền không dấu ( VD: a123@gmail.com )");
            }
        }
    }

    public void display() {
        System.out.printf("\t\t\t||\t%-10s %-25s||\n\t\t\t||\t%-10s %-25s||\n\t\t\t||\t%-10s %-25s||\n\t\t\t" +
                "||\t%-10s %-25s||\n\t\t\t||\t%-10s %-20s||\n" + "\t\t\t||\t%-10s %-25s||\n", "Tài Khoản:",
                this.username, "Mật khẩu: ", this.password, "Họ Tên: ", this.name, "Địa chỉ: ", this.addread,
                "Số điện thoại: ", this.phonenumber, "Email: ", this.email);
    }

    @Override
    public String toString() {
        return this.username + "#" + this.password + "#" + this.name + "#" + this.addread + "#" + this.phonenumber
                + "#" + this.email + "\n";
    }
}
