Book.java
        package RMI;
import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 20241123L;
    private String id, title, author;
    private int yearPublished, pageCount;
    private String code;
    public Book() {}
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                ", code='" + code + '\'' +
                '}';
    }
}

 
BookX.java
package RMI;
import java.io.Serializable;
public class BookX implements Serializable {
    private static final long serialVersionUID = 20241124L;
    private String id, title, author;
    private int yearPublished;
    private String genre, code;
    public BookX() {}
    public BookX(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.code = "";
    }
    //get set cứ insert tung hết ra

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }


}

 
Byte.java
package RMI;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class Byte {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf"); //Thay MSV mã câu hỏi tương ứng
        // b. Xử lý
        //Giả sử sau rất nhiều bước xử lý, từ mảng byte []a, các bạn thu được mảng kết quả byte []ans
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans); //Gửi lên sv, thay msv mã đề tương ứng
    }
}

 
ByteService.java
package RMI;
import java.rmi.*;
public interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
 
Character.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class Character {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6"); //Thay MSV mã đề tương ứng

        //b. Xử lý
        //Giả sử với xâu s đề cho, các bận xử lý tỉ tỉ bước, rồi xâu cuối cùng thu được là xâu res gì đấy

        //c. Gửi
        sv.submitCharacter("B21DCCN015", "0JaasIw6", res);//Gửi xâu kq lên cho sv, thay msv mã đề và tên biến kq tương ứng
    }
}

 
CharacterService.java
package RMI;
import java.rmi.*;
public interface CharacterService extends Remote {
    public String requestCharacter(String studentCode, String qCode) throws RemoteException;
    public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
 
Data.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
//Khung chung các bài làm dạng Data
public class Data {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw"); //Thay tương ứng MSV mã câu hỏi vào
        //Chú ý thay kiểu dữ liệu tương ứng và ép kiểu, cú pháp tương tự
        //Ví dụ đề bài cần String thì ghi: String x = (String)sv.requestData (MSV, mã đề)
        //Ta tiếp tục xử lý với inp nhận được...

        // b. Xử lý:
        //Tuỳ vào đề thi, các bạn sẽ cần gửi trả lại server một cái gì đấy, xâu, số, v.v..
        //Ở đây mình giả sử sau 1001 bước xử lý thì kết quả ta thu được là một biến int res chẳng hạn
        int res = 0;
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res); //Chú ý thay MSV mã đề tương ứng
    }
}

 
DataService.java
package RMI;
import java.rmi.*;
public interface DataService extends Remote {
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}

 
Employee.java
package RMI;
import java.io.Serializable;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id;
    private String name;
    private double baseSalary, finalSalary;
    private int experienceYears;
    public Employee(){}
    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
}

 
Event.java
package RMI;
import java.io.Serializable;
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode;
    private int expectedAttendance;
    public Event(){};
    public Event(String id, String eventName, String eventDate, int expectedAttendance){
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getExpectedAttendance() {
        return expectedAttendance;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventCode=" + eventCode + ", expectedAttendance=" + expectedAttendance + '}';
    }
}

 
Object.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
//import RMI.tên lớp;
//Ví dụ
import RMI.Book;
public class Object {
    public static void main(String[] args) throws Exception{
        //a. Nhận đối tượng từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        //Tên lớp a = (Tên lớp)sv.requestObject(Mã sinh viên, Mã câu hỏi); //Chú ý ép kiểu
        //Ví dụ:
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");

        //b. Xử lý đối tượng
        //Sau bước này, ta thu được đối tượng book đã xử lý chẳng hạn

        //c. Gửi lại
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);//Thay MSV mã câu hỏi và tên đối tượng tương ứng
    }
}

 
ObjectService.java
package RMI;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qAlias) throws RemoteException;
    public void submitObject(String studentCode, String qAlias, Serializable object) throws RemoteException;
}

 
Order.java
package RMI;
import java.io.Serializable;
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    private String id, customerCode, orderDate, shippingType, orderCode;
    public Order() {}
    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public String getShippingType() {
        return shippingType;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingType=" + shippingType + ", orderCode=" + orderCode + '}';
    }
}

 
Product.java
package RMI;
import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private String id;
    private String code;
    private double importPrice;
    private double exportPrice;
    public Product() {}
    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getImportPrice() {
        return importPrice;
    }
    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                '}';
    }
}

 
ProductX.java
package RMI;
import java.io.Serializable;
public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107;
    private String id, code, discountCode;
    private int discount;
    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "ProductX [id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + "]";
    }
}

 
Student.java
package RMI;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20241130L;
    private String id;
    private String name;
    private int enrollmentYear;
    private String code;
    public Student() {}
    public Student(String id, String name, int enrollmentYear) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' + '}';
    }
}

 
Ticket.java
package RMI;
import java.io.Serializable;
public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName, saleDate, ticketCode;
    public Ticket(){}
    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
    }
    public String getEventName() {
        return eventName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}

 
ChuyenDoiBatPhan.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi bát phân
        String res = "";
        for (byte x : a) res+=String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN008", "HhPAxeDw", ans);
    }
}


 
PhepXOR1.java
package RMI;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhepXOR1 {
    public static void main(String[] args) throws Exception{
        // a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN212", "YmXQKAUX");
        System.out.println(s);
        // b. Xử lý xâu
        String []tmp = s.split(";");
        String xorKey =tmp[0], inp = tmp[1], res = "";
        for(int i = 0;i<inp.length();i++) res+=(char)(inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN008", "Xidb0Thk", res);
    }
}


 
QuanLyThuVien1.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Book;
public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)), Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code+=String.format("%02d%d%03d", book.getYearPublished()%100,
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        // c.
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);
    }
}




 
SoLonThuK.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}


 
DemSoLanXH2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN012", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first) res+=", ";
                res+=String.format("\"%c\": %d", x, cnt[x]);
                cnt[x] = 0;
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN012", "ctRfIejL", res);
    }
}

 
DoiTien.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class DoiTien {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN012", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        // b. Xử lý: Tìm số đồng tiền
        String ans = "";
        int[] a = {1, 2, 5, 10};
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i];
            if (p > 0) {
                res += p;
                n -= p * a[i];
                for (int j = 0; j < p; j++) ans+=a[i] + ",";
            }
        }
        if (n > 0) ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans= String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        // c. Gửi kết quả
        sv.submitData("B21DCCN012", "Iz06p8Zw", ans);
    }
}



 
PhepXOR2.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN012", "4BraNTI5");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b. Mã hoá
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes(); // Chuyển khóa thành mảng byte
        byte[] maHoa = new byte[a.length];
        for(int i = 0;i<a.length;i++) maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for(byte x: maHoa) System.out.print(x + " ");
        //c. Gửi
        sv.submitData("B21DCCN012", "4BraNTI5", maHoa);
    }
}

 
QuanLyThuVien2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.BookX;
public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B21DCCN012", "CoWosBho");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code+=String.format("%02d%d%d", book.getYearPublished()%100,
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c.
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}

 
ChuyenDoiLaMaThapPhan.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6");
        System.out.println(s);
        //c. Gửi
        System.out.println(change(s));
        sv.submitCharacter("B21DCCN015", "0JaasIw6", String.valueOf(change(s)));
    }
}


 
GiaiMaBase64.java
package RMI.B21DCCN015;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf");
        // b. Giải mã
        String s = new String(a);  //Byte -->String
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s);  // Giải mã Base64
        for (byte x: ans) System.out.print(x + " ");
        System.out.println();
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans);
    }
}



 
LietKeSoNguyenTo.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        // b. Xử lý: Tìm list các SNT
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i<=N;i++){
            if(check(i)==1) res.add(i);
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN015", "NMATI6Zw", res);
    }
    public static int check(int n){//ktra snt
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}

 
PhuongSai.java
package RMI.B21DCCN016;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class PhuongSai {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        System.out.println(s);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp) a.add(Double.parseDouble(x));
        int n = a.size();
        double tong = 0, tongTmp = 0;
        for (double x : a) tong += x;
        double tbc = tong / (double) n;
        for (double x : a) tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        // c. Gửi kết quả
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B21DCCN016", "uZMEY3Zg", res);
    }
}
 
LietKeSoDoiXung.java
package RMI.B21DCCN021;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoDoiXung {
    public static boolean check(int x){
        String s = x+"";
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN021", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String []tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer>a = new ArrayList<>();
        for(int i = n;i<k;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN021", "t3cBY2uk", a);
    }
}

 
MaHoaVigen.java
package RMI.B21DCCN021;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.CharacterService;
public class MaHoaVigen {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN021", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for(int i = 0;i<text.length();i++){
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x)) z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans+=z;
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN021", "Y7YMXHs4", ans);
    }
}

 
TDMT.java
package RMI.B21DCCN021;
import RMI.Order;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
public class TDMT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B21DCCN021", "vLJWvWpf");
        System.out.println(order);
        //b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        //c
        System.out.println(order);
        sv.submitObject("B21DCCN021", "vLJWvWpf", order);
    }
}


 
MaHoaCaesar1.java
package RMI.B21DCCN022;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN022", "j4rStb2a");
        System.out.println(s);
        //b.
        String ans = "";
        int dich = s.length()%7;
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans+=x;
        }
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN022", "j4rStb2a", ans);
    }
}

 
PhanTichTSNT.java
package RMI.B21DCCN022;
import java.util.*;
        import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhanTichTSNT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN022", "zzmmquoc");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                a.add(i);
                n/=i;
            }
        }
        if(n>1) a.add(n);
        System.out.println(a);
        sv.submitData("B21DCCN022", "zzmmquoc", a);
    }
}

 
QuanLySinhVien.java
package RMI.B21DCCN023;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Student;
public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoa2(String s){
        String []tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = 0;i<tmp.length - 1;i++) res+=chuanhoa(tmp[i]) + " ";
        res+=tmp[tmp.length - 1].toUpperCase();
        return res;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B21DCCN023", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear()%100);
        String []tmp = student.getName().split("\\s+");
        code+=tmp[tmp.length - 1].toUpperCase() + "_";
        for(int i = 0;i<tmp.length - 1;i++) code+=Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        //c.
        sv.submitObject("B21DCCN023", "lNV6xzmk", student);
    }
}

 
LietKeSoCP.java
package RMI.B21DCCN028;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoCP {
    public static boolean check(int x){
        double y = Math.sqrt(x);
        int y1 = (int)y;
        return y == y1;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN028", "eTHcAYZh");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN028", "eTHcAYZh", a);
    }
}
 
MaHoaCaesar2.java
package RMI.B21DCCN028;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN028", "i0EVI2TB");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++) a[i]+=doDich;
        for(byte x: a) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "i0EVI2TB", a);
    }
}

 
MaHoaBase64.java
package RMI.B21DCCN029;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN029", "psd4Jmnt");
        System.out.println(s);
        //
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        //
        sv.submitCharacter("B21DCCN029", "psd4Jmnt", ans);
    }
}

 
SapXepChanLe.java
package RMI.B21DCCN029;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN029", "A7hytb1V");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. sx
        byte []res = new byte[a.length];
        int idx = 0;
        for(byte x: a){
            if(x % 2==0)  res[idx++] = x;
        }
        for(byte x: a){
            if(x % 2==1)  res[idx++] = x;
        }
        for(byte x: res) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "A7hytb1V", res);
    }
}

 
ToChucSuKien.java
package RMI.B21DCCN029;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Event;
public class ToChucSuKien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B21DCCN029", "FKrGvwLM");
        System.out.println(event);
        //b.
        String ans = "";
        int x = event.getExpectedAttendance();
        //
        if(x>=1000) ans = "L";
        else if (x>=500 && x<=999) ans = "M";
        else ans = "S";
        //
        String []tmp = event.getEventName().trim().split("\\s+");
        ans+=Character.toUpperCase(tmp[0].charAt(0));
        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1));
        //
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String []tmp2 = tmp1.trim().split("\\s+");
        ans+=tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        //c.
        System.out.println(event);
        sv.submitObject("B21DCCN029", "FKrGvwLM", event);
    }
}

 
ChuyenDoiThapPhanLaMa.java
package RMI.B21DCCN032;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ChuyenDoiThapPhanLaMa {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN032", "ADu6zRYE");
        System.out.println(s);
        //b.
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//thập phân
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};// la mã
        for(int i = 0;i<tp.length;i++){
            while(dec >=tp[i]){
                rm+=lm[i];
                dec-=tp[i];
            }
        }
        System.out.println(rm);
        //c.
        sv.submitCharacter("B21DCCN032", "ADu6zRYE", rm);
    }
}

 
MaHoaHexa.java
package RMI.B21DCCN032;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN032", "pK0IZNnt");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi hexa
        String res = "";
        for (byte x : a) res+=String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN032", "pK0IZNnt", ans);
    }
}


 
NenRLE.java
package RMI.B21DCCN036;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class NenRLE {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b.
        int cnt = 1;
        ArrayList<Byte>res = new ArrayList<>();
        for(int i = 1;i<a.length;i++){
            if(a[i] == a[i - 1]) cnt++;
            else{
                res.add(a[i - 1]); res.add((byte)cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]); res.add((byte)cnt);
        //Cóp sang mảng
        byte []ans = new byte[res.size()];
        int idx = 0;
        for(byte x: res) ans[idx++] = x;
        for(byte x: ans) System.out.print(x + " ");
        sv.submitData("B21DCCN036", "2uG0lQGi", ans);
    }
}

 
QuanLyNhanVien.java
package RMI.B21DCCN038;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Employee;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B21DCCN038", "7fSWnlHB");
        System.out.println(employee);
        //b.tổng cs
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while(x>0){
            tongCS+=x%10;
            x/=10;
        }
        //tổng ước
        int soUoc = 0;
        for(int i = 1;i<=y;i++){
            if(y%i==0) soUoc++;
        }
        //factor
        double factor = (double)(employee.getExperienceYears() + tongCS + soUoc)/100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        //
        employee.setFinalSalary(Final);
        System.out.println(employee);
        //c.
        sv.submitObject("B21DCCN038", "7fSWnlHB", employee);
    }
}

 
QuanLySuKien.java
package RMI.B21DCCN048;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;
public class QuanLySuKien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B21DCCN048", "Uct8bABt");
        //Ticket ticket = new Ticket(1, "Charity Concert", "15/06/2024");
        System.out.println(ticket);
        //Lấy tên
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res+=String.format("%c%c", Character.toUpperCase(s.charAt(0)), (char)Character.toUpperCase(s.charAt(s.length() - 1)));
        //Lấy ngày sinh
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String []tmp = s1.trim().split("\\s+");
        res+=tmp[1] + tmp[0];
        //Lấy 2 chữ số
        Set<Integer>si = new HashSet<>();
        for(char x: s1.toCharArray()){
            if(Character.isDigit(x)) si.add(x - '0');
        }
        for(int i = 9;i >= 0;i--){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        for(int i = 0;i<=9;i++){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        //c.
        sv.submitObject("B21DCCN048", "Uct8bABt", ticket);
    }
}


 
MaHoaURL.java
package RMI.B21DCCN053;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import java.net.URLEncoder;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
}
//Sửa đề xong thì chịu không biết AC kiểu gì??

 
SinhToHop.java
package RMI.B21DCCN053;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class SinhToHop {
    static int ok;
    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++) a[i] = i;
    }
    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3";
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());// Lấy số k
        // Lấy ra mảng và sắp xếp
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp) a.add(Integer.parseInt(x));
        // Bắt đầu sinh tổ hợp. Khởi tạo
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        // Duyệt qua từng tổ hợp chỉ số
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++) tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        //c.
        System.out.println(ans);
        sv.submitData("B21DCCN053", "juC3u7C6", ans);
    }
}

 
LonThuK.java
package RMI.B21DCCN066;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class LonThuK {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN066", "uIKHCTWG");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b.
        byte []b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for(int i = 0;i<b.length;i++){
            if(b[i]==a[a.length - k]){
                pos = i;
                break;
            }
        }
        byte []ans = {(byte)a[a.length - k], (byte)(pos + 1)};
        for(byte x: ans) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN066", "uIKHCTWG", ans);
    }
}

 
BoBaPytago.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        System.out.println(N);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}

 
XHMax.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN319", "1mPMIkGJ");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128];
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B21DCCN319", "1mPMIkGJ", res);
    }
}

 
XuLySanPham1.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Product;
public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN214", "vy7Cq1hJ");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        sv.submitObject("B22DCCN214", "vy7Cq1hJ", product);
    }
}

 
XuLyVanBan.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN319", "NFldNPp6");
        System.out.println(s);
        // b. Xử lý xâu
        s = s.replace("\"", "");  s = s.replace("{", "");  s = s.replace("}", "");
        String[] tmp = s.trim().split(",");// Tách chuỗi thành các cặp key-value
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim();
            if (i % 2 == 0) {
                if (chan.length() > 0) chan+=", ";
                chan+=tmp[i];
            } else {
                if (le.length() > 0) le+=", ";
                le+=tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN319", "NFldNPp6", res);
    }
}

 
DemSoLanXH1.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN564", "U5BEBBOW");
        System.out.println(s);
        // b. Xử lý xâu
        String res = "";
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=String.format("%c%d", x, cnt[x]);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN564", "U5BEBBOW", res);
    }
}



 
HoanViTiepTheo.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN564", "3Qe0Qb5w");
        System.out.println(s);
        //Đẩy hết vào mảng để xử lý
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        //b. Sinh hoán vị kế tiếp
        // Bước 1: Tìm vị trí đầu tiên từ cuối mà tại đó nó nhỏ hơn số đằng sau nó
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        // Bước 2: Kiểm tra nếu không còn hoán vị nào lớn hơn
        if (i < 0) Collections.sort(a); // Đưa về hoán vị đầu tiên
        else {
            // Bước 3: Tìm vị trí đầu tiên từ cuối lớn hơn a[i]
            int j = n - 1;
            while (a.get(j) <= a.get(i)) j--;
            Collections.swap(a, i, j);// Hoán đổi a[i] và a[j]
            // Bước 4: Lật ngược đoạn từ i + 1 đến cuối mảng
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for(int x: a) res+=String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN564", "3Qe0Qb5w", res);
    }
}


 
XHMin.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN564", "L7A2NPQU");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005];
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN564", "L7A2NPQU", res);
    }
}
 
