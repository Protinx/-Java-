import java.awt.*;
import javax.swing.*;

public class AutoScore extends JFrame {
    public AutoScore() {
        init();
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void init() {
        setLayout(null);
        setSize(400, 350);
        btnNew.setText("出题");
        getContentPane().add(btnNew);
        btnNew.setBounds(36, 96, 98, 26);
        btnJudge.setText("判分");
        getContentPane().add(btnJudge);
        btnJudge.setBounds(216, 96, 94, 25);
        lblA.setText("text");
        getContentPane().add(lblA);
        lblA.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblA.setBounds(36, 24, 36, 36);
        lblOp.setText("text");
        getContentPane().add(lblOp);
        lblOp.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblOp.setBounds(72, 24, 36, 36);
        lblB.setText("text");
        getContentPane().add(lblB);
        lblB.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblB.setBounds(108, 24, 33, 36);
        lblEq.setText("=");
        getContentPane().add(lblEq);
        lblEq.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblEq.setBounds(168, 24, 24, 36);
        getContentPane().add(txtAnswer);
        txtAnswer.setFont(new Font("Dialog", Font.PLAIN, 24));
        txtAnswer.setBounds(216, 24, 85, 42);
        lstHistory.setFont(new Font("Dialog", Font.PLAIN, 16));
        getContentPane().add(lstHistory);
        lstHistory.setBounds(36, 144, 272, 196);
        btnNew.addActionListener(e -> btnNew_ActionPerformed(e));
        btnJudge.addActionListener(e -> btnJudge_ActionPerformed(e));

    }

    JButton btnNew = new JButton();
    JButton btnJudge = new JButton();
    JLabel lblA = new JLabel();
    JLabel lblOp = new JLabel();
    JLabel lblB = new JLabel();
    JLabel lblEq = new JLabel();
    JTextField txtAnswer = new JTextField();
    DefaultListModel<String> history = new DefaultListModel<>();
    JList<String> lstHistory = new JList<>(history);

    void btnNew_ActionPerformed(java.awt.event.ActionEvent event) {
        a = (int) (Math.random() * 9 + 1);
        b = (int) (Math.random() * 9 + 1);
        int c = (int) (Math.random() * 4);
        switch (c) {
            case 0:
                op = "+";
                result = a + b;
                break;
            case 1:
                op = "-";
                result = a - b;
                break;
            case 2:
                op = "*";
                result = a * b;
                break;
            case 3:
                op = "/";
                result = a / b;
                break;
        }
        lblA.setText("" + a);
        lblB.setText("" + b);
        lblOp.setText("" + op);
        txtAnswer.setText("");
    }

    int a = 0, b = 0;
    String op = "";
    double result = 0;

    void btnJudge_ActionPerformed(java.awt.event.ActionEvent event) {
        String str = txtAnswer.getText();
        double d = Double.valueOf(str).doubleValue();
        String info = " " + a + op + b + "=" + str + " ";
        if (d == result) {
            info += "yes";

        } else {
            info += "no";

        }
        history.addElement(info);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AutoScore();

        });
    }

}
