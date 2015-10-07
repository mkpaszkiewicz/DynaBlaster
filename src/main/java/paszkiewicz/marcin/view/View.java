package paszkiewicz.marcin.view;

import org.newdawn.slick.Graphics;

import paszkiewicz.marcin.model.Model;

public interface View
{
    void render(Model model, Graphics graphics);
}