XuLySanPham2.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.ProductX;
public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B21DCCN564", "PY43T66m");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for(char x: product.getDiscountCode().toCharArray()){
            if(Character.isDigit(x)) tong+=Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        System.out.println(product);
        sv.submitObject("B21DCCN564", "PY43T66m", product);
    }
}




 
Address.java
package TCP;
import java.io.*;
public class Address implements Serializable{
    private static final long serialVersionUID = 20180801L;
    private int id;
    private String code, addressLine, city, postalCode;
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", code=" + code + ", addressLine=" + addressLine + ", city=" + city + ", postalCode=" + postalCode + '}';
    }
}

 
Customer.java
package TCP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20170711L; // Theo yêu cầu của đề bài
    private int id;
    private String code, name, dayOfBirth, userName;
    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

 
Laptop.java
package TCP;
import java.io.*;
public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    private int id;
    private String code, name;
    private int quantity;
    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
Product.java
package TCP;
import java.io.*;
public class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    private int id, discount;
    private double price;
    private String name;
    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }
}

 
SanPham.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Product;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN370;151GNZvT";
        out.writeObject(code);
        out.flush();
        //b.
        Product product = (Product) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        int x = (int) product.getPrice();
        int tong = 0;
        while(x > 0){
            tong+=x%10;
            x/=10;
        }
        product.setDiscount(tong);
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        //Đóng kết nối, chú ý là phải có phần này nếu không sẽ bị máy chấm ngoại lệ
        in.close();
        out.close();
        socket.close();
    }
}

 
SinhVien.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Student;
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN222;j5ELZdmS";
        out.writeObject(code);
        out.flush();
        //b.
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien ban dau: " + student);
        //c.
        float x = student.getGpa();
        if (x >= 3.7) student.setGpaLetter("A");
        else if (x >= 3.0) student.setGpaLetter("B");
        else if (x >= 2.0) student.setGpaLetter("C");
        else if (x >= 1.0) student.setGpaLetter("D");
        else student.setGpaLetter("F");
        //d.
        System.out.println("Sinh vien luc sau: " + student);
        out.writeObject(student);
        out.flush();
    }
}
 
Student.java
package TCP;
import java.io.*;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, gpaLetter;
    private float gpa;
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
    @Override
    public String toString() {
        return this.id + " " + this.code + " " + this.gpa + " " + this.gpaLetter;
    }
}

 
Book.java
package UDP;
import java.io.*;
public class Book implements Serializable{
    private static final long serialVersionUID = 20251107L;
    private String id, title, author, isbn, publishDate;
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishDate=" + publishDate + '}';
    }
}

 
Customer.java
package UDP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;
    private String id;
    private String code, name, dayOfBirth, userName;
    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
 
Employee.java
package UDP;
import java.io.*;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    private String id, name, hireDate;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
}

 
Product.java
package UDP;
import java.io.*;
public class Product implements Serializable {
    private static final long serialVersionUID = 20161107;
    private String id, code, name;
    private int quantity;
    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
SanPham.java
package UDP;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/


 
Student.java
package UDP;
import java.io.Serializable;
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    private String id, code, name, email;
    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
}

 
KhachHang.java
package UDP.B17DCAT176;
import UDP.Customer;
import java.io.*;
        import java.net.*;
public class KhachHang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B17DCAT176;OH7rzusB";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String []tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi+=tenTmp[tenTmp.length - 1].toUpperCase()+", ";
        for(int i = 0;i<tenTmp.length - 1;i++) tenMoi+=Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        //Chuẩn hoá ngày sinh
        String []nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        //Tạo username
        String userMoi = "";
        for(int i = 0;i<tenTmp.length - 1;i++) userMoi+=Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi+=tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
LietKeSNT.java
package UDP.B17DCAT176;
import java.net.*;
public class LietKeSNT {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B17DCAT176;78CCQ6xD";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1];int n = Integer.parseInt(s1.trim());
        //
        String ans = "";int cnt = 0;
        for(int i = 2;i<=1000000;i++){
            if(check(i)){
                cnt++;
                ans+=String.format("%d,", i);
                if(cnt==n) break;
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
    public static boolean check(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

 
ChuanHoaXauKyTu.java
package UDP.B21DCCN001;
import java.net.*;
public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;NRVwBVvx";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Chuẩn hoá
        String []tmpS = s.trim().split("\\s+");
        s = "";
        for(String x: tmpS) s+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res = rI + ";" + s;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}


 
DemSoLanXH.java
package UDP.B21DCCN001;
import java.net.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String res = ""; int []cnt = new int[10005];
        for(char x: s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x]>0){
                res+=String.format("%d%c", cnt[x], x);
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
QLSinhVien.java
package UDP.B21DCCN001;
import UDP.Student;
import java.io.*;
        import java.net.*;
public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;QABGDFxd";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        System.out.println(student);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for(String x: words) name+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        //Tạo email
        String email = words[words.length - 1].toLowerCase();
        for(int i = 0;i<words.length - 1;i++) email+=Character.toLowerCase(words[i].charAt(0));
        email+="@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
SanPham.java
package UDP.B21DCCN001;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;OX8O73nD ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/

 
TimSoConThieu.java
package UDP.B21DCCN001;
import java.net.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;XdHHmyiv";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []sTmp = s.trim().split(";");
        String rI = sTmp[0]; int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split(",");
        for(int i = 0;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
TongCacChuSo.java
package UDP.B21DCCN001;
import java.net.*;
public class TongCacChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;0Iend7Pp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int tong = 0;
        for(char x: s.toCharArray()) tong+=(x - '0');
        String res = String.format("%s;%d", rI, tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
LocKyTu.java
package UDP.B21DCCN002;
import java.net.*;
public class LocKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN002;EbTMtFBH";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int []cnt = new int[10005];
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        String res = "";
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
MaHoaCaesar.java
package UDP.B21DCCN003;
import java.net.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN003;vNIIU53V";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1]; int doDich = Integer.parseInt(sTmp[2].trim());
        //
        String ans = "";
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans+=x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
XHMax.java
package UDP.B21DCCN003;
import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN003;KFPR3GWV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
ChuanHoaThongTinSach.java
package B21DCCN005_HE;
import UDP.Book;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoaTitle(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaISBN(String s){
        //Ví dụ: Input: 9783161484100. Ouput: 978-3-16-148410-0
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6), s.substring(6, 12), s.substring(12));
    }
    public static String chuanhoaAuthor(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for(int i = 1;i < tmp.length; i++) ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
QuanLyTTNhanVien.java
package B21DCCN005_HE;
import UDP.Employee;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaTen(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0];
    }
    //Đã chuẩn hoá ngày rồi thì muốn tăng phải lấy theo ngày đã chuẩn hoá
    public static double tangLuong (String ngay, double luongCu){
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray()) tong += c - '0';
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;ySsumsIE";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
SapXepTuDienNguoc.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;9UfU4Vky";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<String> a = new ArrayList <>();
        for(int i = 1; i < tmp1.length; i++) a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for(String x: a) res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
//Phải đưa về cùng một kiểu rồi mới sắp xếp được

 
TongSoNguyenLon.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;2sIjAYaU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}

 
HieuHaiTapTu.java
package UDP.B21DCCN020;
import java.net.*;
public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN020;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1], s2 = sTmp[2];
        //
        String ans = "";
        int []cnt = new int[10005];
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
CuaSoTruot.java
package B22DCCN007;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN007;iv00Hrq6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        System.out.println(st);
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; int n = Integer.parseInt(tmp[1]), k = Integer.parseInt(tmp[2]);
        //Cho các số còn lại vào mảng
        ArrayList<Integer>a = new ArrayList<>();
        for(int i = 3; i < tmp.length; i++) a.add(Integer.parseInt(tmp[i]));
        //Tạo String kết quả
        String ans = rqID + ";";
        //en - st + 1 = k -> st = en + 1 - k. en_max = n - 1 -> st_max = n - 1 + 1 - k = n - k
        for(int i = 0; i <=  n - k; i++){
            int Max = a.get(i);//Max mỗi đoạn con
            for(int j = i + 1; j <= i + k - 1; j++){ //en = st + k - 1
                if(a.get(j) > Max) Max = a.get(j);
            }
            ans += String.format("%d,", Max);
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.
c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"
d. Đóng socket và kết thúc chương trình.
*/

 
SXTheoVTGoc.java
package B22DCCN015;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class SXTheoVTGoc{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN015;aKZwZxWk";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0];
        //Cho các xâu còn lại vào mảng
        TreeMap<Integer, String> mp = new TreeMap<>();
        for(int i = 1; i < tmp.length; i++){
            String []tmp_i = tmp[i].split(":");
            mp.put(Integer.parseInt(tmp_i[1]), tmp_i[0]);
        }
        //Tạo kết quả
        String ans = rqID + ";";
        int ok = 0;//ok = 1: Là xâu đầu
        for(String x: mp.values()){
            if(ok == 1) ans += ",";
            ans += x; ok = 1;
        }
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"
d. Đóng socket và kết thúc chương trình.
*/

 
TongHaiSoNhiPhan.java
package B22DCCN016;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class TongHaiSoNhiPhan{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B22DCCN016;lIQVug9S";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; long b1 = Integer.parseInt(tmp[1], 2); long b2 = Integer.parseInt(tmp[2], 2);
        long tong = b1 + b2;
        String ans = String.format("%d", tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.
b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130
d. Đóng socket và kết thúc chương trình.
*/

 
PTichTSNT.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            String tmp = "";
            for(int i = 2;i*i<=x;i++){
                while(x%i==0){
                    x/=i;
                    tmp+=String.format("%d, ", i);
                }
            }
            if(x > 1) tmp+=String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}


 
QuanLySinhVien.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a) System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>(); //key: tên môn, value: điểm thi cao nhất môn đó
        for(StudentY x: a){
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon))) hsg.put(mon, diemMon);
        }
        List<Float>diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemMax.contains(x.getScore())) ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}


 
DemSoLanXH.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a); Collections.sort(a);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(String x: ans){
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
QuanLySanPham.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}

 
SapXepChuoi.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class SapXepChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN002", qCode = "x5TIDg1S";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
LonNhoThuK.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
PhanLoaiHocLuc.java
package ws;
import vn.medianews.*;
        import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN214", qCode = "SWiWt72j"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}

 
SXTheoLen.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class SXTheoLen {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN003", qCode = "mpu9xCxR";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}
 
LietKeUoc.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int)port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer>ans = new java.util.ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0) ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
QuanLyNhanVien.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY>a = port.requestListEmployeeY(msv, qCode);
        for(EmployeeY x: a) System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}

 
LenMaxMin.java
package WebService.B21DCCN005;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "9n2rfqST";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin  = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for(String x: tmp){
            if(x.length() < lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length() > lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN005;
import java.util.*;
        import java.time.*;
        import java.time.temporal.ChronoUnit;
import vn.medianews.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x: cus) System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x: cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if(thang >=6) ans.add(x);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}

 
ChuanHoaChuoi.java

import vn.medianews.*;
        import java.util.*;
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B22DCCN214", qCode = "mcgWENCz";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        s = s.replace('_', ' ');
        String []tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for(String x: tmp) p+=chuanhoa(x);
        for(int i = 1;i<tmp.length;i++) c+=chuanhoa(tmp[i]);
        for(String x: tmp) sn+=x.toLowerCase()+"_"; sn = sn.substring(0, sn.length() - 1);
        List<String>ans = new java.util.ArrayList<>();
        ans.add(p); ans.add(c); ans.add(sn);
        System.out.println(ans);
        //c
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static String chuanhoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}

 
TimSoLonNhat.java
package WebService.B21DCCN007;
import vn.medianews.*;
        import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<String>a1 = new java.util.ArrayList<>();
        for(int x: a) a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for(String x: a1) ans+=x+ans;
        port.submitDataString(msv, qCode, ans);
    }
}

 
DaoNguoc.java
package WebService.B21DCCN008;
import vn.medianews.*;
        import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN008", qCode = "rT6Ql5GH";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
LenMaxMin2.java
package WebService.B21DCCN010;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "sGJc3iD5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for(String x: a){
            if(x.length() > Max.length()) Max = x;
            if(x.length() < Min.length()) Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyDuAn.java
package WebService.B21DCCN010;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
        import java.util.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for(Project x : a){
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if(ngay <=15 && ngay >=0 && x.getCompletionPercentage() >=80.00) send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for(Project p: send) System.out.println(p);
    }
}

 
FractoDec.java
package WebService.B21DCCN011;
import vn.medianews.*;
        import java.util.*;
public class FractoDec {
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int) (a * 100.0);
        int tmp = gcd(tu, mau); tu/=tmp; mau/=tmp;
        List<Integer> ans = new java.util.ArrayList<>();
        ans.add(tu); ans.add(mau);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
NhomTuTheoNguyenAm.java
package WebService.B21DCCN012;
import vn.medianews.*;
        import java.util.*;
public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1;i<a.size();i++){
            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN014;
import vn.medianews.*;
        import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer>a = (List<Customer>)port.requestListCustomer(msv, qCode);
        for(Customer x: a) System.out.println(x);
        List<Customer>ans = new java.util.ArrayList<>();
        for(Customer x: a){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >=5) ans.add(x);
        }
        System.out.println();
        for(Customer x: ans) System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}

 
XoayVongKyTu.java
package WebService.B21DCCN016;
import vn.medianews.*;
        import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}


 
DecToBin.java
package WebService;
import vn.medianews.*;
        import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
DonHang2.java
package WebService.B21DCCN021;
import vn.medianews.*;
        import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "CuW1L0ev";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a) System.out.println(x);
        HashMap<String, Float>mp = new HashMap<>();
        for(Order x: a){
            String maKH = x.getCustomerId(); float giaTri = x.getAmount();
            if(!mp.containsKey(maKH)) mp.put(maKH, giaTri);
            else mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0; String maKHmax = "";
        for (String maKH: mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order>ans = new java.util.ArrayList<>();
        for(Order x: a){
            if(x.getCustomerId().equals(maKHmax)) ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}

 
HeCoSo8.java
import vn.medianews.*;
        import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN214", qCode = "F9BK4f0Y";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>res = new java.util.ArrayList<>();
        for(int n: a){
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}


 
LoaiBoTrungNhau.java
package WebService.B21DCCN033;
import vn.medianews.*;
        import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
TongCacSo.java
package WebService.B21DCCN082;
import vn.medianews.*;
        import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}


 
QuanLyNhanVien2.java
package WebService.B21DCCN084;
import vn.medianews.*;
        import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10); kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for(int i = 0;i<=tmp;i++){
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue()<=5) cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}

 
SXChanLe.java
package WebService.B21DCCN088;
import vn.medianews.*;
        import java.util.*;
public class SXChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN088", qCode = "0BEtJAT9";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<Integer>chan = new java.util.ArrayList<>(), le = new java.util.ArrayList<>(), ans = new java.util.ArrayList<>();
        for(int x: a){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int k = Integer.min(chan.size(), le.size());
        for(int i = 0;i < k;i++){
            ans.add(chan.get(i)); ans.add(le.get(i));
        }
        int k1 = chan.size() - k, k2 = le.size() - k;
        if(k1 > 0){
            for(int i = k;i<chan.size();i++) ans.add(chan.get(i));
        }
        if(k2 > 0){
            for(int i = k;i<le.size();i++) ans.add(le.get(i));
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
Book.java
package RMI;
import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 20241123L;
    private String id, title, author;
    private int yearPublished, pageCount;
    private String code;
    public Book() {}
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                ", code='" + code + '\'' +
                '}';
    }
}

 
BookX.java
package RMI;
import java.io.Serializable;
public class BookX implements Serializable {
    private static final long serialVersionUID = 20241124L;
    private String id, title, author;
    private int yearPublished;
    private String genre, code;
    public BookX() {}
    public BookX(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.code = "";
    }
    //get set cứ insert tung hết ra

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }


}

 
Byte.java
package RMI;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class Byte {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf"); //Thay MSV mã câu hỏi tương ứng
        // b. Xử lý
        //Giả sử sau rất nhiều bước xử lý, từ mảng byte []a, các bạn thu được mảng kết quả byte []ans
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans); //Gửi lên sv, thay msv mã đề tương ứng
    }
}

 
ByteService.java
package RMI;
import java.rmi.*;
public interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
 
