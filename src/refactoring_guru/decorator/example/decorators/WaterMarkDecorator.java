package refactoring_guru.decorator.example.decorators;

public class WaterMarkDecorator extends DataSourceDecorator {
    private String waterMark = "12\n\n##System default water mark##";

    public WaterMarkDecorator(DataSource source) {
        super(source);
    }

    public void setWaterMark(String waterMark) {
        this.waterMark = waterMark;
    }

    @Override
    public void writeData(String data) {
        super.writeData(addWaterMark(data));
    }

    @Override
    public String readData() {
        return removeWaterMark(super.readData());
    }

    private String addWaterMark(String data) {
        return data + this.waterMark;
    }

    private String removeWaterMark(String data) {
        return data.substring(0, data.length() - waterMark.length());
    }
}
