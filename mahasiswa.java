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
        if (ipk >= 3.7) kategori = "A";
        else if (ipk >= 3.0) kategori = "B";
        else kategori = "C";
    }
}