Character.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class Character {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6"); //Thay MSV mã đề tương ứng

        //b. Xử lý
        //Giả sử với xâu s đề cho, các bận xử lý tỉ tỉ bước, rồi xâu cuối cùng thu được là xâu res gì đấy

        //c. Gửi
        sv.submitCharacter("B21DCCN015", "0JaasIw6", res);//Gửi xâu kq lên cho sv, thay msv mã đề và tên biến kq tương ứng
    }
}

 
CharacterService.java
package RMI;
import java.rmi.*;
public interface CharacterService extends Remote {
    public String requestCharacter(String studentCode, String qCode) throws RemoteException;
    public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
 
Data.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
//Khung chung các bài làm dạng Data
public class Data {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw"); //Thay tương ứng MSV mã câu hỏi vào
        //Chú ý thay kiểu dữ liệu tương ứng và ép kiểu, cú pháp tương tự
        //Ví dụ đề bài cần String thì ghi: String x = (String)sv.requestData (MSV, mã đề)
        //Ta tiếp tục xử lý với inp nhận được...

        // b. Xử lý:
        //Tuỳ vào đề thi, các bạn sẽ cần gửi trả lại server một cái gì đấy, xâu, số, v.v..
        //Ở đây mình giả sử sau 1001 bước xử lý thì kết quả ta thu được là một biến int res chẳng hạn
        int res = 0;
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res); //Chú ý thay MSV mã đề tương ứng
    }
}

 
DataService.java
package RMI;
import java.rmi.*;
public interface DataService extends Remote {
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}

 
Employee.java
package RMI;
import java.io.Serializable;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id;
    private String name;
    private double baseSalary, finalSalary;
    private int experienceYears;
    public Employee(){}
    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
}

 
Event.java
package RMI;
import java.io.Serializable;
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode;
    private int expectedAttendance;
    public Event(){};
    public Event(String id, String eventName, String eventDate, int expectedAttendance){
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getExpectedAttendance() {
        return expectedAttendance;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventCode=" + eventCode + ", expectedAttendance=" + expectedAttendance + '}';
    }
}

 
Object.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
//import RMI.tên lớp;
//Ví dụ
import RMI.Book;
public class Object {
    public static void main(String[] args) throws Exception{
        //a. Nhận đối tượng từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        //Tên lớp a = (Tên lớp)sv.requestObject(Mã sinh viên, Mã câu hỏi); //Chú ý ép kiểu
        //Ví dụ:
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");

        //b. Xử lý đối tượng
        //Sau bước này, ta thu được đối tượng book đã xử lý chẳng hạn

        //c. Gửi lại
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);//Thay MSV mã câu hỏi và tên đối tượng tương ứng
    }
}

 
ObjectService.java
package RMI;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qAlias) throws RemoteException;
    public void submitObject(String studentCode, String qAlias, Serializable object) throws RemoteException;
}

 
Order.java
package RMI;
import java.io.Serializable;
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    private String id, customerCode, orderDate, shippingType, orderCode;
    public Order() {}
    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public String getShippingType() {
        return shippingType;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingType=" + shippingType + ", orderCode=" + orderCode + '}';
    }
}

 
Product.java
package RMI;
import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private String id;
    private String code;
    private double importPrice;
    private double exportPrice;
    public Product() {}
    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getImportPrice() {
        return importPrice;
    }
    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                '}';
    }
}

 
ProductX.java
package RMI;
import java.io.Serializable;
public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107;
    private String id, code, discountCode;
    private int discount;
    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "ProductX [id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + "]";
    }
}

 
Student.java
package RMI;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20241130L;
    private String id;
    private String name;
    private int enrollmentYear;
    private String code;
    public Student() {}
    public Student(String id, String name, int enrollmentYear) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' + '}';
    }
}

 
Ticket.java
package RMI;
import java.io.Serializable;
public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName, saleDate, ticketCode;
    public Ticket(){}
    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
    }
    public String getEventName() {
        return eventName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}

 
ChuyenDoiBatPhan.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi bát phân
        String res = "";
        for (byte x : a) res+=String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN008", "HhPAxeDw", ans);
    }
}


 
PhepXOR1.java
package RMI;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhepXOR1 {
    public static void main(String[] args) throws Exception{
        // a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN212", "YmXQKAUX");
        System.out.println(s);
        // b. Xử lý xâu
        String []tmp = s.split(";");
        String xorKey =tmp[0], inp = tmp[1], res = "";
        for(int i = 0;i<inp.length();i++) res+=(char)(inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN008", "Xidb0Thk", res);
    }
}


 
QuanLyThuVien1.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Book;
public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)), Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code+=String.format("%02d%d%03d", book.getYearPublished()%100,
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        // c.
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);
    }
}




 
SoLonThuK.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}


 
DemSoLanXH2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN012", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first) res+=", ";
                res+=String.format("\"%c\": %d", x, cnt[x]);
                cnt[x] = 0;
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN012", "ctRfIejL", res);
    }
}

 
DoiTien.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class DoiTien {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN012", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        // b. Xử lý: Tìm số đồng tiền
        String ans = "";
        int[] a = {1, 2, 5, 10};
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i];
            if (p > 0) {
                res += p;
                n -= p * a[i];
                for (int j = 0; j < p; j++) ans+=a[i] + ",";
            }
        }
        if (n > 0) ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans= String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        // c. Gửi kết quả
        sv.submitData("B21DCCN012", "Iz06p8Zw", ans);
    }
}



 
PhepXOR2.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN012", "4BraNTI5");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b. Mã hoá
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes(); // Chuyển khóa thành mảng byte
        byte[] maHoa = new byte[a.length];
        for(int i = 0;i<a.length;i++) maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for(byte x: maHoa) System.out.print(x + " ");
        //c. Gửi
        sv.submitData("B21DCCN012", "4BraNTI5", maHoa);
    }
}

 
QuanLyThuVien2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.BookX;
public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B21DCCN012", "CoWosBho");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code+=String.format("%02d%d%d", book.getYearPublished()%100,
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c.
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}

 
ChuyenDoiLaMaThapPhan.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6");
        System.out.println(s);
        //c. Gửi
        System.out.println(change(s));
        sv.submitCharacter("B21DCCN015", "0JaasIw6", String.valueOf(change(s)));
    }
}


 
GiaiMaBase64.java
package RMI.B21DCCN015;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf");
        // b. Giải mã
        String s = new String(a);  //Byte -->String
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s);  // Giải mã Base64
        for (byte x: ans) System.out.print(x + " ");
        System.out.println();
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans);
    }
}



 
LietKeSoNguyenTo.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        // b. Xử lý: Tìm list các SNT
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i<=N;i++){
            if(check(i)==1) res.add(i);
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN015", "NMATI6Zw", res);
    }
    public static int check(int n){//ktra snt
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}

 
PhuongSai.java
package RMI.B21DCCN016;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class PhuongSai {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        System.out.println(s);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp) a.add(Double.parseDouble(x));
        int n = a.size();
        double tong = 0, tongTmp = 0;
        for (double x : a) tong += x;
        double tbc = tong / (double) n;
        for (double x : a) tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        // c. Gửi kết quả
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B21DCCN016", "uZMEY3Zg", res);
    }
}
 
LietKeSoDoiXung.java
package RMI.B21DCCN021;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoDoiXung {
    public static boolean check(int x){
        String s = x+"";
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN021", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String []tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer>a = new ArrayList<>();
        for(int i = n;i<k;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN021", "t3cBY2uk", a);
    }
}

 
MaHoaVigen.java
package RMI.B21DCCN021;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.CharacterService;
public class MaHoaVigen {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN021", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for(int i = 0;i<text.length();i++){
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x)) z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans+=z;
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN021", "Y7YMXHs4", ans);
    }
}

 
TDMT.java
package RMI.B21DCCN021;
import RMI.Order;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
public class TDMT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B21DCCN021", "vLJWvWpf");
        System.out.println(order);
        //b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        //c
        System.out.println(order);
        sv.submitObject("B21DCCN021", "vLJWvWpf", order);
    }
}


 
MaHoaCaesar1.java
package RMI.B21DCCN022;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN022", "j4rStb2a");
        System.out.println(s);
        //b.
        String ans = "";
        int dich = s.length()%7;
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans+=x;
        }
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN022", "j4rStb2a", ans);
    }
}

 
PhanTichTSNT.java
package RMI.B21DCCN022;
import java.util.*;
        import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhanTichTSNT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN022", "zzmmquoc");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                a.add(i);
                n/=i;
            }
        }
        if(n>1) a.add(n);
        System.out.println(a);
        sv.submitData("B21DCCN022", "zzmmquoc", a);
    }
}

 
QuanLySinhVien.java
package RMI.B21DCCN023;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Student;
public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoa2(String s){
        String []tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = 0;i<tmp.length - 1;i++) res+=chuanhoa(tmp[i]) + " ";
        res+=tmp[tmp.length - 1].toUpperCase();
        return res;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B21DCCN023", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear()%100);
        String []tmp = student.getName().split("\\s+");
        code+=tmp[tmp.length - 1].toUpperCase() + "_";
        for(int i = 0;i<tmp.length - 1;i++) code+=Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        //c.
        sv.submitObject("B21DCCN023", "lNV6xzmk", student);
    }
}

 
LietKeSoCP.java
package RMI.B21DCCN028;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoCP {
    public static boolean check(int x){
        double y = Math.sqrt(x);
        int y1 = (int)y;
        return y == y1;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN028", "eTHcAYZh");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN028", "eTHcAYZh", a);
    }
}
 
MaHoaCaesar2.java
package RMI.B21DCCN028;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN028", "i0EVI2TB");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++) a[i]+=doDich;
        for(byte x: a) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "i0EVI2TB", a);
    }
}

 
MaHoaBase64.java
package RMI.B21DCCN029;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN029", "psd4Jmnt");
        System.out.println(s);
        //
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        //
        sv.submitCharacter("B21DCCN029", "psd4Jmnt", ans);
    }
}

 
SapXepChanLe.java
package RMI.B21DCCN029;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN029", "A7hytb1V");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. sx
        byte []res = new byte[a.length];
        int idx = 0;
        for(byte x: a){
            if(x % 2==0)  res[idx++] = x;
        }
        for(byte x: a){
            if(x % 2==1)  res[idx++] = x;
        }
        for(byte x: res) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "A7hytb1V", res);
    }
}

 
ToChucSuKien.java
package RMI.B21DCCN029;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Event;
public class ToChucSuKien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B21DCCN029", "FKrGvwLM");
        System.out.println(event);
        //b.
        String ans = "";
        int x = event.getExpectedAttendance();
        //
        if(x>=1000) ans = "L";
        else if (x>=500 && x<=999) ans = "M";
        else ans = "S";
        //
        String []tmp = event.getEventName().trim().split("\\s+");
        ans+=Character.toUpperCase(tmp[0].charAt(0));
        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1));
        //
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String []tmp2 = tmp1.trim().split("\\s+");
        ans+=tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        //c.
        System.out.println(event);
        sv.submitObject("B21DCCN029", "FKrGvwLM", event);
    }
}

 
ChuyenDoiThapPhanLaMa.java
package RMI.B21DCCN032;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ChuyenDoiThapPhanLaMa {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN032", "ADu6zRYE");
        System.out.println(s);
        //b.
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//thập phân
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};// la mã
        for(int i = 0;i<tp.length;i++){
            while(dec >=tp[i]){
                rm+=lm[i];
                dec-=tp[i];
            }
        }
        System.out.println(rm);
        //c.
        sv.submitCharacter("B21DCCN032", "ADu6zRYE", rm);
    }
}

 
MaHoaHexa.java
package RMI.B21DCCN032;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN032", "pK0IZNnt");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi hexa
        String res = "";
        for (byte x : a) res+=String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN032", "pK0IZNnt", ans);
    }
}


 
NenRLE.java
package RMI.B21DCCN036;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class NenRLE {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b.
        int cnt = 1;
        ArrayList<Byte>res = new ArrayList<>();
        for(int i = 1;i<a.length;i++){
            if(a[i] == a[i - 1]) cnt++;
            else{
                res.add(a[i - 1]); res.add((byte)cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]); res.add((byte)cnt);
        //Cóp sang mảng
        byte []ans = new byte[res.size()];
        int idx = 0;
        for(byte x: res) ans[idx++] = x;
        for(byte x: ans) System.out.print(x + " ");
        sv.submitData("B21DCCN036", "2uG0lQGi", ans);
    }
}

 
QuanLyNhanVien.java
package RMI.B21DCCN038;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Employee;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B21DCCN038", "7fSWnlHB");
        System.out.println(employee);
        //b.tổng cs
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while(x>0){
            tongCS+=x%10;
            x/=10;
        }
        //tổng ước
        int soUoc = 0;
        for(int i = 1;i<=y;i++){
            if(y%i==0) soUoc++;
        }
        //factor
        double factor = (double)(employee.getExperienceYears() + tongCS + soUoc)/100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        //
        employee.setFinalSalary(Final);
        System.out.println(employee);
        //c.
        sv.submitObject("B21DCCN038", "7fSWnlHB", employee);
    }
}

 
QuanLySuKien.java
package RMI.B21DCCN048;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;
public class QuanLySuKien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B21DCCN048", "Uct8bABt");
        //Ticket ticket = new Ticket(1, "Charity Concert", "15/06/2024");
        System.out.println(ticket);
        //Lấy tên
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res+=String.format("%c%c", Character.toUpperCase(s.charAt(0)), (char)Character.toUpperCase(s.charAt(s.length() - 1)));
        //Lấy ngày sinh
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String []tmp = s1.trim().split("\\s+");
        res+=tmp[1] + tmp[0];
        //Lấy 2 chữ số
        Set<Integer>si = new HashSet<>();
        for(char x: s1.toCharArray()){
            if(Character.isDigit(x)) si.add(x - '0');
        }
        for(int i = 9;i >= 0;i--){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        for(int i = 0;i<=9;i++){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        //c.
        sv.submitObject("B21DCCN048", "Uct8bABt", ticket);
    }
}


 
MaHoaURL.java
package RMI.B21DCCN053;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import java.net.URLEncoder;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
}
//Sửa đề xong thì chịu không biết AC kiểu gì??

 
SinhToHop.java
package RMI.B21DCCN053;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class SinhToHop {
    static int ok;
    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++) a[i] = i;
    }
    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3";
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());// Lấy số k
        // Lấy ra mảng và sắp xếp
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp) a.add(Integer.parseInt(x));
        // Bắt đầu sinh tổ hợp. Khởi tạo
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        // Duyệt qua từng tổ hợp chỉ số
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++) tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        //c.
        System.out.println(ans);
        sv.submitData("B21DCCN053", "juC3u7C6", ans);
    }
}

 
LonThuK.java
package RMI.B21DCCN066;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class LonThuK {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN066", "uIKHCTWG");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b.
        byte []b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for(int i = 0;i<b.length;i++){
            if(b[i]==a[a.length - k]){
                pos = i;
                break;
            }
        }
        byte []ans = {(byte)a[a.length - k], (byte)(pos + 1)};
        for(byte x: ans) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN066", "uIKHCTWG", ans);
    }
}

 
BoBaPytago.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        System.out.println(N);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}

 
XHMax.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN319", "1mPMIkGJ");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128];
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B21DCCN319", "1mPMIkGJ", res);
    }
}

 
XuLySanPham1.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Product;
public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN214", "vy7Cq1hJ");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        sv.submitObject("B22DCCN214", "vy7Cq1hJ", product);
    }
}

 
XuLyVanBan.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN319", "NFldNPp6");
        System.out.println(s);
        // b. Xử lý xâu
        s = s.replace("\"", "");  s = s.replace("{", "");  s = s.replace("}", "");
        String[] tmp = s.trim().split(",");// Tách chuỗi thành các cặp key-value
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim();
            if (i % 2 == 0) {
                if (chan.length() > 0) chan+=", ";
                chan+=tmp[i];
            } else {
                if (le.length() > 0) le+=", ";
                le+=tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN319", "NFldNPp6", res);
    }
}

 
DemSoLanXH1.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN564", "U5BEBBOW");
        System.out.println(s);
        // b. Xử lý xâu
        String res = "";
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=String.format("%c%d", x, cnt[x]);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN564", "U5BEBBOW", res);
    }
}



 
HoanViTiepTheo.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN564", "3Qe0Qb5w");
        System.out.println(s);
        //Đẩy hết vào mảng để xử lý
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        //b. Sinh hoán vị kế tiếp
        // Bước 1: Tìm vị trí đầu tiên từ cuối mà tại đó nó nhỏ hơn số đằng sau nó
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        // Bước 2: Kiểm tra nếu không còn hoán vị nào lớn hơn
        if (i < 0) Collections.sort(a); // Đưa về hoán vị đầu tiên
        else {
            // Bước 3: Tìm vị trí đầu tiên từ cuối lớn hơn a[i]
            int j = n - 1;
            while (a.get(j) <= a.get(i)) j--;
            Collections.swap(a, i, j);// Hoán đổi a[i] và a[j]
            // Bước 4: Lật ngược đoạn từ i + 1 đến cuối mảng
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for(int x: a) res+=String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN564", "3Qe0Qb5w", res);
    }
}


 
XHMin.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN564", "L7A2NPQU");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005];
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN564", "L7A2NPQU", res);
    }
}
 
