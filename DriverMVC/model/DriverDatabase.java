import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverDatabase {
    private List<Driver> drivers;

    public DriverDatabase() {
        drivers = new ArrayList<>();
        generateSampleData();
    }

    private void generateSampleData() {
        
        drivers.add(new Driver("678912345", "บุคคลทั่วไป", LocalDate.of(1965, 1, 13), "ปกติ"));
        drivers.add(new Driver("789123456", "บุคคลทั่วไป", LocalDate.of(1955, 12, 30), "ปกติ"));
        drivers.add(new Driver("891234567", "บุคคลทั่วไป", LocalDate.of(1975, 4, 9), "ปกติ"));
        drivers.add(new Driver("912345678", "บุคคลทั่วไป", LocalDate.of(1980, 9, 17), "ปกติ"));
        drivers.add(new Driver("123456780", "บุคคลทั่วไป", LocalDate.of(1962, 11, 2), "ปกติ"));
        drivers.add(new Driver("345678912", "บุคคลทั่วไป", LocalDate.of(1948, 7, 10), "หมดอายุ"));
        drivers.add(new Driver("123456789", "บุคคลทั่วไป", LocalDate.of(1950, 5, 12), "หมดอายุ"));
        drivers.add(new Driver("234567891", "บุคคลทั่วไป", LocalDate.of(1945, 2, 23), "หมดอายุ"));
        drivers.add(new Driver("345678912", "บุคคลทั่วไป", LocalDate.of(1948, 7, 10), "หมดอายุ"));
        drivers.add(new Driver("456789123", "บุคคลทั่วไป", LocalDate.of(2010, 3, 18), "ถูกระงับ"));
        drivers.add(new Driver("567891234", "บุคคลทั่วไป", LocalDate.of(2012, 9, 5), "ถูกระงับ"));
        drivers.add(new Driver("678912345", "บุคคลทั่วไป", LocalDate.of(1985, 7, 10), "ปกติ"));

        drivers.add(new Driver("112345678", "มือใหม่", LocalDate.of(2005, 5, 25), "ปกติ"));
        drivers.add(new Driver("122345678", "มือใหม่", LocalDate.of(1995, 6, 15), "ปกติ"));
        drivers.add(new Driver("132345678", "มือใหม่", LocalDate.of(1990, 7, 5), "ปกติ"));
        drivers.add(new Driver("142345678", "มือใหม่", LocalDate.of(1985, 8, 25), "ปกติ"));
        drivers.add(new Driver("152345678", "มือใหม่", LocalDate.of(1992, 9, 15), "ปกติ"));
        drivers.add(new Driver("162345678", "มือใหม่", LocalDate.of(1998, 10, 10), "ปกติ"));
        drivers.add(new Driver("172345678", "มือใหม่", LocalDate.of(1999, 11, 1), "ปกติ"));
        drivers.add(new Driver("182345678", "มือใหม่", LocalDate.of(2000, 3, 30), "ปกติ"));
        drivers.add(new Driver("192345678", "มือใหม่", LocalDate.of(2002, 12, 12), "ปกติ"));
        drivers.add(new Driver("102345678", "มือใหม่", LocalDate.of(2003, 4, 4), "ปกติ"));
        drivers.add(new Driver("98765432", "มือใหม่", LocalDate.of(1965, 10, 11), "ปกติ"));

        drivers.add(new Driver("212345678", "คนขับรถสาธารณะ", LocalDate.of(1975, 1, 10), "ปกติ"));
        drivers.add(new Driver("222345678", "คนขับรถสาธารณะ", LocalDate.of(1980, 3, 22), "ปกติ"));
        drivers.add(new Driver("232345678", "คนขับรถสาธารณะ", LocalDate.of(1965, 7, 18), "ปกติ"));
        drivers.add(new Driver("242345678", "คนขับรถสาธารณะ", LocalDate.of(1955, 9, 12), "ปกติ"));
        drivers.add(new Driver("252345678", "คนขับรถสาธารณะ", LocalDate.of(1988, 6, 30), "ปกติ"));
        drivers.add(new Driver("262345678", "คนขับรถสาธารณะ", LocalDate.of(1972, 10, 1), "ปกติ"));
        drivers.add(new Driver("272345678", "คนขับรถสาธารณะ", LocalDate.of(1960, 11, 17), "ปกติ"));
        drivers.add(new Driver("282345678", "คนขับรถสาธารณะ", LocalDate.of(1978, 12, 4), "ปกติ"));
        drivers.add(new Driver("292345678", "คนขับรถสาธารณะ", LocalDate.of(1990, 2, 22), "ปกติ"));
        drivers.add(new Driver("202345678", "คนขับรถสาธารณะ", LocalDate.of(1985, 8, 5), "ปกติ"));
    }

    public Driver getDriverByLicenseNumber(String licenseNumber) {
        return drivers.stream().filter(d -> d.getLicenseNumber().equals(licenseNumber)).findFirst().orElse(null);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public long countDriversByType(String type) {
        return drivers.stream().filter(d -> d.getDriverType().equals(type)).count();
    }
}
