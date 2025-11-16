package com.github.affandes.kuliah.pm;


import java.util.Stack;
import java.util.Scanner;

public class Main {

    static Stack<String> browserHistory = new Stack<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        browserHistory.push("Google.com");
        System.out.println("Selamat datang di Browser Sederhana!");

        while (true) {
            System.out.println("\nSekarang berada di: ==" + browserHistory.peek() + "==");

            System.out.println("\nPilih aksi:");
            System.out.println("1. Browse (Kunjungi website baru)");
            System.out.println("2. Back (Kembali)");
            System.out.println("3. View (Lihat history)");
            System.out.println("4. Keluar");

            System.out.print("Masukkan pilihan Anda (1/2/3/4): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    browse();
                    break;
                case "2":
                    back();
                    break;
                case "3":
                    viewHistory();
                    break;
                case "4":
                    System.out.println("Menutup browser... Sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
    }

    public static void browse() {
        System.out.print("Masukkan URL website baru: ");
        String urlBaru = scanner.nextLine();

        browserHistory.push(urlBaru);
        System.out.println("Berhasil 'browse' ke: " + urlBaru);
    }


    public static void back() {
        if (browserHistory.size() > 1) {
            String halamanYangDihapus = browserHistory.pop();
            System.out.println("Kembali dari '" + halamanYangDihapus + "'...");
        } else {
            System.out.println("Tidak bisa 'back', Anda sudah berada di halaman utama.");
        }
    }

    public static void viewHistory() {
        System.out.println("\n--- History Browser (dari terbaru) ---");

        for (int i = browserHistory.size() - 1; i >= 0; i--) {
            System.out.println("- " + browserHistory.get(i));
        }

        System.out.println("--------------------------------------");
    }
}