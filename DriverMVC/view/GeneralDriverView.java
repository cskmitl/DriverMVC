import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class GeneralDriverView extends JFrame {
    private JLabel statusLabel;
    private JButton testButton;

    public GeneralDriverView(Driver driver) {
        setTitle("ข้อมูลผู้ขับขี่ - บุคคลทั่วไป");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        int age = Period.between(driver.getBirthDate(), LocalDate.now()).getYears();

        if (age > 70) {
            driver.setLicenseStatus("หมดอายุ");
        } else if (age < 16) {
            driver.setLicenseStatus("ถูกระงับ");
        }

        statusLabel = new JLabel("สถานะ: " + driver.getLicenseStatus());
        add(statusLabel);

        if (driver.getLicenseStatus().equals("ปกติ")) {
            testButton = new JButton("ทดสอบสมรรถนะ");
            add(testButton);

            testButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "ทดสอบสมรรถนะเสร็จสิ้น");
            });
        }

        setVisible(true);
    }
}
