import java.util.Scanner;
public class Tugas2PemesananKafe24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] menu = {
            "Nasi Goreng", "Mie Goreng", "Roti Bakar",
            "Kentang Goreng", "Teh Tarik", "Cappucino",
            "Chocolate Ice"
        };
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};
        System.out.println("========== MENU KAFE KAMPUS ==========");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-20s Rp %,d%n", i + 1, menu[i], harga[i]);
        }
        System.out.print("\nCari nama menu: ");
        String dicari = input.nextLine().trim();
        int indeksCari = cariMenu(menu, dicari);
        if (indeksCari >= 0) {
            System.out.printf("Menu tersedia: %s - Rp %,d%n",
                    menu[indeksCari], harga[indeksCari]);
        } else {
            System.out.println("Maaf, menu \"" + dicari + "\" tidak tersedia.");
        }
        System.out.print("\nBerapa jenis item yang ingin dipesan? ");
        int jumlahPesanan = input.nextInt();
        input.nextLine();
        if (jumlahPesanan <= 0) {
            System.out.println("Jumlah pesanan harus lebih dari 0.");
            input.close();
            return;
        }
        String[] pesanan = new String[jumlahPesanan];
        int[] hargaPesanan = new int[jumlahPesanan];
        int[] jumlahItem = new int[jumlahPesanan];
        int totalBiaya = 0;
        for (int i = 0; i < jumlahPesanan; i++) {
            while (true) {
                System.out.print("\nMasukkan nama menu pesanan ke-" + (i + 1) + ": ");
                String namaPesanan = input.nextLine().trim();
                int indeks = cariMenu(menu, namaPesanan);
                if (indeks >= 0) {
                    pesanan[i] = menu[indeks];
                    hargaPesanan[i] = harga[indeks];
                    System.out.print("Masukkan jumlah " + menu[indeks] + ": ");
                    jumlahItem[i] = input.nextInt();
                    input.nextLine();
                    if (jumlahItem[i] <= 0) {
                        System.out.println("Jumlah harus lebih dari 0. Masukkan ulang pesanan ini.");
                        continue;
                    }
                    totalBiaya += hargaPesanan[i] * jumlahItem[i];
                    break;
                } else {
                    System.out.println("Menu tidak tersedia. Silakan pilih nama dari daftar menu.");
                }
            }
        }
        System.out.println("\n=============== STRUK PESANAN ===============");
        System.out.printf("%-20s %6s %12s %14s%n",
                "Nama Menu", "Jumlah", "Harga", "Subtotal");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < pesanan.length; i++) {
            int subtotal = hargaPesanan[i] * jumlahItem[i];
            System.out.printf("%-20s %6d Rp %8d Rp %10d%n",
                    pesanan[i], jumlahItem[i], hargaPesanan[i], subtotal);
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("TOTAL BIAYA: Rp %,d%n", totalBiaya);
        System.out.println("Terima kasih telah memesan di Kafe Kampus!");
        input.close();
    }
    public static int cariMenu(String[] menu, String key) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }
}