XuLySanPham2.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.ProductX;
public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B21DCCN564", "PY43T66m");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for(char x: product.getDiscountCode().toCharArray()){
            if(Character.isDigit(x)) tong+=Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        System.out.println(product);
        sv.submitObject("B21DCCN564", "PY43T66m", product);
    }
}




 
Address.java
package TCP;
import java.io.*;
public class Address implements Serializable{
    private static final long serialVersionUID = 20180801L;
    private int id;
    private String code, addressLine, city, postalCode;
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", code=" + code + ", addressLine=" + addressLine + ", city=" + city + ", postalCode=" + postalCode + '}';
    }
}

 
Customer.java
package TCP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20170711L; // Theo yêu cầu của đề bài
    private int id;
    private String code, name, dayOfBirth, userName;
    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

 
Laptop.java
package TCP;
import java.io.*;
public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    private int id;
    private String code, name;
    private int quantity;
    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
Product.java
package TCP;
import java.io.*;
public class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    private int id, discount;
    private double price;
    private String name;
    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }
}

 
SanPham.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Product;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN370;151GNZvT";
        out.writeObject(code);
        out.flush();
        //b.
        Product product = (Product) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        int x = (int) product.getPrice();
        int tong = 0;
        while(x > 0){
            tong+=x%10;
            x/=10;
        }
        product.setDiscount(tong);
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        //Đóng kết nối, chú ý là phải có phần này nếu không sẽ bị máy chấm ngoại lệ
        in.close();
        out.close();
        socket.close();
    }
}

 
SinhVien.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Student;
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN222;j5ELZdmS";
        out.writeObject(code);
        out.flush();
        //b.
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien ban dau: " + student);
        //c.
        float x = student.getGpa();
        if (x >= 3.7) student.setGpaLetter("A");
        else if (x >= 3.0) student.setGpaLetter("B");
        else if (x >= 2.0) student.setGpaLetter("C");
        else if (x >= 1.0) student.setGpaLetter("D");
        else student.setGpaLetter("F");
        //d.
        System.out.println("Sinh vien luc sau: " + student);
        out.writeObject(student);
        out.flush();
    }
}
 
Student.java
package TCP;
import java.io.*;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, gpaLetter;
    private float gpa;
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
    @Override
    public String toString() {
        return this.id + " " + this.code + " " + this.gpa + " " + this.gpaLetter;
    }
}

 
Book.java
package UDP;
import java.io.*;
public class Book implements Serializable{
    private static final long serialVersionUID = 20251107L;
    private String id, title, author, isbn, publishDate;
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishDate=" + publishDate + '}';
    }
}

 
Customer.java
package UDP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;
    private String id;
    private String code, name, dayOfBirth, userName;
    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
 
Employee.java
package UDP;
import java.io.*;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    private String id, name, hireDate;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
}

 
Product.java
package UDP;
import java.io.*;
public class Product implements Serializable {
    private static final long serialVersionUID = 20161107;
    private String id, code, name;
    private int quantity;
    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
SanPham.java
package UDP;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/


 
Student.java
package UDP;
import java.io.Serializable;
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    private String id, code, name, email;
    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
}

 
KhachHang.java
package UDP.B17DCAT176;
import UDP.Customer;
import java.io.*;
        import java.net.*;
public class KhachHang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B17DCAT176;OH7rzusB";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String []tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi+=tenTmp[tenTmp.length - 1].toUpperCase()+", ";
        for(int i = 0;i<tenTmp.length - 1;i++) tenMoi+=Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        //Chuẩn hoá ngày sinh
        String []nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        //Tạo username
        String userMoi = "";
        for(int i = 0;i<tenTmp.length - 1;i++) userMoi+=Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi+=tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
LietKeSNT.java
package UDP.B17DCAT176;
import java.net.*;
public class LietKeSNT {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B17DCAT176;78CCQ6xD";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1];int n = Integer.parseInt(s1.trim());
        //
        String ans = "";int cnt = 0;
        for(int i = 2;i<=1000000;i++){
            if(check(i)){
                cnt++;
                ans+=String.format("%d,", i);
                if(cnt==n) break;
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
    public static boolean check(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

 
ChuanHoaXauKyTu.java
package UDP.B21DCCN001;
import java.net.*;
public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;NRVwBVvx";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Chuẩn hoá
        String []tmpS = s.trim().split("\\s+");
        s = "";
        for(String x: tmpS) s+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res = rI + ";" + s;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}


 
DemSoLanXH.java
package UDP.B21DCCN001;
import java.net.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String res = ""; int []cnt = new int[10005];
        for(char x: s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x]>0){
                res+=String.format("%d%c", cnt[x], x);
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
QLSinhVien.java
package UDP.B21DCCN001;
import UDP.Student;
import java.io.*;
        import java.net.*;
public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;QABGDFxd";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        System.out.println(student);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for(String x: words) name+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        //Tạo email
        String email = words[words.length - 1].toLowerCase();
        for(int i = 0;i<words.length - 1;i++) email+=Character.toLowerCase(words[i].charAt(0));
        email+="@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
SanPham.java
package UDP.B21DCCN001;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;OX8O73nD ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/

 
TimSoConThieu.java
package UDP.B21DCCN001;
import java.net.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;XdHHmyiv";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []sTmp = s.trim().split(";");
        String rI = sTmp[0]; int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split(",");
        for(int i = 0;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
TongCacChuSo.java
package UDP.B21DCCN001;
import java.net.*;
public class TongCacChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;0Iend7Pp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int tong = 0;
        for(char x: s.toCharArray()) tong+=(x - '0');
        String res = String.format("%s;%d", rI, tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
LocKyTu.java
package UDP.B21DCCN002;
import java.net.*;
public class LocKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN002;EbTMtFBH";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int []cnt = new int[10005];
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        String res = "";
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
MaHoaCaesar.java
package UDP.B21DCCN003;
import java.net.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN003;vNIIU53V";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1]; int doDich = Integer.parseInt(sTmp[2].trim());
        //
        String ans = "";
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans+=x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
XHMax.java
package UDP.B21DCCN003;
import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN003;KFPR3GWV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
ChuanHoaThongTinSach.java
package B21DCCN005_HE;
import UDP.Book;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoaTitle(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaISBN(String s){
        //Ví dụ: Input: 9783161484100. Ouput: 978-3-16-148410-0
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6), s.substring(6, 12), s.substring(12));
    }
    public static String chuanhoaAuthor(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for(int i = 1;i < tmp.length; i++) ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
QuanLyTTNhanVien.java
package B21DCCN005_HE;
import UDP.Employee;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaTen(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0];
    }
    //Đã chuẩn hoá ngày rồi thì muốn tăng phải lấy theo ngày đã chuẩn hoá
    public static double tangLuong (String ngay, double luongCu){
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray()) tong += c - '0';
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;ySsumsIE";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
SapXepTuDienNguoc.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;9UfU4Vky";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<String> a = new ArrayList <>();
        for(int i = 1; i < tmp1.length; i++) a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for(String x: a) res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
//Phải đưa về cùng một kiểu rồi mới sắp xếp được

 
TongSoNguyenLon.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;2sIjAYaU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}

 
HieuHaiTapTu.java
package UDP.B21DCCN020;
import java.net.*;
public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN020;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1], s2 = sTmp[2];
        //
        String ans = "";
        int []cnt = new int[10005];
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
CuaSoTruot.java
package B22DCCN007;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN007;iv00Hrq6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        System.out.println(st);
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; int n = Integer.parseInt(tmp[1]), k = Integer.parseInt(tmp[2]);
        //Cho các số còn lại vào mảng
        ArrayList<Integer>a = new ArrayList<>();
        for(int i = 3; i < tmp.length; i++) a.add(Integer.parseInt(tmp[i]));
        //Tạo String kết quả
        String ans = rqID + ";";
        //en - st + 1 = k -> st = en + 1 - k. en_max = n - 1 -> st_max = n - 1 + 1 - k = n - k
        for(int i = 0; i <=  n - k; i++){
            int Max = a.get(i);//Max mỗi đoạn con
            for(int j = i + 1; j <= i + k - 1; j++){ //en = st + k - 1
                if(a.get(j) > Max) Max = a.get(j);
            }
            ans += String.format("%d,", Max);
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.
c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"
d. Đóng socket và kết thúc chương trình.
*/

 
SXTheoVTGoc.java
package B22DCCN015;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class SXTheoVTGoc{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN015;aKZwZxWk";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0];
        //Cho các xâu còn lại vào mảng
        TreeMap<Integer, String> mp = new TreeMap<>();
        for(int i = 1; i < tmp.length; i++){
            String []tmp_i = tmp[i].split(":");
            mp.put(Integer.parseInt(tmp_i[1]), tmp_i[0]);
        }
        //Tạo kết quả
        String ans = rqID + ";";
        int ok = 0;//ok = 1: Là xâu đầu
        for(String x: mp.values()){
            if(ok == 1) ans += ",";
            ans += x; ok = 1;
        }
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"
d. Đóng socket và kết thúc chương trình.
*/

 
TongHaiSoNhiPhan.java
package B22DCCN016;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class TongHaiSoNhiPhan{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B22DCCN016;lIQVug9S";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; long b1 = Integer.parseInt(tmp[1], 2); long b2 = Integer.parseInt(tmp[2], 2);
        long tong = b1 + b2;
        String ans = String.format("%d", tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.
b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130
d. Đóng socket và kết thúc chương trình.
*/

 
PTichTSNT.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            String tmp = "";
            for(int i = 2;i*i<=x;i++){
                while(x%i==0){
                    x/=i;
                    tmp+=String.format("%d, ", i);
                }
            }
            if(x > 1) tmp+=String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}


 
QuanLySinhVien.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a) System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>(); //key: tên môn, value: điểm thi cao nhất môn đó
        for(StudentY x: a){
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon))) hsg.put(mon, diemMon);
        }
        List<Float>diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemMax.contains(x.getScore())) ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}


 
DemSoLanXH.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a); Collections.sort(a);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(String x: ans){
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
QuanLySanPham.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}

 
SapXepChuoi.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class SapXepChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN002", qCode = "x5TIDg1S";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
LonNhoThuK.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
PhanLoaiHocLuc.java
package ws;
import vn.medianews.*;
        import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN214", qCode = "SWiWt72j"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}

 
SXTheoLen.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class SXTheoLen {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN003", qCode = "mpu9xCxR";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}
 
LietKeUoc.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int)port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer>ans = new java.util.ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0) ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
QuanLyNhanVien.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY>a = port.requestListEmployeeY(msv, qCode);
        for(EmployeeY x: a) System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}

 
LenMaxMin.java
package WebService.B21DCCN005;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "9n2rfqST";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin  = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for(String x: tmp){
            if(x.length() < lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length() > lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN005;
import java.util.*;
        import java.time.*;
        import java.time.temporal.ChronoUnit;
import vn.medianews.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x: cus) System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x: cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if(thang >=6) ans.add(x);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}

 
ChuanHoaChuoi.java

import vn.medianews.*;
        import java.util.*;
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B22DCCN214", qCode = "mcgWENCz";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        s = s.replace('_', ' ');
        String []tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for(String x: tmp) p+=chuanhoa(x);
        for(int i = 1;i<tmp.length;i++) c+=chuanhoa(tmp[i]);
        for(String x: tmp) sn+=x.toLowerCase()+"_"; sn = sn.substring(0, sn.length() - 1);
        List<String>ans = new java.util.ArrayList<>();
        ans.add(p); ans.add(c); ans.add(sn);
        System.out.println(ans);
        //c
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static String chuanhoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}

 
TimSoLonNhat.java
package WebService.B21DCCN007;
import vn.medianews.*;
        import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<String>a1 = new java.util.ArrayList<>();
        for(int x: a) a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for(String x: a1) ans+=x+ans;
        port.submitDataString(msv, qCode, ans);
    }
}

 
DaoNguoc.java
package WebService.B21DCCN008;
import vn.medianews.*;
        import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN008", qCode = "rT6Ql5GH";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
LenMaxMin2.java
package WebService.B21DCCN010;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "sGJc3iD5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for(String x: a){
            if(x.length() > Max.length()) Max = x;
            if(x.length() < Min.length()) Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyDuAn.java
package WebService.B21DCCN010;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
        import java.util.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for(Project x : a){
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if(ngay <=15 && ngay >=0 && x.getCompletionPercentage() >=80.00) send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for(Project p: send) System.out.println(p);
    }
}

 
FractoDec.java
package WebService.B21DCCN011;
import vn.medianews.*;
        import java.util.*;
public class FractoDec {
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int) (a * 100.0);
        int tmp = gcd(tu, mau); tu/=tmp; mau/=tmp;
        List<Integer> ans = new java.util.ArrayList<>();
        ans.add(tu); ans.add(mau);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
NhomTuTheoNguyenAm.java
package WebService.B21DCCN012;
import vn.medianews.*;
        import java.util.*;
public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1;i<a.size();i++){
            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN014;
import vn.medianews.*;
        import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer>a = (List<Customer>)port.requestListCustomer(msv, qCode);
        for(Customer x: a) System.out.println(x);
        List<Customer>ans = new java.util.ArrayList<>();
        for(Customer x: a){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >=5) ans.add(x);
        }
        System.out.println();
        for(Customer x: ans) System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}

 
XoayVongKyTu.java
package WebService.B21DCCN016;
import vn.medianews.*;
        import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}


 
DecToBin.java
package WebService;
import vn.medianews.*;
        import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
DonHang2.java
package WebService.B21DCCN021;
import vn.medianews.*;
        import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "CuW1L0ev";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a) System.out.println(x);
        HashMap<String, Float>mp = new HashMap<>();
        for(Order x: a){
            String maKH = x.getCustomerId(); float giaTri = x.getAmount();
            if(!mp.containsKey(maKH)) mp.put(maKH, giaTri);
            else mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0; String maKHmax = "";
        for (String maKH: mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order>ans = new java.util.ArrayList<>();
        for(Order x: a){
            if(x.getCustomerId().equals(maKHmax)) ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}

 
HeCoSo8.java
import vn.medianews.*;
        import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN214", qCode = "F9BK4f0Y";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>res = new java.util.ArrayList<>();
        for(int n: a){
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}


 
LoaiBoTrungNhau.java
package WebService.B21DCCN033;
import vn.medianews.*;
        import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
TongCacSo.java
package WebService.B21DCCN082;
import vn.medianews.*;
        import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}


 
QuanLyNhanVien2.java
package WebService.B21DCCN084;
import vn.medianews.*;
        import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10); kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for(int i = 0;i<=tmp;i++){
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue()<=5) cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}

 
SXChanLe.java
package WebService.B21DCCN088;
import vn.medianews.*;
        import java.util.*;
public class SXChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN088", qCode = "0BEtJAT9";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<Integer>chan = new java.util.ArrayList<>(), le = new java.util.ArrayList<>(), ans = new java.util.ArrayList<>();
        for(int x: a){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int k = Integer.min(chan.size(), le.size());
        for(int i = 0;i < k;i++){
            ans.add(chan.get(i)); ans.add(le.get(i));
        }
        int k1 = chan.size() - k, k2 = le.size() - k;
        if(k1 > 0){
            for(int i = k;i<chan.size();i++) ans.add(chan.get(i));
        }
        if(k2 > 0){
            for(int i = k;i<le.size();i++) ans.add(le.get(i));
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
Book.java
package RMI;
import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 20241123L;
    private String id, title, author;
    private int yearPublished, pageCount;
    private String code;
    public Book() {}
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                ", code='" + code + '\'' +
                '}';
    }
}

 
BookX.java
package RMI;
import java.io.Serializable;
public class BookX implements Serializable {
    private static final long serialVersionUID = 20241124L;
    private String id, title, author;
    private int yearPublished;
    private String genre, code;
    public BookX() {}
    public BookX(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.code = "";
    }
    //get set cứ insert tung hết ra

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }


}

 
Byte.java
package RMI;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class Byte {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf"); //Thay MSV mã câu hỏi tương ứng
        // b. Xử lý
        //Giả sử sau rất nhiều bước xử lý, từ mảng byte []a, các bạn thu được mảng kết quả byte []ans
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans); //Gửi lên sv, thay msv mã đề tương ứng
    }
}

 
ByteService.java
package RMI;
import java.rmi.*;
public interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
 
