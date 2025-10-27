import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner input = new Scanner(System.in);
        PC pc1 = new PC("PC Custom User");

        //bool
        boolean installedMB = false;
        boolean installedCPU = false;
        int installedRams = 0;
        int installedStorage = 0;

        MotherBoard[] motherBoards = {
            new MotherBoard("Asus Z90", 600000),
            new MotherBoard("MSI Pro B550", 550000)
        };

        CPU[] cpus = {
            new CPU("Intel i9", 200000),
            new CPU("AMD Ryzen 7", 250000)
        };

        RAM[] rams = {
            new RAM("Corsair 16GB", 200000),
            new RAM("Kingston 8GB", 150000)
        };

        SSD[] ssds = {
            new SSD("Kingston SSD", 512, 500000),
            new SSD("SSD Samsung EVO", 1024, 800000)
        };

        HDD[] hdds = {
            new HDD("HDD Seagate", 1024, 500000),
            new HDD("HDD WD Blue", 2048, 700000)
        };

        Mouse[] mouses = {
            new Mouse("Mouse Razer", 400000),
            new Mouse("Mouse Logitech", 250000)
        };

        Keyboard[] keyboards = {
            new Keyboard("Keyboard Rexus", 100000),
            new Keyboard("Keyboard Logitech K120", 120000)
        };

        Monitor[] monitors = {
            new Monitor("Monitor Samsung", 100000),
            new Monitor("Monitor LG UltraWide", 300000)
        };

        int choice;
        do {
            System.out.println("\n===== MENU PEMILIHAN KOMPONEN =====");
            System.out.println("1. Pilih Motherboard");
            System.out.println("2. Pilih CPU");
            System.out.println("3. Pilih RAM");
            System.out.println("4. Pilih Storage");
            System.out.println("5. Pilih Peripherals");
            System.out.println("6. Selesai & Tampilkan Total");
            System.out.print("Pilih menu: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    if(installedMB == false) {
                        if (pilihKomponen("Motherboard", motherBoards, pc1, input)) installedMB = true;
                    }
                    break;
                case 2:
                    if (installedCPU == false) {
                        if (pilihKomponen("CPU", cpus, pc1, input) && installedCPU == false) installedCPU = true;
                    }
                    break;
                case 3:
                    if (installedRams < 4) {
                        if (pilihKomponen("RAM", rams, pc1, input)) installedRams++;
                    }
                    break;
                case 4:
                    if(installedStorage == 1) {
                        break;
                    }
                    System.out.println("1. SSD");
                    System.out.println("2. HDD");
                    System.out.print("Pilih jenis storage: ");
                    int storageType = input.nextInt();
                    boolean temp = false;
                    if (storageType == 1)
                        temp = pilihKomponen("SSD", ssds, pc1, input);
                    else
                        temp = pilihKomponen("HDD", hdds, pc1, input);
                    if (temp) {
                        installedStorage++;
                    }
                    break;

                case 5:
                    System.out.println("1. Mouse");
                    System.out.println("2. Keyboard");
                    System.out.println("3. Monitor");
                    System.out.print("Pilih jenis peripheral: ");
                    int peri = input.nextInt();
                    if (peri == 1)
                        pilihKomponen("Mouse", mouses, pc1, input);
                    else if (peri == 2)
                        pilihKomponen("Keyboard", keyboards, pc1, input);
                    else
                        pilihKomponen("Monitor", monitors, pc1, input);
                    break;
                case 6:
                    System.out.println("\n=== PC Anda ===");
                    pc1.showComponents();
                    pc1.getTotalHarga();
                    System.out.println("Terima kasih telah merakit PC!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }                        

        } while (choice != 6);

        input.close();
    }

    private static boolean pilihKomponen(String nama, Component[] list, PC pc, Scanner input) {
        System.out.println("\n-- Pilih " + nama + " --");
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + list[i].nama + " - Rp" + list[i].harga);
        }
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        if (pilihan > 0 && pilihan <= list.length) {
            pc.addComponent(list[pilihan - 1]);
            System.out.println(list[pilihan - 1].nama + " berhasil ditambahkan!");
            pc.getTotalHarga();
            return true;
        } else {
            System.out.println("Pilihan tidak valid!");
            return false;
        }
    }
}

