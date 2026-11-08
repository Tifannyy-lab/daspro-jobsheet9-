import java.util.Scanner;
public class Tugas1PengelolaanNilai24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlah;
        int total = 0;
        int tertinggi, terendah;
        int rataRata;
        System.out.print("Masukkan banyak mahasiswa: ");
        jumlah = input.nextInt();
        int[] nilai = new int[jumlah];
        for (int i = 0; i < jumlah; i++) {
            do {
                System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + " (0-100): ");
                nilai[i] = input.nextInt();
                if (nilai[i] < 0 || nilai[i] > 100) {
                    System.out.println("Nilai tidak valid! Masukkan nilai 0-100.");
                }
            } while (nilai[i] < 0 || nilai[i] > 100);
            total += nilai[i];
        }
        tertinggi = nilai[0];
        terendah = nilai[0];
        for (int i = 0; i < jumlah; i++) {
            if (nilai[i] > tertinggi) {
                tertinggi = nilai[i];
            }
            if (nilai[i] < terendah) {
                terendah = nilai[i];
            }
        }
        rataRata = (int) total / jumlah;
        System.out.println("\n===== HASIL NILAI MAHASISWA =====");
        System.out.println("Nilai rata-rata : " + rataRata);
        System.out.println("Nilai tertinggi : " + tertinggi);
        System.out.println("Nilai terendah  : " + terendah);
        System.out.println("\nDaftar Nilai Mahasiswa:");
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Mahasiswa ke-" + (i + 1));
            System.out.print(" = " + nilai[i]);

            if (nilai[i] >= 70) {
                System.out.println(" (LULUS)");
            } else {
                System.out.println(" (TIDAK LULUS)");
            }
        }
        input.close();
    }
}