Character.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class Character {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6"); //Thay MSV mã đề tương ứng

        //b. Xử lý
        //Giả sử với xâu s đề cho, các bận xử lý tỉ tỉ bước, rồi xâu cuối cùng thu được là xâu res gì đấy

        //c. Gửi
        sv.submitCharacter("B21DCCN015", "0JaasIw6", res);//Gửi xâu kq lên cho sv, thay msv mã đề và tên biến kq tương ứng
    }
}

 
CharacterService.java
package RMI;
import java.rmi.*;
public interface CharacterService extends Remote {
    public String requestCharacter(String studentCode, String qCode) throws RemoteException;
    public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
 
Data.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
//Khung chung các bài làm dạng Data
public class Data {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw"); //Thay tương ứng MSV mã câu hỏi vào
        //Chú ý thay kiểu dữ liệu tương ứng và ép kiểu, cú pháp tương tự
        //Ví dụ đề bài cần String thì ghi: String x = (String)sv.requestData (MSV, mã đề)
        //Ta tiếp tục xử lý với inp nhận được...

        // b. Xử lý:
        //Tuỳ vào đề thi, các bạn sẽ cần gửi trả lại server một cái gì đấy, xâu, số, v.v..
        //Ở đây mình giả sử sau 1001 bước xử lý thì kết quả ta thu được là một biến int res chẳng hạn
        int res = 0;
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res); //Chú ý thay MSV mã đề tương ứng
    }
}

 
DataService.java
package RMI;
import java.rmi.*;
public interface DataService extends Remote {
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}

 
Employee.java
package RMI;
import java.io.Serializable;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id;
    private String name;
    private double baseSalary, finalSalary;
    private int experienceYears;
    public Employee(){}
    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
}

 
Event.java
package RMI;
import java.io.Serializable;
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode;
    private int expectedAttendance;
    public Event(){};
    public Event(String id, String eventName, String eventDate, int expectedAttendance){
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getExpectedAttendance() {
        return expectedAttendance;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventCode=" + eventCode + ", expectedAttendance=" + expectedAttendance + '}';
    }
}

 
Object.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
//import RMI.tên lớp;
//Ví dụ
import RMI.Book;
public class Object {
    public static void main(String[] args) throws Exception{
        //a. Nhận đối tượng từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        //Tên lớp a = (Tên lớp)sv.requestObject(Mã sinh viên, Mã câu hỏi); //Chú ý ép kiểu
        //Ví dụ:
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");

        //b. Xử lý đối tượng
        //Sau bước này, ta thu được đối tượng book đã xử lý chẳng hạn

        //c. Gửi lại
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);//Thay MSV mã câu hỏi và tên đối tượng tương ứng
    }
}

 
ObjectService.java
package RMI;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qAlias) throws RemoteException;
    public void submitObject(String studentCode, String qAlias, Serializable object) throws RemoteException;
}

 
Order.java
package RMI;
import java.io.Serializable;
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    private String id, customerCode, orderDate, shippingType, orderCode;
    public Order() {}
    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public String getShippingType() {
        return shippingType;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingType=" + shippingType + ", orderCode=" + orderCode + '}';
    }
}

 
Product.java
package RMI;
import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private String id;
    private String code;
    private double importPrice;
    private double exportPrice;
    public Product() {}
    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getImportPrice() {
        return importPrice;
    }
    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                '}';
    }
}

 
ProductX.java
package RMI;
import java.io.Serializable;
public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107;
    private String id, code, discountCode;
    private int discount;
    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "ProductX [id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + "]";
    }
}

 
Student.java
package RMI;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20241130L;
    private String id;
    private String name;
    private int enrollmentYear;
    private String code;
    public Student() {}
    public Student(String id, String name, int enrollmentYear) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' + '}';
    }
}

 
Ticket.java
package RMI;
import java.io.Serializable;
public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName, saleDate, ticketCode;
    public Ticket(){}
    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
    }
    public String getEventName() {
        return eventName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}

 
ChuyenDoiBatPhan.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi bát phân
        String res = "";
        for (byte x : a) res+=String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN008", "HhPAxeDw", ans);
    }
}


 
PhepXOR1.java
package RMI;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhepXOR1 {
    public static void main(String[] args) throws Exception{
        // a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN212", "YmXQKAUX");
        System.out.println(s);
        // b. Xử lý xâu
        String []tmp = s.split(";");
        String xorKey =tmp[0], inp = tmp[1], res = "";
        for(int i = 0;i<inp.length();i++) res+=(char)(inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN008", "Xidb0Thk", res);
    }
}


 
QuanLyThuVien1.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Book;
public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)), Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code+=String.format("%02d%d%03d", book.getYearPublished()%100,
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        // c.
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);
    }
}




 
SoLonThuK.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}


 
DemSoLanXH2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN012", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first) res+=", ";
                res+=String.format("\"%c\": %d", x, cnt[x]);
                cnt[x] = 0;
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN012", "ctRfIejL", res);
    }
}

 
DoiTien.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class DoiTien {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN012", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        // b. Xử lý: Tìm số đồng tiền
        String ans = "";
        int[] a = {1, 2, 5, 10};
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i];
            if (p > 0) {
                res += p;
                n -= p * a[i];
                for (int j = 0; j < p; j++) ans+=a[i] + ",";
            }
        }
        if (n > 0) ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans= String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        // c. Gửi kết quả
        sv.submitData("B21DCCN012", "Iz06p8Zw", ans);
    }
}



 
PhepXOR2.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN012", "4BraNTI5");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b. Mã hoá
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes(); // Chuyển khóa thành mảng byte
        byte[] maHoa = new byte[a.length];
        for(int i = 0;i<a.length;i++) maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for(byte x: maHoa) System.out.print(x + " ");
        //c. Gửi
        sv.submitData("B21DCCN012", "4BraNTI5", maHoa);
    }
}

 
QuanLyThuVien2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.BookX;
public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B21DCCN012", "CoWosBho");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code+=String.format("%02d%d%d", book.getYearPublished()%100,
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c.
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}

 
ChuyenDoiLaMaThapPhan.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6");
        System.out.println(s);
        //c. Gửi
        System.out.println(change(s));
        sv.submitCharacter("B21DCCN015", "0JaasIw6", String.valueOf(change(s)));
    }
}


 
GiaiMaBase64.java
package RMI.B21DCCN015;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf");
        // b. Giải mã
        String s = new String(a);  //Byte -->String
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s);  // Giải mã Base64
        for (byte x: ans) System.out.print(x + " ");
        System.out.println();
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans);
    }
}



 
LietKeSoNguyenTo.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        // b. Xử lý: Tìm list các SNT
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i<=N;i++){
            if(check(i)==1) res.add(i);
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN015", "NMATI6Zw", res);
    }
    public static int check(int n){//ktra snt
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}

 
PhuongSai.java
package RMI.B21DCCN016;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class PhuongSai {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        System.out.println(s);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp) a.add(Double.parseDouble(x));
        int n = a.size();
        double tong = 0, tongTmp = 0;
        for (double x : a) tong += x;
        double tbc = tong / (double) n;
        for (double x : a) tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        // c. Gửi kết quả
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B21DCCN016", "uZMEY3Zg", res);
    }
}
 
LietKeSoDoiXung.java
package RMI.B21DCCN021;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoDoiXung {
    public static boolean check(int x){
        String s = x+"";
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN021", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String []tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer>a = new ArrayList<>();
        for(int i = n;i<k;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN021", "t3cBY2uk", a);
    }
}

 
MaHoaVigen.java
package RMI.B21DCCN021;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.CharacterService;
public class MaHoaVigen {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN021", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for(int i = 0;i<text.length();i++){
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x)) z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans+=z;
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN021", "Y7YMXHs4", ans);
    }
}

 
TDMT.java
package RMI.B21DCCN021;
import RMI.Order;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
public class TDMT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B21DCCN021", "vLJWvWpf");
        System.out.println(order);
        //b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        //c
        System.out.println(order);
        sv.submitObject("B21DCCN021", "vLJWvWpf", order);
    }
}


 
MaHoaCaesar1.java
package RMI.B21DCCN022;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN022", "j4rStb2a");
        System.out.println(s);
        //b.
        String ans = "";
        int dich = s.length()%7;
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans+=x;
        }
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN022", "j4rStb2a", ans);
    }
}

 
PhanTichTSNT.java
package RMI.B21DCCN022;
import java.util.*;
        import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhanTichTSNT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN022", "zzmmquoc");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                a.add(i);
                n/=i;
            }
        }
        if(n>1) a.add(n);
        System.out.println(a);
        sv.submitData("B21DCCN022", "zzmmquoc", a);
    }
}

 
QuanLySinhVien.java
package RMI.B21DCCN023;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Student;
public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoa2(String s){
        String []tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = 0;i<tmp.length - 1;i++) res+=chuanhoa(tmp[i]) + " ";
        res+=tmp[tmp.length - 1].toUpperCase();
        return res;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B21DCCN023", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear()%100);
        String []tmp = student.getName().split("\\s+");
        code+=tmp[tmp.length - 1].toUpperCase() + "_";
        for(int i = 0;i<tmp.length - 1;i++) code+=Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        //c.
        sv.submitObject("B21DCCN023", "lNV6xzmk", student);
    }
}

 
LietKeSoCP.java
package RMI.B21DCCN028;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoCP {
    public static boolean check(int x){
        double y = Math.sqrt(x);
        int y1 = (int)y;
        return y == y1;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN028", "eTHcAYZh");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN028", "eTHcAYZh", a);
    }
}
 
MaHoaCaesar2.java
package RMI.B21DCCN028;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN028", "i0EVI2TB");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++) a[i]+=doDich;
        for(byte x: a) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "i0EVI2TB", a);
    }
}

 
MaHoaBase64.java
package RMI.B21DCCN029;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN029", "psd4Jmnt");
        System.out.println(s);
        //
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        //
        sv.submitCharacter("B21DCCN029", "psd4Jmnt", ans);
    }
}

 
SapXepChanLe.java
package RMI.B21DCCN029;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN029", "A7hytb1V");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. sx
        byte []res = new byte[a.length];
        int idx = 0;
        for(byte x: a){
            if(x % 2==0)  res[idx++] = x;
        }
        for(byte x: a){
            if(x % 2==1)  res[idx++] = x;
        }
        for(byte x: res) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "A7hytb1V", res);
    }
}

 
ToChucSuKien.java
package RMI.B21DCCN029;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Event;
public class ToChucSuKien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B21DCCN029", "FKrGvwLM");
        System.out.println(event);
        //b.
        String ans = "";
        int x = event.getExpectedAttendance();
        //
        if(x>=1000) ans = "L";
        else if (x>=500 && x<=999) ans = "M";
        else ans = "S";
        //
        String []tmp = event.getEventName().trim().split("\\s+");
        ans+=Character.toUpperCase(tmp[0].charAt(0));
        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1));
        //
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String []tmp2 = tmp1.trim().split("\\s+");
        ans+=tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        //c.
        System.out.println(event);
        sv.submitObject("B21DCCN029", "FKrGvwLM", event);
    }
}

 
ChuyenDoiThapPhanLaMa.java
package RMI.B21DCCN032;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ChuyenDoiThapPhanLaMa {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN032", "ADu6zRYE");
        System.out.println(s);
        //b.
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//thập phân
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};// la mã
        for(int i = 0;i<tp.length;i++){
            while(dec >=tp[i]){
                rm+=lm[i];
                dec-=tp[i];
            }
        }
        System.out.println(rm);
        //c.
        sv.submitCharacter("B21DCCN032", "ADu6zRYE", rm);
    }
}

 
MaHoaHexa.java
package RMI.B21DCCN032;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN032", "pK0IZNnt");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi hexa
        String res = "";
        for (byte x : a) res+=String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN032", "pK0IZNnt", ans);
    }
}


 
NenRLE.java
package RMI.B21DCCN036;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class NenRLE {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b.
        int cnt = 1;
        ArrayList<Byte>res = new ArrayList<>();
        for(int i = 1;i<a.length;i++){
            if(a[i] == a[i - 1]) cnt++;
            else{
                res.add(a[i - 1]); res.add((byte)cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]); res.add((byte)cnt);
        //Cóp sang mảng
        byte []ans = new byte[res.size()];
        int idx = 0;
        for(byte x: res) ans[idx++] = x;
        for(byte x: ans) System.out.print(x + " ");
        sv.submitData("B21DCCN036", "2uG0lQGi", ans);
    }
}

 
QuanLyNhanVien.java
package RMI.B21DCCN038;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Employee;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B21DCCN038", "7fSWnlHB");
        System.out.println(employee);
        //b.tổng cs
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while(x>0){
            tongCS+=x%10;
            x/=10;
        }
        //tổng ước
        int soUoc = 0;
        for(int i = 1;i<=y;i++){
            if(y%i==0) soUoc++;
        }
        //factor
        double factor = (double)(employee.getExperienceYears() + tongCS + soUoc)/100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        //
        employee.setFinalSalary(Final);
        System.out.println(employee);
        //c.
        sv.submitObject("B21DCCN038", "7fSWnlHB", employee);
    }
}

 
QuanLySuKien.java
package RMI.B21DCCN048;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;
public class QuanLySuKien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B21DCCN048", "Uct8bABt");
        //Ticket ticket = new Ticket(1, "Charity Concert", "15/06/2024");
        System.out.println(ticket);
        //Lấy tên
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res+=String.format("%c%c", Character.toUpperCase(s.charAt(0)), (char)Character.toUpperCase(s.charAt(s.length() - 1)));
        //Lấy ngày sinh
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String []tmp = s1.trim().split("\\s+");
        res+=tmp[1] + tmp[0];
        //Lấy 2 chữ số
        Set<Integer>si = new HashSet<>();
        for(char x: s1.toCharArray()){
            if(Character.isDigit(x)) si.add(x - '0');
        }
        for(int i = 9;i >= 0;i--){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        for(int i = 0;i<=9;i++){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        //c.
        sv.submitObject("B21DCCN048", "Uct8bABt", ticket);
    }
}


 
MaHoaURL.java
package RMI.B21DCCN053;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import java.net.URLEncoder;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
}
//Sửa đề xong thì chịu không biết AC kiểu gì??

 
SinhToHop.java
package RMI.B21DCCN053;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class SinhToHop {
    static int ok;
    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++) a[i] = i;
    }
    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3";
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());// Lấy số k
        // Lấy ra mảng và sắp xếp
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp) a.add(Integer.parseInt(x));
        // Bắt đầu sinh tổ hợp. Khởi tạo
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        // Duyệt qua từng tổ hợp chỉ số
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++) tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        //c.
        System.out.println(ans);
        sv.submitData("B21DCCN053", "juC3u7C6", ans);
    }
}

 
LonThuK.java
package RMI.B21DCCN066;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class LonThuK {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN066", "uIKHCTWG");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b.
        byte []b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for(int i = 0;i<b.length;i++){
            if(b[i]==a[a.length - k]){
                pos = i;
                break;
            }
        }
        byte []ans = {(byte)a[a.length - k], (byte)(pos + 1)};
        for(byte x: ans) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN066", "uIKHCTWG", ans);
    }
}

 
BoBaPytago.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        System.out.println(N);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}

 
XHMax.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN319", "1mPMIkGJ");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128];
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B21DCCN319", "1mPMIkGJ", res);
    }
}

 
XuLySanPham1.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Product;
public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN214", "vy7Cq1hJ");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        sv.submitObject("B22DCCN214", "vy7Cq1hJ", product);
    }
}

 
XuLyVanBan.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN319", "NFldNPp6");
        System.out.println(s);
        // b. Xử lý xâu
        s = s.replace("\"", "");  s = s.replace("{", "");  s = s.replace("}", "");
        String[] tmp = s.trim().split(",");// Tách chuỗi thành các cặp key-value
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim();
            if (i % 2 == 0) {
                if (chan.length() > 0) chan+=", ";
                chan+=tmp[i];
            } else {
                if (le.length() > 0) le+=", ";
                le+=tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN319", "NFldNPp6", res);
    }
}

 
DemSoLanXH1.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN564", "U5BEBBOW");
        System.out.println(s);
        // b. Xử lý xâu
        String res = "";
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=String.format("%c%d", x, cnt[x]);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN564", "U5BEBBOW", res);
    }
}



 
HoanViTiepTheo.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN564", "3Qe0Qb5w");
        System.out.println(s);
        //Đẩy hết vào mảng để xử lý
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        //b. Sinh hoán vị kế tiếp
        // Bước 1: Tìm vị trí đầu tiên từ cuối mà tại đó nó nhỏ hơn số đằng sau nó
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        // Bước 2: Kiểm tra nếu không còn hoán vị nào lớn hơn
        if (i < 0) Collections.sort(a); // Đưa về hoán vị đầu tiên
        else {
            // Bước 3: Tìm vị trí đầu tiên từ cuối lớn hơn a[i]
            int j = n - 1;
            while (a.get(j) <= a.get(i)) j--;
            Collections.swap(a, i, j);// Hoán đổi a[i] và a[j]
            // Bước 4: Lật ngược đoạn từ i + 1 đến cuối mảng
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for(int x: a) res+=String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN564", "3Qe0Qb5w", res);
    }
}


 
XHMin.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN564", "L7A2NPQU");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005];
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN564", "L7A2NPQU", res);
    }
}
 
