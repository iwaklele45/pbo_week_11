public class Component {
    protected String nama;
    protected int harga;

    public Component(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void showInfo() {
        System.out.println(nama + " - Rp" + harga);
    }

    public int getHarga() {
        return harga;
    }
}

