package API;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyButtonUI extends BasicButtonUI
{
    public void installUI ( JComponent c )
    {
        // ����������� ��������� ��������� UI, ������������� � Basic UI ������
        super.installUI ( c );

        // ������������� �������� ��������� JButton'�
        // ��� ���������� ���������� AbstractButton, ��� ��� � �� ���� �� ����������� ���
        AbstractButton button = ( AbstractButton ) c;
        button.setOpaque ( false );
        button.setFocusable ( true );
        button.setMargin ( new Insets ( 0, 0, 0, 0 ) );
        button.setBorder ( BorderFactory.createEmptyBorder ( 4, 4, 4, 4 ) );
    }

    public void paint ( Graphics g, JComponent c )
    {
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        AbstractButton button = ( AbstractButton ) c;
        ButtonModel buttonModel = button.getModel ();

        // ������ ������ ����� ����������� �������������

        // ��� ������
        g2d.setPaint ( new GradientPaint ( 0, 0, Color.WHITE, 0, c.getHeight (),
                new Color ( 200, 200, 200 ) ) );
        // ������������ ���������� ������ ������, ��� ��� ��������� �����,
        // ����� ������� ��� ����� ������������ �� �����
        g2d.fillRoundRect ( 0, 0, c.getWidth (), c.getHeight (), 8, 8 );

        // ������ ������
        g2d.setPaint ( Color.GRAY );
        // ����� �������, ��� ����� ���������� ������ �� 1px ������, ��� ������/������ ����������,
        // ����� ������ � ������ ���� ������ ������� �� ������� ���������� � �� ����� �����
        // � ������� ��� �� ���������, ��� ��� ��������� �������/������ �������� ������������ ��� ����������
        g2d.drawRoundRect ( 0, 0, c.getWidth () - 1, c.getHeight () - 1, 6, 6 );

        // ����� ��������� ��� ������� ������
        if ( buttonModel.isPressed () )
        {
            g2d.translate ( 1, 1 );
        }

        // ��������� ������ � ������ �����������
        super.paint ( g, c );
    }
    public static ComponentUI createUI ( JComponent c )
    {
        // ������ ������� ������ UI
        return new MyButtonUI ();
    }
}