XuLySanPham2.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.ProductX;
public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B21DCCN564", "PY43T66m");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for(char x: product.getDiscountCode().toCharArray()){
            if(Character.isDigit(x)) tong+=Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        System.out.println(product);
        sv.submitObject("B21DCCN564", "PY43T66m", product);
    }
}




 
Address.java
package TCP;
import java.io.*;
public class Address implements Serializable{
    private static final long serialVersionUID = 20180801L;
    private int id;
    private String code, addressLine, city, postalCode;
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", code=" + code + ", addressLine=" + addressLine + ", city=" + city + ", postalCode=" + postalCode + '}';
    }
}

 
Customer.java
package TCP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20170711L; // Theo yêu cầu của đề bài
    private int id;
    private String code, name, dayOfBirth, userName;
    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

 
Laptop.java
package TCP;
import java.io.*;
public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    private int id;
    private String code, name;
    private int quantity;
    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
Product.java
package TCP;
import java.io.*;
public class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    private int id, discount;
    private double price;
    private String name;
    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }
}

 
SanPham.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Product;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN370;151GNZvT";
        out.writeObject(code);
        out.flush();
        //b.
        Product product = (Product) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        int x = (int) product.getPrice();
        int tong = 0;
        while(x > 0){
            tong+=x%10;
            x/=10;
        }
        product.setDiscount(tong);
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        //Đóng kết nối, chú ý là phải có phần này nếu không sẽ bị máy chấm ngoại lệ
        in.close();
        out.close();
        socket.close();
    }
}

 
SinhVien.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Student;
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN222;j5ELZdmS";
        out.writeObject(code);
        out.flush();
        //b.
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien ban dau: " + student);
        //c.
        float x = student.getGpa();
        if (x >= 3.7) student.setGpaLetter("A");
        else if (x >= 3.0) student.setGpaLetter("B");
        else if (x >= 2.0) student.setGpaLetter("C");
        else if (x >= 1.0) student.setGpaLetter("D");
        else student.setGpaLetter("F");
        //d.
        System.out.println("Sinh vien luc sau: " + student);
        out.writeObject(student);
        out.flush();
    }
}
 
Student.java
package TCP;
import java.io.*;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, gpaLetter;
    private float gpa;
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
    @Override
    public String toString() {
        return this.id + " " + this.code + " " + this.gpa + " " + this.gpaLetter;
    }
}

 
Book.java
package UDP;
import java.io.*;
public class Book implements Serializable{
    private static final long serialVersionUID = 20251107L;
    private String id, title, author, isbn, publishDate;
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishDate=" + publishDate + '}';
    }
}

 
Customer.java
package UDP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;
    private String id;
    private String code, name, dayOfBirth, userName;
    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
 
Employee.java
package UDP;
import java.io.*;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    private String id, name, hireDate;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
}

 
Product.java
package UDP;
import java.io.*;
public class Product implements Serializable {
    private static final long serialVersionUID = 20161107;
    private String id, code, name;
    private int quantity;
    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
SanPham.java
package UDP;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/


 
Student.java
package UDP;
import java.io.Serializable;
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    private String id, code, name, email;
    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
}

 
KhachHang.java
package UDP.B17DCAT176;
import UDP.Customer;
import java.io.*;
        import java.net.*;
public class KhachHang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B17DCAT176;OH7rzusB";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String []tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi+=tenTmp[tenTmp.length - 1].toUpperCase()+", ";
        for(int i = 0;i<tenTmp.length - 1;i++) tenMoi+=Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        //Chuẩn hoá ngày sinh
        String []nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        //Tạo username
        String userMoi = "";
        for(int i = 0;i<tenTmp.length - 1;i++) userMoi+=Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi+=tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
LietKeSNT.java
package UDP.B17DCAT176;
import java.net.*;
public class LietKeSNT {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B17DCAT176;78CCQ6xD";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1];int n = Integer.parseInt(s1.trim());
        //
        String ans = "";int cnt = 0;
        for(int i = 2;i<=1000000;i++){
            if(check(i)){
                cnt++;
                ans+=String.format("%d,", i);
                if(cnt==n) break;
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
    public static boolean check(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

 
ChuanHoaXauKyTu.java
package UDP.B21DCCN001;
import java.net.*;
public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;NRVwBVvx";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Chuẩn hoá
        String []tmpS = s.trim().split("\\s+");
        s = "";
        for(String x: tmpS) s+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res = rI + ";" + s;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}


 
DemSoLanXH.java
package UDP.B21DCCN001;
import java.net.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String res = ""; int []cnt = new int[10005];
        for(char x: s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x]>0){
                res+=String.format("%d%c", cnt[x], x);
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
QLSinhVien.java
package UDP.B21DCCN001;
import UDP.Student;
import java.io.*;
        import java.net.*;
public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;QABGDFxd";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        System.out.println(student);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for(String x: words) name+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        //Tạo email
        String email = words[words.length - 1].toLowerCase();
        for(int i = 0;i<words.length - 1;i++) email+=Character.toLowerCase(words[i].charAt(0));
        email+="@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
SanPham.java
package UDP.B21DCCN001;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;OX8O73nD ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/

 
TimSoConThieu.java
package UDP.B21DCCN001;
import java.net.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;XdHHmyiv";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []sTmp = s.trim().split(";");
        String rI = sTmp[0]; int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split(",");
        for(int i = 0;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
TongCacChuSo.java
package UDP.B21DCCN001;
import java.net.*;
public class TongCacChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;0Iend7Pp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int tong = 0;
        for(char x: s.toCharArray()) tong+=(x - '0');
        String res = String.format("%s;%d", rI, tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
LocKyTu.java
package UDP.B21DCCN002;
import java.net.*;
public class LocKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN002;EbTMtFBH";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int []cnt = new int[10005];
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        String res = "";
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
MaHoaCaesar.java
package UDP.B21DCCN003;
import java.net.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN003;vNIIU53V";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1]; int doDich = Integer.parseInt(sTmp[2].trim());
        //
        String ans = "";
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans+=x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
XHMax.java
package UDP.B21DCCN003;
import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN003;KFPR3GWV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
ChuanHoaThongTinSach.java
package B21DCCN005_HE;
import UDP.Book;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoaTitle(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaISBN(String s){
        //Ví dụ: Input: 9783161484100. Ouput: 978-3-16-148410-0
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6), s.substring(6, 12), s.substring(12));
    }
    public static String chuanhoaAuthor(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for(int i = 1;i < tmp.length; i++) ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
QuanLyTTNhanVien.java
package B21DCCN005_HE;
import UDP.Employee;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaTen(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0];
    }
    //Đã chuẩn hoá ngày rồi thì muốn tăng phải lấy theo ngày đã chuẩn hoá
    public static double tangLuong (String ngay, double luongCu){
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray()) tong += c - '0';
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;ySsumsIE";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
SapXepTuDienNguoc.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;9UfU4Vky";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<String> a = new ArrayList <>();
        for(int i = 1; i < tmp1.length; i++) a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for(String x: a) res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
//Phải đưa về cùng một kiểu rồi mới sắp xếp được

 
TongSoNguyenLon.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;2sIjAYaU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}

 
HieuHaiTapTu.java
package UDP.B21DCCN020;
import java.net.*;
public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN020;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1], s2 = sTmp[2];
        //
        String ans = "";
        int []cnt = new int[10005];
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
CuaSoTruot.java
package B22DCCN007;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN007;iv00Hrq6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        System.out.println(st);
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; int n = Integer.parseInt(tmp[1]), k = Integer.parseInt(tmp[2]);
        //Cho các số còn lại vào mảng
        ArrayList<Integer>a = new ArrayList<>();
        for(int i = 3; i < tmp.length; i++) a.add(Integer.parseInt(tmp[i]));
        //Tạo String kết quả
        String ans = rqID + ";";
        //en - st + 1 = k -> st = en + 1 - k. en_max = n - 1 -> st_max = n - 1 + 1 - k = n - k
        for(int i = 0; i <=  n - k; i++){
            int Max = a.get(i);//Max mỗi đoạn con
            for(int j = i + 1; j <= i + k - 1; j++){ //en = st + k - 1
                if(a.get(j) > Max) Max = a.get(j);
            }
            ans += String.format("%d,", Max);
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.
c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"
d. Đóng socket và kết thúc chương trình.
*/

 
SXTheoVTGoc.java
package B22DCCN015;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class SXTheoVTGoc{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN015;aKZwZxWk";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0];
        //Cho các xâu còn lại vào mảng
        TreeMap<Integer, String> mp = new TreeMap<>();
        for(int i = 1; i < tmp.length; i++){
            String []tmp_i = tmp[i].split(":");
            mp.put(Integer.parseInt(tmp_i[1]), tmp_i[0]);
        }
        //Tạo kết quả
        String ans = rqID + ";";
        int ok = 0;//ok = 1: Là xâu đầu
        for(String x: mp.values()){
            if(ok == 1) ans += ",";
            ans += x; ok = 1;
        }
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"
d. Đóng socket và kết thúc chương trình.
*/

 
TongHaiSoNhiPhan.java
package B22DCCN016;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class TongHaiSoNhiPhan{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B22DCCN016;lIQVug9S";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; long b1 = Integer.parseInt(tmp[1], 2); long b2 = Integer.parseInt(tmp[2], 2);
        long tong = b1 + b2;
        String ans = String.format("%d", tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.
b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130
d. Đóng socket và kết thúc chương trình.
*/

 
PTichTSNT.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            String tmp = "";
            for(int i = 2;i*i<=x;i++){
                while(x%i==0){
                    x/=i;
                    tmp+=String.format("%d, ", i);
                }
            }
            if(x > 1) tmp+=String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}


 
QuanLySinhVien.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a) System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>(); //key: tên môn, value: điểm thi cao nhất môn đó
        for(StudentY x: a){
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon))) hsg.put(mon, diemMon);
        }
        List<Float>diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemMax.contains(x.getScore())) ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}


 
DemSoLanXH.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a); Collections.sort(a);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(String x: ans){
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
QuanLySanPham.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}

 
SapXepChuoi.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class SapXepChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN002", qCode = "x5TIDg1S";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
LonNhoThuK.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
PhanLoaiHocLuc.java
package ws;
import vn.medianews.*;
        import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN214", qCode = "SWiWt72j"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}

 
SXTheoLen.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class SXTheoLen {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN003", qCode = "mpu9xCxR";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}
 
LietKeUoc.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int)port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer>ans = new java.util.ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0) ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
QuanLyNhanVien.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY>a = port.requestListEmployeeY(msv, qCode);
        for(EmployeeY x: a) System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}

 
LenMaxMin.java
package WebService.B21DCCN005;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "9n2rfqST";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin  = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for(String x: tmp){
            if(x.length() < lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length() > lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN005;
import java.util.*;
        import java.time.*;
        import java.time.temporal.ChronoUnit;
import vn.medianews.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x: cus) System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x: cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if(thang >=6) ans.add(x);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}

 
ChuanHoaChuoi.java

import vn.medianews.*;
        import java.util.*;
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B22DCCN214", qCode = "mcgWENCz";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        s = s.replace('_', ' ');
        String []tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for(String x: tmp) p+=chuanhoa(x);
        for(int i = 1;i<tmp.length;i++) c+=chuanhoa(tmp[i]);
        for(String x: tmp) sn+=x.toLowerCase()+"_"; sn = sn.substring(0, sn.length() - 1);
        List<String>ans = new java.util.ArrayList<>();
        ans.add(p); ans.add(c); ans.add(sn);
        System.out.println(ans);
        //c
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static String chuanhoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}

 
TimSoLonNhat.java
package WebService.B21DCCN007;
import vn.medianews.*;
        import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<String>a1 = new java.util.ArrayList<>();
        for(int x: a) a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for(String x: a1) ans+=x+ans;
        port.submitDataString(msv, qCode, ans);
    }
}

 
DaoNguoc.java
package WebService.B21DCCN008;
import vn.medianews.*;
        import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN008", qCode = "rT6Ql5GH";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
LenMaxMin2.java
package WebService.B21DCCN010;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "sGJc3iD5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for(String x: a){
            if(x.length() > Max.length()) Max = x;
            if(x.length() < Min.length()) Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyDuAn.java
package WebService.B21DCCN010;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
        import java.util.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for(Project x : a){
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if(ngay <=15 && ngay >=0 && x.getCompletionPercentage() >=80.00) send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for(Project p: send) System.out.println(p);
    }
}

 
FractoDec.java
package WebService.B21DCCN011;
import vn.medianews.*;
        import java.util.*;
public class FractoDec {
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int) (a * 100.0);
        int tmp = gcd(tu, mau); tu/=tmp; mau/=tmp;
        List<Integer> ans = new java.util.ArrayList<>();
        ans.add(tu); ans.add(mau);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
NhomTuTheoNguyenAm.java
package WebService.B21DCCN012;
import vn.medianews.*;
        import java.util.*;
public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1;i<a.size();i++){
            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN014;
import vn.medianews.*;
        import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer>a = (List<Customer>)port.requestListCustomer(msv, qCode);
        for(Customer x: a) System.out.println(x);
        List<Customer>ans = new java.util.ArrayList<>();
        for(Customer x: a){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >=5) ans.add(x);
        }
        System.out.println();
        for(Customer x: ans) System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}

 
XoayVongKyTu.java
package WebService.B21DCCN016;
import vn.medianews.*;
        import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}


 
DecToBin.java
package WebService;
import vn.medianews.*;
        import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
DonHang2.java
package WebService.B21DCCN021;
import vn.medianews.*;
        import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "CuW1L0ev";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a) System.out.println(x);
        HashMap<String, Float>mp = new HashMap<>();
        for(Order x: a){
            String maKH = x.getCustomerId(); float giaTri = x.getAmount();
            if(!mp.containsKey(maKH)) mp.put(maKH, giaTri);
            else mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0; String maKHmax = "";
        for (String maKH: mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order>ans = new java.util.ArrayList<>();
        for(Order x: a){
            if(x.getCustomerId().equals(maKHmax)) ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}

 
HeCoSo8.java
import vn.medianews.*;
        import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN214", qCode = "F9BK4f0Y";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>res = new java.util.ArrayList<>();
        for(int n: a){
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}


 
LoaiBoTrungNhau.java
package WebService.B21DCCN033;
import vn.medianews.*;
        import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
TongCacSo.java
package WebService.B21DCCN082;
import vn.medianews.*;
        import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}


 
QuanLyNhanVien2.java
package WebService.B21DCCN084;
import vn.medianews.*;
        import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10); kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for(int i = 0;i<=tmp;i++){
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue()<=5) cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}

 
SXChanLe.java
package WebService.B21DCCN088;
import vn.medianews.*;
        import java.util.*;
public class SXChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN088", qCode = "0BEtJAT9";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<Integer>chan = new java.util.ArrayList<>(), le = new java.util.ArrayList<>(), ans = new java.util.ArrayList<>();
        for(int x: a){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int k = Integer.min(chan.size(), le.size());
        for(int i = 0;i < k;i++){
            ans.add(chan.get(i)); ans.add(le.get(i));
        }
        int k1 = chan.size() - k, k2 = le.size() - k;
        if(k1 > 0){
            for(int i = k;i<chan.size();i++) ans.add(chan.get(i));
        }
        if(k2 > 0){
            for(int i = k;i<le.size();i++) ans.add(le.get(i));
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
Book.java
package RMI;
import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 20241123L;
    private String id, title, author;
    private int yearPublished, pageCount;
    private String code;
    public Book() {}
    public Book(String id, String title, String author, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", pageCount=" + pageCount +
                ", code='" + code + '\'' +
                '}';
    }
}

 
BookX.java
package RMI;
import java.io.Serializable;
public class BookX implements Serializable {
    private static final long serialVersionUID = 20241124L;
    private String id, title, author;
    private int yearPublished;
    private String genre, code;
    public BookX() {}
    public BookX(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.code = "";
    }
    //get set cứ insert tung hết ra

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + ", code=" + code + '}';
    }


}

 
Byte.java
package RMI;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class Byte {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf"); //Thay MSV mã câu hỏi tương ứng
        // b. Xử lý
        //Giả sử sau rất nhiều bước xử lý, từ mảng byte []a, các bạn thu được mảng kết quả byte []ans
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans); //Gửi lên sv, thay msv mã đề tương ứng
    }
}

 
ByteService.java
package RMI;
import java.rmi.*;
public interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
 
