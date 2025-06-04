package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class DexterBenchmarkGUI_ULTIMATE {

    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private static JTextArea dexresResultArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("DC Benchmarking Framework - DEXTER Performance Suite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel dexterPanel = createDexterPanel();

        JPanel resultsPanel = createResultsPanel();

        cardPanel.add(dexterPanel, "dexter");
        cardPanel.add(resultsPanel, "results");

        cardLayout.show(cardPanel, "dexter");

        frame.setContentPane(cardPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createDexterPanel() {
        JPanel dexterPanel = new JPanel() {
            private BufferedImage backgroundImage;
              {

                try {

                    File imageFile = new File("asset/dexter.png");
                    System.out.println("DEBUG: Loading DEXTER background from: " + imageFile.getAbsolutePath());
                    System.out.println("DEBUG: File exists: " + imageFile.exists());

                    if (imageFile.exists()) {
                        backgroundImage = ImageIO.read(imageFile);
                        if (backgroundImage != null) {
                            System.out.println(" SUCCESS: DEXTER background loaded! Dimensions: " +
                                             backgroundImage.getWidth() + "x" + backgroundImage.getHeight());
                        } else {
                            System.out.println(" FAILED: Could not read image data from file");
                        }
                    } else {
                        System.out.println(" FAILED: DEXTER image file not found");
                    }
                } catch (Exception e) {
                    System.out.println(" ERROR loading DEXTER background: " + e.getMessage());
                    backgroundImage = null;
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int width = getWidth();
                int height = getHeight();

                if (backgroundImage != null) {

                    g.drawImage(backgroundImage, 0, 0, width, height, this);
                    System.out.println("Drawing DEXTER background scaled to " + width + "x" + height);
                } else {

                    for (int y = 0; y < height; y++) {
                        float ratio = (float) y / height;

                        int red = (int) (120 + (135 * ratio));
                        int green = (int) (0 + (20 * ratio));
                        int blue = (int) (0 + (15 * ratio));
                        g.setColor(new Color(Math.min(255, red), Math.min(255, green), Math.min(255, blue)));
                        g.fillRect(0, y, width, 1);
                    }
                    System.out.println("Using fallback DEXTER red gradient background");
                }
            }
        };
        dexterPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("DEXTER BENCHMARKING FRAMEWORK - SELECT PERFORMANCE TEST", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 0, 0, 180));
        dexterPanel.add(titleLabel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);

        JPanel leftButtonContainer = new JPanel();
        leftButtonContainer.setOpaque(false);
        leftButtonContainer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 20, 8, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;        String[] benchmarks = {
            "Demo Benchmark (Array Processing)",
            "Digits of Pi (Mathematical Precision)",
            "Fixed Point Arithmetic (MOPS)",
            "Recursion and Caching Performance",
            "Hard Disk Write Speed (MB/s)",
            "Hard Disk Random Access (IOPS)",
            "Virtual Memory Performance (MB/s)"
        };

        for (int i = 0; i < benchmarks.length; i++) {
            String benchmark = benchmarks[i];

            JButton button = new JButton(benchmark);
            button.setFont(new Font("Arial", Font.BOLD, 14));

            button.setBackground(new Color(139, 0, 0));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(true);

            button.setPreferredSize(new Dimension(320, 45));
            button.setMaximumSize(new Dimension(320, 45));
            button.setMinimumSize(new Dimension(320, 45));

            Color originalBg = button.getBackground();
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(new Color(178, 34, 34));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(originalBg);
                }
            });
              button.addActionListener(new BenchmarkActionListener(benchmark));
            gbc.gridy++;
            leftButtonContainer.add(button, gbc);
        }

        buttonPanel.add(leftButtonContainer, BorderLayout.WEST);

        dexterPanel.add(buttonPanel, BorderLayout.CENTER);        JTextArea infoArea = new JTextArea("DEXTER PERFORMANCE SUITE\n" +
                                           "Click any benchmark to run real performance tests!\n" +
                                           "Results will show numerical data with timing, throughput, and accuracy metrics.\n" +
                                           "Tonight's the night... for benchmarking!");
        infoArea.setFont(new Font("Arial", Font.BOLD, 14));
        infoArea.setEditable(false);
        infoArea.setOpaque(true);
        infoArea.setForeground(Color.YELLOW);
        infoArea.setBackground(new Color(0, 0, 0, 200));
        infoArea.setRows(4);
        dexterPanel.add(infoArea, BorderLayout.SOUTH);

        return dexterPanel;
    }

    private static JPanel createResultsPanel() {
        JPanel resultsPanel = new JPanel() {
            private BufferedImage backgroundImage;
              {

                try {
                    File imageFile = new File("asset/dexter.png");
                    if (imageFile.exists()) {
                        backgroundImage = ImageIO.read(imageFile);
                        System.out.println(" Results panel: DEXTER background loaded successfully");
                    }
                } catch (Exception e) {
                    System.out.println(" Results panel: Error loading background - " + e.getMessage());
                    backgroundImage = null;
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int width = getWidth();
                int height = getHeight();

                if (backgroundImage != null) {

                    g.drawImage(backgroundImage, 0, 0, width, height, this);
                } else {

                    for (int y = 0; y < height; y++) {
                        float ratio = (float) y / height;
                        int red = (int) (120 + (135 * ratio));
                        int green = (int) (0 + (20 * ratio));
                        int blue = (int) (0 + (15 * ratio));
                        g.setColor(new Color(Math.min(255, red), Math.min(255, green), Math.min(255, blue)));
                        g.fillRect(0, y, width, 1);
                    }
                }
            }
        };
        resultsPanel.setLayout(new BorderLayout());

        JLabel resultsTitle = new JLabel("DEXTER PERFORMANCE ANALYSIS - BENCHMARK RESULTS", JLabel.CENTER);
        resultsTitle.setFont(new Font("Arial", Font.BOLD, 22));
        resultsTitle.setForeground(Color.YELLOW);
        resultsTitle.setOpaque(true);
        resultsTitle.setBackground(new Color(0, 0, 0, 180));
        resultsPanel.add(resultsTitle, BorderLayout.NORTH);        dexresResultArea = new JTextArea("DEXTER BENCHMARK RESULTS\n\n" +
                                         "Performance data will appear here...\n\n" +
                                         "Click a benchmark from the main panel to see detailed\n" +
                                         "numerical performance metrics, timing data, and analysis.\n\n" +
                                         "Every kill tells a story... every benchmark tells performance!");
        dexresResultArea.setFont(new Font("Courier New", Font.BOLD, 13));
        dexresResultArea.setEditable(false);
        dexresResultArea.setOpaque(true);
        dexresResultArea.setForeground(Color.GREEN);
        dexresResultArea.setBackground(new Color(0, 0, 0, 200));
        dexresResultArea.setRows(20);

        JScrollPane scrollPane = new JScrollPane(dexresResultArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        resultsPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel backPanel = new JPanel();
        backPanel.setOpaque(false);
        JButton backButton = new JButton("BACK TO DEXTER - RUN MORE BENCHMARKS");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(255, 140, 0));
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(400, 45));
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "dexter"));
        backPanel.add(backButton);
        resultsPanel.add(backPanel, BorderLayout.SOUTH);

        return resultsPanel;
    }

    static class BenchmarkActionListener implements ActionListener {
        private final String benchmark;

        public BenchmarkActionListener(String benchmark) {
            this.benchmark = benchmark;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            cardLayout.show(cardPanel, "results");            dexresResultArea.setText("Running " + benchmark + "...\n" +
                                   "Please wait while DEXTER analyzes performance...\n" +
                                   "Computing numerical results...\n" +
                                   " Tonight's the night for benchmarking... ");

            SwingUtilities.invokeLater(() -> {
                String result = runBenchmark(benchmark);
                dexresResultArea.setText(result);
            });
        }

        private String runBenchmark(String benchmarkName) {
            DecimalFormat df = new DecimalFormat("#,###.##");
            StringBuilder results = new StringBuilder();
            results.append("================================================================================\n");
            results.append("      DEXTER BENCHMARKING FRAMEWORK - PERFORMANCE RESULTS      \n");
            results.append("================================================================================\n\n");            results.append("Benchmark: ").append(benchmarkName).append("\n");
            results.append("Timestamp: ").append(new java.util.Date()).append("\n");
            results.append("System: Java Benchmarking Framework\n");
            results.append("\"Tonight's the night for performance analysis!\"\n\n");

            try {
                if (benchmarkName.contains("Demo Benchmark")) {
                    results.append(runDemoBenchmark(df));
                } else if (benchmarkName.contains("Digits of Pi")) {
                    results.append(runPiBenchmark(df));
                } else if (benchmarkName.contains("Fixed Point")) {
                    results.append(runFixedPointBenchmark(df));
                } else if (benchmarkName.contains("Recursion")) {
                    results.append(runRecursionBenchmark(df));
                } else if (benchmarkName.contains("Write Speed")) {
                    results.append(runHDDWriteBenchmark(df));
                } else if (benchmarkName.contains("Random Access")) {
                    results.append(runHDDRandomBenchmark(df));
                } else if (benchmarkName.contains("Virtual Memory")) {
                    results.append(runVirtualMemoryBenchmark(df));
                }
            } catch (Exception ex) {
                results.append(" ERROR: ").append(ex.getMessage()).append("\n");
            }

            
            results.append(" Benchmark Complete! Click 'BACK TO DEXTER' for more tests\n");
            results.append(" \"Every benchmark reveals the truth about performance...\"\n");
            

            return results.toString();
        }

        private String runDemoBenchmark(DecimalFormat df) {
            long startTime = System.nanoTime();

            int workload = 2_000_000;
            int[] data = new int[workload];
            Random random = new Random();
            for (int i = 0; i < workload; i++) {
                data[i] = random.nextInt(1000);
            }

            long sum = 0;
            for (int i = 0; i < data.length; i++) {
                sum += data[i] * data[i];
            }

            long endTime = System.nanoTime();
            double timeMs = (endTime - startTime) / 1_000_000.0;
            double timeS = timeMs / 1000.0;
            double throughput = workload / timeS;

            return "DEMO BENCHMARK - ARRAY PROCESSING:\n" +
                   "════════════════════════════════════════\n" +
                   "Workload size: " + df.format(workload) + " elements\n" +
                   "Sum of squares: " + df.format(sum) + "\n" +
                   "Execution time: " + df.format(timeMs) + " ms\n" +
                   "Throughput: " + df.format(throughput) + " elements/sec\n" +
                   "Memory used: " + df.format(workload * 4 / 1024.0) + " KB\n" +
                   "Performance Score: " + df.format(throughput / 1000.0) + " K-ops/sec\n" +
                   " \"Clean and efficient, just like a perfect kill.\"\n\n";
        }

        private String runPiBenchmark(DecimalFormat df) {
            long startTime = System.nanoTime();

            int iterations = 25_000_000;
            double pi = 0.0;
            for (int i = 0; i < iterations; i++) {
                pi += Math.pow(-1, i) / (2 * i + 1);
            }
            pi *= 4;

            long endTime = System.nanoTime();
            double timeMs = (endTime - startTime) / 1_000_000.0;
            double accuracy = Math.abs(Math.PI - pi);
            int correctDigits = (int) Math.max(0, -Math.log10(accuracy));

            return "DIGITS OF PI - MATHEMATICAL PRECISION:\n" +
                   "═══════════════════════════════════════════\n" +
                   "Method: Leibniz infinite series\n" +
                   "Iterations: " + df.format(iterations) + "\n" +
                   "Calculated Pi: " + String.format("%.12f", pi) + "\n" +
                   "Actual Pi:     " + String.format("%.12f", Math.PI) + "\n" +
                   "Accuracy error: " + String.format("%.2e", accuracy) + "\n" +
                   "Correct digits: " + correctDigits + "\n" +
                   "Execution time: " + df.format(timeMs) + " ms\n" +
                   "Iterations/sec: " + df.format(iterations / (timeMs / 1000.0)) + "\n" +
                   " \"Mathematical precision, surgical precision.\"\n\n";
        }

        private String runFixedPointBenchmark(DecimalFormat df) {
            long startTime = System.nanoTime();

            int iterations = 75_000_000;
            long result = 0;

            for (int i = 0; i < iterations; i++) {
                int a = i % 1000;
                int b = (i + 1) % 1000;
                result += a + b;
                result *= 2;
                result /= 3;
                result = result % 100;
                result ^= a;
                result = result << 1;
                result = result >> 1;
            }

            long endTime = System.nanoTime();
            double timeS = (endTime - startTime) / 1_000_000_000.0;
            double totalOps = iterations * 11.0;
            double mops = (totalOps / timeS) / 1_000_000.0;            return "FIXED POINT ARITHMETIC - MOPS PERFORMANCE:\n" +
                   "═══════════════════════════════════════════════\n" +
                   "Total operations: " + df.format(totalOps) + "\n" +
                   "Execution time: " + df.format(timeS) + " seconds\n" +
                   "Performance: " + df.format(mops) + " MOPS\n" +
                   "Final result: " + df.format(result) + "\n" +
                   "Ops per iteration: 11 (add, mult, div, mod, xor, shifts)\n" +
                   "CPU Efficiency: " + df.format(mops * 100 / 1000) + "%\n" +
                   " \"Every operation calculated with deadly precision.\"\n\n";
        }

        private String runRecursionBenchmark(DecimalFormat df) {
            long startTime = System.nanoTime();

            int n = 50;
            long fibResult = fibonacciIterative(n);

            long endTime = System.nanoTime();
            double timeMs = (endTime - startTime) / 1_000_000.0;

            int primes = countPrimesIterative(10000);            return "RECURSION & CACHING - PERFORMANCE TEST:\n" +
                   "═════════════════════════════════════════════\n" +
                   "Fibonacci(" + n + ") = " + df.format(fibResult) + "\n" +
                   "Primes up to 10,000: " + df.format(primes) + "\n" +
                   "Method: Optimized iterative (cache-friendly)\n" +
                   "Execution time: " + df.format(timeMs) + " ms\n" +
                   "Performance score: " + df.format((fibResult + primes) / timeMs) + " ops/ms\n" +
                   "Stack efficiency: Optimized (no overflow risk)\n" +
                   "Algorithm complexity: O(n) linear time\n" +
                   " \"Recursive patterns, like the Code of Harry.\"\n\n";
        }

        private String runHDDWriteBenchmark(DecimalFormat df) {
            try {

                File tempFile = new File("dexter_benchmark_write.dat");
                byte[] buffer = new byte[4096];
                new Random().nextBytes(buffer);

                long startTime = System.nanoTime();

                int fileSizeMB = 25;
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    for (int i = 0; i < fileSizeMB * 256; i++) {
                        fos.write(buffer);
                    }
                    fos.flush();
                }

                long endTime = System.nanoTime();
                double timeS = (endTime - startTime) / 1_000_000_000.0;
                double mbps = fileSizeMB / timeS;

                long actualSize = tempFile.length();

                tempFile.delete();                return "HARD DISK WRITE SPEED - I/O PERFORMANCE:\n" +
                       "═══════════════════════════════════════════════\n" +
                       "File size: " + df.format(fileSizeMB) + " MB\n" +
                       "Buffer size: 4 KB (optimized)\n" +
                       "Bytes written: " + df.format(actualSize) + " bytes\n" +
                       "Write time: " + df.format(timeS) + " seconds\n" +
                       "Write speed: " + df.format(mbps) + " MB/s\n" +
                       "Throughput: " + df.format(fileSizeMB * 1024 / timeS) + " KB/s\n" +
                       "Disk Performance: " + (mbps > 100 ? "Excellent" : mbps > 50 ? "Good" : "Standard") + "\n" +
                       " \"Writing data with the precision of a scalpel.\"\n\n";

            } catch (Exception e) {
                return " HDD Write Benchmark ERROR: " + e.getMessage() + "\n\n";
            }
        }

        private String runHDDRandomBenchmark(DecimalFormat df) {
            try {

                File tempFile = new File("dexter_benchmark_random.dat");
                int fileSizeMB = 100;
                byte[] buffer = new byte[4096];

                try (RandomAccessFile raf = new RandomAccessFile(tempFile, "rw")) {
                    for (int i = 0; i < fileSizeMB * 256; i++) {
                        raf.write(buffer);
                    }
                }

                Random random = new Random();
                int operations = 2500;
                long startTime = System.nanoTime();

                try (RandomAccessFile raf = new RandomAccessFile(tempFile, "r")) {
                    long fileSize = raf.length();
                    for (int i = 0; i < operations; i++) {
                        long pos = Math.abs(random.nextLong()) % (fileSize - buffer.length);
                        raf.seek(pos);
                        raf.read(buffer);
                    }
                }

                long endTime = System.nanoTime();
                double timeS = (endTime - startTime) / 1_000_000_000.0;
                double iops = operations / timeS;
                double mbps = (operations * buffer.length) / (timeS * 1024 * 1024);

                tempFile.delete();                return "HARD DISK RANDOM ACCESS - IOPS PERFORMANCE:\n" +
                       "═══════════════════════════════════════════════════\n" +
                       "File size: " + df.format(fileSizeMB) + " MB\n" +
                       "Buffer size: 4 KB per operation\n" +
                       "Random operations: " + df.format(operations) + "\n" +
                       "Test time: " + df.format(timeS) + " seconds\n" +
                       "Random IOPS: " + df.format(iops) + " operations/sec\n" +
                       "Read speed: " + df.format(mbps) + " MB/s\n" +
                       "Storage Type: " + (iops > 1000 ? "SSD-class" : "HDD-class") + " performance\n" +
                       " \"Random access patterns, unpredictable like prey.\"\n\n";

            } catch (Exception e) {
                return " HDD Random Access Benchmark ERROR: " + e.getMessage() + "\n\n";
            }
        }

        private String runVirtualMemoryBenchmark(DecimalFormat df) {
            try {

                int arraySize = 50_000_000;
                long startTime = System.nanoTime();

                int[] largeArray = new int[arraySize];

                for (int i = 0; i < arraySize; i++) {
                    largeArray[i] = i % 10000;
                }

                long sum = 0;
                for (int i = 0; i < arraySize; i++) {
                    sum += largeArray[i] * 2;
                }

                long endTime = System.nanoTime();
                double timeS = (endTime - startTime) / 1_000_000_000.0;
                double memoryMB = (arraySize * 4) / (1024.0 * 1024.0);
                double mbps = memoryMB / timeS;

                double totalMB = memoryMB * 2;
                double totalThroughput = totalMB / timeS;

                largeArray = null;
                System.gc();                return "VIRTUAL MEMORY - MEMORY PERFORMANCE:\n" +
                       "═══════════════════════════════════════════\n" +
                       "Array size: " + df.format(arraySize) + " integers\n" +
                       "Memory allocated: " + df.format(memoryMB) + " MB\n" +
                       "Operations: Write + Read + Compute\n" +
                       "Execution time: " + df.format(timeS) + " seconds\n" +
                       "Memory speed: " + df.format(mbps) + " MB/s\n" +
                       "Total throughput: " + df.format(totalThroughput) + " MB/s\n" +
                       "Checksum: " + df.format(sum) + "\n" +
                       "RAM Performance: " + (totalThroughput > 1000 ? "Excellent" : "Good") + "\n" +
                       " \"Memory flows like blood through the system.\"\n\n";

            } catch (Exception e) {
                return " Virtual Memory Benchmark ERROR: " + e.getMessage() + "\n\n";
            }
        }

        private long fibonacciIterative(int n) {
            if (n <= 1) return n;
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }

        private int countPrimesIterative(int limit) {
            if (limit < 2) return 0;
            boolean[] isPrime = new boolean[limit + 1];
            for (int i = 2; i <= limit; i++) {
                isPrime[i] = true;
            }

            for (int i = 2; i * i <= limit; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= limit; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            int count = 0;
            for (int i = 2; i <= limit; i++) {
                if (isPrime[i]) count++;
            }
            return count;
        }
    }
}
