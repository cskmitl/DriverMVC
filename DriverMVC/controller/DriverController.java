import java.time.LocalDate;

public class DriverController {
    private DriverDatabase model;
    private DriverView view;

    public DriverController(DriverDatabase model, DriverView view) {
        this.model = model;
        this.view = view;
    }

    public void checkDriver(String licenseNumber) {
        if (!licenseNumber.matches("[1-9][0-9]{8}")) {
            view.displayError("หมายเลขใบขับขี่ไม่ถูกต้อง!");
            return;
        }

        Driver driver = model.getDriverByLicenseNumber(licenseNumber);
        if (driver == null) {
            view.displayError("ไม่พบหมายเลขใบขับขี่นี้ในระบบ!");
            return;
        }

        LocalDate birthDate = driver.getBirthDate();
        int age = driver.calculateAge();
        
        if (age < 16) {
            driver.setLicenseStatus("ถูกระงับ");
        } else if (("บุคคลทั่วไป".equals(driver.getDriverType()) && age > 70) ||
                   ("มือใหม่".equals(driver.getDriverType()) && age > 50) ||
                   ("คนขับรถสาธารณะ".equals(driver.getDriverType()) && age > 60)) {
            driver.setLicenseStatus("หมดอายุ");
        }
        view.displayDriverInfo(driver);
    }

    public void generateReport() {
        long generalDrivers = model.countDriversByType("บุคคลทั่วไป");
        long newDrivers = model.countDriversByType("มือใหม่");
        long publicDrivers = model.countDriversByType("คนขับรถสาธารณะ");

        view.displayReport(generalDrivers, newDrivers, publicDrivers);
    }
}
