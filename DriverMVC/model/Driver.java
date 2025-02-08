import java.time.LocalDate;

public class Driver {
    private String licenseNumber;
    private String driverType;
    private LocalDate birthDate;
    private String licenseStatus;

    public Driver(String licenseNumber, String driverType, LocalDate birthDate, String licenseStatus) {
        this.licenseNumber = licenseNumber;
        this.driverType = driverType;
        this.birthDate = birthDate;
        this.licenseStatus = licenseStatus;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getDriverType() {
        return driverType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public void setDriverType(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setDriverType'");
    }
}
