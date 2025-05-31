package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DexterBackgroundTest extends JFrame {
    private BufferedImage backgroundImage;
      public DexterBackgroundTest() {
        String[] imagePaths = {
            "asset/DEXRES.png",
            "asset/dexter.png"
        };

        for (String path : imagePaths) {
            try {
                File imageFile = new File(path);
                System.out.println("🔍 Trying: " + imageFile.getAbsolutePath());
                System.out.println("📁 File exists: " + imageFile.exists());

                if (imageFile.exists()) {
                    backgroundImage = ImageIO.read(imageFile);
                    if (backgroundImage != null) {
                        System.out.println("✅ SUCCESS: Image loaded from " + path);
                        System.out.println("📏 Size: " + backgroundImage.getWidth() + "x" + backgroundImage.getHeight());
                        break;
                    } else {
                        System.out.println("❌ FAILED: Could not read image data from " + path);
                    }
                } else {
                    System.out.println("❌ FAILED: File not found " + path);
                }
            } catch (IOException e) {
                System.out.println("❌ ERROR: " + path + " - " + e.getMessage());
            }
        }

        if (backgroundImage == null) {
            System.out.println("🔴 No background image loaded - will use red fallback");
        }

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {

                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {

                    g.setColor(new Color(139, 0, 0));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        mainPanel.setLayout(new BorderLayout());
        JLabel title = new JLabel("🔪 DEXTER BENCHMARK FRAMEWORK 🩸", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(title, BorderLayout.CENTER);

        add(mainPanel);
        setTitle("DEXTER Background Test");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DexterBackgroundTest().setVisible(true);
        });
    }
}
