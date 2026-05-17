public static void main(String[] args) {
    isiData();

    while (true) {
        System.out.println("Sistem Nilai IPK Mahasiswa");
        System.out.println("1. Tambah Data");
        System.out.println("2. Tampilkan Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Cari Nama mahasiswa");
        System.out.println("6. Cari NPM mahasiswa");
        System.out.println("7. Cari Kategori Nilai mahasiswa");
        System.out.println("8. Urutkan Data berdasarkan Nama");
        System.out.println("9. Urutkan Data berdasarkan NPM");
        System.out.println("10. Urutkan Data berdasarkan IPK");
        System.out.println("11. Keluar");
        System.out.println("Pilih menu (1-11):");

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
            case 8 -> bubbleSortNPM();
            case 9 -> selectionSortNama();
            case 10 -> sortIPK();
            case 11 -> {
                System.out.println("Program selesai.");
                return;
            }
            default -> System.out.println("Pilihan tidak valid!");
        }
       
    }
}





    
