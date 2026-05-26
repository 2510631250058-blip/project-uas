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