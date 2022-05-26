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
        // Обязательно оставляем установку UI, реализованную в Basic UI классе
        super.installUI ( c );

        // Устанавливаем желаемые настройки JButton'а
        // Для абстракции используем AbstractButton, так как в нём есть всё необходимое нам
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

        // Формой кнопки будет закруглённый прямоугольник

        // Фон кнопки
        g2d.setPaint ( new GradientPaint ( 0, 0, Color.WHITE, 0, c.getHeight (),
                new Color ( 200, 200, 200 ) ) );
        // Закгругление необходимо делать больше, чем при отрисовке формы,
        // иначе светлый фон будет просвечивать по краям
        g2d.fillRoundRect ( 0, 0, c.getWidth (), c.getHeight (), 8, 8 );

        // Бордер кнопки
        g2d.setPaint ( Color.GRAY );
        // Важно помнить, что форму необходимо делать на 1px меньше, чем ширина/высота компонента,
        // иначе правый и нижний края фигуры вылезут за границу компонента и не будут видны
        // К заливке это не относится, так как последняя колонка/строка пикселей игнорируется при заполнении
        g2d.drawRoundRect ( 0, 0, c.getWidth () - 1, c.getHeight () - 1, 6, 6 );

        // Сдвиг отрисовки при нажатой кнопке
        if ( buttonModel.isPressed () )
        {
            g2d.translate ( 1, 1 );
        }

        // Отрисовка текста и иконки изображения
        super.paint ( g, c );
    }
    public static ComponentUI createUI ( JComponent c )
    {
        // Создаём инстанс нашего UI
        return new MyButtonUI ();
    }
}