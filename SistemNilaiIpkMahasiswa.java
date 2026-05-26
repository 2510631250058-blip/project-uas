import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Class untuk menyimpan data mahasiswa
class Mahasiswa {
    String npm;
    String nama;
    double ipk;
    String kategori;
    String status;

    Mahasiswa(String npm, String nama, double ipk) {
        this.npm = npm;
        this.nama = nama;
        this.ipk = ipk;
        this.status = "aktif";

        // Penentuan kategori berdasarkan IPK
        updateKategori();
    }

    // Dipisah menjadi method agar mudah dipanggil ulang saat edit
    void updateKategori() {
        if (this.ipk >= 3.7) this.kategori = "A"; 
        else if (this.ipk >= 3.0) this.kategori = "B";
        else this.kategori = "C";
    }
}

public class  SistemNilaiIPKMahasiswa{

    static ArrayList<Mahasiswa> data = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    // ================= FILE I/O =================

    static void simpanDataKeFile() {
        try {
            FileWriter writer = new FileWriter("DataMahasiswa.txt");
            for (Mahasiswa m : data) {
                // Format: NPM,Nama,IPK,Status
                writer.write(m.npm + "," + m.nama + "," + m.ipk + "," + m.status + "\n");
            }
            writer.close();
            System.out.println("Data berhasil disimpan ke dalam file 'DataMahasiswa.txt'.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    static void loadDataDariFile() {
        try {
            File myObj = new File("DataMahasiswa.txt");
            if (!myObj.exists()) {
                System.out.println("File 'DataMahasiswa.txt' belum ada. Memulai dengan data kosong.");
                return;
            }

            Scanner myReader = new Scanner(myObj);
            data.clear(); // Bersihkan memori sebelum load
            
            while (myReader.hasNextLine()) {
                String baris = myReader.nextLine();
                // Lewati baris kosong jika ada
                if (baris.trim().isEmpty()) continue; 
                
                String[] atribut = baris.split(","); 

                if (atribut.length == 4) {
                    String npm = atribut[0].trim();
                    String nama = atribut[1].trim();
                    double ipk = Double.parseDouble(atribut[2].trim());
                    String status = atribut[3].trim();

                    Mahasiswa m = new Mahasiswa(npm, nama, ipk);
                    m.status = status; 
                    data.add(m);
                }
            }
            myReader.close();
            System.out.println("Data berhasil di-load dari file 'DataMahasiswa.txt'.");
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membaca data: " + e.getMessage());
        }
    }

    // ================= CRUD =================

    static void tambahData() {
        System.out.print("NPM: ");
        String npm = input.nextLine();
        System.out.print("Nama Lengkap: ");
        String nama = input.nextLine();
        System.out.print("IPK: ");
        double ipk = input.nextDouble();
        input.nextLine(); 

        data.add(new Mahasiswa(npm, nama, ipk));
        System.out.println("Data berhasil ditambahkan\n");
    }

    static void tampilData() {
        if (data.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        System.out.println("\n=== DATA MAHASISWA ===");
        System.out.printf("%-12s | %-15s | %-4s | %-8s\n", "NPM", "NAMA", "IPK", "KATEGORI");
        System.out.println("--------------------------------------------------");
        for (Mahasiswa m : data) {
            if (m.status.equals("aktif")) {
                System.out.printf("%-12s | %-15s | %-4.2f | %-8s\n", m.npm, m.nama, m.ipk, m.kategori);
            }
        }
        System.out.println("--------------------------------------------------");
    }

    static void editData() {
        System.out.print("Masukkan NPM: ");
        String npm = input.nextLine();

        for (Mahasiswa m : data) {
            if (m.npm.equals(npm) && m.status.equals("aktif")) {
                System.out.print("Nama Lengkap baru: ");
                m.nama = input.nextLine();
                System.out.print("IPK baru: ");
                m.ipk = input.nextDouble();
                input.nextLine();
                
                m.updateKategori();

                System.out.println("Data berhasil diupdate");
                return;
            }
        }
        System.out.println("Data tidak ditemukan atau sudah dihapus");
    }

    static void hapusData() {
        System.out.print("Masukkan NPM: ");
        String npm = input.nextLine();

        for (Mahasiswa m : data) {
            if (m.npm.equals(npm)) {
                m.status = "nonaktif"; // Soft delete
                System.out.println("Data berhasil dihapus (soft delete)");
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    // ================= SEARCHING =================

    static void cariNama() {
        System.out.print("Masukkan Nama Lengkap: ");
        String nama = input.nextLine();
        boolean ditemukan = false;

        for (Mahasiswa m : data) {
            if (m.nama.equalsIgnoreCase(nama) && m.status.equals("aktif")) {
                System.out.println("Data ditemukan: " + m.npm + " | " + m.nama + " | " + m.ipk + " | " + m.kategori);
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }

    static void binarySearchNPM() {
        if (data.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }

        bubbleSortNPM(false); // Urutkan data secara diam-diam sebelum pencarian biner

        System.out.print("Masukkan NPM: ");
        String cari = input.nextLine();

        int low = 0;
        int high = data.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = data.get(mid).npm.compareTo(cari);

            if (cmp == 0) {
                if (data.get(mid).status.equals("aktif")) {
                    System.out.println("Data ditemukan: " + data.get(mid).nama + " (IPK: " + data.get(mid).ipk + ")");
                } else {
                    System.out.println("Data ditemukan tetapi berstatus nonaktif (sudah dihapus)");
                }
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    static void cariKategori() {
        System.out.print("Masukkan kategori Nilai (A/B/C): ");
        String kategori = input.nextLine();
        boolean ditemukan = false;

        System.out.println("\nMahasiswa dengan Kategori " + kategori.toUpperCase() + ":");
        for (Mahasiswa m : data) {
            if (m.kategori.equalsIgnoreCase(kategori) && m.status.equals("aktif")) {
                System.out.println("- " + m.nama + " (" + m.ipk + ")");
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Tidak ada mahasiswa dalam kategori tersebut.");
        }
    }

    // ================= SORTING =================
    
    static void bubbleSortNPM(boolean showOutput) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).npm.compareTo(data.get(j + 1).npm) > 0) {
                    Mahasiswa temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
        if (showOutput) {
            System.out.println("Data berhasil diurutkan berdasarkan NPM");
            tampilData();
        }
    }

    static void selectionSortNama() {
        for (int i = 0; i < data.size(); i++) {
            int min = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).nama.compareTo(data.get(min).nama) < 0) {
                    min = j;
                }
            }
            Mahasiswa temp = data.get(i);
            data.set(i, data.get(min));
            data.set(min, temp);
        }
        System.out.println("Data berhasil diurutkan berdasarkan nama");
        tampilData();
    }

    static void sortIPK() {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).ipk < data.get(j + 1).ipk) {
                    Mahasiswa temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
        System.out.println("Data berhasil diurutkan berdasarkan IPK tertinggi");
        tampilData();
    }

    // ================= STATISTIK =================

    static void tampilStatistik() {
        if (data.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        int totalAktif = 0, countA = 0, countB = 0, countC = 0;
        double totalIpk = 0, maxIpk = -1.0, minIpk = 5.0;
        String namaMax = "", namaMin = "";

        for (Mahasiswa m : data) {
            if (m.status.equals("aktif")) {
                totalAktif++;
                totalIpk += m.ipk;

                if (m.ipk > maxIpk) {
                    maxIpk = m.ipk;
                    namaMax = m.nama;
                }
                
                if (m.ipk < minIpk) {
                    minIpk = m.ipk;
                    namaMin = m.nama;
                }

                if (m.kategori.equals("A")) countA++;
                else if (m.kategori.equals("B")) countB++;
                else if (m.kategori.equals("C")) countC++;
            }
        }

        if (totalAktif == 0) {
            System.out.println("Tidak ada mahasiswa berstatus aktif.");
            return;
        }

        double rataRata = totalIpk / totalAktif;

        System.out.println("\n=== STATISTIK MAHASISWA ===");
        System.out.println("Total Mahasiswa Aktif : " + totalAktif + " orang");
        System.out.printf("Rata-rata IPK         : %.2f\n", rataRata);
        System.out.println("IPK Tertinggi         : " + maxIpk + " (" + namaMax + ")");
        System.out.println("IPK Terendah          : " + minIpk + " (" + namaMin + ")");
        System.out.println("Distribusi Kategori   :");
        System.out.println(" - Kategori A (>=3.7) : " + countA + " orang");
        System.out.println(" - Kategori B (>=3.0) : " + countB + " orang");
        System.out.println(" - Kategori C (<3.0)  : " + countC + " orang");
        System.out.println("===========================\n");
    }

    // ================= MENU =================

    public static void main(String[] args) {
        System.out.println("Memeriksa data yang tersimpan...");
        loadDataDariFile(); 

        while (true) {
            System.out.println("\n Sistem Nilai IPK Mahasiswa");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data (Soft Delete)");
            System.out.println("5. Cari Nama mahasiswa (Linear Search)");
            System.out.println("6. Cari NPM mahasiswa (Binary Search)");
            System.out.println("7. Cari Kategori Nilai mahasiswa");
            System.out.println("8. Urutkan Data berdasarkan Nama");
            System.out.println("9. Urutkan Data berdasarkan NPM");
            System.out.println("10. Urutkan Data berdasarkan IPK Tertinggi");
            System.out.println("11. Tampilkan Statistik");
            System.out.println("12. Simpan ke File");
            System.out.println("13. Keluar dan Simpan");
            System.out.print("Pilih menu (1-13): ");

            int pilih = input.nextInt();
            input.nextLine(); 

            switch (pilih) {
                case 1 -> tambahData();
                case 2 -> tampilData();
                case 3 -> editData();
                case 4 -> hapusData();
                case 5 -> cariNama();
                case 6 -> binarySearchNPM();
                case 7 -> cariKategori();
                case 8 -> selectionSortNama(); 
                case 9 -> bubbleSortNPM(true); 
                case 10 -> sortIPK();
                case 11 -> tampilStatistik();
                case 12 -> simpanDataKeFile();
                case 13 -> {
                    System.out.println("Menyimpan data sebelum keluar...");
                    simpanDataKeFile();
                    System.out.println("Program selesai. Sampai jumpa!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid! Silakan pilih angka 1-13.");
            } 
        }
    }
}