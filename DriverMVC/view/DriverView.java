import javax.swing.*;
import java.awt.*;


public class DriverView {
    private JFrame frame;
    private JTextField licenseInput;

    public DriverView() {
        frame = new JFrame("Driver License Check System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter License Number: ");
        frame.add(label);

        licenseInput = new JTextField(15);
        frame.add(licenseInput);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String licenseNumber = licenseInput.getText();
            // ส่งหมายเลขใบขับขี่ไปยัง Controller
            DriverController controller = new DriverController(new DriverDatabase(), this);
            controller.checkDriver(licenseNumber);
        });

        frame.setVisible(true);
    }

    public void displayError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayDriverInfo(Driver driver) {
        // กำหนดฟอนต์ที่รองรับภาษาไทย
        UIManager.put("OptionPane.messageFont", new Font("Angsana New", Font.PLAIN, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Angsana New", Font.PLAIN, 16));
    
        // แสดงข้อมูลผู้ขับขี่ตามประเภท
        JOptionPane.showMessageDialog(frame, 
            "Driver Info: " + driver.getLicenseNumber() + "\nType: " + driver.getDriverType() + 
            "\nStatus: " + driver.getLicenseStatus(), 
            "Driver Info", JOptionPane.INFORMATION_MESSAGE);
    }
    

    public void displayReport(long generalDrivers, long newDrivers, long publicDrivers) {
        // กำหนดฟอนต์ที่รองรับภาษาไทย
        UIManager.put("OptionPane.messageFont", new Font("Angsana New", Font.PLAIN, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Angsana New", Font.PLAIN, 16));
    
        // แสดงรายงานจำนวผู้ขับขี่ในแต่ละประเภท
        JOptionPane.showMessageDialog(frame, 
            "รายงานจำนวผู้ขับขี่ในแต่ละประเภท:\n" +
            "บุคคลทั่วไป: " + generalDrivers + "\nมือใหม่: " + newDrivers + 
            "\nคนขับรถสาธารณะ: " + publicDrivers, 
            "Driver Report", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
