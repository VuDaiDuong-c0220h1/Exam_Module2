import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<PersonContact> personContactArrayList = new ArrayList<>();
    public static void saveContactInFile(ArrayList<PersonContact> personContactArrayList) {
        try {
            File file = new File("D:\\Codegym\\IntelliJ\\Exam\\src\\listContact.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(PersonContact personContact : personContactArrayList) {
                printWriter.println(personContact.getPhoneNumber() + "," + personContact.getGroup()
                        + "," + personContact.getName()+ "," + personContact.getGender()
                        + "," + personContact.getAddress()+ "," + personContact.getBirthday()
                        + "," + personContact.getEmail());
            }
            printWriter.close();
        }catch(IOException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readContactFromFile(ArrayList<PersonContact> personContactArrayList){
        try {
            File file = new File("D:\\Codegym\\IntelliJ\\Exam\\src\\listContact.txt");
            if (!file.exists()) {
                System.out.println("File không tồn tại");
                return;
            }
            if (!file.canRead()) {
                System.out.println("Không thể đọc file");
                return;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                int phoneNumber = Integer.parseInt(stringTokenizer.nextToken());
                String group = stringTokenizer.nextToken();
                String name = stringTokenizer.nextToken();
                String gender = stringTokenizer.nextToken();
                String address = stringTokenizer.nextToken();
                String birthday = stringTokenizer.nextToken();
                String email = stringTokenizer.nextToken();
                personContactArrayList.add(new PersonContact(phoneNumber, group, name, gender, address, birthday, email));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số để tiếp tục:");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi từ file");
            System.out.println("8. Exit");
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    readContactFromFile(personContactArrayList);
                    break;
                case 7:
                    saveContactInFile(personContactArrayList);
                    break;
                case 8:
                    System.exit(0);
            }


        }
    }

    private static void showList() {
        for(PersonContact personContact : personContactArrayList){
            System.out.println(personContact.toString());
        }
    }

    private static void addContact(){
        Scanner scanner = new Scanner(System.in);
        PersonContact personContact = new PersonContact();
        System.out.println("Nhập số điện thoại: ");
        personContact.setPhoneNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập nhóm của danh bạ: ");
        personContact.setGroup(scanner.nextLine());
        System.out.println("Nhập họ tên: ");
        personContact.setName(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        personContact.setGender(scanner.nextLine());
        System.out.println("Nhập địa chỉ: ");
        personContact.setAddress(scanner.nextLine());
        System.out.println("Nhập ngày sinh: ");
        personContact.setBirthday(scanner.nextLine());
        System.out.println("Nhập email: ");
        personContact.setEmail(scanner.nextLine());
        personContactArrayList.add(personContact);
        System.out.println("Thêm danh bạ thành công.");
    }

    private static void deleteContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số điện thoại cần xóa: ");
        int phoneNumber = scanner.nextInt();
        boolean isDeleted = false;
        for(int i = 0; i < personContactArrayList.size(); i++){
            if (personContactArrayList.get(i).getPhoneNumber() == phoneNumber){
                personContactArrayList.remove(i);
                System.out.println("Đã xóa.");
                isDeleted = true;
            }
        }
        if (!isDeleted){
            System.out.println("Không tìm thấy số điện thoại này.");
            deleteContact();
        }
    }

    private static void editContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số điện thoại cần sửa");
        int phoneNumber = scanner.nextInt();
        for(int i = 0; i < personContactArrayList.size(); i++){
            if (personContactArrayList.get(i).getPhoneNumber() == phoneNumber){
                System.out.println("Nhập thông tin chỉnh sửa");
                System.out.println("Email");
                String email = scanner.nextLine();
                String checkEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
                Pattern pattern = Pattern.compile(checkEmail);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    System.out.println("Nhóm của danh bạ");
                    personContactArrayList.get(i).setGroup(scanner.nextLine());
                    System.out.println("Họ và tên");
                    personContactArrayList.get(i).setName(scanner.nextLine());
                    System.out.println("Giới tính");
                    personContactArrayList.get(i).setGender(scanner.nextLine());
                    System.out.println("Địa chỉ");
                    personContactArrayList.get(i).setAddress(scanner.nextLine());
                    System.out.println("Ngày sinh");
                    personContactArrayList.get(i).setBirthday(scanner.nextLine());
                    personContactArrayList.get(i).setEmail(email);
                    System.out.println("Chỉnh sửa thành công.");
                }
            }
        }
    }

    private static void findContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số điện thoại cần tìm");
        int phoneNumber = scanner.nextInt();
        for(int i = 0; i < personContactArrayList.size(); i++){
            if (personContactArrayList.get(i).getPhoneNumber() == phoneNumber){
                System.out.println("Đã tìm thấy.");
                System.out.println(personContactArrayList.get(i));
            }
        }
    }
}
