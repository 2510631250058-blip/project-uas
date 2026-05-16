public class mahasiswa {
    public string npm;
    public string nama;
    public double ipk;
    public string kategori;
    public string status;

    public mahasiswa(string npm, string nama, double ipk, string kategori, string status) {
        this.npm = npm;
        this.nama = nama;
        this.ipk = ipk;
        this.kategori = kategori;
        this.status = "aktif";

        //kategori ipk
        if (ipk >= 3.7) kategori = "A";
        else if (ipk >= 3.0) kategori = "B";
        else kategori = "C";
    }
    
}