Character.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class Character {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6"); //Thay MSV mã đề tương ứng

        //b. Xử lý
        //Giả sử với xâu s đề cho, các bận xử lý tỉ tỉ bước, rồi xâu cuối cùng thu được là xâu res gì đấy

        //c. Gửi
        sv.submitCharacter("B21DCCN015", "0JaasIw6", res);//Gửi xâu kq lên cho sv, thay msv mã đề và tên biến kq tương ứng
    }
}

 
CharacterService.java
package RMI;
import java.rmi.*;
public interface CharacterService extends Remote {
    public String requestCharacter(String studentCode, String qCode) throws RemoteException;
    public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
 
Data.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
//Khung chung các bài làm dạng Data
public class Data {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw"); //Thay tương ứng MSV mã câu hỏi vào
        //Chú ý thay kiểu dữ liệu tương ứng và ép kiểu, cú pháp tương tự
        //Ví dụ đề bài cần String thì ghi: String x = (String)sv.requestData (MSV, mã đề)
        //Ta tiếp tục xử lý với inp nhận được...

        // b. Xử lý:
        //Tuỳ vào đề thi, các bạn sẽ cần gửi trả lại server một cái gì đấy, xâu, số, v.v..
        //Ở đây mình giả sử sau 1001 bước xử lý thì kết quả ta thu được là một biến int res chẳng hạn
        int res = 0;
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res); //Chú ý thay MSV mã đề tương ứng
    }
}

 
DataService.java
package RMI;
import java.rmi.*;
public interface DataService extends Remote {
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}

 
Employee.java
package RMI;
import java.io.Serializable;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id;
    private String name;
    private double baseSalary, finalSalary;
    private int experienceYears;
    public Employee(){}
    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
}

 
Event.java
package RMI;
import java.io.Serializable;
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode;
    private int expectedAttendance;
    public Event(){};
    public Event(String id, String eventName, String eventDate, int expectedAttendance){
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public int getExpectedAttendance() {
        return expectedAttendance;
    }
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventCode=" + eventCode + ", expectedAttendance=" + expectedAttendance + '}';
    }
}

 
Object.java
package RMI;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
//import RMI.tên lớp;
//Ví dụ
import RMI.Book;
public class Object {
    public static void main(String[] args) throws Exception{
        //a. Nhận đối tượng từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        //Tên lớp a = (Tên lớp)sv.requestObject(Mã sinh viên, Mã câu hỏi); //Chú ý ép kiểu
        //Ví dụ:
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");

        //b. Xử lý đối tượng
        //Sau bước này, ta thu được đối tượng book đã xử lý chẳng hạn

        //c. Gửi lại
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);//Thay MSV mã câu hỏi và tên đối tượng tương ứng
    }
}

 
ObjectService.java
package RMI;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qAlias) throws RemoteException;
    public void submitObject(String studentCode, String qAlias, Serializable object) throws RemoteException;
}

 
Order.java
package RMI;
import java.io.Serializable;
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    private String id, customerCode, orderDate, shippingType, orderCode;
    public Order() {}
    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public String getShippingType() {
        return shippingType;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingType=" + shippingType + ", orderCode=" + orderCode + '}';
    }
}

 
Product.java
package RMI;
import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private String id;
    private String code;
    private double importPrice;
    private double exportPrice;
    public Product() {}
    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getImportPrice() {
        return importPrice;
    }
    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                '}';
    }
}

 
ProductX.java
package RMI;
import java.io.Serializable;
public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107;
    private String id, code, discountCode;
    private int discount;
    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "ProductX [id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + "]";
    }
}

 
Student.java
package RMI;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20241130L;
    private String id;
    private String name;
    private int enrollmentYear;
    private String code;
    public Student() {}
    public Student(String id, String name, int enrollmentYear) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' + '}';
    }
}

 
Ticket.java
package RMI;
import java.io.Serializable;
public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id;
    private String eventName, saleDate, ticketCode;
    public Ticket(){}
    public Ticket(String id, String eventName, String saleDate) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
    }
    public String getEventName() {
        return eventName;
    }
    public String getSaleDate() {
        return saleDate;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}

 
ChuyenDoiBatPhan.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi bát phân
        String res = "";
        for (byte x : a) res+=String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN008", "HhPAxeDw", ans);
    }
}


 
PhepXOR1.java
package RMI;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhepXOR1 {
    public static void main(String[] args) throws Exception{
        // a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN212", "YmXQKAUX");
        System.out.println(s);
        // b. Xử lý xâu
        String []tmp = s.split(";");
        String xorKey =tmp[0], inp = tmp[1], res = "";
        for(int i = 0;i<inp.length();i++) res+=(char)(inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN008", "Xidb0Thk", res);
    }
}


 
QuanLyThuVien1.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Book;
public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)), Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code+=String.format("%02d%d%03d", book.getYearPublished()%100,
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        // c.
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);
    }
}




 
SoLonThuK.java
package RMI.B21DCCN008;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}


 
DemSoLanXH2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN012", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first) res+=", ";
                res+=String.format("\"%c\": %d", x, cnt[x]);
                cnt[x] = 0;
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN012", "ctRfIejL", res);
    }
}

 
DoiTien.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class DoiTien {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN012", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        // b. Xử lý: Tìm số đồng tiền
        String ans = "";
        int[] a = {1, 2, 5, 10};
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i];
            if (p > 0) {
                res += p;
                n -= p * a[i];
                for (int j = 0; j < p; j++) ans+=a[i] + ",";
            }
        }
        if (n > 0) ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans= String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        // c. Gửi kết quả
        sv.submitData("B21DCCN012", "Iz06p8Zw", ans);
    }
}



 
PhepXOR2.java
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN012", "4BraNTI5");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b. Mã hoá
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes(); // Chuyển khóa thành mảng byte
        byte[] maHoa = new byte[a.length];
        for(int i = 0;i<a.length;i++) maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for(byte x: maHoa) System.out.print(x + " ");
        //c. Gửi
        sv.submitData("B21DCCN012", "4BraNTI5", maHoa);
    }
}

 
QuanLyThuVien2.java
package RMI.B21DCCN012;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.BookX;
public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B21DCCN012", "CoWosBho");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code+=String.format("%02d%d%d", book.getYearPublished()%100,
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c.
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}

 
ChuyenDoiLaMaThapPhan.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6");
        System.out.println(s);
        //c. Gửi
        System.out.println(change(s));
        sv.submitCharacter("B21DCCN015", "0JaasIw6", String.valueOf(change(s)));
    }
}


 
GiaiMaBase64.java
package RMI.B21DCCN015;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception{
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN015", "oeJljCIf");
        // b. Giải mã
        String s = new String(a);  //Byte -->String
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s);  // Giải mã Base64
        for (byte x: ans) System.out.print(x + " ");
        System.out.println();
        // c.
        sv.submitData("B21DCCN015", "oeJljCIf", ans);
    }
}



 
LietKeSoNguyenTo.java
package RMI.B21DCCN015;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        // b. Xử lý: Tìm list các SNT
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i<=N;i++){
            if(check(i)==1) res.add(i);
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN015", "NMATI6Zw", res);
    }
    public static int check(int n){//ktra snt
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}

 
PhuongSai.java
package RMI.B21DCCN016;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class PhuongSai {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        System.out.println(s);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp) a.add(Double.parseDouble(x));
        int n = a.size();
        double tong = 0, tongTmp = 0;
        for (double x : a) tong += x;
        double tbc = tong / (double) n;
        for (double x : a) tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        // c. Gửi kết quả
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B21DCCN016", "uZMEY3Zg", res);
    }
}
 
LietKeSoDoiXung.java
package RMI.B21DCCN021;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoDoiXung {
    public static boolean check(int x){
        String s = x+"";
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN021", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String []tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer>a = new ArrayList<>();
        for(int i = n;i<k;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN021", "t3cBY2uk", a);
    }
}

 
MaHoaVigen.java
package RMI.B21DCCN021;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.CharacterService;
public class MaHoaVigen {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN021", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for(int i = 0;i<text.length();i++){
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x)) z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans+=z;
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN021", "Y7YMXHs4", ans);
    }
}

 
TDMT.java
package RMI.B21DCCN021;
import RMI.Order;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
public class TDMT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B21DCCN021", "vLJWvWpf");
        System.out.println(order);
        //b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        //c
        System.out.println(order);
        sv.submitObject("B21DCCN021", "vLJWvWpf", order);
    }
}


 
MaHoaCaesar1.java
package RMI.B21DCCN022;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN022", "j4rStb2a");
        System.out.println(s);
        //b.
        String ans = "";
        int dich = s.length()%7;
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans+=x;
        }
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN022", "j4rStb2a", ans);
    }
}

 
PhanTichTSNT.java
package RMI.B21DCCN022;
import java.util.*;
        import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhanTichTSNT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN022", "zzmmquoc");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                a.add(i);
                n/=i;
            }
        }
        if(n>1) a.add(n);
        System.out.println(a);
        sv.submitData("B21DCCN022", "zzmmquoc", a);
    }
}

 
QuanLySinhVien.java
package RMI.B21DCCN023;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Student;
public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoa2(String s){
        String []tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = 0;i<tmp.length - 1;i++) res+=chuanhoa(tmp[i]) + " ";
        res+=tmp[tmp.length - 1].toUpperCase();
        return res;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B21DCCN023", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear()%100);
        String []tmp = student.getName().split("\\s+");
        code+=tmp[tmp.length - 1].toUpperCase() + "_";
        for(int i = 0;i<tmp.length - 1;i++) code+=Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        //c.
        sv.submitObject("B21DCCN023", "lNV6xzmk", student);
    }
}

 
LietKeSoCP.java
package RMI.B21DCCN028;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoCP {
    public static boolean check(int x){
        double y = Math.sqrt(x);
        int y1 = (int)y;
        return y == y1;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN028", "eTHcAYZh");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN028", "eTHcAYZh", a);
    }
}
 
MaHoaCaesar2.java
package RMI.B21DCCN028;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN028", "i0EVI2TB");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++) a[i]+=doDich;
        for(byte x: a) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "i0EVI2TB", a);
    }
}

 
MaHoaBase64.java
package RMI.B21DCCN029;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN029", "psd4Jmnt");
        System.out.println(s);
        //
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        //
        sv.submitCharacter("B21DCCN029", "psd4Jmnt", ans);
    }
}

 
SapXepChanLe.java
package RMI.B21DCCN029;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN029", "A7hytb1V");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. sx
        byte []res = new byte[a.length];
        int idx = 0;
        for(byte x: a){
            if(x % 2==0)  res[idx++] = x;
        }
        for(byte x: a){
            if(x % 2==1)  res[idx++] = x;
        }
        for(byte x: res) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "A7hytb1V", res);
    }
}

 
ToChucSuKien.java
package RMI.B21DCCN029;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Event;
public class ToChucSuKien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B21DCCN029", "FKrGvwLM");
        System.out.println(event);
        //b.
        String ans = "";
        int x = event.getExpectedAttendance();
        //
        if(x>=1000) ans = "L";
        else if (x>=500 && x<=999) ans = "M";
        else ans = "S";
        //
        String []tmp = event.getEventName().trim().split("\\s+");
        ans+=Character.toUpperCase(tmp[0].charAt(0));
        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1));
        //
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String []tmp2 = tmp1.trim().split("\\s+");
        ans+=tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        //c.
        System.out.println(event);
        sv.submitObject("B21DCCN029", "FKrGvwLM", event);
    }
}

 
ChuyenDoiThapPhanLaMa.java
package RMI.B21DCCN032;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ChuyenDoiThapPhanLaMa {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN032", "ADu6zRYE");
        System.out.println(s);
        //b.
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//thập phân
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};// la mã
        for(int i = 0;i<tp.length;i++){
            while(dec >=tp[i]){
                rm+=lm[i];
                dec-=tp[i];
            }
        }
        System.out.println(rm);
        //c.
        sv.submitCharacter("B21DCCN032", "ADu6zRYE", rm);
    }
}

 
MaHoaHexa.java
package RMI.B21DCCN032;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN032", "pK0IZNnt");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi hexa
        String res = "";
        for (byte x : a) res+=String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN032", "pK0IZNnt", ans);
    }
}


 
NenRLE.java
package RMI.B21DCCN036;
import java.util.*;
        import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ByteService;
public class NenRLE {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b.
        int cnt = 1;
        ArrayList<Byte>res = new ArrayList<>();
        for(int i = 1;i<a.length;i++){
            if(a[i] == a[i - 1]) cnt++;
            else{
                res.add(a[i - 1]); res.add((byte)cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]); res.add((byte)cnt);
        //Cóp sang mảng
        byte []ans = new byte[res.size()];
        int idx = 0;
        for(byte x: res) ans[idx++] = x;
        for(byte x: ans) System.out.print(x + " ");
        sv.submitData("B21DCCN036", "2uG0lQGi", ans);
    }
}

 
QuanLyNhanVien.java
package RMI.B21DCCN038;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Employee;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B21DCCN038", "7fSWnlHB");
        System.out.println(employee);
        //b.tổng cs
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while(x>0){
            tongCS+=x%10;
            x/=10;
        }
        //tổng ước
        int soUoc = 0;
        for(int i = 1;i<=y;i++){
            if(y%i==0) soUoc++;
        }
        //factor
        double factor = (double)(employee.getExperienceYears() + tongCS + soUoc)/100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        //
        employee.setFinalSalary(Final);
        System.out.println(employee);
        //c.
        sv.submitObject("B21DCCN038", "7fSWnlHB", employee);
    }
}

 
QuanLySuKien.java
package RMI.B21DCCN048;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;
public class QuanLySuKien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B21DCCN048", "Uct8bABt");
        //Ticket ticket = new Ticket(1, "Charity Concert", "15/06/2024");
        System.out.println(ticket);
        //Lấy tên
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res+=String.format("%c%c", Character.toUpperCase(s.charAt(0)), (char)Character.toUpperCase(s.charAt(s.length() - 1)));
        //Lấy ngày sinh
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String []tmp = s1.trim().split("\\s+");
        res+=tmp[1] + tmp[0];
        //Lấy 2 chữ số
        Set<Integer>si = new HashSet<>();
        for(char x: s1.toCharArray()){
            if(Character.isDigit(x)) si.add(x - '0');
        }
        for(int i = 9;i >= 0;i--){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        for(int i = 0;i<=9;i++){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        //c.
        sv.submitObject("B21DCCN048", "Uct8bABt", ticket);
    }
}


 
MaHoaURL.java
package RMI.B21DCCN053;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import java.net.URLEncoder;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
}
//Sửa đề xong thì chịu không biết AC kiểu gì??

 
SinhToHop.java
package RMI.B21DCCN053;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class SinhToHop {
    static int ok;
    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++) a[i] = i;
    }
    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3";
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());// Lấy số k
        // Lấy ra mảng và sắp xếp
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp) a.add(Integer.parseInt(x));
        // Bắt đầu sinh tổ hợp. Khởi tạo
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        // Duyệt qua từng tổ hợp chỉ số
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++) tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        //c.
        System.out.println(ans);
        sv.submitData("B21DCCN053", "juC3u7C6", ans);
    }
}

 
LonThuK.java
package RMI.B21DCCN066;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class LonThuK {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN066", "uIKHCTWG");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b.
        byte []b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for(int i = 0;i<b.length;i++){
            if(b[i]==a[a.length - k]){
                pos = i;
                break;
            }
        }
        byte []ans = {(byte)a[a.length - k], (byte)(pos + 1)};
        for(byte x: ans) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN066", "uIKHCTWG", ans);
    }
}

 
BoBaPytago.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        System.out.println(N);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}

 
XHMax.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN319", "1mPMIkGJ");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128];
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B21DCCN319", "1mPMIkGJ", res);
    }
}

 
XuLySanPham1.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.Product;
public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN214", "vy7Cq1hJ");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        sv.submitObject("B22DCCN214", "vy7Cq1hJ", product);
    }
}

 
XuLyVanBan.java
package RMI.B21DCCN319;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN319", "NFldNPp6");
        System.out.println(s);
        // b. Xử lý xâu
        s = s.replace("\"", "");  s = s.replace("{", "");  s = s.replace("}", "");
        String[] tmp = s.trim().split(",");// Tách chuỗi thành các cặp key-value
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim();
            if (i % 2 == 0) {
                if (chan.length() > 0) chan+=", ";
                chan+=tmp[i];
            } else {
                if (le.length() > 0) le+=", ";
                le+=tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN319", "NFldNPp6", res);
    }
}

 
DemSoLanXH1.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.CharacterService;
public class DemSoLanXH1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN564", "U5BEBBOW");
        System.out.println(s);
        // b. Xử lý xâu
        String res = "";
        int[] cnt = new int[256];
        for (char x : s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=String.format("%c%d", x, cnt[x]);
                cnt[x] = 0;
            }
        }
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN564", "U5BEBBOW", res);
    }
}



 
HoanViTiepTheo.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.DataService;
public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN564", "3Qe0Qb5w");
        System.out.println(s);
        //Đẩy hết vào mảng để xử lý
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        //b. Sinh hoán vị kế tiếp
        // Bước 1: Tìm vị trí đầu tiên từ cuối mà tại đó nó nhỏ hơn số đằng sau nó
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        // Bước 2: Kiểm tra nếu không còn hoán vị nào lớn hơn
        if (i < 0) Collections.sort(a); // Đưa về hoán vị đầu tiên
        else {
            // Bước 3: Tìm vị trí đầu tiên từ cuối lớn hơn a[i]
            int j = n - 1;
            while (a.get(j) <= a.get(i)) j--;
            Collections.swap(a, i, j);// Hoán đổi a[i] và a[j]
            // Bước 4: Lật ngược đoạn từ i + 1 đến cuối mảng
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for(int x: a) res+=String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN564", "3Qe0Qb5w", res);
    }
}


 
XHMin.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import java.util.*;
        import RMI.ByteService;
