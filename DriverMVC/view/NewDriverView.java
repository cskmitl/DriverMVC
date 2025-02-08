import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class NewDriverView extends JFrame {
    private Driver driver;
    private JLabel statusLabel;
    private JButton writtenTestButton;
    private JButton practicalTestButton;
    private boolean writtenTestDone = false;
    private boolean practicalTestDone = false;

    public NewDriverView(Driver driver) {
        this.driver = driver;

        setTitle("ข้อมูลผู้ขับขี่ - มือใหม่");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        int age = Period.between(driver.getBirthDate(), LocalDate.now()).getYears();

        if (age > 50) {
            driver.setLicenseStatus("หมดอายุ");
        } else if (age < 16) {
            driver.setLicenseStatus("ถูกระงับ");
        }

        statusLabel = new JLabel("สถานะ: " + driver.getLicenseStatus());
        add(statusLabel);

        if (driver.getLicenseStatus().equals("ปกติ")) {
            writtenTestButton = new JButton("สอบข้อเขียน");
            practicalTestButton = new JButton("สอบปฏิบัติ");

            add(writtenTestButton);
            add(practicalTestButton);

            writtenTestButton.addActionListener(e -> {
                writtenTestDone = true;
                JOptionPane.showMessageDialog(this, "สิ้นสุดการสอบข้อเขียน");
                checkAllTestsDone();
            });

            practicalTestButton.addActionListener(e -> {
                practicalTestDone = true;
                JOptionPane.showMessageDialog(this, "สิ้นสุดการสอบปฏิบัติ");
                checkAllTestsDone();
            });
        }

        setVisible(true);
    }

    private void checkAllTestsDone() {
        if (writtenTestDone && practicalTestDone) {
            JOptionPane.showMessageDialog(this, "เปลี่ยนประเภทเป็นบุคคลทั่วไป");
            driver.setDriverType("บุคคลทั่วไป");
        }
    }
}
