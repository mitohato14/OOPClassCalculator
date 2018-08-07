import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * CalculatorFrame
 */
class CalculatorFrame extends Frame implements ActionListener {
    Panel mainButtonPanel;
    JLabel label;
    GridBagLayout gridBagLayout;
    Button[] numButtons = new Button[11];
    OPButtons opButtons = new OPButtons();
    Boolean isSelectedOP = false;
    CalculatorValue calculatorValue = new CalculatorValue();

    CalculatorFrame() {
        initButton();
        initLabel();
        initPanel();

        setupMain();

        setTitle("Test");
        setSize(
                800,
                600
        );

        setLayout(new GridLayout(
                2,
                1
        ));

        setCalcLayout();


        addWindowListener(new CalculatorWindowAdapter());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Button clickButton = (Button) actionEvent.getSource();

        if (clickButton.getLabel() == "AC") {
            calculatorValue.init();
        }

        switch (clickButton.getLabel()) {
            case "0":
                addNum("0");
                return;
            case "00":
                addNum("-1");
                return;
            case "1":
                addNum("1");
                return;
            case "2":
                addNum("2");
                return;
            case "3":
                addNum("3");
                return;
            case "4":
                addNum("4");
                return;
            case "5":
                addNum("5");
                return;
            case "6":
                addNum("6");
                return;
            case "7":
                addNum("7");
                return;
            case "8":
                addNum("8");
                return;
            case "9":
                addNum("1");
                return;
        }

        calculatorValue.setOP(clickButton.getLabel());

    }

    private void changeSign() {
        if (isSelectedOP) {
            calculatorValue.changeValueSign(true);
        } else {
            calculatorValue.changeValueSign(false);
        }
    }

    private void addNum(String num) {
        if (isSelectedOP) {
            calculatorValue.addRightValue(Integer.parseInt(num));
        } else {
            calculatorValue.addLeftValue(Integer.parseInt(num));
        }
    }

    private void setCalcLayout() {
        add(label);
        add(mainButtonPanel);
    }

    private void setupMain() {
        mainButtonPanel.setLayout(new GridLayout(
                5,
                4
        ));

        mainButtonPanel.add(opButtons.getACButton());
        mainButtonPanel.add(opButtons.getChangeSignButton());
        mainButtonPanel.add(opButtons.getModButton());
        mainButtonPanel.add(opButtons.getDevideButton());

        mainButtonPanel.add(numButtons[7]);
        mainButtonPanel.add(numButtons[8]);
        mainButtonPanel.add(numButtons[9]);
        mainButtonPanel.add(opButtons.getTimeButton());

        mainButtonPanel.add(numButtons[4]);
        mainButtonPanel.add(numButtons[5]);
        mainButtonPanel.add(numButtons[6]);
        mainButtonPanel.add(opButtons.getSubButton());

        mainButtonPanel.add(numButtons[1]);
        mainButtonPanel.add(numButtons[2]);
        mainButtonPanel.add(numButtons[3]);
        mainButtonPanel.add(opButtons.getPlusButton());

        mainButtonPanel.add(numButtons[0]);
        mainButtonPanel.add(numButtons[10]);
        mainButtonPanel.add(opButtons.getDotButton());
        mainButtonPanel.add(opButtons.getEqualButton());
    }

    private void initButton() {
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button(String.valueOf(i));
        }
        numButtons[10] = new Button("00");

    }

    private void initLabel() {
        label = new JLabel("0");
        label.setPreferredSize(new Dimension(
                220,
                50
        ));
        label.setHorizontalAlignment(JLabel.TRAILING);
        label.setFont(new Font("Arial", Font.PLAIN, 48));

        LineBorder lineBorder = new LineBorder(
                Color.gray,
                1,
                false
        );

        label.setBorder(lineBorder);
    }

    private void initPanel() {
        mainButtonPanel = new Panel();
    }
}
