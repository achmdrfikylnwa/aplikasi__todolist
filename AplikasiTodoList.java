import java.util.Scanner;

public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Mempelajari Java Bagian Dasar";
        model[1] = "Membuat Aplikasi TodoList Sederhana";
        showTodoList();
    }

    public static void addTodoList(String todo) {
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo ke." + i);
        }

        showTodoList();
    }

    public static boolean removeTodoList(int number) {
        if (number < 1 || number > model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = number - 1; i < model.length - 1; i++) {
                model[i] = model[i + 1];
            }
            model[model.length - 1] = null;
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        boolean result = removeTodoList(3);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);
    }

    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            String input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        String todo = input("Masukkan todo baru");
        addTodoList(todo);
    }

    public static void viewRemoveTodoList() {
        int number = Integer.parseInt(input("Nomor todo yang akan dihapus"));
        boolean result = removeTodoList(number);
        if (!result) {
            System.out.println("Todo tidak ditemukan atau tidak dapat dihapus.");
        }
    }
}