public class XHMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN564", "L7A2NPQU");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005];
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN564", "L7A2NPQU", res);
    }
}
 
XuLySanPham2.java
package RMI.B21DCCN564;
import java.rmi.*;
        import java.rmi.registry.*;
        import RMI.ObjectService;
import RMI.ProductX;
public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B21DCCN564", "PY43T66m");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for(char x: product.getDiscountCode().toCharArray()){
            if(Character.isDigit(x)) tong+=Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại server
        System.out.println(product);
        sv.submitObject("B21DCCN564", "PY43T66m", product);
    }
}




 
Address.java
package TCP;
import java.io.*;
public class Address implements Serializable{
    private static final long serialVersionUID = 20180801L;
    private int id;
    private String code, addressLine, city, postalCode;
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", code=" + code + ", addressLine=" + addressLine + ", city=" + city + ", postalCode=" + postalCode + '}';
    }
}

 
Customer.java
package TCP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20170711L; // Theo yêu cầu của đề bài
    private int id;
    private String code, name, dayOfBirth, userName;
    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

 
Laptop.java
package TCP;
import java.io.*;
public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    private int id;
    private String code, name;
    private int quantity;
    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
Product.java
package TCP;
import java.io.*;
public class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    private int id, discount;
    private double price;
    private String name;
    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }
}

 
SanPham.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Product;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN370;151GNZvT";
        out.writeObject(code);
        out.flush();
        //b.
        Product product = (Product) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        int x = (int) product.getPrice();
        int tong = 0;
        while(x > 0){
            tong+=x%10;
            x/=10;
        }
        product.setDiscount(tong);
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        //Đóng kết nối, chú ý là phải có phần này nếu không sẽ bị máy chấm ngoại lệ
        in.close();
        out.close();
        socket.close();
    }
}

 
SinhVien.java
package TCP;
import java.io.*;
        import java.net.*;
        import TCP.Student;
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN222;j5ELZdmS";
        out.writeObject(code);
        out.flush();
        //b.
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien ban dau: " + student);
        //c.
        float x = student.getGpa();
        if (x >= 3.7) student.setGpaLetter("A");
        else if (x >= 3.0) student.setGpaLetter("B");
        else if (x >= 2.0) student.setGpaLetter("C");
        else if (x >= 1.0) student.setGpaLetter("D");
        else student.setGpaLetter("F");
        //d.
        System.out.println("Sinh vien luc sau: " + student);
        out.writeObject(student);
        out.flush();
    }
}
 
Student.java
package TCP;
import java.io.*;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, gpaLetter;
    private float gpa;
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
    @Override
    public String toString() {
        return this.id + " " + this.code + " " + this.gpa + " " + this.gpaLetter;
    }
}

 
Book.java
package UDP;
import java.io.*;
public class Book implements Serializable{
    private static final long serialVersionUID = 20251107L;
    private String id, title, author, isbn, publishDate;
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publishDate=" + publishDate + '}';
    }
}

 
Customer.java
package UDP;
import java.io.Serializable;
public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;
    private String id;
    private String code, name, dayOfBirth, userName;
    public Customer(String id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
 
Employee.java
package UDP;
import java.io.*;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    private String id, name, hireDate;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
}

 
Product.java
package UDP;
import java.io.*;
public class Product implements Serializable {
    private static final long serialVersionUID = 20161107;
    private String id, code, name;
    private int quantity;
    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
 
SanPham.java
package UDP;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/


 
Student.java
package UDP;
import java.io.Serializable;
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    private String id, code, name, email;
    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", name=" + name + ", email=" + email + '}';
    }
}

 
KhachHang.java
package UDP.B17DCAT176;
import UDP.Customer;
import java.io.*;
        import java.net.*;
public class KhachHang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B17DCAT176;OH7rzusB";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String []tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi+=tenTmp[tenTmp.length - 1].toUpperCase()+", ";
        for(int i = 0;i<tenTmp.length - 1;i++) tenMoi+=Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        //Chuẩn hoá ngày sinh
        String []nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        //Tạo username
        String userMoi = "";
        for(int i = 0;i<tenTmp.length - 1;i++) userMoi+=Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi+=tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
LietKeSNT.java
package UDP.B17DCAT176;
import java.net.*;
public class LietKeSNT {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B17DCAT176;78CCQ6xD";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1];int n = Integer.parseInt(s1.trim());
        //
        String ans = "";int cnt = 0;
        for(int i = 2;i<=1000000;i++){
            if(check(i)){
                cnt++;
                ans+=String.format("%d,", i);
                if(cnt==n) break;
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
    public static boolean check(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

 
ChuanHoaXauKyTu.java
package UDP.B21DCCN001;
import java.net.*;
public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;NRVwBVvx";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Chuẩn hoá
        String []tmpS = s.trim().split("\\s+");
        s = "";
        for(String x: tmpS) s+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res = rI + ";" + s;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}


 
DemSoLanXH.java
package UDP.B21DCCN001;
import java.net.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String res = ""; int []cnt = new int[10005];
        for(char x: s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x]>0){
                res+=String.format("%d%c", cnt[x], x);
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
QLSinhVien.java
package UDP.B21DCCN001;
import UDP.Student;
import java.io.*;
        import java.net.*;
public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;QABGDFxd";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        System.out.println(student);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for(String x: words) name+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        //Tạo email
        String email = words[words.length - 1].toLowerCase();
        for(int i = 0;i<words.length - 1;i++) email+=Character.toLowerCase(words[i].charAt(0));
        email+="@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
 
SanPham.java
package UDP.B21DCCN001;
import UDP.Product;
import java.io.*;
        import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;OX8O73nD ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/

 
TimSoConThieu.java
package UDP.B21DCCN001;
import java.net.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;XdHHmyiv";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []sTmp = s.trim().split(";");
        String rI = sTmp[0]; int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split(",");
        for(int i = 0;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
TongCacChuSo.java
package UDP.B21DCCN001;
import java.net.*;
public class TongCacChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;0Iend7Pp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int tong = 0;
        for(char x: s.toCharArray()) tong+=(x - '0');
        String res = String.format("%s;%d", rI, tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
LocKyTu.java
package UDP.B21DCCN002;
import java.net.*;
public class LocKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN002;EbTMtFBH";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        int []cnt = new int[10005];
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        String res = "";
        for(char x: s.toCharArray()){
            if(cnt[x] > 0){
                res+=x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
MaHoaCaesar.java
package UDP.B21DCCN003;
import java.net.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN003;vNIIU53V";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1]; int doDich = Integer.parseInt(sTmp[2].trim());
        //
        String ans = "";
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans+=x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
XHMax.java
package UDP.B21DCCN003;
import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN003;KFPR3GWV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
ChuanHoaThongTinSach.java
package B21DCCN005_HE;
import UDP.Book;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoaTitle(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaISBN(String s){
        //Ví dụ: Input: 9783161484100. Ouput: 978-3-16-148410-0
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6), s.substring(6, 12), s.substring(12));
    }
    public static String chuanhoaAuthor(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for(int i = 1;i < tmp.length; i++) ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
QuanLyTTNhanVien.java
package B21DCCN005_HE;
import UDP.Employee;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaTen(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0];
    }
    //Đã chuẩn hoá ngày rồi thì muốn tăng phải lấy theo ngày đã chuẩn hoá
    public static double tangLuong (String ngay, double luongCu){
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray()) tong += c - '0';
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;ySsumsIE";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

 
SapXepTuDienNguoc.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;9UfU4Vky";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<String> a = new ArrayList <>();
        for(int i = 1; i < tmp1.length; i++) a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for(String x: a) res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
//Phải đưa về cùng một kiểu rồi mới sắp xếp được

 
TongSoNguyenLon.java
package B21DCCN005_HE;
import java.io.*;
        import java.math.BigInteger;
import java.net.*;
        import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;2sIjAYaU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}

 
HieuHaiTapTu.java
package UDP.B21DCCN020;
import java.net.*;
public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN020;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1], s2 = sTmp[2];
        //
        String ans = "";
        int []cnt = new int[10005];
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}

 
CuaSoTruot.java
package B22DCCN007;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN007;iv00Hrq6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        System.out.println(st);
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; int n = Integer.parseInt(tmp[1]), k = Integer.parseInt(tmp[2]);
        //Cho các số còn lại vào mảng
        ArrayList<Integer>a = new ArrayList<>();
        for(int i = 3; i < tmp.length; i++) a.add(Integer.parseInt(tmp[i]));
        //Tạo String kết quả
        String ans = rqID + ";";
        //en - st + 1 = k -> st = en + 1 - k. en_max = n - 1 -> st_max = n - 1 + 1 - k = n - k
        for(int i = 0; i <=  n - k; i++){
            int Max = a.get(i);//Max mỗi đoạn con
            for(int j = i + 1; j <= i + k - 1; j++){ //en = st + k - 1
                if(a.get(j) > Max) Max = a.get(j);
            }
            ans += String.format("%d,", Max);
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.
c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"
d. Đóng socket và kết thúc chương trình.
*/

 
SXTheoVTGoc.java
package B22DCCN015;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class SXTheoVTGoc{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN015;aKZwZxWk";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0];
        //Cho các xâu còn lại vào mảng
        TreeMap<Integer, String> mp = new TreeMap<>();
        for(int i = 1; i < tmp.length; i++){
            String []tmp_i = tmp[i].split(":");
            mp.put(Integer.parseInt(tmp_i[1]), tmp_i[0]);
        }
        //Tạo kết quả
        String ans = rqID + ";";
        int ok = 0;//ok = 1: Là xâu đầu
        for(String x: mp.values()){
            if(ok == 1) ans += ",";
            ans += x; ok = 1;
        }
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"
d. Đóng socket và kết thúc chương trình.
*/

 
TongHaiSoNhiPhan.java
package B22DCCN016;
import java.io.*;
        import java.net.*;
        import java.util.*;
public class TongHaiSoNhiPhan{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B22DCCN016;lIQVug9S";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; long b1 = Integer.parseInt(tmp[1], 2); long b2 = Integer.parseInt(tmp[2], 2);
        long tong = b1 + b2;
        String ans = String.format("%d", tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.
b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130
d. Đóng socket và kết thúc chương trình.
*/

 
PTichTSNT.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            String tmp = "";
            for(int i = 2;i*i<=x;i++){
                while(x%i==0){
                    x/=i;
                    tmp+=String.format("%d, ", i);
                }
            }
            if(x > 1) tmp+=String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}


 
QuanLySinhVien.java
package WebService.B21DCCN001;
import vn.medianews.*;
        import java.util.*;
public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a) System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>(); //key: tên môn, value: điểm thi cao nhất môn đó
        for(StudentY x: a){
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon))) hsg.put(mon, diemMon);
        }
        List<Float>diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemMax.contains(x.getScore())) ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}


 
DemSoLanXH.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a); Collections.sort(a);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(String x: ans){
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
QuanLySanPham.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}

 
SapXepChuoi.java
package WebService.B21DCCN002;
import vn.medianews.*;
        import java.util.*;
public class SapXepChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN002", qCode = "x5TIDg1S";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
LonNhoThuK.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
PhanLoaiHocLuc.java
package ws;
import vn.medianews.*;
        import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN214", qCode = "SWiWt72j"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}

 
SXTheoLen.java
package WebService.B21DCCN003;
import vn.medianews.*;
        import java.util.*;
public class SXTheoLen {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN003", qCode = "mpu9xCxR";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}
 
LietKeUoc.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int)port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer>ans = new java.util.ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0) ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
QuanLyNhanVien.java
package WebService.B21DCCN004;
import vn.medianews.*;
        import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY>a = port.requestListEmployeeY(msv, qCode);
        for(EmployeeY x: a) System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}

 
LenMaxMin.java
package WebService.B21DCCN005;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "9n2rfqST";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin  = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for(String x: tmp){
            if(x.length() < lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length() > lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN005;
import java.util.*;
        import java.time.*;
        import java.time.temporal.ChronoUnit;
import vn.medianews.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x: cus) System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x: cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if(thang >=6) ans.add(x);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}

 
ChuanHoaChuoi.java

import vn.medianews.*;
        import java.util.*;
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B22DCCN214", qCode = "mcgWENCz";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        s = s.replace('_', ' ');
        String []tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for(String x: tmp) p+=chuanhoa(x);
        for(int i = 1;i<tmp.length;i++) c+=chuanhoa(tmp[i]);
        for(String x: tmp) sn+=x.toLowerCase()+"_"; sn = sn.substring(0, sn.length() - 1);
        List<String>ans = new java.util.ArrayList<>();
        ans.add(p); ans.add(c); ans.add(sn);
        System.out.println(ans);
        //c
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static String chuanhoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}

 
TimSoLonNhat.java
package WebService.B21DCCN007;
import vn.medianews.*;
        import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<String>a1 = new java.util.ArrayList<>();
        for(int x: a) a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for(String x: a1) ans+=x+ans;
        port.submitDataString(msv, qCode, ans);
    }
}

 
DaoNguoc.java
package WebService.B21DCCN008;
import vn.medianews.*;
        import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN008", qCode = "rT6Ql5GH";
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
LenMaxMin2.java
package WebService.B21DCCN010;
import vn.medianews.*;
        import java.util.*;
public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "sGJc3iD5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for(String x: a){
            if(x.length() > Max.length()) Max = x;
            if(x.length() < Min.length()) Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}

 
QuanLyDuAn.java
package WebService.B21DCCN010;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
        import java.util.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for(Project x : a){
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if(ngay <=15 && ngay >=0 && x.getCompletionPercentage() >=80.00) send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for(Project p: send) System.out.println(p);
    }
}

 
FractoDec.java
package WebService.B21DCCN011;
import vn.medianews.*;
        import java.util.*;
public class FractoDec {
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int) (a * 100.0);
        int tmp = gcd(tu, mau); tu/=tmp; mau/=tmp;
        List<Integer> ans = new java.util.ArrayList<>();
        ans.add(tu); ans.add(mau);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}


 
NhomTuTheoNguyenAm.java
package WebService.B21DCCN012;
import vn.medianews.*;
        import java.util.*;
public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1;i<a.size();i++){
            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}

 
QuanLyKhachHang.java
package WebService.B21DCCN014;
import vn.medianews.*;
        import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer>a = (List<Customer>)port.requestListCustomer(msv, qCode);
        for(Customer x: a) System.out.println(x);
        List<Customer>ans = new java.util.ArrayList<>();
        for(Customer x: a){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >=5) ans.add(x);
        }
        System.out.println();
        for(Customer x: ans) System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}

 
XoayVongKyTu.java
package WebService.B21DCCN016;
import vn.medianews.*;
        import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}


 
DecToBin.java
package WebService;
import vn.medianews.*;
        import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}

 
DonHang2.java
package WebService.B21DCCN021;
import vn.medianews.*;
        import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "CuW1L0ev";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a) System.out.println(x);
        HashMap<String, Float>mp = new HashMap<>();
        for(Order x: a){
            String maKH = x.getCustomerId(); float giaTri = x.getAmount();
            if(!mp.containsKey(maKH)) mp.put(maKH, giaTri);
            else mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0; String maKHmax = "";
        for (String maKH: mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order>ans = new java.util.ArrayList<>();
        for(Order x: a){
            if(x.getCustomerId().equals(maKHmax)) ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}

 
HeCoSo8.java
import vn.medianews.*;
        import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN214", qCode = "F9BK4f0Y";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>res = new java.util.ArrayList<>();
        for(int n: a){
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}


 
LoaiBoTrungNhau.java
package WebService.B21DCCN033;
import vn.medianews.*;
        import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}

 
TongCacSo.java
package WebService.B21DCCN082;
import vn.medianews.*;
        import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}


 
QuanLyNhanVien2.java
package WebService.B21DCCN084;
import vn.medianews.*;
        import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10); kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for(int i = 0;i<=tmp;i++){
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue()<=5) cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}

 
SXChanLe.java
package WebService.B21DCCN088;
import vn.medianews.*;
        import java.util.*;
public class SXChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN088", qCode = "0BEtJAT9";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<Integer>chan = new java.util.ArrayList<>(), le = new java.util.ArrayList<>(), ans = new java.util.ArrayList<>();
        for(int x: a){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int k = Integer.min(chan.size(), le.size());
        for(int i = 0;i < k;i++){
            ans.add(chan.get(i)); ans.add(le.get(i));
        }
        int k1 = chan.size() - k, k2 = le.size() - k;
        if(k1 > 0){
            for(int i = k;i<chan.size();i++) ans.add(chan.get(i));
        }
        if(k2 > 0){
            for(int i = k;i<le.size();i++) ans.add(le.get(i));
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}



