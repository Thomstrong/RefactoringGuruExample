package refactoring_guru.decorator.example;

import refactoring_guru.decorator.example.decorators.*;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new WaterMarkDecorator(
                new CompressionDecorator(
                        new EncryptionDecorator(
                                new FileDataSource("out/OutputDemo.txt"))));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        DataSource watermarkText = new WaterMarkDecorator(new FileDataSource("out/watermarkDemo.txt"));
        watermarkText.writeData(salaryRecords);

        DataSource watermarkPlan = new FileDataSource("out/watermarkDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
        System.out.println("- Add watermark --------------");
        System.out.println(watermarkPlan.readData());
    }
}
