import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class PublicDriverView extends JFrame {
    private JLabel statusLabel;
    private JLabel complaintsLabel;
    private JButton trainingButton;
    private JButton testButton;
    private int complaints;

    public PublicDriverView(Driver driver) {
        setTitle("ข้อมูลผู้ขับขี่ - คนขับรถสาธารณะ");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        int age = Period.between(driver.getBirthDate(), LocalDate.now()).getYears();

        if (age > 60) {
            driver.setLicenseStatus("หมดอายุ");
        } else if (age < 20) {
            driver.setLicenseStatus("ถูกระงับ");
        }

        complaints = 4;  // ฟิกค่า ไม่ใช้การสุ่ม

        statusLabel = new JLabel("สถานะ: " + driver.getLicenseStatus());
        complaintsLabel = new JLabel("จำนวนการร้องเรียน: " + complaints);
        add(statusLabel);
        add(complaintsLabel);

        if (driver.getLicenseStatus().equals("ปกติ") && complaints <= 5) {
            testButton = new JButton("ทดสอบสมรรถนะ");
            add(testButton);

            testButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "ทดสอบสมรรถนะเสร็จสิ้น");
            });
        } else if (complaints > 5) {
            trainingButton = new JButton("อบรม");
            add(trainingButton);

            trainingButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "สิ้นสุดการอบรม");
                driver.setLicenseStatus("ปกติ");
                statusLabel.setText("สถานะ: " + driver.getLicenseStatus());
            });
        }

        setVisible(true);
    }
}
