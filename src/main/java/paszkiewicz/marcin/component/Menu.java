package paszkiewicz.marcin.component;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

public class Menu
{
    private float x = 0;
    private float y = 0;
    private float space = 0;
    private List<MenuField> menuFields;
    private MenuFieldPointer menuFieldPointer;
    private int visibleFields = 0;

    public Menu()
    {
        menuFields = new ArrayList<MenuField>();
    }
    
    public void addField(MenuField menuField, int index)
    {
        menuFields.add(index, menuField);
        updatePosition();
    }

    public void setFieldVisibility(int index, boolean visibility)
    {
        if (menuFields.get(index).isVisible() ^ visibility)
        {
            visibleFields += visibility ? 1 : 0;
            menuFields.get(index).setVisibility(visibility);
        }
    }
    
    public void setX(float x)
    {
        this.x = x;
        updatePosition();
    }

    public void setY(float y)
    {
        this.y = y;
        updatePosition();
    }

    public float getSpace()
    {
        return space;
    }

    public void setSpace(float space)
    {
        this.space = space;
    }
    
    public MenuFieldPointer getFieldPointer()
    {
        return menuFieldPointer;
    }
    
    public void setFieldPointer(MenuFieldPointer menuFieldPointer)
    {
        this.menuFieldPointer = menuFieldPointer;
    }

    public int getWidth()
    {
        int maxFieldWidth = 0;

        for (MenuField field : menuFields)
        {
            if (field.isVisible() && field.getGraphic().getWidth() > maxFieldWidth)
            {
                maxFieldWidth = field.getGraphic().getWidth();
            }
        }

        return maxFieldWidth;
    }

    public int getHeight()
    {
        int height = 0;

        for (MenuField field : menuFields)
        {
            if (field.isVisible())
            {
                height += field.getGraphic().getHeight();
            }
        }
        height += (visibleFields - 1) * space;

        return height;
    }

    public void draw(Graphics graphics)
    {
        for (MenuField field : menuFields)
        {
            if (field.isVisible())
            {
                field.getGraphic().draw(graphics);
            }
        }

        if (menuFieldPointer != null)
        {
            menuFieldPointer.getGraphic().draw(graphics);
        }
    }

    public void nextChoice()
    {
        MenuField currentMenuField = menuFieldPointer.getCurrentChoice();

        int indexOfLastField = menuFields.size() - 1;
        for (int i = menuFields.indexOf(currentMenuField) + 1; i <= indexOfLastField; i++)
        {
            MenuField field = menuFields.get(i);
            if (field.isVisible())
            {
                menuFieldPointer.changeChoice(field);
                break;
            }
        }
    }

    public void previousChoice()
    {
        MenuField currentMenuField = menuFieldPointer.getCurrentChoice();

        int indexOfFirstField = 0;
        for (int i = menuFields.indexOf(currentMenuField) - 1; i >= indexOfFirstField; i--)
        {
            MenuField field = menuFields.get(i);
            if (field.isVisible())
            {
                menuFieldPointer.changeChoice(field);
                break;
            }
        }
    }

    public String getChoice()
    {
        return menuFieldPointer.getCurrentChoice().getName();
    }

    private void updatePosition()
    {
        int visibleFields = 0;
        float previousFieldY = 0;

        for (int i = 0; i < menuFields.size(); i++)
        {
            MenuField field = menuFields.get(i);
            if (field.isVisible())
            {
                if (visibleFields++ == 0)
                {
                    field.getGraphic().setX(x);
                    field.getGraphic().setY(y);
                    previousFieldY = field.getGraphic().getY();
                }
            }
        }

        for (int i = 0; i < menuFields.size(); i++)
        {
            MenuField field = menuFields.get(i);
            if (!field.isVisible())
            {
                continue;
            }

            field.getGraphic().setX(x);
            field.getGraphic().setY(previousFieldY + field.getGraphic().getHeight() + space);

            previousFieldY = field.getGraphic().getY();
        }

        if (menuFieldPointer != null)
        {
            menuFieldPointer.updatePosition();
        }
    }
}