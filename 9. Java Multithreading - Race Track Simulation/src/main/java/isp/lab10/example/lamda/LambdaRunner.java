package isp.lab10.example.lamda;

public class LambdaRunner {
    public static void main(String[] args) {
        Printable printable1 = new Printer();
        printable1.print();

        Printable printable2 = new Printer(){
            @Override
            public void print() {
                System.out.println("Printing from anonymous class");
            }
        };
        printable2.print();

        Printable printable3 = () -> System.out.println("Printing from lambda expression");
        printable3.print();
    }
}
